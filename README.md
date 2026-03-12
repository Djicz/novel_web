# Novel Web - Hệ thống đọc truyện trực tuyến

Dự án **novel_web** là một ứng dụng web được xây dựng trên nền tảng Spring Boot, cho phép người dùng đọc truyện, quản lý danh sách truyện và tự động lấy nội dung từ các nguồn khác (crawler/fetcher).

## Tính năng chính
* **Đọc truyện đa thiết bị:** Giao diện tối ưu cho cả trình duyệt máy tính và điện thoại.
* **Hệ thống Crawler:** Tự động fetch nội dung chương từ các nguồn truyện lớn (như TTV - SangTacViet).
* **Quản lý thư viện:** Lưu trữ thông tin truyện, tác giả, thể loại và trạng thái chương.
* **Ghi log hệ thống:** Theo dõi quá trình vận hành và lỗi thông qua hệ thống log chi tiết (`app.log`, `spring_output.log`).

## Công nghệ sử dụng
* **Backend:** Java 17+, Spring Boot 3.x
* **Quản lý thư viện:** Maven
* **Database:** (Tùy chỉnh: MySQL/PostgreSQL/H2)
* **Frontend:** HTML, CSS (Thymeleaf), JavaScript
* **Tools:** Lombok, MapStruct, Jsoup (để fetch dữ liệu)

## Cấu trúc thư mục tiêu biểu
```text
├── src/main/java         # Mã nguồn Java (Controller, Service, Repository, Entity)
├── src/main/resources    # Cấu hình ứng dụng, templates HTML và static files
├── .mvn/                 # Maven wrapper
├── TestFetch.java        # File test tính năng crawler
├── pom.xml               # Khai báo các dependency (Lombok, Spring Data JPA,...)
└── app.log               # Log ghi lại hoạt động của ứng dụng
```

## Hướng dẫn cài đặt

1. **Clone project:**
```bash
git clone https://github.com/Djicz/novel_web.git
cd novel_web
```


2. **Cấu hình Database:**
   Chỉnh sửa file `src/main/resources/application.properties` để cấu hình datasource (URL, username, password) phù hợp với máy của bạn.
3. **Chạy ứng dụng:**
   Sử dụng Maven Wrapper để khởi động project:
```bash
./mvnw spring-boot:run
```