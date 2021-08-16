package com.example.demo.Layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Layer2.Admin;

@Repository
public class AdminValidationRepositoryImpl extends BaseRepository implements AdminValidationRepository{
	
	@Transactional
	public Admin getValidation(String username,String password) {
		EntityManager entityManager = getEntityManager();
		Query query = super.getEntityManager().createQuery("select e from Admin e where e.username = :vusername AND e.password = :vpassword");
		query.setParameter("vusername", username);
		query.setParameter("vpassword", password);
		List<Admin> adminList = query.getResultList();
		Admin admin = entityManager.find(Admin.class, username);
		if (admin != null && (adminList.isEmpty()==false))
			return admin;
		else
			return  null;
	}
}