package com.gx.workflow_management.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IWorkFlowService {
    void deploy(MultipartFile file, String bpmnLabel, Integer bpmnType, String info) throws IOException;
}
