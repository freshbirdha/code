package bookstoreCategory;

import java.util.List;



public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();

	/**
	 * 查询所有分类
	 * @return
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	} 
}
