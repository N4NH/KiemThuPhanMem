# BÁO CÁO LỖI (BUG REPORTS)
**Tổng số Bug:** 10 (2 Critical, 4 Major, 4 Minor)

## Danh sách lỗi chi tiết

| Bug ID | Tóm tắt (Summary) | Severity | Priority | Trạng thái |
| :--- | :--- | :--- | :--- | :--- |
| **BUG_CART_001** | Tổng tiền giỏ hàng tính sai khi mua > 10 sản phẩm | **Critical** | High | Open |
| **BUG_CHECKOUT_002** | Hệ thống crash (màn hình trắng) khi chọn thanh toán Visa | **Critical** | High | Open |
| **BUG_AUTH_003** | Không nhận được email reset mật khẩu | Major | High | Open |
| **BUG_PROD_004** | Bộ lọc giá không hoạt động với mức giá > 1 triệu đồng | Major | Medium | Fixed |
| **BUG_CART_005** | Nút "Xóa sản phẩm" không phản hồi trên trình duyệt Firefox | Major | Medium | Open |
| **BUG_CHECKOUT_006** | Không lưu được địa chỉ giao hàng mới tạo | Major | High | Open |
| **BUG_UI_007** | Sai chính tả tiêu đề trang chủ "Wellcome" | Minor | Low | Fixed |
| **BUG_UI_008** | Nút "Login" bị lệch pixel trên màn hình mobile | Minor | Low | Open |
| **BUG_PROD_009** | Hình ảnh sản phẩm load chậm (>5s) | Minor | Low | Open |
| **BUG_AUTH_010** | Thông báo lỗi sai định dạng hiển thị màu xanh thay vì đỏ | Minor | Low | Open |

---

## Chi tiết lỗi điển hình (Sample)

### 1. BUG_CART_001
- **Tóm tắt:** Tổng tiền giỏ hàng tính sai khi mua > 10 sản phẩm cùng loại.
- **Môi trường:** Chrome 120, Windows 11.
- **Các bước tái hiện:**
    1. Login vào hệ thống.
    2. Chọn sản phẩm A (giá 100k).
    3. Thêm vào giỏ.
    4. Vào giỏ hàng, cập nhật số lượng lên 11.
- **Kết quả mong đợi:** Tổng tiền = 1.100.000đ.
- **Kết quả thực tế:** Tổng tiền = 1.000.000đ (Dường như chỉ tính 10 item).
- **Severity:** Critical.
- **Priority:** High.

### 2. BUG_CHECKOUT_002
- **Tóm tắt:** Hệ thống crash khi chọn thanh toán Visa.
- **Môi trường:** Chrome 120, Windows 11.
- **Các bước tái hiện:**
    1. Thêm sản phẩm vào giỏ.
    2. Proceed to Checkout.
    3. Chọn Method "Visa Card".
- **Kết quả mong đợi:** Hiển thị form nhập thông tin thẻ.
- **Kết quả thực tế:** Trang web trắng trơn (Blank page), console báo lỗi 500 Internal Server Error.
- **Severity:** Critical.
- **Priority:** High.
