package data.element;

/**
 * Model for element.
 */
public class ElementModel {

    /**
     * Root node name for element.
     */
    public static final String ELEMENT_ROOT_NODE = "Element";

    /**
     * Id node for element.
     */
    public static final String ELEMENT_NODE_ID = "Id";

    /**
     * Path node for element.
     */
    public static final String ELEMENT_NODE_PATH = "Path";

    /**
     * Name node for element.
     */
    public static final String ELEMENT_NODE_NAME = "Name";

    /**
     * Id of link for data store.
     */
    private String id;

    /**
     * XPath of link.
     */
    private String xpath;

    /**
     * Text of link.
     */
    private String text;

    public ElementModel() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}
