<#include "includes/header.ftlh">
<title>Регистрация</title>
<#include "includes/close_header.ftlh">
<#import "spring.ftl" as spring />
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">AviToolHelper</a>
    <form class="form-inline" method="get" action="/login">
        <#--        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
        <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Вход</button>
    </form>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-6 my-4 my-sm-4 my-lg-5 p-3 col-md-offset-4" style="display: table;margin: 0 auto">
            <@spring.bind "user"/>
            <form method="post" action="/registration">
                <h1 style="display: table;margin: 0 auto">Регистрация в системе</h1>
                <div class="form-group">
                    <label for="login">Логин</label>
                    <@spring.formInput"user.login""class='form-control' id='login' placeholder='Логин'"/>
                    <#--                    <input type="text" class="form-control" id="login" placeholder="Логин" name="user.login">-->
                    <span style="color: red">
                        <@spring.showErrors""/>
                    </span>
                </div>
                <div class="form-group">
                    <label for="password">Пароль</label>
                    <@spring.formPasswordInput"user.password""class='form-control' id='login' placeholder='Пароль'"/>
                    <span style="color: red">
                        <@spring.showErrors""/>
                    </span>
                    <#--                    <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">-->
                </div>
                <div class="form-group">
                    <label for="userName">Ваше имя</label>
                    <@spring.formInput"user.name""class='form-control' id='name' placeholder='Имя'"/>
                    <span style="color: red">
                        <@spring.showErrors""/>
                    </span>
                </div>
                <div class="form-group">
                    <label for="userSecondName">Ваша фамилия</label>
                    <@spring.formInput"user.secondName""class='form-control' id='secondName' placeholder='Фамилия'"/>
                    <span style="color: red">
                        <@spring.showErrors""/>
                    </span>
                </div>
                <div class="form-group">
                    <label for="key">Спецальный ключ</label>
                    <input type="text" class="form-control" id="key" name="key" placeholder="Ключ">
                    <span style="color:red"><@spring.showErrors""/></span>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input class="btn btn-success my-2 my-sm-0" type="submit" value="Регистрация"
                       style="display: table;margin: 0 auto">
            </form>
        </div>
    </div>
</div>
<#include "includes/footer.ftlh">