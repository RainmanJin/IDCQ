package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import item.*;
import model.TbGysinfo;
import model.TbKc;
import model.TbKhinfo;
import model.TbRkthDetail;
import model.TbRkthMain;
import model.TbRukuDetail;
import model.TbRukuMain;
import model.TbSellDetail;
import model.TbSellMain;
import model.TbSpinfo;
import model.TbUserlist;
import model.TbXsthDetail;
import model.TbXsthMain;

public class Dao {
	protected static String second = null;
	public static Connection conn = null;
	//public static Statement stmt = null;
	static {
		try {
			if (conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/jcx?characterEncoding=utf8";// 定义所访问数据库
				String user = "root";
				String password = "122157";
				conn = DriverManager.getConnection(url, user, password);// 实现数据库连接
				
				// return conn;
				//stmt = conn.createStatement();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Dao() {
	}

	// 读取所有客户信息
	public static List getKhInfos() {
		List list = findForList("select id,khname from tb_khinfo");
		return list;
	}

	// 读取所有供应商信息
	public static List getGysInfos() {
		List list = findForList("select id,name from tb_gysinfo");
		return list;
	}

	// 读取客户信息
	public static TbKhinfo getKhInfo(Item item) {
		String where = "khname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		TbKhinfo info = new TbKhinfo();
		ResultSet set = findForResultSet("select * from tb_khinfo where " + where);
		try {
			if (set.next()) {
				info.setId(set.getString("id").trim());
				info.setKhName(set.getString("khname").trim());
				info.setJc(set.getString("jc").trim());
				info.setDz(set.getString("dz").trim());
				info.setYzbm(set.getString("yzbm").trim());
				info.setCz(set.getString("cz").trim());
				info.setYhkh(set.getString("yhkh").trim());
				info.setLxr(set.getString("lxr").trim());
				info.setLxdh(set.getString("lxdh").trim());
				info.setYx(set.getString("yx").trim());
				info.setDh(set.getString("dh").trim());
				info.setYhName(set.getString("yhname").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	// 读取指定供应商信息
	public static TbGysinfo getGysInfo(Item item) {
		String where = "name='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		TbGysinfo info = new TbGysinfo();
		ResultSet set = findForResultSet("select * from tb_gysinfo where " + where);
		try {
			if (set.next()) {
				info.setId(set.getString("id").trim());
				info.setDz(set.getString("dz").trim());
				info.setYzbm(set.getString("yzbm").trim());
				info.setCz(set.getString("cz").trim());
				info.setJc(set.getString("jc").trim());
				info.setLxr(set.getString("lxr").trim());
				info.setLxdh(set.getString("lxdh").trim());
				info.setYx(set.getString("yx").trim());
				info.setName(set.getString("name").trim());
				info.setDh(set.getString("dh").trim());
				info.setYh(set.getString("yh").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	// 执行指定查询
	public static ResultSet query(String QueryStr) {
		ResultSet set = findForResultSet(QueryStr);
		return set;
	}

	// 执行删除
	public static int delete(String sql) {
		return update(sql);
	}

	// 添加客户信息的方法
	public static boolean addKeHu(TbKhinfo khinfo) {
		if (khinfo == null)
			return false;
		return insert("insert tb_khinfo values('" + khinfo.getId() + "','" + khinfo.getKhName() + "','" + khinfo.getJc()
				+ "','" + khinfo.getDz() + "','" + khinfo.getYzbm() + "','" + khinfo.getDh() + "','" + khinfo.getCz()
				+ "','" + khinfo.getLxr() + "','" + khinfo.getLxdh() + "','" + khinfo.getYx() + "','"
				+ khinfo.getYhName() + "','" + khinfo.getYhkh() + "')");
	}

	// 修改客户信息的方法
	public static int updateKeHu(TbKhinfo khinfo) {
		return update("update tb_khinfo set jc='" + khinfo.getJc() + "',dz='" + khinfo.getDz() + "',yzbm='"
				+ khinfo.getYzbm() + "',dh='" + khinfo.getDh() + "',cz='" + khinfo.getCz() + "',lxr='" + khinfo.getLxr()
				+ "',lxdh='" + khinfo.getLxdh() + "',yx='" + khinfo.getYx() + "',yhname='" + khinfo.getYhName()
				+ "',yhkh='" + khinfo.getYhkh() + "' where id='" + khinfo.getId() + "'");
	}

	// 修改库存的方法
	public static int updateKucunDj(TbKc kcInfo) {
		return update("update tb_kc set dj=" + kcInfo.getDj() + " where id='" + kcInfo.getId() + "'");
	}

	// 修改供应商信息的方法
	public static int updateGys(TbGysinfo gysInfo) {
		return update("update tb_gysinfo set jc='" + gysInfo.getJc() + "',dz='" + gysInfo.getDz() + "',yzbm='"
				+ gysInfo.getYzbm() + "',dh='" + gysInfo.getDh() + "',cz='" + gysInfo.getCz() + "',lxr='"
				+ gysInfo.getLxr() + "',lxdh='" + gysInfo.getLxdh() + "',yx='" + gysInfo.getYx() + "',yh='"
				+ gysInfo.getYh() + "' where id='" + gysInfo.getId() + "'");
	}

	// 添加商品
	public static boolean addSp(TbSpinfo spInfo) {
		if (spInfo == null)
			return false;
		return insert("insert tb_spinfo values('" + spInfo.getId() + "','" + spInfo.getSpname() + "','" + spInfo.getJc()
				+ "','" + spInfo.getCd() + "','" + spInfo.getDw() + "','" + spInfo.getGg() + "','" + spInfo.getBz()
				+ "','" + spInfo.getPh() + "','" + spInfo.getPzwh() + "','" + spInfo.getMemo() + "','"
				+ spInfo.getGysname() + "')");
	}

	// 更新商品
	public static int updateSp(TbSpinfo spInfo) {
		return update("update tb_spinfo set jc='" + spInfo.getJc() + "',cd='" + spInfo.getCd() + "',dw='"
				+ spInfo.getDw() + "',gg='" + spInfo.getGg() + "',bz='" + spInfo.getBz() + "',ph='" + spInfo.getPh()
				+ "',pzwh='" + spInfo.getPzwh() + "',memo='" + spInfo.getMemo() + "',gysname='" + spInfo.getGysname()
				+ "' where id='" + spInfo.getId() + "'");
	}

	// 读取商品信息
	public static TbSpinfo getSpInfo(Item item) {
		String where = "spname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_spinfo where " + where);
		TbSpinfo spInfo = new TbSpinfo();
		try {
			if (rs.next()) {
				spInfo.setId(rs.getString("id").trim());
				spInfo.setBz(rs.getString("bz").trim());
				spInfo.setCd(rs.getString("cd").trim());
				spInfo.setDw(rs.getString("dw").trim());
				spInfo.setGg(rs.getString("gg").trim());
				spInfo.setGysname(rs.getString("gysname").trim());
				spInfo.setJc(rs.getString("jc").trim());
				spInfo.setMemo(rs.getString("memo").trim());
				spInfo.setPh(rs.getString("ph").trim());
				spInfo.setPzwh(rs.getString("pzwh").trim());
				spInfo.setSpname(rs.getString("spname").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spInfo;
	}

	// 获取所有商品信息
	public static List getSpInfos() {
		List list = findForList("select * from tb_spinfo");
		return list;
	}

	// 获取库存商品信息
	public static TbKc getKc(Item item) {
		String where = "spname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_kc where " + where);
		TbKc kucun = new TbKc();
		try {
			if (rs.next()) {
				kucun.setId(rs.getString("id"));
				kucun.setSpname(rs.getString("spname"));
				kucun.setJc(rs.getString("jc"));
				kucun.setBz(rs.getString("bz"));
				kucun.setCd(rs.getString("cd"));
				kucun.setDj(rs.getDouble("dj"));
				kucun.setDw(rs.getString("dw"));
				kucun.setGg(rs.getString("gg"));
				kucun.setKcsl(rs.getInt("sl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kucun;
	}

	// 获取入库单的最大ID，即最大入库票号
	public static String getRuKuMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_ruku_main", "RK", "rkid");
	}

	// 在事务中添加入库信息
	public static boolean insertRukuInfo(TbRukuMain ruMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加入库主表记录
			insert("insert into tb_ruku_main values('" + ruMain.getRkId() + "','" + ruMain.getPzs() + "',"
					+ ruMain.getJe() + ",'" + ruMain.getYsjl() + "','" + ruMain.getGysname() + "','"
					+ ruMain.getRkdate() + "','" + ruMain.getCzy() + "','" + ruMain.getJsr() + "','" + ruMain.getJsfs()
					+ "')");
			Set<TbRukuDetail> rkDetails = ruMain.getTabRukuDetails();
			int pzno = 0;
			double rkthje = 0;
			for (Iterator<TbRukuDetail> iter = rkDetails.iterator(); iter.hasNext();) {
				TbRukuDetail details = iter.next();
				// 添加入库详细表记录
				insert("insert into tb_ruku_detail values('" + ruMain.getRkId() + "','" + details.getTabSpinfo() + "',"
						+ details.getDj() + "," + details.getSl() + ")");
				//添加tb_rkth表记录
				rkthje = details.getDj() * details.getSl();
				String sql = "insert into tb_ruku values('" + ruMain.getRkId() + "','" + pzno + "','"
						+ details.getTabSpinfo() + "','"+ details.getDj() + "','" + details.getSl() + "','" 
						+ rkthje + "','" + ruMain.getGysid() + "','" + ruMain.getRkdate() + "','" 
						+ ruMain.getJsr() + "','" + ruMain.getJsfs() + "')";
				insert(sql);
				//System.out.println(sql);
				pzno++;
				// 添加或修改库存表记录
				Item item = new Item();
				item.setId(details.getTabSpinfo());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().equals("")) {
					TbKc kucun = getKc(item);
					if (kucun.getId() == null || kucun.getId().equals("")) {
						insert("insert into tb_kc values('" + spInfo.getId() + "','" + spInfo.getSpname() + "','"
								+ spInfo.getJc() + "','" + spInfo.getCd() + "','" + spInfo.getGg() + "','"
								+ spInfo.getBz() + "','" + spInfo.getDw() + "'," + details.getDj() + ","
								+ details.getSl() + ")");
					} else {
						int sl = kucun.getKcsl() + details.getSl();
						update("update tb_kc set kcsl=" + sl + ",dj=" + details.getDj() + " where id='" + kucun.getId()
								+ "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return true;
	}

	// 获取退货最大ID
	public static String getRkthMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_rkth_main", "RT", "rkthId");
	}

	// 在事务中添加入库退货信息
	public static boolean insertRkthInfo(TbRkthMain rkthMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加入库退货主表记录
			insert("insert into tb_rkth_main values('" + rkthMain.getRkthId() + "','" + rkthMain.getPzs() + "',"
					+ rkthMain.getJe() + ",'" + rkthMain.getYsjl() + "','" + rkthMain.getGysname() + "','"
					+ rkthMain.getRtdate() + "','" + rkthMain.getCzy() + "','" + rkthMain.getJsr() + "','"
					+ rkthMain.getJsfs() + "')");
			Set<TbRkthDetail> rkDetails = rkthMain.getTbRkthDetails();
			int pzno = 0;
			double rkthje = 0;
			for (Iterator<TbRkthDetail> iter = rkDetails.iterator(); iter.hasNext();) {
				TbRkthDetail details = iter.next();
				// 添加入库详细表记录
				insert("insert into tb_rkth_detail values('" + rkthMain.getRkthId() + "','" + details.getSpid() + "',"
						+ details.getDj() + "," + details.getSl() + ")");
				//添加tb_rkth表记录
				rkthje = details.getDj() * details.getSl();
				String sql = "insert into tb_rkth values('" + rkthMain.getRkthId() + "','" + pzno + "','"
						+ details.getSpid() + "','"+ details.getDj() + "','" + details.getSl() + "','" 
						+ rkthje + "','" + rkthMain.getGysid() + "','" + rkthMain.getRtdate() + "','" 
						+ rkthMain.getJsr() + "','" + rkthMain.getJsfs() + "')";
				insert(sql);
				//System.out.println(sql);
				pzno++;
				// 添加或修改库存表记录
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().equals("")) {
					TbKc kucun = getKc(item);
					if (kucun.getId() != null && !kucun.getId().equals("")) {
						int sl = kucun.getKcsl() - details.getSl();
						update("update tb_kc set kcsl=" + sl + " where id='" + kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// 获取销售主表最大ID
	public static String getSellMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_sell_main", "XS", "sellID");
	}

	// 在事务中添加销售信息
	public static boolean insertSellInfo(TbSellMain sellMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加销售主表记录
			insert("insert into tb_sell_main values('" + sellMain.getSellId() + "','" + sellMain.getPzs() + "',"
					+ sellMain.getJe() + ",'" + sellMain.getYsjl() + "','" + sellMain.getKhname() + "','"
					+ sellMain.getXsdate() + "','" + sellMain.getCzy() + "','" + sellMain.getJsr() + "','"
					+ sellMain.getJsfs() + "')");
			Set<TbSellDetail> rkDetails = sellMain.getTbSellDetails();
			int pzno = 0;
			double rkthje = 0;
			for (Iterator<TbSellDetail> iter = rkDetails.iterator(); iter.hasNext();) {
				TbSellDetail details = iter.next();
				// 添加销售详细表记录
				insert("insert into tb_sell_detail values('" + sellMain.getSellId() + "','" + details.getSpid() + "',"
						+ details.getDj() + "," + details.getSl() + ")");
				//添加tb_rkth表记录
				rkthje = details.getDj() * details.getSl();
				String sql = "insert into tb_sell values('" + sellMain.getSellId() + "','" + pzno + "','"
						+ details.getSpid() + "','"+ details.getDj() + "','" + details.getSl() + "','" 
						+ rkthje + "','" + sellMain.getKhid() + "','" + sellMain.getXsdate() + "','" 
						+ sellMain.getJsr() + "','" + sellMain.getJsfs() + "')";
				insert(sql);
				//System.out.println(sql);
				pzno++;
				// 修改库存表记录
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().equals("")) {
					TbKc kucun = getKc(item);
					if (kucun.getId() != null && !kucun.getId().equals("")) {
						int sl = kucun.getKcsl() - details.getSl();
						update("update tb_kc set kcsl=" + sl + " where id='" + kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// 获取根类主表最大ID
	private static String getMainTypeTableMaxId(Date date, String table, String idChar, String idName) {
		String dateStr = date.toString().replace("-", "");
		String id = idChar + dateStr;
		String sql = "select max(" + idName + ") from " + table + " where " + idName + " like '" + id + "%'";
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseId = baseId == null ? "000" : baseId.substring(baseId.length() - 3);
		int idNum = Integer.parseInt(baseId) + 1;
		id += String.format("%03d", idNum);
		return id;
	}

	public static String getXsthMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_xsth_main", "XT", "xsthID");
	}

	public static List getKucunInfos() {
		List list = findForList("select id,spname,dj,sl from tb_kc");
		return list;
	}

	// 在事务中添加销售退货信息
	public static boolean insertXsthInfo(TbXsthMain xsthMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加销售退货主表记录
			insert("insert into tb_xsth_main values('" + xsthMain.getXsthId() + "','" + xsthMain.getPzs() + "',"
					+ xsthMain.getJe() + ",'" + xsthMain.getYsjl() + "','" + xsthMain.getKhname() + "','"
					+ xsthMain.getThdate() + "','" + xsthMain.getCzy() + "','" + xsthMain.getJsr() + "','"
					+ xsthMain.getJsfs() + "')");
			Set<TbXsthDetail> xsthDetails = xsthMain.getTbXsthDetails();
			int pzno = 0;
			double rkthje = 0;
			for (Iterator<TbXsthDetail> iter = xsthDetails.iterator(); iter.hasNext();) {
				TbXsthDetail details = iter.next();
				// 添加销售退货详细表记录
				insert("insert into tb_xsth_detail values('" + xsthMain.getXsthId() + "','" + details.getSpid() + "',"
						+ details.getDj() + "," + details.getSl() + ")");
				//添加tb_rkth表记录
				rkthje = details.getDj() * details.getSl();
				String sql = "insert into tb_xsth values('" + xsthMain.getXsthId() + "','" + pzno + "','"
						+ details.getSpid() + "','"+ details.getDj() + "','" + details.getSl() + "','" 
						+ rkthje + "','" + xsthMain.getKhid() + "','" + xsthMain.getThdate() + "','" 
						+ xsthMain.getJsr() + "','" + xsthMain.getJsfs() + "')";
				insert(sql);
				//System.out.println(sql);
				pzno++;
				// 修改库存表记录
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().equals("")) {
					TbKc kucun = getKc(item);
					if (kucun.getId() != null && !kucun.getId().equals("")) {
						int sl = kucun.getKcsl() + details.getSl();
						update("update tb_kc set kcsl=" + sl + " where id='" + kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// 添加用户
	public static int addUser(TbUserlist ul) {
		return update("insert tb_yhlist values('" + ul.getUsername() + "','" + ul.getName() + "','" + ul.getPass()
				+ "','" + ul.getQuan() + "')");
	}

	public static List getUsers() {
		List list = findForList("select * from tb_yhlist");
		return list;
	}

	// 修改用户方法
	public static int updateUser(TbUserlist user) {
		return update(
				"update tb_yhlist set name='" + user.getName() + "',username='" + user.getUsername() + "',password='"
						+ user.getPass() + "',qx='" + user.getQuan() + "' where username='" + user.getUsername() + "'");
	}

	// 获取用户对象的方法
	public static TbUserlist getUser(Item item) {
		String where = "username='" + item.getName() + "'";
		if (item.getId() != null)
			where = "name='" + item.getId() + "'"+" && "+where;
		ResultSet rs = findForResultSet("select * from tb_yhlist where " + where);
		TbUserlist user = new TbUserlist();
		try {
			if (rs.next()) {
				user.setName(rs.getString("name").trim());
				user.setUsername(rs.getString("username").trim());
				user.setPass(rs.getString("password").trim());
				user.setQuan(rs.getString("qx").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static boolean addGys(TbGysinfo gysInfo) {
		if (gysInfo == null) {
			return false;
		}
		return insert("insert tb_gysinfo values('" + gysInfo.getId() + "','" + gysInfo.getName() + "','"
				+ gysInfo.getJc() + "','" + gysInfo.getDz() + "','" + gysInfo.getYzbm() + "','" + gysInfo.getDh()
				+ "','" + gysInfo.getCz() + "','" + gysInfo.getLxr() + "','" + gysInfo.getLxdh() + "','"
				+ gysInfo.getYx() + "','" + gysInfo.getYh() + "')");
	}

	/*
	 * public static TbUserlist getUser(String name, String password) {
	 * System.out.println("12"); TbUserlist user = new TbUserlist();
	 * System.out.println("13"); ResultSet rs = findForResultSet(
	 * "select * from tb_yhlist where username='" + name + "'"); try { if
	 * (rs.next()) { user.setUsername(name);
	 * user.setPass(rs.getString("password")); if
	 * (user.getPass().equals(password)) { user.setName(rs.getString("name"));
	 * user.setQuan(rs.getString("qx")); } } } catch (SQLException e) {
	 * e.printStackTrace(); } return user; }
	 */
	public static TbUserlist getUser(String quanx, String name, String password) {
		TbUserlist user = new TbUserlist();
		String sql = "select * from tb_yhlist where name='" + quanx + "' and username='" + name + "'";
		ResultSet rs = findForResultSet(sql);
		//System.out.println(sql);
		try {
			if ( rs.next() ) {
				user.setUsername(name);
				user.setPass(rs.getString("password"));
				if (user.getPass().equals(password)) {
					user.setName(rs.getString("name"));
					user.setQuan(rs.getString("qx"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static ResultSet findForResultSet(String sql) {
		if (conn == null) {
			System.out.println("null");
			return null;
		}
		long time = System.currentTimeMillis();
		ResultSet rs = null;
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			second = ((System.currentTimeMillis() - time) / 1000d) + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static List findForList(String sql) {
		List<List> list = new ArrayList<List>();
		ResultSet rs = findForResultSet(sql);
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				for (int i = 1; i <= colCount; i++) {
					String str = rs.getString(i);
					if (str != null && !str.equals(""))
						str = str.trim();
					row.add(str);
				}
				list.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int update(String sql) {
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean insert(String sql) {
		boolean result = false;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
