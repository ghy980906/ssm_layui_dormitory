<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body>
<form class="layui-form" style="width: 80%;">

    <div class="layui-form-item">
        <label class="layui-form-label">选择维修日期</label>
        <div class="layui-input-inline">
            <input type="text" id="fixTime" name="fixTime" class="layui-input"
                   lay-verify="required" placeholder="请输入维修日期">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="updateFix">立即保存</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/fix/editFix.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>
</body>
</html>















