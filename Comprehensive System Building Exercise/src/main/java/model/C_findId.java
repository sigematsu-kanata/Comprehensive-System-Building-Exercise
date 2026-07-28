package kigyou.model;

import java.sql.SQLException;

import kigyou.bean.CompanyBean;
import kigyou.dao.CompanyDao;

public class C_findId {
	public CompanyBean execute(int id ) {
		CompanyDao empdao = new CompanyDao();
		CompanyBean emplist = null;
		try {
			emplist = (CompanyBean) empdao.findById(id);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return emplist;
	}
}
