package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.User;

public interface IUserDao {

	int count();

	List<User> findAll(int page, int pagesize);

	List<User> searchByName(String username);

	List<User> findAll();

	User findByUsername(String name) throws Exception;

	User findById(int userid);

	void delete(int userid) throws Exception;

	void update(User user);

	void insert(User user);

	User findByEmail(String email) throws Exception;

	User findByPhone(String phone) throws Exception;
}
