/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.classifications.api.logic;

import au.org.ala.names.model.LinnaeanRankClassification;
import au.org.ala.names.model.NameSearchResult;
import au.org.ala.names.search.ALANameSearcher; 
import java.io.IOException;
import java.io.Serializable;   
import javax.enterprise.context.ApplicationScoped; 
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject; 
import javax.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import se.nrm.dina.classifications.api.logic.exceptions.StatusType; 
import se.nrm.dina.classifications.api.logic.json.JsonConverter;
import se.nrm.dina.classifications.api.utils.CommonString;

/**
 *
 * @author idali
 */
//@Stateless
@ApplicationScoped
public class ClassificationsLogic implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final String LOCAL_DATA_POINT = "/Users/idali/docker_project/ala-docker/data/namematching";
    private final String DOCKER_DATA_POINT = "/data/lucene/namematching";
    private NameSearchResult result;
    
    private static final JsonBuilderFactory JSON_FACTORY = Json.createBuilderFactory(null);
    
    @Inject
    JsonConverter jsonConverter;

    public ClassificationsLogic() {

    }

    @Produces 
    public JsonObject getNameSearchResult(String scientificName, String url) {
        
        logger.info("getNameSearchResult : {}", scientificName);
 
        try {
            ALANameSearcher searcher = new ALANameSearcher(DOCKER_DATA_POINT);
         
            LinnaeanRankClassification cl = new LinnaeanRankClassification();  
            cl.setScientificName(scientificName);   
              
            result = searcher.searchForAcceptedRecordDefaultHandling(cl, true);
      
            return jsonConverter.convertResult(result, CommonString.getInstance().getScientificName(), scientificName, url); 
        } catch (IOException ex) {  
            return jsonConverter.convertError(ex.getMessage(), StatusType.InternalServerError, url); 
        } 
    }
}