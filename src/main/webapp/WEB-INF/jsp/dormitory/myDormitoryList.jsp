<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
          media="all" />
    <link rel="stylesheet" href="${ctx }/css/list.css" media="all" />

    <script >
        var ctx="${ctx}";
    </script>
    <style type="text/css">
        .layui-table-cell {
            font-size:14px;
            padding:0 5px;
            height: 100%;
            max-width: 100%;
            overflow:visible;
            text-overflow:inherit;
            white-space:normal;
            word-break: break-all;
        }
    </style>
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote list_search">

</blockquote>
<!--数据表格-->
<table id="dormitoryList" class="layui-table layui-table-cell" lay-filter="dormitoryList"></table>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/dormitory/myDormitoryList.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

<!--我们设置了虚拟路径 所以这里可以直接用{{d.dormitoryPhoto}}-->
<script type="text/html" id="imgtmp">
    <img src="{{d.dormitoryPhoto}}" />
</script>


<script type="text/html" id="barEdit">

    <a class="layui-btn layui-btn-sm layui-btn-danger " lay-event="del">
        <i class="layui-icon">&#xe640;</i>
    </a>
    <a class="layui-btn layui-btn-sm layui-btn-danger " lay-event="detail">
        <i class="layui-icon">&#xe634;</i>
    </a>
</script>

</body>
</html>




