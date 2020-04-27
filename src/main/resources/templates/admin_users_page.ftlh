<#include "includes/header.ftlh"/>
<title>Админ-панель (пользователи)</title>
<#include "includes/close_header.ftlh"/>
<#include "includes/admin_navbar.ftlh"/>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Логин</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Роль</th>
        <th scope="col">Действие</th>
        <th scope="col">Кнопка</th>
    </tr>
    </thead>
    <#list users as user>
        <form action="/admin/users" method="post">
            <tbody>
            <tr>
                <th scope="row">${user.id}
                    <input type="hidden" name="user_id" id="user_id" value="${user.id}">
                </th>
                <td>${user.login}</td>
                <td>${user.name}</td>
                <td>${user.secondName}</td>
                <td>${user.role.toString()}</td>
                <td>
                    <select class="form-control col-sm-5" id="select" name="select">
                        <option name="none" id="none"></option>
                        <option name="changeRole" id="changeRole">Выдать роль администратора</option>
                        <option name="changeRole" id="changeRole">Выдать роль пользователя</option>
                        <option name="delete" id="delete">Удалить</option>
                    </select>
                </td>
                <td>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Подтвердить" class="btn-danger" id="${user.id}" name="${user.id}"></td>
            </tr>
            </tbody>
        </form>
    </#list>
</table>
<#include "includes/footer.ftlh"/>