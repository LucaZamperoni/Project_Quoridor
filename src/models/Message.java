package models;

import lombok.Data;

// Model for the action and event that comes in the response JSON.
// Another function destructure the JSON.

@Data
public class Message {
    private String action;
    private String event;
    private DataMessage data;
}
