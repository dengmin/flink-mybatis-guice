package com.baieapp;

import com.baieapp.properties.PropertiesManager;
import org.apache.flink.api.common.JobExecutionResult;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Author dengmin
 * @Created 2020/3/22 17:16
 */
public class TaskRunner {

    private String[] arg;

    private String jobName;

    public TaskRunner(String[] arg) {
        this.arg = arg;
        this.jobName = PropertiesManager.getString("application.name");
    }

    public JobExecutionResult execute() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        return env.execute(jobName);
    }

}
