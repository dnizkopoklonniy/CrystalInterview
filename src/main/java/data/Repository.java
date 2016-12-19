package data;

import data.element.ElementModel;
import data.element.ElementWrapper;
import data.message.MessageModel;
import data.message.MessageWrapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Repository class for gets data from data store.
 * Data store represents in xml file.
 */
public class Repository {

    /**
     * File path for elements xml data.
     */
    private static final String ELEMENTS_FILE_PATH = "src/main/resources/elements.xml";

    /**
     * File path for messages xml data.
     */
    private static final String MESSAGES_FILE_PATH = "src/main/resources/messages.xml";

    /**
     * data.Repository instance.
     */
    private static Repository repository = null;

    /**
     * List of node elements for cache data.
     */
    private NodeList elements;

    /**
     * List of node messages for cache data.
     */
    private NodeList messages;

    /**
     * Gets repository instance.
     * @return data.Repository instance.
     */
    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }

        return repository;
    }

    private Repository() {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

            File fileElement = new File(ELEMENTS_FILE_PATH);
            File fileMessage = new File(MESSAGES_FILE_PATH);

            Document elementDoc = docBuilder.parse (fileElement);
            Document messageDoc = docBuilder.parse(fileMessage);

            elementDoc.getDocumentElement().normalize();
            elements = elementDoc.getElementsByTagName(ElementModel.ELEMENT_ROOT_NODE);

            messageDoc.getDocumentElement().normalize();
            messages = messageDoc.getElementsByTagName(MessageModel.MESSAGE_ROOT_NODE);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets element model by id.
     * @param id Data store id.
     * @return Null if element model was not found, element model another.
     */
    public ElementModel getElementById(String id) {
        ElementModel elementModel = null;

        for (int i = 0; i < elements.getLength(); i++) {
            Node elementNode = elements.item(i);

            if (elementNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) elementNode;
                String elementId = element
                        .getElementsByTagName(ElementModel.ELEMENT_NODE_ID)
                        .item(0)
                        .getTextContent();

                if (id.equals(elementId)) {
                    elementModel = ElementWrapper.transform(elementNode);
                    break;
                }
            }
        }

        return elementModel;
    }

    /**
     * Gets message text by id from data store.
     * @param id Id from data store.
     * @return Message text.
     */
    public String getMessageTextById(String id) {
        MessageModel messageModel = null;

        for (int i = 0; i < messages.getLength(); i++) {
            Node messageNode = messages.item(i);

            if (messageNode.getNodeType() == Node.ELEMENT_NODE) {
                Element message = (Element) messageNode;
                String messageId = message
                        .getElementsByTagName(ElementModel.ELEMENT_NODE_ID)
                        .item(0)
                        .getTextContent();

                if (id.equals(messageId)) {
                    messageModel = MessageWrapper.transform(messageNode);
                    break;
                }
            }
        }

        if (messageModel == null)
            return null;

        return messageModel.getText();
    }
}
