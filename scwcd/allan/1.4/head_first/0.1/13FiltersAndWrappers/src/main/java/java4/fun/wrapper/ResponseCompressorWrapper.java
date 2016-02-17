package java4.fun.wrapper;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseCompressorWrapper extends HttpServletResponseWrapper{

	private GZIPCompressOutputStream out = null;
	private PrintWriter writer = null;
	private Object stream;
	
	public ResponseCompressorWrapper(HttpServletResponse resp) {
		super(resp);
	}
	
	public GZIPOutputStream getGZIPOutputStream(){
		return this.out.gzipOut;
	}

	public ServletOutputStream getOutputStream() throws IOException{
		
		if((stream != null) && (stream != writer)){
			throw new IllegalStateException("");
		}
		
		if(out == null){
			out = new GZIPCompressOutputStream(getResponse().getOutputStream());
			stream = out;
		}
		
		return out;
	}
	
	public PrintWriter getWriter() throws IOException{
		
		if((stream != null) && (stream != out)){
			throw new IllegalStateException("");
		}
		
		if(writer == null){
			out = new GZIPCompressOutputStream(getResponse().getOutputStream());
			OutputStreamWriter outw = new OutputStreamWriter(out, getResponse().getCharacterEncoding());
			
			writer = new PrintWriter(outw);
			stream = writer;
		}
		
		return writer;
	}
	
}
