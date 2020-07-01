package experiment;

import org.testng.annotations.Test;

import utilities.ExcelReader;

public class ExcelWrite {

@Test 

public void writeInExcel()
{
	ExcelReader write=new ExcelReader("/Users/birendra/git/datadriven/SampleDataTest/src/test/resources/excel/testdata.xlsx");
	write.setData("Registration","a",2,"aaa@aaa.com");
}



}
