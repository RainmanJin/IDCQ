package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import search.search;
import swing2swt.layout.BorderLayout;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import dao.Dao;
import view.dialog.GenggaiMM;
import view.dialog.GysCX;
import view.dialog.JiageTZ;
import view.dialog.JinHD;
import view.dialog.JinHtuiHD;
import view.dialog.KhCX;
import view.dialog.KucunPD;
import view.dialog.RuKuCX;
import view.dialog.RukutuiHCX;
import view.dialog.SpCX;
import view.dialog.UpdateGys;
import view.dialog.UpdateKh;
import view.dialog.UpdateSp;
import view.dialog.UpdateUser;
import view.dialog.XiaoStuiHCX;
import view.dialog.XiaoStuiHD;
import view.dialog.XiaosCX;
import view.dialog.ZDgl;
import view.dialog.addGys;
import view.dialog.addKh;
import view.dialog.addSp;
import view.dialog.addUser;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import controller.OpenExcel;
import controller.OpenTool;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class displayTime extends Thread
//通过继承Thread类,并实现它的抽象方法run()
//适当时候创建这一Thread子类的实例来实现多线程机制
//一个线程启动后（也即进入就绪状态）一旦获得CPU将自动调用它的run()方法
{
	displayTime() {
	}// 构造函数

	public void run() {
		try {
			while (true) {
				Main.refreshTime();
				sleep(1000);
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}

public class Main extends Shell {
	
	private Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
	private displayTime dt;
	private Composite composite,composite_3,composite_8,composite_9;
	private static Composite composite_10;
	private static Label lblNewLabel;
	private static Table table;
	public static Text text;
	private Button btnNewButton_5;
	private GridLayout g3 = new GridLayout(2, false);
	private String btnName;	//表示最近哪个按钮被点击过
	private Button btnNewButton_1;
	
	/** 
     *  C键 
     */  
	private final int KEY_C= 99;  

	/*public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Main shell = new Main(display);
			shell.open();
			shell.layout();
			shell.setMaximized(true);
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void run() {
		try {
			Display display = Display.getDefault();
			Main shell = new Main(display);
			shell.open();
			shell.layout();
			shell.setMaximized(true);
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
	public Main(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(Main.class, "/picture/6.jpg"));
		addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				//setBounds(0, 0, (int)(scrSize.width*0.9), (int)(scrSize.height*0.9));
			}
		});
		addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				int shell_width = getShell().getSize().x;
				int shell_height = getShell().getSize().y;
				if(shell_width < 1024){
					getShell().setSize(1024, shell_height);
				}
				if(shell_height < 720){
					getShell().setSize(shell_width, 720);
				}
				g3.horizontalSpacing = (int) (getShell().getSize().x * 0.01);
			}
		});
		addDisposeListener(new DisposeListener() {
			@SuppressWarnings("deprecation")
			public void widgetDisposed(DisposeEvent e) {
				dt.stop();
			}
		});
		setSize((int)(scrSize.width), (int)(scrSize.height));
		
		createContents();
		setLayout(new BorderLayout(0, 0));
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText(" \u57FA\u672C\u4FE1\u606F\u7BA1\u7406(M) ");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmNewItem = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new addKh(Display.getCurrent().getActiveShell()).open();
			}
		});
		mntmNewItem.setText("\u5BA2\u6237\u4FE1\u606F\u6DFB\u52A0");
		
		MenuItem menuItem_3 = new MenuItem(menu_1, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new UpdateKh(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_3.setText("\u5BA2\u6237\u4FE1\u606F\u7F16\u8F91");
		
		MenuItem menuItem_4 = new MenuItem(menu_1, SWT.NONE);
		menuItem_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new addSp(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_4.setText("\u5546\u54C1\u4FE1\u606F\u6DFB\u52A0");
		
		MenuItem menuItem_5 = new MenuItem(menu_1, SWT.NONE);
		menuItem_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new UpdateSp(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_5.setText("\u5546\u54C1\u4FE1\u606F\u7F16\u8F91");
		
		MenuItem menuItem_6 = new MenuItem(menu_1, SWT.NONE);
		menuItem_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new addGys(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_6.setText("\u4F9B\u5E94\u5546\u4FE1\u606F\u6DFB\u52A0");
		
		MenuItem menuItem_7 = new MenuItem(menu_1, SWT.NONE);
		menuItem_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new UpdateGys(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_7.setText("\u4F9B\u5E94\u5546\u4FE1\u606F\u7F16\u8F91");
		
		MenuItem mntmNewSubmenu_1 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_1.setText(" \u5165\u5E93\u7BA1\u7406(W) ");
		
		Menu menu_2 = new Menu(mntmNewSubmenu_1);
		mntmNewSubmenu_1.setMenu(menu_2);
		
		MenuItem menuItem_8 = new MenuItem(menu_2, SWT.NONE);
		menuItem_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new JinHD(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_8.setText("\u8FDB\u8D27\u5355");
		
		MenuItem menuItem_9 = new MenuItem(menu_2, SWT.NONE);
		menuItem_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new JinHtuiHD(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_9.setText("\u8FD4\u5382\u5355");
		
		MenuItem mntmNewSubmenu_2 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_2.setText(" \u9500\u552E\u7BA1\u7406(S) ");
		
		Menu menu_3 = new Menu(mntmNewSubmenu_2);
		mntmNewSubmenu_2.setMenu(menu_3);
		
		MenuItem menuItem_10 = new MenuItem(menu_3, SWT.NONE);
		menuItem_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new view.dialog.XiaoSD(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_10.setText("\u9500\u552E\u5355");
		
		MenuItem menuItem_11 = new MenuItem(menu_3, SWT.NONE);
		menuItem_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new XiaoStuiHD(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_11.setText("\u9000\u8D27\u5355");
		
		MenuItem mntmNewSubmenu_3 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_3.setText(" \u5E93\u5B58\u7BA1\u7406(I) ");
		
		Menu menu_4 = new Menu(mntmNewSubmenu_3);
		mntmNewSubmenu_3.setMenu(menu_4);
		
		MenuItem menuItem_12 = new MenuItem(menu_4, SWT.NONE);
		menuItem_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new KucunPD(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_12.setText("\u5E93\u5B58\u76D8\u70B9");
		
		MenuItem menuItem_13 = new MenuItem(menu_4, SWT.NONE);
		menuItem_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new JiageTZ(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_13.setText("\u4EF7\u683C\u8C03\u6574");
		
		MenuItem menuItem_18 = new MenuItem(menu_4, SWT.NONE);
		menuItem_18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ZDgl zd = new ZDgl(Display.getCurrent().getActiveShell());
				zd.open();
			}
		});
		menuItem_18.setText("账单管理");

		
		MenuItem mntmNewSubmenu_4 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_4.setText(" \u4FE1\u606F\u67E5\u8BE2(Q) ");
		
		Menu menu_5 = new Menu(mntmNewSubmenu_4);
		mntmNewSubmenu_4.setMenu(menu_5);
		
		MenuItem menuItem = new MenuItem(menu_5, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KhCX khcx = new KhCX(Display.getCurrent().getActiveShell());
				khcx.open();
			}
		});
		menuItem.setText("\u5BA2\u6237\u67E5\u8BE2");
		
		MenuItem menuItem_1 = new MenuItem(menu_5, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new SpCX(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_1.setText("\u5546\u54C1\u67E5\u8BE2");
		
		MenuItem menuItem_2 = new MenuItem(menu_5, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new GysCX(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_2.setText("\u4F9B\u5E94\u5546\u67E5\u8BE2");
		
		MenuItem menuItem_14 = new MenuItem(menu_5, SWT.NONE);
		menuItem_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				new RuKuCX(Display.getCurrent().getActiveShell()).open();
				new FastWay(Display.getCurrent().getActiveShell(), "进货信息查询").open("select * from tb_ruku");
			}
		});
		menuItem_14.setText("\u8FDB\u8D27\u67E5\u8BE2");
		
		MenuItem menuItem_15 = new MenuItem(menu_5, SWT.NONE);
		menuItem_15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				new RukutuiHCX(Display.getCurrent().getActiveShell()).open();
				new FastWay(Display.getCurrent().getActiveShell(), "返厂信息查询").open("select * from tb_rkth");
			}
		});
		menuItem_15.setText("\u8FD4\u5382\u67E5\u8BE2");
		
		MenuItem menuItem_16 = new MenuItem(menu_5, SWT.NONE);
		menuItem_16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				new XiaosCX(Display.getCurrent().getActiveShell()).open();
				new FastWay(Display.getCurrent().getActiveShell(), "销售信息查询").open("select * from tb_sell");
			}
		});
		menuItem_16.setText("\u9500\u552E\u67E5\u8BE2");
		
		MenuItem menuItem_17 = new MenuItem(menu_5, SWT.NONE);
		menuItem_17.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				new XiaoStuiHCX(Display.getCurrent().getActiveShell()).open();
				new FastWay(Display.getCurrent().getActiveShell(), "退货信息查询").open("select * from tb_xsth");
			}
		});
		menuItem_17.setText("\u9000\u8D27\u67E5\u8BE2");
		
		MenuItem mntmNewSubmenu_5 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_5.setText(" \u7CFB\u7EDF\u7EF4\u62A4(P) ");
		
		Menu menu_6 = new Menu(mntmNewSubmenu_5);
		mntmNewSubmenu_5.setMenu(menu_6);
		
		MenuItem menuItem_21 = new MenuItem(menu_6, SWT.NONE);
		menuItem_21.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new GenggaiMM(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_21.setText("\u66F4\u6539\u5BC6\u7801");
		
		MenuItem menuItem_23 = new MenuItem(menu_6, SWT.NONE);
		menuItem_23.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new UpdateUser(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_23.setText("\u66F4\u6539\u6743\u9650");
		
		MenuItem menuItem_22 = new MenuItem(menu_6, SWT.NONE);
		menuItem_22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new addUser(Display.getCurrent().getActiveShell()).open();
			}
		});
		menuItem_22.setText("\u6DFB\u52A0\u7BA1\u7406\u5458");
		if (login.getUser().getName().equals("管理员")) {
			menuItem_22.dispose();
		}
		
		MenuItem mntmNewSubmenu_6 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_6.setText(" \u5DE5\u5177(T) ");
		
		Menu menu_7 = new Menu(mntmNewSubmenu_6);
		mntmNewSubmenu_6.setMenu(menu_7);
		
		MenuItem menuItem_24 = new MenuItem(menu_7, SWT.NONE);
		menuItem_24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				OpenTool ot = new OpenTool();
				String result = ot.open();
				if(!result.equals("ok")){
					MessageDialog.openError(getShell(), "提示", "打开计算器失败!");
				}
			}
		});
		menuItem_24.setText("\u8BA1\u7B97\u5668");
		
		MenuItem mntmExcel = new MenuItem(menu_7, SWT.NONE);
		mntmExcel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				OpenExcel oe = new OpenExcel();
				String result = oe.open();
				if(!result.equals("ok")){
					MessageDialog.openError(getShell(), "提示", "打开excel失败!");
				}
			}
		});
		mntmExcel.setText("Excel");
		
		MenuItem mntmNewSubmenu_7 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new AboutMe(Display.getCurrent().getActiveShell()).open();
			}
		});
		mntmNewSubmenu_7.setText(" \u5E2E\u52A9(H) ");
		
		Menu menu_8 = new Menu(mntmNewSubmenu_7);
		mntmNewSubmenu_7.setMenu(menu_8);
		
		composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite.setLayoutData(BorderLayout.CENTER);
		GridLayout g0 = new GridLayout(2, false);
		//g0.marginHeight = 0;
		//g0.marginWidth = 0;
		composite.setLayout(g0);
		
		final Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				org.eclipse.swt.graphics.Image img = SWTResourceManager.getImage(Main.class, "/picture/19.jpg");
				int imgWidth = img.getBounds().width;
				int imgHeight = img.getBounds().height;
				int Width = composite_1.getBounds().width;
				int Height = composite_1.getBounds().height;
                e.gc.drawImage(img, 0, 0, imgWidth, imgHeight, 0, 0, Width, Height);
			}
		});
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_1.setLayout(null);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_composite_1.heightHint = (int) (getShell().getSize().y*0.1);
		composite_1.setLayoutData(gd_composite_1);
		
		composite_3 = new Composite(composite, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		//composite_3.setLayout(new GridLayout(2, false));
		//g3 = new GridLayout(2, false);
		g3.horizontalSpacing = (int) (getShell().getSize().x * 0.01);
		composite_3.setLayout(g3);
		composite_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 8));
		
		Composite composite_4 = new Composite(composite_3, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_4.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_4 = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
		gd_composite_4.heightHint = 23;
		composite_4.setLayoutData(gd_composite_4);
		
		lblNewLabel = new Label(composite_4, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setAlignment(SWT.CENTER);
		//lblNewLabel.setText("\u65F6\u95F4\uFF1A");
		dt = new displayTime();
		dt.start();
		
		Label lblNewLabel_1 = new Label(composite_4, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setText("当前用户:	" + login.getUser().getName());
		
		Label lblNewLabel_2 = new Label(composite_4, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setText("操作员:		" + login.getUser().getUsername());
		
		Label lblNewLabel_3 = new Label(composite_4, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new AboutMe(Display.getCurrent().getActiveShell()).open();
			}
		});		
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3.setAlignment(SWT.RIGHT);
		lblNewLabel_3.setText("\u5E2E\u52A9\u624B\u518C");
		
		Label lblNewLabel_4 = new Label(composite_4, SWT.NONE);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseUp(MouseEvent e) {
				dt.stop();
				getShell().dispose();			
			}
		});
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_4.setAlignment(SWT.CENTER);
		lblNewLabel_4.setText("\u9000\u51FA\u7CFB\u7EDF");
		
		Composite composite_5 = new Composite(composite_3, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_5.setLayout(new BorderLayout(0, 0));
		GridData gd_composite_5 = new GridData(SWT.LEFT, SWT.FILL, false, true);
		gd_composite_5.widthHint = (int) (getShell().getSize().y*0.25);
		composite_5.setLayoutData(gd_composite_5);
		
		Group group = new Group(composite_5, SWT.NONE);
		group.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group.setText("\u5FEB\u901F\u901A\u9053");
		group.setLayoutData(BorderLayout.CENTER);
		group.setLayout(new FillLayout(1));
		
		Button btnRadioButton = new Button(group, SWT.RADIO);
		btnRadioButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new UpdateUser(Display.getCurrent().getActiveShell()).open();
			}
		});
		btnRadioButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton.setText(" \u66F4\u6539\u6743\u9650");
		
		Button btnRadioButton_1 = new Button(group, SWT.RADIO);
		btnRadioButton_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new GenggaiMM(Display.getCurrent().getActiveShell()).open();
			}
		});
		btnRadioButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_1.setText(" \u66F4\u6539\u5BC6\u7801");
		
		Button btnRadioButton_2 = new Button(group, SWT.RADIO);
		btnRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				/*KhCX khcx = new KhCX(Display.getCurrent().getActiveShell());
				khcx.open();*/
				new FastWay(Display.getCurrent().getActiveShell(), "客户信息查询").open("select * from tb_khinfo");
			}
		});
		btnRadioButton_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_2.setText(" \u5BA2\u6237\u67E5\u8BE2");
		
		Button btnRadioButton_3 = new Button(group, SWT.RADIO);
		btnRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				new SpCX(Display.getCurrent().getActiveShell()).open();
				new FastWay(Display.getCurrent().getActiveShell(), "商品信息信息查询").open("select * from tb_spinfo");
			}
		});
		btnRadioButton_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_3.setText(" \u5546\u54C1\u67E5\u8BE2");
		
		Button btnRadioButton_4 = new Button(group, SWT.RADIO);
		btnRadioButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				new GysCX(Display.getCurrent().getActiveShell()).open();
				new FastWay(Display.getCurrent().getActiveShell(), "供应商信息查询").open("select * from tb_gysinfo");
			}
		});
		btnRadioButton_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_4.setText(" \u4F9B\u5E94\u5546\u67E5\u8BE2");
		
		Button btnRadioButton_5 = new Button(group, SWT.RADIO);
		btnRadioButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				new RuKuCX(Display.getCurrent().getActiveShell()).open();
				new FastWay(Display.getCurrent().getActiveShell(), "进货信息查询").open("select * from tb_ruku");
			}

		});
		btnRadioButton_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_5.setText(" \u8FDB\u8D27\u67E5\u8BE2");
		
		Button btnRadioButton_6 = new Button(group, SWT.RADIO);
		btnRadioButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new FastWay(Display.getCurrent().getActiveShell(), "返厂信息查询").open("select * from tb_rkth");
			}
		});
		btnRadioButton_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_6.setText(" \u8FD4\u5382\u67E5\u8BE2");
		
		Button btnRadioButton_7 = new Button(group, SWT.RADIO);
		btnRadioButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				new XiaosCX(Display.getCurrent().getActiveShell()).open();
				new FastWay(Display.getCurrent().getActiveShell(), "销售信息查询").open("select * from tb_sell");
			}
		});
		btnRadioButton_7.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_7.setText(" \u9500\u552E\u67E5\u8BE2");
		
		Button btnRadioButton_8 = new Button(group, SWT.RADIO);
		btnRadioButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				new XiaoStuiHCX(Display.getCurrent().getActiveShell()).open();
				new FastWay(Display.getCurrent().getActiveShell(), "退货信息查询").open("select * from tb_xsth");
			}
		});
		btnRadioButton_8.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_8.setText(" \u9000\u8D27\u67E5\u8BE2");
		
		Button btnRadioButton_9 = new Button(group, SWT.RADIO);
		btnRadioButton_9.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new KucunPD(Display.getCurrent().getActiveShell()).open();
			}
		});
		btnRadioButton_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_9.setText(" \u5E93\u5B58\u76D8\u70B9");
		
		Button btnRadioButton_10 = new Button(group, SWT.RADIO);
		btnRadioButton_10.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnRadioButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new JiageTZ(Display.getCurrent().getActiveShell()).open();
			}
		});
		btnRadioButton_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_10.setText(" \u4EF7\u683C\u8C03\u6574");
		
		Button btnRadioButton_11 = new Button(group, SWT.RADIO);
		btnRadioButton_11.setVisible(false);
		btnRadioButton_11.setText("No Use");
		
		Button btnRadioButton_12 = new Button(group, SWT.RADIO);
		btnRadioButton_12.setVisible(false);
		btnRadioButton_12.setText("No Use");
		
		final Composite composite_6 = new Composite(composite_3, SWT.NONE);
		composite_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		GridLayout g6 = new GridLayout(1, false);
		g6.verticalSpacing = 0;
