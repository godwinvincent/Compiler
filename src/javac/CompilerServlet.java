package javac;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.janino.SimpleCompiler;

@SuppressWarnings("serial")
public class CompilerServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String code = req.getParameter("content");
		System.out.println(code);
		String output;
		try
		{
			SimpleCompiler sc = new SimpleCompiler("errors.txt", new StringReader(code));
		}
		catch(Exception e)
		{
			output = e.getMessage();
			if(output==null)
			{
				output = "No compile errors";
			}
			resp.getWriter().println(output);
		}
		resp.addHeader("Access-Control-Allow-Origin", "*");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String code = req.getParameter("content");
		System.out.println(code);
		String output;
		try
		{
			SimpleCompiler sc = new SimpleCompiler("errors.txt", new StringReader(code));
		}
		catch(Exception e)
		{
			output = e.getMessage();
			if(output==null)
			{
				output = "No compile errors";
			}
			resp.getWriter().println(output);
		}
		resp.addHeader("Access-Control-Allow-Origin", "*");
	}
}
