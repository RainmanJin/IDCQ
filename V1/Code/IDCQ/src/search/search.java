package search;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.*;

import dao.Dao;
import edu.fudan.ml.types.Dictionary;
import edu.fudan.nlp.cn.ner.*;
import edu.fudan.nlp.cn.tag.CWSTagger;

public class search {
	private static TimeUnit[] unit = null;
	private static int time_index = -1;
	private static String yuju;	//用于确定输入语句的时间词
	private static String ci[];
	private static String cixing1[];
	private static String cixing2[];
	private static String cixing3[];
	private static Connection conn = null;
	// 取得根目录路径
	// private String rootPath =
	// getClass().getResource("/").getFile().toString();

	private static void Printshuzu(String str[]) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] != null)
				System.out.print(str[i] + " ");
		}
		System.out.println();
	}

	public static String fenci(String str) throws Exception {
		String str2[] = null;
		int aaaa = -1;
		if (unit.length > 0) {
			str2 = unit[0].toString().split(" ---> ");
			aaaa = str.indexOf(str2[0]);
			if (aaaa == 0)
				str = str.substring(str2[0].length());
		}

		CWSTagger tag = new CWSTagger("src/dictionary/seg.m",new Dictionary("src/dictionary/dict.txt"));
		str = tag.tag(str);
		if (aaaa == 0)
			return str2[1] + " " + str;
		else
			return str;
	}

	public static String[] get_ci(String str) throws Exception {
		str = fenci(str);
		System.out.println(str);
		ci = str.split(" ");
		str = "";
		int index = 0;
		String zuihou[] = new String[ci.length];
		zuihou[index] = ci[0];
		while (ci.length > 1) {
			index++;
			for (int i = 1; i < ci.length; i++)
				str += ci[i];
			str = fenci(str);
			System.out.println(str);
			ci = str.split(" ");
			str = "";
			zuihou[index] = ci[0];

			/*
			 * check_time(ci[0]); if(unit.length >0){ String str2[] =
			 * unit[0].toString().split(" ---> "); time_index = index; unit
			 * =null; }
			 */
			if (unit.length > 0) {
				String str2[] = unit[0].toString().split(" ---> ");
				if (ci[0].equals(str2[1])) {
					// cixing1[index]=ci[0];
					time_index = index;
				}
			}
		}
		return zuihou;
	}

	public static String get_cixing(String path, String str) throws IOException {// 返回每个词的词性
		Scanner scanner = new Scanner(new FileInputStream(path), "utf-8");
		while (scanner.hasNext()) {
			String line = scanner.nextLine().trim();
			if (line.length() > 0) {
				// line = line.replaceAll("[?]", "");解决第一行乱码问题，但是由于编码不统一，未能解决
				String a[] = line.split(" ");
				if (a[0].equals(str)) {
					scanner.close();
					return a[1];
				}
			}
		}
		scanner.close();

		/*
		 * File file = new File(path); if (!file.exists() || file.isDirectory())
		 * throw new FileNotFoundException(); BufferedReader br = new
		 * BufferedReader(new FileReader(file)); String temp = null; temp =
		 * br.readLine(); while (temp != null) { String a[] = temp.split(" ");
		 * if (a[0].equals(str)){ br.close(); return a[1]; } temp =
		 * br.readLine(); } br.close();
		 */
		return null;
	}

	private static void refreshyuju() {// 重构输入语句，处理日期格式的多样性
		if (unit.length > 0) {
			String str[] = unit[0].toString().split(" ---> ");
			String regex = "([0-9]|[一二三四五六七八九十]|(十一)|(十二))月[份]?";
			yuju = yuju.replaceAll(regex, str[0]);
			regex = "([0-9]|[零一二三四五六七八九]){2,4}年[度]?";
			yuju = yuju.replaceAll(regex, str[0]);

			// Pattern p = Pattern.compile(regex);
			// Matcher m = p.matcher(yuju);
			// while (m.find()) {
			// String s = m.group();
			// System.out.println(s);
			// }
		}
	}

	private static void check_time(String target) {// 检查分词数组中是否有时间
		TimeNormalizer normalizer;
		normalizer = new TimeNormalizer("src/dictionary/TimeExp.m");
		normalizer.parse(target);
//		System.out.println("Before Refreshed: " + yuju);
		unit = normalizer.getTimeUnit();
		refreshyuju();

		for (int i = 0; i < unit.length; i++) {
			System.out.println(unit[i]);
		}
//		System.out.println("After Refreshed: " + yuju);
	}

	/*
	 * private static int ack_borORret() {//如果是借书返回1；还书返回2 int abr=-1;
	 * if(check_string(cixing1, "借书")) return 0; if(check_string(cixing1, "还书"))
	 * return 1; return abr; }
	 */

	private static String format_time(String time) throws ParseException {
		SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy年");
		SimpleDateFormat sdf_0 = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月");
		SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf_2 = new SimpleDateFormat("yyyy-MM-dd");
		int year, month, date;
		String str;
		java.util.Date right_time = null;
		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
		if (time.length() > 8) {
			c.setTime(sdf2.parse(time));
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH) + 1;
			date = c.get(Calendar.DATE);
			str = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(date);
			right_time = sdf_2.parse(str);
			str = sdf_2.format(right_time);
		} else if (time.length() > 5) {
			c.setTime(sdf1.parse(time));
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH) + 1;
			str = Integer.toString(year) + "-" + Integer.toString(month);
			right_time = sdf_1.parse(str);
			str = sdf_1.format(right_time);
		} else {
			c.setTime(sdf0.parse(time));
			year = c.get(Calendar.YEAR);
			str = Integer.toString(year);
			right_time = sdf_0.parse(str);
			str = sdf_0.format(right_time);
		}
		return str;
	}

	public static void ensure_cixing(String path) throws IOException, ParseException {// 确定词性（传递性）匹配3次
		cixing1 = new String[ci.length];
		cixing2 = new String[ci.length];
		cixing3 = new String[ci.length];
		System.out.print("cixing1[]:	");
		for (int i = 0; i < ci.length; i++) {
			cixing1[i] = get_cixing(path, ci[i]);
			System.out.print(cixing1[i] + " ");
		}
		if (time_index != -1)
			cixing1[time_index] = "'" + format_time(ci[time_index]) + "'";
		// Printshuzu(cixing1);

		System.out.println();
		System.out.print("cixing2[]:	");
		for (int i = 0; i < ci.length; i++) {
			cixing2[i] = get_cixing(path, cixing1[i]);
			System.out.print(cixing2[i] + " ");
		}
		// Printshuzu(cixing2);

		System.out.println();
		System.out.print("cixing3[]:	");
		for (int i = 0; i < ci.length; i++) {
			cixing3[i] = get_cixing(path, cixing2[i]);
			System.out.print(cixing3[i] + " ");
		}
		System.out.println();
		
		if (time_index != -1) {
			/*
			 * if(ack_borORret()==0) cixing3[time_index] = "借出时间";
			 */
			cixing3[time_index] = "rq";
		}
		// Printshuzu(cixing3);
	}

	private static boolean check_string(String d[], String str) {// 存在返回true
		boolean exsit = false;
		for (int i = 0; i < d.length; i++)
			if (d[i] != null && d[i].equals(str))
				exsit = true;
		return exsit;
	}

	private static int[] ack_table_by_uniq(String att[], int tag_att[]) {// 通过独立属性区分
		// tb_rkth,tb_ruku,tb_sell,tb_xsth 4个表
		// tb_gysinfo,tb_khinfo 2个表
		// mark[0]记录是否匹配到表，为1表示匹配到
		int mark[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int index = 0; att[index] != null; index++) {
			if (att[index].equals("返厂") || att[index].equals("rkthid") || att[index].equals("rkthrq")) {
				mark[0] = 1;
				mark[1] = 1;
				tag_att[index] = 1;
			}
			if (att[index].equals("进货") || att[index].equals("rukuid") || att[index].equals("rukurq")) {
				mark[0] = 1;
				mark[2] = 1;
				tag_att[index] = 1;
			}
			if (att[index].equals("销售") || att[index].equals("sellid") || att[index].equals("sellrq")) {
				mark[0] = 1;
				mark[3] = 1;
				tag_att[index] = 1;
			}
			if (att[index].equals("退货") || att[index].equals("xsthid") || att[index].equals("xsthrq")) {
				mark[0] = 1;
				mark[4] = 1;
				tag_att[index] = 1;
			}
			if (att[index].equals("供应商") || att[index].equals("gysid") || att[index].equals("gysname")) {
				mark[0] = 1;
				mark[5] = 1;
				tag_att[index] = 1;
			}
			if (att[index].equals("客户") || att[index].equals("khid") || att[index].equals("khname")) {
				mark[0] = 1;
				mark[6] = 1;
				tag_att[index] = 1;
			}
			if (att[index].equals("商品") || att[index].equals("spid") || att[index].equals("spname")) {
				mark[0] = 1;
				mark[7] = 1;
				tag_att[index] = 1;
			}
			/*
			 * if (check_string(ci, "管理员")) { mark[0] = 1; mark[2] = 1;
			 * tag_att[index] = 1; }
			 */
		}
		return mark;
	}

	private static int ack_c_name(String att[], int tag_att[]) {// 确定顾客姓名在
		// user/ministrator
		// 2个表中的位置（存在优先级）
		// 分别返回0,1.若无姓名返回-1；若有姓名而都没匹配到,返回3
		int remark = -1;
		int index = 0, in = cixing1.length, tttt = cixing1.length;
		String c_name = null;
		for (; index < in; index++) {
			if (cixing1[index] != null) {
				if (cixing1[index].equals("用户名")) {
					c_name = ci[index];
					break;
				}
				if (cixing3[index] != null)
					if (cixing3[index].equals("用户名")) {
						c_name = ci[index];
						break;
					}
				if (cixing1[index].equals("tttt"))
					tttt = index;
			}
		}
		if (index < tttt) {
			for (int i = 0; i < tag_att.length; i++) {
				if (att[i].equals("用户名"))
					tag_att[i] = 1;
			}
			try {
				// Connect();
				String sql0 = "select 用户名 from user where 用户名='" + c_name + "'";
				String sql1 = "select 用户名 from ministrator where 用户名='" + c_name + "'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql0);
				if (rs.next())
					remark = 0;
				else {
					rs = st.executeQuery(sql1);
					if (rs.next())
						remark = 1;
					else
						remark = 3;
				}
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return remark;
	}

	private static String[] get_all_attributes() {
		String att[] = new String[50];
		int num = 0;
		int length = cixing1.length;
		int i;
		for (i = length - 1; i >= 0; i--) {
			if (cixing1[i] != null) {
				if (cixing1[i].equals("tttt"))
					break;
				if (!cixing1[i].equals("and"))
					att[num++] = cixing1[i];
			}
		}
		for (int j = 0; j < i; j++) {
			if (cixing1[j] != null) {
				// if (cixing1[j].equals("=") && cixing3[j + 1] == null)
				// att[num++] = cixing1[j - 1];
				if (checkOperator(cixing1[j]) && cixing3[j + 1] == null)
					att[num++] = cixing1[j - 1];
				if (cixing3[j] != null)
					att[num++] = cixing3[j];
			}
		}
		return att;
	}

	private static boolean check_tag_att(int tag_att[]) {// 判断是否所有属性都已经和表关联。是返回true
		boolean bl = true;
		for (int i = 0; i < tag_att.length; i++)
			if (tag_att[i] != 1)
				bl = false;
		return bl;
	}

	public static String[] ensure_dbtable_1(String att[], int tag_att[]) {
		String dbtable[] = new String[50];
		int mark[] = ack_table_by_uniq(att, tag_att);
		for (int i = 0; i < mark.length; i++)
			System.out.print("mark[" + i + "]:" + mark[i] + " ");
		System.out.println();
		/*
		 * int remark = -1; if (mark[0] == 0) {// 没有在独立属性上匹配到表 remark =
		 * ack_c_name(att, tag_att); }
		 * 
		 * if (remark == 3) {// 姓名未匹配上 System.out.println("=============");
		 * return dbtable; }
		 */
		int end = tag_att.length;
		for (int index = 0; att[index] != null && !check_tag_att(tag_att); index++) {
			if (mark[1] == 1) {
				dbtable[0] = "tb_rkth";
				for (int i = 0; i < end; i++) {
					if (tag_att[i] == 0) {
						if (att[i].equals("ruthid") || att[i].equals("pzno") || att[i].equals("spid")
								|| att[i].equals("dj") || att[i].equals("sl") || att[i].equals("je")
								|| att[i].equals("gysid") || att[i].equals("thrq") || att[i].equals("jsr")
								|| att[i].equals("jsfs"))
							tag_att[i] = 1;
					}
				}
			}

			if (mark[2] == 1) {
				dbtable[1] = "tb_ruku";
				for (int i = 0; i < end; i++) {
					if (tag_att[i] == 0) {
						if (att[i].equals("rukuid") || att[i].equals("pzno") || att[i].equals("spid")
								|| att[i].equals("dj") || att[i].equals("sl") || att[i].equals("je")
								|| att[i].equals("gysid") || att[i].equals("rukurq") || att[i].equals("jsr")
								|| att[i].equals("jsfs"))
							tag_att[i] = 1;
					}
				}
			}

			if (mark[3] == 1) {
				dbtable[2] = "tb_sell";
				for (int i = 0; i < end; i++) {
					if (tag_att[i] == 0) {
						if (att[i].equals("sellid") || att[i].equals("pzno") || att[i].equals("spid")
								|| att[i].equals("dj") || att[i].equals("sl") || att[i].equals("je")
								|| att[i].equals("khid") || att[i].equals("sellrq") || att[i].equals("jsr")
								|| att[i].equals("jsfs"))
							tag_att[i] = 1;
					}
				}
			}

			if (mark[4] == 1) {
				dbtable[3] = "tb_xsth";
				for (int i = 0; i < end; i++) {
					if (tag_att[i] == 0) {
						if (att[i].equals("xsthid") || att[i].equals("pzno") || att[i].equals("spid")
								|| att[i].equals("dj") || att[i].equals("sl") || att[i].equals("je")
								|| att[i].equals("khid") || att[i].equals("xsthrq") || att[i].equals("jsr")
								|| att[i].equals("jsfs"))
							tag_att[i] = 1;
					}
				}
			}

			if (mark[5] == 1) {
				dbtable[4] = "tb_gysinfo";
				for (int i = 0; i < end; i++) {
					if (tag_att[i] == 0) {
						if (att[i].equals("gysid") || att[i].equals("gysname") || att[i].equals("dz")
								|| att[i].equals("yzbm") || att[i].equals("cz") || att[i].equals("lxr")
								|| att[i].equals("lxdh") || att[i].equals("yx"))
							tag_att[i] = 1;
						// if(att[i].equals("gysid")) att[i] = "id";
						// if(att[i].equals("gysname")) att[i] = "name";
					}
				}
			}

			if (mark[6] == 1) {
				dbtable[6] = "tb_khinfo";
				for (int i = 0; i < end; i++) {
					if (tag_att[i] == 0) {
						if (att[i].equals("khid") || att[i].equals("khname") || att[i].equals("dz")
								|| att[i].equals("yzbm") || att[i].equals("cz") || att[i].equals("lxr")
								|| att[i].equals("lxdh") || att[i].equals("yx"))
							tag_att[i] = 1;
					}
				}
			}

			if (mark[7] == 1) {
				dbtable[7] = "tb_spinfo";
				for (int i = 0; i < end; i++) {
					if (tag_att[i] == 0) {
						if (att[i].equals("spid") || att[i].equals("spname") || att[i].equals("dz")
								|| att[i].equals("yzbm") || att[i].equals("cz") || att[i].equals("lxr")
								|| att[i].equals("lxdh") || att[i].equals("yx"))
							tag_att[i] = 1;
						// if (att[i].equals("khid")) att[i] = "id";
					}
				}
			}

			if (att[index].equals("kcsl") || att[index].equals("库存") || att[index].equals("dj")) {
				dbtable[5] = "tb_kc";
				tag_att[index] = 1;
				for (int i = 0; i < end; i++) {
					if (att[i].equals("kcid")) {
						tag_att[i] = 1;
						att[i] = "id";
					}
				}
			}

			if (att[index].equals("spid") || att[index].equals("spname") || att[index].equals("cd")
					|| att[index].equals("dw") || att[index].equals("gg") || att[index].equals("bz")
					|| att[index].equals("ph") || att[index].equals("pzwh")) {
				dbtable[7] = "tb_spinfo";
				tag_att[index] = 1;
				for (int i = 0; i < end; i++) {
					if (att[i].equals("id"))
						tag_att[i] = 1;
					if (att[i].equals("sl") && dbtable[0] != null && dbtable[2] != null && dbtable[3] != null) {
						tag_att[i] = 1;
						dbtable[1] = "tb_ruku";
					}
				}
			}
			/*
			 * if (mark[0] == 0 && remark == -1 && dbtable[3] == null &&
			 * dbtable[4] == null) {// 所有表都没有匹配上,判断是否出现表间公共属性 for (int i = 0; i
			 * < end; i++) { if (check_string(att, "BID") && check_string(att,
			 * "UID")) { dbtable[1] = "bor"; for (int j = 0; j < end; j++) { if
			 * (att[j].equals("r_no")) tag_att[i] = 1; if
			 * (att[j].equals("r_type")) tag_att[i] = 1; } } } }
			 */
		}
		return dbtable;
	}

	private static void ensure_table_linkable(String from[]) {
		if (from[2] != null && from[3] != null) {
			if (from[7] == null)
				from[6] = "tb_sell";
		}
	}

	private static String ack_qianzhui(String from[], String str) {
		if (str.equals("spid"))
			str = "tb_spinfo.id";
		if (str.equals("gysid"))
			str = "tb_gysinfo.id";
		if (str.equals("gysname"))
			str = "tb_gysinfo.name";
		if (str.equals("rukuid"))
			str = "tb_ruku.id";
		if (str.equals("khid"))
			str = "tb_khinfo.id";

		if (str.equals("spname"))
			str = "tb_spinfo.spname";
		if (str.equals("cd"))
			str = "tb_spinfo.cd";
		if (str.equals("dw"))
			str = "tb_spinfo.dw";
		if (str.equals("gg"))
			str = "tb_spinfo.gg";
		if (str.equals("bz"))
			str = "tb_spinfo.bz";
		if (str.equals("ph"))
			str = "tb_spinfo.ph";
		if (str.equals("pzwh"))
			str = "tb_spinfo.pzwh";

		if (str.equals("rq")) {
			if (from[0] != null)
				str = "tb_rkth.rkthrq";
			if (from[1] != null)
				str = "tb_ruku.rukurq";
			if (from[2] != null)
				str = "tb_sell.sellrq";
			if (from[3] != null)
				str = "tb_xsth.xsthrq";
		}
		return str;
	}

	private static boolean checkOperator(String ope) {
		if (ope.equals("=") || ope.equals("<") || ope.equals(">") || ope.equals(">=") || ope.equals("<="))
			return true;
		else
			return false;
	}

	private static boolean checkNumber(String str) {
		String regex = "^[0-9]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static String makeSQL(String a[], String b[], String c[], String d[]) throws ParseException {// a[]存词,b[]:cixing1,c[]:cixing2,d[]:cixing3
		String select[] = new String[50], where[] = new String[50], from[];
		int s = 0, w = 0;// 记录个数
		String sql = "select";
		int n = a.length;
		int i;
		for (i = n - 1; i >= 0; i--) {
			if (b[i] != null) {
				if (b[i].equals("tttt"))
					break;
				if (!b[i].equals("and")) {
					if (d[i] != null && !d[i].equals(b[i]))
						select[s++] = b[i];
					if (d[i] == null)
						select[s++] = b[i];
				}
			}
		}
		for (int m = 1; m < i; m++) {
			// 注销代码后移
			/*
			 * if (d[m] != null) { select[s++] = d[m]; where[w++] = (d[m] +
			 * " = " + b[m]); }
			 */
			if (b[m] != null) {
				// if (b[m].equals("=")) {
				if (checkOperator(b[m])) {
					select[s++] = b[m - 1];
					// 公共属性在表确定后加入where语句
					if (!b[m - 1].equals("dz") && !b[m - 1].equals("yzbm") && !b[m - 1].equals("cz")
							&& !b[m - 1].equals("lxr") && !b[m - 1].equals("lxdh") && !b[m - 1].equals("yx")) {
						if (checkNumber(a[m + 1])) {
							where[w++] = (b[m - 1] + b[m] + a[m + 1]);
						} else {
							where[w++] = (b[m - 1] + b[m] + b[m + 1]);
						}
					}
				}
			}
		}

		String all_attributes[] = get_all_attributes();
		System.out.println();
		System.out.print("all_attributes:");
		Printshuzu(all_attributes);
		int no = 0;
		while (all_attributes[no] != null)
			no++;
		int tag_att[] = new int[no];
		from = ensure_dbtable_1(all_attributes, tag_att);
		System.out.print("from:	");
		Printshuzu(from);

		ensure_table_linkable(from);
		System.out.print("from:	");
		Printshuzu(from);

		for (int p = 0; select[p] != null; p++)
			select[p] = ack_qianzhui(from, select[p]);
		System.out.print("select[]:");
		Printshuzu(select);

		for (int m = 1; m < i; m++) {
			// 后移注销代码
			if (d[m] != null) {
				if (d[m].equals("khname") || d[m].equals("gysname")) {
					d[m] = ack_qianzhui(from, d[m]);
					select[s++] = d[m];
					where[w++] = (d[m] + " like " + "'%" + a[m] + "%'");
				} else if (time_index == m) {// 处理日期
					d[m] = ack_qianzhui(from, d[m]);
					select[s++] = d[m];
					where[w++] = (d[m] + " like " + "'%" + format_time(ci[time_index]) + "%'");
					time_index = -1;
				} else {
					if (!d[m].equals(b[m])) {
						d[m] = ack_qianzhui(from, d[m]);
						select[s++] = d[m];
						where[w++] = (d[m] + "=" + b[m]);
					}
				}
			}
		}
		int x = s - 1;
		while (x >= 0) {
			if (check_string(select, "*")) {
				sql = sql + " *";
				break;
			} else {
				if (x == s - 1)
					sql = sql + " " + select[x];
				else
					sql = sql + "," + select[x];
				x--;
			}
		}
		sql += " from ";
		int count = 0;
		for (int f = 0; f < from.length; f++) {
			if (from[f] != null) {
				if (count == 0)
					sql += from[f];
				else {
					// sql += ", " + from[f];
					sql += " natural join " + from[f];
				}
				count++;
			}
		}

		if (from[7] != null) {
			if (from[0] != null) {
				where[w++] = "tb_rkth.spid = tb_spinfo.id";
				if (from[4] != null)
					where[w++] = "tb_rkth.gysid = tb_gysinfo.id";
			}
			if (from[1] != null) {
				where[w++] = "tb_ruku.spid = tb_spinfo.id";
				if (from[4] != null)
					where[w++] = "tb_ruku.gysid = tb_gysinfo.id";
			}
			if (from[2] != null) {
				where[w++] = "tb_sell.spid = tb_spinfo.id";
				if (from[6] != null)
					where[w++] = "tb_sell.khid = tb_khinfo.id";
			}
			if (from[3] != null) {
				where[w++] = "tb_xsth.spid = tb_spinfo.id";
				if (from[6] != null)
					where[w++] = "tb_xsth.khid = tb_khinfo.id";
			}

			if (from[5] != null)
				where[w++] = "tb_kc.id = tb_spinfo.id";
		}
		if (w != 0) {
			sql += " where";
			x = w - 1;
			while (x >= 0) {
				if (x == w - 1)
					sql = sql + " " + where[x];
				else
					sql = sql + " and " + where[x];
				x--;
			}
		}
		return sql;
	}

	public static void main(String[] args) throws Exception { // TODO
		// 自动生成的方法存根 while (true) {
		System.out.println("请输入待查询的语句：");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String string = buf.readLine();
		yuju = string;
		check_time(yuju);
		ci = get_ci(string);
		Printshuzu(ci);
		String path = "src/dictionary/dict.txt";
		ensure_cixing(path);
		Printshuzu(cixing1);
		Printshuzu(cixing2);
		Printshuzu(cixing3);
		String sql = makeSQL(ci, cixing1, cixing2, cixing3);
		System.out.println(sql+"\n");
		Dao dao = new Dao();
		dao.Display(sql);
	}

}
