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
<form class="layui-form" style="width: 80%;" id="auf">

    <div class="layui-form-item">
        <label class="layui-form-label">计费起始时间</label>
        <div class="layui-input-block">
            <input type="text" id="payStartTime" class="layui-input" autocomplete="off"
                   name="payStartTime" lay-verify="datetime" placeholder="yyyy-MM-dd"
            >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">计费结束时间</label>
        <div class="layui-input-block">
            <input type="text" id="payEndTime" class="layui-input" autocomplete="off"
                   name="payEndTime" lay-verify="datetime" placeholder="yyyy-MM-dd"
            >
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">房间号</label>
        <div class="layui-input-block">
            <select name="dormitoryId" id="dormitoryId"
                    lay-filter="roomFilter">
                <option value="">请选择</option>
                <c:forEach items="${dormitories}" var="d">
                    <option value="${d.dormitoryId}">${d.dormitoryNumber}</option>
                </c:forEach>
            </select>
        </div>
    </div>
<!--
    <div class="layui-form-item">
        <label class="layui-form-label">收费项目</label>
        <div class="layui-input-inline">
            <input type="radio" name="payName" value="0" title="水费" checked>
            <input type="radio" name="payName" value="1" title="电费" checked>
            <input type="radio" name="payName" value="2" title="物业费" checked>
            <input type="radio" name="payName" value="3" title="其他费用" checked>
        </div>
    </div>
-->
    <div class="layui-form-item">
        <label class="layui-form-label ">费用</label>
        <div class="layui-input-block">
            <input type="text" id="total" class="layui-input"
                   lay-verify="required" placeholder="请输入价格" name="total" >
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWPay">立即提交</button>
        </div>
    </div>
</form>

<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/pay/addWPay.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

</body>
</html>