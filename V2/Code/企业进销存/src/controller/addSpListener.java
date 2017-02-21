package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.Dao;
import item.Item;
import model.TbSpinfo;
import search.updateDictionary;
import view.dialog.addSp;

public class addSpListener {
	
	addSp addSp ;
	List items;
	
	public addSpListener(addSp addSp,List items) {
		this.addSp = addSp;
		this.items = items;
	}

	
	public String add() {
		if(addSp.getText_1().getText().equals("")||addSp.getText_2().getText().equals("")
				||addSp.getText_3().getText().equals("")||addSp.getText_4().getText().equals("")
				||addSp.getText_5().getText().equals("")||addSp.getText_6().getText().equals("")
				||addSp.getCombo().getText().equals("")||addSp.getText_8().getText().equals("")
				||addSp.getText_9().getText().equals("")||addSp.getText_10().getText().equals("")) {
			return "输入的内容不能为空!";
			}
		
			ResultSet haveUser = Dao.query("select * from tb_spinfo where spname='"
				+ addSp.getText_1().getText().trim() + "'");
			try {
				if (haveUser.next()){
					return "添加失败，存在相同的客户!";
				}
			} catch (Exception er) {
				return "操作失败!";
			}
			ResultSet set = Dao.query("select max(id) from tb_spinfo");
			String id = null;
			try {
				if (set != null && set.next()) {
					String sid = set.getString(1);
					if (sid == null)
						id = "sp1001";
					else {
						String str = sid.substring(2);
						id = "sp" + (Integer.parseInt(str) + 1);
					}
				}
			} catch (SQLException e1) {
				return "操作失败!";
			}
			TbSpinfo spinfo = new TbSpinfo();
			spinfo.setId(id);
			spinfo.setJc(addSp.getText_2().getText().trim());
			spinfo.setGg(addSp.getText_8().getText().trim());
			spinfo.setPh(addSp.getText_9().getText().trim());
			spinfo.setCd(addSp.getText_3().getText().trim());
			spinfo.setSpname(addSp.getText_1().getText().trim());
			spinfo.setBz(addSp.getText_5().getText().trim());
			spinfo.setMemo(addSp.getText_10().getText().trim());
			spinfo.setPzwh(addSp.getText_6().getText().trim());
			spinfo.setDw(addSp.getText_4().getText().trim());
			spinfo.setGysname(addSp.getCombo().getText());
			Dao.addSp(spinfo);
			updateDictionary ud = new updateDictionary();
			ud.add("商品名", addSp.getText_1().getText().trim());
			ud.add("商品名", addSp.getText_2().getText().trim());
			return "添加成功!";
	}
	public void reset() {
		addSp.getText_1().setText("");
		addSp.getText_2().setText("");
		addSp.getText_3().setText("");
		addSp.getText_4().setText("");
		addSp.getText_5().setText("");
		addSp.getText_6().setText("");
		addSp.getCombo().setText("");
		addSp.getText_8().setText("");
		addSp.getText_9().setText("");
		addSp.getText_10().setText("");
	}
	
	public void selectAction() {
		int id = addSp.getCombo().getSelectionIndex();
		if(id<=0||items.size()<=0) {
			return ;
		}
		Item item = (Item)items.get(id);
		if (!(item instanceof Item)) {
			return ;
		}
		
		TbSpinfo spinfo = Dao.getSpInfo(item);
		addSp.getText_1().setText(spinfo.getSpname());
		addSp.getText_2().setText(spinfo.getJc());
		addSp.getText_3().setText(spinfo.getCd());
		addSp.getText_4().setText(spinfo.getDw());
		addSp.getText_5().setText(spinfo.getBz());
		addSp.getText_6().setText(spinfo.getPzwh());
		addSp.getCombo().setText(spinfo.getGysname());
		addSp.getText_8().setText(spinfo.getGg());
		addSp.getText_9().setText(spinfo.getPh());
		addSp.getText_10().setText(spinfo.getMemo());	
	}
}
