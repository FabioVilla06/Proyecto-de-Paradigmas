package cr.ac.una.proyecto_paradigmas.model;

import java.time.LocalDateTime;

public class LogEntry {
    private LocalDateTime timestamp;
    private String error;
    private int statusCode;
    private double responseTime;
    private String endpoint;

    // Constructor
    public LogEntry(LocalDateTime timestamp, String error, int statusCode, double responseTime, String endpoint) {
        this.timestamp = timestamp;
        this.error = error;
        this.statusCode = statusCode;
        this.responseTime = responseTime;
        this.endpoint = endpoint;
    }

    // Getters y Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
