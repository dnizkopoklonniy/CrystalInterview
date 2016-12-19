package data.message;

/**
 * Model for message.
 */
public class MessageModel {

    /**
     * Root node name for message.
     */
    public static final String MESSAGE_ROOT_NODE = "Message";

    /**
     * Id node for message.
     */
    public static final String MESSAGE_NODE_ID = "Id";

    /**
     * Text node for message.
     */
    public static final String MESSAGE_NODE_TEXT = "Text";

    /**
     * Message id.
     */
    private String id;

    /**
     * Message text.
     */
    private String text;

    /**
     * Default constructor.
     */
    public MessageModel() {
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
}

