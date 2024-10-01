package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        displayLyrics();
    }

    private void displayLyrics() throws InterruptedException {
        // Lời bài hát với thời gian chờ trước khi hiển thị (đơn vị là giây)
        String[][] lyrics = {
                {"0", "Lòng còn thương ấy mấy còn trông đợi..."},
                {"3", "Buồn còn vương ấy thế lệ còn rơi..."},
                {"7", "Ai về lau sạch đi giọt rơi hắt hiu trên mi người..."},
                {"11", "Thôi tình ta từ nay cách xa muôn ngàn phương trời..."},
                {"15", "Chờ người thương ấy mấy còn xa vời..."},
                {"19", "Niềm tương tư ấy thế còn đầy vơi..."},
                {"24", "Em dù mai này mang bình yên khuất xa nơi anh rồi..."},
                {"27", "Mang mộng mơ ngày qua gửi mây đến em đôi lời..."},
                {"29", "Ấy mấy anh trông đợi..."},
        };

        // Lấy thời gian bắt đầu
        long startTime = System.currentTimeMillis();

        // Duyệt qua các dòng lời bài hát và hiển thị theo thời gian
        for (String[] lyric : lyrics) {
            int delay = Integer.parseInt(lyric[0]);  // Lấy thời gian delay
            String line = lyric[1];  // Lời bài hát

            // Tính thời gian hiện tại
            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - startTime) / 1000;  // Đã qua bao nhiêu giây

            // Nếu thời gian đã vượt qua delay thì hiển thị ngay, không đợi
            if (elapsedTime < delay) {
                TimeUnit.SECONDS.sleep(delay - elapsedTime);
            }

            System.out.println(line);  // Hiển thị lời bài hát
            System.out.println("Hello Word");

        }
    }
}
