# CHỈ SỐ KIỂM THỬ (TEST METRICS)

## 1. Tỷ lệ thực thi (Test Execution Rate)
Đo lường tiến độ thực hiện test.
- Công thức: `(Số TC đã chạy / Tổng số TC) * 100%`
- Tính toán: `(45 / 45) * 100%`
- **Kết quả: 100%** (Đã hoàn thành chạy toàn bộ test)

## 2. Tỷ lệ Pass/Fail (Pass/Fail Rate)
- Pass Rate: `(35 / 45) * 100%` = **77.8%**
- Fail Rate: `(10 / 45) * 100%` = **22.2%**

## 3. Mật độ lỗi theo Module (Defect Density)
Đo lường số lượng bug tìm thấy trên mỗi module.

| Module | Số Bug | Tỷ trọng |
| :--- | :--- | :--- |
| Auth | 2 | 20% |
| Product & Cart | 4 | 40% |
| Checkout | 4 | 40% |
=> **Nhận xét:** Module Checkout và Cart đang chứa nhiều lỗi nhất, cần tập trung fix và re-test kỹ areas này.

## 4. Phân bố mức độ nghiêm trọng (Severity Distribution)
Đánh giá mức độ ảnh hưởng của lỗi.
- **Critical:** 2 (20%)
- **Major:** 4 (40%)
- **Minor:** 4 (40%)
=> **Chỉ số Sức khỏe:** Xấu. Tỷ lệ Critical + Major chiếm 60% tổng số lỗi.

## 5. Độ bao phủ yêu cầu (Requirement Coverage)
- Tổng yêu cầu (Reqs): 16
- Số yêu cầu đã có Test Case: 16
- **Coverage: 100%**
