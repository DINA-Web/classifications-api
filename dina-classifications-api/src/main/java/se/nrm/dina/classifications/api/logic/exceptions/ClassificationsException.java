/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.classifications.api.logic.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author idali
 */
@ApplicationException
public class ClassificationsException extends RuntimeException {

    private final int errorCode;
    private final String errorType;
    private final String errorMessage; 
    
    public ClassificationsException(final int errorCode, final String errorType, final String errorMessage) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    } 
}
