package model;

public class TbGysinfo {
	
	private String id;	//供应商id
	private String name; //名称
	private String jc;  //简称
	private String dz; //地址
	private String yzbm; //邮政编码
	private String dh; //电话
	private String cz; //传真
	private String lxr; //联系人
	private String lxdh; //联系电话
	private String yh; //开户银行
	private String yx; //电子邮箱
	
	public TbGysinfo() {
		
	}
	public TbGysinfo(String id) {
		this.id = id;
	}
	public TbGysinfo(String id,String name,String jc,String dz,String yzbm,
			String dh,String cz,String lxr,String lxdh,String yh,String yx) {
		this.id = id;
		this.name = name;
		this.jc = jc;
		this.dz = dz;
		this.yzbm = yzbm;
		this.dh = dh;
		this.cz = cz;
		this.lxr = lxr;
		this.lxdh = lxdh;
		this.yh = yh;
		this.yx = yx;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYh() {
		return yh;
	}
	public void setYh(String yh) {
		this.yh = yh;
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
