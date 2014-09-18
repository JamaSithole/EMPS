package co.za.ngwane.epms.reports.operations;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.InflaterInputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PDFServlet extends javax.servlet.http.HttpServlet
implements javax.servlet.Servlet {

	static final long serialVersionUID = 1L;

	// The size of the reading block
	private static final int READ_BLOCK = 8192;

	public PDFServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("In PDF Servlet");
	

		ServletInputStream in = req.getInputStream();
		InflaterInputStream iin = new InflaterInputStream(in);

		byte[] content = readAllFromInputStream(iin);

		resp.setContentType("application/pdf");
		resp.flushBuffer();

		resp.getOutputStream().write(content);
		resp.getOutputStream().close();
	}

	private byte[] readAllFromInputStream(InputStream is) throws IOException {

		// create channel for input stream
		ReadableByteChannel bc = Channels.newChannel(is);

		ByteBuffer bb = ByteBuffer.allocate(READ_BLOCK);

		while (bc.read(bb) != -1) {
			// get new buffer for read
			bb = resizeBuffer(bb);
		}

		bb.flip();

		return bb.array();
	}

	private ByteBuffer resizeBuffer(ByteBuffer in) {
		ByteBuffer result = in;

		if (in.remaining() < READ_BLOCK) {
			// create new buffer
			result = ByteBuffer.allocate(in.capacity() * 2);

			// set limit to current position in buffer and set position to zero.
			in.flip();

			// store the content of original buffer to new buffer
			result.put(in);
		}

		return result;

	}
}
