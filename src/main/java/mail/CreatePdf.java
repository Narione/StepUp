package mail;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/pdf")
public class CreatePdf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/mail/createPdf.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Document document = new Document();
	    String filePath = "Z:/2023_산대특_4차/User/std124/과제/"+title+".pdf"; // 저장하고 싶은 경로와 파일명 설정
	
	    try {
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
	        document.open();
	        
	        BaseFont bf = BaseFont.createFont("C:/Users/user/Documents/malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 12);
	
	        document.add(new Paragraph(content, font));
	
	        document.close();
	        writer.close();
	    } catch (DocumentException | FileNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	    	request.getRequestDispatcher("/WEB-INF/views/mail/createPdf.jsp").forward(request, response);    	
	    }
	}
	

}
