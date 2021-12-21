package memo.model;
import java.sql.*;
import java.util.*;

import jdbc.util.DBUtil;
//DAO: Data Access Object (Persistence Layer -영속성 계증)
public class MemoDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//메모글을 등록하는 메소드
	public int insertMemo(MemoVO vo) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="INSERT INTO memo(idx,name,msg,wdate) VALUES("
					+" memo_seq.nextval,?,?,sysdate)";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getMsg());			
			return ps.executeUpdate();
		}finally {
			closeAll();
		}
	}//----------------------------
	
	public List<MemoVO> listMemo() throws SQLException{
		try {
			con = DBUtil.getCon();
			String sql="SELECT idx, name, msg, wdate FROM memo ORDER BY idx DESC";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			List<MemoVO> arr = new ArrayList<>();
			while(rs.next()) {
				int idx =rs.getInt("idx");
				String name = rs.getString("name");
				String msg = rs.getString("msg");
				java.sql.Date wdate = rs.getDate("wdate");
				MemoVO vo=new MemoVO(idx, name, msg, wdate);//record => 행
				arr.add(vo);//table구조
			}//while-----
			return arr;
		} finally {
			closeAll();
		}
	}//----------------------------
	public int deleteMemo(int idx) throws SQLException{
		try {
			con = DBUtil.getCon();
			String sql="DELETE FROM memo WHERE idx=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, idx);			
			return ps.executeUpdate();
		} finally {
			closeAll();
		}
	}//----------------------------
	
	private void closeAll() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//----------------------------------
}
