package com.example.demo.Layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Layer2.Document;



@Repository
public class DocumentRepositoryImpl extends BaseRepository implements DocumentRepository {

	@Transactional
	public void insertDocument(Document doc) {
	EntityManager entityManager = getEntityManager();
	entityManager.merge(doc);
	System.out.println("Document Stored ...");
	}
	
	@Transactional
	public Document selectDocument(Long custId) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select d from Document d where d.customer.custId = :vcustId");
		query.setParameter("vcustId", custId);
		List<Document> documentListAsPerCustId = query.getResultList();
		return documentListAsPerCustId.get(0);
	}

	@Transactional
    public List<Document> selectAllDocument(){
        EntityManager entityManager = getEntityManager();;
        Query query = entityManager.createQuery(" from Document");
        List<Document> docList =query.getResultList();
        return docList;

    }

}
