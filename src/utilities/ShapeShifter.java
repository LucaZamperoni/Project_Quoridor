package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.DataMessage;
import models.Message;

// This class is responsible of manipulating everything related to JSON.
public class ShapeShifter {
    
    public static String objectToJSON(Message obj) {
        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        return GSON.toJson(obj, Message.class);
    }

    public static Message JSONToObject(String json) {
        Gson GSON = new GsonBuilder().serializeNulls().create();
        return GSON.fromJson(json, Message.class);
    }

    public static String acceptChallenge(String challenge_id) {
        Message msj = new Message();
        DataMessage dataMsj = new DataMessage();
        msj.setAction(Action.ACCEPT_CHALLENGE.getString());
        dataMsj.setChallenge_id(challenge_id);
        msj.setData(dataMsj);
        return objectToJSON(msj);
    }

    public static String gameover(Message req) {
        String message = objectToJSON(req);
        return message;
    }

    public static String move(Message req, int fromRow, int fromCol, int toRow, int toCol) {
        Message msj = new Message();
        DataMessage dataMsj = new DataMessage();
        msj.setAction(Action.MOVE.getString());
        dataMsj.setGame_id(req.getData().getGame_id());
        dataMsj.setTurn_token(req.getData().getTurn_token());

        dataMsj.setFrom_row(fromRow);
        dataMsj.setFrom_col(fromCol);
        dataMsj.setTo_row(toRow);
        dataMsj.setTo_col(toCol);

        msj.setData(dataMsj);
        return objectToJSON(msj);
    }
    
    public static String wall(Message req, int row, int col, String direction) {
        Message msj = new Message();
        DataMessage dataMsj = new DataMessage();
        msj.setAction(Action.WALL.getString());
        dataMsj.setGame_id(req.getData().getGame_id());
        dataMsj.setTurn_token(req.getData().getTurn_token());
        
        dataMsj.setRow(row);
        dataMsj.setCol(col);
        dataMsj.setOrientation(direction);

        msj.setData(dataMsj);
        return objectToJSON(msj);
    }
}
