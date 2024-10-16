package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.entity.User;

public class UserDao implements IUserDao {

	@Override
	public void insert(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	
	@Override
	public void update(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	
	@Override
	public void delete(int userid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			User user = enma.find(User.class, userid);
			if (user != null) {
				enma.remove(user);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	
	@Override
	public User findById(int userid) {
		EntityManager enma = JPAConfig.getEntityManager();
		User user = enma.find(User.class, userid);
		return user;
	}

	
	@Override
	public User findByUsername(String name) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT u FROM User u WHERE u.username =:name";
		try {
			TypedQuery<User> query = enma.createQuery(jpql, User.class);
			query.setParameter("name", name);
			return query.getSingleResult();  // Nếu không có kết quả, sẽ ném NoResultException
	    } catch (NoResultException e) {
	        // Không tìm thấy người dùng
	        return null;
	    } finally {
	        enma.close();
	    }
	}
	
	@Override
	public User findByPhone(String phone) throws Exception {
	    EntityManager enma = JPAConfig.getEntityManager();
	    String jpql = "SELECT u FROM User u WHERE u.phone =:phone";
	    try {
	        TypedQuery<User> query = enma.createQuery(jpql, User.class);
	        query.setParameter("phone", phone);
	        return query.getSingleResult();  // Nếu không có kết quả, sẽ ném NoResultException
	    } catch (NoResultException e) {
	        // Không tìm thấy người dùng
	        return null;
	    } finally {
	        enma.close();
	    }
	}

	
	@Override
	public User findByEmail(String email) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT u FROM User u WHERE u.email =:email";
		try {
			TypedQuery<User> query = enma.createQuery(jpql, User.class);
			query.setParameter("email", email);
			return query.getSingleResult();  // Nếu không có kết quả, sẽ ném NoResultException
	    } catch (NoResultException e) {
	        // Không tìm thấy người dùng
	        return null;
	    } finally {
	        enma.close();
	    }
	}

	
	@Override
	public List<User> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	
	@Override
	public List<User> searchByName(String username) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT u FROM User u WHERE u.username like :catname";
		TypedQuery<User> query = enma.createQuery(jpql, User.class);
		query.setParameter("catname", "%" + username + "%");
		return query.getResultList();
	}

	
	@Override
	public List<User> findAll(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	
	@Override
	public int count() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(u) FROM User u";
		Query query = enma.createQuery(jpql);
		return ((Long) query.getSingleResult()).intValue();
	}

}
