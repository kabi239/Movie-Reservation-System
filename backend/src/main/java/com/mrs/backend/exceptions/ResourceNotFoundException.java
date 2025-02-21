package com.mrs.backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    String resourseName;
    String fieldName;
    String field;
    Long fieldId;
    
    public ResourceNotFoundException(){

    }
    public ResourceNotFoundException(String resourseName, String field,  String fieldName){
        super(String.format("%s not found with %s : '%s'", resourseName, field ,fieldName));
        this.resourseName = resourseName;
        this.field = field;
        this.fieldName = fieldName;        
    }
    public ResourceNotFoundException(String resourseName,String field, Long fieldId){
        super(String.format("%s not found with %s : '%d'", resourseName, field ,fieldId));
        this.resourseName = resourseName;
        this.field = field;
        this.fieldId = fieldId;
    }
}
