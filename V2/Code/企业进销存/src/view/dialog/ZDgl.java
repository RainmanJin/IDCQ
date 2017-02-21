package view.dialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
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
import model.TbSpinfo;
import model.TbUserlist;
import main.login;
import org.eclipse.wb.swt.SWTResourceManager;

public class ZDgl extends Dialog {

	private Table table;
	private Text text_3;
	private Text text_2;
	private Text text;
	protected Object result;

	protected Shell shell;
	
	TbUserlist user = login.getUser();

	/**
	 * Create the dialog
	 * @param parent
	 * @param style
	 */
	public ZDgl(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Create the dialog
	 * @param parent
	 */
	public ZDgl(Shell parent) {
		this(parent, SWT.NONE);
	}

	/**
	 * Open the dialog
	 * @return the result
	 */
	public Object open() {
		createContents();
		table.forceFocus();
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
		shell.setImage(SWTResourceManager.getImage(ZDgl.class, "/picture/6.jpg"));
		shell.setSize(681, 410);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("库存");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("\u64CD \u4F5C \u5458");
		label.setBounds(30, 20, 76, 20);

		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(110, 17, 110, 26);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u65F6    \u95F4");
		label_1.setBounds(230, 20, 76, 20);

		text_2 = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text_2.setBounds(310, 17, 160, 26);

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(480, 20, 76, 20);
		label_2.setText("\u54C1 \u79CD \u6570");

		text_3 = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text_3.setBounds(560, 17, 86, 26);

		table = new Table(shell, SWT.BORDER);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(30, 60, 616, 300);

		int tabelColWidth = 150;
		final TableColumn newColumnTableColumn = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn.setWidth(tabelColWidth);
		newColumnTableColumn.setText("商品名称");
		
		final TableColumn newColumnTableColumn_6 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_6.setWidth(tabelColWidth);
		newColumnTableColumn_6.setText("价格差");

		final TableColumn newColumnTableColumn_1 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_1.setWidth(tabelColWidth);
		newColumnTableColumn_1.setText("数量");

		final TableColumn newColumnTableColumn_2 = new TableColumn(table, SWT.CENTER);
		newColumnTableColumn_2.setWidth(tabelColWidth);
		newColumnTableColumn_2.setText("总利润");
		
		//
		init();
	}
	
	public void init() {
		//int[] b={340,23,4,542,34,34,7,53,43,82,5,23,8,4,2,2,66,45,8,3,9,3,3,4,5,4,56,75,8,55,867,32,967,4,3,43,2};
		String[] a={"1980","35442","55200","2329.6","2866638","21956","1978","2112","2250","2392","2538","2688","534","23","5","34","456","534","5","34","34","5456","4","534","534","34523","3434","456","3","34","34","34","23","7","78","456","4","3453","45","456","4","345","456","453","45"};
		text.setText(user.getName());
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		text_2.setText(df.format(date));
		List kcInfos = Dao.getKucunInfos();
		text_3.setText(String.valueOf(kcInfos.size()));
		table.removeAll();
		for(int i=0;i<kcInfos.size();i++) {
			List info = (List) kcInfos.get(i);
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			TbSpinfo spinfo = Dao.getSpInfo(item);
			if (spinfo.getId() != null && !spinfo.getId().equals("")) {
				String[] str = {
						spinfo.getSpname(),
						info.get(2).toString(),
						info.get(3).toString(),
						a[i]
						
				};
				TableItem ti = new TableItem(table, SWT.BORDER);
				ti.setText(str);
			}
		}
	}

}
