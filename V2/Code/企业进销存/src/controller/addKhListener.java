package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Dao;
import model.TbKhinfo;
import search.updateDictionary;
import view.dialog.addKh;

public class addKhListener {
	addKh addkh ;
	public addKhListener(addKh addkh) {
		this.addkh = addkh;
	}
	
	public String add() {
		if(addkh.getText_1().getText().equals("")||addkh.getText_2().getText().equals("")
				||addkh.getText_3().getText().equals("")||addkh.getText_4().getText().equals("")
				||addkh.getText_5().getText().equals("")||addkh.getText_6().getText().equals("")
				||addkh.getText_7().getText().equals("")||addkh.getText_8().getText().equals("")
				||addkh.getText_9().getText().equals("")||addkh.getText_10().getText().equals("")
				||addkh.getText_0().getText().equals("")) {
			return "输入的内容不能为空!";
			}
		
			ResultSet haveUser = Dao.query("select * from tb_khinfo where khname='"
				+ addkh.getText_1().getText().trim() + "'");
			try {
				if (haveUser.next()){
					return "添加失败，存在相同的客户!";
				}
			} catch (Exception er) {
				return "操作失败!";
			}
			ResultSet set = Dao.query("select max(id) from tb_khinfo");
			String id = null;
			try {
				if (set != null && set.next()) {
					String sid = set.getString(1);
					if (sid == null)
						id = "kh1001";
					else {
						String str = sid.substring(2);
						id = "kh" + (Integer.parseInt(str) + 1);
					}
				}
			} catch (SQLException e1) {
				return "操作失败!";
			}
			TbKhinfo khinfo = new TbKhinfo();
			khinfo.setId(id);
			khinfo.setDz(addkh.getText_1().getText().trim());
			khinfo.setYzbm(addkh.getText_7().getText().trim());
			khinfo.setCz(addkh.getText_8().getText().trim());
			khinfo.setYhkh(addkh.getText_10().getText().trim());
			khinfo.setJc(addkh.getText_2().getText().trim());
			khinfo.setKhName(addkh.getText_0().getText().trim());
			khinfo.setLxr(addkh.getText_4().getText().trim());
			khinfo.setLxdh(addkh.getText_9().getText().trim());
			khinfo.setYx(addkh.getText_5().getText().trim());
			khinfo.setDh(addkh.getText_3().getText().trim());
			khinfo.setYhName(addkh.getText_6().getText().trim());
			Dao.addKeHu(khinfo);
			updateDictionary ud = new updateDictionary();
			ud.add("客户名", addkh.getText_0().getText().trim());
			ud.add("客户名", addkh.getText_2().getText().trim());
			return "添加成功!";
	}
	public void reset() {
		addkh.getText_0().setText("");
		addkh.getText_1().setText("");
		addkh.getText_2().setText("");
		addkh.getText_3().setText("");
		addkh.getText_4().setText("");
		addkh.getText_5().setText("");
		addkh.getText_6().setText("");
		addkh.getText_7().setText("");
		addkh.getText_8().setText("");
		addkh.getText_9().setText("");
		addkh.getText_10().setText("");
	}
}
