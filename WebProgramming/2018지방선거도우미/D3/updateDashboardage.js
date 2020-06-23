function updatedashboardA(file) {
    d3.json(file, function (err, data) {
        if (err)
            console.log("data access error");
        //console.log(data);
        dataViz(data.age);
    });

    function dataViz(incomingData) {
        var barColor = 'steelblue';
        function segColor(c) { return { twenty: "#e6f5f7", thirty: "#9fe3dd", fourty: "#51bfb5", fifty: "#11625b", sixty: "#004843" }[c]; }
        function partyColor(c) { return { 1: "Royalblue", 2: "crimson", 3: "Highlight", 4: "gold", 5: "gray" }[c]; }
        var sum = 0;

        incomingData.forEach(function (d) {
            d.total = d.freq.twenty + d.freq.thirty + d.freq.fourty + d.freq.fifty + d.freq.sixty;
            sum += d.total;
        });

        //calculate total frequency by segment for all candidate.
        var tF = ['twenty', 'thirty', 'fourty', 'fifty', 'sixty'].map(function (d) {
            return { type: d, freq: d3.sum(incomingData.map(function (t) { return t.freq[d]; })) };
        });


        var sF = incomingData.map(function (d) { return [d.candidate, d.total]; });

        function histoGram(fD) {
            // function to handle histogram.
            var hG = {};
            var hGDim = { t: 60, r: 0, b: 30, l: 0 };
            hGDim.width = (400 - hGDim.l - hGDim.r),
                hGDim.height = (250 - hGDim.t - hGDim.b);

            //히스토그램 svg 생성
            var hGsvg = d3.select("#dashboardA");

            // 히스토그램 x축 domain 범위 설정
            var x = d3.scale.ordinal()
                .rangeRoundBands([0, hGDim.width], 0.1)
                .domain(fD.map(function (d) { return d[0]; }));


            // Create function for y-axis map.
            // 히스토그램 y축 범위 설정
            var y = d3.scale.linear().range([hGDim.height, 0])
                .domain([0, d3.max(fD, function (d) { return d[1]; })]);


            // 막대그래프 생성
            var bars = hGsvg
                .selectAll(".Abar")
                .data(fD);

            //rect 생성
            bars.select("rect")
                .attr("x", function (d) { return x(d[0]); })
                .attr("y", function (d) { return y(d[1]); })
                .attr("width", x.rangeBand())
                .attr("height", function (d) { return hGDim.height - y(d[1]); })
                .attr('fill', function (d, i) { return partyColor(i + 1); })
                .on("mouseover", mouseover)// mouseover is defined below.
                .on("mouseout", mouseout);// mouseout is defined below.

            //Create the frequency labels above the rectangles.
            bars.select("text")
                .text(function (d) { return d3.format(",")(d[1]); })
                .attr("x", function (d) { return x(d[0]) + x.rangeBand() / 2; })
                .attr("y", function (d) { return y(d[1]) - 5; })
                .attr("text-anchor", "middle");

            function mouseover(d) {  // utility function to be called on mouseover.
                // filter for selected candidate.
                var st = incomingData
                    .filter(function (s) {
                        // console.log(d[0]);
                        return s.candidate === d[0];
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
            hG.update = function (nD, color) {
                // update the domain of the y-axis map to reflect change in frequencies.
                y.domain([0, d3.max(nD, function (d) { return d[1]; })]);

                // Attach the new data to the bars.
                var bars = hGsvg
                    .selectAll(".Abar")
                    .data(nD);

                // transition the height and color of rectangles.
                bars.select("rect")
                    .transition().duration(500)
                    .attr("y", function (d) { return y(d[1]); })
                    .attr("height", function (d) { return hGDim.height - y(d[1]); })
                    .attr('fill', function (d, i) { return partyColor(i + 1); });

                // transition the frequency labels location and change value.
                bars.select("text")
                    .transition().duration(500)
                    .text(function (d) { return d3.format(",")(d[1]); })
                    .attr("y", function (d) { return y(d[1]) - 5; });
            };
            return hG;
        }

        // function to handle pieChart.
        function pieChart(pD) {
            var pC = {};
            var pieDim = { w: 150, h: 150 };
            pieDim.r = Math.min(pieDim.w, pieDim.h) / 2;

            // create svg for pie chart.
            var piesvg = d3.select("#dashboardA");
            //.append("svg")
            //.attr("width", pieDim.w)
            //.attr("height", pieDim.h)
            //.append("g")
            //.attr("transform", "translate(" + pieDim.w / 2 + "," + pieDim.h / 2 + ")");

            // create function to draw the arcs of the pie slices.
            var arc = d3.svg.arc()
                .outerRadius(pieDim.r - 10)
                .innerRadius(0);

            // create a function to compute the pie slice angles.
            var pie = d3.layout.pie()
                .sort(null)
                .value(function (d) { return d.freq; });

            // Draw the pie slices.
            piesvg.selectAll("path")
                .data(pie(pD))
                //.enter()
                //.append("path")
                .attr("d", arc)
                .each(function (d) { this._current = d; })
                .style("fill", function (d) { return segColor(d.data.type); })
                .on("mouseover", mouseover)
                .on("mouseout", mouseout);

            // create function to update pie-chart. This will be used by histogram.
            pC.update = function (nD) {
                //console.log(nD);

                piesvg.selectAll("path")
                    .data(pie(nD))
                    .transition().duration(500)
                    .attrTween("d", arcTween);
            };

            // Utility function to be called on mouseover a pie slice.
            function mouseover(d) {
                // call the update function of histogram with new data.
                hG.update(incomingData.map(function (v) {
                    //console.log(v.freq[d.data.type]);
                    return [v.candidate, v.freq[d.data.type]];
                }), segColor(d.data.type));
            }


            //Utility function to be called on mouseout a pie slice.
            function mouseout(d) {
                // call the update function of histogram with all data.
                hG.update(incomingData.map(function (v) {
                    return [v.candidate, v.total];
                }), barColor);
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
            var legend = d3.select("#dashboardA");
            //append("table")
            //    .attr('class', 'legend');

            // create one row per segment.
            var tr = legend.select("tbody")
                .selectAll("tr")
                .data(lD);
            //.enter()
            //.append("tr");

            // create the first column for each segment.
            //tr
            //.append("td")
            //.append("svg")
            tr.attr("width", '8')
                .attr("height", '8')
                .append("rect")
                .attr("width", '8')
                .attr("height", '8')
                .attr("fill", function (d) { return segColor(d.type); });

            // create the second column for each segment.
            //tr.append("td").text(function (d) {
            //    switch (d.type) {
            //        case "twenty":
            //            return "19 ~ 29 : ";
            //        case "thirty":
            //            return "30 ~ 39 : ";
            //        case "fourty":
            //            return "40 ~ 49 : ";
            //        case "fifty":
            //            return "50 ~ 59 : ";
            //        case "sixty":
            //            return "60 이상 : ";
            //    }
            //}).style("font-size", "15px");

            // create the third column for each segment.
            tr.select(".legendFreq")
                //.attr("class", 'legendFreq')
                .text(function (d) { return d3.format(",")(d.freq); }).style("font-size", "15px");

            // create the fourth column for each segment.
            tr.select(".legendPerc")
                //.attr("class", 'legendPerc')
                .text(function (d) { return getLegend(d, lD); }).style("font-size", "15px");

            // Utility function to be used to update the legend.
            leg.update = function (nD) {
                // update the data attached to the row elements.
                var l = legend.select("tbody")
                    .selectAll("tr")
                    .data(nD);

                // update the frequencies.
                l.select(".legendFreq").text(function (d) { return d3.format(",")(d.freq); }).style("font-size", "15px");

                // update the percentage column.
                l.select(".legendPerc").text(function (d) { return getLegend(d, nD); }).style("font-size", "15px");
            };

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