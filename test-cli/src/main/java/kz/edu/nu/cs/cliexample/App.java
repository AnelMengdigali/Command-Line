package kz.edu.nu.cs.cliexample;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * 
 */
public class App {
    public static void main(String[] args) {
        
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("help", false, "print this help message");
        options.addOption("s", true, "input string");
        
        CommandLine cmd;
        
        try {
            cmd = parser.parse(options, args);
            
            if (cmd.hasOption("help")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("App", options);
                System.exit(0);
            }
            
            if (cmd.hasOption("s")) {
            	
            	String s = cmd.getOptionValue("s");
            	
            	int result = wordcount(s);
                System.out.print( result );
                             
            }
            
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }

    public static int wordcount(String s) {
        
        int wordcount = 1;
        
        for( int i = 0; i < s.length(); i ++ ) {
        	
        	if ( s.charAt(0) == ' ' ) {
                return 0;
            }
        	
            if ( s.charAt(i) == ' ' ) {
                wordcount ++;
            }
            
        }
        
        return wordcount;
        
    }
    
}
