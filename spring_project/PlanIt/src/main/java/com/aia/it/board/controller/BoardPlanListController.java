/*
 * package com.aia.it.board.controller;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.aia.it.board.service.BoardPlanListService;
 * 
 * @Controller public class BoardPlanListController {
 * 
 * @Autowired private BoardPlanListService boardPlanListService;
 * 
 * @RequestMapping("/board/boardWrite") public String getMemberList( Model
 * model,
 * 
 * @RequestParam("uidx") int uidx) {
 * 
 * model.addAttribute("boardPlanListService",
 * boardPlanListService.BoardPlanList(uidx));
 * 
 * return "board/boardWriteForm"; }
 * 
 * }
 */