package com.picard.protocol.packet;

import lombok.Data;
import com.picard.protocol.Packet;

import static com.picard.protocol.Command.LOGOUT_RESPONSE;


@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;

    public LogoutResponsePacket(){}
    @Override
    public Byte getCommand() {

        return LOGOUT_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}