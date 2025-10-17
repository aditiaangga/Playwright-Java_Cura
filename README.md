# Playwright-Java_Cura

Automation Testing Website **Cura Healthcare** menggunakan **Playwright Java**.

## 📌 Deskripsi Proyek

Proyek ini bertujuan untuk melakukan **automated UI testing** pada situs [Cura Healthcare](https://katalon-demo-cura.herokuapp.com/) menggunakan **Playwright dengan Java**. Framework ini dirancang untuk membantu pengujian fungsionalitas utama dari aplikasi web seperti login, appointment dengan beragam data.

## 🛠️ Teknologi yang Digunakan

- Playwright for Java
- Java 11+
- Maven
- IntelliJ IDEA

## 📁 Struktur Proyek

Playwright-Java_Cura/<br>
├── src/<br>
│   └── test/<br>
│       └── java/<br>
│           └── tests/<br>
│           └── pages/<br>
├── pom.xml<br>
└── README.md<br>

## 🚀 Cara Menjalankan

1. Clone repositori ini:
   ```java
   git clone https://github.com/aditiaangga/Playwright-Java_Cura.git
   cd Playwright-Java_Cura
   ```

3. Jalankan perintah Maven untuk menjalankan test:<br>
   ```java
   mvn test
   ```

4. Pastikan Playwright dependencies sudah terinstall:<br>
   ```java
   mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
   ```

## ✅ Fitur yang Diuji

- Login ke aplikasi
- Melakukan appointment
- Validasi Negative Testing
