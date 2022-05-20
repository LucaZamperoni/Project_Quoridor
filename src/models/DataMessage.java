package models;

import java.util.List;
import lombok.Data;

// Model for all the posible responses that comes in the JSON.
// Another function destructure the JSON.

@Data
public class DataMessage {

    private String opponent;
    private String challenge_id;
    private String game_id;
    private String player_1;
    private String player_2;
    private String score_1;
    private String score_2;
    private String walls;
    private String side;
    private Integer remaining_moves;
    private String turn_token;
    private String board;
    private List<String> users;
    
    private Integer from_row;
    private Integer from_col;
    private Integer to_row;
    private Integer to_col;
    
    private Integer row;
    private Integer col;
    private String orientation;
}

