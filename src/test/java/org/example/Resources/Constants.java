package org.example.Resources;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

public class Constants {
    public final static String webdriverProperty = "webdriver.chrome.driver";
    public final static String chromeDriverPath = "Z:/chromedriver.exe";
    public final static String websiteURL = "https://app.yaware.com.ua/";
    public final static String emailUser = "o.babeniuk+555@yaware.com";
    public final static String passwordUser = "123456";
    public final static String successPopUpText = "Готово";
    public final static String windowsText = "Windows";
    public final static String linuxText = "Linux";
    public final static String macosText = "Mac OS";
    public final static String noDataText = "Нет данных для отображения";
    public static DateFormatSymbols rusDateFormatSymbols = new DateFormatSymbols(){
        public String[] getMonths() {
            return new String[]{"января", "февраля", "марта", "апреля", "мая", "июня",
                    "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        }
    };
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy'г' HH:mm", rusDateFormatSymbols);
    public class Generator {
        public final static String HeaderCSV = "firstname,middlename,lastname,email,group_name";
        public final static String EmailDomain = "@gmail.com";
        public final static String[] GroupName = {
                "Transportation Department",
                "HR Department",
                "Accounting",
                "Logistics Department"
        };
        public final static String PathToCSV = "Z://employee.csv";
    }
}
