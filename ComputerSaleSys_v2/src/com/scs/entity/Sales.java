package com.scs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer salesManId;                   //销售员id
	private Integer productId;                    //产品id
	private String productName;                   //产品名
	private Double outPrice;                      //出售价格
	private Date salesTime;                       //出售时间
	private String buyerName;                     //买家姓名
	private String buyTel;                        //买家电话
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSalesManId() {
		return salesManId;
	}
	public void setSalesManId(Integer salesManId) {
		this.salesManId = salesManId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(Double outPrice) {
		this.outPrice = outPrice;
	}
	public Date getSalesTime() {
		return salesTime;
	}
	public void setSalesTime(Date salesTime) {
		this.salesTime = salesTime;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyTel() {
		return buyTel;
	}
	public void setBuyTel(String buyTel) {
		this.buyTel = buyTel;
	}
	public Sales(Integer salesManId, Integer productId, String productName, Double outPrice, Date salesTime,
			String buyerName, String buyTel) {
		super();
		this.salesManId = salesManId;
		this.productId = productId;
		this.productName = productName;
		this.outPrice = outPrice;
		this.salesTime = salesTime;
		this.buyerName = buyerName;
		this.buyTel = buyTel;
	}
	public Sales() {
		super();
	}
	@Override
	public String toString() {
		return "Sales [id=" + id + ", salesManId=" + salesManId + ", productId=" + productId + ", productName="
				+ productName + ", outPrice=" + outPrice + ", salesTime=" + salesTime + ", buyerName=" + buyerName
				+ ", buyTel=" + buyTel + "]";
	}
	
	
	
	
	

}
