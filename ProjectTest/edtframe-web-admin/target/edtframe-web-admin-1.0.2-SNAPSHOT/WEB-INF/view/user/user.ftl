<!DOCTYPE HTML>
<html>
<head>
    <#include "../common.ftl">
    <title>用户管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;
		</span>系统管理<span class="c-gray en">&gt;</span>用户管理<a
        class="btn btn-success radius r"
        style="line-height:1.6em;
	margin-top:3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i> </a>
</nav>
<div class="page-container">
    <div class="cus_hei_30">
        <@shiro.hasPermission name='101'>
            <button name="" id="addBtn" class="btn btn-primary radius"
                    type="button">
                <i class="Hui-iconfont">&#xe600;</i>&nbsp;添加用户
            </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name='106'>
            <button name="" id="dustbinBtn" class="btn btn-success"
                    type="button">
                <i class="Hui-iconfont">&#xe600;</i>恢复删除用户
            </button>
        </@shiro.hasPermission>
        <span class="f-r"> <input type="text" name="name"
                                  id="name" placeholder="用户姓名"
                                  class="input-text cus_wid_250 radius">
				<button id="searchBtn" class="btn btn-success radius"
                        type="button">
					<i class="Hui-iconfont">&#xe665;</i>&nbsp;查询
				</button>
			</span>
    </div>
    <div class="mt-20">
        <table id="tableList"
               class="table table-striped table-border table-bordered table-bg table-hover table-sort">
            <thead>
            <tr class="text-c">
                <th width="30">序号</th>
                <th width="80">id</th>
                <th width="40">账号</th>
                <th width="40">姓名</th>
                <th width="40">机构名称</th>
                <th width="40">角色名称</th>
                <th width="50">用户状态</th>
                <th width="40">添加人</th>
                <th width="40">添加时间</th>
                <th width="120">操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/user/user.js"></script>
<script type="text/javascript">
    function initUserTable() {
        table = $('#tableList')
                .dataTable(
                        {
                            "searching": false,
                            "lengthChange": false,
                            "processing": true,
                            "ordering": false,
                            "serverSide": true,
                            "pageLength": ${pageLength},
                            "pagingType": "full_numbers",
                            "ajax": {
                                "type": "post",
                                "url": ctx + "/user/getUserByConditon",
                                "data": {
                                    deleteFlag: 2
                                }
                            },
                            "columns": [{
                                "data": null,
                                "targets": 0
                            }, {
                                "data": "id",
                                "visible": false
                            }, {
                                "data": "loginId"
                            }, {
                                "data": "name"
                            }, {
                                "data": "mechanismsName"
                            }, {
                                "data": "roleName"
                            }, {
                                "data": "activeName"
                            }, {
                                "data": "addUser"
                            }, {
                                "data": "addTime"
                            }],
                            "createdRow": function (row, data, index) {
                                if (data.activeName == "启用") {
                                    $('td', row).eq(5).html(
                                            '<span class=\"label label-primary radius\">' + data.activeName + '</span>');
                                } else {
                                    $('td', row).eq(5).html(
                                            '<span class=\"label label-danger radius\">' + data.activeName + '</span>');
                                }
                            },
                            "columnDefs": [{
                                "targets": [9],
                                "data": "id",
                                "render": function (data, type, full) {
                                    var updateUser = "<@shiro.hasPermission name='102'><a href='javascript:void(0)'"
                                            + "onClick=toUpdate('" + data + "')>修改</a>&nbsp;&nbsp;"
                                            + "</@shiro.hasPermission>";
                                    var deleteUser = "<@shiro.hasPermission name='103'><a href='javascript:void(0)'"
                                            + "onClick=toDelete('" + data + "')>删除</a>&nbsp;&nbsp;"
                                            + "</@shiro.hasPermission>";
                                    var updateUserState;
                                    if ("启用" == full.activeName) {
                                        updateUserState = "<@shiro.hasPermission name='104'><a href='javascript:void(0)'"
                                                + "onClick=updateState('" + data + "','1')>禁用</a>&nbsp;&nbsp;"
                                                + "</@shiro.hasPermission>";
                                    } else {
                                        updateUserState = "<@shiro.hasPermission name='104'><a href='javascript:void(0)'"
                                                + "onClick=updateState('" + data + "','2')>启用</a>&nbsp;&nbsp;"
                                                + "</@shiro.hasPermission>";
                                    }
                                    var restPwd = "<@shiro.hasPermission name='105'><a href='javascript:void(0)' "
                                            + "onClick=resetLoginPassword('" + data + "')>重置密码</a></@shiro.hasPermission>";

                                    return updateUser + deleteUser + updateUserState + restPwd;
                                }
                            }],
                            "fnDrawCallback": function () {
                                var api = this.api();
                                var startIndex = api.context[0]._iDisplayStart;// 获取到本页开始的条数
                                api.column(0).nodes().each(
                                        function (cell, i) {
                                            cell.innerHTML = startIndex + i + 1;
                                        });
                            }
                        });
    }
</script>
</body>
</html>
