package util;

public class Person {
    private String firstname, lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String toXml() {
        return "<person>" +
                "<firstname>" + firstname + "</firstname>" +
                "<lastname>" + lastname + "</lastname>" +
                "</person>";
    }

    public String toXmlWithWhitespace() {
        return "<person>\n" +
                "\t<firstname>" + firstname + "</firstname>\n" +
                "\t<lastname>" + lastname + "</lastname>\n" +
                "</person>\n";
    }
}
