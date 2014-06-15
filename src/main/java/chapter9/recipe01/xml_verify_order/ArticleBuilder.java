package chapter9.recipe01.xml_verify_order;

public class ArticleBuilder {
    private String articleXml = "";

    public ArticleBuilder(String title) {
        articleXml += "<title>" + title + "</title>";
    }

    public void addAuthorName(String authorName) {
        articleXml += "<author>" + authorName + "</author>";
    }

    public void addHeading(String heading) {
        articleXml += "<h1>" + heading + "</h1>";
    }

    public void addParagraph(String paragraph) {
        articleXml += "<p>" + paragraph + "</p>";
    }

    public String toXml() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" ?>");
        stringBuilder.append("<article>" + articleXml + "</article>");
        return stringBuilder.toString();
    }
}
