var opts = {
    num_edge_entries: 2,
    num_display_entries: 4,
    items_per_page: 10,
    current_page: 0
};
var typeStr = ""
$(function(){
    $('.aboutMe_00').attr("class", "nav-item start active open");

    $('.aboutMe_01').attr("class", "nav-item start active open");
    $('.ui.dropdown').dropdown();
    showDate();
    //进入页面时加载第一页数据 并初始化分页控件
    queryData(opts.current_page + 1,opts.items_per_page)

    $('#submitEditBtn').on('click',function(){
        submitFunction('/compoent/change')
    })

    $('#submitBtn').on('click',function(){
        submitFunction('/compoent/insert')
    })

    $("#addCompoentClassify").on('change',function () {

        $.ajax({
            type: 'POST',
            url: "/compoent/queryType",
            data:{
                classify:$("#addCompoentClassify").val(),
            },
            success:function(data){
                if(data.code=="0000"){
                    var menuSelect = $("#addCompoentType")
                    // alert(data.code);
                    // alert(data.data[0].cMenuName);
                    menuSelect.empty();
                    var lists = data.data;
                    for(var i in lists){
                        var option=$("<option>").val(lists[i].id).text(lists[i].typeName);
                        menuSelect.append(option);
                    }
                }
            }


        });
    })

    $("#editCompoentClassify").on('change',function () {

        $.ajax({
            type: 'POST',
            url: "/compoent/queryType",
            data:{
                classify:$("#editCompoentClassify").val(),
            },
            success:function(data){
                if(data.code=="0000"){
                    var menuSelect = $("#editCompoentType")
                    // alert(data.code);
                    // alert(data.data[0].cMenuName);
                    menuSelect.empty();
                    var lists = data.data;
                    for(var i in lists){
                        var option=$("<option>").val(lists[i].id).text(lists[i].typeName);
                        menuSelect.append(option);
                    }
                }
            }


        });
    })

    $("#compoentClassify").on('change',function () {

        $.ajax({
            type: 'POST',
            url: "/compoent/queryType",
            data:{
                classify:$("#compoentClassify").val(),
            },
            success:function(data){
                if(data.code=="0000"){
                    var menuSelect = $("#compoentType")
                    // alert(data.code);
                    // alert(data.data[0].cMenuName);
                    menuSelect.empty();
                    var lists = data.data;
                    var oneId = ""
                    for(var i in lists){
                        var option=$("<option>").val(lists[i].id).text(lists[i].typeName);
                        menuSelect.append(option);
                    }


                }
            }


        });
    })
})




var showDate= function(){
    var date=new Date();
    var year=date.getFullYear();
    var month = date.getMonth()+1;
    var day = date.getDate();
    var str;
    var week = date.getDay();
    switch (week) {
        case 0:
            str = '日';
            break;
        case 1:
            str = '一';
            break;
        case 2:
            str = '二';
            break;
        case 3:
            str = '三';
            break;
        case 4:
            str = '四';
            break;
        case 5:
            str = '五';
            break;
        case 6:
            str = '六';
            break;
    }
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    var mydate =year+'-'+month+'-'+day ;
    var myday='今天是星期'+str;
    $("#day").text(myday);
    $("#data").text(mydate);
}
// var queryBtn = function () {
//     queryData(1,opts.items_per_page)
// }
//
var queryData = function(page,size){
    typeStr = $("#compoentType").val()
    var url = '/compoent/data'
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data:{
            // 需要传到后台的值，可带参进行分页
            name:$("#compoentName").val(),
            type:typeStr,
            classify:$("#compoentClassify").val(),
            pageNumber: page,
            pageSize: size
        },
        success: function(data){
            //加载内容到页面中
            var html = '';
            $('#content').text(html)
            if(data.code == '0000'){
                var content = data.data.list
                for (i in content){
                    html += '<tr>'
                    html += ('<td nowrap="nowrap">'+content[i].name+'</td>')
                    // html += ('<td nowrap="nowrap">'+content[i].type+'</td>')
                    // html += ('<td nowrap="nowrap">'+content[i].introduce+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].numbers+'</td>')
                    html += ('<td nowrap="nowrap">')
                    html += ('<div class="ui primary button" onclick="delate(\''+content[i].id+'\')">删除</div>')
                    html += ('<div class="ui primary button" onclick="edit(\''+content[i].id+'\')">修改</div>')
                    html += ('</td>')
                    html += '</tr>'
                }
                $('#content').append(html)
                $('#usersCount').text("查询出数目："+data.data.total);
            }else{
                cautionModal(data.message)
            }
            //mybatis需要将data.data.number 减 1，JPA不需要做操作
            opts.current_page = data.data.pageNum-1
            //每次成功请求后会重新初始化分页控件
            $('#page').pagination(data.data.total,opts);
        }
    });
}

