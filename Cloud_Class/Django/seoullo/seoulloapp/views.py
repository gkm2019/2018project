from django.shortcuts import render
from django.http import HttpResponse
from django.core import serializers
from .models import date1, date2, date3, date4, date5, date6, date7, date8, date9, date10, date11, date12, date13 ,date14, date16, date17, date18, date19, date20, date21, date22, date23, date24, date26, date28, date29, date30
from django.db.models import F, Sum, Count, Case, When
from django.template import Library
from django.db.models.functions import Coalesce
from matplotlib import pylab
from pylab import *
from . import dao

#화면에 뿌려질 db view를 관리 한다.
def index(request):

    vt = dao.visitTime(request) #시간대 별 방문자 수(6/1)
    vf = dao.visitFifth(request) #5번 넘게 자주 방문하는 사람 수 (6월 한달 동안)
    vf_total = dao.visitFifthTotal(request) #6월 간 자주 방문 한 사람 수의 합
    vt_avg = dao.visitAverage(request) #자주 방문한 사람들이 머무르는 평균 시간 (1일 치)

    context = {
               'vf' : vf,
               'total' : vf_total,
               'vt' : vt,
               'vt_avg':vt_avg

               }

    return render(request, 'content/date01.html', context)

