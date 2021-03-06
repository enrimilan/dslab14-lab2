package channel;

import java.io.IOException;

import org.bouncycastle.util.encoders.Base64;

/**
 * Messages that are sent are encrypted in Base64, messages that are received are decrypted back.
 */
public class Base64Channel extends ChannelDecorator {

	public Base64Channel(Channel channel) {
		super(channel);
	}
	
	@Override
	public void write(byte[] message) {
		channel.write(Base64.encode(message));
	}

	@Override
	public byte[] read() throws IOException {
		return Base64.decode(channel.read());
	}

	@Override
	public void close() throws IOException {
		channel.close();
	}
}