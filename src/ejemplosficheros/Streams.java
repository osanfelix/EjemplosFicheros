package ejemplosficheros;

// For 'copyBytes()'
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// For 'copyChars()'
import java.io.FileReader;
import java.io.FileWriter;

// Streams generics
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;


// ENTRADA
// example.txt		==> UTF-8  31 Bytes
// example_ANSI.txt	==> ANSI   29 Bytes

public class Streams
{	
	public static void copyBytes(boolean buffered, String file_in, String file_out) throws IOException
	{
		InputStream in = null;
		OutputStream out = null;

		int counter = 0;
		try {
			in = buffered ? new FileInputStream(file_in)
				: new BufferedInputStream( new FileInputStream(file_in));
			
			out = buffered ? new FileOutputStream(file_out)
			: new BufferedOutputStream( new FileOutputStream(file_out));
			
			int c;	// Number between 0-255 (1 Byte)
			while ((c = in.read()) != -1) {
				out.write(c);
				counter++;
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			System.out.println("Cost: " + counter);
		}
	}
	
	
	// Only change FileInputStream to FileRead
	// Only change FileOutputStream to FileWriter
	public static void copyChars() throws IOException
	{
		FileReader in = null;
		FileWriter out = null;
		int counter = 0;
		try {
			in = new FileReader("example.txt");
			out = new FileWriter("characteroutput.txt");

			int c;	// Number between 0-65535 (2 Bytes)
			while ((c = in.read()) != -1) {
				out.write(c);
				counter++;
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			System.out.println("Cost: " + counter);
		}
	}
}


