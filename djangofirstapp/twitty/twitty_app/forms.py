from django.contrib.auth.forms import AuthenticationForm, UserCreationForm
from django.contrib.auth.models import User
from django import forms
from django.utils.html import strip_tags
from twitty_app.models import Twitty

class UserCreateForm(UserCreationForm):
    #Email as Username
    #username = forms.CharField(widget=forms.widgets.TextInput(attrs={'placeholder': 'Username'}))
    username = forms.EmailField(required=True, widget=forms.widgets.TextInput(attrs={'placeholder': 'Username(Email)'}))
    first_name = forms.CharField(required=True, widget=forms.widgets.TextInput(attrs={'placeholder': 'First Name'}))
    last_name = forms.CharField(required=True, widget=forms.widgets.TextInput(attrs={'placeholder': 'Last Name'}))
    password1 = forms.CharField(widget=forms.widgets.PasswordInput(attrs={'placeholder': 'Password'}))
    password2 = forms.CharField(widget=forms.widgets.PasswordInput(attrs={'placeholder': 'Password Confirmation'}))

    def is_valid(self):
        form = super(UserCreateForm, self).is_valid()
        for f, error in self.errors.items():
            if f != '__all_':
                self.fields[f].widget.attrs.update({'class': 'error', 'value': strip_tags(error)})
        return form

    class Meta:
        fields = ['username', 'first_name', 'last_name', 'password1',
                  'password2']
        model = User

class AuthenticateForm(AuthenticationForm):
    username = forms.EmailField(widget=forms.widgets.TextInput(attrs={'placeholder': 'Username (Email)'}))
    password = forms.CharField(widget=forms.widgets.PasswordInput(attrs={'placeholder': 'Password'}))

    def is_valid(self):
        form = super(AuthenticateForm, self).is_valid()
        for f, error in self.errors.items():
            if f != '__all__':
                self.fields[f].widget.attrs.update({'class': 'error', 'value': strip_tags(error)})
        return form

class TwittyForm(forms.ModelForm):
    content = forms.CharField(required=True, widget=forms.widgets.Textarea(attrs={'class': 'twittyText'}))

    def is_valid(self):
        form = super(TwittyForm, self).is_valid()
        for f in self.errors.items():
            if f != '__all__':
                self.fields[f].widget.attrs.update({'class': 'error twittyText'})
        return form

    class Meta:
        model = Twitty
        exclude = ('user',)
