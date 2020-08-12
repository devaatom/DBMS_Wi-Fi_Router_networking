/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author USER
 */
 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 import java.util.ArrayList;
import java.util.List;

class ShowIP1
{
	public static void main(String[] args)throws Exception	
	{
            InetAddress localhost=InetAddress.getLocalHost();
            
         
        String ip[] = localhost.getHostAddress().split("\\.");
        String ipaddr = ip[0]+"."+ip[1]+"."+ip[2]+".";
                                            
        for(int i=2; i<255; i++){
            List<String> commands = new ArrayList<String>(); 
            commands.add("ping"); 
            commands.add("-n 1 -w 1");
            commands.add(ipaddr+Integer.toString(i));
            ProcessBuilder ps = new ProcessBuilder(commands); 
            Process process = ps.start();
        }
                        
        Thread.sleep(5000);

            System.out.println("system IP Address : "+(localhost.getHostAddress()));
			// Create operating system process from arpe.bat file command
                        System.out.println("new code9:");
			ProcessBuilder pb = new ProcessBuilder("G:\\Desktop\\arpe.bat");  
 
			pb.redirectErrorStream();
			// Starts a new process using the attributes of this process builder                            
			Process p = pb.start();				
				 
			BufferedReader br = new BufferedReader (new InputStreamReader(p.getInputStream()));
 
			// String out is used to store output of this command(process)
			String out="";   
                        
                        //InetAddress localhost = InetAddress.getLocalHost(); 
                        //System.out.println("System IP Address : " + (localhost.getHostAddress()));
 
			while(true)
			{
				String l=null;
				try 
				{
					l = br.readLine();
                                        
                                        if(l==null)
                                            break;
                                        String[] tokens = l.split("\\s+");
                                        //String t;
                                        if(tokens.length > 3){
                                            //System.out.println(tokens[3]);
                                            if("dynamic".equals(tokens[3])){
                                                System.out.println(tokens[1]+ " "+tokens[2]);
                                            }
                                        }
				} 
				catch (IOException ex) {
                                    ex.printStackTrace();
                                }
				if(l==null)
					break;
				out+="\n"+l;
			}
 
			// A compiled representation of a regular expression
			Pattern pattern = 
Pattern.compile(".*\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b"); 
 
			/* An engine that performs match operations on a character sequence by interpreting a Pattern */
			Matcher match = pattern.matcher(out);			
 
			out="";
			String prev="",pLoc;
 
			if(!(match.find()))        // In case no IP address Found in out
				out="No IP found!";
 
			else
			{
 
				/* Returns the input subsequence matched by the previous match in this case IP of our interface */
				pLoc = match.group();  
                    
				out+=pLoc+"\nOther Hosts'(In Same Network) IP addresses:\n";
				while(match.find())	 
				{
					pLoc = match.group();	// Returns the IP of other hosts
					out+=pLoc+"\n";
				}
				try 
				{
					br.close();
				} 
				catch (IOException ex) {
                                    ex.printStackTrace();
                                }
			}
 
			// Printing IP Addresses of all computers in our network
			//System.out.println(out);			
	}
}