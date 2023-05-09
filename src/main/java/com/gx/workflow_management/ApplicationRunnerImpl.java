package com.gx.workflow_management;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
* @描述: 启动完毕提示
* @作者: 黄鹤松
* @日期: 2023/05/08 15:46
**/

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
       System.out.println("工作流服务启动成功。");
    }
}