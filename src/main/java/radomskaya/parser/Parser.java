package radomskaya.parser;

import radomskaya.entity.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static Parser instance;

    private Parser(){}

    public static Parser getInstance(){
        if (instance == null){
            instance = new Parser();
        }
        return instance;
    }

    public List<Student> parseXmlFileWithDOM(){
        List<Student> empList = new ArrayList<Student>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse("file/student.xml");
            NodeList nodeList = null;
            if (document != null) {
                nodeList = document.getDocumentElement().getChildNodes();
            }
            parseNodeList(nodeList, empList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return empList;
    }

    private void parseNodeList(NodeList nodeList, List<Student> empList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Student student = new Student();
                String id = node.getAttributes().getNamedItem("id").getNodeValue();
                student.setId(Integer.parseInt(id));

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().
                                getTextContent().trim();
                        String s = cNode.getNodeName();
                        if (s.equals("surname")) {
                            student.setSurname(content);

                        } else if (s.equals("name")) {
                            student.setName(content);

                        } else if (s.equals("middlename")) {
                            student.setMiddleName(content);

                        } else if (s.equals("faculty")) {
                            student.setFaculty(content);

                        } else if (s.equals("group")) {
                            student.setGroup(content);

                        } else if (s.equals("markMath")) {
                            student.setMarkMath(content);

                        } else if (s.equals("markRussian")) {
                            student.setMarkRussian(content);
                        }
                    }
                }
                empList.add(student);
            }
        }
    }
}


