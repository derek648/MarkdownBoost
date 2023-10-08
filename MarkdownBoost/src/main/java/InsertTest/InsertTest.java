package InsertTest;

import java.io.*;

public class InsertTest {
    //1、校验参数的合法性
    //2、将指针移动到插入的位置
    //3、通过流读取出来写到磁盘文件上(开辟读和写的流)
    //4、将指针重新指定到插入位置
    //5、将写入的内容write写入
    //6、将后续内存重新写入该文件

    //    方法： void seek(long pos) //将文件记录移动到指定的pos位置
    public void insertContent(String path, int index, String cont) {
        //1、校验参数的合法性
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        if (index < 0) {
            return;
        }

        File tmpfile = new File(file.getParent() + file.separator + file.separator + "tmp.txt");
        //新建一个文件tmp.txt来存放需要移动的内容
        RandomAccessFile randomAccessFile = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            randomAccessFile = new RandomAccessFile(path, "rws");
            //2、将指针移动到插入的位置
            randomAccessFile.seek(index);
            //3、通过流读取出来写到磁盘文件上(开辟读和写的流)
            outputStream = new FileOutputStream(tmpfile);
            inputStream = new FileInputStream(tmpfile);
            byte[] bytes = new byte[100];
            int len;
            while ((len = randomAccessFile.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.flush();
            //4、将指针重新指定到插入位置
            randomAccessFile.seek(index);
            //5、将写入的内容write写入
            randomAccessFile.write(cont.getBytes());
            //6、将后续内存重新写入该文件
            while ((len = inputStream.read(bytes)) != -1) {
                randomAccessFile.write(bytes, 0, len);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                //关闭所有的流
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }
}