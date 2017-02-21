package view.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import controller.RukutuiHCXListener;
import org.eclipse.wb.swt.SWTResourceManager;

public class RukutuiHCX extends Dialog {

	private Table table;
	protected Object result;

	protected Shell shell;

	/**
	 * Create the dialog
	 * @param parent
	 * @param style
	 */
	public RukutuiHCX(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Create the dialog
	 * @param parent
	 */
	public RukutuiHCX(Shell parent) {
		this(parent, SWT.NONE);
	}

	/**
	 * Open the dialog
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return result;
	}

	/**
	 * Create contents of the dialog
	 */
	protected void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setImage(SWTResourceManager.getImage(RukutuiHCX.class, "/picture/6.jpg"));
		shell.setSize(655, 405);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("入库退货查询");

		table = new Table(shell, SWT.BORDER);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(0, 0, 650, 370);

		int tabelColWidth = 150;
		final TableColumn newColumnTableColumn = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn.setWidth(tabelColWidth);
		newColumnTableColumn.setText("入库退货票号");

		final TableColumn newColumnTableColumn_1 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_1.setWidth(tabelColWidth);
		newColumnTableColumn_1.setText("商品编号");

		final TableColumn newColumnTableColumn_2 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_2.setWidth(tabelColWidth);
		newColumnTableColumn_2.setText("商品名称");

		final TableColumn newColumnTableColumn_3 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_3.setWidth(tabelColWidth);
		newColumnTableColumn_3.setText("规格");

		final TableColumn newColumnTableColumn_4 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_4.setWidth(tabelColWidth);
		newColumnTableColumn_4.setText("单价");

		final TableColumn newColumnTableColumn_5 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_5.setWidth(tabelColWidth);
		newColumnTableColumn_5.setText("金额");

		final TableColumn newColumnTableColumn_6 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_6.setWidth(tabelColWidth);
		newColumnTableColumn_6.setText("供应商");

		final TableColumn newColumnTableColumn_7 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_7.setWidth(tabelColWidth);
		newColumnTableColumn_7.setText("退货日期");

		final TableColumn newColumnTableColumn_8 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_8.setWidth(tabelColWidth);
		newColumnTableColumn_8.setText("操作员");

		final TableColumn newColumnTableColumn_9 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_9.setWidth(tabelColWidth);
		newColumnTableColumn_9.setText("经手人");

		final TableColumn newColumnTableColumn_10 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_10.setWidth(tabelColWidth);
		newColumnTableColumn_10.setText("结算方式");

		final TableColumn newColumnTableColumn_11 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_11.setWidth(tabelColWidth);
		newColumnTableColumn_11.setText("数量");
		//
		
		new RukutuiHCXListener(RukutuiHCX.this);
	}
	
	public TableItem getNewItemTableItem() {
		return new TableItem(table, SWT.BORDER);
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

}
