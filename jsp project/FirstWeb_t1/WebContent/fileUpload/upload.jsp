<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	//파일업로드처리
	if(isMultipart){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = upload.parseRequest(request);
		
		//iterator는 반복 가능
		Iterator<FileItem> ite = items.iterator();
		
		while(ite.hasNext()){
			//넥스트하면서 요소를 반환해줌
			FileItem item = ite.next();
			
			//paramName은 uanme이런거
			//isFormFieldtext value를 가지는 input확인
			if(item.isFormField()){//type이외의 input
				//파라미터이름
				String paramName = item.getFieldName();
				//파라미터의 값
				String paramValue = item.getString("utf-8");
				System.out.println(paramName+" = "+paramValue);
			}else {//type=file
				//파라미터 이름
				String paramName= item.getFieldName();
				//파일 이름
				String fileName = item.getName();
				//파일의 사이즈
				long file_size = item.getSize();
				//파일의 타입
				String contentType = item.getContentType();
				//임시메모리에 저장여부
				boolean isInMemory = item.isInMemory();
				System.out.println("필드이름 : "+paramName);
				System.out.println("파일이름 : "+fileName);
				System.out.println("파일사이즈 : "+file_size);
				System.out.println("파일의 타입 : "+contentType);
				//여기까지하면 파일이 업로드됨. 이제 파일을 직접쓰고 경로를 가지도록 서버에 등록해주는것을 해야함.
				
				//서버 내부의 경로>>서버에서 파일폴더로 찾아가는 경로
				//String uri="/file";

				String uri = request.getSession().getServletContext().getInitParameter("uploadPath");
				//시스템의 실제(절대)경로
				String realPath = request.getSession().getServletContext().getRealPath(uri);
				//System.out.println(realPath);
				
				//파일이름이 같으면 덮어쓰기 되니까 그거 방지(입력시간_파일이름 으로들어가게됨)
				String newFileName = System.nanoTime()+"_"+fileName;
				//서버의 저장소에 실제 저장
				File savaFile = new File(realPath,newFileName);
				item.write(savaFile);
				System.out.println("저장완료");
				
			}
		}
		
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>