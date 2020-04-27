package com.avitool.develop.avitool.service.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//https://user-agents.net/random
public class GetRandomUserAgents {
    private static FileWriter fw;

    static {
        try {
            fw = new FileWriter(new File("D:\\AppForAvitool\\src\\main\\resources\\htmlpage\\user_agents.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread sleep 5 sek");
            Thread.sleep(TimeUnit.SECONDS.toMillis(2));
            System.out.println("Thread continue");
            Document dirtyDocument = Jsoup.connect("https://user-agents.net/random").get();
            Elements elements = dirtyDocument.select("a[href]");
//            List<String> agentList = new ArrayList<>();
            for (Element element : elements) {
                if (element.text().contains("Mozilla") && element.text().contains("Windows")) {
                    System.out.println(element.text());
//                    agentList.add(element.text());
                    fw.write(element.text() + "\n");
                    System.out.println("Value write");
                }
            }
            fw.flush();
            System.out.println("Values flush");
            System.out.println("PW close");
        }
        fw.close();
    }
}
