package com.picard.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.picard.protocol.packet.LogoutResponsePacket;
import com.picard.util.SessionUtil;
@ChannelHandler.Sharable
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {
    public static final LogoutResponseHandler INSTANCE = new LogoutResponseHandler();
    protected LogoutResponseHandler(){}
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket logoutResponsePacket) {
        SessionUtil.unBindSession(ctx.channel());
    }
}