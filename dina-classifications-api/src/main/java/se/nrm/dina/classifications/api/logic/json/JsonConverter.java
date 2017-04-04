/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.classifications.api.logic.json;

import au.org.ala.names.model.NameSearchResult;
import javax.json.JsonObject; 
import se.nrm.dina.classifications.api.logic.exceptions.StatusType;

/**
 *
 * @author idali
 */
public interface JsonConverter {
     JsonObject convertResult(NameSearchResult result, String queryParam, String queryValue, String url);
     JsonObject convertError(String errorMessage, StatusType type, String url);
}
