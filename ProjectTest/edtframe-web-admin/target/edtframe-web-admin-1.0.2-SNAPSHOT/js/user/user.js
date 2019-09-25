var table;
$(function () {
    initUserTable();
    $("#addBtn").click(function () {
        add();
    });
    $("#dustbinBtn").click(function () {
        dustbin();
    });
    $("#searchBtn").click(function () {
        search();
    });
});

function add() {
    layer.open({
        type: 2,
        area: ['800px', '500px'],
        fix: false, // 不固定
        maxmin: false,
        shade: 0.4,
        title: '用户添加',
        content: ctx + '/redirect?page=user/userAdd',
        end: function () {
            table.api().ajax.reload();
        }
    });
}

function dustbin() {
    layer.open({
        type: 2,
        area: ['850px', '500px'],
        fix: false, // 不固定
        maxmin: false,
        shade: 0.4,
        title: '用户垃圾箱',
        content: ctx + '/redirect?page=user/userDustbin',
        end: function () {
            table.api().ajax.reload(null, false);
        }
    });
}

function toUpdate(id) {
    layer.open({
        type: 2,
        area: ['800px', '500px'],
        fix: false, // 不固定
        maxmin: false,
        shade: 0.4,
        title: '用户修改',
        content: ctx + '/user/toUpdateUser?id=' + id,
        end: function () {
            table.api().ajax.reload(null, false);
        }
    });
}

function toDelete(userid) {
    layer.confirm('确定要删除此条数据么？', {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        $.ajax({
            type: "POST",
            url: ctx + '/user/updateDeleteFlag',
            data: {
                'id': userid,
                'deleteFlag': 1
            },
            cache: false,
            async: true,
            success: function (data) {
                var result = $.parseJSON(data);
                layer.alert(result.message);
                table.api().ajax.reload(null, false);
            }
        });
    });
}

function search() {
    table.fnSettings().ajax.data = {
        "name": $("#name").val(),
        "deleteFlag": "2"
    };
    var url = ctx + '/user/getUserByConditon';
    table.api().ajax.url(url).load();
}

/*
 * 设置用户状态
 */
function updateState(userid, state) {
    var confirm = "";
    if ("2" === state) {
        confirm = "确定要启用该用户吗？";
    } else {
        confirm = "确定要禁用该用户吗？";
    }
    layer.confirm(confirm, {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        $.ajax({
            type: "POST",
            url: ctx + '/user/updateState',
            data: {
                'id': userid,
                'active': state
            },
            cache: false,
            async: true,
            success: function (data) {
                var result = $.parseJSON(data);
                layer.alert(result.message);
                table.api().ajax.reload(null, false);
            }
        });
    });
}

function resetLoginPassword(userid) {
    layer.confirm('确定要重置该用户的密码吗？', {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        $.ajax({
            type: "POST",
            url: ctx + '/user/resetLoginPassword',
            data: {
                'id': userid
            },
            cache: false,
            async: true,
            success: function (data) {
                var result = $.parseJSON(data);
                if (result.success) {
                    layer.alert(result.message);
                }
                table.api().ajax.reload(null, false);
            },
        });
    });
}
