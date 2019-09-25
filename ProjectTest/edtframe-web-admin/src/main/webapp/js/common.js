var ctx = getRootPath();
var imgPath = "http://localhost:8080/res/";
//加载框下标，用于关闭时识别
var layerIndex;

/*
 * 全局ajax设置
 */
$.ajaxSetup({
    contentType: "application/x-www-form-urlencoded;charset=utf-8",
    type: "POST",
    complete: function (XMLHttpRequest, textStatus) {
        layer.close(layerIndex);
        var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
        switch (sessionstatus) {
            case "timeout":
                top.location.href = ctx + '/login';
                layer.alert("用户登陆超时,请重新登录");
                break;
        }
    },
    error: function (xhr, status, error) {
        layer.close(layerIndex);
        layer.alert("服务器繁忙，请稍后重试");
    },
    beforeSend: function () {
        layerIndex = layer.load(0, {
            icon: 16,
            shade: 0.01,
            time: 0,
        });
    }
});

/*
 * 获取项目根目录
 */
function getRootPath() {
    // 获取当前网址，如： http://localhost:8080/iceframe/view/center/jsps/user/user.jsp
    var curWwwPath = window.document.location.href;
    // 获取主机地址之后的目录，如：iceframe/view/center/jsps/user/user.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    // 获取主机地址，如： http://localhost:8080
    var localhostPaht = curWwwPath.substring(0, pos);
    // 获取带"/"的项目名，如：/iceframe
    var projectName = pathName
        .substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}


/*
 * 获取当前时间，格式YYYY-MM-DD
 */
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    return year + seperator1 + month + seperator1 + strDate;
}

Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};

$(function () {
    /*关闭当前窗口*/
    $("#closeWindow").click(function () {
        layer_close();
    });
});

function appendSkipPage() {
    var table = $(".table-sort").dataTable();
    var template =
        $("<div style='display: inline-block;'>" +
            "  <span style='padding:0px 6px 0 12px;'>跳转到</span>" +
            "  <input type='text' style='text-align:center;padding: 0; border: 1px solid #ccc; height:26px; line-height26px; font-size: 14px; width:40px; vertical-align: top;' />" +
            "  <a class='paginate_button next disabled' href='javascript:void(0)'> Go </a>" +
            "</div>");

    template.find("a").click(function () {
        var pn = template.find("input").val();
        if (pn > 0) {
            --pn;
        } else {
            pn = 0;
        }
        table.fnPageChange(pn);
    });
    $(".dataTables_paginate").append(template);
}

