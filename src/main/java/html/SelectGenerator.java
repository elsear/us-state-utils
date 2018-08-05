package html;


import configuration.DualConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class SelectGenerator implements Generator {

    private DualConfiguration configuration;

    public SelectGenerator(DualConfiguration configuration) {
        this.configuration = configuration;
    }

    private static Document createDOM() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        return db.newDocument();
    }

    private String transformDOMToString(Document document) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        return writer.getBuffer().toString();
    }

    /**
     * Method to generate specific html select block.
     */
    public String generateHtmlBlock() throws ParserConfigurationException, TransformerException {
        Document document = createDOM();
        Element rootElement = document.createElement("select");
        rootElement.setAttribute("name", "state");
        document.appendChild(rootElement);
        for (String value : configuration.getConfigurationKeys()) {
            Element option = document.createElement("option");
            option.setTextContent(value);
            option.setAttribute("value", value);
            rootElement.appendChild(option);
        }

        return transformDOMToString(document);
    }
}