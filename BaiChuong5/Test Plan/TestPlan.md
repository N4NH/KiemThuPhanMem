# KẾ HOẠCH KIỂM THỬ (TEST PLAN)
**Dự án:** Hệ thống Website bán hàng Online (E-commerce)

## 1. Giới thiệu (Introduction)
Tài liệu này mô tả kế hoạch kiểm thử cho hệ thống Website bán hàng Online. Mục đích là để xác định phạm vi, phương pháp, nguồn lực và lịch trình cho các hoạt động kiểm thử nhằm đảm bảo chất lượng phần mềm trước khi phát hành.

## 2. Phạm vi kiểm thử (Scope)
### 2.1 Trong phạm vi (In-scope)
Kiểm thử chức năng (Functional Testing) và giao diện (UI Testing) cho các module sau:
- **Module 1 - Xác thực (Authentication):** Đăng ký, Đăng nhập, Quên mật khẩu, Đăng xuất.
- **Module 2 - Sản phẩm & Giỏ hàng (Product & Cart):** Tìm kiếm, Lọc, Xem chi tiết, Thêm vào giỏ, Cập nhật số lượng, Xoá sản phẩm.
- **Module 3 - Thanh toán (Checkout):** Nhập địa chỉ, Phương thức thanh toán, Đặt hàng, Lịch sử đơn hàng.

### 2.2 Ngoài phạm vi (Out-of-scope)
- Kiểm thử hiệu năng (Performance Testing).
- Kiểm thử tự động (Automation Testing).
- Kiểm thử bảo mật chuyên sâu (Security Penetration Testing).
- Tích hợp cổng thanh toán thực tế (Chỉ dùng giả lập).

## 3. Phương pháp kiểm thử (Test Approach)
- **Kiểm thử chức năng (Functional testing):** Xác minh các chức năng hoạt động đúng theo yêu cầu (Requirement).
- **Kiểm thử giao diện (UI testing – basic):** Đảm bảo giao diện hiển thị đúng trên trình duyệt mục tiêu.
- **Kiểm thử hồi quy (Regression – smoke):** Chạy lại các test case chính sau khi có bản vá lỗi để đảm bảo không phát sinh lỗi mới.

## 4. Môi trường kiểm thử (Test Environment)
- **Phần cứng:** PC/Laptop cá nhân.
- **Hệ điều hành:** Windows 10/11.
- **Trình duyệt:** Google Chrome (phiên bản mới nhất).
- **Dữ liệu test:** Sử dụng dữ liệu giả lập (Mock data) cho sản phẩm và tài khoản người dùng test.

## 5. Điều kiện vào / ra (Entry / Exit Criteria)
### Entry Criteria (Điều kiện bắt đầu):
- Các module đã được code xong và deploy lên môi trường test.
- Tài liệu yêu cầu (Requirement) đã được phê duyệt.
- Test Plan và Test Cases đã sẵn sàng.

### Exit Criteria (Điều kiện kết thúc):
- 100% Test case trọng yếu (Critical) đã được thực thi.
- Tỷ lệ Pass đạt trên 90%.
- Không còn lỗi nghiêm trọng (Critical/High Severity) mở.
- Test Report được hoàn thành và gửi đi.

## 6. Rủi ro & biện pháp giảm thiểu (Risks & Mitigation)
| Rủi ro | Mức độ | Biện pháp giảm thiểu |
| :--- | :--- | :--- |
| Thiếu hụt thời gian kiểm thử | Cao | Ưu tiên kiểm thử các luồng chính (Happy path) và module quan trọng trước. |
| Yêu cầu thay đổi thường xuyên | Trung bình | Cập nhật RTM và Test Case kịp thời, giao tiếp chặt chẽ với Dev. |
| Môi trường test không ổn định | Thấp | Báo cáo ngay cho Dev/SysAdmin khi gặp sự cố, sử dụng môi trường local nếu cần. |

## 7. Vai trò & trách nhiệm (Roles & Responsibilities)
- **QA Manager:** Phê duyệt Test Plan, giám sát tiến độ.
- **QA Tester:** Viết Test case, thực thi test, báo cáo lỗi (Bug), viết Test Report.
- **Developer:** Fix bug và hỗ trợ môi trường.

## 8. Lịch trình kiểm thử (Test Schedule – Giả lập)
- **Ngày 1:** Viết Test Plan & Test Cases.
- **Ngày 2:** Review Test Cases & Chuẩn bị môi trường.
- **Ngày 3-4:** Thực thi kiểm thử (Execution) vòng 1.
- **Ngày 5:** Retest & Regression Test.
- **Ngày 6:** Tổng hợp Test Report & Submit.
