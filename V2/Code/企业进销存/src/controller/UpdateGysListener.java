package controller;

import java.util.List;

import dao.Dao;
import item.Item;
import model.TbGysinfo;
import search.updateDictionary;
import view.dialog.UpdateGys;

public class UpdateGysListener {
	
	UpdateGys ug;
	List items;
	
	public UpdateGysListener(UpdateGys ug,List items) {
		this.ug = ug;
		this.items = items;
	}
	
	public String update() {
		int id = ug.getCombo().getSelectionIndex();
		if(id<0) {
			return "修改失败";
		}
		Item item = (Item)items.get(id);
		TbGysinfo gysinfo = new TbGysinfo();
		gysinfo.setId(item.getId());
		gysinfo.setDz(ug.getText_2().getText().trim());
		gysinfo.setYzbm(ug.getText_8().getText().trim());
		gysinfo.setCz(ug.getText_9().getText().trim());
		gysinfo.setJc(ug.getText_3().getText().trim());
		gysinfo.setName(ug.getText_1().getText().trim());
		gysinfo.setLxr(ug.getText_5().getText().trim());
		gysinfo.setLxdh(ug.getText_10().getText().trim());
		gysinfo.setYx(ug.getText_6().getText().trim());
		gysinfo.setDh(ug.getText_4().getText().trim());
		gysinfo.setYh(ug.getText_7().getText().trim());
		if (Dao.updateGys(gysinfo) == 1){
			updateDictionary ud = new updateDictionary();
			ud.add("供应商名", ug.getText_3().getText().trim());
			return "修改完成";
		}
		else
			return "修改失败";
	}
	
	public String delete() {
		try {
			int id = ug.getCombo().getSelectionIndex();
			Item item = (Item)items.get(id);
			if (item == null || !(item instanceof Item))
				return "不存在的记录!";
			int rs = Dao.delete("delete from tb_Gysinfo where id='"
						+ item.getId() + "'");
			if (rs > 0) {
				return "供应商：" + item.getName() + "。删除成功";
			}
			ug.getCombo().removeAll();
		} catch (Exception e) {
			return "不存在的记录!";
		}
		return "删除失败!";
	}
	
	public void selectAction() {
		int id = ug.getCombo().getSelectionIndex();
		if(id<0) {
			return ;
		}
		Item item = (Item)items.get(id);
		if (!(item instanceof Item)) {
			return ;
		}
		
		TbGysinfo gysInfo = Dao.getGysInfo(item);
		if(gysInfo.getId() == null) {
			return ;
		}
		ug.getText_1().setText(gysInfo.getName());
		ug.getText_2().setText(gysInfo.getDz());
		ug.getText_3().setText(gysInfo.getJc());
		ug.getText_8().setText(gysInfo.getYzbm());
		ug.getText_4().setText(gysInfo.getDh());
		ug.getText_9().setText(gysInfo.getCz());
		ug.getText_5().setText(gysInfo.getLxr());
		ug.getText_10().setText(gysInfo.getLxdh());
		ug.getText_6().setText(gysInfo.getYx());
		ug.getText_7().setText(gysInfo.getYh());
	}
}
