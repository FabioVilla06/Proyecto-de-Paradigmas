package cr.ac.una.proyecto_paradigmas.service;

import cr.ac.una.proyecto_paradigmas.model.LogEntry;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LogServiceTests {

    private final LogService logService = new LogService();

    @Test
    public void testFiltrarErrores() {
        List<LogEntry> logs = List.of(
                new LogEntry(LocalDateTime.now(), null, 200, 500, "/api/v1/test"),
                new LogEntry(LocalDateTime.now(), "NullPointerException", 500, 1200, "/api/v1/test")
        );
        List<LogEntry> errores = logService.filtrarErrores(logs);
        assertEquals(1, errores.size());
        assertEquals(500, errores.get(0).getStatusCode());
    }

    @Test
    public void testCalcularTiempoPromedio() {
        List<LogEntry> logs = List.of(
                new LogEntry(LocalDateTime.now(), null, 200, 500, "/api/v1/test"),
                new LogEntry(LocalDateTime.now(), null, 200, 1000, "/api/v1/test")
        );
        Optional<Double> promedio = logService.calcularTiempoPromedio(logs);
        assertTrue(promedio.isPresent());
        assertEquals(750, promedio.get());
    }
}
