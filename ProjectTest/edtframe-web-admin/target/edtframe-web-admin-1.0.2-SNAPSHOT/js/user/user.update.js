var $accountSelect = $("#wxAccountSelect");
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: 0
        },
        key: {
            name: "name"
        }
    }, check: {
        enable: true,
        chkStyle: "checkbox",
        chkboxType: {
            "Y": "s",
            "N": "s"
        }
    },
    callback: {
        onClick: userTreeOnClick,
        onCheck: userTreeOnCheck
    }
};

function userTreeOnClick(event, treeId, treeNode) {
    $("#parentName").val(treeNode.name);
    $("#mechanismsId").val(treeNode.id);
}

function userTreeOnCheck(event, treeId, treeNode) {
    var treeObj = jQuery.fn.zTree.getZTreeObj("userTree");
    var nodes = treeObj.getCheckedNodes(true);
    var msg = "";
    for (var i = 0; i < nodes.length; i++) {
        if ((i + 1) === nodes.length) {
            msg += nodes[i].id;
        } else {
            msg += nodes[i].id + ",";
        }
    }
    jQuery('#userMechanismsRights').val(msg);
}

/*
 * 初始化表单验证
 */
function initFormValid() {
    $("#form").validate({
        rules: {
            loginId: {
                required: true,
                minlength: 2,
                maxlength: 32
            },
            name: {
                required: true,
                minlength: 2,
                maxlength: 32
            }
        },
        onkeyup: false,
        focusCleanup: true,
        success: "valid",
        submitHandler: function (form) {
            updateUser();
        }
    });
}

/*
 * 初始化角色数据
 */
function initRole() {
    var roleId = $("#roleId");
    $.ajax({
        type: "POST",
        url: ctx + '/role/getRoleByAll',
        cache: false,
        async: false,
        success: function (data) {
            var result = $.parseJSON(data);
            roleId.empty();
            if (result !== null && result.length > 0) {
                for (var i = 0; i < result.length; i++) {
                    roleId.append(
                        "<option value='" + result[i].id + "'>"
                        + result[i].name + "</option>");
                }
            }
        }
    });
}

function updateUser() {
    layer.confirm('确定要修改此条数据么？', {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        $.ajax({
            type: "POST",
            url: ctx + '/user/updateUser',
            data: $("#form").serialize(),
            cache: false,
            async: true,
            success: function (data) {
                var result = $.parseJSON(data);
                if (result.success) {
                    layer.alert(result.message, function (index) {
                        layer_close();
                    });
                } else {
                    layer.alert(result.message);
                }
            }
        });
    }, function () {

    });
}
