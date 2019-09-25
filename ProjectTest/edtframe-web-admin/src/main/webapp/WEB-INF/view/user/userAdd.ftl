<!DOCTYPE HTML>
<html>
<head>
    <#include "../common.ftl">
    <title></title>
</head>
<body>
<article class="page-container">
    <form class="form form-horizontal" id="form">
    <#--<input type="text" name="token" value="${TOKEN}" /> -->
        <input type="hidden" id="userMechanismsRights" name="userMechanismsRights" value="">
        <div class="col-sm-4 style_tree_scroll">
            <ul id="userTree" class="ztree"></ul>
        </div>
        <div class="col-sm-8">
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3 cus_font-normal"><span
                        class="c-red">*</span>登录账号：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="text" class="input-text radius" value=""
                           placeholder="登陆账号" id="userAddLoginId" name="loginId">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3 cus_font-normal"><span
                        class="c-red">*</span>初始密码：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="password" class="input-text radius"
                           autocomplete="off" value="" placeholder="密码" id="userAddPassword"
                           name="loginPassword">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3 cus_font-normal"><span
                        class="c-red">*</span>确认密码：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="password" class="input-text radius"
                           autocomplete="off" placeholder="确认新密码" id="userAddPassword2"
                           name="userAddPassword2">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3 cus_font-normal"><span
                        class="c-red">*</span>姓名：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="text" class="input-text radius" value=""
                           placeholder="姓名" id="userAddName" name="name">
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
                    <input type="text" class="style_input-disabled radius" value=""
                           placeholder="所属地市" id="parentName" name="parentName"
                           readonly="readonly">
                    <input type="hidden" class="style_input-disabled radius" value="" placeholder="机构id"
                           id="mechanismsId" name="mechanismsId" readonly="readonly">
                </div>
            </div>
            <div class="row cl">
                <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                    <input id="saveUserAdd" class="btn btn-primary cus_wid_70 radius"
                           type="submit" value="提&nbsp;交">
                    <input id="closeWindow" class="btn btn-primary cus_wid_70 radius"
                           type="button" value="关&nbsp;闭">
                </div>
            </div>
        </div>
    </form>
</article>
<script type="text/javascript" src="${ctx}/js/user/user.add.js"></script>
</body>
</html>
