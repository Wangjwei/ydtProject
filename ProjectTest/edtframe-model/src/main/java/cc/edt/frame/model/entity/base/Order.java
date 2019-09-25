package cc.edt.frame.model.entity.base;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {

    private int orderId;
    private String orderName;
    private Date orderTime;
    private Double orderMoney;
    private String orderDescription;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderTime=" + orderTime +
                ", orderMoney=" + orderMoney +
                ", orderDescription='" + orderDescription + '\'' +
                '}';
    }

    public Order(String orderName, Date orderTime, Double orderMoney, String orderDescription) {
        this.orderName = orderName;
        this.orderTime = orderTime;
        this.orderMoney = orderMoney;
        this.orderDescription = orderDescription;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
