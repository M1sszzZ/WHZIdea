package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.branch.service.BranchService;
import com.demo.master.service.MasterService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Reference
	BranchService branchService;

	@Reference
	MasterService masterService;

	@RequestMapping("branch")
	public String branch() {
		String re = branchService.branchTest("consumer请求branch服务");
		return re;
	}

	@RequestMapping("master")
	public String master() {
		String re = masterService.masterTest("consumer请求master服务");
		return re;
	}

}
