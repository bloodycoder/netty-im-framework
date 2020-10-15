package com.picard.protocol.packet;

import com.picard.protocol.Packet;
import lombok.Data;
import static com.picard.protocol.Command.HEART_BEAT_ROUNDTRIP;

@Data
public class HeartBeatRequestPacket extends Packet{
    private boolean success;
    @Override
    public Byte getCommand() {

        return HEART_BEAT_ROUNDTRIP;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}