layui.use(['form','layer','jquery','laydate'],function () {
    var layer=parent.layer===undefined?layui.layer:parent.layer;
    var $=layui.jquery,form=layui.form,laydate=layui.laydate;

    laydate.render({
        elem:'#fixTime',
        type: 'datetime'
    });






    form.on("submit(addPay)",function (data) {
        var index=top.layer.msg('数据提交中，请稍候',{icon:16,time:false,shade:0.2});
        //  var index1=parent.layer.getFrameIndex(window.name); //获取 学生列表 窗口
        //  var msg,flag=false;
        var msg;
        $.ajax({
            type:"post",
            url:ctx+"/pay/insertStuWPay",
            async:false,
            data:data.field,
            dataType:"json",
            success:function (d) {
                if(d.code==0)
                {
                    msg="付款成功";
                }
                else
                {
                    msg=d.msg;
                }
            },
            error:function () {
                layer.msg("添加失败，请检查sql及输出",{icon:2});
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