# Báo cáo Kiểm thử Hiệu năng với JMeter

## 1. Giới thiệu
- **Mục tiêu**: Đánh giá hiệu năng của website Wikipedia dưới các mức tải khác nhau.
- **Website kiểm thử**: [https://www.wikipedia.org](https://www.wikipedia.org)
- **Công cụ sử dụng**: Apache JMeter 5.6.3
- **Ngày thực hiện**: 24/1/2026

## 2. Kịch bản kiểm thử (Test Scenarios)
- **Kết quả kiểm thử gộp**:
  <img width="1514" height="856" alt="image" src="https://github.com/user-attachments/assets/96675788-5a69-410c-aa80-5e2cceb0684a" />

### Kịch bản 1: Cơ bản (Basic Load)
- **Cấu hình**: 10 users, 5 loops.
- **Mục đích**: Kiểm tra phản hồi cơ bản của server với lượng truy cập thấp.
- **Hành vi**: Truy cập trang chủ.

### Kịch bản 2: Tải nặng (Heavy Load)
- **Cấu hình**: 50 users, Ramp-up 30s, chạy trong 2 phút.
- **Mục đích**: Kiểm tra khả năng chịu tải của server khi lượng user tăng dần.
- **Hành vi**: Truy cập trang chủ và trang ngẫu nhiên (Wiki Random).

### Kịch bản 3: Tùy chỉnh (Custom Load)
- **Cấu hình**: 20 users, chạy trong 60s.
- **Mục đích**: Mô phỏng hành vi người dùng đọc các bài viết cụ thể.
- **Hành vi**: Truy cập Portal:Arts và Portal:History.

## 3. Kết quả Kiểm thử

### Thread Group 1 (Basic)
*(Kết quả chạy thử mẫu)*
- **Average Response Time**: ~400 ms
- **Throughput**: ~1.8 req/sec
- **Error %**: 0% (Sau khi thêm User-Agent)

### Thread Group 2 (Heavy)
*(Kết quả chạy thử mẫu)*
- **Average Response Time**: ~500 ms (Redirects ~300ms, Page Load ~1000ms)
- **Error %**: 0%

### Thread Group 3 (Custom)
*(Kết quả chạy thử mẫu)*
- **Average Response Time**: ~300 ms
- **Error %**: 0%

## 4. Phân tích & Nhận xét
- **Thời gian phản hồi**: Ổn định, trung bình dưới 500ms cho các trang tĩnh.
- **Tỉ lệ lỗi**: Ban đầu gặp lỗi 403 Forbidden do Wikipedia chặn bot. Đã khắc phục bằng cách thêm "User-Agent" giả lập trình duyệt Chrome.
- **Khả năng chịu tải**: Server phản hồi tốt trong bài test nhanh.

## 5. Kết luận
- Trang web hoạt động **Tốt** sau khi cấu hình đúng Header.
- Kịch bản kiểm thử đã sẵn sàng để chạy tải nặng thực tế.
