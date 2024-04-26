package com.tzsj.chatbot.ai.domain.zsxq.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.tzsj.chatbot.ai.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.tzsj.chatbot.ai.domain.zsxq.service.IZsxqAi;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ZxsqApi implements IZsxqAi {
    @Override
    public UnAnsweredQuestionsAggregates queryUnAnsweredQuestions(String groupId, String cookie) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/" + groupId + "/topics?scope=unanswered_questions&count=20");
//        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/15555585821212/topics?scope=all&count=20");
        httpGet.addHeader("cookie", cookie);
        httpGet.addHeader("Content-type", "application/json; charset=UTF-8");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            String responseInfo = EntityUtils.toString(httpResponse.getEntity());
            UnAnsweredQuestionsAggregates unAnsweredQuestionsList = JSON.parseObject(responseInfo, UnAnsweredQuestionsAggregates.class);
            System.out.println("哈哈哈哈==========" + responseInfo + "呵呵呵呵呵");
            return unAnsweredQuestionsList;
        } else {
            throw new RuntimeException("queryUnAnsweredQuestionsTopicId Err Code is " + statusCode);
        }
    }

    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException {
        return false;
    }
}
