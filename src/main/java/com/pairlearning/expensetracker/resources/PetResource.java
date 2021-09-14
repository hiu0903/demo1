package com.pairlearning.expensetracker.resources;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pairlearning.expensetracker.domain.Pet;
import com.pairlearning.expensetracker.services.PetService;

@RestController
@RequestMapping("/api/pet")
public class PetResource {

	@Autowired
    PetService petService;
	
	@GetMapping("")
    public ResponseEntity<List<Pet>> getAllCategories(HttpServletRequest request) {
        int uid = (Integer) request.getAttribute("uid");
        List<Pet> pet = petService.fetchAllPet(uid);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping("/{petid}")
    public ResponseEntity<Pet> getCategoryById(HttpServletRequest request,
                                                    @PathVariable("petid") Integer petid) {
        int uid = (Integer) request.getAttribute("uid");
        Pet pet = petService.fetchPetById(uid);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    
    @PostMapping("")			
    public ResponseEntity<Pet> addPet(HttpServletRequest request,
                                                @RequestBody Map<String, Object> petMap) throws ParseException {
    	String ipbirth = (String) petMap.get("birth");
    	SimpleDateFormat formatter =new SimpleDateFormat("yyyy/MM/dd");
    	Date fbirth = new java.sql.Date(formatter.parse(ipbirth).getTime());
        int uid = (Integer) petMap.get("uid");
        String name = (String) petMap.get("name");
        java.sql.Date birth = (Date) fbirth;
        String breed = (String) petMap.get("breed");
        String kind = (String) petMap.get("kind");
        Timestamp added = (Timestamp) petMap.get("added");
        Timestamp updated = (Timestamp) petMap.get("updated");
        String img = (String) petMap.get("img");
        Pet pet = petService.addPet(uid, name, birth,breed,kind,added,updated,img);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @PutMapping("/{petid}")
    public ResponseEntity<Map<String, Boolean>> updatePet(HttpServletRequest request,
                                                               @PathVariable("petid") Integer petid,
                                                               @RequestBody Pet pet) {
        int uid = (Integer) request.getAttribute("uid");
        petService.updatePet(uid, pet);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
 
    @DeleteMapping("/{petid}")
    public ResponseEntity<Map<String, Boolean>> deletePet(HttpServletRequest request,
                                                               @PathVariable("petid") Integer petid) {
        int uid = (Integer) request.getAttribute("userId");
        petService.removePetWithAllProduct(uid);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
