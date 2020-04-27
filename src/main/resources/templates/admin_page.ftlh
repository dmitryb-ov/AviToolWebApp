<#include "includes/header.ftlh"/>
<title>Admin-Panel</title>
<link rel="stylesheet" href="css/main_page.css">
<link rel="stylesheet" href="css/admin_posts.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script>
    jQuery(document).ready(function () {
        $('.remove-item').on('mouseenter', function (e) {
            $(this).addClass('mouseover');
            $(this).parent().mouseleave();
        }).on('mouseleave', function (e) {
            $(this).removeClass('mouseover');
            $(this).parent().mouseenter();
        });

        $('.remove-item').on('click', function (e) {
            console.log('clicked remove-item btn');
            e.stopPropagation();
        });
    });
</script>
<#include "includes/close_header.ftlh"/>
<#include "includes/admin_navbar.ftlh"/>
<form action="/admin/create" method="get">
    <input type="submit" class="btn btn-success" value="+Добавить пост">
</form>
<div class="list-group">
    <#list posts as post>
    <a href="/admin/post/${post.id}"
       class="list-group-item clearfix list-group-item-action flex-column align-items-start">
        <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">${post.title}</h5>
            <div>
                <small>${post.postedAt}</small>
                <form style="display: inline" method="post" action="/admin/delete">
                    <input type="hidden" name="postId" id="postId" value="${post.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-danger btn-sm" value="Удалить">
                </form>
            </div>
        </div>
        <p class="mb-1">${post.description}</p>
        <small>${post.content}</small>
        <div>
            <#list post.tags as tag>
                <small class="badge badge-danger">${tag.name}</small>
            </#list>
        </div>
    </a>
</div>
</#list>
<#include "includes/footer.ftlh"/>