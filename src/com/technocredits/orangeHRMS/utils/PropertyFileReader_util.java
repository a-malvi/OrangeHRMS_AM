package com.technocredits.orangeHRMS.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.technocredits.orangeHRMS.constants.ConstantPath;

public class PropertyFileReader_util {
	private Properties prop;
	
	public PropertyFileReader_util(String filePath) throws IOException{
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		prop = new Properties();
		prop.load(inputStream);
	}
	
	public String getValueFromKey(String targetKey) throws IOException {
		return prop.getProperty(targetKey);
	}


}
