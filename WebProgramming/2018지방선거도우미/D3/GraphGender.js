﻿function dashboardG(file) {
    d3.json(file, function (err, data) {
        if (err)
            console.log("data access error");
        //console.log(data);
        G_dataViz(data.gender);
    });

    function G_dataViz(incomingData) {
        var barColor = 'steelblue';
        function segColor(c) { return { man: "#807dba", woman: "#e08214" }[c]; }
        function partyColor(c) { return { 1: "Royalblue", 2: "crimson", 3: "Highlight", 4: "gold", 5: "gray" }[c] };
        var sum = 0;
        var i = 0;

        incomingData.forEach(function (d) {
            d.total = d.freq.man + d.freq.woman;
            sum += d.total;
        });

        //calculate total frequency by segment for all candidate.
        var tF = ['man', 'woman'].map(function (d) {
            return { type: d, freq: d3.sum(incomingData.map(function (t) { return t.freq[d]; })) };
        });


        var sF = incomingData.map(function (d) { return [d.candidate, d.total]; });

        function histoGram(fD) {
            // function to handle histogram.
            var hG = {};
            var hGDim = { t: 60, r: 0, b: 30, l: 0 };
            hGDim.width = 500 - hGDim.l - hGDim.r,
                hGDim.height = 300 - hGDim.t - hGDim.b;

            //히스토그램 svg 생성
            var hGsvg = d3.select("#dashboardG")
                .append("svg")
                .attr("width", hGDim.width + hGDim.l + hGDim.r)
                .attr("height", hGDim.height + hGDim.t + hGDim.b)
                .attr("class", "G_HGsvg")
                .append("g")
                .attr("transform", "translate(" + hGDim.l + "," + hGDim.t + ")");

            // 히스토그램 x축 line domain 범위 설정
            var x = d3.scale.ordinal()
                .rangeRoundBands([0, hGDim.width], 0.1)
                .domain(fD.map(function (d) { return d[0]; }));


            // Add x-axis to the histogram svg.
            hGsvg.append("g")
                .attr("class", "G_x axis")
                .attr("transform", "translate(0," + hGDim.height + ")")
                .call(d3.svg.axis().scale(x).orient("bottom"));


            // Create function for y-axis map.
            // 히스토그램 y축 범위 설정
            var y = d3.scale.linear().range([hGDim.height, 0])
                .domain([0, d3.max(fD, function (d) { return d[1]; })]);


            // 막대그래프 생성
            var bars = hGsvg
                .selectAll(".Gbar")
                .data(fD)
                .enter()
                .append("g")
                .attr("class", "Gbar");


            //rect 생성
            bars.append("rect")
                .attr("x", function (d) { return x(d[0]); })
                .attr("y", function (d) { return y(d[1]); })
                .attr("width", x.rangeBand())
                .attr("height", function (d) { return hGDim.height - y(d[1]); })
                .attr('fill', function (d, i) { return partyColor(i + 1); })
                .on("mouseover", mouseover)// mouseover is defined below.
                .on("mouseout", mouseout);// mouseout is defined below.

            //Create the frequency labels above the rectangles.
            bars.append("text")
                .text(function (d) {
                    return (d[1] / sum * 100).toFixed(1);
                    //return d3.format(",")(d[1]);
                })
                .attr("x", function (d) { return x(d[0]) + x.rangeBand() / 2; })
                .attr("y", function (d) { return y(d[1]) - 5; })
                .attr("text-anchor", "middle")
                .attr("class", "G_barText")
                .attr("font-size", "20px");

            function mouseover(d) {  // utility function to be called on mouseover.
                // filter for selected candidate.
                var st = incomingData
                    .filter(function (s) {
                        return s.candidate == d[0];
                    })[0],
                    nD = d3.keys(st.freq)
                        .map(function (s) { return { type: s, freq: st.freq[s] }; });



                // call update functions of pie-chart and legend.
                pC.update(nD);
                leg.update(nD);
            }


            function mouseout(d) {    // utility function to be called on mouseout.
                // reset the pie-chart and legend.
                pC.update(tF);
                leg.update(tF);
            }


            // create function to update the bars. This will be used by pie-chart.
            hG.update = function (nD, color, tF) {
                // update the domain of the y-axis map to reflect change in frequencies.
                y.domain([0, d3.max(nD, function (d) { return d[1]; })]);

                // Attach the new data to the bars.
                var bars = hGsvg
                    .selectAll(".Gbar")
                    .data(nD);

                // transition the height and color of rectangles.
                bars.select("rect")
                    .transition().duration(500)
                    .attr("y", function (d) { return y(d[1]); })
                    .attr("height", function (d) { return hGDim.height - y(d[1]); })
                    .attr('fill', function (d, i) { return partyColor(i + 1); });

                // transition the frequency labels location and change value.
                bars.select(".G_barText")
                    .transition().duration(500)
                    .text(function (d) {
                        return (d[1] / tF * 100).toFixed(1);
                        //return d3.format(",")(d[1])
                    })
                    .attr("y", function (d) { return y(d[1]) - 5; });
            }
            return hG;
        }

        // function to handle pieChart.
        function pieChart(pD) {
            var pC = {};
            var pieDim = { w: 200, h: 200 };
            pieDim.r = Math.min(pieDim.w, pieDim.h) / 2;

            // create svg for pie chart.
            var piesvg = d3.select("#dashboardG")
                .append("svg")
                .attr("width", pieDim.w)
                .attr("height", pieDim.h)
                .attr("class", "G_PCsvg")
                .append("g")
                .attr("transform", "translate(" + pieDim.w / 2 + "," + pieDim.h / 2 + ")");

            // create function to draw the arcs of the pie slices.
            var arc = d3.svg.arc()
                .outerRadius(pieDim.r - 10)
                .innerRadius(10);

            // create a function to compute the pie slice angles.
            var pie = d3.layout.pie()
                .sort(null)
                .value(function (d) { return d.freq; });

            // Draw the pie slices.
            piesvg.selectAll("path")
                .data(pie(pD))
                .enter()
                .append("path")
                .attr("d", arc)
                .each(function (d) { this._current = d; })
                .style("fill", function (d) { return segColor(d.data.type); })
                .on("mouseover", mouseover)
                .on("mouseout", mouseout);

            // 파이차트 업데이트
            pC.update = function (nD) {

                piesvg.selectAll("path")
                    .data(pie(nD))
                    .transition().duration(500)
                    .attrTween("d", arcTween);
            }

            // Utility function to be called on mouseover a pie slice.
            function mouseover(d) {
                // call the update function of histogram with new data.
                hG.update(incomingData.map(function (v) { 
                    return [v.candidate, v.freq[d.data.type]];
                }), segColor(d.data.type),d.data.freq);
            }


            //Utility function to be called on mouseout a pie slice.
            function mouseout(d) {
                // call the update function of histogram with all data.
                hG.update(incomingData.map(function (v) {
                    return [v.candidate, v.total];
                }), barColor,sum);
            }


            // Animating the pie-slice requiring a custom function which specifies
            // how the intermediate paths should be drawn.
            function arcTween(a) {
                var i = d3.interpolate(this._current, a);
                this._current = i(0);
                return function (t) { return arc(i(t)); };
            }
            return pC;
        }


        // function to handle legend.
        function legend(lD) {
            var leg = {};

            // create table for legend.
            var legend = d3.select("#dashboardG")
                .append("table")
                .attr('class', 'G_legend');

            // create one row per segment.
            var tr = legend.append("tbody")
                .selectAll("tr")
                .data(lD)
                .enter()
                .append("tr");

            // create the first column for each segment.
            tr.append("td")
                .append("svg")
                .attr("width", '8')
                .attr("height", '8')
                .append("rect")
                .attr("width", '8')
                .attr("height", '8')
                .attr("fill", function (d) { return segColor(d.type); });

            // create the second column for each segment.
            tr.append("td").text(function (d) {
                switch (d.type) {
                    case "man":
                        return "남자 : ";
                    case "woman":
                        return "여자 : ";
                }
            }).style("font-size", "15px")
                .attr("class", "G_columnText");

            // create the third column for each segment.
            tr.append("td")
                .attr("class", 'G_legendFreq')
                .text(function (d) { return d3.format(",")(d.freq); })
                .style("font-size", "15px");

            // create the fourth column for each segment.
            tr.append("td")
                .attr("class", 'G_legendPerc')
                .text(function (d) { return getLegend(d, lD); })
                .style("font-size", "15px");

            // Utility function to be used to update the legend.
            leg.update = function (nD) {
                // update the data attached to the row elements.
                var l = legend.select("tbody")
                    .selectAll("tr")
                    .data(nD);

                // update the frequencies.
                l.select(".G_legendFreq")
                    .text(function (d) { return d3.format(",")(d.freq); })
                    .style("font-size", "15px");

                // update the percentage column.
                l.select(".G_legendPerc")
                    .text(function (d) { return getLegend(d, nD); })
                    .style("font-size", "15px")
            }

            function getLegend(d, aD) { // Utility function to compute percentage.
                return d3.format("%")(d.freq / d3.sum(aD.map(function (v) { return v.freq; })));
            }

            return leg;
        }


        var hG = histoGram(sF), // create the histogram.
            pC = pieChart(tF), // create the pie-chart.
            leg = legend(tF);  // create the legend.

    }
}
