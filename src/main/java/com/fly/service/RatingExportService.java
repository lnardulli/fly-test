package com.fly.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class RatingExportService {
    static final String ENDPOINT_TO_DOWNLOAD = "http://localhost:8080/v1/api/export-rating";

    public void download(String fileDownload) {
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(
                    ENDPOINT_TO_DOWNLOAD);

            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            InputStream is = entity.getContent();

            String filePath = "/tmp/exports/" + fileDownload;
            FileOutputStream fos = new FileOutputStream(new File(filePath));

            int inByte;
            while ((inByte = is.read()) != -1) {
                fos.write(inByte);
            }

            is.close();
            fos.close();

            client.close();

            System.out.println("File Download Completed!");
            System.out.println(fileDownload);
            System.out.println("File Download Completed!!!");

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
