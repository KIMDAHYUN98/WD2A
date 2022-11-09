package kdh57_mvc_beer3.controller.beer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kdh57_mvc_beer3.model.beer.*;

public class BeerController extends HttpServlet implements Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		String RequsetURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequsetURI.substring(contextPath.length());
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		String actionType = request.getParameter("actionType");
		
		BeerDTO beer;
		BeerDAO beerDAO;
		ArrayList<BeerDTO> beerList;
		
		BeerPageInfoVO bpiVO;
		
		
		String select_search;
		String input_search;
		
		if(session.getAttribute("beerPageInfoVO") == null) {
			bpiVO = new BeerPageInfoVO();
			session.setAttribute("beerPageInfoVO", bpiVO);
		}
		else {
			bpiVO = (BeerPageInfoVO)session.getAttribute("beerPageInfoVO");
			System.out.println(bpiVO + "=> bpiVO 실행됨!!!");
		}
		
		
		beerDAO = new BeerDAO();
		boolean result;
		String displayRecordCnt;
		int drc;
		String currentPageNo;
		int cpn;
		
		 switch(actionType) {
		 
	      case "C":
	         beer = new BeerDTO();
	         
	         beer.setB_code(request.getParameter("b_code"));
	         beer.setB_category(request.getParameter("b_category"));
	         beer.setB_name(request.getParameter("b_name"));
	         beer.setB_country(request.getParameter("b_country"));
	         beer.setB_price(Integer.parseInt(request.getParameter("b_price")));
	         beer.setB_alcohol(request.getParameter("b_alcohol"));
	         beer.setB_content(request.getParameter("b_content"));
	         beer.setB_like(0);
	         beer.setB_dislike(0);
	         beer.setB_image("baseImage.jpg");
	         
	         result = beerDAO.insertBeer(beer);
	         
	         if(result == true) {
	            request.getRequestDispatcher("/index.jsp").forward(request, response);
	         } else {
	            request.getRequestDispatcher("/com/yju/2wda/team7/view/etc/error.jsp").forward(request, response);
	         }
	         break;
	   
	      case "R":
	         beerList = beerDAO.getBeerList();
	         
	         request.setAttribute("beerList", beerList);
	         request.getRequestDispatcher("/com/yju/2wda/team7/view/beer/beer_r.jsp").forward(request, response);
	         
	         break;
	         
	      case "R4":
	         currentPageNo = request.getParameter("currentPageNo");
	         cpn = (currentPageNo == null)? 0 : Integer.parseInt(currentPageNo);
	         
	         System.out.println(cpn);
	         
	         bpiVO.setCurrentPageNo(cpn);
	         bpiVO.adjPageInfo();
	         
	         beerList = beerDAO.getBeerListForPage(bpiVO);
	         request.setAttribute("beerList", beerList);
	         request.getRequestDispatcher("/com/yju/2wda/team7/view/beer/beer_r4.jsp").forward(request, response);
	         
	         break;
	         
	      case "R5":
	    	 beer = new BeerDTO();
	         currentPageNo = request.getParameter("currentPageNo");
	         cpn = (currentPageNo == null)? 0 : Integer.parseInt(currentPageNo);
	        
	         bpiVO.setCurrentPageNo(cpn);
	         bpiVO.adjPageInfo();
	         
	         select_search = request.getParameter("select_search"); //(b_code, b_type 등 칼럼명)
        	 input_search = request.getParameter("input_search"); // 실제 입력한 값
        	 
        	 beer.setSelect_search(select_search);
    		 beer.setInput_search(input_search);
    		 
    		 beerList = beerDAO.searchBeer(beer, bpiVO);
        	 
	         request.setAttribute("beerList", beerList);
	         request.getRequestDispatcher("/com/yju/2wda/team7/view/beer/beer_r5.jsp").forward(request, response);
		         
         	break;
         
	      case "SEARCH" :
	    	  beer = new BeerDTO();
	    	  currentPageNo = request.getParameter("currentPageNo");
	    	  
	    	  cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
	    	 
	    	  bpiVO.setCurrentPageNo(cpn);
	    	  bpiVO.adjPageInfo();
	    	  
	    	  // DAO의 메서드로 전달
	    	  select_search = request.getParameter("select_search"); //(b_code, b_type 등 칼럼명)
	    	  input_search = request.getParameter("input_search"); // 실제 입력한 값
	    	 
	    	  System.out.println(select_search + ", " + input_search);
	    	  
	    	 beer.setSelect_search(select_search);
	    	 beer.setInput_search(input_search);
	         	    	 
	    	 beerList = beerDAO.searchBeer(beer, bpiVO);
	    	 
	    	 request.setAttribute("beerList", beerList);
	    	 request.getRequestDispatcher("/com/yju/2wda/team7/view/beer/beer_r5.jsp").forward(request, response);
	    	  
	    	break;
	      
	      case "R_DRC":
	         displayRecordCnt = request.getParameter("displayRecordCnt");
	         drc = (displayRecordCnt == null)? 10:Integer.parseInt(displayRecordCnt);
	         
	         bpiVO.setLimitCnt(drc);
	         bpiVO.setCurrentPageNo(0);
	         bpiVO.adjPageInfo();
	         
	         request.getRequestDispatcher("/index.jsp").forward(request, response);	         
	         break;
	         
	      case "D_ID" :
	    	  int b_id = Integer.parseInt(request.getParameter("b_id"));
	    	  
	    	  result = beerDAO.deleteBeer(b_id);
	    	  
	    	  if(result == true) {
	    		  request.getRequestDispatcher("/com/yju/2wda/team7/BeerController.be?actionType=D").forward(request, response);
	    	  } else {
	    		  request.getRequestDispatcher("/com/yju/2wda/team7/view/etc/error.jsp").forward(request, response);
	    	  }
	    	  break;
	    	  
	      case "D" :
	    	  currentPageNo = request.getParameter("currentPageNo");
	    	  cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
	    	  
	    	  bpiVO.setCurrentPageNo(cpn);
	    	  bpiVO.adjPageInfo();
	    	  
	    	  beerList = beerDAO.getBeerListForPage(bpiVO);
	    	  
	    	  request.setAttribute("beerList", beerList);
	    	  request.getRequestDispatcher("/com/yju/2wda/team7/view/beer/beer_d.jsp").forward(request, response);
	    	  
	    	  break;
	    	  
	      case "U" :
	    	  currentPageNo = request.getParameter("currentPageNo");
	    	  cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
	    	  
	    	  bpiVO.setCurrentPageNo(cpn);
	    	  bpiVO.adjPageInfo();
	    	  
	    	  beerList = beerDAO.getBeerListForPage(bpiVO);
	    	  
	    	  request.setAttribute("beerList", beerList);
	    	  request.getRequestDispatcher("/com/yju/2wda/team7/view/beer/beer_u.jsp").forward(request, response);
	    	  
	    	  break;
	    	  
	      case "U2" :
	    	  b_id = Integer.parseInt(request.getParameter("b_id"));
	    	  beer = beerDAO.getBeer(b_id);
	    	  
	    	  request.setAttribute("beer", beer);
	    	  request.getRequestDispatcher("/com/yju/2wda/team7/view/beer/beer_u2.jsp").forward(request, response);
	    	  
	    	  break;
	    	  
	      case "U_ID" :
	    	  
	    	  beer = new BeerDTO();
	    	  System.out.println("b_id => " + Integer.parseInt(request.getParameter("b_id")));
	    	  
	    	  beer.setB_id(Integer.parseInt(request.getParameter("b_id")));
	    	  beer.setB_code(request.getParameter("b_code"));
	    	  beer.setB_category(request.getParameter("b_category"));
	    	  beer.setB_name(request.getParameter("b_name"));
	    	  beer.setB_country(request.getParameter("b_country"));
	    	  beer.setB_price(Integer.parseInt(request.getParameter("b_price")));
	    	  beer.setB_alcohol(request.getParameter("b_alcohol"));
	    	  beer.setB_content(request.getParameter("b_content"));
	    	  beer.setB_like(Integer.parseInt(request.getParameter("b_like")));
	    	  beer.setB_dislike(Integer.parseInt(request.getParameter("b_dislike")));
	    	  beer.setB_image(request.getParameter("b_image"));
	    	  
	    	  result = beerDAO.updateBeer(beer);
	    	  
	    	  if(result == true) {
	    		  request.getRequestDispatcher("/index.jsp").forward(request, response);
	    	  } else {
	    		  request.getRequestDispatcher("/com/yju/2wda/team7/view/etc/error.jsp").forward(request, response);
	    	  }
	    	  break;
	   }
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
	
}
