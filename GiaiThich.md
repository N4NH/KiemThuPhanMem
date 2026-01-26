# Phân Tích Các Phương Thức Kiểm Thử Trong Dự Án

Dựa trên việc phân tích toàn bộ mã nguồn hiện tại, dưới đây là báo cáo chi tiết về các phương thức kiểm thử (testing methods) đang được áp dụng trong dự án.

### Tổng quan
Dự án áp dụng mô hình **Tháp kiểm thử (Testing Pyramid)** hoặc đa tầng, bao gồm 3 cấp độ chính:
1.  **Unit Testing (Kiểm thử đơn vị)**: Kiểm tra logic code nhỏ lẻ.
2.  **E2E Testing (Kiểm thử đầu cuối)**: Kiểm tra luồng đi của người dùng trên giao diện web.
3.  **Performance Testing (Kiểm thử hiệu năng)**: Kiểm tra khả năng chịu tải của hệ thống.

---

## 1. Unit Testing (Kiểm thử đơn vị)
Đây là tầng kiểm thử cơ bản nhất, tập trung vào việc kiểm chứng tính đúng đắn của từng hàm hoặc phương thức riêng lẻ.

*   **Vị trí mã nguồn**: Thư mục `unit-test`.
*   **Công cụ sử dụng**: **JUnit 5** (Java).
*   **Đối tượng kiểm thử**: Class `StudentAnalyzer.java`.
*   **Chi tiết kỹ thuật**:
    *   Hệ thống đang thực hiện kiểm thử các hàm tính toán logic nghiệp vụ:
        *   `countExcellentStudents(List<Double> scores)`: Đếm số lượng học sinh giỏi.
        *   `calculateValidAverage(List<Double> scores)`: Tính điểm trung bình hợp lệ (loại bỏ điểm sai).
    *   **Kỹ thuật thiết kế Test Case**: Code trong `StudentAnalyzerTest.java` cho thấy việc áp dụng bài bản các kỹ thuật kiểm thử hộp đen:
        *   **Phân vùng tương đương (Equivalence Partitioning)**: Chia dữ liệu thành các nhóm hợp lệ (điểm 0-10) và không hợp lệ (điểm âm, điểm >10) để kiểm tra cách xử lý của hàm.
            *   *Ví dụ*: `testCountExcellentStudents_allValid` (toàn bộ hợp lệ), `testCalculateValidAverage_exceptionLike_allInvalid` (toàn bộ không hợp lệ).
        *   **Phân tích giá trị biên (Boundary Value Analysis)**: Tập trung kiểm thử tại các điểm cực hạn nơi lỗi thường hay xảy ra (ví dụ: điểm 0, điểm 10, danh sách rỗng).
            *   *Ví dụ*: `testCountExcellentStudents_boundary_only0and10` (biên 0 và 10), `testCountExcellentStudents_emptyList_boundary` (danh sách rỗng).
    *   **Mục đích**: Đảm bảo logic cốt lõi của việc tính toán điểm số hoạt động chính xác tuyệt đối, không phụ thuộc vào giao diện hay cơ sở dữ liệu.

## 2. End-to-End (E2E) Testing (Kiểm thử đầu cuối)
Đây là tầng kiểm thử ở mức cao nhất, giả lập hành vi của người dùng thật thao tác trên trình duyệt web.

*   **Vị trí mã nguồn**: Thư mục `BaiChuong3/e2e-cypress`.
*   **Công cụ sử dụng**: **Cypress** (Javascript).
*   **Đối tượng kiểm thử**: Giao diện người dùng (UI) và các luồng nghiệp vụ (Business Flows).
*   **Chi tiết**:
    *   Trong thư mục `cypress/e2e`, các kịch bản test (Test Specs) bao gồm:
        *   `login_spec.cy.js`: Kiểm thử tính năng **Đăng nhập**. Đảm bảo người dùng nhập đúng tài khoản sẽ vào được hệ thống, nhập sai sẽ báo lỗi.
        *   `cart_spec.cy.js`: Kiểm thử tính năng **Giỏ hàng**. Đảm bảo luồng thêm sản phẩm, cập nhật số lượng diễn ra đúng như mong đợi.
    *   **Mục đích**: Đảm bảo hệ thống hoạt động trơn tru dưới góc nhìn của người dùng cuối. Nó kiểm tra sự tích hợp giữa giao diện (Front-end) và có thể cả Back-end phía sau.

## 3. Performance Testing (Kiểm thử hiệu năng)
Đây là tầng kiểm thử phi chức năng (Non-functional testing), không kiểm tra xem tính năng đúng hay sai, mà kiểm tra xem hệ thống "khỏe" hay "yếu".

*   **Vị trí mã nguồn**: Thư mục `BaiChuong4/jmeter`.
*   **Công cụ sử dụng**: **Apache JMeter**.
*   **Đối tượng kiểm thử**: Các API endpoint hoặc Web Server.
*   **Chi tiết**:
    *   `test_plan.jmx`: File chứa kịch bản test (Test Plan). File này định nghĩa số lượng người dùng giả lập (Users/Threads), thời gian gửi yêu cầu (Ramp-up period), và các HTTP Request cần test.
    *   `jmeter.log` và `results.csv`: Các file lưu trữ kết quả chạy test thực tế, dùng để phân tích thời gian phản hồi (Response Time) và tỉ lệ lỗi (Error Rate).
    *   **Mục đích**: Thực hiện **Load Testing** (Kiểm thử chịu tải) hoặc **Stress Testing** (Kiểm thử chịu tải ở mức cực hạn) để đảm bảo hệ thống không bị chậm, treo, hoặc sập khi có nhiều người dùng truy cập cùng lúc.

---

### Tổng kết kiến trúc kiểm thử

| Tầng kiểm thử | Loại kiểm thử | Công cụ | Mục tiêu chính | File mã nguồn tiêu biểu |
| :--- | :--- | :--- | :--- | :--- |
| **Unit** | Chức năng (Functional) | JUnit 5 | Logic xử lý dữ liệu (Hàm tính điểm) | `StudentAnalyzerTest.java` |
| **E2E** | Chức năng (Functional) | Cypress | Luồng người dùng & Giao diện (Login, Cart) | `login_spec.cy.js` |
| **System** | Phi chức năng (Non-functional) | JMeter | Hiệu năng, Độ chịu tải, Thời gian phản hồi | `test_plan.jmx` |

Dự án hiện tại có độ bao phủ kiểm thử (Test Coverage) khá toàn diện, bao gồm cả chiều sâu (Unit Test cho logic) và chiều rộng (E2E cho UI), đồng thời quan tâm đến chất lượng vận hành (Performance Test).
