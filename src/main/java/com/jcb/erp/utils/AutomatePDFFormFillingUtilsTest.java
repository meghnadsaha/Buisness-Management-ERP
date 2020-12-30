package com.jcb.erp.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AutomatePDFFormFillingUtilsTest {
	
	private static String html = "<input type=\"hidden\" name=\"sessionValidity\" value=\"2018-09-13T16:28:28Z\">\n"
			+ "<input type=\"hidden\" name=\"shipBeforeDate\" value=\"2018-09-17\"> \n"
			+ "<input type=\"hidden\" name=\"merchantReturnData\" value=\"\"> \n"
			+ "<input type=\"hidden\" name=\"shopperLocale\" value=\"en_GB\"> \n"
			+ "<input type=\"hidden\" name=\"skinCode\" value=\"Ce0xkMuQ\"> \n"
			+ "<input type=\"hidden\" name=\"merchantSig\" value=\"X70xAkOaaAeWGxNgWnTJolmy6/FFoFaBD47IzyBYWf4=\">"

			+"<input id=\"form-check-input\" type=\"checkbox\" name=\"remember\" required=\"\"  >"
			
			
			+ "<span>One</span>"

			+ "<div id =\"test\"></div>";

	public static void main(String[] args) {

		Document document = Jsoup.parse(html);

		Element div = document.getElementById("merchantSig");
		

		// Element.prepend(String first) and Element.append(String last) add
		// HTML to the start or end of an element's inner HTML, respectively
		Element div2 = document.select("div").first(); // <div></div>
		div2.html("<p>lorem ipsum</p>"); // <div><p>lorem ipsum</p></div>
		div2.prepend("<p>First</p>");
		div2.append("<p>Last</p>");
		// now: <div><p>First</p><p>lorem ipsum</p><p>Last</p></div>

		// Element.wrap(String around) wraps HTML around the outer HTML of an
		// element.
		Element span = document.select("span").first(); // <span>One</span>
		span.wrap("<li><a href='http://example.com/'></a></li>");
		// now: <li><a href="http://example.com"><span>One</span></a></li>

		document.select("input[name$=merchantSig]").attr("value", "Ranjan");
		

//		Element div3 = document.getElementById("form-check-input");
//		div3.insertChildren(0, children)("checked");

		
		System.out.println(document.html());
	}

}
