package main;

import model.TbUserlist;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import dao.Dao;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class login extends Shell {
	private static TbUserlist user;
	
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			login shell = new login(display);
			//屏幕居中
			shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent()  
	                .getClientArea().height / 2 - shell.getSize().y/2);
			
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public login(Display display) {
		super(display, SWT.NO_TRIM);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage(login.class, "/picture/3.jpg"));
		composite.setBounds(0, 0, 656, 296);
		
		final Combo combo = new Combo(composite, SWT.READ_ONLY);
		combo.setItems(new String[] {"\u7BA1\u7406\u5458", "\u7CFB\u7EDF\u7BA1\u7406\u5458"});
		combo.setBounds(333, 107, 260, 28);
		combo.select(0);
		
		text = new Text(composite, SWT.BORDER);
		text.forceFocus();
		text.setBounds(333, 145, 260, 26);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode==SWT.CR){
					user = Dao.getUser(combo.getText(),text.getText().toString().trim(), text_1.getText().toString().trim());
					if (user.getUsername() == null || user.getName() == null) {
						text_1.setText("");
						MessageBox diglog=new MessageBox(getShell(),SWT.OK|SWT.ICON_INFORMATION);
						diglog.setText("Error");
						diglog.setMessage("用户名或者密码不正确");
						diglog.open();
						return;
					}
					getShell().dispose();
					Main.run();
				}
			}
		});
		text_1.setBounds(333, 180, 260, 26);
		
		Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getShell().dispose();
			}
		});
		button.setBounds(338, 219, 70, 30);
		button.setText("\u9000\u51FA");
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				user = Dao.getUser(combo.getText(),text.getText().toString().trim(), text_1.getText().toString().trim());
				if (user.getUsername() == null || user.getName() == null) {
					text_1.setText("");
					MessageBox diglog=new MessageBox(getShell(),SWT.OK|SWT.ICON_INFORMATION);
					diglog.setText("Error");
					diglog.setMessage("用户名或者密码不正确");
					diglog.open();
					return;
				}
				getShell().dispose();
				Main.run();
			}
		});
		button_1.setBounds(523, 219, 70, 30);
		button_1.setText("\u767B\u5F55");
		
		Label label = new Label(composite, SWT.NONE);
		label.setBackgroundImage(SWTResourceManager.getImage(login.class, "/picture/11.png"));
		label.setBounds(295, 98, 33, 44);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBackgroundImage(SWTResourceManager.getImage(login.class, "/picture/12.png"));
		label_1.setBounds(299, 136, 28, 42);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBackgroundImage(SWTResourceManager.getImage(login.class, "/picture/13.png"));
		label_2.setBounds(297, 171, 30, 45);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(656, 296);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public static TbUserlist getUser() {
		return user;
	}

	public static void setUser(TbUserlist user) {
		login.user = user;
	}
}
