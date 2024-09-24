package Spring.Data.JPA.SpringJPA_Sequrity.Daoimpl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import Dao.EntityDao;
import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.LoginRegisterDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Query;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.Transactional;
@Repository
public  class EntityDaoimpl implements EntityDao{
	@Autowired
	EntityManager entityManager;
	// --------Here we insert single list dto in DB using  entitymanager( )----------

	// 
	@Transactional
	@Override
	public LoginRegisterDTO UpdateDataUsingEntityManager(LoginRegisterDTO dto1) {
		
		 if (entityManager.find(LoginRegisterDTO.class, dto1.getPersonid()) != null) {
			 entityManager.merge(dto1);

			} else {
				 entityManager.persist(dto1);
		}

		return null ;
	}
	
	// --------Here we insert multiple list dto in DB using  entitymanager(Batch )----------
	@Transactional	@Override
	public LoginRegisterDTO SpringJPAUpdateEntityManagerMUltiple(List<LoginRegisterDTO> dto1) {
		        int count =0;
		        
		Iterator<LoginRegisterDTO>  it=dto1.iterator();
		while(it .hasNext()) {
			entityManager.persist(it.next());
			count++;
			System.out.println("total  dto  inserted size is  ="+count);
		}
		return null;
	}
// ----------entityManager Select fetch data from db using native  query -----
	// 1.1 using entitymanager-----------
	@Override
	public List<LoginRegisterDTO> SpringJPAUpdateEntityManagerSelect(LoginRegisterDTO dto1) {
		// Query createQuery = entityManager.createQuery(" from persons where email=:email");  FOR hql QUERY 
		Query createQuery = entityManager.createNativeQuery("select *  from persons where email=:email");

		createQuery.setParameter("email", dto1.getEmail());
		List resultList = createQuery.getResultList();
		return resultList;
	}
	// 1.2 using Native  query multiple param -----------
		@Override
		public  List<LoginRegisterDTO> SpringJPASelectQueryAnno(LoginRegisterDTO dto1) {
			
			Query createQuery = entityManager.createNativeQuery("select *  from persons where email=:email and personid=:personid");
			createQuery.setParameter("email", dto1.getEmail());
			createQuery.setParameter("personid", dto1.getPersonid());

			List resultList = createQuery.getResultList();
		return resultList;
	}
		// 1.3 using Native  query multiple param -----------
		@Override
		public  List<LoginRegisterDTO> SpringJPASelectNativeEntityManger(LoginRegisterDTO dto1) {
			
			Query createQuery = entityManager.createNativeQuery("select *  from persons where  personid=:personid");// ("select *  from persons where email=:email and personid=:personid");
			createQuery.setParameter("personid", dto1.getPersonid());
			List resultList1s = createQuery.getResultList();
			for (Object object : resultList1s) {
				System.out.println("lopp listdat entity native query"+object.toString().indent(0));
				
			}
	
			resultList1s.stream().forEach(System.out::print);
			System.out.println("Data listffrom  query which is not mapped to any Entity nown"+resultList1s.toString());
			List resultList = createQuery.getResultList();
		return resultList;
	}
		
}
