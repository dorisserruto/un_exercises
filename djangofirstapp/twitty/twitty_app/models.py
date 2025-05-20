from django.db import models

from django.contrib.auth.models import User

class Twitty(models.Model):
    content = models.CharField(max_length=140)
    user = models.ForeignKey(User)
    creation_date = models.DateTimeField(auto_now=True, blank=True)

class UserProfile(models.Model):
    user = models.OneToOneField(User)
    follows = models.ManyToManyField('self', related_name='followed_by', symmetrical=False)

    def avatar_url(self):
        default = "http://i63.tinypic.com/1z3v41h.jpg" #no avatar
        return default

User.profile = property(lambda u: UserProfile.objects.get_or_create(user=u)[0])
