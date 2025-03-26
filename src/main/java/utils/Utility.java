package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Utility {
	
	
//To load properties file 	
	public static Properties loadpropertiesFile() {
		Properties prop = new Properties();
		try {
		FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\projectdata.properties");
		prop.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	
// To Generate new Email id
	public static String GenerateNewEmailAddressWithTimeStamp() {
		
		Date date = new Date();
		String datestring = date.toString();
		String datestringwithoutspaces = datestring.replaceAll("\\s", "");
		String datestringwithoutcolonandspaces = datestringwithoutspaces.replaceAll("\\:", "");
		String brandnewemail = datestringwithoutcolonandspaces+"@gmail.com";
		return brandnewemail;
		
		
	}
	
	//Method to compare two screenshot
	
	public static boolean compareTwoScreenshots(String actualImagePath, String expectedImagePath) throws IOException {
		
		BufferedImage bufferactualImage=ImageIO.read(new File(actualImagePath));
		BufferedImage bufferexpectedImage=ImageIO.read(new File(expectedImagePath));
		ImageDiffer differ = new ImageDiffer();
		ImageDiff imagediff = differ.makeDiff(bufferexpectedImage, bufferactualImage);
		return imagediff.hasDiff();
		
		
	}
	
	public static void takeScreenshot(WebDriver driver,String screenshotpath) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcSreenshot = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(srcSreenshot, new File(screenshotpath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
