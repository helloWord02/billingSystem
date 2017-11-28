package com.test_project.bean;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 资费实体对象
 * @author xyf
 *
 */
@Entity
@Table(name="t_postage")
public class PostageBean implements Serializable {
	
	@Id
	@GenericGenerator(name="hibernate_id",strategy="identity")
	@GeneratedValue(generator="hibernate_id")
	private long id;
	/**资费名称**/
	@Column(name="postage_name")
	private String postageName;
	/**资费类型**/
	private int type;
	/**基本时长**/
	private long baisetime;
	/**基本费用**/
	private double baisecost;
	/**单位费用**/
	private double unitcost;
	/**资费说明**/
	private String costexplain;
	/**状态**/
	private int state;
	/**开通时间**/
	@Column(name="begindate")
	private Date beginDate;
	
	
	public PostageBean(String postageName, int type, long baisetime, double baisecost, double unitcost,
			String costexplain, int state, Date beginDate) {
		super();
		this.postageName = postageName;
		this.type = type;
		this.baisetime = baisetime;
		this.baisecost = baisecost;
		this.unitcost = unitcost;
		this.costexplain = costexplain;
		this.state = state;
		this.beginDate = beginDate;
	}
	public PostageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPostageName() {
		return postageName;
	}
	public void setPostageName(String postageName) {
		this.postageName = postageName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getBaisetime() {
		return baisetime;
	}
	public void setBaisetime(long baisetime) {
		this.baisetime = baisetime;
	}
	public double getBaisecost() {
		return baisecost;
	}
	public void setBaisecost(double baisecost) {
		this.baisecost = baisecost;
	}
	public double getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(double unitcost) {
		this.unitcost = unitcost;
	}
	public String getCostexplain() {
		return costexplain;
	}
	public void setCostexplain(String costexplain) {
		this.costexplain = costexplain;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	@Override
	public String toString() {
		return "PostageBean [id=" + id + ", postageName=" + postageName + ", type=" + type + ", baisetime=" + baisetime
				+ ", baisecost=" + baisecost + ", unitcost=" + unitcost + ", costexplain=" + costexplain + ", state="
				+ state + ", beginDate=" + beginDate + "]";
	}

	
	
	
}
