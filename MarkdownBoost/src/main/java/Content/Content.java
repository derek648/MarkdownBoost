package Content;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;

public class Content {

    public Content() {
    }

    //生成目录method
    public String addContent(String html) throws IOException {
        String content = "";

        //加载html文件，并生成doc实例
        Document doc = Jsoup.parse(html);

        //逐行读取html源码并生成对应的内部链接方式
        BufferedReader bf = new BufferedReader(new StringReader(doc.html()));
        Document docLine;

        Element element1;
        Element element2;
        Element element3;
        Element element4;
        Element element5;
        Element element6;

        String line = "";

        int tag1 = 1;
        int tag2 = 1;
        int tag3 = 1;
        int tag4 = 1;
        int tag5 = 1;
        int tag6 = 1;
        while ((line = bf.readLine()) != null) {
            docLine = Jsoup.parse(line);

            //获取一级标签
            if (line.contains("<h1>")) {
                element1 = docLine.getElementsByTag("h1").get(0);
                element1.addClass("no1=" + tag1);
                content += "- <a href=\"#no1=" + tag1 + "\">" + element1.text() + "</a>\n";
                tag1++;
            }

            //获取二级标签
            if (line.contains("<h2>")) {
                element2 = docLine.getElementsByTag("h2").get(0);
                element2.addClass("no2=" + tag2);
                content += "  - <a href=\"#no2=" + tag2 + "\">" + element2.text() + "</a>\n";
                tag2++;
            }

            //获取三级标签
            if (line.contains("<h3>")) {
                element3 = docLine.getElementsByTag("h3").get(0);
                element3.addClass("no3=" + tag3);
                content += "      - <a href=\"#no3=" + tag3 + "\">" + element3.text() + "</a>\n";
                tag3++;
            }

            //获取四级标签
            if (line.contains("<h4>")) {
                System.out.println(line.contains("<h4>"));
                element4 = docLine.getElementsByTag("h4").get(0);
                element4.addClass("no4=" + tag4);
                content += "        - <a href=\"#no4=" + tag4 + "\">" + element4.text() + "</a>\n";
                tag4++;
            }

            //获取五级标签
            if (line.contains("<h5>")) {
                System.out.println(line.contains("<h5>"));
                element5 = docLine.getElementsByTag("h5").get(0);
                element5.addClass("no5=" + tag5);
                content += "        - <a href=\"#no5=" + tag5 + "\">" + element5.text() + "</a>\n";
                tag5++;
            }

            //获取六级标签
            if (line.contains("<h6>")) {
                System.out.println(line.contains("<h6>"));
                element6 = docLine.getElementsByTag("h6").get(0);
                element6.addClass("no6=" + tag6);
                content += "        - <a href=\"#no6=" + tag6 + "\">" + element6.text() + "</a>\n";
                tag6++;
            }

        }
        return content + "\n";
    }
}