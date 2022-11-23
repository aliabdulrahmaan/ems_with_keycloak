package com.ems.EmployeeManagementService.exception;

public class BadRequestAlertException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String entityName;

    private final String errorKey;
    private final String defaultMessage;
    private  String message;

    public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {

        this.entityName = entityName;
        this.errorKey = errorKey;
        this.defaultMessage = defaultMessage;

    }

    public BadRequestAlertException(String message, String entityName, String errorKey, String defaultMessage) {

        this.entityName = entityName;
        this.errorKey = errorKey;
        this.defaultMessage = defaultMessage;
        this.message = message;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BadRequestAlertException{" +
                "entityName='" + entityName + '\'' +
                ", errorKey='" + errorKey + '\'' +
                ", defaultMessage='" + defaultMessage + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
