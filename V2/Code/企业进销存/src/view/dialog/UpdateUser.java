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

import dao.Dao;
import item.Item;
import model.TbUserlist;

import org.eclipse.wb.swt.SWTResourceManager;

public class UpdateUser extends Dialog {

	private Text text;
	private Combo combo_2;
	private Combo combo;
	protected Object result;

	protected Shell shell;

	List<Item> items = new ArrayList<Item>();

	public UpdateUser(Shell parent, int style) {
		super(parent, style);
	}

	public UpdateUser(Shell parent) {
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
		shell.setImage(SWTResourceManager.getImage(UpdateUser.class, "/picture/6.jpg"));
		shell.setSize(291, 232);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width) / 2,
				parentBounds.y + (parentBounds.height - shellBounds.height) / 2);
		shell.setText("更改权限");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("登陆名称");
		label.setBounds(30, 20, 76, 20);

		combo = new Combo(shell, SWT.READ_ONLY);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				selectAction();
			}
		});

		combo.setBounds(110, 17, 147, 28);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(30, 60, 76, 20);
		label_1.setText("权    限");

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(30, 100, 76, 20);
		label_2.setText("更改权限");

		combo_2 = new Combo(shell, SWT.READ_ONLY);
		combo_2.setBounds(110, 97, 147, 28);
		combo_2.add("操作员");
		combo_2.add("管理员");
		combo_2.add("采购员");
		combo_2.add("销售员");
		combo_2.add("统计员");

		text = new Text(shell, SWT.BORDER);
		text.setEditable(false);
		text.setBounds(110, 57, 147, 26);

		final Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				int id = combo.getSelectionIndex();
				if (id < 0) {
					return;
				}
				Item item = (Item) items.get(id);
				if (!(item instanceof Item)) {
					return;
				}

				TbUserlist user = Dao.getUser(item);
				if (user.getName() == null) {
					return;
				}
				if (combo_2.getText().trim().equals("管理员")) {
					user.setQuan("a");
				} else if (combo_2.getText().trim().equals("操作员")) {
					user.setQuan("c");
				} else if (combo_2.getText().trim().equals("采购员")) {
					user.setQuan("j");
				} else if (combo_2.getText().trim().equals("销售员")) {
					user.setQuan("s");
				} else if (combo_2.getText().trim().equals("统计员")) {
					user.setQuan("t");
				} else
					user.setQuan("c");
				if (Dao.updateUser(user) >= 1)
					MessageDialog.openInformation(shell, "提示", "修改成功!");
				else
					MessageDialog.openInformation(shell, "提示", "修改失败!");
			}
		});
		button.setText("确定");
		button.setBounds(177, 149, 80, 30);
		//
		initCombo();
	}

	public void initCombo() {
		List user = Dao.getUsers();
		combo.removeAll();
		for (Iterator iter = user.iterator(); iter.hasNext();) {
			List element = (List) iter.next();
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if (items.contains(item))
				continue;
			items.add(item);
			combo.add(item.getName());
		}
		selectAction();
	}

	public void selectAction() {
		int id = combo.getSelectionIndex();
		if (id < 0) {
			return;
		}
		Item item = (Item) items.get(id);
		if (!(item instanceof Item)) {
			return;
		}

		TbUserlist user = Dao.getUser(item);
		if (user.getName() == null) {
			return;
		}
		text.setText(user.getName());

	}

}
