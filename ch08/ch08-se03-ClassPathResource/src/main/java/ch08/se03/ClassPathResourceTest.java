package ch08.se03;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ClassPathResourceTest {
    public static void main(String[] args) throws IOException, DocumentException {
        // ClassPathResource可以从类加载路径下读取文件，程序编译后生成的的classes目录是类加载路径之一
        ClassPathResource resource = new ClassPathResource("book.xml");
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
