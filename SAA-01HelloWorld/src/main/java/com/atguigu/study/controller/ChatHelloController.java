package com.atguigu.study.controller;


import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatHelloController {

    @Resource // 对话模型，调用阿里云百炼平台
    private ChatModel chatModel;

    @RequestMapping("/callhello")
    public String callhello(@RequestParam(name = "msg",defaultValue = "你是谁？") String msg){
        return chatModel.call(msg);
    }

    @RequestMapping("/streamhello")
    public Flux<String> steamhello(@RequestParam(name = "msg",defaultValue = "给我讲个笑话") String msg) {
        return chatModel.stream(msg);
    }
}
