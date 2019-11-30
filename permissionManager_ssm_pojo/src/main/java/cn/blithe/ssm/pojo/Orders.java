package cn.blithe.ssm.pojo;

import cn.blithe.ssm.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Orders
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/23 22:36
 * @Version 1.0
 **/
public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;  //订单状态(0 未支付 1 已支付)
    private String orderStatusStr;
    private int peopleCount;
    private Product product; //产品信息
    private List<Traveller> travellers;  //游客信息
    private Member member; //会员信息
    private Integer payType;//支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;
    private String orderDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime != null){
            orderTimeStr = DateUtils.date2String(orderTime,"yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        if(!"".equals(orderStatus)){
            if(orderStatus == 0){
                orderStatusStr = "未支付";
            }
            if(orderStatus == 1){
                orderStatusStr = "已支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    //支付方式(0 支付宝 1 微信 2其它)
    public String getPayTypeStr() {
        if(payType == 0){
            payTypeStr = "支付宝";
        } else if(payType == 1){
            payTypeStr = "微信";
        }else{
            payTypeStr="其它";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}