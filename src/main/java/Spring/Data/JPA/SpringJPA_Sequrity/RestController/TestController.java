package Spring.Data.JPA.SpringJPA_Sequrity.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.LoginRegisterDTO;
import Spring.Data.JPA.SpringJPA_Sequrity.DTOs.ProductMaster;
import Spring.Data.JPA.SpringJPA_Sequrity.Daoimpl.UserRepo;
import Spring.Data.JPA.SpringJPA_Sequrity.Daoimpl.productJPARepo;
import Spring.Data.JPA.SpringJPA_Sequrity.services.LoginRegiService;
import jakarta.transaction.Transactional;



@RestController
public class TestController {
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	 @Autowired
	 productJPARepo prodRepo;
		/*
		 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
		 * BCryptPasswordEncoder(); }
		 */
		private static final Logger log=LoggerFactory.getLogger(TestController.class);
	@Autowired
	public  UserRepo repo;
	@Autowired
	LoginRegiService service;
	@RequestMapping(value = "/loginDetails" , method = RequestMethod.GET )
	 public   ResponseEntity login(@RequestBody LoginRegisterDTO dto) { 
		LoginRegisterDTO login = new LoginRegisterDTO();

		Optional<LoginRegisterDTO> returndto=Optional.ofNullable(new LoginRegisterDTO());
		//returndto = repo.findByEmail(dto.getEmail());
		//ResponseEntity res=new ResponseEntity<LoginRegisterDTO>(null);
		//return new ResponseEntity<>(returndto.get(), HttpStatus.ACCEPTED);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	@RequestMapping(value = "/admin/springSequrity" , method = RequestMethod.GET)
	 public  String springSequrity() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "User  currently authnticated is   ="+authentication.getName();
		
		
	}
// 1. --------Insert SAVE ---------
	@RequestMapping(value = "/springJPATestSaveData" , method = RequestMethod.GET)
	 public  LoginRegisterDTO  springJPATest(@RequestBody LoginRegisterDTO dto1) {
		LoginRegisterDTO dto = null;
		// dto= service.save(dto1);
		dto1.setPassword(this.passwordEncoder.encode(dto1.getPassword()));
		    LoginRegisterDTO saveAll = repo.save(dto1);

		 Optional<LoginRegisterDTO> findByCity1 = java.util.Optional.empty();
		try {
		// List<LoginRegisterDTO> findByCity  = repo.findByLastName("pushp.11122@gmail.com");
		}

	catch(Exception e) {
	System.out.println("error  here inn testcontroller "+e);
	}

		return  saveAll;
		
		
	}
	// 2. --------Delete ---------

	@RequestMapping(value = "/SpringJPADeleteOne" , method = RequestMethod.DELETE)

