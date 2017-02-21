package controller;

import java.sql.ResultSet;

import dao.Dao;
import view.dialog.JinHtuiHD_Add;

public class JinHtuiHD_AddListener {

	
	String name;
	JinHtuiHD_Add jd;
	
	public JinHtuiHD_AddListener(String name,JinHtuiHD_Add jd) {
		this.name = name;
		this.jd = jd;
		ResultSet rs = Dao.query("select * from tb_spinfo where gysName='"
				+ name.trim() + "'");
		jd.getCombo().removeAll();
		try {
			while(rs.next()) {
				jd.getCombo().add(rs.getString("spname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String add() {
		return jd.getCombo().getText().trim();
	}
}
