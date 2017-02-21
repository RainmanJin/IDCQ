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

import controller.addUserListener;

import org.eclipse.wb.swt.SWTResourceManager;

public class addUser extends Dialog {

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
	public addUser(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Create the dialog
	 * @param parent
	 */
	public addUser(Shell parent) {
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
		shell.setImage(SWTResourceManager.getImage(addUser.class, "/picture/6.jpg"));
		shell.setSize(326, 288);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("添加操作员");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("登陆名称");
		label.setBounds(30, 20, 76, 20);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(110, 17, 176, 26);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(30, 60, 76, 20);
		label_1.setText("姓    名");

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(110, 57, 176, 26);

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(30, 100, 76, 20);
		label_2.setText("登陆密码");

		final Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(30, 140, 76, 20);
		label_3.setText("确认密码");

		text_3 = new Text(shell, SWT.PASSWORD | SWT.BORDER);
		text_3.setBounds(110, 100, 176, 26);

		text_4 = new Text(shell, SWT.PASSWORD | SWT.BORDER);
		text_4.setBounds(110, 140, 176, 26);

		final Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String message = new addUserListener().add(addUser.this);
				MessageDialog.openInformation(shell, "提示", message);
			}
		});
		button.setText("添加");
		button.setBounds(81, 200, 50, 30);

		final Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				text.setText("");
				text_2.setText("");
				text_3.setText("");
				text_4.setText("");
			}
		});
		button_1.setText("重置");
		button_1.setBounds(203, 200, 50, 30);
	}

	public Text getText_1() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
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

}
