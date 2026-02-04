# BÁO CÁO KIỂM THỬ (TEST REPORT)

**Dự án:** E-commerce Website
**Ngày báo cáo:** 04/02/2026
**Người báo cáo:** QA Team

## 1. Tóm tắt kết quả (Summary)
Đợt kiểm thử tập trung vào các chức năng cốt lõi: Auth, Cart, Checkout.
- **Tổng số Test Cases:** 45
- **Số Pass:** 35 (77.8%)
- **Số Fail:** 10 (22.2%)
- **Số Blocked:** 0

## 2. Chi tiết theo Module
| Module | Total TC | Pass | Fail | Tỷ lệ Pass |
| :--- | :--- | :--- | :--- | :--- |
| Authentication | 15 | 13 | 2 | 86.6% |
| Product & Cart | 20 | 16 | 4 | 80% |
| Checkout | 10 | 6 | 4 | 60% |
| **Tổng cộng** | **45** | **35** | **10** | **77.8%** |

## 3. Top lỗi nghiêm trọng (Top Critical/Major Bugs)
1. **[Critical]** BUG_CHECKOUT_002: Crash khi chọn thanh toán Visa - Cần fix gấp.
2. **[Critical]** BUG_CART_001: Sai logic tính tiền khi số lượng lớn - Ảnh hưởng doanh thu.
3. **[Major]** BUG_CHECKOUT_006: Không lưu được địa chỉ giao hàng - Chặn luồng mua hàng.

## 4. Nhận xét chất lượng (Quality Assessment)
- **Chức năng:** Các luồng cơ bản (Happy path) của Auth và Product ổn định. Tuy nhiên, phần Checkout và tính toán Cart đang gặp lỗi nghiêm trọng ảnh hưởng trực tiếp đến quy trình mua bán.
- **Giao diện:** Ổn, chỉ còn vài lỗi nhỏ (Minor).
- **Độ ổn định:** Cần cải thiện, lỗi 500 xảy ra tại trang Checkout.

## 5. Quyết định (Release Decision)
⛔ **NO-RELEASE (KHÔNG PHÁT HÀNH)**

**Lý do:**
- Tồn tại 2 lỗi Critical ảnh hưởng trực tiếp đến tính năng thanh toán và tính tiền.
- Tỷ lệ Pass module Checkout quá thấp (60%).
- Cần fix xong các lỗi Critical và Major, sau đó chạy Regression Test lại trước khi xem xét release.
