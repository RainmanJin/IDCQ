package controller;

import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.widgets.TableItem;

import dao.Dao;
import item.Item;
import model.TbKhinfo;
import view.dialog.KhCX;

public class KhCXListener {
	
	public KhCXListener(KhCX khcx) {
		List list = Dao.getKhInfos();
		int num = khcx.getTable().getItemCount();
		for (int i = 0; i < num; i++)
			khcx.getTable().remove(0);
		Iterator iterator = list.iterator();
		TbKhinfo khInfo;
		while (iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			khInfo = Dao.getKhInfo(item);
			TableItem newItemTableItem = khcx.getNewItemTableItem();
			String[] str = {khInfo.getId().trim(),
							khInfo.getKhName().trim(),
							khInfo.getDz().trim(),
							khInfo.getJc().trim(),
							khInfo.getYzbm().trim(),
							khInfo.getDh().trim(),
							khInfo.getCz().trim(),
							khInfo.getCz().trim(),
							khInfo.getLxr().trim(),
							khInfo.getLxdh().trim(),
							khInfo.getYx().trim(),
							khInfo.getYhName().trim(),
							khInfo.getYhkh().trim()
							};
			newItemTableItem.setText(str);
		}
	}

}
