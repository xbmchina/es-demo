package com.example.esdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@TableName("trade_000010")
public class Trade implements Serializable {

    private Long tradeId;
    private Long sellerId;
    private Long shopBuyerId;
    private String buyerNick;
    private Double receivedPayment;
    private Double postFee;
    private String receiverName;
    private String receiverAddress;
    private String receiverZip;
    private String receiverMobile;
    private Integer receiverMobileType;
    private Long tid;
    private Integer num;
    private String buyerMessage;
    private Integer sellerFlag;
    private String sellerMemo;
    private String status;
    private String tradeFrom;
    private String type;
    private String stepTradeStatus;
    private String stepPaidFee;
    private String buyerAlipayNo;
    private Double price;
    private Double discountFee;
    private Double totalFee;
    private Date created;
    private Date payTime;
    private Date modified;
    private Date consignTime;
    private Date endTime;
    private String shippingType;
    private String shippingName;
    private String shippingSid;
    private Integer shippingStatus;
    private Date shippingModified;//淘宝返回的物流修改时间
    private Date lastShippingUpdateTime;//MQ物流状态消息更新到数据库的时间
    private Integer rxAuditStatus;
    private Date lastSendTime;
    //签收时间
    private Date signTime;


    public static final class Builder {
        private Long tradeId;
        private Long sellerId;
        private Long shopBuyerId;
        private String buyerNick;
        private Double receivedPayment;
        private Double postFee;
        private String receiverName;
        private String receiverAddress;
        private String receiverZip;
        private String receiverMobile;
        private Integer receiverMobileType;
        private Long tid;
        private Integer num;
        private String buyerMessage;
        private Integer sellerFlag;
        private String sellerMemo;
        private String status;
        private String tradeFrom;
        private String type;
        private String stepTradeStatus;
        private String stepPaidFee;
        private String buyerAlipayNo;
        private Double price;
        private Double discountFee;
        private Double totalFee;
        private Date created;
        private Date payTime;
        private Date modified;
        private Date consignTime;
        private Date endTime;
        private String shippingType;
        private String shippingName;
        private String shippingSid;
        private Integer shippingStatus;
        private Date shippingModified;//淘宝返回的物流修改时间
        private Date lastShippingUpdateTime;//MQ物流状态消息更新到数据库的时间
        private Integer rxAuditStatus;
        private Date lastSendTime;
        //签收时间
        private Date signTime;

        private Builder() {
        }

        public static Builder aTrade() {
            return new Builder();
        }

        public Builder tradeId(Long tradeId) {
            this.tradeId = tradeId;
            return this;
        }

