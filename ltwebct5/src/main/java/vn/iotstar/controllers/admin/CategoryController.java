package vn.iotstar.controllers.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import jakarta.servlet.jsp.PageContext;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.models.*;
import vn.iotstar.impl.*;

@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/edit", "/admin/category/update", "/admin/category/delete", "/admin/category/search" })
@MultipartConfig()
public class CategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CategoryServiceImpl();
	public static final String UPLOAD_DIRECTORY = "C:\\Users\\Admin\\git\\repository\\ltwebct5\\src\\main\\webapp\\uploads";
	public static final String DEFAULT_FILENAME = "default.file";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("categories")) {

			List<CategoryModel> list = cateService.findAll();

			req.setAttribute("listcate", list);
			System.out.println(list);

			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);

		}
		if (url.contains("/admin/category/edit")) {
			HttpSession session = req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel cate = cateService.findById(id);
			session.setAttribute("cate", cate);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}
		if (url.contains("/admin/category/add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}

		System.out.println("Da goi 5");
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return DEFAULT_FILENAME;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print("Cuc cu do post");
		String url = req.getRequestURI();
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		if (url.contains("/admin/category/edit")) {
			System.out.print("Cuc cu 2222");
			String uploadPath = File.separator + UPLOAD_DIRECTORY; // upload vào thư mục bất kỳ
			// String uploadPath = getServletContext().getRealPath("") + File.separator +
			// UPLOAD_DIRECTORY; //upload vào thư mục project

			System.out.print(uploadPath);
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			try { 
				String fileName = "";
				String id = req.getParameter("id");
				String categoryname = req.getParameter("categoryname");
				int status = Integer.parseInt(req.getParameter("status"));
				String images = fileName;
				// vì đọc(dịch input) thành cái part chỉ 1 lần nên cần lưu trong list để cần thì
				// duyệt lại
				List<Part> fileParts = req.getParts().stream().filter(part -> "file".equals(part.getName()))
						.collect(Collectors.toList());
				for (Part part : fileParts) {
					fileName = getFileName(part);
					if (fileName !=  "") {
						images = fileName;
						CategoryModel md = new CategoryModel(Integer.parseInt(id), categoryname, status, images);
						req.setAttribute("cate", md);
						cateService.update(md);
						part.write(uploadPath + File.separator + fileName);
					}
					else
					{
						 id = req.getParameter("id");
						CategoryModel mdold = cateService.findById(Integer.parseInt(id));
						String fileold = mdold.getImages();
						CategoryModel md = new CategoryModel(Integer.parseInt(id), categoryname, status, fileold);
						req.setAttribute("cate", md);
						cateService.update(md);
					}
				}
				req.setAttribute("message", "File " + fileName + " has uploaded successfully!");
			} catch (FileNotFoundException fne) {
				req.setAttribute("message", "There was an error: " + fne.getMessage());
			}
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}
		if (url.contains("/admin/category/insert")) {
			System.out.print("Cuc cu 2222");
			String uploadPath = File.separator + UPLOAD_DIRECTORY; // upload vào thư mục bất kỳ
			// String uploadPath = getServletContext().getRealPath("") + File.separator +
			// UPLOAD_DIRECTORY; //upload vào thư mục project

			System.out.print(uploadPath);
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			try { 
				String fileName = "";
				// vì đọc(dịch input) thành cái part chỉ 1 lần nên cần lưu trong list để cần thì
				// duyệt lại
				List<Part> fileParts = req.getParts().stream().filter(part -> "file".equals(part.getName()))
						.collect(Collectors.toList());
				for (Part part : fileParts) {
					fileName = getFileName(part);
					if (fileName !=  "") {
						String categoryname = req.getParameter("categoryname");
						int status = Integer.parseInt(req.getParameter("status"));
						String images = fileName;
						CategoryModel md = new CategoryModel(categoryname, status, images);
						cateService.insert(md);
						part.write(uploadPath + File.separator + fileName);
					}

				}
				req.setAttribute("message", "File " + fileName + " has uploaded successfully!");
			} catch (FileNotFoundException fne) {
				req.setAttribute("message", "There was an error: " + fne.getMessage());
			}
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}

	}

}
