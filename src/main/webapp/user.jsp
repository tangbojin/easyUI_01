<%--
  Created by IntelliJ IDEA.
  User: tbj12
  Date: 2018/3/20 0020
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户中心</title>

    <link rel="stylesheet" href="easyui/themes/material/easyui.css">
    <link rel="stylesheet" href="easyui/themes/icon.css">
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body background="image/userbg.jpg">
<div id="win">
    <table id="dg"></table>
</div>

</body>

<script type="text/javascript">
    $('#win').window({
        title:"餐馆信息",
        top:52,
        left:10,
        width:400,
        height:400,
        modal:false,
    });
</script>
<script type="text/javascript">
    $('#dg').datagrid({
        url:'/seller',
        columns:[[
            {field:'sellerName',title:'店铺名称',width:100,align:'center'},
            {field:'windowImg',title:'店铺招牌',width:100,align:'center',formatter: function (value)
                {return '<img src="'+value+'" style="width: 70px;height: 70px">'}},
            {field:'phoneNumber',title:'电话号码',width:100,align:'center'}
        ]],
        fit : true,
        fitColumns :true,
        frozenColumns :true,
        pageNumber :1,
        pageSize : 4,
        singleSelect :true,
        showFooter: true,
    });
</script>
<style type="text/css">
    #win {
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
</html>
