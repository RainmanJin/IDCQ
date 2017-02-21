package controller;

import java.util.List;

import dao.Dao;
import item.Item;
import model.TbSpinfo;
import search.updateDictionary;
import view.dialog.UpdateSp;

public class UpdateSpListener {
	
	UpdateSp us;
	List items;
	
	public UpdateSpListener(UpdateSp us,List items) {
		this.us = us;
		this.items = items;
	}
	
	public String update() {
		int id = us.getCombo().getSelectionIndex();
		if(id<0) {
			return "修改失败";
		}
		Item item = (Item)items.get(id);
		TbSpinfo spinfo = new TbSpinfo();
		spinfo.setId(item.getId());
		spinfo.setJc(us.getText_2().getText().trim());
		spinfo.setGg(us.getText_8().getText().trim());
		spinfo.setPh(us.getText_9().getText().trim());
		spinfo.setCd(us.getText_3().getText().trim());
		spinfo.setGysname(us.getText_7().getText().trim());
		spinfo.setBz(us.getText_5().getText().trim());
		spinfo.setMemo(us.getText_10().getText().trim());
		spinfo.setPzwh(us.getText_6().getText().trim());
		spinfo.setDw(us.getText_4().getText().trim());
		if (Dao.updateSp(spinfo) == 1){
			updateDictionary ud = new updateDictionary();
			ud.add("商品名", us.getText_2().getText().trim());
			return "修改完成";
		}
		else
			return "修改失败";
	}
	
	public String delete() {
		try {
			int id = us.getCombo().getSelectionIndex();
			Item item = (Item)items.get(id);
			if (item == null || !(item instanceof Item))
				return "不存在的记录!";
			int rs = Dao.delete("delete from tb_spinfo where id='"
						+ item.getId() + "'");
			if (rs > 0) {
				return "商品：" + item.getName() + "。删除成功";
			}
			us.getCombo().removeAll();
		} catch (Exception e) {
			return "不存在的记录!";
		}
		return "删除失败!";
	}
	
	public void selectAction() {
			int id = us.getCombo().getSelectionIndex();
			if(id<0) {
				return ;
			}
			Item item = (Item)items.get(id);
			if (!(item instanceof Item)) {
				return ;
			}
		
		TbSpinfo spinfo = Dao.getSpInfo(item);
		if(spinfo.getId() == null) {
			return ;
		}
		us.getText_1().setText(spinfo.getSpname());
		us.getText_2().setText(spinfo.getJc());
		us.getText_3().setText(spinfo.getCd());
		us.getText_8().setText(spinfo.getGg());
		us.getText_4().setText(spinfo.getDw());
		us.getText_9().setText(spinfo.getPh());
		us.getText_5().setText(spinfo.getBz());
		us.getText_6().setText(spinfo.getPzwh());
		us.getText_7().setText(spinfo.getGysname());
		us.getText_10().setText(spinfo.getMemo());
	}
}
