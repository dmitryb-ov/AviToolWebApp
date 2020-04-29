<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">AviToolHelper</a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/profile">Профиль</a>
            </li>
            <#--            <li class="nav-item">-->
            <#--                <a class="nav-link" href="#">Настройки</a>-->
            <#--            </li>-->
            <#--            <li class="nav-item">-->
            <#--                <a class="nav-link" href="/dz">Дз</a>-->
            <#--            </li>-->
        </ul>
    </div>
    <form class="form-inline" method="post" action="/logout">
        <#--        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Выход</button>
    </form>
</nav>