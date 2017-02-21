package controller;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.swt.widgets.TableItem;

import dao.Dao;
import view.dialog.XiaoStuiHCX;

public class XiaoStuiHCXListener {

	@SuppressWarnings("unchecked")
	public XiaoStuiHCXListener(XiaoStuiHCX xsx) {
		List list = Dao.findForList("select * from tb_xsth");
		int num = xsx.getTable().getItemCount();
		for (int i = 0; i < num; i++)
			xsx.getTable().remove(0);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			Vector vector = new Vector();
			List view = (List) iterator.next();
			vector.addAll(view);
			TableItem newItemTableItem = xsx.getNewItemTableItem();
			String[] str = {
					(String)vector.get(0),
					(String)vector.get(1),
					(String)vector.get(2),
					(String)vector.get(3),
					(String)vector.get(4),
					(String)vector.get(5),
					(String)vector.get(6),
					(String)vector.get(7),
					(String)vector.get(8),
					(String)vector.get(9),
					(String)vector.get(10),
					(String)vector.get(11)
			};
			newItemTableItem.setText(str);
		}
	}
	
}
