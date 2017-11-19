package priv.lirenhe.test1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 1,http://blog.csdn.net/u010814849/article/details/52526582
 * 2,http://www.open-open.com/jsoup/parsing-a-document.htm
 * 3,
 * @author lenovo
 *
 */
public class JsoupTest02 {
	public static void main(String[] args) {
		/*
		String html = "<html><head><title> 开源中国社区 </title></head>"
                + "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.html());
        */
        
		String html = "<div><p>Lorem ipsum.</p>";
		Document doc = Jsoup.parseBodyFragment(html);
		Element body = doc.body();
		System.out.println(body);
//		System.out.println(body.getElementsByTag("div"));
		System.out.println("*************************");
		System.out.println(body.getAllElements());
		
	}

}
