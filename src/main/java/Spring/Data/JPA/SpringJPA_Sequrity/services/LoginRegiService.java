package Spring.Data.JPA.SpringJPA_Sequrity.services;

import java.util.List;

import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.LoginRegisterDTO;
import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.ProductMaster;


public interface LoginRegiService {

	LoginRegisterDTO save(LoginRegisterDTO dto1);

	List<LoginRegisterDTO> saveAll(List<LoginRegisterDTO> dto1);


	int SpringJPAUpdateJPQL(String city, int personid);

	int SpringJPAUpdateNativeQuery(String city, int personid);

	LoginRegisterDTO UpdateDataUsingEntityManager(LoginRegisterDTO dto1);

	LoginRegisterDTO SpringJPAUpdateEntityManagerMUltiple(List<LoginRegisterDTO> dto1);

	List<LoginRegisterDTO> SpringJPAUpdateEntityManagerSelect(LoginRegisterDTO dto1);

	List<LoginRegisterDTO> SpringJPASelectQueryAnno(LoginRegisterDTO dto1);

	List<LoginRegisterDTO> SpringJPASelectNativeEntityManger(LoginRegisterDTO dto1);

	List<ProductMaster> saveAll1(List<ProductMaster> dto1);

}
