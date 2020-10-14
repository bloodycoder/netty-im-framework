package com.picard.server.handler;

import com.picard.protocol.packet.QuitGroupRequestPacket;
import com.picard.protocol.packet.QuitGroupResponsePacket;
import com.picard.protocol.packet.SendGroupMessageNotifyPacket;
import com.picard.protocol.packet.SendGroupMessageRequestPacket;
import com.picard.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

@ChannelHandler.Sharable
public class SendGroupMessageRequestHandler extends SimpleChannelInboundHandler<SendGroupMessageRequestPacket> {
    public static final SendGroupMessageRequestHandler INSTANCE = new SendGroupMessageRequestHandler();
    protected SendGroupMessageRequestHandler(){}
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SendGroupMessageRequestPacket requestPacket) {
        // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 移除
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);


        // 2. 构造退群响应发送给客户端
        SendGroupMessageNotifyPacket responsePacket = new SendGroupMessageNotifyPacket();
        responsePacket.setGroupId(groupId);
        responsePacket.setMessage(requestPacket.getMessage());
        responsePacket.setUserId(SessionUtil.getSession(ctx.channel()).getUserId());

        //
        channelGroup.writeAndFlush(responsePacket);

    }
}