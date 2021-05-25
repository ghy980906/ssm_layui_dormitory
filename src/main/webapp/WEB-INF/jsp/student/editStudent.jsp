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
    <!--管理员id 这个必须要有 因为底层sql是根据id来更新的
    但是password和 status其他字段可有可无 但是类型和名称必须一样 不然会绑定错误
    ajax无法进去controller
    -->
    <%--<input type="hidden" name="id" value="${student.id}" id="id"/>--%>
    <input type="hidden" name="id" value="${hotel_user.id}" id="id"/>


    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" id="username" class="layui-input"
                   <%--name="username" value="${student.username}">--%>
                   name="username" value="${hotel_user.username}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" id="email" id="email" class="layui-input"
                   lay-verify="email" placeholder="请输入邮箱" value="${hotel_user.email}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <c:if test="${hotel_user.sex==0}">
                <input type="radio" name="sex" value="1" title="男">
                <input type="radio" name="sex" value="0" title="女" checked>
                <input type="radio" name="sex" value="2" title="保密">
            </c:if>
            <c:if test="${hotel_user.sex==1}">
                <input type="radio" name="sex" value="1" title="男" checked>
                <input type="radio" name="sex" value="0" title="女" >
                <input type="radio" name="sex" value="2" title="保密">
            </c:if>
            <c:if test="${hotel_user.sex==2}">
                <input type="radio" name="sex" value="1" title="男" >
                <input type="radio" name="sex" value="0" title="女" >
                <input type="radio" name="sex" value="2" title="保密" checked>
            </c:if>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出生日期</label>
        <div class="layui-input-block">
            <input type="text" id="birthday" class="layui-input" autocomplete="off"
                   name="birthday" lay-verify="date" placeholder="yyyy-MM-dd"
                   value="<fmt:formatDate value="${hotel_user.birthday}" pattern="yyyy-MM-dd"/>"
            >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">职务</label>
        <div class="layui-input-inline">
            <select name="level">
                <option value="0"<c:if test="${hotel_user.level==0}">selected</c:if>>舍长</option>
                <option value="1"<c:if test="${hotel_user.level==1}">selected</c:if>>舍员</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">
            <input type="text" name="address" class="layui-input"
                   lay-verify="required" placeholder="请输入地址" value="${hotel_user.address}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" name="phone" class="layui-input"
                   lay-verify="phone" placeholder="请输入手机号" value="${hotel_user.phone}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">班级信息</label>
        <div class="layui-input-block">
            <input type="text" name="className" class="layui-input"
                   <%--value="${student.className}">--%>
                     value="${hotel_user.className}">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <input type="text" name="note" class="layui-input"
                   lay-verify="required" placeholder="请输入备注" value="${hotel_user.note}">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="updateStudent">立即保存</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/student/editStudent.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>
</body>
</html>















