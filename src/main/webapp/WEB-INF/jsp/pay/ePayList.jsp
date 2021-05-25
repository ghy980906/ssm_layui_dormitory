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


    <div class="layui-inline">
        <a class="layui-btn layui-btn-normal payAdd_btn">
            <i class="layui-icon">&#xe608;</i>添加缴费信息
        </a>
    </div>



</blockquote>
<!--数据表格-->
<table id="payList" class="payList" lay-filter="payList"></table>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/pay/ePayList.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

<script type="text/html" id="barEdit">

    <a class="layui-btn layui-btn-sm layui-btn-danger " lay-event="del">
        <i class="layui-icon">&#xe640;</i>
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
<script type="text/html" id="payType">
    {{#  if(d.payType==0){                         }}
    <span style="color: #0000FF">微信</span>

    {{#   }  else if(d.payType==1){                        }}
    <span style="color: #FF5722">支付宝</span>

    {{#   }  else if(d.payType==2){                        }}
    <span style="color: #FF5722">现金</span>

    {{#   }  else if(d.payType==5){                        }}
    <span style="color: #FF5722">未交费</span>

    {{#   }else {                                      }}
    <span style="color: #1AA094">其他</span>
    {{#      }                                          }}
</script>
</body>
</html>




