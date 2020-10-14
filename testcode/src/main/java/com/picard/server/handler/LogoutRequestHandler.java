package com.picard.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.picard.protocol.packet.LogoutRequestPacket;
import com.picard.protocol.packet.LogoutResponsePacket;
import com.picard.util.SessionUtil;

/**
 * 登出请求
 */
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) {
        SessionUtil.unBindSession(ctx.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(logoutResponsePacket);
    }
}