	 public  ResponseEntity<LoginRegisterDTO> SpringJPADelete(@RequestBody LoginRegisterDTO dto1) {
		LoginRegisterDTO dto = null;			int deleteUsingModifyNativeQuery;
		try {
                // repo.delete(dto1) ;//delete  only 1  entry with  contained  pK
               // repo.deleteById(1); //delete by id  given 
                //repo.deleteAll(); //it  will  delete all record  from DB
                //repo.deleteAll(List<LoginRegisterDTO> dto2); // it  will  this  all record  with pk
              //repo.deleteUsingModifyJPQL(dto1.getPersonid());  using JPQL query
	 deleteUsingModifyNativeQuery = repo.deleteUsingModifyNativeQuery(dto1.getPersonid());//Using  native  query 
			System.out.println("return of  delete  data "+deleteUsingModifyNativeQuery);
		}

	catch(Exception e) {
	System.out.println("Error  here inn testcontroller "+e);
	return  new ResponseEntity<LoginRegisterDTO>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
		if(deleteUsingModifyNativeQuery!=0) {
			return  new ResponseEntity<LoginRegisterDTO>(HttpStatus.ACCEPTED);

		}else
			{return  new ResponseEntity<LoginRegisterDTO>(HttpStatus.INTERNAL_SERVER_ERROR);}

		

		
		
	}
	
	// --  2.1 delete all
	@RequestMapping(value = "/SpringJPADeleteAll" , method = RequestMethod.DELETE)

	 public  ResponseEntity<LoginRegisterDTO> SpringJPADeleteAll(@RequestBody List<LoginRegisterDTO> dto1) {
		LoginRegisterDTO dto = null;
		List<Integer> pk=dto1.stream().map(a->a.getPersonid()).collect(Collectors.toList());
		try {
                //repo.deleteAll(dto1); //it  will  delete all record  from DB
               repo.deleteAllById(pk); // it  will  this  all record  with pk
             
           
		 Optional<LoginRegisterDTO> findByCity1 = java.util.Optional.empty();
		
		 findByCity1  = repo.findByEmail("pushp.11122@gmail.com");
		}

	catch(Exception e) {
	System.out.println("Error  here inn testcontroller "+e);
	return  new ResponseEntity<LoginRegisterDTO>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
		return  new ResponseEntity<LoginRegisterDTO>(HttpStatus.ACCEPTED);

		
		
	}
	// 3. . --------Update SAVE ---------

	@RequestMapping(value = "/SpringJPAUpdateJPQLNative" , method = RequestMethod.PATCH)

	 public  ResponseEntity<Integer> v(@RequestBody LoginRegisterDTO dto1) {
		List<LoginRegisterDTO> dto = null;		int springJPAUpdateJPQL1;
		try{
			 springJPAUpdateJPQL1 = service.SpringJPAUpdateJPQL(dto1.getCity(),dto1.getPersonid());

		}
	catch(Exception e) {
	System.out.println("Error  here inn testcontroller "+e);
	return  new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
		return  new ResponseEntity<Integer>(springJPAUpdateJPQL1,HttpStatus.ACCEPTED);

		
		
	}
	// 3.1 -------Update save using native  query
		@RequestMapping(value = "/SpringJPAUpdateNativeQuery" , method = RequestMethod.PATCH)

	 public  ResponseEntity<Integer> SpringJPAUpdateNativeQuery(@RequestBody LoginRegisterDTO dto1) {
		List<LoginRegisterDTO> dto = null;		int springJPAUpdateJPQL1;
		try{
			 springJPAUpdateJPQL1 = service.SpringJPAUpdateNativeQuery(dto1.getCity(),dto1.getPersonid());

		}
	catch(Exception e) {
	System.out.println("Error  here inn testcontroller "+e);
	return  new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
		return  new ResponseEntity<Integer>(springJPAUpdateJPQL1,HttpStatus.ACCEPTED);

		
		
	}

	// ----- (1,2,3).EntityManager implemetation ------------
	// ----------- entityManager insert 1 DTO only ----------------
	@RequestMapping(value = "/SpringJPAUpdateEntityManager", method = RequestMethod.PATCH)
	public LoginRegisterDTO SpringJPAUpdateEntityManager(@RequestBody LoginRegisterDTO dto1) {
		LoginRegisterDTO updateDataUsingEntityManager = service.UpdateDataUsingEntityManager(dto1);
		return updateDataUsingEntityManager;

	}

	// ----------- entityManager insert List DTO ----------------

	@RequestMapping(value = "/SpringJPAUpdateEntityManagerMUltiple", method = RequestMethod.POST)
	public LoginRegisterDTO SpringJPAUpdateEntityManagerMultiple(@RequestBody List<LoginRegisterDTO> dto1) {
		LoginRegisterDTO updateDataUsingEntityManager = service.SpringJPAUpdateEntityManagerMUltiple(dto1);
		return updateDataUsingEntityManager;

	}
	
	// ----------- entityManager select and   criteria  ----------------

	@RequestMapping(value = "/SpringJPAUpdateEntityManagerSelect", method = RequestMethod.GET)
	public List<LoginRegisterDTO> SpringJPAUpdateEntityManagerSelect(@RequestBody LoginRegisterDTO dto1) {
		List<LoginRegisterDTO> updateDataUsingEntityManager = service.SpringJPAUpdateEntityManagerSelect(dto1);
		return updateDataUsingEntityManager;

	}
	// ----------- entityManager select and   criteria  ----------------

	@RequestMapping(value = "/SpringJPAUpdateEntityManagerSelAnnot", method = RequestMethod.GET)
	public List<LoginRegisterDTO> SpringJPAUpdateEntityManagerSelAnnot(@RequestBody LoginRegisterDTO dto1) {
		List<LoginRegisterDTO> updateDataUsingEntityManager = service.SpringJPASelectQueryAnno(dto1);
		return updateDataUsingEntityManager;

	}
	@RequestMapping(value = "/SpringJPASelectNativeEntityManger", method = RequestMethod.GET)
	public List<LoginRegisterDTO> SpringJPASelectNativeEntityManger(@RequestBody LoginRegisterDTO dto1) {
            List<LoginRegisterDTO> springJPASelectNativeEntityManger = service.SpringJPASelectNativeEntityManger(dto1);
		return springJPASelectNativeEntityManger;

	}
    //----- JPA fetch get data from JPA repositry Using  method generated query  -------------
	// ----------Product entity Operation from here ----------

	@RequestMapping(value = "/SpringJPASaveProdutMst", method = RequestMethod.POST)
	public List<ProductMaster> SpringJPASaveProdutMst(@RequestBody List<ProductMaster> dto1) {
		List<ProductMaster> updateDataUsingEntityManager = service.saveAll1(dto1);
		return updateDataUsingEntityManager;

	}

	// -------------Getdata 1 record fetch only  from productMst Using inbuilt JPA method --------------
	@RequestMapping(value = "/SpringJPAGETProdutMst/{id}", method = RequestMethod.GET)
	public ProductMaster SpringJPAGETProdutMst(@PathVariable("id") Integer id) {
		Optional<ProductMaster> updateDataUsingEntityManager = prodRepo.findById(id);
		return updateDataUsingEntityManager.get();

	}
	// -------------Getdata 1.1 record fetch only  from productMst Uisng CustomMethodCreated Query--------------
	@RequestMapping(value = "/SpringJPAGETProdutMstJPAMethod_customQuery/{quantity}", method = RequestMethod.GET)
	public ProductMaster SpringJPAGETProdutMstJPAMethod_customQuery(@PathVariable("quantity") Integer quantity) {
		Optional<ProductMaster> updateDataUsingEntityManager = prodRepo.findByQuantity(quantity);
		log.info("api call end and  id is ="+updateDataUsingEntityManager.get().toString());
		log.trace("api call end and  id is ="+updateDataUsingEntityManager.get().toString());
		return updateDataUsingEntityManager.get();

	}
	// -------------Getdata 1.2 record fetch only  from productMst Uisng CustomMethodCreated Query--------------
	@RequestMapping(value = "/SpringJPAGETProdutOneIteamMstJPAMethod/{id}", method = RequestMethod.GET)
	public List<Optional<ProductMaster>>SpringJPAGETProdutOneIteamMstJPAMethod(@PathVariable("id") Integer id) {
		Optional<ProductMaster> updateDataUsingEntityManager=null;
		//Optional<ProductMaster> updateDataUsingEntityManager = prodRepo.findByQuantityGreaterThanEqual(id);
		//List<Optional<ProductMaster>> findTop5ByOrderByIdDesc = prodRepo.findTop5ByOrderByPidDesc();
		//Long countByQuantity = prodRepo.countByQuantity(id);
		//List<Optional<ProductMaster>> findByPriceOrderByQuantityDesc = prodRepo.findByPriceOrderByQuantityDesc(id);
		List<Optional<ProductMaster>> findByCrtdtBetween = null;//prodRepo.findByCrtdtBetween(Date dt);
		return findByCrtdtBetween;

	}
}
