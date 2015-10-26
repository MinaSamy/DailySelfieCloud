package bloodstone.dailyselfie.cloud.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		PrintWriter writer=resp.getWriter();
		writer.write("Hello There");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream is=req.getInputStream();
		InputStreamReader reader=new InputStreamReader(is);
		int i=0;
		StringBuilder builder=new StringBuilder();
		while((i=reader.read())!=-1){
			builder.append((char)i);
		}
		
		PrintWriter writer=resp.getWriter();
		writer.write(builder.toString());
	}
}
