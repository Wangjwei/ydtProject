<!DOCTYPE HTML>
<html>
<head>
    <#include "../common.ftl">
    <title>Title</title>
    <script>
        function addOrder() {
            $.ajax({
                type: "POST",
                url: ctx + '/order/saveOrder',
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
    </script>
</head>
<body>
<form action="" method="post" id="form">
    订单名字：<input type="text" name="orderName" id="orderName"><br>
    订单时间：<input type="text" name="orderTime" id="orderTime"><br>
    订单金额：<input type="text" name="orderMoney" id="orderMoney"><br>
    订单描述：<input type="text" name="orderDescription" id="orderDescription"><br>
    <input type="button" value="新增" onclick="addOrder();"/>
</form>
</body>
</html>
