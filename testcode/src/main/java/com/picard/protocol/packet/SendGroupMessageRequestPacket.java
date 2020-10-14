package com.picard.protocol.packet;

import com.picard.protocol.Packet;
import lombok.Data;

import static com.picard.protocol.Command.SEND_GROUP_MESSAGE_REQUEST;

@Data
public class SendGroupMessageRequestPacket extends Packet {

    private String groupId;

    private String message;

    public SendGroupMessageRequestPacket(){}
    @Override
    public Byte getCommand() {
        return SEND_GROUP_MESSAGE_REQUEST;
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
}