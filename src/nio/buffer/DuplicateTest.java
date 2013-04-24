package nio.buffer;

import java.nio.ByteBuffer;

public class DuplicateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer buf = ByteBuffer.allocate(10);
		
		buf.put((byte)0).put((byte)1).put((byte)2).put((byte)3).put((byte)4);
		buf.put((byte)5).put((byte)6).put((byte)7).put((byte)8).put((byte)9);
		
		buf.position(3);
		
		buf.limit(9);
		
		buf.mark();
		
		ByteBuffer buf2 = buf.duplicate();
		
		System.out.print("Init Position : " + buf2.position());
		System.out.print(", Init Limit  : " + buf2.limit());
		System.out.println(", Init Capacity : " + buf2.capacity());
		
		buf2.position(7);
		buf2.reset();
		System.out.println("Reset() 후 Position : " + buf2.position());
		
		buf2.clear();
		System.out.print("Position : " + buf2.position());
		System.out.print(", Limit  : " + buf2.limit());
		System.out.println(", Capacity : " + buf2.capacity());
		
		while( buf2.hasRemaining() ) {
			System.out.print(buf2.get());
		}
		
		buf.put(0,(byte)10);
		System.out.println("\n"+"=> buf의 0값을 10으로 변경");
		
		System.out.println("Original Buffer Value : " + buf.get(0));
		System.out.println("Duplicate Buffer Value : " + buf2.get(0));
		
		buf2.put(1,(byte)11);
		System.out.println("=> buf2의 1값을 12로 변경");
		
		System.out.println("Original Buffer Value : " + buf.get(1));
		System.out.println("Duplicate Buffer Value : " + buf2.get(1));
		
	}

}
