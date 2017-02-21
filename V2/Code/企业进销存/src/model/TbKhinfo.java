package model;

public class TbKhinfo {
	
	private String id;//客户编号
	private String khName; //名称
	private String jc;  //简称
	private String dz; //地址
	private String yzbm; //邮政编码
	private String dh; //电话
	private String cz; //传真
	private String lxr; //联系人
	private String lxdh; //联系电话
	private String yhName; //开户银行
	private String yhkh;//银行卡号
	private String yx; //电子邮箱
	
	public TbKhinfo() {
		
	}
	
	public TbKhinfo(String id) {
		this.id = id;
	}
	
	public TbKhinfo(String id,String khName,String jc,String dz,String yzbm,
			String dh,String cz,String lxr,String lxdh,String yx,String yhName,
			String yhkh) {
		this.id = id;
		this.khName = khName;
		this.jc = jc;
		this.dz = dz;
		this.yzbm = yzbm;
		this.dh = dh;
		this.cz = cz;
		this.lxr = lxr;
		this.lxdh = lxdh;
		this.yx = yx;
		this.yhName = yhName;
		this.yhkh = yhkh;
	}
	
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJc() {
		return jc;
	}
	public void setJc(String jc) {
		this.jc = jc;
	}
	public String getKhName() {
		return khName;
	}
	public void setKhName(String khName) {
		this.khName = khName;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getYhkh() {
		return yhkh;
	}
	public void setYhkh(String yhkh) {
		this.yhkh = yhkh;
	}
	public String getYhName() {
		return yhName;
	}
	public void setYhName(String yhName) {
		this.yhName = yhName;
	}
	public String getYx() {
		return yx;
	}
	public void setYx(String yx) {
		this.yx = yx;
	}
	public String getYzbm() {
		return yzbm;
	}
	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}
	
}
