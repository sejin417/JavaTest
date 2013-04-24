package nio.buffer;

import java.nio.ByteBuffer;

public class AbsoluteBufferTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer buf = ByteBuffer.allocate(10);
		System.out.print("Init Position : " + buf.position());
		System.out.print(", Init Limit  : " + buf.limit());
		System.out.println(", Init Capacity : " + buf.capacity());

		buf.put(3, (byte)3);
		buf.put(4, (byte)4);
		buf.put(5, (byte)5);
		
		System.out.println("Value : " + buf.get(3) + ", Postion : " + buf.position());
		System.out.println("Value : " + buf.get(4) + ", Postion : " + buf.position());
		System.out.println("Value : " + buf.get(5) + ", Postion : " + buf.position());
		
		System.out.println("Value : " + buf.get(0) + ", Postion : " + buf.position());
	}

}