//		g8.marginWidth = 0;
//		g8.verticalSpacing = 0;
		composite_6.setLayout(g6);
		//composite_6.setLayout(new GridLayout(1, false));
		composite_6.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Composite composite_7 = new Composite(composite_6, SWT.NONE);
		composite_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_7.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_7 = new GridData(SWT.FILL, SWT.LEFT, true, false);
		gd_composite_7.heightHint = 48;
		composite_7.setLayoutData(gd_composite_7);
		
		Button btnNewButton = new Button(composite_7, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(false);
				composite_10.setVisible(false);
			}
		});   
		btnNewButton.setText("\u6B22\u8FCE");
		btnNewButton.forceFocus();
		
		btnNewButton_1 = new Button(composite_7, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(true);
				composite_10.setVisible(true);
				btnName = btnNewButton_1.getText().trim();
				text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				text.setText("请输入待查询的语句");
				clearTable();
			}
		});
		btnNewButton_1.setText("\u641C\u7D22");
		
		final Button btnNewButton_2 = new Button(composite_7, SWT.NONE);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(true);
				composite_10.setVisible(true);
				btnName = btnNewButton_2.getText().trim();
				text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				text.setText("请输入待查询的客户ID");
				clearTable();
				get_table_ele("select * from tb_khinfo");
			}
		});
		btnNewButton_2.setText("\u5BA2\u6237\u57FA\u672C\u4FE1\u606F");
		
		final Button btnNewButton_3 = new Button(composite_7, SWT.NONE);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(true);
				composite_10.setVisible(true);
				btnName = btnNewButton_3.getText().trim();
				text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				text.setText("请输入待查询的商品ID");
				clearTable();
				get_table_ele("select * from tb_spinfo");
			}
		});
		btnNewButton_3.setText("\u5546\u54C1\u57FA\u672C\u4FE1\u606F");
		
		final Button btnNewButton_4 = new Button(composite_7, SWT.NONE);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(true);
				composite_10.setVisible(true);
				btnName = btnNewButton_4.getText().trim();
				text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				text.setText("请输入待查询的供应商ID");
				clearTable();
				get_table_ele("select * from tb_gysinfo");
			}
		});
		btnNewButton_4.setText("\u4F9B\u5E94\u5546\u57FA\u672C\u4FE1\u606F");
		
		final Button button = new Button(composite_7, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(true);
				composite_10.setVisible(true);
				btnName = button.getText().trim();
				text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				text.setText("请输入待查询的进货ID");
				clearTable();
				get_table_ele("select * from tb_ruku");
			}
		});
		button.setText("\u8FDB\u8D27\u8BE6\u60C5");
		
		final Button button_1 = new Button(composite_7, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(true);
				composite_10.setVisible(true);
				btnName = button_1.getText().trim();
				text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				text.setText("请输入待查询的返厂ID");
				clearTable();
				get_table_ele("select * from tb_rkth");
			}
		});
		button_1.setText("\u8FD4\u5382\u8BE6\u60C5");
		
		final Button button_2 = new Button(composite_7, SWT.NONE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(true);
				composite_10.setVisible(true);
				btnName = button_2.getText().trim();
				text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				text.setText("请输入待查询的销售ID");
				clearTable();
				get_table_ele("select * from tb_sell");
			}
		});
		button_2.setText("\u9500\u552E\u8BE6\u60C5");
		
		final Button button_3 = new Button(composite_7, SWT.NONE);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(true);
				composite_10.setVisible(true);
				btnName = button_3.getText().trim();
				text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				text.setText("请输入待查询的退货ID");
				clearTable();
				get_table_ele("select * from tb_xsth");
			}
		});
		button_3.setText("\u9000\u8D27\u8BE6\u60C5");
		
		Button button_4 = new Button(composite_7, SWT.NONE);
		button_4.setVisible(false);
		
		composite_8 = new Composite(composite_6, SWT.NONE);		
		composite_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				composite_9.setVisible(true);
				composite_10.setVisible(true);
				btnName = btnNewButton_1.getText().trim();
				btnNewButton_1.setFocus();
				text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				text.setText("请输入待查询的语句");
				clearTable();
			}
		});
		composite_8.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				org.eclipse.swt.graphics.Image img = SWTResourceManager.getImage(Main.class, "/picture/background.jpg");
				int imgWidth = img.getBounds().width;
				int imgHeight = img.getBounds().height;
				int Width = composite_8.getBounds().width;
				int Height = composite_8.getBounds().height;
                e.gc.drawImage(img, 0, 0, imgWidth, imgHeight, 0, 0, Width, Height);
			}
		});
		//composite_8.setLayout(new GridLayout(1, false));
		GridLayout g8 = new GridLayout(1, false);
		g8.marginHeight = 0;
		g8.marginWidth = 0;
		g8.verticalSpacing = 0;
		composite_8.setLayout(g8);
		composite_8.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		composite_9 = new Composite(composite_8, SWT.NONE);
		composite_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_9.setLayout(new GridLayout(5, false));
		GridData gd_composite_9 = new GridData(SWT.FILL, SWT.LEFT, true, false);
		gd_composite_9.heightHint = 51;
		composite_9.setLayoutData(gd_composite_9);
		composite_9.setVisible(false);
		
		Label label = new Label(composite_9, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridData gd_label = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_label.widthHint = 100;
		label.setLayoutData(gd_label);
		
		text = new Text(composite_9, SWT.BORDER | SWT.CENTER);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode==SWT.CR){
					clearTable();
					String str = text.getText().trim();
					if (str != null && !str.equals("")) {
						clickSearchFunc(btnName, str);
					}
				}
			}
		});
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textTishi(btnName, "focus");
			}
			@Override
			public void focusLost(FocusEvent e) {
				textTishi(btnName, "blur");
			}
		});
		text.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label label_2 = new Label(composite_9, SWT.NONE);
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridData gd_label_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label_2.widthHint = 30;
		label_2.setLayoutData(gd_label_2);
		
		btnNewButton_5 = new Button(composite_9, SWT.NONE);
		btnNewButton_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				clearTable();
				String str = text.getText().trim();
				if (str != null && !str.equals("")) {
					clickSearchFunc(btnName, str);
				}
			}
		});
		GridData gd_btnNewButton_5 = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_btnNewButton_5.widthHint = 122;
		btnNewButton_5.setLayoutData(gd_btnNewButton_5);
		btnNewButton_5.setText("\u67E5\u8BE2");
		
		Label label_1 = new Label(composite_9, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridData gd_label_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label_1.widthHint = 150;
		label_1.setLayoutData(gd_label_1);
		
		composite_10 = new Composite(composite_8, SWT.NONE);
		composite_10.setLayout(new BorderLayout(0, 0));
		composite_10.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite_10.setVisible(false);
		
		table = new Table(composite_10, SWT.BORDER | SWT.FULL_SELECTION );
		setLayoutData(BorderLayout.CENTER);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.stateMask == SWT.CTRL && e.keyCode == KEY_C){
					int selectRow = table.getSelectionIndex();
					TableItem item = table.getItem(selectRow); 
					String  str = item.getText(0);
					java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
		            StringSelection contents=new StringSelection(str); //用拷贝文本框文本实例化StringSelection对象  
		            clipboard.setContents(contents, null); //设置系统剪贴板内容  
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//获取鼠标点击的位置
				Point point = new Point(e.x, e.y);
				//得到鼠标点击的行（item）
				TableItem item = table.getItem(point); 
				if(item == null){
					return;
				}
				
				/*//获取所点击的cell
				int i = 0;
				for(; i < table.getColumnCount(); i++){
					Rectangle rect = item.getBounds(i);
					if (rect.contains(point)) {
						System.out.println(item.getText(i));
					}
				}*/
				java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
	            StringSelection contents=new StringSelection(item.getText(0)); //用拷贝文本框文本实例化StringSelection对象  
	            clipboard.setContents(contents, null); //设置系统剪贴板内容  
			}
		});
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		composite_3.setTabList(new Control[]{composite_4, composite_6});
		
		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		//gd_composite_2.heightHint = (int) (getShell().getSize().y*0.03);
		gd_composite_2.heightHint = 25;
		composite_2.setLayoutData(gd_composite_2);
		
		Label lblNewLabel_5 = new Label(composite_2, SWT.NONE);
		lblNewLabel_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_5.setAlignment(SWT.CENTER);
		lblNewLabel_5.setText("\u8BE5\u4E9A\u79D1\u6280\u2014\u2014\u4F01\u4E1A\u8FDB\u9500\u5B58\u7BA1\u7406\u7CFB\u7EDF");
		
		Label lblNewLabel_6 = new Label(composite_2, SWT.NONE);
		lblNewLabel_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_6.setAlignment(SWT.CENTER);
		lblNewLabel_6.setText("\u6B22\u8FCE\u4F7F\u7528\uFF01");
		
		Label lblNewLabel_7 = new Label(composite_2, SWT.NONE);
		lblNewLabel_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_7.setAlignment(SWT.CENTER);
		lblNewLabel_7.setText("\u6280\u672F\u670D\u52A1\u70ED\u7EBF\uFF1A13173033303");
		
		Label lblNewLabel_8 = new Label(composite_2, SWT.NONE);
		lblNewLabel_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_8.setAlignment(SWT.CENTER);
		lblNewLabel_8.setText("QQ：917785909");
		composite.setTabList(new Control[]{composite_1, composite_2});
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("\u8BE5\u4E9A\u79D1\u6280\u2014\u2014\u4F01\u4E1A\u8FDB\u9500\u5B58\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(0, 0, (int)(scrSize.width*0.9), (int)(scrSize.height*0.9));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public static void refreshTime() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Date date = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获取当前时间
				lblNewLabel.setText("时间：		"+df.format(date));
			}
		});
	}
	
	private void textTishi(String btn_name, String state){
		String str = text.getText().trim();
		switch (btn_name) {
		case "搜索":
			if(str.equals("请输入待查询的语句") || str==null || str.equals("")){
				if(state.equals("focus")){
					text.setText("");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				}
				if(state.equals("blur")){
					text.setText("请输入待查询的语句");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
			break;
		
		case "客户基本信息":
			if(str.equals("请输入待查询的客户ID") || str==null || str.equals("")){
				if(state.equals("focus")){
					text.setText("");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				}
				if(state.equals("blur")){
					text.setText("请输入待查询的客户ID");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
			break;
		

		case "商品基本信息":
			if(str.equals("请输入待查询的商品ID") || str==null || str.equals("")){
				if(state.equals("focus")){
					text.setText("");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				}
				if(state.equals("blur")){
					text.setText("请输入待查询的商品ID");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
			break;
			

		case "供应商基本信息":
			if(str.equals("请输入待查询的供应商ID") || str==null || str.equals("")){
				if(state.equals("focus")){
					text.setText("");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				}
				if(state.equals("blur")){
					text.setText("请输入待查询的供应商ID");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
			break;
			
		case "进货详情":
			if(str.equals("请输入待查询的进货ID") || str==null || str.equals("")){
				if(state.equals("focus")){
					text.setText("");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				}
				if(state.equals("blur")){
					text.setText("请输入待查询的进货ID");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
			break;
			
		case "返厂详情":
			if(str.equals("请输入待查询的返厂ID") || str==null || str.equals("")){
				if(state.equals("focus")){
					text.setText("");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				}
				if(state.equals("blur")){
					text.setText("请输入待查询的返厂ID");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
			break;
			
		case "销售详情":
			if(str.equals("请输入待查询的销售ID") || str==null || str.equals("")){
				if(state.equals("focus")){
					text.setText("");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				}
				if(state.equals("blur")){
					text.setText("请输入待查询的销售ID");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
			break;
			
		case "退货详情":
			if(str.equals("请输入待查询的退货ID") || str==null || str.equals("")){
				if(state.equals("focus")){
					text.setText("");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				}
				if(state.equals("blur")){
					text.setText("请输入待查询的退货ID");
					text.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				}
			}
			break;
		default:
			break;
		}
	}
	
	private void clearTable(){
		table.removeAll();
		int num = table.getColumnCount() - 1;
		for (int j = num; j >= 0; j--) {
			table.getColumn(j).dispose();
		}
	}
	
	private void clickSearchFunc(String btn_name,String content){
		switch (btn_name) {
		case "搜索":
			search sh = new search();
			try {
				get_table_ele(sh.run(content));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			break;

		case "客户基本信息":
			get_table_ele("select * from tb_khinfo where id = '"+content+"'");
			break;

		case "商品基本信息":
			get_table_ele("select * from tb_spinfo where id = '"+content+"'");
			break;
			
		case "供应商基本信息":
			get_table_ele("select * from tb_gysinfo where id = '"+content+"'");
			break;

		case "进货详情":
			get_table_ele("select * from tb_ruku where rukuid = '"+content+"'");
			break;

		case "返厂详情":
			get_table_ele("select * from tb_rkth where rkthid = '"+content+"'");
			break;

		case "销售详情":
			get_table_ele("select * from tb_sell where sellid = '"+content+"'");
			break;

		case "退货详情":
			get_table_ele("select * from tb_xsth where xsthid = '"+content+"'");
			break;

		default:
			break;
		}
	}
	
	private static void get_table_ele(String sql){
		try {
			ResultSet rs = Dao.findForResultSet(sql);
			ResultSetMetaData rsmd = rs.getMetaData();

			// step2: add columns
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				new TableColumn(table, SWT.CENTER).setText(rsmd.getColumnName(i + 1));
			}
			adjustTable(table);
			TableItem item = null;
			// step3: add rows
			while(rs.next()){
				item = new TableItem(table, SWT.NONE);
				int n = 1;
				for (int col = 0; col < rsmd.getColumnCount(); col++) {
					item.setText(col, rs.getString(n));
					n++;
				}
			}
			rs.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private static void adjustTable(Table ta) {
		int table_width = composite_10.getSize().x;
		int colCount = ta.getColumnCount();
		int percol_wideth = table_width/colCount;
		if(percol_wideth < 200)
			percol_wideth = 200;
		for (int i = 0; i < colCount; i++) {
			ta.getColumn(i).setWidth(percol_wideth);

			if (ta.getColumn(i).getText().equals("id")) {
				ta.getColumn(i).setText("ID");
			}
			if (ta.getColumn(i).getText().equals("spname")) {
				ta.getColumn(i).setText("商品名");
			}
			if (ta.getColumn(i).getText().equals("cd")) {
				ta.getColumn(i).setText("产地");
			}
			if (ta.getColumn(i).getText().equals("dw")) {
				ta.getColumn(i).setText("单位");
			}
			if (ta.getColumn(i).getText().equals("gg")) {
				ta.getColumn(i).setText("规格");
			}
			if (ta.getColumn(i).getText().equals("bz")) {
				ta.getColumn(i).setText("包装");
			}
			if (ta.getColumn(i).getText().equals("ph")) {
				ta.getColumn(i).setText("批号");
			}
			if (ta.getColumn(i).getText().equals("pzwh")) {
				ta.getColumn(i).setText("批准文号");
			}
			if (ta.getColumn(i).getText().equals("gysname")) {
				ta.getColumn(i).setText("供应商");
			}
			if (ta.getColumn(i).getText().equals("dz")) {
				ta.getColumn(i).setText("地址");
			}
			if (ta.getColumn(i).getText().equals("yzbm")) {
				ta.getColumn(i).setText("邮政编码");
			}
			if (ta.getColumn(i).getText().equals("dh")) {
				ta.getColumn(i).setText("电话");
			}
			if (ta.getColumn(i).getText().equals("cz")) {
				ta.getColumn(i).setText("传真");
			}
			if (ta.getColumn(i).getText().equals("lxr")) {
				ta.getColumn(i).setText("联系人");
			}
			if (ta.getColumn(i).getText().equals("lxdh")) {
				ta.getColumn(i).setText("联系电话");
			}
			if (ta.getColumn(i).getText().equals("yx")) {
				ta.getColumn(i).setText("邮箱");
			}
			if (ta.getColumn(i).getText().equals("dj")) {
				ta.getColumn(i).setText("单价");
			}
			if (ta.getColumn(i).getText().equals("kcsl")) {
				ta.getColumn(i).setText("库存数量");
			}
			if (ta.getColumn(i).getText().equals("khname")) {
				ta.getColumn(i).setText("客户名");
			}

			if (ta.getColumn(i).getText().equals("rkthid")) {
				ta.getColumn(i).setText("返厂ID");
			}
			if (ta.getColumn(i).getText().equals("rukuid")) {
				ta.getColumn(i).setText("进货ID");
			}
			if (ta.getColumn(i).getText().equals("sellid")) {
				ta.getColumn(i).setText("销售ID");
			}
			if (ta.getColumn(i).getText().equals("xsthid")) {
				ta.getColumn(i).setText("退货ID");
			}
			if (ta.getColumn(i).getText().equals("pzno")) {
				ta.getColumn(i).setText("品种ID");
			}
			if (ta.getColumn(i).getText().equals("spid")) {
				ta.getColumn(i).setText("商品ID");
			}
			if (ta.getColumn(i).getText().equals("sl")) {
				ta.getColumn(i).setText("数量");
			}
			if (ta.getColumn(i).getText().equals("je")) {
				ta.getColumn(i).setText("金额");
			}
			if (ta.getColumn(i).getText().equals("gysid")) {
				ta.getColumn(i).setText("供应商ID");
			}
			if (ta.getColumn(i).getText().equals("khid")) {
				ta.getColumn(i).setText("客户ID");
			}
			if (ta.getColumn(i).getText().equals("thrq")) {
				ta.getColumn(i).setText("返厂日期");
			}
			if (ta.getColumn(i).getText().equals("rukurq")) {
				ta.getColumn(i).setText("进货日期");
			}
			if (ta.getColumn(i).getText().equals("sellrq")) {
				ta.getColumn(i).setText("出售日期");
			}
			if (ta.getColumn(i).getText().equals("xsthrq")) {
				ta.getColumn(i).setText("退货日期");
			}
			if (ta.getColumn(i).getText().equals("jsr")) {
				ta.getColumn(i).setText("经手人");
			}
			if (ta.getColumn(i).getText().equals("jsfs")) {
				ta.getColumn(i).setText("经手方式");
			}

			if (ta.getColumn(i).getText().equals("jc")) {
				ta.getColumn(i).setText("简称");
			}
			if (ta.getColumn(i).getText().equals("name")) {
				ta.getColumn(i).setText("NAME");
			}
			if (ta.getColumn(i).getText().equals("yh")) {
				ta.getColumn(i).setText("银行");
			}
			if (ta.getColumn(i).getText().equals("yhkh")) {
				ta.getColumn(i).setText("银行卡号");
			}
		}
	}
	 public static Text getTextt(){
		 return text;
	 }
}
