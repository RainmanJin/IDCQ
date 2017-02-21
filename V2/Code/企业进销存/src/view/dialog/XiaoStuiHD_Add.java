package view.dialog;

import java.sql.ResultSet;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
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

import controller.XiaoStuiHD_AddListener;
import dao.Dao;

import org.eclipse.wb.swt.SWTResourceManager;

public class XiaoStuiHD_Add extends Dialog {

	private Text text_2;
	private Combo combo;
	private Text text;
	protected Object result;
	protected Shell shell;
	
	String name = null;
	String spname = null;
	XiaoStuiHD_AddListener xdl;
	XiaoStuiHD xs;

	public XiaoStuiHD_Add(Shell parent, int style) {
		super(parent, style);
	}

	public XiaoStuiHD_Add(Shell parent) {
		this(parent, SWT.NONE);
	}

	public Object open(String name,XiaoStuiHD xs) {
		this.name = name;
		this.xs = xs;
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		
		xdl = new XiaoStuiHD_AddListener(name, XiaoStuiHD_Add.this);
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return result;
	}

	protected void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setImage(SWTResourceManager.getImage(XiaoStuiHD_Add.class, "/picture/6.jpg"));
		shell.setSize(348, 213);
		Rectangle parentBounds = getParent().getShell().getBounds();
		Rectangle shellBounds = shell.getBounds();
		shell.setLocation(parentBounds.x + (parentBounds.width - shellBounds.width)/2, parentBounds.y + (parentBounds.height - shellBounds.height)/2);
		shell.setText("添加商品");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("商品名称");
		label.setBounds(30, 20, 76, 20);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("数    量");
		label_1.setBounds(30, 60, 76, 20);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(110, 57, 200, 26);

		final Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				try {
					spname = xdl.add();
					String shul = text.getText().trim();
					String danj = text_2.getText().trim();
					if(combo.getSelectionIndex() ==-1){
						MessageDialog.openInformation(shell, "提示", "请选择商品!");
						return ;
					}
					if(shul.equals("")){
						MessageDialog.openInformation(shell, "提示", "请输入商品的数量!");
						return ;
					}
					if(danj.equals("")){
						MessageDialog.openInformation(shell, "提示", "请输入商品的单价!");
						return ;
					}
					int i;
					double j;
					try {
						i = Integer.parseInt(shul);
						j = Double.parseDouble(danj);
					} catch (Exception e2) {
						MessageDialog.openError(shell, "提示", "无效的输入!");
						return ;
					}
					if(i<=0 || j<=0){
						MessageDialog.openError(shell, "提示", "无效的输入!");
						return ;
					}

					String sql = "select * from tb_spinfo where spname='" + spname + "'";
					ResultSet rs = Dao.query(sql);
					if(rs.next()) {
						String[] str = {
								rs.getString("spname"),
								rs.getString("id"),
								rs.getString("gysname"),
								rs.getString("cd"),
								rs.getString("dw"),
								rs.getString("gg"),
								String.valueOf(j),
								String.valueOf(i),
								rs.getString("bz"),
								rs.getString("ph"),
								rs.getString("pzwh")
						};
						xs.getTableItem().setText(str);
					}
					MessageDialog.openInformation(shell, "提示", "添加成功!");
					shell.dispose();
				} catch (Exception ep) {
					ep.printStackTrace();
					MessageDialog.openInformation(shell, "提示", "添加失败!");
					return ;
				}
			}
		});
		button.setText("确定");
		button.setBounds(230, 132, 80, 30);

		combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(110, 17, 200, 28);

		final Label label_1_1 = new Label(shell, SWT.NONE);
		label_1_1.setBounds(30, 100, 76, 20);
		label_1_1.setText("单    价");

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(110, 94, 200, 26);
	}


	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public Text getText_2() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Combo getCombo() {
		return combo;
	}

}
