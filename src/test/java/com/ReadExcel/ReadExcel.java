package com.ReadExcel;

import java.io.File;


import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcel {
	
	
	public static Fillo fillo;
	public static Connection connection;
	
	public static void connect_to_excel()
	{
		
		String testdata_path = System.getProperty("user.dir")+"\\Testdata\\Testdata.xlsx";
		try
		{
		
		File testfile = new File(testdata_path);
		
		if(testfile.exists())
		{
			
			fillo = new Fillo();
			connection = fillo.getConnection(testdata_path);
			System.out.println("Connection is established successsfully");
			
		}
		else
		{
			throw new Exception ("Test file is not available under " + testdata_path);
		}
		
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static String getCommonTestData(String column)
	{
		String data="";
		String query="Select * from Common_Testdata where Execute_Test='Yes'";
		
		try {
			Recordset rcrdst=connection.executeQuery(query);
			
			while(rcrdst.next())
			{
				System.out.println(rcrdst.getField(column));
				
				data=rcrdst.getField(column);
				break;
			}
					
		
		} catch (FilloException e) {
			
			System.out.println(e.getMessage());
		}
		
		return data;
		
	}
	
	
	
	
	

}
