 package com.project1.visiterManagmentSystemRepository;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.project1.visiterManagmentSystem.visiterManagmentSystem;
//@Repository
public interface visiterManagmentSystemRepository extends JpaRepository<visiterManagmentSystem, Integer> {
	

	public List<visiterManagmentSystem> findByName(String name);
	public List<visiterManagmentSystem> findByNameAndPassword(String name,String password);
	public List<visiterManagmentSystem> findByEmail(String email);
	public visiterManagmentSystem findByEmailAndPassword(String Email,String password);
//	public List<visiterManagmentSystem> findByNameContainingAndvisiterManagmentSyetem(String name, visiterManagmentSystem visiterManagmentSystem );
	
	@Query(value="SELECT * FROM visiter_table where name  LIKE (%:query%) or address LIKE (%:query%) or email LIKE (%:query%) or date LIKE (%:query%) or id LIKE (%:query%) or phone LIKE (%:query%) or gender  LIKE (%:query%) or password  LIKE (%:query%)",nativeQuery = true)
	public List<visiterManagmentSystem> searchvisiterManagmentSystemsSQL(String query);



@Query(value="SELECT * FROM visiter_table where name LIKE (%:name%) and date LIKE (%:date%)",nativeQuery = true)
public List<visiterManagmentSystem> searchByNameAndDatevisiterManagmentSystems(String name,String date);


@Query(value="SELECT * FROM visiter_table where date between :stratingdate AND :endingdate",nativeQuery = true)
public List<visiterManagmentSystem> searchByDateRange(String stratingdate,String endingdate);

@Query(value = "SELECT * FROM visiter_table where name LIKE (%:name%) And email LIKE (%:email%) And date LIKE (%:date%) And password LIKE (%:password%)",nativeQuery = true)
public List<visiterManagmentSystem> advanceSearch(String name,String email,String date,String password ); 

}
