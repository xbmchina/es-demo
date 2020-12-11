package com.example.esdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@TableName("order_000011")
public class Order implements Serializable{

  private Long orderId;
  private Long sellerId;
  private Long tid;
  private Long oid;
  private Long shopBuyerId;
  private String buyerNick;
  private String picPath;
  private String refundStatus;
  private String buyerRate;
  private String sellerRate;
  private String title;
  private Long numIid;
  private Double price;
  private Integer num;
  private Integer sellerFlag;
  private Double totalFee;
  private Double payment;
  private Double discountFee;
  private String promotionName;
  private Date endTime;
  private String status;
  private Date created;
  private Date payTime;
  private Long skuId;
  private String outerId;

}
