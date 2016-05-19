package com.kylx.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kylx.db.DBUtil;
import com.kylx.model.Goddess;

public class GoddessDao {
	public void addGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "" + "insert into imooc_goddess" + "(user_name, sex, age, birthday, email, mobile,"
				+ "create_user, create_date, update_user, update_date, isdel)" + "values("
				+ "?,?,?,?,?,?,?,current_date(),?, current_date(),?)";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);

		prepareStatement.setString(1, g.getUser_name());
		prepareStatement.setInt(2, g.getSex());
		prepareStatement.setInt(3, g.getAge());
		prepareStatement.setDate(4, new Date(g.getBirthday().getTime()));
		prepareStatement.setString(5, g.getEmail());
		prepareStatement.setString(6, g.getMobile());
		prepareStatement.setString(7, g.getCreate_user());
		prepareStatement.setString(8, g.getUpdate_user());
		prepareStatement.setLong(9, g.getIsdel());

		prepareStatement.execute();
	}

	public void updateGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " update imooc_goddess " + " set user_name =?, sex=?, age=?, birthday=?, email=?, mobile=?, "
				+ " update_user=?, update_date = current_date(), isdel=? " + " where id = ? ";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);

		prepareStatement.setString(1, g.getUser_name());
		prepareStatement.setInt(2, g.getSex());
		prepareStatement.setInt(3, g.getAge());
		prepareStatement.setDate(4, new Date(g.getBirthday().getTime()));
		prepareStatement.setString(5, g.getEmail());
		prepareStatement.setString(6, g.getMobile());
		prepareStatement.setString(7, g.getUpdate_user());
		prepareStatement.setLong(8, g.getIsdel());
		prepareStatement.setInt(9, g.getId());
		prepareStatement.execute();
	}

	public void delGoddess(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " delete from imooc_goddess " + " where id = ? ";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);

		prepareStatement.setInt(1, id);
		prepareStatement.execute();

	}

	public List<Goddess> query() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");

		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));

			gs.add(g);

		}
		return gs;
	}

	public List<Goddess> query(String name) throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");

		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));

			gs.add(g);

		}
		return gs;
	}

	public Goddess get(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " select * from imooc_goddess " + " where id = ? ";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);

		prepareStatement.setInt(1, id);
		ResultSet rs = prepareStatement.executeQuery();

		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
		}
		return g;
	}

}
