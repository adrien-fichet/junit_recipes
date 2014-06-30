package util.coffee_shop;

import util.Money;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class ShopcartBean {
    private SortedSet<ShopcartItemBean> shopcartItems = new TreeSet<ShopcartItemBean>();

    public static ShopcartBean create(ShopcartModel shopcart, CoffeeCatalog catalog) {
        ShopcartBean shopcartBean = new ShopcartBean();

        for (Iterator i = shopcart.items(); i.hasNext();) {
            CoffeeQuantity each = (CoffeeQuantity) i.next();
            String eachCoffeeName = each.getCoffeeName();
            int eachQuantityInKilograms = each.getAmountInKilograms();

            ShopcartItemBean item = new ShopcartItemBean(eachCoffeeName, catalog.getProductId(eachCoffeeName),
                    eachQuantityInKilograms, catalog.getUnitPrice(eachCoffeeName));

            shopcartBean.shopcartItems.add(item);
        }

        return shopcartBean;
    }

    public Money getSubtotal() {
        Money subtotal = new Money(0, 0);

        for (ShopcartItemBean shopcartItem : shopcartItems) {
            ShopcartItemBean eachItem = (ShopcartItemBean) shopcartItem;
            subtotal = subtotal.add(eachItem.getTotalPrice());
        }

        return subtotal;
    }

    public String asXml() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter out = new PrintWriter(stringWriter);
        printXmlOn(out);
        return stringWriter.toString();
    }

    public void printXmlOn(PrintWriter out) {
        out.println("<shopcart>");

        for (Object shopcartItem : shopcartItems) {
            ShopcartItemBean eachItem = (ShopcartItemBean) shopcartItem;
            out.println("<item id=\"" + eachItem.productId + "\">");
            printSimpleTag(out, "name", eachItem.coffeeName);
            printSimpleTag(out, "quantity", eachItem.quantityInKilograms);
            printSimpleTag(out, "unit-price", eachItem.unitPrice);
            printSimpleTag(out, "total-price", eachItem.getTotalPrice());
            out.println("</item>");
        }

        printSimpleTag(out, "subtotal", getSubtotal());
        out.println("</shopcart>");
    }

    public void printSimpleTag(
            PrintWriter out,
            String tagName,
            Object tagValue) {

        out.println(
                "<" + tagName + ">" + tagValue + "</" + tagName + ">");
    }

    public void printSimpleTag(
            PrintWriter out,
            String tagName,
            int tagValue) {

        out.println(
                "<" + tagName + ">" + tagValue + "</" + tagName + ">");
    }
}
