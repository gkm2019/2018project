# Generated by Django 2.1.3 on 2018-11-28 12:17

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('seoulloapp', '0006_auto_20181128_1912'),
    ]

    operations = [
        migrations.CreateModel(
            name='date15',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('region', models.CharField(max_length=50)),
                ('visitor_id', models.CharField(max_length=50)),
                ('first_time_seen', models.CharField(max_length=50)),
                ('last_time_seen', models.CharField(max_length=50)),
            ],
            options={
                'verbose_name': 'date15',
                'verbose_name_plural': 'date15',
            },
        ),
        migrations.CreateModel(
            name='date25',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('region', models.CharField(max_length=50)),
                ('visitor_id', models.CharField(max_length=50)),
                ('first_time_seen', models.CharField(max_length=50)),
                ('last_time_seen', models.CharField(max_length=50)),
            ],
            options={
                'verbose_name': 'date25',
                'verbose_name_plural': 'date25',
            },
        ),
        migrations.CreateModel(
            name='date27',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('region', models.CharField(max_length=50)),
                ('visitor_id', models.CharField(max_length=50)),
                ('first_time_seen', models.CharField(max_length=50)),
                ('last_time_seen', models.CharField(max_length=50)),
            ],
            options={
                'verbose_name': 'date27',
                'verbose_name_plural': 'date27',
            },
        ),
    ]
