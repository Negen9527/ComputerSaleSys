package com.scs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deploy")
public class Deploy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer productId;             //产品
	private String screenSize;             //屏幕
	private Double weight;                 //重量
	private String cpu;                    //处理器
	private String videoCard;              //显卡
	private String ram;                    //运行内存
	private String hardPan;                //硬盘
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getVideoCard() {
		return videoCard;
	}
	public void setVideoCard(String videoCard) {
		this.videoCard = videoCard;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getHardPan() {
		return hardPan;
	}
	public void setHardPan(String hardPan) {
		this.hardPan = hardPan;
	}
	public Deploy(Integer productId, String screenSize, Double weight, String cpu, String videoCard, String ram,
			String hardPan) {
		super();
		this.productId = productId;
		this.screenSize = screenSize;
		this.weight = weight;
		this.cpu = cpu;
		this.videoCard = videoCard;
		this.ram = ram;
		this.hardPan = hardPan;
	}
	public Deploy() {
		super();
	}
	@Override
	public String toString() {
		return "Deploy [id=" + id + ", productId=" + productId + ", screenSize=" + screenSize + ", weight=" + weight
				+ ", cpu=" + cpu + ", videoCard=" + videoCard + ", ram=" + ram + ", hardPan=" + hardPan + "]";
	}




}
