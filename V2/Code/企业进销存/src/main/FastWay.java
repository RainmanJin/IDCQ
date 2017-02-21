package main;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;

import dao.Dao;

public class FastWay extends Dialog {

	protected Object result;
	protected Shell shell;
	private Table table;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public FastWay(Shell parent, int style) {
		super(parent, style);
	}

	public FastWay(Shell parent, String title) {
		this(parent, SWT.NONE);
		setText(title);
	}
	
	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String sql) {
		createContents(sql);
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents(String sql) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setImage(SWTResourceManager.getImage(FastWay.class, "/picture/6.jpg"));
		shell.setSize(655, 405);
		shell.setText(getText());
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 0, 649, 370);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		clearTable();
		get_table_ele(sql);
	}
	
	private void clearTable(){
		table.removeAll();
		int num = table.getColumnCount() - 1;
		for (int j = num; j >= 0; j--) {
			table.getColumn(j).dispose();
		}
	}
	
	private void get_table_ele(String sql){
		try {
			ResultSet rs = Dao.findForResultSet(sql);
			ResultSetMetaData rsmd = rs.getMetaData();

			// step2: add columns
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				new TableColumn(table, SWT.CENTER).setText(rsmd.getColumnName(i + 1));
			}
			adjustTable(table);
			TableItem item = null;
			// step3: add rows
			while(rs.next()){
				item = new TableItem(table, SWT.NONE);
				int n = 1;
				for (int col = 0; col < rsmd.getColumnCount(); col++) {
					item.setText(col, rs.getString(n));
					n++;
				}
			}
			rs.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private static void adjustTable(Table ta) {
		int colCount = ta.getColumnCount();
		int percol_wideth = 200;
		for (int i = 0; i < colCount; i++) {
			ta.getColumn(i).setWidth(percol_wideth);

			if (ta.getColumn(i).getText().equals("id")) {
				ta.getColumn(i).setText("ID");
			}
			if (ta.getColumn(i).getText().equals("spname")) {
				ta.getColumn(i).setText("商品名");
			}
			if (ta.getColumn(i).getText().equals("cd")) {
				ta.getColumn(i).setText("产地");
			}
			if (ta.getColumn(i).getText().equals("dw")) {
				ta.getColumn(i).setText("单位");
			}
			if (ta.getColumn(i).getText().equals("gg")) {
				ta.getColumn(i).setText("规格");
			}
			if (ta.getColumn(i).getText().equals("bz")) {
				ta.getColumn(i).setText("包装");
			}
			if (ta.getColumn(i).getText().equals("ph")) {
				ta.getColumn(i).setText("批号");
			}
			if (ta.getColumn(i).getText().equals("pzwh")) {
				ta.getColumn(i).setText("批准文号");
			}
			if (ta.getColumn(i).getText().equals("gysname")) {
				ta.getColumn(i).setText("供应商");
			}
			if (ta.getColumn(i).getText().equals("dz")) {
				ta.getColumn(i).setText("地址");
			}
			if (ta.getColumn(i).getText().equals("yzbm")) {
				ta.getColumn(i).setText("邮政编码");
			}
			if (ta.getColumn(i).getText().equals("dh")) {
				ta.getColumn(i).setText("电话");
			}
			if (ta.getColumn(i).getText().equals("cz")) {
				ta.getColumn(i).setText("传真");
			}
			if (ta.getColumn(i).getText().equals("lxr")) {
				ta.getColumn(i).setText("联系人");
			}
			if (ta.getColumn(i).getText().equals("lxdh")) {
				ta.getColumn(i).setText("联系电话");
			}
			if (ta.getColumn(i).getText().equals("yx")) {
				ta.getColumn(i).setText("邮箱");
			}
			if (ta.getColumn(i).getText().equals("dj")) {
				ta.getColumn(i).setText("单价");
			}
			if (ta.getColumn(i).getText().equals("kcsl")) {
				ta.getColumn(i).setText("库存数量");
			}
			if (ta.getColumn(i).getText().equals("khname")) {
				ta.getColumn(i).setText("客户名");
			}

			if (ta.getColumn(i).getText().equals("rkthid")) {
				ta.getColumn(i).setText("返厂ID");
			}
			if (ta.getColumn(i).getText().equals("rukuid")) {
				ta.getColumn(i).setText("进货ID");
			}
			if (ta.getColumn(i).getText().equals("sellid")) {
				ta.getColumn(i).setText("销售ID");
			}
			if (ta.getColumn(i).getText().equals("xsthid")) {
				ta.getColumn(i).setText("退货ID");
			}
			if (ta.getColumn(i).getText().equals("pzno")) {
				ta.getColumn(i).setText("品种ID");
			}
			if (ta.getColumn(i).getText().equals("spid")) {
				ta.getColumn(i).setText("商品ID");
			}
			if (ta.getColumn(i).getText().equals("sl")) {
				ta.getColumn(i).setText("数量");
			}
			if (ta.getColumn(i).getText().equals("je")) {
				ta.getColumn(i).setText("金额");
			}
			if (ta.getColumn(i).getText().equals("gysid")) {
				ta.getColumn(i).setText("供应商ID");
			}
			if (ta.getColumn(i).getText().equals("khid")) {
				ta.getColumn(i).setText("客户ID");
			}
			if (ta.getColumn(i).getText().equals("thrq")) {
				ta.getColumn(i).setText("返厂日期");
			}
			if (ta.getColumn(i).getText().equals("rukurq")) {
				ta.getColumn(i).setText("进货日期");
			}
			if (ta.getColumn(i).getText().equals("sellrq")) {
				ta.getColumn(i).setText("出售日期");
			}
			if (ta.getColumn(i).getText().equals("xsthrq")) {
				ta.getColumn(i).setText("退货日期");
			}
			if (ta.getColumn(i).getText().equals("jsr")) {
				ta.getColumn(i).setText("经手人");
			}
			if (ta.getColumn(i).getText().equals("jsfs")) {
				ta.getColumn(i).setText("经手方式");
			}

			if (ta.getColumn(i).getText().equals("jc")) {
				ta.getColumn(i).setText("简称");
			}
			if (ta.getColumn(i).getText().equals("name")) {
				ta.getColumn(i).setText("NAME");
			}
			if (ta.getColumn(i).getText().equals("yh")) {
				ta.getColumn(i).setText("银行");
			}
			if (ta.getColumn(i).getText().equals("yhkh")) {
				ta.getColumn(i).setText("银行卡号");
			}
		}
	}
}
