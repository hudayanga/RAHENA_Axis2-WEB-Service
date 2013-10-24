package com.rahena.ws5;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

import org.apache.axiom.om.util.Base64;
 
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class serviceMethods6 {
	
	private Connection con;
	 private Statement stmt;
	 String username = "hudayanga";
	 String password = "123456";
	 private String url="jdbc:mysql://localhost:3306/rahenatest";
	 
	 public void connectToDB() {
		 System.out.println("hiii axis");
	  
	  try {
		  
	   Class.forName("com.mysql.jdbc.Driver");
	   con = (Connection) DriverManager.getConnection(url,username,password);
	   System.out.println("successfully connected");
	  } catch (Exception e) {
	   System.out.println("Error - Unable to Connect to the Database" + e);
	 
	  }
	 }

	 public float getLongitude_Mc(int mcid) {
		  connectToDB();
		  float lngt = 0;
		  try {
		   stmt = (Statement) con.createStatement();
		   ResultSet rs = stmt
		     .executeQuery("SELECT Longitude FROM moclocation WHERE mocid='"
		       + mcid + "'");
		   rs.next();
		   lngt = rs.getFloat("Longitude");
		  } catch (Exception e) {
		   System.out.println("Error - Unable to get longitude of " + mcid
		     + " :" + e);
		  }
		  return lngt;
		 }
		 
		 public float getLatitude_Mc(int mcid) {
		  connectToDB();
		  float latt = 0;
		  try {
		   stmt = (Statement) con.createStatement();
		   ResultSet rs = stmt
		     .executeQuery("SELECT Latitude FROM moclocation WHERE mocid='"
		       + mcid + "'");
		   rs.next();
		   latt = rs.getFloat("Latitude");
		  } catch (Exception e) {
		   System.out.println("Error - Unable to get latitude of " + mcid
		     + " :" + e);
		  }
		  return latt;
		 }
		 public String HelloRahena() {
			  
			  return "Hi Rahena Web Service";
			 }
		 
		 public String HelloRahena2() {
			  
			  return "Hi Rahena Web Servic2";
			 }
		 
		 public String HelloRahena3() {
			  
			  return "Hi Rahena Web Servic3";
			 }
		 public int addTwoNumbers(int firstNumber, int secondNumber){
			  return firstNumber + secondNumber;
			 }
		 
		 public void addUser(String na,String em,String pw,int co,String deg) {
			  connectToDB();
			  //float latt = 0;
			  try {
				  
				  	UUID uni=UUID.randomUUID();
				  	String ruuid=uni.toString();
				  	System.out.println(""+ruuid);
				  stmt =(Statement) con.createStatement();
				  stmt.executeUpdate("INSERT INTO sysusers " + "VALUES ('1','Hasi','hasiya' ,'12345t', '0130138013','dfdfds')");
				  System.out.println("Added Sussesfully");
			   
			   
			  } catch (Exception e) {
			   System.out.println("Error - Unable to get latitude of " 
			     + " :" + e);
			  }
			  
			 }
		 
		 public void removeUser(String uid){
			  connectToDB();
			  //float latt = 0;
			  try {
				  
				  	UUID uni=UUID.randomUUID();
				  	String ruuid=uni.toString();
				  	System.out.println(""+ruuid);
				  stmt =(Statement) con.createStatement();
				  stmt.executeUpdate("INSERT INTO sysusers " + "VALUES ('1','Hasi','hasiya' ,'12345t', '0130138013','dfdfds')");
				  System.out.println("Added Sussesfully");
			   
			   
			  } catch (Exception e) {
			   System.out.println("Error - Unable to get latitude of " 
			     + " :" + e);
			  }
			  
			 }
		 
		 public String CustomerRegister(String uname,String uemail,String ucode,int uphone){
			  connectToDB();
			  //float latt = 0;
			  try {
				  
				  	UUID uni=UUID.randomUUID();
				  	String ruuid=uni.toString();
				  	System.out.println(""+ruuid);
				  stmt =(Statement) con.createStatement();
				  stmt.executeUpdate("INSERT INTO customers " + "VALUES ('1s1','"+uname+"','"+uemail+"' ,'"+ucode+"', '1.0','2.0','"+uphone+"','type')");
				  System.out.println("Added Sussesfully");
			   
			   
			  } catch (Exception e) {
			   System.out.println("Error - Unable to get latitude of " 
			     + " :" + e);
			  }
			  
			  return "Register Sucessfully";
			  
			 }
		 
		 
			    public String faultReport(String image,String FaultStatus){
			    	connectToDB();
			    	//byte[] data=Base64.decode(image);
			        
			            try{
			            stmt =(Statement) con.createStatement();
			            ResultSet rs = stmt.executeQuery("SELECT oid FROM outages ");
		            	int count=0;
		            	while(rs.next()) { 
		            	      count++;
		            	}
		            	System.out.println(""+count);
		            	int id=count+1;
						  stmt.executeUpdate("INSERT INTO outages " + "VALUES ('"+id+"','Manual','"+FaultStatus+"','1','"+image+"')");
						  System.out.println("Added Sussesfully");
			            }
			            catch(Exception e)
			            {
			            	
			            }
			            
			            
			            
			        
			        return "Image Added Successfully";
			    }
			    
			    
			    public String viewFault(){
			    	connectToDB();
			    	//byte[] blobAsBytes;
			    	//byte[] data;
			    	String str=null;
			    	String fstr1=null;
			        
			            try{
			            	stmt = (Statement) con.createStatement();
			     		   ResultSet rs = stmt.executeQuery("SELECT image FROM outages");
			     		  int count=0;
			            	while(rs.next()) { 
			            	      count++;
			            	}
			            	System.out.println(""+count);
			            	
			            	for(int i=1;i<=count;i++)
			            	{
			            		
			            		String cid="A"+i;
			            		System.out.println(""+cid);
			            		ResultSet rs1 = stmt.executeQuery("SELECT image FROM outages where oid='"+i+"'");
			            		rs1.next();
			            		String str1 = rs1.getString("image");
			            		
			            		
			            		fstr1=fstr1+".........."+str1;
			            		
			            	}
	                        
			           
			            	//System.out.println(""+fstr1);
			     		
			     		 
			            }
			            catch(Exception e)
			            {
			            	
			            }
			            
			            
			            
			            System.out.println(""+fstr1);
			        return fstr1;
			    }
			    
			    public void addminRegister(String na,int pho,String email,String pword,String type) {
					  connectToDB();
					  //float latt = 0;
					  System.out.println(""+na);
					  try {
						  
						  	
						  stmt =(Statement) con.createStatement();
						  stmt.executeUpdate("INSERT INTO addmintb " + "VALUES ('1','"+na+"','"+pho+"' ,'"+email+"', '"+pword+"','"+type+"')");
						  System.out.println("Added Sussesfully");
					   
					   
					  } catch (Exception e) {
					   System.out.println("Error - Unable to get latitude of " 
					     + " :" + e);
					  }
					  
					 }
			    
			    public String reportpowercut(String mesage,String area,String time,String date,String crew){
			    	connectToDB();
			    	System.out.println(""+mesage);
			    	String a="a1";
			        
			            try{
			            stmt =(Statement) con.createStatement();
						  stmt.executeUpdate("INSERT INTO powercut " + "VALUES ('"+a+"','"+mesage+"','"+area+"','"+time+"','"+date+"','"+crew+"')");
						  
						  System.out.println("Added Sussesfully");
			            }
			            catch(Exception e)
			            {
			            	
			            }
			            
			            
			            
			        
			        return "Succesfully Reported";
			    }
			    
			    public String updateServicecrew(String cid,String longt,String latitude){
			    	System.out.println("Added Sussesfully");
			    	connectToDB();
			    	
			    	String a="a1";
			    	
			        
			            try{
			            stmt =(Statement) con.createStatement();
			            stmt.executeUpdate("UPDATE servicecrew" +" set longitude='"+Double.parseDouble(longt)+"',latitude='"+Double.parseDouble(latitude)+"' " +"where scid= '" +cid+"'");
			           
						  
						  System.out.println("Added Sussesfully");
			            }
			            catch(Exception e)
			            {
			            	
			            }
			            
			            
			            
			        
			        return "Succesfully Reported";
			    }
			    
			    public String trackServicecrew(){
			    	
			    	connectToDB();
			    	
			    	//String a="a1";
			    	//int rowCount = -1;
			        String fstr1=null;
			            try{
			            	//System.out.println(""+rowCount);
			            	stmt = (Statement) con.createStatement();
			            	ResultSet rs = stmt.executeQuery("SELECT * FROM servicecrew ");
			            	int count=0;
			            	while(rs.next()) { 
			            	      count++;
			            	}
			            	System.out.println(""+count);
			            	
			            	for(int i=1;i<=count;i++)
			            	{
			            		
			            		String cid="A"+i;
			            		System.out.println(""+cid);
			            		ResultSet rs1 = stmt.executeQuery("SELECT * FROM servicecrew WHERE scid='"+cid+"'");
			            		rs1.next();
			            		String str1 = rs1.getString("scid");
			            		String str2=rs1.getString("longitude");
			            		String str3=rs1.getString("latitude");
			            		String str4=rs1.getString("avalability");
			            		
			            		fstr1=fstr1+" "+str1+" "+str2+" "+str3+" "+str4;
			            		System.out.println(""+fstr1);
			            	}
	                        
			           
			            	System.out.println(""+fstr1);
						 
			            }
			            catch(Exception e)
			            {
			            	
			            }
			            
			            
			            
			        
			        return ""+fstr1;
			    }
			    
			    
			    public void detectOutage()
			    {
			    	connectToDB();
			    	
			    	try
			    	{
			    		stmt = (Statement) con.createStatement();
		            	ResultSet rs = stmt.executeQuery("SELECT * FROM outages where mocid!='0'");
		            	rs.next();
		            	String str1 = rs.getString("description");
		            	String str2=rs.getString("mocid");
		            	String str3=rs.getString("oid");
		            	
		            	ResultSet rs1 = stmt.executeQuery("SELECT * FROM servicecrew where avalability='0'");
		            	rs.next();
		            	String str4=rs.getString("sid");
		            	stmt =(Statement) con.createStatement();
						stmt.executeUpdate("INSERT INTO processes " + "VALUES ('A1','"+str2+"','Bellanwila','PowerDown','"+str4+"','sddsd','sdsds','sasa','"+str3+"')");
						
						stmt.executeUpdate("UPDATE servicecrew" +" set avalability='1' " +"where scid= '" +str4+"'");
		            	
		            	System.out.println(""+str1);
			    		
			    	}
			    	
			    	catch(Exception e)
			    	{
			    		
			    	}
			    	
			    	
			    	
			    	
			    	
			    }
			    
			    public String microStatus(){
			    	
			    	connectToDB();
			    	
			    	//String a="a1";
			    	//int rowCount = -1;
			        String fstr1=null;
			            try{
			            	//System.out.println(""+rowCount);
			            	stmt = (Statement) con.createStatement();
			            	ResultSet rs = stmt.executeQuery("SELECT * FROM moclocation ");
			            	int count=0;
			            	while(rs.next()) { 
			            	      count++;
			            	}
			            	System.out.println(""+count);
			            	
			            	for(int i=1;i<=count;i++)
			            	{
			            		
			            		String cid="A"+i;
			            		System.out.println(""+cid);
			            		ResultSet rs1 = stmt.executeQuery("SELECT * FROM moclocation where mocid='"+i+"'");
			            		rs1.next();
			            		String str1 = rs1.getString("mocid");
			            		String str2=rs1.getString("status");
			            		
			            		
			            		fstr1=fstr1+" "+str1+" "+str2;
			            		System.out.println(""+fstr1);
			            	}
	                        
			           
			            	System.out.println(""+fstr1);
						 
			            }
			            catch(Exception e)
			            {
			            	
			            }
			            
			            
			            
			        
			        return ""+fstr1;
			    }
			    
			    public String faultReportMC(String reportType,String description,int mocid){
			    	connectToDB();
			    	//byte[] data=Base64.decode(image);
			        
			            try{
			            stmt =(Statement) con.createStatement();
			            ResultSet rs = stmt.executeQuery("SELECT oid FROM outages ");
		            	int count=0;
		            	while(rs.next()) { 
		            	      count++;
		            	}
		            	System.out.println(""+count);
		            	int id=count+1;
						  stmt.executeUpdate("INSERT INTO outages " + "VALUES ('"+id+"','"+reportType+"','"+description+"','"+mocid+"','null')");
						  System.out.println("Added Sussesfully");
			            }
			            catch(Exception e)
			            {
			            	
			            }
			            
			            
			            
			        
			        return "Image Added Successfully";
			    }
}
