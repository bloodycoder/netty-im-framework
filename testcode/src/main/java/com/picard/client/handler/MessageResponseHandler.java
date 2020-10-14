package com.picard.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.picard.protocol.packet.MessageResponsePacket;
@ChannelHandler.Sharable
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    public static final MessageResponseHandler INSTANCE = new MessageResponseHandler();
    protected MessageResponseHandler(){}
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket messageResponsePacket) {
        String fromUserId = messageResponsePacket.getFromUserId();
        String fromUserName = messageResponsePacket.getFromUserName();
        System.out.println(fromUserId + ":" + fromUserName + " -> " + messageResponsePacket
                .getMessage());
    }
}