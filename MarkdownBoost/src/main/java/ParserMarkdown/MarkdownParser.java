package ParserMarkdown;


import org.markdown4j.Markdown4jProcessor;

import java.io.*;

public class MarkdownParser {
    FileInputStream fi = null;
    File file = null;

    public MarkdownParser(File file) {
        this.file = file;
    }


    //将markdown文件转换成html格式
    public String parser() throws IOException {
        //读取markdown文件内容
        String markdownText = "";
        byte[] b = new byte[4096];
        //读取文件内容
        try {
            fi = new FileInputStream(file);
            int len = fi.read(b);
            while (len != -1) {
                markdownText = markdownText + new String(b, 0, len);
                len = fi.read(b);
            }
            fi.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //将Markdown文件解析成html文件
        String html = new Markdown4jProcessor().process(markdownText);

        return html;
    }
}
