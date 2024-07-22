<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
    <h1>Home Coming</h1>
    <p>${story}</p>
    <p>
      <b>${question}</b>
    </p>
    <button onclick="clickButton1()">${nameButton1}</button>
    <button onclick="clickButton2()">${nameButton2}</button>

    <hr>
    <c:if test="${win}">
        <h2>Победа! Ты вернулся домой</h2>
        <button onclick="restart()">Начать сначала</button>
    </c:if>
    <c:if test="${lose}">
        <h2>Поражение. ${messageLose}</h2>
        <button onclick="restart()">Начать сначала</button>
    </c:if>
</body>

<script>
    function restart() {
        $.ajax({
            url: '/restart',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            async: false,
            success: function () {
                location.reload();
            }
        });
    }

    function clickButton1() {
        if(!${win} && !${lose}) {
            window.location='/logic?button=1'
        }
    }

    function clickButton2() {
        if(!${win} && !${lose}) {
            window.location='/logic?button=2'
        }
    }
</script>
</html>
