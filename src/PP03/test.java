package PP03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class test {
	  public static void main(String[] args) throws Exception{
		  	String output = "";
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				// Get the selected file
				java.io.File file = fileChooser.getSelectedFile();
				// Create a Scanner for the file
				Scanner input = new Scanner(file);
				
				String[] rec = new String[50];
				int i = 0;
				
				// Read text from the file
				while (input.hasNext()) {
					String line = input.nextLine();
					String[] data = line.split(",");
					for(i=0; i < data.length; i++) {
						output += (data[i]);
					}
					output = output + "\n";
				}
				System.out.print(output + "\n");
				input.close(); // Close the file

				
			
		    }
		    else {
		        JOptionPane.showMessageDialog(null,"No file selected");
		    }
			try {
				File file_output = new File("outputfile.txt");
				FileWriter fileWriter = new FileWriter(file_output);
				fileWriter.write(output);
				fileWriter.flush();
				fileWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
	  }
}
