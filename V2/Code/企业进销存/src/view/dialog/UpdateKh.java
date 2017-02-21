package view.dialog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import controller.UpdateKhListener;
import dao.Dao;
import item.Item;

import org.eclipse.wb.swt.SWTResourceManager;

public class UpdateKh extends Dialog {

	private Combo combo;
	private Text text_11;
	private Text text_10;
	private Text text_9;
	private Text text_8;
	private Text text_7;
	private Text text_6;
	private Text text_5;
	private Text text_4;
	private Text text_3;
	private Text text_2;
	private Text text;
	
	List<Item> items = new ArrayList<Item>();
	
	protected Object result;

	protected Shell shell;

	public UpdateKh(Shell parent, int style) {
		super(parent, style);
	}

	public UpdateKh(Shell parent) {
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
		shell.setImage(SWTResourceManager.getImage(UpdateKh.class, "/picture/6.jpg"));
		shell.setSize(527, 454);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("修改客户信息");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("客户全称");
		label.setBounds(30, 22, 76, 20);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(30, 60, 76, 20);
		label_1.setText("客户地址");

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(30, 104, 76, 20);
		label_2.setText("客户简称");

		final Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(30, 148, 76, 20);
		label_3.setText("电    话");

		final Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(30, 192, 76, 20);
		label_4.setText("联 系 人");

		final Label eMailLabel = new Label(shell, SWT.NONE);
		eMailLabel.setBounds(30, 235, 76, 20);
		eMailLabel.setText("e - mail");

		final Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(30, 279, 76, 20);
		label_6.setText("开户银行");

		final Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(268, 104, 76, 20);
		label_7.setText("邮政编号");

		final Label label_8 = new Label(shell, SWT.NONE);
		label_8.setBounds(268, 148, 76, 20);
		label_8.setText("传    真");

		final Label label_9 = new Label(shell, SWT.NONE);
		label_9.setBounds(268, 192, 76, 20);
		label_9.setText("联系电话");

		final Label label_10 = new Label(shell, SWT.NONE);
		label_10.setBounds(268, 279, 76, 20);
		label_10.setText("银行账号");

		text = new Text(shell, SWT.BORDER);
		text.setEditable(false);
		text.setBounds(115, 19, 360, 26);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(115, 57, 360, 26);

		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(117, 101, 110, 26);

		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(117, 145, 110, 26);

		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(117, 189, 110, 26);

		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(115, 232, 360, 26);

		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(117, 276, 110, 26);

		text_8 = new Text(shell, SWT.BORDER);
		text_8.setBounds(365, 101, 110, 26);

		text_9 = new Text(shell, SWT.BORDER);
		text_9.setBounds(365, 145, 110, 26);

		text_10 = new Text(shell, SWT.BORDER);
		text_10.setBounds(365, 189, 110, 26);

		text_11 = new Text(shell, SWT.BORDER);
		text_11.setBounds(365, 276, 110, 26);

		final Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String message = new UpdateKhListener(UpdateKh.this,items).delete();
				MessageDialog.openInformation(shell, "提示", message);
				clear();
				initCombo();
			}
		});
		button.setText("删除");
		button.setBounds(115, 372, 80, 30);

		final Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String message = new UpdateKhListener(UpdateKh.this,items).update();
				MessageDialog.openInformation(shell, "提示", message);
			}
		});
		button_1.setText("修改");
		button_1.setBounds(365, 372, 80, 30);

		final Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(30, 322, 76, 20);
		label_5.setText("选择客户");

		combo = new Combo(shell, SWT.READ_ONLY);
		initCombo();
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				new UpdateKhListener(UpdateKh.this,items).selectAction();
			}
		});
		combo.setBounds(115, 319, 360, 28);
	}
	
	/*初始化combo*/
	public void initCombo() {
		List<?> khInfo = Dao.getKhInfos();
		this.getCombo().removeAll();
		for (Iterator<?> iter = khInfo.iterator(); iter.hasNext();) {
			List<?> element = (List<?>) iter.next();
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item))
				continue;
			items.add(item);
			this.getCombo().add(item.getName());
		}
		new UpdateKhListener(UpdateKh.this,items).selectAction();
	}
	
	public void clear() {
		this.getText_11().setText("");
		this.getText_10().setText("");
		this.getText_9().setText("");
		this.getText_8().setText("");
		this.getText_7().setText("");
		this.getText_6().setText("");
		this.getText_5().setText("");
		this.getText_4().setText("");
		this.getText_3().setText("");
		this.getText_2().setText("");
		this.getText_1().setText("");
		this.getCombo().setText("");
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public Text getText_10() {
		return text_10;
	}

	public void setText_10(Text text_10) {
		this.text_10 = text_10;
	}

	public Text getText_11() {
		return text_11;
	}

	public void setText_11(Text text_11) {
		this.text_11 = text_11;
	}

	public Text getText_2() {
		return text_2;
	}

	public void setText_2(Text text_2) {
		this.text_2 = text_2;
	}

	public Text getText_3() {
		return text_3;
	}

	public void setText_3(Text text_3) {
		this.text_3 = text_3;
	}

	public Text getText_4() {
		return text_4;
	}

	public void setText_4(Text text_4) {
		this.text_4 = text_4;
	}

	public Text getText_5() {
		return text_5;
	}

	public void setText_5(Text text_5) {
		this.text_5 = text_5;
	}

	public Text getText_6() {
		return text_6;
	}

	public void setText_6(Text text_6) {
		this.text_6 = text_6;
	}

	public Text getText_7() {
		return text_7;
	}

	public void setText_7(Text text_7) {
		this.text_7 = text_7;
	}

	public Text getText_8() {
		return text_8;
	}

	public void setText_8(Text text_8) {
		this.text_8 = text_8;
	}

	public Text getText_9() {
		return text_9;
	}

	public void setText_9(Text text_9) {
		this.text_9 = text_9;
	}

	public Text getText_1() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

}
