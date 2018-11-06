package com.scs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;                  //产品名
	private String typeId;                //型号
	private Integer amount;               //数量
	private Double inPrice;               //进货价格
	private Double outPrice;			  //出售价格
	private Date inTime;                  //入库时间
	private String supplier;              //供应商
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getInPrice() {
		return inPrice;
	}
	public void setInPrice(Double inPrice) {
		this.inPrice = inPrice;
	}
	public Double getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(Double outPrice) {
		this.outPrice = outPrice;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Product(String name, String typeId, Integer amount, Double inPrice, Double outPrice, Date inTime,
			String supplier) {
		super();
		this.name = name;
		this.typeId = typeId;
		this.amount = amount;
		this.inPrice = inPrice;
		this.outPrice = outPrice;
		this.inTime = inTime;
		this.supplier = supplier;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", typeId=" + typeId + ", amount=" + amount + ", inPrice="
				+ inPrice + ", outPrice=" + outPrice + ", inTime=" + inTime + ", supplier=" + supplier + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
