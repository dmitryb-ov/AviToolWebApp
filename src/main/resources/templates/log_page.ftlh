<#import "/spring.ftl" as spring/>
<#include "includes/header.ftlh">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<#include "includes/close_header.ftlh">
<#import "spring.ftl" as spring />
<#--<#import "spring.ftl" as spring />-->
<#--<@spring.bind "user"/>-->
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">AviToolHelper</a>
    <form class="form-inline" method="get" action="/registration">
        <#--        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Регистрация</button>
    </form>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-6 my-4 my-sm-4 my-lg-5 p-3 col-md-offset-4" style="display: table;margin: 0 auto">
            <#--            ${_csrf.token}-->
            <form method="post" action="/login">
                <h1 style="display: table;margin: 0 auto">Войти в систему</h1>
                <div class="form-group">
                    <label for="login">Логин</label>
                    <input type="text" class="form-control" id="login" placeholder="Логин" name="login">
                    <#--                    <label for="login" style="color: red">${passwErr}</label>-->
                </div>
                <div class="form-group">
                    <label for="password">Пароль</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
                </div>
                <div style="color: red">
                    <#if Session.SPRING_SECURITY_LAST_EXCEPTION??
                    && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
                        Пользователь не найден
                    </#if>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input id="enter" class="btn btn-primary my-2 my-sm-0" type="submit" value="Вход"
                       style="display: table;margin: 0 auto">
            </form>
        </div>
    </div>
</div>
<#include "includes/footer.ftlh">