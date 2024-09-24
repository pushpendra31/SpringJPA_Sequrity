package Spring.Data.JPA.SpringJPA_Sequrity.Daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.LoginRegisterDTO;
import jakarta.transaction.Transactional;
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<LoginRegisterDTO, Integer> {
	//@Transactional //1. Always  try  to  Manage in Serviceimpl	
	//2.For inbuild  JPARepo methood Like-: Save(),delete we do not  need to maintain @transection its  handled by JPA simple  repositry 
	
 @Query(value ="  from LoginRegisterDTO where personid=1")
 Optional<LoginRegisterDTO> findByEmail(String email);
	 


// 1.Save
LoginRegisterDTO save(LoginRegisterDTO dtoo);
	//Optional<LoginRegisterDTO> findByEmailid(String email);
//1.1 SaveAll(),
//1.2  JPQL INsert query 
//1.3 Native Query  for  insert


// 2.Delete Custome  query 
//2.1 Delete Custome  query  JPQL

@Transactional
@Modifying
@Query("DELETE FROM LoginRegisterDTO DT WHERE personid=:personid")
void deleteUsingModifyJPQL(@Param("personid") int personid);

//2.1 Delete Custome  USING  Native  query
@Transactional // Always  try  to  Manage in Serviceimpl
@Modifying
@Query(value = "DELETE FROM persons WHERE personid = :personid", nativeQuery = true)
int  deleteUsingModifyNativeQuery(@Param("personid") int personid);


//3. Update
//3.1 Update using  JPQL
@Modifying
@Query("update LoginRegisterDTO set city=:city where  personid=:personid")
    int SpringJPAUpdateJPQL(String city, int personid);

//3.1 Update using  Native querys
//Native query  need @Params
@Modifying
@Query(value ="update persons set city=:city where personid=:personid", nativeQuery = true)
    int SpringJPAUpdateNativeQuery(@Param("city") String city,@Param("personid") int personid);


//4 Fetch select   Native querys
//Native query  need @Params
@Query(value ="select * from  where personid=:personid", nativeQuery = true)
  int SpringJPASelectNativeQuery(@Param("personid") int personid);

}
