package com.nimu.tradermodclient.packets;

public class PacketListener {
    public static String json;
    public static void onReceive(String s){
       PacketCustom packetCustom = PacketCustom.getPacket(s);
        assert packetCustom != null;
        if (packetCustom.id == ID.JSONSHOP.getType()){
           json = packetCustom.mess;
       }
    }
}
