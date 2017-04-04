/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.classifications.api.logic.exceptions.annotations;
 
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy; 

/**
 *
 * @author idali
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Error {
    String message();
    int code(); 
}
