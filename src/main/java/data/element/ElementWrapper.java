package data.element;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Wrapped Node to ElementModel.
 */
public class ElementWrapper {

    /**
     * Transformed Node to ElementModel.
     * @param node Node.
     * @return ElementModel.
     */
    public static ElementModel transform(Node node) {
        Element element = (Element) node;
        ElementModel elementModel = new ElementModel();

        String id = element
                .getElementsByTagName(ElementModel.ELEMENT_NODE_ID)
                .item(0)
                .getTextContent();

        String path = element
                .getElementsByTagName(ElementModel.ELEMENT_NODE_PATH)
                .item(0)
                .getTextContent();

        String name = element
                .getElementsByTagName(ElementModel.ELEMENT_NODE_NAME)
                .item(0)
                .getTextContent();

        elementModel.setId(id);
        elementModel.setXpath(path);
        elementModel.setText(name);

        return elementModel;
    }
}
