package data.message;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Wrapped Node to MessageModel.
 */
public class MessageWrapper {

    /**
     * Transformed Node to MessageModel.
     * @param node Node.
     * @return MessageModel.
     */
    public static MessageModel transform(Node node) {
        Element element = (Element) node;
        MessageModel messageModel = new MessageModel();

        String id = element
                .getElementsByTagName(MessageModel.MESSAGE_NODE_ID)
                .item(0)
                .getTextContent();

        String text = element
                .getElementsByTagName(MessageModel.MESSAGE_NODE_TEXT)
                .item(0)
                .getTextContent();

        messageModel.setId(id);
        messageModel.setText(text);

        return messageModel;
    }
}
