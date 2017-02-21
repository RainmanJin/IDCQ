package controller;

import java.sql.ResultSet;

import dao.Dao;
import view.dialog.XiaoStuiHD_Add;

public class XiaoStuiHD_AddListener {

	String name;
	XiaoStuiHD_Add xs;
	
	public XiaoStuiHD_AddListener(String name,XiaoStuiHD_Add xs) {
		this.name = name;
		this.xs = xs;
		ResultSet rs = Dao.query("select * from tb_spinfo");
		xs.getCombo().removeAll();
		try {
			while(rs.next()) {
				xs.getCombo().add(rs.getString("spname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String add() {
		return xs.getCombo().getText().trim();
	}
}
