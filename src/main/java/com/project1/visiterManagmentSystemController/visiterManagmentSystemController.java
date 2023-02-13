package com.project1.visiterManagmentSystemController;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project1.visiterManagmentSystem.visiterManagmentSystem;
import com.project1.visiterManagmentSystemService.visiterManagmentSystemService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api")
public class visiterManagmentSystemController {
	@Autowired
	private  visiterManagmentSystemService visiterManagmentSystemService;
//	private ResponseEntity<com.project1.visiterManagmentSystem.visiterManagmentSystem> ResponseEntity<visiterManagmentSystem> response;
	
	
//	@GetMapping("/visitors")
//	public visiterManagmentSystem getByEmailandPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
//		return visiterManagmentSystemService.getByEmailandPassword(email, password);
//	}
	@GetMapping("/visitor/{email}/{password}")
	public visiterManagmentSystem getByEmailandPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
		return visiterManagmentSystemService.getByEmailandPassword(email, password);
	}
	
	@GetMapping("/visitor")
	public List<visiterManagmentSystem> getallData(){
		List<visiterManagmentSystem> list=this.visiterManagmentSystemService.getAllData();
		return list;
	}
		
	@GetMapping("/visitors/{name}")
	public List<visiterManagmentSystem> getByName(@PathVariable("name") String name) {
		List<visiterManagmentSystem> list=this.visiterManagmentSystemService.getByName(name);
		return list;
	}
	
	@GetMapping("/visitor/{email}")
	public List<visiterManagmentSystem> getByEmail(@PathVariable("email") String email){
		List<visiterManagmentSystem> list=this.visiterManagmentSystemService.getByEmail(email);
		return list;
	}
	@GetMapping("/visitorid/{id}")
	public Optional<visiterManagmentSystem> getByid(@PathVariable("id") int id){
		Optional<visiterManagmentSystem> visiterManagmentSystem=this.visiterManagmentSystemService.getByid(id);
		return visiterManagmentSystem;
	}
	
//	@PostMapping("/visitor")
//	public String addData(@Valid @RequestBody visiterManagmentSystem visiterManagmentSystem) {
//		System.out.println("post method run");
//	visiterManagmentSystem visitor=this.visiterManagmentSystemService.addData(visiterManagmentSystem);
//	String name =visitor.getName();
//	return "Hii "+name+" your data is inserted successfully ";
//	}
	
	@PostMapping("/visitor")
	public ResponseEntity<visiterManagmentSystem> addData(@Valid @RequestBody visiterManagmentSystem visiterManagmentSystem) {
		System.out.println("post method run");
		visiterManagmentSystem visitor=this.visiterManagmentSystemService.addData(visiterManagmentSystem);
		
		 ResponseEntity<visiterManagmentSystem> response = new ResponseEntity<visiterManagmentSystem>(visitor,HttpStatus.CREATED);
		 System.out.println(response);
		 return response;
	}
	
	//delete dara by id
	
	@DeleteMapping("/visitor/{id}")
	public List<visiterManagmentSystem> deletedata (@PathVariable("id")int id){
		this.visiterManagmentSystemService.deleteById(id);
		return this.visiterManagmentSystemService.getAllData();
	}
	
	//put data by id
	
	@PutMapping("visitor/{id}")
	public String updateDataById(@PathVariable("id")int id,@RequestBody visiterManagmentSystem visiterManagmentSystem) {
		visiterManagmentSystem visiterManagmentSystem2=this.visiterManagmentSystemService.updateById(visiterManagmentSystem, id);
	return "hiii "+visiterManagmentSystem2.getName()+" your data is updated successfully";
	}
	
	
	//pagination
	
	@GetMapping("/page")
	public Page<visiterManagmentSystem> getAllDataBy(@RequestParam(value="pageNumber",defaultValue = "0")
	int pageNumber,@RequestParam(value="pageSize",defaultValue = "5")int pageSize){
		Page<visiterManagmentSystem> allDataByPage = this.visiterManagmentSystemService.getAllDataByPage(pageNumber, pageSize);
		return allDataByPage;
	}
	
	// search by all data
	@GetMapping("/api/search/{query}")
	public ResponseEntity<List<visiterManagmentSystem>> searchdata(@PathVariable("query") String query){
		System.out.println(query);
		List<visiterManagmentSystem> list=this.visiterManagmentSystemService.searchProducts(query);
		for (visiterManagmentSystem visiterManagmentSystem1 : list) {
			System.out.println(visiterManagmentSystem1);
		}
		
	return ResponseEntity.ok(list);
	}
	
	
	//search by name and Date
	@GetMapping("/api/search/{name}/{date}")
	public ResponseEntity<List<visiterManagmentSystem>> searchdata(@PathVariable("name") String name,@PathVariable("date")String date){
		System.out.println("name:"+name+" date:"+date);
		List<visiterManagmentSystem> list=this.visiterManagmentSystemService.searchProductsByNameAndDate(name, date);
		for (visiterManagmentSystem visiterManagmentSystem1 : list) {
			System.out.println(visiterManagmentSystem1);
		}
		
		return ResponseEntity.ok(list);
	}
	
	//search by date Range
	@GetMapping("/api/range/{Startingdate}/{Endingdate}")
//	public ResponseEntity<List<visiterManagmentSystem>> searchByDateRange(@PathVariable("Startingdate") String Startingdate,@PathVariable("Endingdate") String Endingdate){
		public List<visiterManagmentSystem> searchByDateRange(@PathVariable("Startingdate") String Startingdate,@PathVariable("Endingdate") String Endingdate){
		
		List<visiterManagmentSystem> list= this.visiterManagmentSystemService.searchByDateRange(Startingdate, Endingdate);
		System.out.println("list"+ list);
		for (visiterManagmentSystem visiterManagmentSystem1 : list) {
			System.out.println(visiterManagmentSystem1);
		}
//		return ResponseEntity.ok(list); 
		return list;
		
		
	}
	
	
//	sorting data
	
	@GetMapping("/sort/{field}")
	public List<visiterManagmentSystem> getwithSort(@PathVariable("field")String field){
		List<visiterManagmentSystem> allproducts =this.visiterManagmentSystemService.findWithSorting(field);
		return allproducts;
	}
	
	//pagination with sorting
	
	@GetMapping("/paginationwithsort")
	public Page<visiterManagmentSystem> getAllDataBy(@RequestParam(value="pageNumber",defaultValue = "0")
	int pageNumber,@RequestParam(value="pageSize",defaultValue = "5")int pageSize,@RequestParam(value = "field") String field ){
		Page<visiterManagmentSystem> allDataByPage = this.visiterManagmentSystemService.getAllDataByPagewithSorting(pageNumber, pageSize, field);
		return allDataByPage;
	
}
	
	//advance searching
	@GetMapping("/api/advanceSearch")
	public ResponseEntity<List<visiterManagmentSystem>> advanceSearch(@RequestParam(value = "name",defaultValue = "")String name,
			@RequestParam(value = "email",defaultValue = "")String email,@RequestParam(value = "date",defaultValue = "")String date,
			 @RequestParam(value = "password",defaultValue = "")String password ){
		List<visiterManagmentSystem> list=this.visiterManagmentSystemService.advanceSearch(name, email, date, password);
	return	ResponseEntity.ok(list);
	}
}


