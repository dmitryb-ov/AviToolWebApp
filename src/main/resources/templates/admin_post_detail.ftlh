<#include "includes/header.ftlh"/>
<title>Пост</title>
<#include "includes/close_header.ftlh"/>
<#include "includes/admin_navbar.ftlh"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4">

        </div>
        <div class="col-sm-4">
            <h1>${post.title}</h1>
            <div>
                <#list post.tags as tag>
                    <small class="badge badge-danger">${tag.name}</small>
                </#list>
            </div>
            <h5>${post.description}</h5>
            <h6>${post.content}</h6>
        </div>
        <div class="col-sm-4">

        </div>
    </div>
</div>
<#include "includes/footer.ftlh"/>