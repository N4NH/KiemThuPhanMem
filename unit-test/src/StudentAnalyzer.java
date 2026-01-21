import java.util.List;

public class StudentAnalyzer {

    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     * - Bỏ qua điểm âm hoặc lớn hơn 10 (coi là dữ liệu sai)
     * - Nếu danh sách rỗng, trả về 0
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) return 0;

        int count = 0;

        // Vòng lặp 1: duyệt để lọc học sinh giỏi
        for (Double s : scores) {
            if (s == null) continue;          // bỏ qua null nếu có
            if (s < 0 || s > 10) continue;    // validate: bỏ điểm sai
            if (s >= 8.0) count++;
        }
        return count;
    }

    /**
     * Tính điểm trung bình hợp lệ (từ 0 đến 10)
     * @param scores danh sách điểm
     * @return điểm trung bình của các điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) return 0.0;

        double sum = 0.0;
        int validCount = 0;

        // Vòng lặp 2: duyệt để tính trung bình hợp lệ
        for (Double s : scores) {
            if (s == null) continue;
            if (s < 0 || s > 10) continue;
            sum += s;
            validCount++;
        }

        if (validCount == 0) return 0.0;
        return sum / validCount;
    }
}
