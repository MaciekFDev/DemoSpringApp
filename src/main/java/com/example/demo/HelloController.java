package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;

import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
public class HelloController {
	Cvreader reader = new Cvreader();
	ArrayList<String > lista = new ArrayList<String>();
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String index(@RequestBody String ob) throws JsonParseException, JsonMappingException, IOException{
    	reader.lista_znalezionych.clear();
    	System.out.println(ob);
    	//List<ObjectJSON> obiekt  = mapper.readValue(ob,new TypeReference<List<ObjectJSON>>() {});
    	
    	lista = reader.stringSplitter2(ob);
    	reader.wczytajCV("C:\\Users\\jarek\\OneDrive\\Pulpit\\demo\\demo\\src\\main\\resources\\cv", lista);
    	reader.usun_duplikaty();
    	for(String cos: reader.lista_znalezionych) {
    		System.out.println(cos);
    	}
    	System.out.println(reader.jsoninString(reader.sendJSON()).toString());
    	
        return reader.jsoninString(reader.sendJSON()) ;// reader.jsoninString(reader.sendJSON()).toString();
    }

    
    
    
    
    

}
