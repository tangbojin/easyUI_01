<%--
  Created by IntelliJ IDEA.
  User: tbj12
  Date: 2018/3/20 0020
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="easyui/themes/material/easyui.css">
    <link rel="stylesheet" href="easyui/themes/icon.css">
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:false" style="height:60px;display:flex; justify-content: center;align-items: center;font-size: 24px;color: orangered" >餐馆后台管理系统</div>
<div data-options="region:'south',split:false" style="height:50px;display:flex; justify-content: center;align-items: center;font-size: 18px;font-family: 'Microsoft YaHei UI'">@copyright 2018</div>
<div data-options="region:'west',title:'系统菜单',split:false" style="width:200px;">
    <ul id="tt" ></ul>
</div>
<div id="tabs" class="easyui-tabs" data-options="region:'center',title:'系统主页'" style="padding:0px;background:#E0ECFF;">
</div>
</body>

<script type="text/javascript">
    $('#tt').tree({
        data: [
            {
                text: '订单管理',
                attributes: {
                    "url":"order.jsp"
                }
            },{ text: '菜品管理',
                attributes: {
                    "url":"food.jsp"
                }
            },{
                text: '用户中心',
                attributes: {
                    "url":"user.jsp"
                }
            }
        ],
        onClick: function(node){
            if($('#tabs').tabs('exists',node.text)){
                $('#tabs').tabs('select',node.text)
            }else {
                $('#tabs').tabs('add', {
                    title: node.text,
                    content:'<iframe src="'+node.attributes.url+'" style="width:100%;height:100%" frameborder="0"></iframe>' ,
                    closable: true,
                })
            }
        }

    });


</script>
</html>
