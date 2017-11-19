package priv.lirenhe.test2;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/*    
һ�� html �ĵ��о����кܶ����ӣ�����Щ���ӿ��ܰ���������ַ�����ܲ�������Ҳ������һ����Եĵ�ַ������
<a href="http://www.oschina.net/p/jsoup">jsoup</a>
<a href="/p/jsoup">jsoup</a>
<a href="../jsoup">jsoup</a>
һ�����Ǵ� html �ĵ��н�������Щ���ӣ����ջ�Ҫת�ɵ�һ����ʽ�����ӵ�ַ�����ת���ӵĹ��̻�ͦ���ӵģ�
��Ҫ�������������ĵ�url��ַ�����㡣
�����ʹ�� jsoup �Ļ����ͷǳ����ˣ�jsoup �� attr �����ṩ��һ�� abs: �Ĳ������뿴����Ĵ��룺
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
