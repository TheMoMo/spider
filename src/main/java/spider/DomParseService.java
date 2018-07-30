package spider;

import org.jsoup.nodes.Element;

public class DomParseService {

    public PoemEntity parsePoem(Element div){

        Element cont = div.select("div.cont").first();
        String title= cont.child(1).text();
        Element source = cont.selectFirst("p.source");
        String year = source.select("a").get(0).text();
        String author = source.select("a").get(1).text();
        String poemBody = cont.selectFirst("div.contson").text();
        String tag = div.select("div.tag > a").text();

        return new PoemEntity(title,year,author,poemBody,tag);
    }
}
