package ru.spbstu.telematics.lecture11;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

public class NIO {
	public static void main(String[] args) throws Exception {
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.bind(new InetSocketAddress(10000));

		Selector selector = Selector.open();

		System.out.println(channel.validOps() | SelectionKey.OP_ACCEPT);

		channel.configureBlocking(false);
		SelectionKey serverKey = channel.register(selector,
				SelectionKey.OP_ACCEPT);

		while (!Thread.currentThread().isInterrupted()) {
			int num = selector.select();
			System.out.println("I see " + num + " active channels");

			Set<SelectionKey> selectedKeys = selector.selectedKeys();

			for (SelectionKey k : selectedKeys) {
				SelectableChannel c = k.channel();
				if (k.isAcceptable()) {
					SocketChannel client = ((ServerSocketChannel) c).accept();
					if (client != null) {
						client.configureBlocking(false);
						client.register(selector, SelectionKey.OP_READ
								| SelectionKey.OP_WRITE);
					}
				} else {
					ByteBuffer buf = ByteBuffer.allocate(100);
					SocketChannel socket = ((SocketChannel) c);
					int size = socket.read(buf);

					int pos = buf.position();
					System.out.println("Current position is " + pos);
					buf.flip();
					for (int i = 0; i < size; i++) {
						System.out.println(i + ": " + buf.get());
					}
				}

			}

		}
	}
}
