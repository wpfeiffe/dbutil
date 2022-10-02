package com.wspfeiffer.dbutil;

import com.wspfeiffer.dbutil.services.DbService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DbUtilApplication implements CommandLineRunner {

    public final DbService dbService;

    public DbUtilApplication(final DbService dbService) {
        this.dbService = dbService;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DbUtilApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    public void run (String... args) {
        System.out.println("Hello");
        List<DbService.UserAccount> users = dbService.runSql("select * from user_account");
        for (DbService.UserAccount user : users) {
            System.out.println(user.toString());
        }
    }
}
