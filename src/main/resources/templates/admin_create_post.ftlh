<#include "includes/header.ftlh"/>
<title>Создать пост</title>
<#include "includes/close_header.ftlh"/>
<#include "includes/admin_navbar.ftlh"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">
            <form action="/admin/create" method="post">
                <div class="form-group">
                    <label for="postTitle">Заголовок</label>
                    <input type="text" class="form-control" id="postTitle" name="postTitle">
                </div>
                <div class="form-group">
                    <label for="postDescription">Описание</label>
                    <textarea class="form-control" id="postDescription" name="postDescription" rows="5"></textarea>
                </div>
                <div class="form-group">
                    <label for="postContent">Дополнительно</label>
                    <textarea class="form-control" id="postContent" name="postContent" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <label for="tag">Тэг</label>
                    <input type="text" class="form-control" id="tag" name="tag"
                           placeholder="Теги указывать через запятую">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input type="submit" class="btn btn-success" value="Создать пост">
            </form>
        </div>
        <div class="col-md-4">

        </div>
    </div>
</div>
<#include "includes/footer.ftlh"/>