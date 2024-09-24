package Spring.Data.JPA.SpringJPA_Sequrity.ServiceImmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.EntityDao;
import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.LoginRegisterDTO;
import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.ProductMaster;
import Spring.Data.JPA.SpringJPA_Sequrity.Daoimpl.UserRepo;
import Spring.Data.JPA.SpringJPA_Sequrity.Daoimpl.productJPARepo;
import Spring.Data.JPA.SpringJPA_Sequrity.services.LoginRegiService;
import jakarta.transaction.Transactional;
@Service
public class LoginRegisterServiceimpl implements LoginRegiService{
	@Autowired
	EntityDao daoimpl;
	@Autowired
	productJPARepo repoprod;
	@Autowired
	public  UserRepo repo;
	@Override
	@Transactional
	
	public LoginRegisterDTO save(LoginRegisterDTO dto1) {
		
		LoginRegisterDTO save = repo.save(dto1);
		return save;
	}

	@Override
	public List<LoginRegisterDTO> saveAll(List<LoginRegisterDTO> dto1) {
	
		List<LoginRegisterDTO> save = repo.saveAll(dto1);
		return save;
	}

	@Override
	@Transactional
	public int SpringJPAUpdateJPQL(String city,int personid) {
		int update = repo.SpringJPAUpdateJPQL(city,personid);
		return update;
	}
	@Transactional
	@Override
	public int SpringJPAUpdateNativeQuery(String city, int personid) {
		int update = repo.SpringJPAUpdateNativeQuery(city,personid);
		return update;
	}

	@Override
	public LoginRegisterDTO UpdateDataUsingEntityManager(LoginRegisterDTO dto1) {
	return	daoimpl.UpdateDataUsingEntityManager(dto1);
		
	}

	@Override
	public LoginRegisterDTO SpringJPAUpdateEntityManagerMUltiple(List<LoginRegisterDTO> dto1) {
		// TODO Auto-generated method stub
		return	daoimpl.SpringJPAUpdateEntityManagerMUltiple(dto1);
	}

	@Override
	public List<LoginRegisterDTO> SpringJPAUpdateEntityManagerSelect(LoginRegisterDTO dto1) {
		// TODO Auto-generated method stub
		return	daoimpl.SpringJPAUpdateEntityManagerSelect(dto1);

	}

	@Override
	public List<LoginRegisterDTO> SpringJPASelectQueryAnno(LoginRegisterDTO dto1) {
		return	daoimpl.SpringJPASelectQueryAnno(dto1);
	}

	@Override
	public List<LoginRegisterDTO> SpringJPASelectNativeEntityManger(LoginRegisterDTO dto1) {
		return	daoimpl.SpringJPASelectNativeEntityManger(dto1);

	}
	
	// -----Nested transection issue  check 212 at  controller 2nd  at serviceimpl
@Transactional
	@Override
	public List<ProductMaster> saveAll1(List<ProductMaster> dto1) {
		// TODO Auto-generated method stub
		return	repoprod.saveAll(dto1);
	}


	

}
