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
    $('#compoentType').dropdown();
    showDate();
    //进入页面时加载第一页数据 并初始化分页控件
    queryData(opts.current_page + 1,opts.items_per_page)

    $('#submitEditBtn').on('click',function(){
        submitFunction('/compoent/change')
    })

    $('#submitBtn').on('click',function(){
        submitFunction('/compoent/insert')
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
                    html += ('<td nowrap="nowrap">'+content[i].type+'</td>')
                    html += ('<td nowrap="nowrap">'+content[i].introduce+'</td>')
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
                        $("#editCompoentType").val(result[i].type),
                        $("#editCompoentName").val(result[i].name),
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
                name:$("#addCompoentName").val(),
                introduce:$("#addIntroduce").val(),
            },
            success: function (data) {
                if(data.code==0000){
                    $('#add')
                        .modal('hide')
                    ;
                    cautionModal("操作成功")
                    $.ajax({
                        url: '/compoent/queryType',
                        type: 'post',
                        dataType: 'json',
                        data: {
                        },
                        success: function (data) {
                            if(data.code==0000){
                                var selectValue =  $("#compoentType")
                                selectValue.empty()
                                var contents = data.data
                                for(var i=0; i<contents.length;i++){
                                    var option ="<option value='"+contents[i]+"'>"+contents[i]+"</option>"
                                    selectValue.append(option)
                                }
                                $("#compoentType").dropdown('set selected',typeStr)
                            }
                        }
                    });
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
                type:$("#editCompoentType").val(),
                name:$("#editCompoentName").val(),
                introduce:$("#editIntroduce").val()
            },
            success: function (data) {
                if(data.code==0000){
                    $('#add')
                        .modal('hide')
                    ;
                    cautionModal("操作成功")
                    $.ajax({
                        url: '/compoent/queryType',
                        type: 'post',
                        dataType: 'json',
                        data: {
                        },
                        success: function (data) {
                            if(data.code==0000){
                                var selectValue =  $("#compoentType")
                                selectValue.empty()
                                var contents = data.data
                                for(var i=0; i<contents.length;i++){
                                    var option ="<option value='"+contents[i]+"'>"+contents[i]+"</option>"
                                    selectValue.append(option)
                                }
                                $("#compoentType").dropdown('set selected',typeStr)
                            }
                        }
                    });
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
