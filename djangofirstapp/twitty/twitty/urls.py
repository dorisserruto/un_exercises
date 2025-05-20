"""twitty URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.9/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Add an import:  from blog import urls as blog_urls
    2. Import the include() function: from django.conf.urls import url, include
    3. Add a URL to urlpatterns:  url(r'^blog/', include(blog_urls))
"""
from django.conf.urls import url, patterns, include
from django.contrib import admin

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^$', 'twitty_app.views.index'),
    url(r'^login$', 'twitty_app.views.login_view'),
    url(r'^logout$', 'twitty_app.views.logout_view'),
    url(r'^signup$', 'twitty_app.views.signup'),
    url(r'^twittys$', 'twitty_app.views.public'),
    url(r'^submit$', 'twitty_app.views.submit'),
    url(r'^users/$', 'twitty_app.views.users'),
    url(r'^users/(?P<username>\w{0,30})/$', 'twitty_app.views.users'),
    url(r'^follow$', 'twitty_app.views.follow'),
]
