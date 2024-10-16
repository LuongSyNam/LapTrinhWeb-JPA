package vn.iotstar.service.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.iotstar.dao.impl.CategoryDao;
import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.entity.Category;
import vn.iotstar.service.ICategoryService;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryServiceImpl implements ICategoryService {

    public ICategoryDao cateDao = new CategoryDao();

    @Override
    public void insert(Category category) {
        Category cate = this.findByCategoryname(category.getCategoryname());
        if (cate == null) {
            cateDao.insert(category);
        }
    }

    @Override
    public int count() {
        return cateDao.count();
    }

    @Override
    public List<Category> findAll(int page, int pageSize) {
        return cateDao.findAll(page, pageSize);
    }

    @Override
    public List<Category> searchByName(String keyword) {
        return cateDao.searchByName(keyword);
    }

    @Override
    public List<Category> findAll() {
        return cateDao.findAll();
    }

    @Override
    public Category findById(int id) {
        return cateDao.findById(id);
    }

    @Override
    public void delete(int id) {
        try {
            cateDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        Category cate = this.findById(category.getCategoryid());
        if (cate != null) {
            cateDao.update(category);
        }
    }

    @Override
    public Category findByCategoryname(String name) {
        try {
            return cateDao.findByCategoryname(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
