layui.use(['form','layer','jquery','laydate'],function () {
    var layer=parent.layer===undefined?layui.layer:parent.layer;
    var $=layui.jquery,form=layui.form,laydate=layui.laydate;

    laydate.render({
        elem:'#payStartTime',
        type:'datetime'
    });
    laydate.render({
        elem:'#payEndTime',
        type:'datetime'
    });



    form.on("submit(addWPay)",function (data) {
        var index=top.layer.msg('数据提交中，请稍候。',{icon:16,time:false,shade:0.8});
        var msg;
        $.ajax({
            type: "post",
            url:ctx+"/pay/insWPay",
            data:data.field,
            dataType:"json",
            success:function (d) {
                if(d.code==0)
                {
                    msg="添加成功!";
                }
                else
                {
                    msg=d.msg;
                }
            },
            error:function (jqXHR, textStatus, errorThrown) {
                layer.alert("获取数据失败! 先检查sql 及 Tomcat Localhost Log 的输出");
            }


        });

        setTimeout(function () {
            //  top.layer.msg(msg);

            top.layer.msg(msg, { shift: -1, time: 2000 },function () {
                parent.location.reload();  //shift: -1表示提示信息不抖动 2秒后调用回调函数
            });
        },2000);  //在点击提交后2秒执行 setTimeout中的function函数



        return false;
    })

});