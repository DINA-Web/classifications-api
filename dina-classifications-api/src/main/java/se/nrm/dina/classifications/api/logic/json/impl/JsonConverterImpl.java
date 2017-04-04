/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.classifications.api.logic.json.impl;

import au.org.ala.names.model.NameSearchResult;    
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.nrm.dina.classifications.api.logic.exceptions.StatusType;
import se.nrm.dina.classifications.api.logic.json.JsonConverter;
import se.nrm.dina.classifications.api.utils.CommonString; 
import se.nrm.dina.classifications.api.utils.Util;

/**
 *
 * @author idali
 */
@Stateless
public class JsonConverterImpl implements JsonConverter {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final JsonBuilderFactory JSON_FACTORY = Json.createBuilderFactory(null);
    private NameSearchResult result;
    private String queryParam;
    private String queryValue;
    private String url; 

    @Override
    public JsonObject convertResult(NameSearchResult result, String queryParam, String queryValue, String url) {
        
        logger.info("convertResult");
        this.result = result;
        this.queryValue = queryValue;
        this.queryParam = queryParam;
        this.url = url; 
    
        JsonObjectBuilder jsonBuilder = JSON_FACTORY.createObjectBuilder();
        addMeta(jsonBuilder);
        
        if(result != null) {
            addData(jsonBuilder);
        }
        
        return jsonBuilder.build();  
    }
    
    private void addMeta(JsonObjectBuilder jsonBuilder) {
        jsonBuilder.add(CommonString.getInstance().getMeta(), JSON_FACTORY.createObjectBuilder()
                        .add(CommonString.getInstance().getCallEndPoint(),
                                CommonString.getInstance().getEndPoint(queryParam, queryValue, url))
                        .add(CommonString.getInstance().getApiVersion(), CommonString.getInstance().getApiVersionValue(url))
                        .add(CommonString.getInstance().getContentLicenses(), CommonString.getInstance().getLicenses())
                        .add(CommonString.getInstance().getResultCount(), getResultCount())
                        .add(CommonString.getInstance().getStatusCode(), getStatusCode())
                        .add(CommonString.getInstance().getMaintenanceContact(), CommonString.getInstance().getMaintenanceContactValue())
                        .add(CommonString.getInstance().getCallDate(), Util.getInstance().getStrTimeStamp()));
    }
    
    private void addData(JsonObjectBuilder jsonBuilder) {
        jsonBuilder.add(CommonString.getInstance().getData(), JSON_FACTORY.createObjectBuilder()
                        .add(CommonString.getInstance().getId(), result.getId())
                        .add(CommonString.getInstance().getType(), NameSearchResult.class.getSimpleName())
                        .add(CommonString.getInstance().getAttributes(), JSON_FACTORY.createObjectBuilder()
                            .add(CommonString.getInstance().getLsid(), result.getLsid()) 
                            .add(CommonString.getInstance().getScientificName(), result.getRankClassification().getScientificName())));
    }
    
    private int getStatusCode() {
        return result == null ? StatusType.NoContent.getCode() : StatusType.OK.getCode();
    }
            
    
    private int getResultCount() {
        return result == null ? 0 : 1;
    }
     
    @Override
    public JsonObject convertError(String errorMessage, StatusType type, String urlPath) {
          
        return JSON_FACTORY.createObjectBuilder()
                .add(CommonString.getInstance().getErrors(), JSON_FACTORY.createArrayBuilder()
                        .add(JSON_FACTORY.createObjectBuilder()
                            .add(CommonString.getInstance().getStatusCode(), type.getCode())
                            .add(CommonString.getInstance().getSource(), 
                                    CommonString.getInstance().getEndPoint(queryParam, queryValue, urlPath))
                            .add(CommonString.getInstance().getTitle(), type.getMessage())
                            .add(CommonString.getInstance().getDetail(),errorMessage)))
                        .build(); 
    } 
}
