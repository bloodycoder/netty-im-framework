package com.picard.protocol;

import lombok.Data;
import com.picard.protocol.Packet;

import static com.picard.protocol.Command.LOGOUT_RESPONSE;


@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return LOGOUT_RESPONSE;
    }
}