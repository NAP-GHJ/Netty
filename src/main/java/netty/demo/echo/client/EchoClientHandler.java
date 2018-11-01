package netty.demo.echo.client;

// https://github.com/waylau/netty-4-user-guide-demos/tree/master/netty4-demos/src/main/java/com/waylau/netty/demo/echo

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private final String firstMessage;

    public EchoClientHandler() {
        firstMessage = "Hello, I'm client \n";
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Channel read from server: " + msg);
        ctx.write(msg + " \n");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
        System.out.println("Channel read complete");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

}
