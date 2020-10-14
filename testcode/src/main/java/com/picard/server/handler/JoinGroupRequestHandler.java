package com.picard.server.handler;
import com.picard.protocol.packet.JoinGroupNotifyPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import com.picard.protocol.packet.JoinGroupRequestPacket;
import com.picard.protocol.packet.JoinGroupResponsePacket;
import com.picard.util.SessionUtil;

public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket requestPacket) {
        // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 添加进去
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.add(ctx.channel());

        // 2. 构造加群响应发送给客户端
        JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();
        responsePacket.setSuccess(true);
        responsePacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(responsePacket);
        //channelGroup.writeAndFlush(responsePacket);
        // 3 notify
        JoinGroupNotifyPacket notifyAll = new JoinGroupNotifyPacket();
        notifyAll.setGroupId(groupId);
        notifyAll.setUserId(SessionUtil.getSession(ctx.channel()).getUserId());
        channelGroup.writeAndFlush(notifyAll);
    }
}