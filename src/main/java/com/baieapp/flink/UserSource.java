package com.baieapp.flink;

import com.baieapp.model.User;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

/**
 * @Author dengmin
 * @Created 2020/3/22 17:22
 */
public class UserSource extends RichSourceFunction<User> {
    private boolean running = true;
    @Override
    public void run(SourceContext<User> sourceContext) throws Exception {
        while (running){

        }
    }

    @Override
    public void cancel() {
        this.running = false;
    }
}
