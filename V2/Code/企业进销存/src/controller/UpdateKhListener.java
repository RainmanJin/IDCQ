package controller;

import java.util.List;

import dao.Dao;
import item.Item;
import model.TbKhinfo;
import search.updateDictionary;
import view.dialog.UpdateKh;

public class UpdateKhListener {
	
	UpdateKh uk;
	List items;
	
	public UpdateKhListener(UpdateKh uk,List items) {
		this.uk = uk;
		this.items = items;
	}
	
	public String update() {
		int id = uk.getCombo().getSelectionIndex();
		if(id<0) {
			return "修改失败";
		}
		Item item = (Item)items.get(id);
		TbKhinfo khinfo = new TbKhinfo();
		khinfo.setId(item.getId());
		khinfo.setDz(uk.getText_2().getText().trim());
		khinfo.setYzbm(uk.getText_8().getText().trim());
		khinfo.setCz(uk.getText_9().getText().trim());
		khinfo.setYhkh(uk.getText_11().getText().trim());
		khinfo.setJc(uk.getText_3().getText().trim());
		khinfo.setKhName(uk.getText_1().getText().trim());
		khinfo.setLxr(uk.getText_5().getText().trim());
		khinfo.setLxdh(uk.getText_10().getText().trim());
		khinfo.setYx(uk.getText_6().getText().trim());
		khinfo.setDh(uk.getText_4().getText().trim());
		khinfo.setYhName(uk.getText_2().getText());
		if (Dao.updateKeHu(khinfo) == 1){
			updateDictionary ud = new updateDictionary();
			ud.add("客户名", uk.getText_3().getText().trim());
			return "修改完成";
		}
		else
			return "修改失败";
	}
	
	public String delete() {
		try {
			int id = uk.getCombo().getSelectionIndex();
			Item item = (Item)items.get(id);
			if (item == null || !(item instanceof Item))
				return "不存在的记录!";
			int rs = Dao.delete("delete from tb_khinfo where id='"
						+ item.getId() + "'");
			if (rs > 0) {
				return "客户：" + item.getName() + "。删除成功";
			}
			uk.getCombo().removeAll();
		} catch (Exception e) {
			return "不存在的记录!";
		}
		return "删除失败!";
	}
	
	public void selectAction() {
		int id = uk.getCombo().getSelectionIndex();
		if(id<0) {
			return ;
		}
		Item item = (Item)items.get(id);
		if (!(item instanceof Item)) {
			return ;
		}
		
		TbKhinfo khInfo = Dao.getKhInfo(item);
		if(khInfo.getId() == null) {
			return ;
		}
		uk.getText_1().setText(khInfo.getKhName());
		uk.getText_2().setText(khInfo.getDz());
		uk.getText_3().setText(khInfo.getJc());
		uk.getText_8().setText(khInfo.getYzbm());
		uk.getText_4().setText(khInfo.getDh());
		uk.getText_9().setText(khInfo.getCz());
		uk.getText_5().setText(khInfo.getLxr());
		uk.getText_10().setText(khInfo.getLxdh());
		uk.getText_6().setText(khInfo.getYx());
		uk.getText_7().setText(khInfo.getYhName());
		uk.getText_11().setText(khInfo.getYhkh());
	}
}
