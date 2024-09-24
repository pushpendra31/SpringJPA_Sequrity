package Spring.Data.JPA.SpringJPA_Sequrity.Daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.ProductMaster;

public interface productJPARepo extends   JpaRepository<ProductMaster, Integer>{

	Optional<ProductMaster> findByQuantity(Integer id); //column apecific

	Optional<ProductMaster> findByQuantityGreaterThanEqual(Integer id); //GreaterThanEqual

		List<Optional<ProductMaster>> findTop5ByOrderByPidDesc();

		Long  countByQuantity(Integer id);

		List<Optional<ProductMaster>> findByPriceOrderByQuantityDesc(Integer id);

		//List<Optional<ProductMaster>> findByCrtdtBetween();

	
	
	

}
