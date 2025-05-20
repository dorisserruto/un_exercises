from django.shortcuts import render
# Create your views here.
from main.models import Post

''' Los html deben encontrarse en una estructura dentro de una carpeta
# llamada templates'''


def home(request):
    name = "Doris"
    posts = Post.objects.all()
    return render(request, "main/home.html", locals())
    #locals: envia las variables a la vista


def detail(request, pk):
    post = Post.objects.get(pk=pk)
    return render(request, "main/detail.html", locals())