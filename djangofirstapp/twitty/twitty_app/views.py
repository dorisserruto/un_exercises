from django.shortcuts import render, redirect
from django.contrib.auth import login, authenticate, logout
from django.contrib.auth.models import User
from twitty_app.forms import AuthenticateForm, UserCreateForm, TwittyForm
from twitty_app.models import Twitty

from django.contrib.auth.decorators import login_required
from django.db.models import Count
from django.http import Http404
from django.core.exceptions import ObjectDoesNotExist

def index(request, auth_form=None, user_form=None):
    if request.user.is_authenticated():
        twitty_form = TwittyForm()
        user = request.user
        twittys_self = Twitty.objects.filter(user=user.id).order_by('-creation_date')
        twittys_buddies = Twitty.objects.filter(user__userprofile__in=user.profile.follows.all().order_by('-creation_date'))
        twittys = twittys_self | twittys_buddies

        return render(request,
                      'buddies.html',
                      {'twitty_form': twitty_form, 'user': user,
                       'twittys': twittys,
                       'next_url': '/', })
    else:
        auth_form = auth_form or AuthenticateForm()
        user_form = user_form or UserCreateForm()

        twittys = Twitty.objects.all().order_by('-creation_date')

        return render(request,
                      'home.html',
                      {'auth_form': auth_form, 'user_form': user_form, 'twittys': twittys,})

def login_view(request):
    if request.method == 'POST':
        form = AuthenticateForm(data=request.POST)
        if form.is_valid():
            login(request, form.get_user())
            return redirect('/')
        else:
            return index(request, auth_form=form)
    return redirect('/')


def logout_view(request):
    logout(request)
    return redirect('/')

def signup(request):
    user_form = UserCreateForm(data=request.POST)
    if request.method == 'POST':
        if user_form.is_valid():
            username = user_form.cleaned_data['username']
            password = user_form.clean_password2()
            user_form.save()
            user = authenticate(username=username, password=password)
            login(request, user)
            return redirect('/')
        else:
            return index(request, user_form=user_form)
    return redirect('/')

@login_required
def submit(request):
    if request.method == "POST":
        twitty_form = TwittyForm(data=request.POST)
        next_url = request.POST.get("next_url", "/")
        if twitty_form.is_valid():
            twitty = twitty_form.save(commit=False)
            twitty.user = request.user
            twitty.save()
            return redirect(next_url)
        else:
            return public(request, twitty_form)
    return redirect('/')

def public(request, twitty_form=None):
    twitty_form = twitty_form or TwittyForm()
    twittys = Twitty.objects.order_by('-creation_date')
    return render(request,
                  'public.html',
                  {'twitty_form': twitty_form, 'next_url': '/twittys',
                   'twittys': twittys, 'username': request.user.username})

def get_latest(user):
    try:
        return user.twitty_set.order_by('-id')[0]
    except IndexError:
        return ""

#dvsr: can't find problem with username
@login_required
def users(request, username="", twitty_form=None):
    if username:
        try:
            user = User.objects.get(username=username)
        except User.DoesNotExist:
            raise Http404
        twittys = Twitty.objects.filter(user=user.id)
        if username == request.user.username or request.user.profile.follows.filter(user__username=username):
            return render(request, 'user.html', {'user': user, 'twittys': twittys, })
        return render(request, 'user.html', {'user': user, 'twittys': twittys, 'follow': True, })

    users = User.objects.all().annotate(twitty_count=Count('twitty'))
    twittys = map(get_latest, users)
    obj = zip(users, twittys)
    twitty_form = twitty_form or TwittyForm()

    return render(request,
                  'profiles.html',
                  {'obj': obj, 'next_url': '/users/',
                   'twitty_form': twitty_form,
                   'username': request.user.username, })

@login_required
def follow(request):
    if request.method == "POST":
        follow_id = request.POST.get('follow', False)
        if follow_id:
            try:
                user = User.objects.get(id=follow_id)
                request.user.profile.follows.add(user.profile)
            except ObjectDoesNotExist:
                return redirect('/users/')
    return redirect('/users/')
