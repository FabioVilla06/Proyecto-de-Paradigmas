package cr.ac.una.proyecto_paradigmas.service;

import cr.ac.una.proyecto_paradigmas.model.LogEntry;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LogService {

    public List<LogEntry> filtrarErrores(List<LogEntry> logs) {
        return logs.stream()
                .filter(log -> log.getStatusCode() >= 400)
                .collect(Collectors.toList());
    }

    public Optional<Double> calcularTiempoPromedio(List<LogEntry> logs) {
        return logs.stream()
                .map(LogEntry::getResponseTime)
                .reduce(Double::sum)
                .map(total -> total / logs.size());
    }

    public Map<String, Long> obtenerErroresFrecuentes(List<LogEntry> logs) {
        return logs.stream()
                .filter(log -> log.getStatusCode() >= 400)
                .collect(Collectors.groupingBy(LogEntry::getError, Collectors.counting()));
    }

    public List<LogEntry> detectarSolicitudesLentas(List<LogEntry> logs, double umbral) {
        return logs.stream()
                .filter(log -> log.getResponseTime() > umbral)
                .collect(Collectors.toList());
    }
}
