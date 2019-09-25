<!DOCTYPE HTML>
<html>
<head>
    <#include "../common.ftl">
    <title>Title</title>
    <script>
        /*跳转新增页面*/
        function toAdd() {
            layer.open({
                type: 2,
                area: ['800px', '500px'],
                fix: false, // 不固定
                maxmin: false,
                shade: 0.4,
                title: '测试添加',
                content: ctx + '/redirect?page=order/orderAdd',
                end: function () {
                    table.api().ajax.reload();
                }
            });
        }

        /*跳转修改页面*/
        function toUpdate(orderId) {
            layer.open({
                type: 2,
                area: ['800px', '500px'],
                fix: false, // 不固定
                maxmin: false,
                shade: 0.4,
                title: '用户修改',
                content: ctx + '/order/getOrderById?orderId=' + orderId,
                end: function () {
                    table.api().ajax.reload(null, false);
                }
            });
        }

        /*删除*/
        function remove(orderId) {
            layer.confirm('确定要删除此条数据么？', {
                btn: ['确定', '取消']
                // 按钮
            }, function () {
                $.ajax({
                    type: "POST",
                    url: ctx + '/order/deleteOrder',
                    data: {
                        'orderId': orderId,
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
    </script>
</head>
<body>
<div>
    <form action="${ctx}/order/getAllOrder" method="post">
        <table id="tableList">
            <tr>
                <input type="button" value="新增" onclick="toAdd();"/>
                <input type="submit" value="查询"/>
            </tr>
            <thead>
            <tr>
                <th>订单编号</th>
                <th>订单名字</th>
                <th>订单时间</th>
                <th>订单金额</th>
                <th>订单描述</th>
                <th>操作</th>
            </tr>
            </thead>
        </table>
    </form>
</div>
</body>
<script>
    var table;
    $(function () {
        initUserTable();
    });
</script>
<script type="text/javascript">
    function initUserTable() {
        table = $('#tableList')
                .dataTable(
                        {
                            "searching": false,
                            "lengthChange": false,
                            "processing": false,
                            "ordering": false,
                            "serverSide": false,
                            "pageLength": 3,
                            "pagingType": "full_numbers",
                            "ajax": {
                                "type": "post",
                                "url": ctx + "/order/getAllOrder",
                                "data": {
                                    deleteFlag: 2
                                }
                            },
                            "columns": [{
                                "data": "orderId"
                            }, {
                                "data": "orderName"
                            }, {
                                "data": "orderTime"
                            }, {
                                "data": "orderMoney"
                            }, {
                                "data": "orderDescription"
                            }],
                            "columnDefs": [{
                                "targets": [5],
                                "data": "orderId",
                                "render": function (data, type, full) {
                                    var updateUser = "<@shiro.hasPermission name='102'><a href='javascript:void(0)'"
                                            + "onClick=toUpdate('" + data + "')>修改</a>&nbsp;&nbsp;"
                                            + "</@shiro.hasPermission>";
                                    var deleteUser = "<@shiro.hasPermission name='103'><a href='javascript:void(0)'"
                                            + "onClick=remove('" + data + "')>删除</a>&nbsp;&nbsp;"
                                            + "</@shiro.hasPermission>";
                                    return updateUser + deleteUser;
                                }
                            }]
                        });
    }
</script>
</html>
