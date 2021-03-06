package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class EaseMyTrip {

    WebDriver driver;
    String destination = "Goa";
    String fromDateYear = "2020";
    String fromDateMonth = "November";
    String fromDate = "10";
    String toDateYear = "2020";
    String toDateMonth = "December";
    String toDate = "12";
    int rooms = 1;
    int guestsAdult = 4;
    int guestChildren = 1;

    @BeforeTest
    public void loadPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/cc1/Documents/software/chromedriver");
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.easemytrip.com/");
        Thread.sleep(3000);
    }

    @Test
    public void hotelsBooking() throws InterruptedException {
        //Hotel tab
        driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[1]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        //Destination
        WebElement dest = driver.findElement(By.className("hp_city"));
        dest.click();
        driver.findElement(By.id("txtCity")).sendKeys(destination);
        //Check In
        driver.findElement(By.id("txtcid")).click();
        getCheckInDate();
        //Check Out
        getCheckOutDate();
        //Rooms and guests
        driver.findElement(By.id("divPaxPanel")).click();
        getRoomsAndGuests();
//        driver.findElement(By.className("htlhp_btn")).click();
//        String expectedTitle = "Hotel List";
//        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    private void getCheckInDate (){

        //This is from date picker table
        WebElement dateWidgetFrom = driver.findElement(By.id("ui-datepicker-div"));

        //Select desired year
        WebElement year = null;
        String yr = null;
        while(yr == null) {
            year = dateWidgetFrom.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[2]"));
            if (year.getText().equals(fromDateYear)) {
                yr = year.getText();
                year.click();
                break;
            } else {
                dateWidgetFrom.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a/span")).click();
            }
        }

        //Select desired month
        WebElement month = null;
        String mnth = null;
        while(mnth == null) {
            month = dateWidgetFrom.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]"));
            if (month.getText().equals(fromDateMonth)) {
                mnth = month.getText();
                month.click();
                break;
            } else {
                dateWidgetFrom.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a/span")).click();
            }
        }

        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            //Select desired Date
            if (cell.getText().equals(fromDate)) {
                cell.click();
                break;
            }
        }
    }

    private void getCheckOutDate () {

        //This is from date picker table
        WebElement dateWidgetFrom = driver.findElement(By.id("ui-datepicker-div"));

        //Select desired year
        WebElement year = null;
        String yr = null;
        while(yr == null) {
            year = dateWidgetFrom.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[2]"));
            if (year.getText().equals(toDateYear)) {
                yr = year.getText();
                year.click();
                break;
            } else {
                dateWidgetFrom.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a/span")).click();
            }
        }

        //Select desired month
        WebElement month = null;
        String mnth = null;
        while(mnth == null) {
            month = dateWidgetFrom.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]"));
            if (month.getText().equals(toDateMonth)) {
                mnth = month.getText();
                month.click();
                break;
            } else {
                dateWidgetFrom.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a/span")).click();
            }
        }

        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            //Select desired Date
            if (cell.getText().equals(toDate)) {
                cell.click();
                break;
            }
        }
    }

    private void getRoomsAndGuests () {

        WebElement roomGuestBox = driver.findElement(By.id("divHotelPaxContent"));
        WebElement noOfAdult = roomGuestBox.findElement(By.id("Adults_room_1_1"));
        WebElement AdultRoomMinus = roomGuestBox.findElement(By.id("Adults_room_1_1_minus"));
        WebElement AdultRoomPlus = roomGuestBox.findElement(By.id("Adults_room_1_1_plus"));
        WebElement noOfChildren = roomGuestBox.findElement(By.id("Children_room_1_1"));
        WebElement ChildRoomMinus = roomGuestBox.findElement(By.id("Children_room_1_1_minus"));
        WebElement ChildRoomPlus = roomGuestBox.findElement(By.id("Children_room_1_1_plus"));
        WebElement doneButton = roomGuestBox.findElement(By.id("exithotelroom"));

        if (rooms == 1  ) {
            if (guestsAdult < Integer.parseInt(noOfAdult.getText())) {
                final int diff1 = Integer.parseInt(noOfAdult.getText()) - guestsAdult;
                for (int i =0; i<diff1; i ++) {
                    AdultRoomMinus.click();
                }
            } else if (guestsAdult > Integer.parseInt(noOfAdult.getText())) {
                final int diff2 =  guestsAdult - Integer.parseInt(noOfAdult.getText());
                for (int i =0; i<diff2; i ++) {
                    AdultRoomPlus.click();
                }
            } else {

            }
           if(guestChildren < Integer.parseInt(noOfChildren.getText())) {
               final int diff3 = Integer.parseInt(noOfChildren.getText()) - guestChildren;
               for (int i = 0; i < diff3; i++) {
                   ChildRoomMinus.click();
               }
           }
               else if (guestChildren > Integer.parseInt(noOfChildren.getText())) {
               final int diff4 = guestChildren - Integer.parseInt(noOfChildren.getText());
               for (int i = 0; i < diff4; i++) {
                   ChildRoomPlus.click();
               }
           } else {}

        }
//        else if (rooms>1) {
//            driver.findElement(By.id("addhotelRoom")).click();
//        } else
//            System.out.println("Number of rooms invalid!");
        doneButton.click();
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}
