package com.picard.protocol;

import lombok.Data;
import com.picard.protocol.Packet;
import com.picard.session.Session;

import com.picard.protocol.Packet;

import java.util.List;

import static com.picard.protocol.Command.LIST_GROUP_MEMBERS_RESPONSE;

@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;
    public ListGroupMembersResponsePacket(){}
    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }
}