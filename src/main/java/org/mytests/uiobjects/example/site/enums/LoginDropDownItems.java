package org.mytests.uiobjects.example.site.enums;

public enum LoginDropDownItems {
    Registration("Регистрация"), Login("Войти"), LoginWithFacebook("Войти через Facebook"), Exit("Выйти"), Panel("Панель управления");

    String value;

    LoginDropDownItems(String value) {
        this.value = value;
    }
}
