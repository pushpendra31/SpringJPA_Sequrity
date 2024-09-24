package Dao;

import java.util.List;

import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.LoginRegisterDTO;

public interface EntityDao {
	
	LoginRegisterDTO UpdateDataUsingEntityManager(LoginRegisterDTO dto1);

	LoginRegisterDTO SpringJPAUpdateEntityManagerMUltiple(List<LoginRegisterDTO> dto1);

	List<LoginRegisterDTO> SpringJPAUpdateEntityManagerSelect(LoginRegisterDTO dto1);

	List<LoginRegisterDTO> SpringJPASelectQueryAnno(LoginRegisterDTO dto1);

	List<LoginRegisterDTO> SpringJPASelectNativeEntityManger(LoginRegisterDTO dto1);

}
