# Unit Test - StudentAnalyzer (Java + JUnit 5)

## Mô tả bài toán
Viết lớp `StudentAnalyzer` gồm 2 phương thức:

1) `countExcellentStudents(List<Double> scores)`
- Đếm số học sinh loại Giỏi (điểm >= 8.0)
- Bỏ qua điểm không hợp lệ (điểm < 0 hoặc > 10)
- Nếu danh sách rỗng thì trả về 0

2) `calculateValidAverage(List<Double> scores)`
- Tính điểm trung bình của các điểm hợp lệ (0..10)
- Bỏ qua điểm không hợp lệ (điểm < 0 hoặc > 10)
- Nếu danh sách rỗng hoặc không có điểm hợp lệ thì trả về 0.0

## Cấu trúc thư mục
