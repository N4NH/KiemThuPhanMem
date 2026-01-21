import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RunTestsManually {

    public static void main(String[] args) {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int passed = 0;
        int failed = 0;

        System.out.println("Running manual tests...");

        // ===================== TEST countExcellentStudents =====================

        // Test 1: Mixed valid/invalid
        if (testCountExcellentStudents(analyzer, Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0), 2,
                "testCountExcellentStudents_normal_mixedValidInvalid"))
            passed++;
        else
            failed++;

        // Test 2: All valid
        if (testCountExcellentStudents(analyzer, Arrays.asList(8.0, 8.1, 9.5, 7.9, 10.0), 4,
                "testCountExcellentStudents_allValid"))
            passed++;
        else
            failed++;

        // Test 3: Empty list
        if (testCountExcellentStudents(analyzer, Collections.emptyList(), 0,
                "testCountExcellentStudents_emptyList_boundary"))
            passed++;
        else
            failed++;

        // Test 4: Boundary 0 and 10
        if (testCountExcellentStudents(analyzer, Arrays.asList(0.0, 10.0, 10.0, 0.0), 2,
                "testCountExcellentStudents_boundary_only0and10"))
            passed++;
        else
            failed++;

        // Test 5: Invalid scores only
        if (testCountExcellentStudents(analyzer, Arrays.asList(-5.0, 11.0, 100.0, -1.0), 0,
                "testCountExcellentStudents_exceptionLike_invalidScoresOnly"))
            passed++;
        else
            failed++;

        // ===================== TEST calculateValidAverage =====================

        // Test 6: Mixed valid/invalid (9.0, 8.5, 7.0) => 24.5 / 3 = 8.1666...
        if (testCalculateValidAverage(analyzer, Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0), 8.1666666667, 0.01,
                "testCalculateValidAverage_normal_mixedValidInvalid"))
            passed++;
        else
            failed++;

        // Test 7: All valid (6, 7, 8, 9) => 30 / 4 = 7.5
        if (testCalculateValidAverage(analyzer, Arrays.asList(6.0, 7.0, 8.0, 9.0), 7.5, 1e-9,
                "testCalculateValidAverage_allValid"))
            passed++;
        else
            failed++;

        // Test 8: Empty list
        if (testCalculateValidAverage(analyzer, Collections.emptyList(), 0.0, 1e-9,
                "testCalculateValidAverage_emptyList_boundary"))
            passed++;
        else
            failed++;

        // Test 9: Boundary 0 and 10 => (0+10)/2 = 5.0
        if (testCalculateValidAverage(analyzer, Arrays.asList(0.0, 10.0), 5.0, 1e-9,
                "testCalculateValidAverage_boundary_only0and10"))
            passed++;
        else
            failed++;

        // Test 10: All invalid => 0.0
        if (testCalculateValidAverage(analyzer, Arrays.asList(-1.0, 11.0, 999.0), 0.0, 1e-9,
                "testCalculateValidAverage_exceptionLike_allInvalid"))
            passed++;
        else
            failed++;

        System.out.println("--------------------------------------------------");
        System.out.println("Tests passed: " + passed);
        System.out.println("Tests failed: " + failed);

        if (failed > 0) {
            System.out.println("FAILURE detected.");
            System.exit(1);
        } else {
            System.out.println("SUCCESS. All tests passed.");
        }
    }

    private static boolean testCountExcellentStudents(StudentAnalyzer analyzer, List<Double> scores, int expected,
            String testName) {
        int actual = analyzer.countExcellentStudents(scores);
        if (actual == expected) {
            System.out.println("[PASS] " + testName);
            return true;
        } else {
            System.out.println("[FAIL] " + testName + " | Expected: " + expected + ", Got: " + actual);
            return false;
        }
    }

    private static boolean testCalculateValidAverage(StudentAnalyzer analyzer, List<Double> scores, double expected,
            double delta, String testName) {
        double actual = analyzer.calculateValidAverage(scores);
        if (Math.abs(actual - expected) <= delta) {
            System.out.println("[PASS] " + testName);
            return true;
        } else {
            System.out.println("[FAIL] " + testName + " | Expected: " + expected + ", Got: " + actual);
            return false;
        }
    }
}
