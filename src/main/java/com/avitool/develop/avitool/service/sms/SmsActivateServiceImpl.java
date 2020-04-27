package com.avitool.develop.avitool.service.sms;

import com.avitool.develop.avitool.security.jwt.details.ApiKeySms;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SmsActivateServiceImpl implements SmsActivateService {
    private static Logger logger = Logger.getLogger(SmsActivateServiceImpl.class.getSimpleName());
    private static final String API_KEY = ApiKeySms.API_KEY;
    private static final int COUNTRY = 0;
    private static final String OPERATOR = "any";
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final String serviceKey = "av_1";

    @Override
    public String getNumberCount() {
        final String URL = "https://sms-activate.ru/stubs/handler_api.php?api_key=" + API_KEY + "&action=getNumbersStatus&country=" + COUNTRY + "&operator=" + OPERATOR;
        HttpGet request = new HttpGet(URL);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            return parseJson(result);
//                return result;
        } catch (ClientProtocolException e) {
            logger.error("ClientProtocolException: " + e.getMessage(), e.getCause());
            return "Ошибка сервера";
        } catch (IOException e) {
            logger.error("IOException: " + e.getMessage(), e.getCause());
            return "Ошбика сервера";
        }
    }

    @Override
    public String getBalance() {
        final String URL = "https://sms-activate.ru/stubs/handler_api.php?api_key=" + API_KEY + "&action=getBalance";
        final String regex = "(\\d+.\\d+)";
        HttpGet request = new HttpGet(URL);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
//            System.out.println(result);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(result);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return "null";
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return "Ошибка сервера";
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка сервера";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "Ошибка сервера";
        }
    }


    private static String parseJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        String getAviNumberCount = jsonObject.getString(serviceKey);
        return getAviNumberCount;
    }
}
