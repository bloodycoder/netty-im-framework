package com.picard.protocol.packet;

import lombok.Data;
import com.picard.protocol.Packet;

import static com.picard.protocol.Command.QUIT_GROUP_REQUEST;

@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_REQUEST;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}