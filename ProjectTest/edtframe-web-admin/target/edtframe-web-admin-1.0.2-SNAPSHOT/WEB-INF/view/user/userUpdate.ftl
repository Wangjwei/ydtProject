<#include "../common.ftl">
<!DOCTYPE HTML>
<html>
<head>
    <#include "../common.ftl">
    <title></title>
</head>
<body>
<article class="page-container">
    <form class="form form-horizontal" id="form">
        <input type="hidden" id="id" name="id" value="${user.id }">
        <input type="hidden" id="userMechanismsRights" name="userMechanismsRights" value="${userMechanismsRights}">
        <div class="col-sm-4 style_tree_scroll">
            <ul id="userTree" class="ztree"></ul>
        </div>
        <div class="col-sm-8">
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3 cus_font-normal"><span
                        class="c-red">*</span>登录账号：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="text" class="style_input-disabled radius"
                           value="${user.loginId }" placeholder="" readonly="readonly"
                           id="userUpdateLoginId" name="loginId">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3 cus_font-normal"><span
                        class="c-red">*</span>姓名：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="text" class="input-text radius" placeholder=""
                           id="userUpdateName" name="name" value="${user.name}">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3 cus_font-normal"><span
                        class="c-red">*</span>角色：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <label for="roleId"></label>
                    <select id="roleId" class="select2 cus_wid_100b"
                            data-live-search="true" name="roleId" size="1"></select>
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3 cus_font-normal"><span
                        class="c-red">*</span>所属地市：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="text" class="style_input-disabled radius"
                           value="${user.mechanisms.name }" placeholder="所属地市"
                           id="parentName" name="parentName" readonly="readonly">
                    <input type="hidden" class="style_input-disabled radius" value="${user.mechanisms.id}"
                           placeholder="" id="mechanismsId" name="mechanismsId">
                </div>
            </div>
            <div class="row cl">
                <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                    <input id="saveUserUpdate"
                           class="btn btn-primary cus_wid_70 radius" type="submit"
                           value="提&nbsp;交">
                    <input id="closeWindow" class="btn btn-primary cus_wid_70 radius"
                           type="button" value="关&nbsp;闭">
                </div>
            </div>
        </div>
    </form>
</article>

<script type="text/javascript" src="${ctx}/js/user/user.update.js"></script>
<script type="text/javascript">
    $(function () {
        var roleId = $("#roleId").select2();
        createTree();
        initFormValid();
        initRole();
        roleId.val('${user.roleId}').trigger("change");
        roleId.change();
    });

    function createTree() {
        $.ajax({
            url: ctx + '/mechanisms/getMechanismsUserTree',
            type: 'POST',
            success: function (data) {
                jQuery.fn.zTree.init(jQuery("#userTree"), setting, eval('('
                        + data + ')'));
                var treeObj = jQuery.fn.zTree.getZTreeObj("userTree");
                treeObj.expandAll(false);
                var userMechanismsRights = "${userMechanismsRights}";
                var arrys = userMechanismsRights.split(",");
                if (userMechanismsRights !== "") {
                    for (var i = 0; i < arrys.length; i++) {
                        var node = treeObj.getNodeByParam("id", arrys[i],
                                null);
                        treeObj.checkNode(node, true, true);
                    }
                }
            },
            error: function (msg) {
                layer.alert(msg);
            }
        });
    }
</script>
</body>
</html>
