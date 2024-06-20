package web.servlet.backstage;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Tag;
import service.TagService;
import service.impl.TagServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/doGetTagByCategoryServlet")
public class DoGetTagByCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TagService tagService = new TagServiceImpl();

		String categoryIdString = request.getParameter("category");
		int categoryId = Integer.parseInt(categoryIdString);
		List<Tag> tagList = tagService.getTagByCId(categoryId);

		// 将 tagList 转换为 JSON 字符串
		ObjectMapper mapper = new ObjectMapper();
		String jsonTagList = mapper.writeValueAsString(tagList);

		// 设置响应的 Content-Type 为 JSON
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// 将 JSON 字符串写回前端
		PrintWriter out = response.getWriter();
		out.print(jsonTagList);
		out.flush();
    }
}