package ua.yakov.sockets;

import java.util.Date;

public class OutputMessage {
    private String content;

    public OutputMessage() {
    }

    public OutputMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
