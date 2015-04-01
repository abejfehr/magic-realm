package com.magicrealm.common;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.esotericsoftware.minlog.Log;

/**
 * Logger is a logging class that's used by the Minlog library to log messages.
 * 
 * When a message is logged it will be:
 * - stored in for future reference in the logHistory
 * - outputted to the console
 * - printed to a log file, whose filename is configurable
 * 
 * @author Abe Fehr
 */
public class Logger extends com.esotericsoftware.minlog.Log.Logger {

	// Stores the log history for the time this logger is alive
	private HashMap<Integer, ArrayList<String>> logHistory;
	
	
	
	/**
	 * Initializes the Log History
	 */
	public Logger() {
		logHistory = new HashMap<Integer, ArrayList<String>>();
	}
	
	
	
	/**
	 * Logs a message to the following places:
	 * - kept in a container in this class
	 * - stored in a file specified in the configuration
	 * - prints it out to the console
	 */
    public void log (int level, String category, String message, Throwable ex) {
    	// Build the string to be logged
        StringBuilder builder = new StringBuilder(256);
        builder.append(new Date());
        builder.append(' ');
        builder.append(level);
        builder.append('[');
        builder.append(category);
        builder.append("] ");
        builder.append(message);
        if (ex != null) {
            StringWriter writer = new StringWriter(256);
            ex.printStackTrace(new PrintWriter(writer));
            builder.append('\n');
            builder.append(writer.toString().trim());
        }
        
        // Print the string to the console
        System.out.println(builder);

        // Put it in a file
		try {
		    FileWriter fw = new FileWriter(Config.LOG_FILE_LOCATION, true);
		    fw.write(builder + "\n");
		    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Add it to the history
		if(logHistory.get(level) == null) {
			logHistory.put(level, new ArrayList<String>());
		}
		ArrayList<String> newHistory = logHistory.get(level);
		newHistory.add(message);
		logHistory.put(level, newHistory);
    }

	
}
