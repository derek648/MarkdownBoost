import Content.Content;
import InsertTest.InsertTest;
import ParserMarkdown.MarkdownParser;

import java.io.*;

public class demo {
    public static void main(String[] args) throws IOException {

        //1.将markdown文件解析成html文件
        MarkdownParser markdownParser = new MarkdownParser(new File("C:\\Users\\33612\\Desktop\\demo\\01-JUnit单元测试简介.md"));
        String parser = markdownParser.parser();

        //2.生成目录
        Content c = new Content();
        String content = c.addContent(parser);
        System.out.println("生成的目录为：");
        System.out.println(content);

        //向remark文件添加生成的目录
        InsertTest is = new InsertTest();
        is.insertContent("C:\\Users\\33612\\Desktop\\demo\\01-JUnit单元测试简介.md", 0, content);
    }
}
