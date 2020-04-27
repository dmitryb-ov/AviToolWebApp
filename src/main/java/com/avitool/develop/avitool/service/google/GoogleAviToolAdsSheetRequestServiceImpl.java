package com.avitool.develop.avitool.service.google;

import com.avitool.develop.avitool.dto.AddAdsDto;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class GoogleAviToolAdsSheetRequestServiceImpl implements GoogleAviToolAdsSheetRequestService {
    private static Logger logger = Logger.getLogger(GoogleAviToolAdsSheetRequestServiceImpl.class.getSimpleName());
    private static final String APP_NAME = "avitoolhepler";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKEN_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String FILE_PATH = "/static/credentials.json";
    private static final String spreadSheetId = "1UEHQI5qH5ohM3ocVs618l0efcOAuCUTIqjFkt6KS2jg";

    @Override
    public void sendToAdsSheet(AddAdsDto adsDto) {
        final NetHttpTransport HTTP_TRANSPORT;
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            String range = "Лист1!A1:A";
            Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APP_NAME)
                    .build();
            ValueRange response = service.spreadsheets().values().get(spreadSheetId, range).execute();
            List<List<Object>> values;
            values = Collections.singletonList(Arrays.asList(
                    adsDto.getAccountId(),
                    adsDto.getAccountLogin(),
                    adsDto.getCity(),
                    adsDto.getCategory(),
                    adsDto.getAccountPhoneNumber(),
                    adsDto.getAccountName(),
                    adsDto.getHeader(),
                    adsDto.getText(),
                    adsDto.getPrice(),
                    adsDto.getImgPath(),
                    adsDto.getURLAds(),
                    adsDto.getComment()
            ));
            ValueRange body = new ValueRange()
                    .setMajorDimension("ROWS")
                    .setRange(range)
                    .setValues(values);
            AppendValuesResponse result =
                    service.spreadsheets().values().append(spreadSheetId, range, body)
//                            .setValueInputOption("RAW")
                            .setValueInputOption("USER_ENTERED")
                            .execute();
            logger.info("Add in ads sheet: " + adsDto.getAccountLogin());
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        InputStream in = GoogleAviToolAdsSheetRequestServiceImpl.class.getResourceAsStream(FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets.getDetails()
                .getClientId(), clientSecrets.getDetails().getClientSecret(), SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKEN_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(7777).build();
        //Credential credential = new AuthorizationCodeInstalledApp(flow,receiver).authorize("user");
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
}
