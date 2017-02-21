package view.dialog;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;

import controller.addKhListener;

public class addKh extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public addKh(Shell parent, int style) {
		super(parent, style);
	}
	
	/**
	 * Create the dialog.
	 * @param parent
	 */
	public addKh(Shell parent) {
		this(parent, SWT.NONE);
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
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
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setImage(SWTResourceManager.getImage(addKh.class, "/picture/6.jpg"));
		shell.setSize(520, 412);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("\u6DFB\u52A0\u5BA2\u6237\u4FE1\u606F");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 514, 377);
		
		Label label = new Label(composite, SWT.NONE);
		label.setBounds(30, 22, 76, 20);
		label.setText("\u5BA2\u6237\u5168\u79F0");
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBounds(30, 60, 76, 20);
		label_1.setText("\u5BA2\u6237\u5730\u5740");
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBounds(30, 104, 76, 20);
		label_2.setText("\u5BA2\u6237\u7B80\u79F0");
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setBounds(30, 148, 76, 20);
		label_3.setText("\u7535    \u8BDD");
		
		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setBounds(30, 192, 76, 20);
		label_4.setText("\u8054\u7CFB\u4EBA");
		
		Label lblEmail = new Label(composite, SWT.NONE);
		lblEmail.setBounds(30, 235, 76, 20);
		lblEmail.setText("e-mail");
		
		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setBounds(30, 279, 76, 20);
		label_5.setText("\u5F00\u6237\u94F6\u884C");
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(115, 19, 360, 26);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(115, 57, 360, 26);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(115, 101, 110, 26);
		
		Label label_6 = new Label(composite, SWT.NONE);
		label_6.setBounds(261, 104, 76, 20);
		label_6.setText("\u90AE\u653F\u7F16\u7801");
		
		Label label_7 = new Label(composite, SWT.NONE);
		label_7.setBounds(261, 148, 76, 20);
		label_7.setText("\u4F20    \u771F");
		
		Label label_8 = new Label(composite, SWT.NONE);
		label_8.setBounds(261, 192, 76, 20);
		label_8.setText("\u8054\u7CFB\u7535\u8BDD");
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBounds(115, 145, 110, 26);
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setBounds(115, 192, 110, 26);
		
		text_5 = new Text(composite, SWT.BORDER);
		text_5.setBounds(115, 232, 360, 26);
		
		text_6 = new Text(composite, SWT.BORDER);
		text_6.setBounds(115, 276, 110, 26);
		
		text_7 = new Text(composite, SWT.BORDER);
		text_7.setBounds(365, 101, 110, 26);
		
		text_8 = new Text(composite, SWT.BORDER);
		text_8.setBounds(365, 145, 110, 26);
		
		text_9 = new Text(composite, SWT.BORDER);
		text_9.setBounds(365, 189, 110, 26);
		
		Label label_9 = new Label(composite, SWT.NONE);
		label_9.setBounds(261, 279, 76, 20);
		label_9.setText("\u94F6\u884C\u8D26\u53F7");
		
		text_10 = new Text(composite, SWT.BORDER);
		text_10.setBounds(365, 276, 110, 26);
		
		Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String message = new addKhListener(addKh.this).add();
				MessageDialog.openInformation(shell, "提示", message);
				if(message.equals("添加成功!"))
					new addKhListener(addKh.this).reset();
			}
		});
		button.setBounds(115, 329, 80, 30);
		button.setText("\u4FDD\u5B58");
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new addKhListener(addKh.this).reset();
			}
		});
		btnNewButton.setBounds(365, 329, 80, 30);
		btnNewButton.setText("\u6E05\u7A7A");

	}
	
	public Text getText_0() {
		return text;
	}

	public void setText_0(Text text) {
		this.text = text;
	}
	
	public Text getText_1() {
		return text_1;
	}

	public void setText_1(Text text) {
		this.text_1 = text;
	}

	public Text getText_2() {
		return text_2;
	}

	public void setText_2(Text text) {
		this.text_2 = text;
	}

	public Text getText_3() {
		return text_3;
	}

	public void setText_3(Text text) {
		this.text_3 = text;
	}
	
	public Text getText_4() {
		return text_4;
	}

	public void setText_4(Text text) {
		this.text_4 = text;
	}

	public Text getText_5() {
		return text_5;
	}

	public void setText_5(Text text) {
		this.text_5 = text;
	}

	public Text getText_6() {
		return text_6;
	}

	public void setText_6(Text text) {
		this.text_6 = text;
	}
	
	public Text getText_7() {
		return text_7;
	}

	public void setText_7(Text text) {
		this.text_7 = text;
	}

	public Text getText_8() {
		return text_8;
	}

	public void setText_8(Text text) {
		this.text_8 = text;
	}

	public Text getText_9() {
		return text_9;
	}

	public void setText_9(Text text) {
		this.text_9 = text;
	}
	
	public Text getText_10() {
		return text_10;
	}

	public void setText_10(Text text) {
		this.text_10 = text;
	}

}
