package java4.fun.filters;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.GZIPOutputStream;

import java4.fun.wrapper.GZIPCompressOutputStream;
import java4.fun.wrapper.ResponseCompressorWrapper;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompressFilter implements Filter{

	private FilterConfig conf;
	private ServletContext ctx;
	
	public void init(FilterConfig conf) throws ServletException{
		this.conf = conf;
		this.ctx = conf.getServletContext();
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String encoding = req.getHeader("Accept-Encoding");
		if(encoding.indexOf("gzip") > -1){
			ResponseCompressorWrapper wrappedResp = new ResponseCompressorWrapper(resp);
			wrappedResp.setHeader("Content-Encoding", "gzip");
			
			chain.doFilter(request, wrappedResp);
			
			GZIPOutputStream gout = wrappedResp.getGZIPOutputStream();
			gout.finish();
			
			ctx.log(conf.getFilterName() +  " : finished the request and compress the response.");
		}else{
			
			ctx.log(conf.getFilterName() +  " : no encoding performed.");
		}
		
	}
	
	public void destroy(){
		this.conf = null;
		this.ctx = null;
	}
}
