package view.dialog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.TbKc;

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
import org.eclipse.swt.widgets.Text;

import dao.Dao;
import item.Item;

import org.eclipse.wb.swt.SWTResourceManager;

public class JiageTZ extends Dialog {

	private Text text_8;
	private Text text_7;
	private Text text_6;
	private Text text_5;
	private Text text_4;
	private Text text_3;
	private Text text_2;
	private Text text;
	private Combo combo;
	protected Object result;

	protected Shell shell;
	
	List<Item> items = new ArrayList<Item>();
	TbKc kc;

	public JiageTZ(Shell parent, int style) {
		super(parent, style);
	}

	public JiageTZ(Shell parent) {
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
		shell.setImage(SWTResourceManager.getImage(JiageTZ.class, "/picture/6.jpg"));
		shell.setSize(392, 461);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("价格调整");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("商品名称");
		label.setBounds(30, 20, 76, 20);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(30, 60, 76, 20);
		label_1.setText("\u89C4    \u683C");

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(30, 100, 76, 20);
		label_2.setText("\u4EA7    \u5730");

		final Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(30, 140, 76, 20);
		label_3.setText("\u7B80    \u79F0");

		final Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(30, 180, 76, 20);
		label_4.setText("\u5305    \u88C5");

		final Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(30, 220, 76, 20);
		label_5.setText("\u5355    \u4F4D");

		final Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(30, 260, 76, 20);
		label_6.setText("\u5355    \u4EF7");

		final Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(30, 300, 76, 20);
		label_7.setText("库存数量");

		final Label label_8 = new Label(shell, SWT.NONE);
		label_8.setBounds(30, 340, 76, 20);
		label_8.setText("库存金额");

		combo = new Combo(shell, SWT.READ_ONLY);
		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				int id = combo.getSelectionIndex();
				text_6.forceFocus();
				Item item = items.get(id);
				kc = Dao.getKc(item);
				if(kc.getId()==null||kc.getId().equals("")) {
					return ;
				}
				text.setText(kc.getGg());
				text_2.setText(kc.getCd());
				text_3.setText(kc.getJc());
				text_4.setText(kc.getBz());
				text_5.setText(kc.getDw());
				text_6.setText(String.valueOf(kc.getDj()));
				text_7.setText(String.valueOf(kc.getKcsl()));
				text_8.setText(String.valueOf(kc.getDj()*kc.getKcsl()));
			}
		});
		combo.setBounds(110, 17, 240, 28);

		text = new Text(shell, SWT.BORDER);
		text.setEditable(false);
		text.setBounds(110, 57, 240, 26);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setEditable(false);
		text_2.setBounds(110, 97, 240, 26);

		text_3 = new Text(shell, SWT.BORDER);
		text_3.setEditable(false);
		text_3.setBounds(110, 137, 240, 26);

		text_4 = new Text(shell, SWT.BORDER);
		text_4.setEditable(false);
		text_4.setBounds(110, 177, 240, 26);

		text_5 = new Text(shell, SWT.BORDER);
		text_5.setEditable(false);
		text_5.setBounds(110, 217, 240, 26);

		text_6 = new Text(shell, SWT.BORDER);
		text_6.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				try {
					double i = Double.parseDouble(text_6.getText());
					kc.setDj(i);
					String text7 = text_7.getText().trim();
					if(text7.equals(""))
						return;
					int j = Integer.valueOf(text7);
					text_8.setText(String.valueOf(i*j));
				} catch (Exception exp) {
					MessageDialog.openInformation(shell, "提示", "输入的金额格式不正确!");
					return ;
				}
			}
		});
		
		text_6.setBounds(110, 257, 240, 26);

		text_7 = new Text(shell, SWT.BORDER);
		text_7.setEditable(false);
		text_7.setBounds(110, 297, 240, 26);

		text_8 = new Text(shell, SWT.BORDER);
		text_8.setEditable(false);
		text_8.setBounds(110, 337, 240, 26);

		final Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				int id = combo.getSelectionIndex();
				if(id<0) {
					MessageDialog.openInformation(shell, "提示", "请选择商品!");
					return ;
				}
				int rs = Dao.updateKucunDj(kc);
				if(rs>0) {
					MessageDialog.openInformation(shell, "提示", "调整成功!");
				} else {
					MessageDialog.openInformation(shell, "提示", "调整失败!");
				}
			}
		});
		button.setText("确定");
		button.setBounds(240, 386, 80, 30);
		
		init();
	}
	
	public void init() {
		combo.removeAll();
		List list = Dao.getKucunInfos();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			List element = (List) iterator.next();
			Item item = new Item();
			item.setId((String) element.get(0));
			item.setName((String) element.get(1));
			items.add(item);
			combo.add(item.getName());
		}
	}
}
