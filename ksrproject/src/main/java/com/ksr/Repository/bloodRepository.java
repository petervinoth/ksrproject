package com.ksr.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ksr.Model.Blood;
@Component
@Repository
public interface bloodRepository extends CrudRepository<Blood,Integer> {
	 List<Blood>  findByBloodgroup(String bloodgroup);
	 
	// List<Blood>  findByLocation(String location);
	 
	 
	 List<Blood> findByName(String  name);
	 
	 
	 

	 
	
}
