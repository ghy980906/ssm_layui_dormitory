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

    <!--id 这个是 提交表单时 携带的参数-->
    <input type="hidden" name="payId" value="${payId}"/>

    <div class="layui-form-item">
        <label class="layui-form-label">付款方式</label>
        <div class="layui-input-inline">
            <input type="radio" name="payType" value="0" title="微信" checked>
            <input type="radio" name="payType" value="1" title="支付宝" checked>
            <input type="radio" name="payType" value="2" title="现金" checked>
            <input type="radio" name="payType" value="3" title="其他" checked>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addPay">立即提交</button>
        </div>
    </div>
</form>

<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/pay/stuEPay.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

</body>
</html>



