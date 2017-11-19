package priv.lirenhe.test2;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/*    
一个 html 文档中经常有很多链接，而这些链接可能包含主机地址，可能不包含，也可能是一个相对的地址，例如
<a href="http://www.oschina.net/p/jsoup">jsoup</a>
<a href="/p/jsoup">jsoup</a>
<a href="../jsoup">jsoup</a>
一般我们从 html 文档中解析出这些链接，最终还要转成第一种形式的链接地址，这个转链接的过程还挺复杂的，
需要根据所解析的文档url地址来计算。
可如果使用 jsoup 的话，就非常简单了，jsoup 的 attr 方法提供了一个 abs: 的操作，请看下面的代码：
*/

public class JsoupTest04_Attr {
	public static void main(String[] args) throws IOException {
	URL url = new URL("http://www.oschina.net/");   
	Document doc = Jsoup.parse(url, 3*1000);     
	Element link = doc.select("a").first();   
	String relHref = link.attr("href"); // == "/"   
	String absHref = link.attr("abs:href"); // "http://www.oschina.net/"  
	System.out.println(relHref);
	System.out.println(absHref);
	/*
	URL url2 = new URL("http://www.oschina.net/");   
	Document doc2 = Jsoup.parse(url, 3*1000);
	Element link2 = doc.select("a").first(); 
	String relHref2 = link.attr("href"); // == "/" 
	String absHref2 = link.attr("abs:href"); // "http://www.oschina.net/" 
	*/
	}
}
