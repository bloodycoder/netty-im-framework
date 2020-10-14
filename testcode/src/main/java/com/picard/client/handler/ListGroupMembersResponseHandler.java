package com.picard.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.picard.protocol.packet.ListGroupMembersResponsePacket;
@ChannelHandler.Sharable
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {
    public static final ListGroupMembersResponseHandler INSTANCE = new ListGroupMembersResponseHandler();
    protected ListGroupMembersResponseHandler(){}
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResponsePacket responsePacket) {
        System.out.println("群[" + responsePacket.getGroupId() + "]中的人包括：" + responsePacket.getSessionList());
    }
}