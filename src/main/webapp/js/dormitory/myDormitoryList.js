
layui.use(['form','layer','jquery','laypage','table'],function () {
    var form=layui.form,table=layui.table,
        layer=parent.layer===undefined?layui.layer:parent.layer,
        laypage=layui.laypage;
    $=layui.jquery;
    //数据表格
    table.render({
        id:'dormitoryList',
        elem:'#dormitoryList',
        url:ctx+"/dormitory/getDormitoryList", //数据接口
        cellMinWidth:80,
        limit:10,//每页条数
        limits:[10,20,30,40],
        cols:[[ //表头
            {field:'dormitoryId',title:'ID',sort:true,align:'center',width:120},
            {field:'dormitoryPhoto',title:'宿舍图片',align:'center',width:110,templet: "#imgtmp"},
            {field:'dormitoryNumber',title:'宿舍名称',width:120,align:'center'},
            {field: 'username', title : '宿舍成员', width:360,templet:function(d){
                    return $.map(d.studentList,function(item, index){
                        return item.username
                    }).join(";")

                }
                ,align:'center'}
         //   {title:'操作',width:120,toolbar:'#barEdit',align:'center'}
        ]],
        page:true
    });




});