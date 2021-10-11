package pom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;





    public class Homepage {

        public static void main(String[] args) {

        }

        @Test
        public void login() {
            System.setProperty("webdriver.chrome.driver", "path of driver");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.airbnb.com");



            }
        }

