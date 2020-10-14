package com.picard.client.console;

import com.picard.protocol.packet.QuitGroupRequestPacket;
import com.picard.protocol.packet.SendGroupMessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

public class SendGroupMessageConsoleCommand implements ConsoleCommand{
    @Override
    public void exec(Scanner scanner, Channel channel) {
        SendGroupMessageRequestPacket sendMessage = new SendGroupMessageRequestPacket();

        System.out.println("输入 groupId，回车输入要发送的消息");
        String groupId = scanner.next();
        String message = scanner.next();
        sendMessage.setGroupId(groupId);
        sendMessage.setMessage(message);
        channel.writeAndFlush(sendMessage);
    }
}
