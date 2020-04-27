<#include "includes/header.ftlh"/>
<link rel="stylesheet" href="css/profile.css">
<title>Профиль</title>
<#include "includes/close_header.ftlh"/>
<#include "includes/navbar.ftlh"/>
<div class="row">
    <div class="col-sm-2">
        <img src="https://i.pinimg.com/originals/c0/b7/7f/c0b77faeb2cb3e67fd1b423c4535f6c3.jpg"
             class="rounded-circle button-section margin-ava" width="200" height="200   " alt="image-profile">
    </div>
    <div class="col-sm-10">
        <h2 class="button-section">${myuser.name} ${myuser.secondName}</h2>
        <h5 class="button-section tags">Пользователь</h5>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade show active button-section margin-info" id="profileInfo">
                <div class="row">
                    <div class="col-md-2">
                        <label>Имя</label>
                    </div>
                    <div class="col-md-6">
                        <p>${myuser.name}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label>Фамилия</label>
                    </div>
                    <div class="col-md-6">
                        <p>${myuser.secondName}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "includes/footer.ftlh"/>
