# CA KIỂM THỬ (TEST CASES)

## Tổng quan
- **Tổng số:** 45 Test Cases
- **Phân bổ:** Auth (15), Product/Cart (20), Checkout (10)

## Module 1: Xác thực (Authentication) - 15 Cases

| TC ID | Tiêu đề (Title) | Điều kiện trước (Precondition) | Các bước (Steps) | Kết quả mong đợi (Expected Result) | Độ ưu tiên | Loại Test |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| TC_AUTH_001 | Đăng ký thành công với email hợp lệ | Chưa đăng nhập | 1. Vào trang Đăng ký <br> 2. Nhập email mới, pass hợp lệ <br> 3. Bấm Đăng ký | Đăng ký thành công, chuyển hướng Login | High | Positive |
| TC_AUTH_002 | Đăng ký thất bại khi email sai định dạng | - | 1. Nhập email "user.com" (thiếu @) <br> 2. Bấm Đăng ký | Báo lỗi định dạng email không hợp lệ | High | Negative |
| TC_AUTH_003 | Đăng ký thất bại khi email đã tồn tại | Email "test@mail.com" đã có | 1. Nhập email "test@mail.com" <br> 2. Bấm Đăng ký | Báo lỗi email đã được sử dụng | Medium | Negative |
| TC_AUTH_004 | Đăng ký thất bại khi password < 8 ký tự | - | 1. Nhập pass "1234567" <br> 2. Bấm Đăng ký | Báo lỗi password quá ngắn | High | Boundary |
| TC_AUTH_005 | Đăng ký thất bại khi để trống trường bắt buộc | - | 1. Để trống Email hoặc Pass <br> 2. Bấm Đăng ký | Hiển thị thông báo yêu cầu nhập trường bắt buộc | Medium | Negative |
| TC_AUTH_006 | Đăng nhập thành công với thông tin đúng | User đã active | 1. Nhập email, pass đúng <br> 2. Bấm Login | Login thành công, vào trang chủ | High | Positive |
| TC_AUTH_007 | Đăng nhập thất bại sai mật khẩu | - | 1. Nhập email đúng, bao sai <br> 2. Bấm Login | Báo lỗi sai thông tin đăng nhập | High | Negative |
| TC_AUTH_008 | Đăng nhập thất bại email không tồn tại | - | 1. Nhập email chưa đăng ký <br> 2. Bấm Login | Báo lỗi sai thông tin đăng nhập | High | Negative |
| TC_AUTH_009 | Check SQL Injection trường Email | - | 1. Nhập email `' OR 1=1 --` <br> 2. Bấm Login | Hệ thống từ chối, không bị bypass | High | Security |
| TC_AUTH_010 | Đăng nhập với phím Enter | - | 1. Nhập thông tin <br> 2. Nhấn Enter | Thực hiện đăng nhập như bấm nút | Low | UI/UX |
| TC_AUTH_011 | Gửi email quên mật khẩu thành công | Email đã tồn tại | 1. Bấm Quên mật khẩu <br> 2. Nhập email đúng <br> 3. Gửi | Thông báo đã gửi email reset | Medium | Positive |
| TC_AUTH_012 | Quên mật khẩu với email không tồn tại | - | 1. Nhập email chưa có trong DB <br> 2. Gửi | Báo lỗi email không tìm thấy | Medium | Negative |
| TC_AUTH_013 | Quên mật khẩu với email sai định dạng | - | 1. Nhập email sai format <br> 2. Gửi | Báo lỗi định dạng | Low | Validation |
| TC_AUTH_014 | Đăng xuất hệ thống | Đang đăng nhập | 1. Bấm icon User <br> 2. Chọn Đăng xuất | Thoát tài khoản, về trang Login/Home | High | Positive |
| TC_AUTH_015 | Truy cập trang Profile khi chưa login | Chưa đăng nhập | 1. Paste URL trang Profile vào trình duyệt | Chặn truy cập, redirect về Login | High | Security |

## Module 2: Sản phẩm & Giỏ hàng (Product & Cart) - 20 Cases

