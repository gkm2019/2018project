# Generated by Django 2.0 on 2018-11-26 16:19

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='date01',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('region', models.CharField(max_length=50)),
                ('visitor_id', models.CharField(max_length=50)),
                ('first_time_seen', models.CharField(max_length=50)),
                ('last_time_seen', models.CharField(max_length=50)),
            ],
            options={
                'verbose_name': 'date01',
                'verbose_name_plural': 'date01',
            },
        ),
    ]
