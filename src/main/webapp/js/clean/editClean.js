
layui.use([ 'form','layer','jquery','table','laydate'], function() {
    var layer = layui.layer, $ = layui.jquery, form = layui.form, table = layui.table, laydate = layui.laydate;



    laydate.render({
        elem:'#cleanTime',
        type:'datetime',//可选择：年、月、日、时、分、秒
    });


    form.on("submit(updateClean)",function (data) {
        var index=top.layer.msg("数据提交中，请稍候",{icon:16,time:false,shade:0.2});
        // var index1=parent.layer.getFrameIndex(window.name); //这是获得的 学生列表 这个窗口？
        var msg;
        // var flag=false;
        $.ajax({
            type:"post",
            async:false,
            url:ctx+"/clean/updateClean",
            data:data.field,  //
            // Student.java 中 birthday属性前必须有
            // @DateTimeFormat(pattern = "yyyy-MM-dd") 很重要 必须加上 不然jsp中
            // 数据类型和这里绑定不了 ajax请求进入不了controller
            //createTime前也要有@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            dataType:"json",
            success:function (d) {
                if(d.code==0)
                {
                    msg="打扫记录更新成功";
                    // flag=true;
                }
                else
                {
                    msg=d.msg;
                }
            } ,
            error:function () {
                layer.msg("错误，请检查sql及输出",{icon:2});
                // layer.closeAll();
            }
        });
        setTimeout(function () {
            top.layer.msg(msg, { shift: -1, time: 2000 },function () {
                parent.location.reload();  //shift: -1表示提示信息不抖动 2秒后调用回调函数
            });
        },2000);  //在点击提交后2秒执行 setTimeout中的function函数
        return false;

    });


});




// 格式化时间
function formatTime(datetime, fmt) {
    if (datetime == null || datetime == 0) {
        return "";
    }
    if (parseInt(datetime) == datetime) {
        if (datetime.length == 10) {
            datetime = parseInt(datetime) * 1000;
        } else if (datetime.length == 13) {
            datetime = parseInt(datetime);
        }
    }
    datetime = new Date(datetime);
    var o = {
        "M+" : datetime.getMonth() + 1, // 月份
        "d+" : datetime.getDate(), // 日
        "h+" : datetime.getHours(), // 小时
        "m+" : datetime.getMinutes(), // 分
        "s+" : datetime.getSeconds(), // 秒
        "q+" : Math.floor((datetime.getMonth() + 3) / 3), // 季度
        "S" : datetime.getMilliseconds()
        // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1,
                (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
                    .substr(("" + o[k]).length)));
    return fmt;
}





