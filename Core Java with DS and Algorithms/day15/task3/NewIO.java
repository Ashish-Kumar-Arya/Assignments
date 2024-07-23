package assignments.day15.task3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NewIO {
    public static void main(String[] args) throws IOException {
        String sourceFile="/home/ashish/Desktop/names.txt";
        String targetFile="/home/ashish/Desktop/names1.txt";
        FileInputStream fis=new FileInputStream(sourceFile);
        FileOutputStream fos=new FileOutputStream(targetFile);
        FileChannel sChannel=fis.getChannel();
        FileChannel tChannel=fos.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while (sChannel.read(buffer)>0) {
            buffer.flip();
            tChannel.write(buffer);
            buffer.clear();
        }
    }
}
