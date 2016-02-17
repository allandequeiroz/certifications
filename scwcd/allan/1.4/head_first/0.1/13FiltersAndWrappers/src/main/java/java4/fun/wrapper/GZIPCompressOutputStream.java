package java4.fun.wrapper;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;

public class GZIPCompressOutputStream extends ServletOutputStream{

	GZIPOutputStream gzipOut;
	
	public GZIPCompressOutputStream(ServletOutputStream out) throws IOException{
		this.gzipOut = new GZIPOutputStream(out);
	}

	public void write(int param) throws IOException {
		gzipOut.write(param);
	}
	
	
}
