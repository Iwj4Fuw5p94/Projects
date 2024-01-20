package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Department;

public class DeptDaoImp implements IDeptDao {

	Connection conn = null;

	public DeptDaoImp() {

		conn = DBUtil.getDBConnection();
	}

	@Override
	public int insert(Department dept) {

		// INSERT
		String insert = "insert into dept values(?,?,?)"; // ? positional parameters

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(insert);

			pstmt.setInt(1, dept.getDno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLocation());

			count = pstmt.executeUpdate();

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int update(Department dept) {
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("update dept set dname='smile',set location=? where dno=?");
			ps.setString(1, dept.getDname());
			ps.setString(2, dept.getLocation());
			ps.setInt(3, dept.getDno());
			count = ps.executeUpdate();
			System.out.println("record has been updated" + count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public int deleteOne(int dno) {
		Department dept=new Department();
		String statement ="delete from dept where dno=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(statement);
			ps.setInt(1,dno);
			int count=ps.executeUpdate();
			System.out.println(count+"rows are deleted ");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dno;
		
		}
	@Override
	public Department selectOne(int dno) {
		Department dept=null;
		try {
			PreparedStatement ps=conn.prepareStatement("select dno,dname,location from dept where dno=?");
			ps.setInt(1,dno);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3));
				dept=new Department(rs.getInt(1),rs.getString(2),rs.getString(3));
				System.out.println(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}

	@Override
	public List<Department> selectAll() {
		Department dept=null;
		List<Department> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement("select dno,dname,location from dept");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				dept=new Department(rs.getInt(1),rs.getString(2),rs.getString(3));
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
