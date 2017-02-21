package view.dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controller.addGysListener;

import org.eclipse.wb.swt.SWTResourceManager;

public class addGys extends Dialog {
	
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

	protected Object result;

	protected Shell shell;

	/**
	 * Create the dialog
	 * @param parent
	 * @param style
	 */
	public addGys(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Create the dialog
	 * @param parent
	 */
	public addGys(Shell parent) {
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
		shell.setImage(SWTResourceManager.getImage(addGys.class, "/picture/6.jpg"));
		shell.setSize(525, 395);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("添加供应商信息");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("供应商名");
		label.setBounds(30, 20, 76, 20);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(30, 60, 76, 20);
		label_1.setText("地    址");

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(30, 100, 76, 20);
		label_2.setText("简    称");

		final Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(30, 140, 76, 20);
		label_3.setText("电    话");

		final Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(30, 180, 76, 20);
		label_4.setText("联 系 人");

		final Label eMailLabel = new Label(shell, SWT.NONE);
		eMailLabel.setBounds(30, 220, 76, 20);
		eMailLabel.setText("e - mail");

		final Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(30, 260, 76, 20);
		label_6.setText("开户银行");

		final Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(261, 100, 76, 20);
		label_7.setText("邮政编号");

		final Label label_8 = new Label(shell, SWT.NONE);
		label_8.setBounds(261, 140, 76, 20);
		label_8.setText("传    真");

		final Label label_9 = new Label(shell, SWT.NONE);
		label_9.setBounds(261, 180, 76, 20);
		label_9.setText("联系电话");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(115, 17, 360, 26);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(115, 57, 360, 26);

		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(115, 97, 110, 26);

		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(115, 137, 110, 26);

		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(115, 177, 110, 26);

		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(115, 217, 360, 26);

		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(115, 257, 360, 26);

		text_8 = new Text(shell, SWT.BORDER);
		text_8.setBounds(365, 97, 110, 26);

		text_9 = new Text(shell, SWT.BORDER);
		text_9.setBounds(365, 140, 110, 26);

		text_10 = new Text(shell, SWT.BORDER);
		text_10.setBounds(365, 177, 110, 26);

		final Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String message = new addGysListener(addGys.this).add();
				MessageDialog.openInformation(shell, "提示", message);
				if(message.equals("添加成功!"))
					new addGysListener(addGys.this).reset();
			}
		});
		button.setText("保存");
		button.setBounds(115, 310, 80, 30);

		final Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				new addGysListener(addGys.this).reset();
			}
		});
		button_1.setText("取消");
		button_1.setBounds(365, 310, 80, 30);
		//
	}

	public Text getText_1() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Text getText_10() {
		return text_10;
	}

	public void setText_10(Text text_10) {
		this.text_10 = text_10;
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

}
