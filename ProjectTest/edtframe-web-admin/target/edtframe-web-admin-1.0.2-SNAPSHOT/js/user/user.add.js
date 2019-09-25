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
$(function () {
    $("#roleId").select2();
    createTree();
    initFormValid();
    initRole();
});

/*
创建机构树形菜单
 */
function createTree() {
    $.ajax({
        url: ctx + '/mechanisms/getMechanismsUserTree',
        type: 'POST',
        success: function (data) {
            jQuery.fn.zTree.init(jQuery("#userTree"), setting, eval('('
                + data + ')'));
            var treeObj = jQuery.fn.zTree.getZTreeObj("userTree");
            treeObj.expandAll(false);
        },
        error: function (msg) {
            layer.alert(msg);
        }
    });
}

/*
单击树形节点
 */
function userTreeOnClick(event, treeId, treeNode) {
    //设置所属地市信息
    $("#parentName").val(treeNode.name);
    $("#mechanismsId").val(treeNode.id);
}

/*
单击树形check
 */
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
            roleId.empty();
            var result = $.parseJSON(data);
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
            },
            loginPassword: {
                required: true
            },
            userAddPassword2: {
                required: true,
                equalTo: "#userAddPassword"
            }, parentName: {
                required: true,
                minlength: 2,
                maxlength: 32
            }
        },
        submitHandler: function (form) {
            save();
        }
    });
}

function save() {
    $.ajax({
        type: "POST",
        url: ctx + '/user/saveUser',
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
}
