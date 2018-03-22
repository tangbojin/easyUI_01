<%--
  Created by IntelliJ IDEA.
  User: tbj12
  Date: 2018/3/20 0020
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单管理中心</title>

    <link rel="stylesheet" href="easyui/themes/material/easyui.css">
    <link rel="stylesheet" href="easyui/themes/icon.css">
    <link rel="stylesheet" href="easyui/themes/layer.css">
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/layer.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
<table id="dg">
    <div id="win"style="display: none;margin-top: 110px" align="center">
        <form id="addFood">
            美食名称：<input type="text" id="foodName" name="foodName"style="margin-top: 10px"><br>
            美食价格：<input type="text" id="foodPrice" name="foodPrice" style="margin-top: 10px"><br>
            图片地址：<input type="text" id="foodImg" name="foodImg" style="margin-top: 10px"><br>
            价格单位：<input type="text" id="priceType" name="priceType" style="margin-top: 10px"><br>
            <input type="button" value="提交" onclick="addmsg()" style="margin-top: 10px"><input type="reset" value="重置" style="margin-left: 30px">
        </form>
    </div>
</table>

</body>

<script type="text/javascript">
    /*提交添加的美食信息，并提示*/
        function addmsg(){
            var foodName = $("#foodName").val();
            var foodPrice = $("#foodPrice").val();
            var foodImg = $("#foodImg").val();
            var priceType = $("#priceType").val();
            $.post("/addFood",
                {foodName: foodName,foodPrice:foodPrice,foodImg:foodImg,priceType:priceType},
                function (smsg) {
                    if(smsg.msg = 'success'){
                        layer.alert('美食已添加成功', {
                            skin: 'layui-layer-molv' //样式类名
                            ,closeBtn: 0
                        }, function(){
                            layer.alert('赶快去看看吧', {
                                skin: 'layui-layer-lan'
                                ,closeBtn: 0
                                ,anim: 4 //动画类型
                            });
                            window.location.replace("food.jsp");
                        });
                    }
                })
        }
</script>

<script type="text/javascript">
    $('#dg').datagrid({
        url:'/food',
        columns:[[
            {field:'id',title:'美食编号',width:20,align:'center',sortable:true},
            {field:'foodName',title:'美食名称',width:100,align:'center'},
            {field:'foodPrice',title:'价格',width:100,align:'center'},
            {field:'foodImg',title:'美食图片',width:100,align:'center',formatter: function (value,row,index) {
                    return '<img src="'+value+'" style="width: 70px;height: 70px">'
                }},
            {field:'priceType',title:'价格单位',width:100,align:'center'},

        ]],
        fit : true,
        fitColumns :true,
        frozenColumns :true,
        pagination : true,
        pageNumber :1,
        pageSize : 4,
        pageList : [4,8,12,16,20,24,28,32,36],
        singleSelect :true,
        showFooter: true,
    });

    $('#dg').datagrid({
        toolbar: [{
            text:'添加美食',
            iconCls: 'icon-add',
            handler: function(){
                $('#win').window({
                    title:"添加一种美食",
                    width:600,
                    height:400,
                    modal:true,
                });
            }
        },'-',{
            text:'删除选中',
            iconCls: 'icon-remove',
            handler: function() {
                var sFood = $('#dg').datagrid('getSelected');
                if (sFood){
                    $.ajax({
                        type: "post",
                        url : "/deleteFood",
                        dataType : "json",
                        contentType: "application/json; charset=utf-8",     //与springMVC进行json交互需指定内容类型为此
                        data : JSON.stringify(sFood),
                        success : function(data){
                            if(data = 1){
                                layer.alert('删除成功,请刷新重试', {icon: 6});
                            }else{
                                layer.alert('删除失败', {icon: 5});
                            }
                        }
                    })
                }
            }
        }/*,'-',{
            text:'编辑美食',
            iconCls: 'icon-edit',
            handler: function(){

            }
        }*/
        ]
    });


</script>

</html>
