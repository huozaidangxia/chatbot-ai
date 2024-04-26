package com.tzsj.chatbot.ai.domain.zsxq.service;

import com.tzsj.chatbot.ai.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

public interface IZsxqAi {
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestions(String groupId, String cookie) throws IOException;
    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}
