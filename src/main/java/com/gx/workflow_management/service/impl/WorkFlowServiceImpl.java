package com.gx.workflow_management.service.impl;

import com.gx.workflow_management.service.IWorkFlowService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class WorkFlowServiceImpl implements IWorkFlowService {
    @Autowired
    private RepositoryService repositoryService;


    /**
     * @Description: 接收bpml文件,并且部署流程定义
     * @param file
     * @param bpmnLabel
     * @param bpmnType
     * @param info
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deploy(MultipartFile file, String bpmnLabel, Integer bpmnType, String info) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String extName=originalFilename.substring(originalFilename.indexOf(".")+1);
        //只能上传bpmn格式的流程文件
        Assert.state("bpmn".equalsIgnoreCase(extName),"只能上传bpmn格式的流程文件");


        InputStream in = file.getInputStream();
        //部署到activities
        Deployment deploy = repositoryService.createDeployment().
                addInputStream(originalFilename, in).
                deploy();
        in.close();

        // 查询流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().
                deploymentId(deploy.getId()).singleResult();

        log.info(processDefinition.getKey());
        log.info(processDefinition.getName());
        log.info(processDefinition.getId());
        log.info(processDefinition.getDeploymentId());
        log.info(processDefinition.getVersion()+"");
        log.info(processDefinition.getDiagramResourceName());
        log.info(processDefinition.getResourceName());
        log.info(processDefinition.getTenantId());
        log.info(processDefinition.getDescription());
        log.info(processDefinition.getEngineVersion());
        log.info(processDefinition.getCategory());

//        //存储到bpmnInfo表
//        BusBpmnInfo busBpmnInfo=new BusBpmnInfo();
//        busBpmnInfo.setBpmnLabel(bpmnLabel);
//        busBpmnInfo.setBpmnType(bpmnType);
//        busBpmnInfo.setProcessDefinitionKey(processDefinition.getKey());
//        busBpmnInfo.setVersion(processDefinition.getVersion());
//        busBpmnInfo.setDeployTime(DateUtils.getNowDate());
//        busBpmnInfo.setInfo(info);
//        busBpmnInfoMapper.insertBusBpmnInfo(busBpmnInfo);
    }
}
