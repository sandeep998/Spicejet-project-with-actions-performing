package Com.Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class Config_Class {
	File src;
	FileInputStream fis;
	Properties prop;
	
	public void loard() throws Exception {
		
			src = new File("C:\\Users\\sandeep.mandhala\\eclipse-workspace\\SPICEJET\\src\\Com\\Utilities\\Config_file");
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		
	}
	public String getProperty(String propKey) {
		return prop.getProperty(propKey);
	}
}
