package model;

import java.util.HashSet;
import java.util.Set;
public class TbSellMain implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 351194752103753759L;
	private String sellId;
	private String pzs;
	private String je;
	private String ysjl;
	private String khid;
	private String khname;
	private String xsdate;
	private String czy;
	private String jsr;
	private String jsfs;
	private Set tbSellDetails = new HashSet(0);
	public TbSellMain() {
	}
	public TbSellMain(String sellId, String pzs, String je, String ysjl,String khid,
			String khname, String xsdate, String czy, String jsr, String jsfs) {
		this.sellId = sellId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.khid = khid;
		this.khname = khname;
		this.xsdate = xsdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
		this.tbSellDetails = tbSellDetails;
	}
	public String getSellId() {
		return this.sellId;
	}

	public void setSellId(String sellId) {
		this.sellId = sellId;
	}

	public String getPzs() {
		return this.pzs;
	}

	public void setPzs(String pzs) {
		this.pzs = pzs;
	}

	public String getJe() {
		return this.je;
	}

	public void setJe(String je) {
		this.je = je;
	}

	public String getYsjl() {
		return this.ysjl;
	}

	public void setYsjl(String ysjl) {
		this.ysjl = ysjl;
	}

	public String getKhid() {
		return this.khid;
	}

	public void setKhid(String khid) {
		this.khid = khid;
	}
	
	public String getKhname() {
		return this.khname;
	}

	public void setKhname(String khname) {
		this.khname = khname;
	}

	public String getXsdate() {
		return this.xsdate;
	}

	public void setXsdate(String xsdate) {
		this.xsdate = xsdate;
	}

	public String getCzy() {
		return this.czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	public String getJsr() {
		return this.jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	public String getJsfs() {
		return this.jsfs;
	}

	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}

	public Set getTbSellDetails() {
		return this.tbSellDetails;
	}

	public void setTbSellDetails(Set tbSellDetails) {
		this.tbSellDetails = tbSellDetails;
	}
}