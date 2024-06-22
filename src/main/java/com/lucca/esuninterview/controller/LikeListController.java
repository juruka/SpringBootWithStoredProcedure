package com.lucca.esuninterview.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucca.esuninterview.service.LikeListService;
import com.lucca.esuninterview.vo.LikeListRequestVO;

@RestController
public class LikeListController {
	@Autowired
	private LikeListService likeListService;

	@GetMapping(path = "/likelist/query", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUserLikeList(@RequestParam Integer id) {
		return likeListService.showUsersLikeList(id);
	}

	@PostMapping(path = "/likelist/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public String addNewLikeList(@RequestParam Map<String, String> body) {
		LikeListRequestVO likeListVO = new LikeListRequestVO(body);
		likeListService.addNewLikeList(likeListVO);
		return "{success}";
	}

	@PostMapping(path = "/likelist/disable", produces = MediaType.APPLICATION_JSON_VALUE)
	public String disableLikeList(@RequestParam Map<String, String> body) {
		Integer likeSN = new Integer(body.get("sn"));
		likeListService.disableLikeList(likeSN);
		return "{success}";
	}
	
	@PostMapping(path = "/likelist/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateLikeList(@RequestParam Map<String, String> body) {
		LikeListRequestVO likeListVO = new LikeListRequestVO(body);
		likeListService.updateLikeList(likeListVO);
		return "{success}";
	}

}
