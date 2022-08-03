package com.nimu.tradermodclient.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

public class PacketCustom implements IMessage {
    String mess;
    int id;
    public PacketCustom(){}
    public PacketCustom(int id, String mess){
        this.mess = mess;
        this.id = id;
    }
    @Override
    public void fromBytes(ByteBuf buf) {
        String s = buf.toString(StandardCharsets.UTF_8);
        String[] arr = s.split("/",2)[0].split(":",2);
        mess = arr[1];
        id = Integer.parseInt(arr[0]);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, id + ":" + mess);
    }

    public static PacketCustom getPacket(String message){
        String[] mess = message.split(":",2);
        if (mess.length != 2){
            System.out.println("IMPOSSIBLE");
            return null;
        }
        return new PacketCustom(Integer.parseInt(mess[0]), mess[1]);
    }
    public int getId() {
        return id;
    }

    public String getMessage() {
        return mess;
    }
    public void setMessage(String message) {
        this.mess = message;
    }
    @Override
    public String toString(){
        return id + ":" + mess;
    }
    public static class Handler implements IMessageHandler<PacketCustom, IMessage>{

        @Override
        public IMessage onMessage(PacketCustom message, MessageContext ctx) {
            PacketListener.onReceive(message.id + ":" + message.mess);
            return null;
        }
    }
}
