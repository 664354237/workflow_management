package com.gx.workflow_management.controller;

import com.gx.workflow_management.service.impl.WorkFlowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 张强
 * @Date: 2023/5/8 17:06
 */
@RestController
@RequestMapping("/workflow")
public class WorkFlow {
    @Autowired
    private WorkFlowServiceImpl workFlowService;

    /**
     * @Description: 接收bpml文件,并且部署流程定义
     * @Parm : [file流程定义文件, bpmnLabel流程定义名称, bpmnType流程定义类型, info流程定义描述]
     */
    @PostMapping
    public Map deploy(MultipartFile file, String bpmnLabel, Integer bpmnType, String info) throws IOException {
        Map map = new HashMap();
        workFlowService.deploy(file, bpmnLabel, bpmnType, info);
        map.put("code", 200);
        map.put("msg", "部署成功");
        return map;
    }

    /**
     * 测试
     */
    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
