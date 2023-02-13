package com.project1.visiterManagmentSystemService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project1.visiterManagmentSystem.visiterManagmentSystem;
import com.project1.visiterManagmentSystemRepository.visiterManagmentSystemRepository;

@Service
public class visiterManagmentSystemService {
	
	@Autowired
	private visiterManagmentSystemRepository visiterManagmentSystemRepository;
	
	
//	getAllData
	
	public List<visiterManagmentSystem> getAllData() {
	 List<visiterManagmentSystem> list=this.visiterManagmentSystemRepository.findAll();
	 return list;
	}
	
//	update data
	
	public visiterManagmentSystem addData(visiterManagmentSystem visiterManagmentSystem) {
     visiterManagmentSystem visiterManagmentSystem2=this.visiterManagmentSystemRepository.save(visiterManagmentSystem);	
     return visiterManagmentSystem2;
	}
	
	//getByEmailAndPhoneNumber
	
	public visiterManagmentSystem getByEmailandPassword(String email,String password) {
	return	this.visiterManagmentSystemRepository.findByEmailAndPassword(email, password);
	}
	
	//get By Id
	
	public Optional<visiterManagmentSystem>   getById(int id) {
	    Optional<visiterManagmentSystem> visitor= this.visiterManagmentSystemRepository.findById(id);
	return visitor;
	}
	
	//Delete Data By Id
	public void deleteById(int id) {
		this.visiterManagmentSystemRepository.deleteById(id);
	}
	
	//getData by name
	public List<visiterManagmentSystem> getByName(String name) {
		List<visiterManagmentSystem> visiterManagmentSystems=this.visiterManagmentSystemRepository.findByName(name);
		return visiterManagmentSystems;
	}
	
	//getDataBy email
	
	public List<visiterManagmentSystem> getByEmail(String email) {
		List<visiterManagmentSystem> list=this.visiterManagmentSystemRepository.findByEmail(email);
		return list;
	}
	
	
	// get data by id
	
	public Optional<visiterManagmentSystem> getByid(int id) {
		Optional<visiterManagmentSystem> visitor = this.visiterManagmentSystemRepository.findById(id);
		return visitor;
	}
	
	//update data by id
	
	public visiterManagmentSystem updateById(visiterManagmentSystem visiterManagmentSystem,int id) {
	visiterManagmentSystem.setId(id);
	 visiterManagmentSystem visiterManagmentSystem2=this.visiterManagmentSystemRepository.save(visiterManagmentSystem);
	 return visiterManagmentSystem2;
	}
	
	// get data by page no and page size
	
	public Page<visiterManagmentSystem> getAllDataByPage(int pageNumber,int PageSize) {
		PageRequest of = PageRequest.of(pageNumber, PageSize);
		Page<visiterManagmentSystem> findAll = this.visiterManagmentSystemRepository.findAll(of);
		return findAll;
	}
	
	//Search all data
	
	public List<visiterManagmentSystem> searchProducts(String query) {
		System.out.println(query);
		List<visiterManagmentSystem> list=this.visiterManagmentSystemRepository.searchvisiterManagmentSystemsSQL(query);
		for (visiterManagmentSystem visiterManagmentSystem1 : list) {
			System.out.println(visiterManagmentSystem1);
		}
		return list;
	}
	
	//search data by name and date
	
	public List<visiterManagmentSystem> searchProductsByNameAndDate(String name,String date) {
		System.out.println("name :"+name+" date:"+date);
		List<visiterManagmentSystem> list=this.visiterManagmentSystemRepository.searchByNameAndDatevisiterManagmentSystems(name, date);
		for (visiterManagmentSystem visiterManagmentSystem1 : list) {
			System.out.println(visiterManagmentSystem1);
		}
		return list;
	}
	
	// find data with sorting in acending order
	
	public List<visiterManagmentSystem> findWithSorting(String field) {
		return this.visiterManagmentSystemRepository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	//find data by page no and page size with sorting in accending order
	
	public Page<visiterManagmentSystem> getAllDataByPagewithSorting(int pageNumber,int PageSize,String field) {
		PageRequest of = PageRequest.of(pageNumber, PageSize);
		Page<visiterManagmentSystem> findAll = this.visiterManagmentSystemRepository.findAll(of.withSort(Sort.by(Sort.Direction.ASC,field)));
		return findAll;
	}
	
	//search data by starting date and ending date
	
	public List<visiterManagmentSystem> searchByDateRange(String Startingdate,String Endingdate){
	return	this.visiterManagmentSystemRepository.searchByDateRange(Startingdate, Endingdate);
	
	
	}
	
	//advance search
	
	public List<visiterManagmentSystem> advanceSearch(String name,String email,String date,String password){
		return this.visiterManagmentSystemRepository.advanceSearch(name, email, date, password); 
     
	
	}

}


