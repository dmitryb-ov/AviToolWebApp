package com.avitool.develop.avitool.service.util.scripts;
//
//import com.avitool.develop.avitool.dto.UserAgentDto;
//import com.avitool.develop.avitool.models.UserAgent;
//import com.avitool.develop.avitool.service.UserAgentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//
//public class AddUserAgents {
//    @Autowired
//    private UserAgentService userAgentService;
//
//    public void addUserAgents(){
//        try {
//            Scanner scanner = new Scanner(new File("D:\\AppForAvitool\\src\\main\\resources\\htmlpage\\user_agents.txt"));
//            while (scanner.hasNextLine()){
//                if(!scanner.nextLine().isEmpty()){
//                    UserAgentDto userAgent = UserAgentDto.builder()
//                            .userAgentString(scanner.nextLine())
//                            .build();
//                    userAgentService.addUserAgent(userAgent);
//                }
//            }
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//}
