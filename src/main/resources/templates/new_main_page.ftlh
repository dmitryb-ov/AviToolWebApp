<#include "includes/header.ftlh"/>
<title>Главная страница</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script type="text/javascript" src="js/sms-activate_getCountAccessNumbers.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/main_page.css">
<#include "includes/close_header.ftlh"/>
<#include "includes/navbar.ftlh"/>
<#import "spring.ftl" as spring />
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4">
            <div class="card">
                <div class="container">
                    <a href="https://sms-activate.ru/ru" target="_blank"><h4>Sms-Activate</h4></a>
                    <p><span>Доступных номеров: </span><b id="sms-count"></b></p>
                    <p><span>Баланс аккаунта: </span><b id="sms-balance"></b><span> рублей</span></p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <@spring.bind"account"/>
            <form method="post" action="/">
                <div class="form-group">
                    <label for="login">Логин</label>
                    <@spring.formInput"account.login""class='form-control' id='login' placeholder='Логин(почта)'"/>
                    <#--                    <input type="text" class="form-control" id="login" placeholder="Логин(почта)" name="login">-->
                    <span style="color: red"><@spring.showErrors""/></span>
                </div>
                <div class="form-group">
                    <label for="password">Пароль</label>
                    <@spring.formInput"account.password""class='form-control' id='password' placeholder='Пароль'"/>
                    <#--                    <input type="text" class="form-control" id="password" value="MyPassw01" name="password">-->
                    <span style="color: red"><@spring.showErrors""/></span>
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Номер телефона</label>
                    <@spring.formInput"account.phoneNumber""class='form-control' id='phoneNumber' placeholder='Номер телефона'"/>
                    <#--                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">-->
                    <span style="color: red"><@spring.showErrors""/></span>
                </div>
                <div class="form-group">
                    <label for="name">Имя</label>
                    <@spring.formInput"account.name""class='form-control' id='name' placeholder='Имя'"/>
                    <#--                    <input type="text" class="form-control" id="name" value="Никита" name="name">-->
                    <span style="color: red"><@spring.showErrors""/></span>
                </div>
                <div class="form-group">
                    <label for="companyName">Название фирмы</label>
                    <@spring.formInput"account.companyName""class='form-control' id='companyName' placeholder='Название фирмы'"/>
                    <#--                    <input type="text" class="form-control" id="companyName" name="companyName">-->
                    <span style="color: red"><@spring.showErrors""/></span>
                </div>
                <div class="form-group">
                    <label for="userAgent">User-Agent</label>
                    <@spring.formInput"account.userAgent""class='form-control' id='userAgent' placeholder='user-agent'"/>
                    <#--                    <input type="text" class="form-control" id="userAgent" name="userAgent">-->
                    <span style="color: red"><@spring.showErrors""/></span>
                </div>
                <div class="form-group">
                    <label for="proxy">Прокси</label>
                    <@spring.formInput"account.proxy""class='form-control' id='proxy' placeholder='Прокси'"/>
                    <#--                    <input type="text" class="form-control" id="proxy" name="proxy">-->
                    <span style="color: red"><@spring.showErrors""/></span>
                </div>
                <div class="form-group">
                    <label for="comment">Комментарий</label>
                    <@spring.formInput"account.comment""class='form-control' id='comment' placeholder='Комментарий'"/>
                    <#--                    <input type="text" class="form-control" id="comment" name="comment">-->
                    <span style="color: red"><@spring.showErrors""/></span>
                </div>
                <div class="form-group">
                    <label for="reversoPhoneNumber">Номер адресации</label>
                    <@spring.formInput"account.reversoPhoneNumber""class='form-control' id='reversoPhoneNumber' placeholder='Номер переадресации'"/>
                    <#--                    <input type="text" class="form-control" id="reversoPhoneNumber" name="reversoPhoneNumber">-->
                    <span style="color: red"><@spring.showErrors""/></span>
                </div>
                <div style="display: table;margin: 0 auto">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-primary mb-2" value="Отправить"/>
                </div>
            </form>
        </div>
        <div class="col-sm-4">
            Hello
        </div>
    </div>
</div>
<#include "includes/footer.ftlh"/>