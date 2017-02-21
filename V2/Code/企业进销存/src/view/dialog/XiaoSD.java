package view.dialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import dao.Dao;
import item.Item;
import model.TbKhinfo;
import model.TbSellDetail;
import model.TbSellMain;
import model.TbUserlist;
import main.login;

import org.eclipse.wb.swt.SWTResourceManager;

public class XiaoSD extends Dialog {

	private Table table;
	private Combo combo_2;
	private Combo combo;
	private Text text_9;
	private Text text_8;
	private Text text_7;
	private Text text_6;
	private Text text_5;
	private Text text_4;
	private Text text_3;
	private Text text_2;
	private Text text;
	protected Object result;
	
	protected Shell shell;
	
	List<Item> items = new ArrayList<Item>();
	TbUserlist user = login.getUser();

	public XiaoSD(Shell parent, int style) {
		super(parent, style);
	}

	public XiaoSD(Shell parent) {
		this(parent, SWT.NONE);
	}

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

	protected void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setImage(SWTResourceManager.getImage(XiaoSD.class, "/picture/6.jpg"));
		shell.setSize(736, 528);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("销售单");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("销售票号");
		label.setBounds(30, 20, 76, 20);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(250, 20, 76, 20);
		label_1.setText("客    户");

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(500, 20, 76, 20);
		label_2.setText("联 系 人");

		final Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(30, 60, 76, 20);
		label_3.setText("结算方式");

		final Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(250, 60, 76, 20);
		label_4.setText("销售时间");

		final Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(500, 60, 76, 20);
		label_5.setText("经 手 人");

		final Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(30, 410, 76, 20);
		label_6.setText("品种数量");

		final Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(250, 410, 76, 20);
		label_7.setText("货品总数");

		final Label label_8 = new Label(shell, SWT.NONE);
		label_8.setBounds(500, 410, 76, 20);
		label_8.setText("合计金额");

		final Label label_9 = new Label(shell, SWT.NONE);
		label_9.setBounds(30, 450, 76, 20);
		label_9.setText("验收结论");

		final Label label_10 = new Label(shell, SWT.NONE);
		label_10.setBounds(250, 450, 76, 20);
		label_10.setText("操 作 员");

		text = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text.setBounds(110, 17, 130, 26);

		text_2 = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text_2.setBounds(580, 17, 130, 26);

		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(580, 57, 130, 26);

		text_4 = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text_4.setBounds(330, 57, 160, 26);

		text_5 = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text_5.setBounds(110, 407, 130, 26);

		text_6 = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text_6.setBounds(330, 407, 160, 26);

		text_7 = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text_7.setBounds(580, 407, 130, 26);

		text_8 = new Text(shell, SWT.BORDER);
		text_8.setBounds(110, 447, 130, 26);

		text_9 = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text_9.setBounds(330, 447, 160, 26);