| TC ID | Tiêu đề (Title) | Điều kiện trước (Precondition) | Các bước (Steps) | Kết quả mong đợi (Expected Result) | Độ ưu tiên | Loại Test |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| TC_PROD_001 | Tìm kiếm sản phẩm có kết quả | - | 1. Nhập "Shirt" vào ô tìm kiếm <br> 2. Enter | Hiển thị list sản phẩm chứa từ khóa | High | Positive |
| TC_PROD_002 | Tìm kiếm không có kết quả | - | 1. Nhập từ khóa vô nghĩa "xyzk123" | Hiển thị "Không tìm thấy sản phẩm" | Medium | Negative |
| TC_PROD_003 | Tìm kiếm với ký tự đặc biệt | - | 1. Nhập "@#$%" | Xử lý an toàn, không lỗi hệ thống | Low | Security |
| TC_PROD_004 | Lọc sản phẩm theo khoảng giá đúng | - | 1. Chọn giá 100k - 500k | Chỉ hiện sp trong khoảng giá | High | Positive |
| TC_PROD_005 | Lọc sản phẩm theo danh mục | - | 1. Chọn danh mục "Giày dép" | Chỉ hiện sp thuộc danh mục Giày dép | High | Positive |
| TC_PROD_006 | Xem chi tiết sản phẩm | - | 1. Click vào hình sản phẩm A | Chuyển đến trang chi tiết SP A | High | Positive |
| TC_PROD_007 | Kiểm tra thông tin chi tiết | - | 1. Tại trang chi tiết | Tên, giá, mô tả hiển thị đúng DB | Medium | UI |
| TC_CART_001 | Thêm sản phẩm vào giỏ hàng | SP còn hàng | 1. Bấm "Thêm vào giỏ" | Thông báo thành công, icon giỏ hàng +1 | High | Positive |
| TC_CART_002 | Thêm sản phẩm hết hàng (Out of stock) | SP hết hàng | 1. Bấm "Thêm vào giỏ" | Button disable hoặc báo hết hàng | High | Negative |
| TC_CART_003 | Thêm quá số lượng tồn kho | Kho còn 5 | 1. Nhập số lượng 6 <br> 2. Thêm | Báo lỗi không đủ hàng | Medium | Boundary |
| TC_CART_004 | Cập nhật tăng số lượng trong giỏ | Giỏ có SP A | 1. Tại giỏ, bấm nút (+) | Số lượng tăng, tổng tiền tăng tương ứng | High | Positive |
| TC_CART_005 | Cập nhật giảm số lượng trong giỏ | Giỏ có SP A (qty=2) | 1. Tại giỏ, bấm nút (-) | Số lượng giảm, tổng tiền giảm | High | Positive |
| TC_CART_006 | Nhập số lượng bằng 0 | - | 1. Nhập '0' vào ô số lượng | Hỏi xác nhận xóa SP hoặc tự xóa | Medium | Boundary |
| TC_CART_007 | Nhập số lượng âm | - | 1. Nhập '-1' vào ô số lượng | Báo lỗi hoặc tự reset về 1 | Medium | Negative |
| TC_CART_008 | Nhập ký tự chữ vào ô số lượng | - | 1. Nhập 'abc' vào ô sl | Không cho nhập hoặc báo lỗi | Low | Validation |
| TC_CART_009 | Nhập số lượng cực lớn | - | 1. Nhập '999999' | Báo lỗi quá giới hạn kho | Low | Boundary |
| TC_CART_010 | Xóa 1 sản phẩm khỏi giỏ | - | 1. Bấm icon Xóa SP A | SP A biến mất, tổng tiền update | High | Positive |
| TC_CART_011 | Xóa toàn bộ giỏ hàng | Giỏ có nhiều SP | 1. Bấm "Xóa hết" (nếu có) | Giỏ hàng trống rỗng | Medium | Positive |
| TC_CART_012 | Kiểm tra tổng tiền (Subtotal) | - | 1. Thêm 2 SP giá 100k và 200k | Tổng hiển thị 300k | High | Functional |
| TC_CART_013 | Lưu giỏ hàng sau khi logout | Đã login, có hàng | 1. Logout <br> 2. Login lại | Giỏ hàng vẫn còn nguyên | Medium | Functional |

## Module 3: Thanh toán (Checkout) - 10 Cases

| TC ID | Tiêu đề (Title) | Điều kiện trước (Precondition) | Các bước (Steps) | Kết quả mong đợi (Expected Result) | Độ ưu tiên | Loại Test |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| TC_CHECKOUT_001 | Thanh toán COD thành công | Giỏ có hàng | 1. Checkout <br> 2. Nhập địa chỉ <br> 3. Chọn COD <br> 4. Đặt hàng | Thông báo thành công, tạo Mã đơn hàng | High | Positive |
| TC_CHECKOUT_002 | Thanh toán Visa thành công (Giả lập) | Giỏ có hàng | 1. Chọn Visa <br> 2. Nhập thẻ test valid <br> 3. Đặt hàng | Thành công, trừ tiền (giả lập) | High | Positive |
| TC_CHECKOUT_003 | Bỏ trống địa chỉ giao hàng | - | 1. Xóa địa chỉ <br> 2. Bấm Đặt hàng | Báo lỗi bắt buộc nhập địa chỉ | High | Negative |
| TC_CHECKOUT_004 | Nhập số thẻ Visa không hợp lệ | - | 1. Nhập thẻ sai cấu trúc <br> 2. Đặt hàng | Báo lỗi thẻ không hợp lệ | Medium | Negative |
| TC_CHECKOUT_005 | Nhập thẻ hết hạn | - | 1. Nhập thẻ date quá khứ <br> 2. Đặt hàng | Báo lỗi thẻ hết hạn | Medium | Negative |
| TC_CHECKOUT_006 | Nhập sai mã CVV | - | 1. Nhập CVV sai <br> 2. Đặt hàng | Giao dịch thất bại | Medium | Negative |
| TC_CHECKOUT_007 | Xem lịch sử đơn hàng | Đã có đơn hàng | 1. Vào Lịch sử đơn hàng | Hiển thị list đơn vừa đặt | Medium | Positive |
| TC_CHECKOUT_008 | Kiểm tra trạng thái đơn hàng mới | Mới đặt hàng | 1. Xem chi tiết đơn mới | Trạng thái là "Pending" / "Processing" | Low | Functional |
| TC_CHECKOUT_009 | Giỏ hàng trống sau khi đặt hàng | Vừa đặt xong | 1. Quay lại trang giỏ hàng | Giỏ hàng trống | Medium | Functional |
| TC_CHECKOUT_010 | Hủy đơn hàng (nếu có chức năng) | Đơn trạng thái Pending | 1. Bấm Hủy đơn | Trạng thái chuyển thành "Cancelled" | Low | Positive |
