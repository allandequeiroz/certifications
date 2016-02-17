package java4.fun.filters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoggerFilter implements Filter{
	
	private FilterConfig conf;
	private String logDir;
	private String logFile;
	
	public void init(FilterConfig conf) throws ServletException{
		this.conf = conf;
		logDir = conf.getInitParameter("logDir");
		logFile = conf.getInitParameter("logFile");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException{
		File dir = new File(this.logDir);
		dir.mkdir();
		
		File log = new File(dir, this.logFile);
		if(!log.exists()){
			boolean created = false;
			try{
				created = log.createNewFile();
			}catch(IOException e){
				if(!created){
					throw new IOException("Log file error!",e);
				}
			}
		}
		
		FileWriter writer = new FileWriter(log, true);

		SimpleDateFormat logTime = new SimpleDateFormat("hh:mm:ss");
		String logTimeString = logTime.format(Calendar.getInstance().getTime());
		
		try{
			writer.append(logTimeString + " - resquest filtered by Log Filter.\n");
			writer.flush();
		}catch(IOException ioe){
			//Stupid log sistem, "only 4 fun"
			System.out.println(ioe.getMessage());
			throw ioe;
		}finally{
			try{
				writer.close();
			}catch(IOException ioe){
				//Stupid log sistem 2, "only 4 fun"
				System.out.println("ATENTION!!! Stream not closed!");
				throw ioe;
			}
		}
		
		chain.doFilter(request, response);
	}
	
	public void destroy(){
		
	}
}
