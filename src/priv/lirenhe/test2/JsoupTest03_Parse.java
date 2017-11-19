package priv.lirenhe.test2;


import java.util.regex.Pattern;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
 
/**
 * @���� Goofy
 * @�ʼ� 252878950@qq.com
 * @���� 2014-4-2����10:41:19
 * @���� ѡ���� ����ʾ��
 */
public class JsoupTest03_Parse {
	 
	public static void main(String[] args) {
		Document doc;
		try {
		//��ȡ�ĵ�
		doc=Jsoup.connect("http://cnblog.com/").get();
		 
		/*****��ȡ��һԪ��******/
		//��JS���Ƶĸ���IDѡ���ѡ����<div id="content"></div>
		Element content = doc.getElementById("site_nav_top");
		System.out.println(content.text());
		 
		/*****һ�·����ķ���ֵ����Elements����******/
		 
		//��ȡ���е�a��ǩ<a href="#"></a>
		content.getElementsByTag("a");
		//��ѡ����<div></div>
		doc.getElementsByClass("divClass");
		//��ȡDocument������Ԫ��
		doc.getAllElements();
		//�������Ի�ȡԪ��<a href="#"></a>
		doc.getElementsByAttribute("href");
		//��������ǰ׺��ȡԪ�� <li data-name="Peter Liu" data-city="ShangHai" data-lang="CSharp" data-food="apple">
		doc.getElementsByAttributeStarting("data-");
		//����key-valueѡ����<a href="http://xdemo.org"></a>
		doc.getElementsByAttributeValue("href","http://xdemo.org");
		//������������෴
		doc.getElementsByAttributeValueNot("href","http://xdemo.org");
		//����key-value,����value������key��Ӧ���Ե�һ�����ַ�����ѡ����<a href="http://xdemo.org"></a>
		doc.getElementsByAttributeValueContaining("href", "xdemo");
		//����key-value,����key��Ӧֵ�Ľ�β��value��ѡ����<a href="http://xdemo.org"></a>
		doc.getElementsByAttributeValueEnding("href", "org");
		//������������෴
		doc.getElementsByAttributeValueStarting("href","http://xdemo");
		//����ƥ�䣬value��Ҫ����������ʽ��<a href="http://xdemo.org"></a>,��href��ֵ���к���
		doc.getElementsByAttributeValueMatching("href",Pattern.compile("[\u4e00-\u9fa5]"));
		//ͬ��
		doc.getElementsByAttributeValueMatching("href", "[\u4e00-\u9fa5]");
		//����Ԫ�����ڵ�z-index��ȡԪ��
		doc.getElementsByIndexEquals(0);
		//��ȡz-index����x��Ԫ��
		doc.getElementsByIndexGreaterThan(0);
		//������������෴
		doc.getElementsByIndexLessThan(10);
		 
		//������ǩ
		for (Element link : content.getElementsByTag("a")) {
		 String linkHref = link.attr("href");
		 String linkText = link.text();
		}
		 
		/**************һЩ�������õķ���**************/
		//��ȡ��ҳ����
		doc.title();
		//��ȡҳ��������ı�
		doc.text();
		 
		//ΪԪ�����һ��css class
		content.addClass("newClass");
		//�������Ի�ȡֵ
		content.attr("id");
		//��ȡ������Ԫ��
		content.children();
		//��ȡԪ���ڵ������ı�
		content.text();
		//��ȡͬ��Ԫ��
		content.siblingElements();
		 
		 
		} catch (Exception e) {
		e.printStackTrace();
		}
		 
	}
	 
}