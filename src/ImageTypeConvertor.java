import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;

public class ImageTypeConvertor {
	public static void main(String args[]) throws TranscoderException, IOException{
		JPEGTranscoder myTranscoder=new JPEGTranscoder();
		
		myTranscoder.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, new Float(.8));
		String svgUri=new File("2016_gybe_front5000_landskroon.svg").toURL().toString();
		TranscoderInput input=new TranscoderInput(svgUri);
		
		OutputStream myOutputStream=new FileOutputStream("out.jpg");
		TranscoderOutput output=new TranscoderOutput(myOutputStream);
		
		myTranscoder.transcode(input, output);
		
		myOutputStream.flush();
		myOutputStream.close();
		
		
	}
}
