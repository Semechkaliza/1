<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${requestScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources.text"/>
<!DOCTYPE html>
<html lang="${language}">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="registration"/></title>
    <style>
        <%@include file='../css/final.css' %>
    </style>
</head>
<body>
<header class="header">

    <ul class="ul_buttons_header">
        <li class="button_header"><a href="" class="link_header">Главная</a></li>
        <li class="button_header"><a href="" class="link_header">Профиль</a></li>
        <li class="button_header"><a href="" class="link_header">Вакансии</a></li>
        <li class="button_header"><a href="" class="link_header">Помощь</a></li>
        <li class="button_header"><a href="" class="link_header">Контакты</a></li>
    </ul>
</header>
<div class="first_section">
    <div class="download">
        <div class="title_first_section">
            <p>HR-system</p>
        </div>
        <div class="description_first_section">
            <p>Открытая площадка для поиска работы, где каждый день сотни работодателей и соискателей работы находят друг друга.</p>
        </div>
    </div>
    <form method="POST" action="controller">

    <div class="registration">

        <div class="all_box_input_registration">
            <input type="hidden" value="locale"/>
            <label>
                <input name="locale" type="radio" value="ru">
            </label> RU
            <label>
                <input name="locale" type="radio" value="en">
            </label> EN
            <label>
                <input name="locale" type="radio" value="be" checked>
            </label> BE
            <br>
            <div class="title_registration"><p><fmt:message key="registration"/></p></div>
            <input type="hidden" name="command" value="registration" />
            <div class="block_inputs">
                <div class="inputBlock">
                    <input type="text" id="Login" class="registration_input" name="login" value="" placeholder="<fmt:message key="login"/>"/>
                    <span class="trueLogin"><fmt:message key="yes"/></span>
                    <span class="falseLogin"><fmt:message key="no"/></span>
                </div>
                <div class="inputBlock">
                    <input type="password" id="Password" class="registration_input" name="password" value="" placeholder="<fmt:message key="password"/>"/>
                    <span class="truePassword"><fmt:message key="yes"/></span>
                    <span class="falsePassword"><fmt:message key="no"/></span>
                </div>
                <div class="inputBlock">
                    <input type="password" id="Password2" class="registration_input" placeholder="<fmt:message key="password"/>"/>
                    <span class="truePassword2"><fmt:message key="yes"/></span>
                    <span class="falsePassword2"><fmt:message key="no"/></span>
                </div>
                <div class="inputBlock">
                    <input type="text" id="Email" class="registration_input" name="email" value="" placeholder="<fmt:message key="email"/>"/>
                </div>
                <div class="inputBlock">
                    <input type="text" id="Phone" class="registration_input" name="phone" value="" placeholder="<fmt:message key="phone"/>"/>
                </div>
                <div class="inputBlock">
                    <input type="text" id="Name" class="registration_input" name="name" value="" placeholder="<fmt:message key="name"/>"/>
                </div>
                <div class="inputBlock">
                    <input type="text" id="Sname" class="registration_input" name="sname" value="" placeholder="<fmt:message key="sname"/>"/>
                </div>
            </div>
            <div class="message">${errorLoginPassMessage}</div> <br/>
            <button type="submit" class="GetStarted_registration" value="Registration"><fmt:message key="registration"/></button>
        </div>
    </div>
    </form>
</div>

<div class="second_section">
    <div class="title_block">
        <h2>Популярные вакансии</h2>
        <div class="line_Section"></div>
        <p>Возможно, именно Вас уже заждалась прекрасная и талантливая команда!</p>
    </div>
    <div class="list_of_options">
        <div class="option">
            <div class="view_price">
                <div class="name_of_option"><p>Java Junior Developer</p></div>
                <div class="price_of_option"><p class="price">>$300</p><p class="text_of_option">EPAM Sys.</p></div>
                <div class="view_div_for_postcript">
                    <a href=""><div class="postscript">Откликнуться</div></a>
                </div>
            </div>
            <ul class="list_of_advantages">
                <li class="advantage">Офис рядом с метро</li>
                <li class="advantage">Дружная команда</li>
                <li class="advantage">Опыт от 1 года</li>
            </ul>
        </div>
        <div class="option">
            <div class="view_price">
                <div class="name_of_option"><p>Senior Python Developer</p></div>
                <div class="price_of_option"><p class="price">>$700</p><p class="text_of_option">IBM</p></div>
                <div class="view_div_for_postcript">
                    <a href=""><div class="postscript"><p>Откликнуться</p></div></a>
                </div>
            </div>
            <ul class="list_of_advantages">
                <li class="advantage">Офис в центре города</li>
                <li class="advantage">Возможность удалённой работы</li>
                <li class="advantage">Приветствуется знание китайского языка</li>
            </ul>
        </div>
        <div class="option">
            <div class="view_price">
                <div class="name_of_option"><p>IOS-разработчик</p></div>
                <div class="price_of_option"><p class="price">$300</p><p class="text_of_option">Lecodegroup</p></div>
                <div class="view_div_for_postcript">
                    <a href=""><div class="postscript"><p>Откликнуться</p></div></a>
                </div>
            </div>
            <ul class="list_of_advantages">
                <li class="advantage">Опыт от 1 года</li>
                <li class="advantage">7-часовой рабочий день</li>
                <li class="advantage">Недалеко от ст.м.Немига</li>
            </ul>
        </div>
    </div>
</div>
<div class="third_section">
    <div class="title_block">
        <h2>Напишите нам</h2>
        <div class="line_Section"></div>
        <p>Сделаем HR-system лучше вместе!</p>
    </div>
    <div class="input_datas_block">
        <div class="block_inputs">
            <input type="text" class="input_data" placeholder="    Name">
            <input type="text" class="input_data" placeholder="    Email">
            <input type="password" class="input_data" placeholder="    Password">
        </div>
        <textarea name="" id="" class="textarea_data_input" placeholder="Сообщение"></textarea>
    </div>
    <button class="button_third_section"><a href="">Отправить</a></button>
</div>
<footer>
    <ul class = "all_icons_footer">
        <li class="icon_footer"><a href=""><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
        <li class="icon_footer"><a href=""><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
        <li class="icon_footer"><a href=""><i class="fa fa-google-plus" aria-hidden="true"></i></a> </li>
        <li class="icon_footer"><a href=""><i class="fa fa-pinterest" aria-hidden="true"></i></a> </li>
        <li class="icon_footer"><a href=""><i class="fa fa-vk" aria-hidden="true"></i></a> </li>
        <li class="icon_footer"><a href=""><i class="fa fa-instagram" aria-hidden="true"></i></a> </li>
        <li class="icon_footer"><a href=""><i class="fa fa-telegram" aria-hidden="true"></i></a> </li>
    </ul>
    <p>HR-system.2018</p>
</footer>


<script type="text/javascript"><%@include file="../js/Script.js" %></script>
</body>
</html>