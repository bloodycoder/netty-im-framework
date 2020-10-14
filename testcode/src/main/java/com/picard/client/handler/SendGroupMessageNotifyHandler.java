package com.picard.client.handler;

import com.picard.protocol.packet.QuitGroupResponsePacket;
import com.picard.protocol.packet.SendGroupMessageNotifyPacket;
import com.picard.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class SendGroupMessageNotifyHandler extends SimpleChannelInboundHandler<SendGroupMessageNotifyPacket> {
    public static final SendGroupMessageNotifyHandler INSTANCE = new SendGroupMessageNotifyHandler();
    protected SendGroupMessageNotifyHandler(){}
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SendGroupMessageNotifyPacket responsePacket) {
        String userId = SessionUtil.getSession(ctx.channel()).getUserId();
        if(userId.equals(responsePacket.getUserId()))
            System.out.print("我");
        else
            System.out.print(responsePacket.getUserId());
        System.out.println(":"+responsePacket.getMessage());
    }
}