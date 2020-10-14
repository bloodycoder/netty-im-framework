package com.picard.protocol.packet;

import com.picard.protocol.Packet;

import static com.picard.protocol.Command.JOIN_GROUP_NOTIFY;

public class JoinGroupNotifyPacket extends Packet {
    private String userId;
    private String groupId;
    @Override
    public Byte getCommand() {

        return JOIN_GROUP_NOTIFY;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
