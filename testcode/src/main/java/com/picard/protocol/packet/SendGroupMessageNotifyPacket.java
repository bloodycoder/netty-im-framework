package com.picard.protocol.packet;

import com.picard.protocol.Packet;
import lombok.Data;

import static com.picard.protocol.Command.SEND_GROUP_MESSAGE_NOTIFY;

@Data
public class SendGroupMessageNotifyPacket extends Packet {

    private String groupId;

    private String userId;

    private String message;

    public SendGroupMessageNotifyPacket(){}
    @Override
    public Byte getCommand() {
        return SEND_GROUP_MESSAGE_NOTIFY;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}