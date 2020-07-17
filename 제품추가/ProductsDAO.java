package study06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context; 
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductsDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public ProductsDAO() {
		try {
			// JNDI에 접근하기 위해 기본경로 (java:/comp/env)를 지정합니다. 
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");

			this.dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			// 톰캣 context.xml에 설정한 name값인 jdbc/oracle을 이용해 톰캣이 미리 연결한 DataSource를 받아 옵니다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ProductsVO> listProd(String input_prod, String input_vend) {
		List<ProductsVO> list = new ArrayList<>();
		try {
			System.out.println("====================>> 조회처리");
			this.con = dataFactory.getConnection();// DataSource를 이용해 데이터베이스에 연결합니다.
			String query = " SELECT prod_id,prod_name,prod_price,prod_desc,vend_id ";
			query += " FROM products";
			query += " WHERE 1=1 ";

			System.out.println("input_prod:" + input_prod);
			System.out.println("input_vend:" + input_vend);

			if (input_prod != null && !"".equals(input_prod)) {
				query += "	AND prod_id LIKE '%" + input_prod + "%'";
			}
			if (input_vend != null && !"".equals(input_vend)) {
				query += " AND vend_id LIKE '%" + input_vend + "%'";
			}

			System.out.println("prepareStatement: " + query);// prepared
			this.pstmt = this.con.prepareStatement(query);

			ResultSet rs = this.pstmt.executeQuery();
			while (rs.next()) {
				String prod_id = rs.getString("prod_id");
				String prod_name = rs.getString("prod_name");
				String prod_price = rs.getString("prod_price");
				String prod_desc = rs.getString("prod_desc");
				String vend_id = rs.getString("vend_id");

				// 각 컬럼 값을 다시 VO객체의 속성에 설정합니다.
				// 순수한 컬럼명만 들어가야 한다.
				ProductsVO vo = new ProductsVO();

				vo.setProd_id(prod_id);
				vo.setProd_name(prod_name);
				vo.setProd_price(prod_price);
				vo.setProd_desc(prod_desc);
				vo.setVend_id(vend_id);
				// 설정된 객체를 다시 ArrayList에 저장합니다.
				list.add(vo);
			}
			rs.close();
			this.pstmt.close();// prepared
			this.con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delProd(String del_id) {

		try {
			Connection con = this.dataFactory.getConnection();
			// delete문을 문자열로 만듭니다.
			String query = "DELETE FROM products" + " WHERE prod_id=?";
			this.pstmt = con.prepareStatement(query);
			this.pstmt.setString(1, del_id);// 첫 번째 ?에 전달된 ID를 인자로 넣습니다.
			System.out.println("prepareStatement:" + query);
			this.pstmt.executeUpdate();// delete문을 실행해 테이블에서 해당 ID의 회원 정보를 삭제합니다.
			this.pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addProd(ProductsVO inputVO) {
		try {
			// datasource를 이용해 데이터베이스와 연결합니다.
			Connection con = this.dataFactory.getConnection();

			System.out.println("추가");

			// 테이블에 저장할 회원 정보를 받아 옵니다.
			String prod_id = inputVO.getProd_id();
			String prod_name = inputVO.getProd_name();
			String prod_price = inputVO.getProd_price();
			String prod_desc = inputVO.getProd_desc();
			String vend_id = inputVO.getVend_id();

			String query = "INSERT INTO products ";
			query += " VALUES(";
			query += "'" + prod_id + "'";
			query += "," + "'" + vend_id + "'";
			query += "," + "'" + prod_name + "'";
			query += "," + prod_price;
			query += "," + "'" + prod_desc + "'";
			query += ") ";

			System.out.println("prepareStatement: " + query);
			this.pstmt = con.prepareStatement(query);// 순서대로 값을 바꿔줘야함
			this.pstmt.executeUpdate();// 회원 정보를 테이블에 추가합니다.
			
			this.pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
