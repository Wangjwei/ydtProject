<#include "../common.ftl">
<!DOCTYPE HTML>
<html>
<head>
    <#include "../common.ftl">
    <title>Title</title>
    <script>
        function updateOrder() {
            layer.confirm('确定要修改此条数据么？', {
                btn: ['确定', '取消']
                // 按钮
            }, function () {
                $.ajax({
                    type: "POST",
                    url: ctx + '/order/updateOrder',
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
    </script>
</head>
<body>
<form action="" method="post" id="form">
    <input type="hidden" id="orderId" name="orderId" value="${order.orderId }">
    订单名字：<input type="text" name="orderName" value="${order.orderName}"><br>
    订单时间：<input type="text" name="orderTime" value="${order.orderTime}"><br>
    订单金额：<input type="text" name="orderMoney" value="${order.orderMoney}"><br>
    订单描述：<input type="text" name="orderDescription" value="${order.orderDescription}"><br>
    <input type="button" value="修改" onclick="updateOrder();"/>
</form>
</body>
</html>
