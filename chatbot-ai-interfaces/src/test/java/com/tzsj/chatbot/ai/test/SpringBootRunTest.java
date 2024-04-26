package com.tzsj.chatbot.ai.test;

import cn.tzsj.chatbot.ai.AiApplication;
import com.tzsj.chatbot.ai.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.tzsj.chatbot.ai.domain.zsxq.model.vo.Topics;
import com.tzsj.chatbot.ai.domain.zsxq.service.IZsxqAi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-ai.group01.groupId}")
    private String groupId;
    @Value("${chatbot-ai.group01.cookie}")
    private String cookie;


    @Resource
    private IZsxqAi zsxqAi;

    @Test
    public void test_zsxqAi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqAi.queryUnAnsweredQuestions(null, null);

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            int topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId：{} text：{}", topicId, text);
            System.out.println("topicId==="+ topicId);
            System.out.println("text"+ text);
        }
    }

}
