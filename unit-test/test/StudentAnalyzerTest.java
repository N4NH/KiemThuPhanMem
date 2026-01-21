import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentAnalyzerTest {

    // ===================== TEST countExcellentStudents =====================

    @Test
    public void testCountExcellentStudents_normal_mixedValidInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_allValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(8.0, 8.1, 9.5, 7.9, 10.0);
        assertEquals(4, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_emptyList_boundary() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_boundary_only0and10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(0.0, 10.0, 10.0, 0.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_exceptionLike_invalidScoresOnly() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-5.0, 11.0, 100.0, -1.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    // ===================== TEST calculateValidAverage =====================

    @Test
    public void testCalculateValidAverage_normal_mixedValidInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        // valid: 9.0, 8.5, 7.0 => avg = 24.5/3 = 8.1666...
        assertEquals(8.17, analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)), 0.01);
    }

    @Test
    public void testCalculateValidAverage_allValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        // avg = (6 + 7 + 8 + 9)/4 = 7.5
        assertEquals(7.5, analyzer.calculateValidAverage(Arrays.asList(6.0, 7.0, 8.0, 9.0)), 1e-9);
    }

    @Test
    public void testCalculateValidAverage_emptyList_boundary() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 1e-9);
    }

    @Test
    public void testCalculateValidAverage_boundary_only0and10() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        // avg = (0 + 10)/2 = 5
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)), 1e-9);
    }

    @Test
    public void testCalculateValidAverage_exceptionLike_allInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        // không có điểm hợp lệ => return 0.0
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(-1.0, 11.0, 999.0)), 1e-9);
    }
}
