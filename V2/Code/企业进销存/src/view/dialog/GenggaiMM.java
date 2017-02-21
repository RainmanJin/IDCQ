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

import controller.GenggaiMMListener;

import org.eclipse.wb.swt.SWTResourceManager;

public class GenggaiMM extends Dialog {

	private Text text_5;
	private Text text_4;
	private Text text_3;
	private Text text_2;
	private Text text;
	
	GenggaiMMListener gl;
	protected Object result;

	protected Shell shell;

	public GenggaiMM(Shell parent, int style) {
		super(parent, style);
	}

	public GenggaiMM(Shell parent) {
		this(parent, SWT.NONE);
	}

	public Object open() {
		createContents();
		text_3.forceFocus();
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
		shell.setImage(SWTResourceManager.getImage(GenggaiMM.class, "/picture/6.jpg"));
		shell.setSize(294, 312);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("修改密码");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("\u7528 \u6237 \u540D");
		label.setBounds(30, 20, 76, 20);

		text = new Text(shell, SWT.BORDER);
		text.setEditable(false);
		text.setBounds(110, 17, 141, 26);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u6743    \u9650");
		label_1.setBounds(30, 60, 76, 20);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setEditable(false);
		text_2.setBounds(110, 57, 141, 26);

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(30, 100, 76, 20);
		label_2.setText("\u65E7 \u5BC6 \u7801");

		text_3 = new Text(shell, SWT.PASSWORD|SWT.BORDER);
		text_3.setBounds(110, 97, 141, 26);

		final Label label_2_1 = new Label(shell, SWT.NONE);
		label_2_1.setBounds(30, 140, 76, 20);
		label_2_1.setText("\u65B0 \u5BC6 \u7801");

		text_4 = new Text(shell, SWT.PASSWORD|SWT.BORDER);
		text_4.setBounds(110, 137, 141, 26);

		final Label label_2_1_1 = new Label(shell, SWT.NONE);
		label_2_1_1.setBounds(30, 180, 76, 20);
		label_2_1_1.setText("\u786E\u8BA4\u5BC6\u7801");

		text_5 = new Text(shell, SWT.PASSWORD|SWT.BORDER);
		text_5.setBounds(110, 177, 141, 26);

		final Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String message = gl.update();
				MessageDialog.openInformation(shell, "提示", message);
			}
		});
		button.setText("确定");
		button.setBounds(201, 227, 50, 30);

		final Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				shell.dispose();
			}
		});
		button_1.setText("取消");
		button_1.setBounds(56, 227, 50, 30);
	
		gl = new GenggaiMMListener(GenggaiMM.this);
	}

	public Text getText_1() {
		return text;
	}

	public void setText_1(Text text) {
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

	public Text getText_5() {
		return text_5;
	}

	public void setText_5(Text text_5) {
		this.text_5 = text_5;
	}

}
