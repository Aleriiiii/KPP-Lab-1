package ua.khnu.kpp.lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ElectricityUsageTest {
    private static final double EPSILON = 1e-9;

    @Test
    void calculatesControlValues() {
        ElectricityUsage usage = new ElectricityUsage(12450.0, 12638.0, 4.32, 30);
        assertEquals(188.0, usage.consumption(), EPSILON);
        assertEquals(812.16, usage.cost(), EPSILON);
        assertEquals(188.0 / 30.0, usage.averageDailyConsumption(), EPSILON);
    }

    @Test
    void rejectsInvalidParameters() {
        assertThrows(IllegalArgumentException.class, () -> new ElectricityUsage(-5.0, 100.0, 4.32, 30));
        assertThrows(IllegalArgumentException.class, () -> new ElectricityUsage(200.0, 100.0, 4.32, 30));
        assertThrows(IllegalArgumentException.class, () -> new ElectricityUsage(100.0, 200.0, 0.0, 30));
        assertThrows(IllegalArgumentException.class, () -> new ElectricityUsage(100.0, 200.0, 4.32, 0));
    }
}