package cr.ac.una.proyecto_paradigmas.controller;

import cr.ac.una.proyecto_paradigmas.model.LogEntry;
import cr.ac.una.proyecto_paradigmas.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/errors")
    public List<LogEntry> obtenerErrores() {
        List<LogEntry> logs = cargarLogs();
        return logService.filtrarErrores(logs);
    }

    @GetMapping("/response-times/average")
    public Optional<Double> obtenerTiempoPromedio() {
        List<LogEntry> logs = cargarLogs();
        return logService.calcularTiempoPromedio(logs);
    }

    @GetMapping("/errors/frequent")
    public Map<String, Long> obtenerErroresFrecuentes() {
        List<LogEntry> logs = cargarLogs();
        return logService.obtenerErroresFrecuentes(logs);
    }

    private List<LogEntry> cargarLogs() {
        return List.of(
                new LogEntry(LocalDateTime.now(), "NullPointerException", 500, 1200, "/api/v1/test"),
                new LogEntry(LocalDateTime.now(), null, 200, 500, "/api/v1/test"),
                new LogEntry(LocalDateTime.now(), "FileNotFoundException", 404, 300, "/api/v1/files"),
                new LogEntry(LocalDateTime.now(), "Timeout", 504, 1500, "/api/v1/request")
        );
    }
}
