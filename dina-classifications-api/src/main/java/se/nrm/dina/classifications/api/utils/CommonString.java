/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.classifications.api.utils;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author idali
 */
public class CommonString {
    
    private static CommonString instance = null;
    
    private final static String CALL_END_POINT = "callEndpoint";
    private final static String API_VERSION = "apiVersion";
    private final static String CALL_DATE = "callDate"; 
    private final static String SCIENTIFIC_NAME = "scientificName";
    private final static String MAINTENANCE_CONTACT = "maintenanceContact";
    private final static String MAINTENANCE_CONTACT_VALUE = "admin@dina-system.org";
    private final static String CONTENT_LICENSES = "contentLicenses";
    private final static String LICENSES = "";
    private final static String RESULT_COUNT = "resultCount";
    private final static String STATUS_CODE = "statusCode";
    
    private final static String META = "meta";
    private final static String DATA = "data";
    private final static String TYPE = "type";
    private final static String ID = "id";
    private final static String ATTRIBUTES = "attributes";
    private final static String LSID = "lsid";
    
    private final static String ERRORS = "errors";
    private final static String SOURCE = "source";
    private final static String TITLE = "title";
    private final static String DETAIL = "detail";
     
    public static synchronized CommonString getInstance() {
        if (instance == null) {
            instance = new CommonString();
        }
        return instance;
    }
    
    
    public String getCallEndPoint() {
        return CALL_END_POINT;
    }
  
    public String getCallDate() {
        return CALL_DATE;
    }
    
    public String getEndPoint(String queryParam, String queryValue, String url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("?");
        sb.append(queryParam);
        sb.append("=");
        sb.append(queryValue);
        return sb.toString();
    }
    
    public String getApiVersion() {
        return API_VERSION;
    }
    
    public String getApiVersionValue(String url) {
        String strVersion = StringUtils.substringBetween(url, "/v", "/search");
        return strVersion == null ? "1" : strVersion; 
    } 
    
    public String getScientificName() {
        return SCIENTIFIC_NAME;
    }
    
    public String getMaintenanceContact() {
        return MAINTENANCE_CONTACT;
    }
    
    public String getMaintenanceContactValue() {
        return MAINTENANCE_CONTACT_VALUE;
    }
    
    public String getContentLicenses() {
        return CONTENT_LICENSES;
    }
    
    public String getLicenses() {
        return LICENSES;
    }
    
    public String getResultCount() {
        return RESULT_COUNT;
    }
    
    public String getStatusCode() {
        return STATUS_CODE;
    }
    
    public String getType() {
        return TYPE;
    }
    
    public String getId() {
        return ID;
    }
    
    public String getMeta() {
        return META;
    }
    
    public String getData() {
        return DATA;
    }
    
    public String getAttributes() {
        return ATTRIBUTES;
    }
    
    public String getLsid() {
        return LSID;
    }
    
    public String getErrors() {
        return ERRORS;
    }
    
    public String getSource() {
        return SOURCE;
    }
    
    public String getTitle() {
        return TITLE;
    }
    
    public String getDetail() {
        return DETAIL;
    }
}
