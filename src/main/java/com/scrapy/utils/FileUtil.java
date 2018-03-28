package com.scrapy.utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by marico on 2018/2/23.
 */
public class FileUtil {

    public static void write(String jsonStr, String filePath) {
        RandomAccessFile randomFile = null;
        ByteBuffer sendBuffer = null;
        FileChannel inChannel = null;
        try {
            if (!Files.exists(Paths.get(filePath))) {
                Files.createFile(Paths.get(filePath));
            }
            randomFile = new RandomAccessFile(filePath, "rw");
            //获取连接到文件的通道
            inChannel = randomFile.getChannel();
            //将文件定位到结尾
            inChannel.position(inChannel.size());
            //在当前定位的位子上写入内容
            //将内容存入ByteBuffer
            sendBuffer = ByteBuffer.wrap((jsonStr + "\r\n").getBytes("UTF-8"));
            //将ByteBuffer放入文件通道
            inChannel.write(sendBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sendBuffer != null) {
                sendBuffer.clear();
            }

            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                }
            }

            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
