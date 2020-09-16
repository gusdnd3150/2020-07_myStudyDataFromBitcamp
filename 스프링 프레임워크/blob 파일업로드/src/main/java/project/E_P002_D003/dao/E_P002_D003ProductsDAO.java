package project.E_P002_D003.dao;


import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import project.E_P002_D003.vo.E_P002_D003ProductsVO;

public interface E_P002_D003ProductsDAO {

	void addProduct(Map<String, Object> datahMap) throws DataAccessException;
	/*public void saveImage(Map<String, Object> hmap);
	public Map<String, Object> getByteImage();*/

}
