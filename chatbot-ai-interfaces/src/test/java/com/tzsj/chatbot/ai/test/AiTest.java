package com.tzsj.chatbot.ai.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AiTest {

    @Test
    public void testAi() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/15555585821212/topics?scope=unanswered_questions&count=20");
//        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/15555585821212/topics?scope=all&count=20");
        httpGet.addHeader("cookie", "zsxq_access_token=AECA52E5-A3DF-B27B-CC29-A4356585739F_C3BD0D930BA19855; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218f08a399a9260-0dda36ec1fbed3-17333270-1327104-18f08a399aa3b%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmMDhhMzk5YTkyNjAtMGRkYTM2ZWMxZmJlZDMtMTczMzMyNzAtMTMyNzEwNC0xOGYwOGEzOTlhYTNiIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218f08a399a9260-0dda36ec1fbed3-17333270-1327104-18f08a399aa3b%22%7D; abtest_env=product; zsxqsessionid=d29ae1b1c3137bd4327a28398cc23d38");
        httpGet.addHeader("Content-type", "application/json; charset=UTF-8");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            String responseInfo = EntityUtils.toString(httpResponse.getEntity());
            System.out.println("哈哈哈哈==========" + responseInfo + "呵呵呵呵呵");

        } else {
            System.out.println("发生异常" + statusCode);
        }

    }

    @Test
    public void testAnswer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/5122551841482244/answer");
        post.addHeader("cookie", "zsxq_access_token=AECA52E5-A3DF-B27B-CC29-A4356585739F_C3BD0D930BA19855; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218f08a399a9260-0dda36ec1fbed3-17333270-1327104-18f08a399aa3b%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmMDhhMzk5YTkyNjAtMGRkYTM2ZWMxZmJlZDMtMTczMzMyNzAtMTMyNzEwNC0xOGYwOGEzOTlhYTNiIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218f08a399a9260-0dda36ec1fbed3-17333270-1327104-18f08a399aa3b%22%7D; abtest_env=product; zsxqsessionid=d29ae1b1c3137bd4327a28398cc23d38");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"去百度一下！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
            System.out.println(111);
        }


    }

}
