


from django.urls import path
from . import views
from . import dao

urlpatterns = [
    path('', views.index, name='app_index'),
]
