package controller;

import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.widgets.TableItem;

import dao.Dao;
import item.Item;
import model.TbGysinfo;
import view.dialog.GysCX;

public class GysCXListener {
	
	public GysCXListener(GysCX gc) {
		List list = Dao.getGysInfos();
		int num = gc.getTable().getItemCount();
		for(int i=0;i<num;i++)
			gc.getTable().remove(0);
		Iterator iterator = list.iterator();
		TbGysinfo gysinfo;
		while(iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			gysinfo = Dao.getGysInfo(item);
			TableItem newItemTableItem = gc.getNewItemTableItem();
			String[] str = {
					gysinfo.getId().trim(),
					gysinfo.getName().trim(),
					gysinfo.getJc().trim(),
					gysinfo.getDz().trim(),
					gysinfo.getDh().trim(),
					gysinfo.getCz().trim(),
					gysinfo.getLxr().trim(),
					gysinfo.getLxdh().trim(),
					gysinfo.getYx().trim(),
					gysinfo.getYh().trim()
					};
			newItemTableItem.setText(str);
		}
		
	}

}