        public Builder sellerId(Long sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public Builder shopBuyerId(Long shopBuyerId) {
            this.shopBuyerId = shopBuyerId;
            return this;
        }

        public Builder buyerNick(String buyerNick) {
            this.buyerNick = buyerNick;
            return this;
        }

        public Builder receivedPayment(Double receivedPayment) {
            this.receivedPayment = receivedPayment;
            return this;
        }

        public Builder postFee(Double postFee) {
            this.postFee = postFee;
            return this;
        }

        public Builder receiverName(String receiverName) {
            this.receiverName = receiverName;
            return this;
        }

        public Builder receiverAddress(String receiverAddress) {
            this.receiverAddress = receiverAddress;
            return this;
        }

        public Builder receiverZip(String receiverZip) {
            this.receiverZip = receiverZip;
            return this;
        }

        public Builder receiverMobile(String receiverMobile) {
            this.receiverMobile = receiverMobile;
            return this;
        }

        public Builder receiverMobileType(Integer receiverMobileType) {
            this.receiverMobileType = receiverMobileType;
            return this;
        }

        public Builder tid(Long tid) {
            this.tid = tid;
            return this;
        }

        public Builder num(Integer num) {
            this.num = num;
            return this;
        }

        public Builder buyerMessage(String buyerMessage) {
            this.buyerMessage = buyerMessage;
            return this;
        }

        public Builder sellerFlag(Integer sellerFlag) {
            this.sellerFlag = sellerFlag;
            return this;
        }

        public Builder sellerMemo(String sellerMemo) {
            this.sellerMemo = sellerMemo;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder tradeFrom(String tradeFrom) {
            this.tradeFrom = tradeFrom;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder stepTradeStatus(String stepTradeStatus) {
            this.stepTradeStatus = stepTradeStatus;
            return this;
        }

        public Builder stepPaidFee(String stepPaidFee) {
            this.stepPaidFee = stepPaidFee;
            return this;
        }

        public Builder buyerAlipayNo(String buyerAlipayNo) {
            this.buyerAlipayNo = buyerAlipayNo;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder discountFee(Double discountFee) {
            this.discountFee = discountFee;
            return this;
        }

        public Builder totalFee(Double totalFee) {
            this.totalFee = totalFee;
            return this;
        }

        public Builder created(Date created) {
            this.created = created;
            return this;
        }

        public Builder payTime(Date payTime) {
            this.payTime = payTime;
            return this;
        }

        public Builder modified(Date modified) {
            this.modified = modified;
            return this;
        }

        public Builder consignTime(Date consignTime) {
            this.consignTime = consignTime;
            return this;
        }

        public Builder endTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder shippingType(String shippingType) {
            this.shippingType = shippingType;
            return this;
        }

        public Builder shippingName(String shippingName) {
            this.shippingName = shippingName;
            return this;
        }

        public Builder shippingSid(String shippingSid) {
            this.shippingSid = shippingSid;
            return this;
        }

        public Builder shippingStatus(Integer shippingStatus) {
            this.shippingStatus = shippingStatus;
            return this;
        }

        public Builder shippingModified(Date shippingModified) {
            this.shippingModified = shippingModified;
            return this;
        }

        public Builder lastShippingUpdateTime(Date lastShippingUpdateTime) {
            this.lastShippingUpdateTime = lastShippingUpdateTime;
            return this;
        }

        public Builder rxAuditStatus(Integer rxAuditStatus) {
            this.rxAuditStatus = rxAuditStatus;
            return this;
        }

        public Builder lastSendTime(Date lastSendTime) {
            this.lastSendTime = lastSendTime;
            return this;
        }

        public Builder signTime(Date signTime) {
            this.signTime = signTime;
            return this;
        }

        public Trade build() {
            Trade trade = new Trade();
            trade.setTradeId(tradeId);
            trade.setSellerId(sellerId);
            trade.setShopBuyerId(shopBuyerId);
            trade.setBuyerNick(buyerNick);
            trade.setReceivedPayment(receivedPayment);
            trade.setPostFee(postFee);
            trade.setReceiverName(receiverName);
            trade.setReceiverAddress(receiverAddress);
            trade.setReceiverZip(receiverZip);
            trade.setReceiverMobile(receiverMobile);
            trade.setReceiverMobileType(receiverMobileType);
            trade.setTid(tid);
            trade.setNum(num);
            trade.setBuyerMessage(buyerMessage);
            trade.setSellerFlag(sellerFlag);
            trade.setSellerMemo(sellerMemo);
            trade.setStatus(status);
            trade.setTradeFrom(tradeFrom);
            trade.setType(type);
            trade.setStepTradeStatus(stepTradeStatus);
            trade.setStepPaidFee(stepPaidFee);
            trade.setBuyerAlipayNo(buyerAlipayNo);
            trade.setPrice(price);
            trade.setDiscountFee(discountFee);
            trade.setTotalFee(totalFee);
            trade.setCreated(created);
            trade.setPayTime(payTime);
            trade.setModified(modified);
            trade.setConsignTime(consignTime);
            trade.setEndTime(endTime);
            trade.setShippingType(shippingType);
            trade.setShippingName(shippingName);
            trade.setShippingSid(shippingSid);
            trade.setShippingStatus(shippingStatus);
            trade.setShippingModified(shippingModified);
            trade.setLastShippingUpdateTime(lastShippingUpdateTime);
            trade.setRxAuditStatus(rxAuditStatus);
            trade.setLastSendTime(lastSendTime);
            trade.setSignTime(signTime);
            return trade;
        }
    }
}
