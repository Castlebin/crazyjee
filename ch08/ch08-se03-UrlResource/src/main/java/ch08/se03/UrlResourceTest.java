package ch08.se03;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class UrlResourceTest {
    public static void main(String[] args) throws IOException, DocumentException {
        // 在IDE中run程序时，相对的根路径是最顶层project的根目录
        UrlResource resource = new UrlResource("file:ch08/ch08-se03-UrlResource/book.xml");
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

        // 使用SAX进行dom解析
        SAXReader reader = new SAXReader();
        Document document = reader.read(resource.getFile());
        // 获取根元素
        Element element = document.getRootElement();
        List LBooks = element.elements();
        for (Iterator it = LBooks.iterator(); it.hasNext();) {
            Element book = (Element)it.next();
            List LBook = book.elements();
            for (Iterator it2 = LBook.iterator(); it2.hasNext();) {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }
    }
}
