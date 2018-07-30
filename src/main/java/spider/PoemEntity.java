package spider;

public class PoemEntity {
    private String title;
    private String year;
    private String author;
    private String body;
    private String tag;

    public PoemEntity (){}

    public PoemEntity(String title,String year,String author,String body,String tag) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.body = body;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.tag+":"+ this.title+":" + this.getYear()+":"+this.author+":"+this.body;
    }
}