var edit = function(id){

    $("#edit").load('demo_ajax_load.txt');

    var url ="/compoent/findOne/" + id;
    $.ajax({
        url:url,
        type: 'post',
        dataType: 'json',
        success: function(data){
            $('#edit')
                .modal('setting', 'closable', false)
                .modal('show');
            if($('.modal').hasClass('scrolling')===false) {
                $('#edit').addClass('scrolling');
            }
            if(data.code == '0000'){
                var result = data.data;
                for(var i in result){
                    $("#programId").val(result[i].id),
                        $('#editCompoentType').dropdown('set selected',result[i].type);
                        $('#editCompoentClassify').dropdown('set selected',result[i].classify);
                        $("#editCompoentName").val(result[i].name),
                            $("#editCompoentNumber").val(result[i].numbers),
                        $("#editIntroduce").val(result[i].introduce)
                }

            }else {
                cautionModal(data.message)
            }
        }
    })
}

var delate = function(id){
    var url ="/compoent/delete/"+id
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        success: function(data){
            if (data.code == '0000'){
                cautionModal("删除成功")
                queryData(opts.current_page + 1,opts.items_per_page)
            }else{
                cautionModal(data.message)
            }
        }
    })
}
var queryBtn = function(){
    queryData(1,10)
}
var addBtn = function () {
    $('#add')
        .modal('show')
    ;
}

var submitFunction = function (url) {

    if(url =="/compoent/insert"){
        $.ajax({
            url: url,
            type: 'post',
            dataType: 'json',
            data: {
                type:$("#addCompoentType").val(),
                classify:$("#addCompoentClassify").val(),
                name:$("#addCompoentName").val(),
                numbers:$("#addCompoentNumber").val(),
                introduce:$("#addIntroduce").val(),
            },
            success: function (data) {
                if(data.code==0000){
                    $('#add')
                        .modal('hide')
                    ;
                    cautionModal("操作成功")

                    $("#addForm").form('clear');
                    queryData( opts.current_page + 1,opts.items_per_page)
                }
            }
        });

    }else{
        $.ajax({
            url: url,
            type: 'post',
            dataType: 'json',
            data: {
                id:$("#programId").val(),
                classify:$("#editCompoentClassify").val(),
                type:$("#editCompoentType").val(),
                name:$("#editCompoentName").val(),
                numbers:$("#editCompoentNumber").val(),
                introduce:$("#editIntroduce").val()
            },
            success: function (data) {
                if(data.code==0000){
                    $('#add')
                        .modal('hide')
                    ;
                    cautionModal("操作成功")

                    $("#editForm").form('clear');
                    queryData( opts.current_page +1,opts.items_per_page)
                }
            }
        });
    }



}

var hideCautionModal = function () {
    $('#cautionModal')
        .modal('hide')
    ;
}
var cancleBtn = function () {
    $('#add')
        .modal('hide')
    ;
}
var cancleEditBtn = function () {
    $('#edit')
        .modal('hide')
    ;
}

var _load=$.fn.load;
$.fn.extend({
    load:function(url,param,calbck){
        //其他操作和处理
        //..
        if(url==null||url==""){
            alert("buxing ")
            return ;
        }
        //此处用apply方法调用原来的load方法，因为load方法属于对象，所以不可直接对象._load（...）
        return _load.apply(this,[url,param,calbck]);
    }
});
