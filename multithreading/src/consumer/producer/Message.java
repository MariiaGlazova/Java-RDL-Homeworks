package consumer.producer;

public class Message {
    private final int id;
    private final String text;

    public Message(String text, int id) {
        this.text = text;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
