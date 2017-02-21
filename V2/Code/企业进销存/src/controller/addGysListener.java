package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Dao;
import model.TbGysinfo;
import search.updateDictionary;
import view.dialog.addGys;

public class addGysListener {
	addGys addgys ;
	public addGysListener(addGys addgys) {
		this.addgys = addgys;
	}
	
	public String add() {
		if(addgys.getText_1().getText().equals("")||addgys.getText_2().getText().equals("")
				||addgys.getText_3().getText().equals("")||addgys.getText_4().getText().equals("")
				||addgys.getText_5().getText().equals("")||addgys.getText_6().getText().equals("")
				||addgys.getText_7().getText().equals("")||addgys.getText_8().getText().equals("")
				||addgys.getText_9().getText().equals("")||addgys.getText_10().getText().equals("")) {
			return "输入的内容不能为空!";
			}
		
			ResultSet haveUser = Dao.query("select * from tb_gysinfo where name='"
				+ addgys.getText_1().getText().trim() + "'");
			try {
				if (haveUser.next()){
					return "添加失败，存在相同的客户!";
				}
			} catch (Exception er) {
				return "操作失败!";
			}
			ResultSet set = Dao.query("select max(id) from tb_gysinfo");
			String id = null;
			try {
				if (set != null && set.next()) {
					String sid = set.getString(1);
					if (sid == null)
						id = "gys1001";
					else {
						String str = sid.substring(3);
						id = "gys" + (Integer.parseInt(str) + 1);
					}
				}
			} catch (SQLException e1) {
				return "操作失败!";
			}
			TbGysinfo Gysinfo = new TbGysinfo();
			Gysinfo.setId(id);
			Gysinfo.setDz(addgys.getText_2().getText().trim());
			Gysinfo.setYzbm(addgys.getText_8().getText().trim());
			Gysinfo.setCz(addgys.getText_9().getText().trim());
			Gysinfo.setJc(addgys.getText_3().getText().trim());
			Gysinfo.setName(addgys.getText_1().getText().trim());
			Gysinfo.setLxr(addgys.getText_5().getText().trim());
			Gysinfo.setLxdh(addgys.getText_10().getText().trim());
			Gysinfo.setYx(addgys.getText_6().getText().trim());
			Gysinfo.setYh(addgys.getText_7().getText().trim());
			Gysinfo.setDh(addgys.getText_4().getText().trim());
			Dao.addGys(Gysinfo);
			updateDictionary ud = new updateDictionary();
			ud.add("供应商名", addgys.getText_1().getText().trim());
			ud.add("供应商名", addgys.getText_3().getText().trim());
			return "添加成功!";
	}
	public void reset() {
		addgys.getText_1().setText("");
		addgys.getText_2().setText("");
		addgys.getText_3().setText("");
		addgys.getText_4().setText("");
		addgys.getText_5().setText("");
		addgys.getText_6().setText("");
		addgys.getText_7().setText("");
		addgys.getText_8().setText("");
		addgys.getText_9().setText("");
		addgys.getText_10().setText("");
	}
}
