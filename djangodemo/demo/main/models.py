from __future__ import unicode_literals

from django.contrib.auth.models import User
from django.db import models

# Create your models here.
class Post(models.Model):
    name = models.CharField(max_length=20)
    content = models.CharField(max_length=100)
    created_at = models.DateTimeField()
    user = models.ForeignKey(User)