package kdh57_mvc_beer3.model.beer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kdh57_mvc_beer3.model.beer.BeerDTO;
import kdh57_mvc_beer3.model.beer.BeerPageInfoVO;

public class BeerDAO {


	private PreparedStatement pstmt = null;
	private Connection con = null;

	Context init = null;
	DataSource ds = null;

	ResultSet rs = null;

	public BeerDAO() {
		super();
		dbConnect();
	}

	public void dbConnect() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc_mariadb");
			con = ds.getConnection();

			System.out.println("DB 연결 성공!!");
		} catch (Exception e) {
			System.out.println("DB 연결 실패!!");
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결 헤제 메서드
	public void disConnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<BeerDTO> searchBeer(BeerDTO bpiVO, BeerPageInfoVO page) {
		// bpiVO에는 컬럼명과 입력한 값이 담겨 있다
		ArrayList<BeerDTO> list = new ArrayList<BeerDTO>();

		String SQL;
		String SQL2;

		ResultSet rs;

		System.out.println("DAO의 검색 값 : " + bpiVO.getSelect_search() + ", " + bpiVO.getInput_search());
		
		if (bpiVO.getSelect_search().equals("0")) {
			System.out.println("============검색 값이 없을 경우============");
			SQL = "select count(*) from beer";
			SQL2 = "select * from beer order by b_id limit ?, ?";
			try {
				pstmt = con.prepareStatement(SQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					page.setRecordCnt(rs.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			page.adjPageInfo();

			try {
				pstmt = con.prepareStatement(SQL2);
				pstmt.setInt(1, page.getStartRecord());
				pstmt.setInt(2, page.getLimitCnt());

				rs = pstmt.executeQuery();

				while (rs.next()) {
					BeerDTO beer = new BeerDTO();
					beer.setB_id(rs.getInt("b_id"));
					beer.setB_code(rs.getString("b_code"));
					beer.setB_category(rs.getString("b_category"));
					beer.setB_name(rs.getString("b_name"));
					beer.setB_country(rs.getString("b_country"));
					beer.setB_price(rs.getInt("b_price"));
					beer.setB_alcohol(rs.getString("b_alcohol"));
					beer.setB_content(rs.getString("b_content"));
					beer.setB_like(rs.getInt("b_like"));
					beer.setB_dislike(rs.getInt("b_dislike"));
					beer.setB_image(rs.getString("b_image"));
					list.add(beer);
				}

				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
			
			
		// 검색창에 입력했을 때
		} else {
			System.out.println("============검색 값이 있을 경우============");
			SQL = "select count(*) from beer where " + bpiVO.getSelect_search();
			SQL += " like " + "\"%" + bpiVO.getInput_search() + "%\"";

			SQL2 = "select * from beer where " + bpiVO.getSelect_search();
			SQL2 += " like " + "\"%" + bpiVO.getInput_search() + "%\"";
			SQL2 += " ORDER BY b_id limit ?, ?";
			System.out.println(SQL + "\n" + SQL2);
			try {
				pstmt = con.prepareStatement(SQL);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					
					page.setRecordCnt(rs.getInt(1)); // 총 레코드 갯수
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			page.adjPageInfo();
			
			try {
				pstmt = con.prepareStatement(SQL2);
				pstmt.setInt(1, page.getCurrentPageNo()*page.getLimitCnt());
				System.out.println("시작 행 : " + page.getCurrentPageNo()*page.getLimitCnt());
				pstmt.setInt(2, page.getLimitCnt());
				System.out.println("마지막 행 : " + page.getLimitCnt());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BeerDTO beer = new BeerDTO();
					beer.setB_id(rs.getInt("b_id"));
					beer.setB_code(rs.getString("b_code"));
					beer.setB_category(rs.getString("b_category"));
					beer.setB_name(rs.getString("b_name"));
					beer.setB_country(rs.getString("b_country"));
					beer.setB_price(rs.getInt("b_price"));
					beer.setB_alcohol(rs.getString("b_alcohol"));
					beer.setB_content(rs.getString("b_content"));
					beer.setB_like(rs.getInt("b_like"));
					beer.setB_dislike(rs.getInt("b_dislike"));
					beer.setB_image(rs.getString("b_image"));
					list.add(beer);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
		} // end of else

		return list;
	}

	// 게시판의 모든 레코드를 반환 메서드 - R
	public ArrayList<BeerDTO> getBeerList() {
//		dbConnect();
		ArrayList<BeerDTO> list = new ArrayList<BeerDTO>();

		String SQL = "select * from beer";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BeerDTO beer = new BeerDTO();
				beer.setB_id(rs.getInt("b_id"));
				beer.setB_code(rs.getString("b_code"));
				beer.setB_category(rs.getString("b_category"));
				beer.setB_name(rs.getString("b_name"));
				beer.setB_country(rs.getString("b_country"));
				beer.setB_price(rs.getInt("b_price"));
				beer.setB_alcohol(rs.getString("b_alcohol"));
				beer.setB_content(rs.getString("b_content"));
				beer.setB_like(rs.getInt("b_like"));
				beer.setB_dislike(rs.getInt("b_dislike"));
				beer.setB_image(rs.getString("b_image"));
				list.add(beer);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 게시판의 현재 페이지 레코드를 반환 페서드 - R4
	public ArrayList<BeerDTO> getBeerListForPage(BeerPageInfoVO bpiVO) {
//		dbConnect();
		ArrayList<BeerDTO> list = new ArrayList<BeerDTO>();

		String SQL = "select * from beer order by b_id limit ?, ?";
		String SQL2 = "select count(*) from beer";

		ResultSet rs;

		try {
			pstmt = con.prepareStatement(SQL2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bpiVO.setRecordCnt(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		bpiVO.adjPageInfo();

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, bpiVO.getStartRecord());
			pstmt.setInt(2, bpiVO.getLimitCnt());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BeerDTO beer = new BeerDTO();
				beer.setB_id(rs.getInt("b_id"));
				beer.setB_code(rs.getString("b_code"));
				beer.setB_category(rs.getString("b_category"));
				beer.setB_name(rs.getString("b_name"));
				beer.setB_country(rs.getString("b_country"));
				beer.setB_price(rs.getInt("b_price"));
				beer.setB_alcohol(rs.getString("b_alcohol"));
				beer.setB_content(rs.getString("b_content"));
				beer.setB_like(rs.getInt("b_like"));
				beer.setB_dislike(rs.getInt("b_dislike"));
				beer.setB_image(rs.getString("b_image"));
				list.add(beer);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return list;
	}

	// 주 키 b_id의 레코드를 반환하는 메서드 - R
	public BeerDTO getBeer(int b_id) {
//		dbConnect();
		String SQL = "select * from beer where b_id = ?";
		BeerDTO beer = new BeerDTO();

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, b_id);
			ResultSet rs = pstmt.executeQuery();

			rs.next();

			beer.setB_id(rs.getInt("b_id"));
			beer.setB_code(rs.getString("b_code"));
			beer.setB_category(rs.getString("b_category"));
			beer.setB_name(rs.getString("b_name"));
			beer.setB_country(rs.getString("b_country"));
			beer.setB_price(rs.getInt("b_price"));
			beer.setB_alcohol(rs.getString("b_alcohol"));
			beer.setB_content(rs.getString("b_content"));
			beer.setB_like(rs.getInt("b_like"));
			beer.setB_dislike(rs.getInt("b_dislike"));
			beer.setB_image(rs.getString("b_image"));

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return beer;
	}

	public boolean insertBeer(BeerDTO beer) {
		boolean success = false;
//		dbConnect();
		String sql = "insert into beer(b_code, b_category, b_name, ";
		sql += "b_country, b_price, b_alcohol, b_content) ";
		sql += "values(?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, beer.getB_code());
			pstmt.setString(2, beer.getB_category());
			pstmt.setString(3, beer.getB_name());
			pstmt.setString(4, beer.getB_country());
			pstmt.setInt(5, beer.getB_price());
			pstmt.setString(6, beer.getB_alcohol());
			pstmt.setString(7, beer.getB_content());
			
			pstmt.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}

	public boolean updateBeer(BeerDTO beer) {
		boolean success = false;
//		dbConnect();
		String sql = "update beer set b_code=?, b_category=?, b_name=?, b_country=?, ";
		sql += "b_price=?, b_alcohol=?, b_content=?, b_like=?, b_dislike=?, ";
		sql += "b_image=? where b_id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, beer.getB_code());
			pstmt.setString(2, beer.getB_category());
			pstmt.setString(3, beer.getB_name());
			pstmt.setString(4, beer.getB_country());
			pstmt.setInt(5, beer.getB_price());
			pstmt.setString(6, beer.getB_alcohol());
			pstmt.setString(7, beer.getB_content());
			pstmt.setInt(8, beer.getB_like());
			pstmt.setInt(9, beer.getB_dislike());
			pstmt.setString(10, beer.getB_image());
			pstmt.setInt(11, beer.getB_id());

			int rowUdt = pstmt.executeUpdate();

			if (rowUdt == 1)
				success = true;

		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}

	public boolean deleteBeer(int b_id) {
		boolean success = false;
//		dbConnect();
		String sql = "delete from beer where b_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_id);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}

}
