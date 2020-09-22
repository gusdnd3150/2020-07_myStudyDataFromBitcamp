package project.B_P002_D001.Service;

import java.util.List;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import project.Paging;
import project.E_P002_D003.vo.E_P002_D003PhotoVO;
import project.E_P002_D003.vo.E_P002_D003ProductsVO;

public interface B_P002_D001ShopingMallService {

	public List<E_P002_D003PhotoVO> shopListImage(Paging vo) throws DataAccessException;	
	public List<E_P002_D003ProductsVO> shopListText2(Paging vo) throws DataAccessException;
	public int totalCount();
	
	public E_P002_D003PhotoVO getImage(E_P002_D003PhotoVO vo) throws DataAccessException;
	
	public List<E_P002_D003ProductsVO> shopListText() throws DataAccessException;
}

