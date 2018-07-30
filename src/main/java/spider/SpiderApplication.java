package spider;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Random;

public class SpiderApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

        for (int j = 1; j <=100; j++) {
            String url = "https://www.gushiwen.org/default_"+j+".aspx";
            Document document = Jsoup.connect(url).get();
            Element body = document.body();
            Elements divs = body.select("div.left > div.sons");
            DomParseService parseService = new DomParseService();
            System.out.println("当前第"+j+"页，地址："+url);
            for (int i = 0; i < divs.size(); i++) {
                Element div = divs.get(i);
                PoemEntity poemEntity = parseService.parsePoem(div);
                System.out.println(new Gson().toJson(poemEntity));
                Writer writer = new OutputStreamWriter(new FileOutputStream(new File("/Users/yk/data/"+poemEntity.getTitle().replace("/","|")+".json")));
                writer.write(new Gson().toJson(poemEntity));
                writer.flush();
                writer.close();

            }
            int random = new Random().nextInt(1000)+1000;
            Thread.sleep(random);
            System.out.println("等待："+random+"毫秒");
        }

    }
}
