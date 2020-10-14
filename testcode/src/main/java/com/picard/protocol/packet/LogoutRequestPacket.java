package com.picard.protocol.packet;

import lombok.Data;
import com.picard.protocol.Packet;

import static com.picard.protocol.Command.LOGOUT_REQUEST;


@Data
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}