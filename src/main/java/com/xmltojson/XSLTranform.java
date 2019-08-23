package com.xmltojson;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTranform {

	public static void main(String[] args) throws Exception {
		Source source;
		StringWriter stringWriter = null;
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			byte[] encoded = Files.readAllBytes(Paths.get("D://xslFile//city.xsl"));

			String dataString = new String(encoded);
			System.out.println("***************" + dataString);
			// byte xslbyte = Byte.valueOf(dataString);
			byte[] bytes = dataString.getBytes();
			System.out.println("*******-------*" + bytes.toString());
			String content = new String(bytes, Charset.defaultCharset());
			source = new StreamSource(new StringReader(content));
			Transformer transformer = factory.newTransformer(source);
			source = new StreamSource(new File("D://xslFile//location.json"));

			stringWriter = new StringWriter();
			StreamResult streamResult = new StreamResult(stringWriter);
			transformer.transform(source, streamResult);
			System.out.println(stringWriter.toString());
			FileWriter fw = new FileWriter("D://xslFile//location.xml");
			fw.write(stringWriter.toString());
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stringWriter.close();
		}

	}
}
