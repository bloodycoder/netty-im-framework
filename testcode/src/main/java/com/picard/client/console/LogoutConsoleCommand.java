package com.picard.client.console;


import io.netty.channel.Channel;
import com.picard.protocol.LogoutRequestPacket;

import java.util.Scanner;

public class LogoutConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}