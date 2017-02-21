package controller;

import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.widgets.TableItem;

import dao.Dao;
import item.Item;
import model.TbSpinfo;
import view.dialog.SpCX;

public class SpCXListener {
	
	public SpCXListener(SpCX spcx) {
		List list = Dao.getSpInfos();
		int num = spcx.getTable().getItemCount();
		for(int i=0;i<num;i++)
			spcx.getTable().remove(0);
		Iterator iterator = list.iterator();
		TbSpinfo tbSpinfo;
		while(iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			tbSpinfo = Dao.getSpInfo(item);
			TableItem newItemTableItem = spcx.getNewItemTableItem();
			String[] str = {
					tbSpinfo.getId().trim(),
					tbSpinfo.getSpname().trim(),
					tbSpinfo.getJc().trim(),
					tbSpinfo.getCd().trim(),
					tbSpinfo.getDw().trim(),
					tbSpinfo.getGg().trim(),
					tbSpinfo.getBz().trim(),
					tbSpinfo.getPh().trim(),
					tbSpinfo.getPzwh().trim(),
					tbSpinfo.getGysname().trim(),
					tbSpinfo.getMemo().trim()
					};
			newItemTableItem.setText(str);
		}	
	}
}
