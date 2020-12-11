//package com.example.esdemo.doc;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.DateFormat;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import java.io.Serializable;
//import java.util.Date;
//
//@Data
//@NoArgsConstructor
//@Accessors(chain = true)
//@Document(indexName = "order", type = "_doc", shards = 1, replicas = 0)
//public class OrderDoc implements Serializable {
//
//    @Id
//    private Long orderId;
//    @Field(type = FieldType.Long)
//    private Long sellerId;
//    @Field(type = FieldType.Long)
//    private Long tid;
//    @Field(type = FieldType.Long)
//    private Long oid;
//    @Field(type = FieldType.Long)
//    private Long shopBuyerId;
//    @Field(type = FieldType.Keyword)
//    private String buyerNick;
//    @Field(type = FieldType.Keyword)
//    private String refundStatus;
//    @Field(type = FieldType.Keyword)
//    private String buyerRate;
//    @Field(type = FieldType.Keyword)
//    private String sellerRate;
//    @Field(type = FieldType.Text)
//    private String title;
//    @Field(type = FieldType.Long)
//    private Long numIid;
//    @Field(type = FieldType.Double)
//    private Double price;
//    @Field(type = FieldType.Short)
//    private Integer num;
//    @Field(type = FieldType.Short)
//    private Integer sellerFlag;
//    @Field(type = FieldType.Double)
//    private Double totalFee;
//    @Field(type = FieldType.Double)
//    private Double payment;
//    @Field(type = FieldType.Double)
//    private Double discountFee;
//    @Field(type = FieldType.Text)
//    private String promotionName;
//    @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date endTime;
//    @Field(type = FieldType.Keyword)
//    private String status;
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date created;
//        @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
//    private Date payTime;
//    @Field(type = FieldType.Long)
//    private Long skuId;
//    @Field(type = FieldType.Keyword)
//    private String outerId;
//
//}
