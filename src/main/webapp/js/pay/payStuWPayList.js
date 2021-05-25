
layui.config({
    base:ctx+"/js/"
}).use(['form','layer','jquery','excel','laypage','table'],function () {
    var form=layui.form,table=layui.table,
        layer=parent.layer===undefined?layui.layer:parent.layer,
        laypage=layui.laypage;
    $=layui.jquery;
    var excel=layui.excel;



    //数据表格
    table.render({
        id:'wpayList',
        elem:'#wpayList',
        url:ctx+"/pay/getStuWPayList", //数据接口
        cellMinWidth:80,
        //toolbar:true,
        //title:'打扫记录表',
        //totalRow:true,
        limit:10,//每页条数
        limits:[10,20,30,40],
        cols:[[ //表头
            {field:'payId',title:'ID',sort:true,align:'center',width:120},

            {field:'payStartTime', title: '缴费计算时间起' ,align: 'center',templet : '<div>{{ formatTime(d.payStartTime,0,"yyyy-MM-dd hh:mm:ss")}}</div>' },
            {field:'payEndTime', title: '缴费计算时间止' ,align: 'center',templet : '<div>{{ formatTime(d.payEndTime,0,"yyyy-MM-dd hh:mm:ss")}}</div>' },


            {field:'payStatus',title:'缴费状况',align:'center',width:110,templet:'#payStatus'},
          //  {field:'payName',title:'缴费项目',align:'center',width:110,templet:'#payName'},

            {field:'dormitoryNumber',title:'房间编号',align:'center',templet: '<div>{{d.dormitory.dormitoryNumber}}</div>'},


         //   {field:'username',title:'缴费人',align:'center',templet: '<div>{{d.user.username}}</div>'},
            {field:'total',title:'费用合计',sort:true,align:'center',width:150},
            {title:'操作',toolbar:'#barEdit',align:'center'}
        ]],
        page:true
    });
    //监听工具条
    table.on('tool(wpayList)',function (obj) {
        var data=obj.data;
        if(obj.event=='edit')
        {

            layer.open({
                type:2,
                title:"确认交费",
                area:['400px','300px'],
               // content:ctx+"/pay/userPay/"+data.payId
                content:ctx+"/pay/stuWPay/"+data.payId
            })
        }
    });

});


//格式化时间 后台穿过来的是 CST时间格式 前台转化成yyyy-MM-dd hh:mm:ss 格式
function formatTime(datetime,datetime1, fmt) {
    if(datetime==datetime1) //因为登录后 loginTime 和logoutTime一样 这样 转换logoutTime的时候显示为空
    {
        return "";
    }
    if (datetime == null || datetime == 0) {
        return "";
    }
    if (parseInt(datetime) == datetime)
    {
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