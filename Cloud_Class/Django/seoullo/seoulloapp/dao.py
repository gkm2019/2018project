from django.db import connection
import datetime
from .models import date1, date2, date3, date4, date5, date6, date7, date8, date9, date10, date11, date12, date13 ,date14, date16, date17, date18, date19, date20, date21, date22, date23, date24, date26, date28, date29, date30
from django.db.models import F, Sum, Count, Case, When

#시간대 별 방문자 수(0시-24시) sample: 2018-06-01
def visitTime(request):
    vt = []
    cursor = connection.cursor()

    for i in range(0,24):
        if i<10:
            sql = "select count(first_time_seen) from seoulloapp_date1 " \
                  "where first_time_seen like '2018-06-01T0" \
                  ""+ str(i) +":%' " \
                  "order by first_time_seen"
        elif 10<=i:
            sql = "select count(first_time_seen) from seoulloapp_date1 " \
                  "where first_time_seen like '2018-06-01T" \
                  ""+ str(i) +":%' " \
                  "order by first_time_seen"

        cursor.execute(sql)
        rows=cursor.fetchall()

        for row in rows:
            vt.append(row[0])

    return vt

#하루에 5번 이상 방문한 방문자 수 (sample : 18/6/1~18/6/5)
def visitFifth(request):
    vf = []
    cursor = connection.cursor()
    for i in range(1,31):
        if i==7:  #db 6/7 데이터가 들어가지 않음
            i+=1
        sql = "select count(*) as total " \
              "from (" \
              "select count(visitor_id) as cnt " \
              "from seoulloapp_date"+str(i)+" " \
              "where region = '1' " \
              "group by visitor_id " \
              "having count(visitor_id)>5 " \
              "order by count(visitor_id) desc " \
              ") totalTable "
        cursor.execute(sql)
        rows = cursor.fetchall()

        for row in rows:
            vf.append(row[0])

    return vf

def visitFifthTotal(request):
    total = 0
    tmp = visitFifth(request)

    # total을 구하는 for문
    for i in range(0, len(tmp)):
        if tmp[i] > 0:
            total += tmp[i]
    return total

#1지역을 자주 방문한 사람들이 머무는 평균 시간 db 불러오기
def visitAverage(request):
    vt_avg=[]
    cursor = connection.cursor()
    """
    for i in range(1, 31):
        if i == 7:  #db 6/7 데이터가 들어가지 않음
            i += 1
    """
    sql = "select region, visitor_id, " \
          "substring(first_time_seen,12,2) as fh, " \
          "substring(first_time_seen,15,2) as fm, " \
          "substring(last_time_seen,12,2) as lh, " \
          "substring(last_time_seen,15,2) as lm " \
          "from seoulloapp_date1 " \
          "where region='1' and visitor_id in (" \
          "select visitor_id from seoulloapp_date1 " \
          "where visitor_id in ( " \
          "select visitor_id " \
          "from seoulloapp_date1 " \
          "where region='1' " \
          "group by visitor_id " \
          "having count(visitor_id)>5 " \
          "))order by visitor_id"

    cursor.execute(sql)
    rows = cursor.fetchall()
    tmpID=0
    id=0
    t=0
    tmpT=0
    T=0
    tmpCnt=0
    cnt=0
    for row in rows:
        if not id:
            id=row[1]

        if id==row[1]:
            fh = int(row[2])
            fm = int(row[3])
            lh = int(row[4])
            lm = int(row[5])
            t=(lh * 60 + lm) - (fh * 60 + fm)
            if t<0:
                t=0
            T+=t
            cnt+=1
        else:
            tmpT=T
            tmpCnt=cnt
            T=0
            cnt=1
            tmpID=id
            id=row[1]
            dic = {'visitor_id': tmpID, 'T': tmpT // tmpCnt, 'cnt': tmpCnt}
            vt_avg.append(dic)

    dic={'visitor_id':id,'T':T//cnt,'cnt':cnt}
    vt_avg.append(dic)

    return vt_avg

