<%--
  Created by IntelliJ IDEA.
  User: tbj12
  Date: 2018/3/14 0014
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>

    <link rel="stylesheet" href="easyui/themes/material/easyui.css">
    <link rel="stylesheet" href="easyui/themes/icon.css">
    <link rel="stylesheet" href="easyui/themes/layer.css">
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/layer.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
<div id="win" style="background-image: url('image/register.jpg');display: flex;align-items: center;" >
    <form style="margin-left: 15px;">
        <h2 align="center">欢迎进行注册</h2>
        用户名称：<input type="text" id="username" name="username" value="${username}" ><br>
        用户密码：<input type="password" id="password" name="password" value="${password}" style="margin-top: 15px"><br>
        手机号码：<input type="text" id="phoneNumber" name="phoneNumber" value="${phoneNumber}" style="margin-top: 15px"><br>
        <input type="button" value="注册" onclick="doreg()" style="margin-top: 15px;margin-left: 60px">
        <input type="reset" value="重置" style="margin-left: 10px;">
    </form>
</div>
</body>

<script type="text/javascript">
    $('#win').window({
        title:"用户注册",
        top:10,
        width:600,
        height:650,
        modal:false,

    });
</script>
<script type="text/javascript">
    function doreg(){
        var username = $("#username").val();
        var password = $("#password").val();
        var phoneNumber = $("#phoneNumber").val();
        $.post("/register",
            {username: username,password:password,phoneNumber:phoneNumber},
            function (smsg) {
                if(smsg.msg = 'error'){
                    layer.alert('该用户已存在', {
                        skin: 'layui-layer-molv' //样式类名
                        ,closeBtn: 0
                    }, function(){
                        layer.alert('换一个昵称吧', {
                            skin: 'layui-layer-lan'
                            ,closeBtn: 0
                            ,anim: 4 //动画类型
                        });
                    });
                }
            })
    }
</script>
</html>
