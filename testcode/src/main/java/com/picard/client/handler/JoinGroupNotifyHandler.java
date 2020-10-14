package com.picard.client.handler;

import com.picard.protocol.packet.CreateGroupResponsePacket;
import com.picard.protocol.packet.JoinGroupNotifyPacket;
import com.picard.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
public class JoinGroupNotifyHandler extends SimpleChannelInboundHandler<JoinGroupNotifyPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupNotifyPacket msg) throws Exception {
        String userId = SessionUtil.getSession(ctx.channel()).getUserId();
        if(userId.equals(msg.getUserId()))
            return;
        System.out.println("用户["+msg.getUserId()+"],加入群聊["+msg.getGroupId()+"]");
    }
}