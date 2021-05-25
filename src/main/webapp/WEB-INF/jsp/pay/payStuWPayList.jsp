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
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote list_search">


</blockquote>
<!--数据表格-->
<table id="wpayList" class="wpayList" lay-filter="wpayList"></table>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/pay/payStuWPayList.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

<script type="text/html" id="barEdit">

    <a class="layui-btn layui-btn-sm" lay-event="edit">
        <i class="layui-icon">&#xe642;</i>
    </a>
</script>


<script type="text/html" id="payStatus">
    {{#  if(d.payStatus==0){                         }}
    <span style="color: #0000FF">未交费</span>
    {{#   }  else if(d.payStatus==1){                        }}
    <span style="color: #FF5722">已缴费</span>
    {{#   }else {                                      }}
    <span style="color: #1AA094">其他</span>
    {{#      }                                          }}
</script>
<script type="text/html" id="payName">
    {{#  if(d.payName==1){                         }}
    <span style="color: #0000FF">水费</span>

    {{#   }  else if(d.payName==2){                        }}
    <span style="color: #FF5722">电费</span>

    {{#   }  else if(d.payName==3){                        }}
    <span style="color: #FF5722">物业费</span>

    {{#   }else {                                      }}
    <span style="color: #1AA094">其他</span>
    {{#      }                                          }}
</script>
</body>
</html>




