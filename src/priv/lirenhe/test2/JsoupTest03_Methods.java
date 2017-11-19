package priv.lirenhe.test2;

/**
 * 
 */

import java.io.File;
import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
 
/**
 * @���� Goofy
 * @�ʼ� 252878950@qq.com
 * @���� 2014-4-2����10:54:53
 * @���� 
 */
public class JsoupTest03_Methods {
     
    /**
     * ��Stringת����Document
     * @return org.jsoup.nodes.Document
     */
    public static Document parseHtmlFromString(){
        String html = "<html><head><title>����</title></head>"
                + "<body><p>����</p></body></html>";
        Document doc = Jsoup.parse(html);
        return doc;
    }
     
    /**
     * ע�⣺����һ������ȫ�ķ���
     * ��Stringת����HtmlƬ��,ע���ֹ��վ�ű�����
     * @return Element
     */
    public static Element parseHtmlFragmentFromStringNotSafe(){
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        return body;
    }
     
    /**
     * ����һ����ȫ�ķ���
     * ��Stringת����HtmlƬ��,ע���ֹ��վ�ű�����
     * @return Element
     */
    public static Element parseHtmlFragmentFromStringSafe(){
        String html = "<div><p>Lorem ipsum.</p>";
        //�������б�������ЩԪ�غ����Կ���ͨ���������������Ԫ�غ�����һ���Ƴ�
        Whitelist wl=new Whitelist();
        //�Ƚ���ɢ�Ĺ��ˣ�����
        //"a", "b", "blockquote", "br", "caption", "cite", "code", "col",
        //"colgroup", "dd", "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6",
        //"i", "img", "li", "ol", "p", "pre", "q", "small", "strike", "strong",
        //"sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u",
        //"ul"
        Whitelist.relaxed();
        //û���κα�ǩ��ֻ���ı�
        Whitelist.none();
        //����Ĺ�����
        //"a", "b", "blockquote", "br", "cite", "code", "dd", "dl", "dt", "em",
        //"i", "li", "ol", "p", "pre", "q", "small", "strike", "strong", "sub",
        //"sup", "u", "ul"
        Whitelist.basic();
        //����Ĺ�����������һ��img��ǩ
        Whitelist.basicWithImages();
        //�ı����͵ı�ǩ
        //"b", "em", "i", "strong", "u"
        Whitelist.simpleText();
        //���⻹�����Զ�����˹���,����
        wl.addTags("a");
        //ִ�й���
        Jsoup.clean(html, wl);
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        return body;
    }
     
    /**
     * ��URL����
     * @return Document
     */
    public static Document parseDocumentFromUrl(){
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.google.com/").get();
            //��ȡ����
            String title = doc.title();
            System.out.println(title);//�����Google
            //data(key,value)�Ǹ�URLҪ��Ĳ���
            //userAgent�ƶ��û�ʹ�õĴ�������
            //userAgent����--->http://blog.csdn.net/w6299702/article/details/41081225
            //cookie����cookie����cookie("JSESSIONID","FDE234242342342423432432")
            //���ӳ�ʱʱ��
            //post����get����
            doc = Jsoup.connect("http://www.xxxxx.com/")
                      .data("query", "Java")
                      .userAgent("Mozilla")
                      .cookie("auth", "token")
                      .timeout(3000)
                      .post();
             
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
    /**
     * ���ļ�����
     * @return Document
     */
    public static Document parseDocumentFromFile(){
        File input = new File("/tmp/input.html");
        Document doc=null;
        try {
            //���ļ�����Document�ĵ�
            doc = Jsoup.parse(input, "UTF-8");
            System.out.println(doc.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
     
     
 
}
