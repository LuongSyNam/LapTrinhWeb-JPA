package vn.iotstar.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;
import vn.iotstar.service.ICategoryService;
import vn.iotstar.service.IVideoService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.VideoServiceImpl;

@MultipartConfig()
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/add", "/admin/video/insert",
		"/admin/video/edit", "/admin/video/update","/admin/video/search", "/admin/video/delete" })
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IVideoService vidService = new VideoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if (url.contains("/admin/videos")) {
			List<Video> list = vidService.findAll();
			req.setAttribute("listvid", list);
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
		} else if (url.contains("/admin/video/add")) {
			ICategoryService categoryService = new CategoryServiceImpl();
		    List<Category> categories = categoryService.findAll(); // Giả sử bạn có phương thức này
		    req.setAttribute("categories", categories);
		        
		    req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
		} else if (url.contains("/admin/video/edit")) {
			String id = req.getParameter("id");
			Video video = vidService.findById(id);
			req.setAttribute("vid", video);
			
			ICategoryService categoryService = new CategoryServiceImpl();
		    List<Category> categories = categoryService.findAll(); // Giả sử bạn có phương thức này
		    req.setAttribute("categories", categories);
			
			req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
		}else if(url.contains("search")) {
			String key = req.getParameter("keyword");
			List<Video> list = vidService.searchByTitle(key);
			req.setAttribute("listvid", list);
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
		} else {
			String id = req.getParameter("id");
			try {
				vidService.delete(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// chuyển trang
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String videoId = req.getParameter("videoid");
		String description = req.getParameter("description");
		String images = "";
		String title = req.getParameter("title");
		int active = Integer.parseInt(req.getParameter("active"));
		int views = Integer.parseInt(req.getParameter("views"));
		int categoryname = Integer.parseInt(req.getParameter("category"));
		CategoryServiceImpl c = new CategoryServiceImpl();
		Category category = c.findById(categoryname);
		
		
		//String uploadPath = UPLOAD_DIRECTORY // lưu vào thư mục trong máy
		String uploadPath = getServletContext().getRealPath("") + File.separator + "upload"; // luu vào thư mục trong prj
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) uploadDir.mkdir();

	    try {
	        String fileName = "";
	        // Duyệt qua các part trong request
	        for (Part part : req.getParts()) {
	            // Kiểm tra nếu part là file (có content-disposition)
	            if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
	            	fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	                part.write(uploadPath + File.separator + fileName);
	        	    	images = fileName;
	            }
	        }
	    } catch (FileNotFoundException fne) {
	        req.setAttribute("message", "Có lỗi xảy ra: " + fne.getMessage());
	    }
	    if(images == "" && req.getParameter("images") != null ) {
	    	images = req.getParameter("images");
	    }

	
		if(url.contains("insert")) {
		
			Video video = new Video();
			video.setVideoId(videoId);
			video.setPoster(images);
			video.setDescription(description);
			video.setActive(active);
			video.setTitle(title);
			video.setViews(views);
			video.setCategory(category);
			vidService.insert(video);
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}else if(url.contains("update")) {
			
			String videoid = req.getParameter("videoid");
			if(images == "") {
				
				Video a = vidService.findById(videoid);
				images = a.getPoster();
			}
			
			Video video = new Video();
			video.setVideoId(videoId);
			video.setPoster(images);
			video.setDescription(description);
			video.setActive(active);
			video.setTitle(title);
			video.setViews(views);
			video.setCategory(category);
			vidService.update(video);
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}
	}

}
