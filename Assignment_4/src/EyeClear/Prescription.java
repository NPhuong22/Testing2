package EyeClear;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Prescription {
	private int prescID;
	private String firstName;
	private String lastName;
	private String address;
	private float sphere;
	private float axis;
	private float cylinder;
	private  Date examinationDate;
	private String optometrist;
	private String[] remarkTypes= {"Client", "Optometrist"};
	private ArrayList <String> postRemarks = new ArrayList<>();
	
	public Prescription(int prescID,String firstName, String lastName, String address, float sphere,
			 float cylinder,float axis, Date examinationDate,  String optometrist  ) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
		
	}
	
	public boolean addPrescription() {
		if(firstName.length() < 4 || firstName.length() > 15 || lastName.length() < 4 || lastName.length() > 15) {
			return false;
		}
		if(address.length() < 20) {
			return false;
		}
		if(sphere < -20.00 || sphere > 20.00 || cylinder < -4.00 || cylinder > 4.00 || axis < 0 || axis > 180) {
			return false;
			
		}
		
		 SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String formattedDate = inputFormat.format(examinationDate);
		 
		if(optometrist.length() < 8 || optometrist.length() > 25) {
			return false;
			
		}
		
		
		try {
		    File directory = new File("C:/Users/LENOVO/OneDrive - RMIT University/Documents/Presc");
		    
		    
		    if (!directory.exists()) {
		        directory.mkdirs(); 
		    }
		
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "/presc.txt", true))){
			writer.write(String.format("Prescription ID: %d, Name: %s %s, Address: %s, Sphere: %.2f, Cylinder: %.2f, Axis: %.2f, Date: %s, Optometrist: %s\n",
                    prescID, firstName, lastName, address, sphere, cylinder, axis, formattedDate, optometrist));
			return true;
		}catch(IOException e){
			 e.printStackTrace(); 
			return false;
		}
		} catch(Exception e){
			 e.printStackTrace(); 
			return false;
		}
		
	}
	
	
	public boolean addRemark(String remark, String category) {
		String[] words = remark.split(" ");
		if(words.length < 6 || words.length > 20 || !Character.isUpperCase(words[0].charAt(0))) {
			return false;
		}
		if(postRemarks.size() >= 2) {
			return false;
			
		}
		
		 if (category == null || 
			       (!category.equalsIgnoreCase("optometrist") && !category.equalsIgnoreCase("client"))) {
			        return false; 
			    }
		 
		postRemarks.add(remark);
		
		
		 File directory = new File("C:/Users/LENOVO/OneDrive - RMIT University/Documents/Remark");
		    
		    
		    if (!directory.exists()) {
		        directory.mkdirs(); 
		    } 
		 
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "/review.txt", true))){
			writer.write("Category: " + category + "\n");
			writer.write("Remark: " + remark + "\n");
			
			return true;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	

}
