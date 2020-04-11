package com.spring.lightrain.service.impl;

import com.spring.lightrain.service.VideoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VideoServiceImplTest {

    @Autowired
    VideoService service;

    @Test
    public void findVideo() {
        String a="i am a student";
        String b="i am a stvdent";
        char[] string1=a.toCharArray();
        char[] string2=b.toCharArray();
        int[] index=new int[a.length()];
        int j=0;
        for (int i=0;i<a.length();i++){
            if (string1[i]!=string2[i])
                index[j++]=i;
        }
        j=0;
        for (int i=0;i<a.length();i++){
            if (i==index[j]){
                System.out.print("\""+string2[i]+"\"");
                j++;
            }else
                System.out.print(string1[i]);
        }
    }

    @Test
    public void findAllVideo() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findTeacherAllVideo() {
    }
}