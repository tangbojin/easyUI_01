<%--
  Created by IntelliJ IDEA.
  User: tbj12
  Date: 2018/3/10 0010
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>餐厅管理系统</title>
    <link rel="stylesheet" href="easyui/themes/material/easyui.css" type="text/css">
    <link rel="stylesheet" href="easyui/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="easyui/animate.css" type="text/css">
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>

</head>
<body background="image/bgimg.jpeg">
<h1 style="display: flex;justify-content: center;color: red">餐厅管理系统</h1>
<div id="win" class="easyui-window" title="登陆界面" data-options="iconCls:'icon-save',modal:true" >
    <form action="/dologin" method="post" id="loginForm">
        <div id="loginTitle" class="animated rubberBand">欢迎登陆</div>
        <%--提示错误信息--%>
        <span style="color: red;font-size: 24px">${error}</span>
        <%--账号密码登陆--%>
        <div>
            <label style="color: orangered">用户名：</label><input type="text" name="username" value="${username}"/>
        </div><br>
        <div>
            <label style="color: orangered">密码：</label><input type="text" name="password" value="${password}" />
        </div><br>
        <div>
            <input type="submit" value="登陆" style="width: 80px" />
            <a href="register.jsp" style="color: orangered" />没有账号？立即注册</a>
        </div>
    </form>

</div>

</body>
<style type="text/css">
    #win {
        width: 600px;
        height: 400px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        background-image: url(' image/contentimage2.jpg');
        color: white;font-size: 18px;
    }

    #loginTitle {
        color: orangered;
        font-size: 48px;
        font-family: 华文新魏;
        display: flex;
        justify-content: center;
        align-items: center;
    }

</style>

</html>
