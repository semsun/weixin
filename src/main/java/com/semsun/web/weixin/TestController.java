package com.semsun.web.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value="/hello",method={RequestMethod.POST,RequestMethod.GET})
	public void hello( @RequestParam(value="data",required=false) String data, HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write( String.format("Hello World! [%s]", data) );
			out.write( "\ntest" );
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