		combo = new Combo(shell, SWT.READ_ONLY);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				initLxr(combo.getSelectionIndex());
			}
		});
		combo.setBounds(330, 17, 160, 28);

		combo_2 = new Combo(shell, SWT.READ_ONLY);
		combo_2.setBounds(110, 57, 130, 28);
		combo_2.add("现金");
		combo_2.add("支票");
		combo_2.setText("现金");

		table = new Table(shell, SWT.BORDER);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(30, 100, 680, 300);

		int tabelColWidth = 200;
		final TableColumn newColumnTableColumn = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn.setWidth(tabelColWidth);
		newColumnTableColumn.setText("商品名称");

		final TableColumn newColumnTableColumn_1 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_1.setWidth(tabelColWidth);
		newColumnTableColumn_1.setText("商品编号");

		final TableColumn newColumnTableColumn_10 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_10.setWidth(tabelColWidth);
		newColumnTableColumn_10.setText("供应商");

		final TableColumn newColumnTableColumn_2 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_2.setWidth(tabelColWidth);
		newColumnTableColumn_2.setText("产地");

		final TableColumn newColumnTableColumn_3 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_3.setWidth(tabelColWidth);
		newColumnTableColumn_3.setText("单位");

		final TableColumn newColumnTableColumn_4 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_4.setWidth(tabelColWidth);
		newColumnTableColumn_4.setText("规格");

		final TableColumn newColumnTableColumn_6 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_6.setWidth(tabelColWidth);
		newColumnTableColumn_6.setText("单价");

		final TableColumn newColumnTableColumn_7 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_7.setWidth(tabelColWidth);
		newColumnTableColumn_7.setText("数量");

		final TableColumn newColumnTableColumn_5 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_5.setWidth(tabelColWidth);
		newColumnTableColumn_5.setText("包装");

		final TableColumn newColumnTableColumn_8 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_8.setWidth(tabelColWidth);
		newColumnTableColumn_8.setText("批号");

		final TableColumn newColumnTableColumn_9 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_9.setWidth(tabelColWidth);
		newColumnTableColumn_9.setText("批准文号");

		final Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				int id = combo.getSelectionIndex();
				if(id<0) {
					MessageDialog.openInformation(shell, "提示", "请选择供应商");
					return;
				}
				Item item = (Item)items.get(id);
				String name = item.getName();
				new XiaoSD_Add(Display.getCurrent().getActiveShell()).open(name,XiaoSD.this);
				int sl = 0;
				double menoy = 0.0;
				for(int i=0;i<table.getItemCount();i++) {
					double dj = Double.parseDouble(table.getItem(i).getText(6));
					int l = Integer.parseInt(table.getItem(i).getText(7));
				    menoy += dj*l;
				    sl += l;
				}
				text_5.setText(String.valueOf(table.getItemCount()));
				text_6.setText(String.valueOf(sl));
				text_7.setText(String.valueOf(menoy));
			}
		});
		button.setText("添加");
		button.setBounds(545, 447, 48, 26);

		final Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			public void widgetSelected(final SelectionEvent e) {
				if(text_3.getText()==null || text_3.getText().equals("")) {
					MessageDialog.openInformation(shell, "提示", "经手人不能为空!");
					return ;
				}
				if(text_8.getText()==null || text_8.getText().equals("")) {
					MessageDialog.openInformation(shell, "提示", "验收结论不能为空!");
					return ;
				}
				if(table.getItemCount()<=0) {
					MessageDialog.openInformation(shell, "提示", "请填写入库商品!");
					return ;
				}
				TbSellMain sellMain = new TbSellMain(
						text.getText().trim(), 
						text_5.getText().trim(), 
						text_7.getText().trim(), 
						text_8.getText().trim(),
						items.get(combo.getSelectionIndex()).getId(),
						combo.getText().trim(), 
						text_4.getText().trim(), 
						text_9.getText().trim(), 
						text_3.getText().trim(), 
						combo_2.getText().trim());
				Set<TbSellDetail> set = sellMain.getTbSellDetails();
				
				for(int i=0;i<table.getItemCount();i++) {
					String spinfo = table.getItem(i).getText(1);
					String djStr = (String) table.getItem(i).getText(6);
					String slStr = (String) table.getItem(i).getText(7);
					Double dj = Double.valueOf(djStr);
					Integer sl = Integer.valueOf(slStr);
					TbSellDetail detail = new TbSellDetail();
					detail.setSpid(spinfo);
					detail.setTbSellMain(sellMain.getSellId());
					detail.setDj(dj);
					detail.setSl(sl);
					set.add(detail);
				}
				
				boolean rs = Dao.insertSellInfo(sellMain);
				if(rs) {
					MessageDialog.openInformation(shell, "提示", "销售成功!");
					table.removeAll();
					text_3.setText("");
					text_8.setText("");
				}
				
			}
		});
		button_1.setText("销售");
		button_1.setBounds(639, 447, 48, 26);
		//
		
		initTime();
		initGysCombo();
		text_9.setText(user.getName());
	}
	
	public TableItem getTableItem() {
		return new TableItem(table, SWT.BORDER);
	}
	
	public void initGysCombo() {
		List khInfos = Dao.getKhInfos();
		combo.removeAll();
		for (Iterator iter = khInfos.iterator(); iter.hasNext();) {
			List list = (List) iter.next();
			Item item = new Item();
			item.setId(list.get(0).toString().trim());
			item.setName(list.get(1).toString().trim());
			items.add(item);
			combo.add(item.getName());
		}
	}
	
	public void initLxr(int id) {
		if(id<0)
			return ;
		Item item = (Item)items.get(id);
		TbKhinfo khinfo = Dao.getKhInfo(item);
		text_2.setText(khinfo.getLxr());
	}
	
	public void initTime() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		text_4.setText(df.format(date));
		java.sql.Date de = new java.sql.Date(date.getTime());
		String maxId = Dao.getSellMainMaxId(de);
		text.setText(maxId);
	}
}
