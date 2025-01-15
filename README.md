# Thực hiện Kiểm thử Tự động với Selenium
## Kịch bản kiểm thử 
### 1. Kiểm thử đăng nhập với thông tin hợp lệ
Mục tiêu: Xác minh rằng người dùng có thể đăng nhập thành công với thông tin hợp lệ.
Bước thực hiện:

Mở trình duyệt Chrome.
Truy cập vào trang https://www.saucedemo.com/.
Nhập tên đăng nhập: "standard_user".
Nhập mật khẩu: "secret_sauce".
Nhấn nút đăng nhập.
Kiểm tra xem người dùng đã đăng nhập thành công chưa.
Kết quả mong đợi:

Người dùng được chuyển hướng đến trang danh sách sản phẩm.
Không xuất hiện thông báo lỗi.
### 2. Kiểm thử đăng nhập với thông tin không hợp lệ
Mục tiêu: Đảm bảo rằng hệ thống hiển thị thông báo lỗi khi người dùng nhập sai thông tin đăng nhập.
Bước thực hiện:

Mở trình duyệt Chrome.
Truy cập vào trang https://www.saucedemo.com/.
Nhập tên đăng nhập: "locked_out_user".
Nhập mật khẩu: "secret_sauce".
Nhấn nút đăng nhập.
Kiểm tra xem thông báo lỗi có hiển thị không.
Kết quả mong đợi:

Hiển thị thông báo lỗi đăng nhập.
Người dùng không được chuyển hướng vào trang sản phẩm.
### 3. Kiểm thử hiển thị danh sách sản phẩm sau khi đăng nhập
Mục tiêu: Kiểm tra sau khi đăng nhập thành công, danh sách sản phẩm phải hiển thị đầy đủ.
Bước thực hiện:

Mở trình duyệt Chrome.
Truy cập vào trang https://www.saucedemo.com/.
Nhập tên đăng nhập: "standard_user".
Nhập mật khẩu: "secret_sauce".
Nhấn nút đăng nhập.
Kiểm tra xem danh sách sản phẩm có hiển thị không.
Kiểm tra xem ít nhất một sản phẩm có xuất hiện trên trang không.
Kết quả mong đợi:

Trang danh sách sản phẩm hiển thị đầy đủ.
Có ít nhất một sản phẩm được hiển thị.
## Kết quả
![image](https://github.com/user-attachments/assets/3600ea86-1c65-4314-9534-bbd112b3a18e)
## Tham khảo
https://chatgpt.com/share/678732af-6b10-8007-bf2f-549ff1c834e7
## Tác giả
Nguyễn Trà My
