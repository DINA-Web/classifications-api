/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.classifications.api.logic.exceptions;
  

/**
 *
 * @author idali
 */
public enum StatusType {
     
    InternalServerError("Internal Server Error", 500), 
    UnsupportedMediaType("Unsupported Media Type", 415), 
    BadRequest("Bad Request", 400), 
    NotFound("Not Found", 404),
    Forbidden("Forbidden", 403),
    Unauthorized("Unauthorized", 401), 
    OK("OK", 200), 
    NoContent("No Content", 204);
    
    private final String message;
    private final int code;
    
    private StatusType(final String message, final int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    } 
}
