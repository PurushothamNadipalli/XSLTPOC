package com.xmltojson.saxonica;

import java.io.File;
import java.io.OutputStream;

import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XdmAtomicValue;
import net.sf.saxon.s9api.XsltCompiler;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.s9api.XsltTransformer;

public class Test {
	public static void main(String[] args) throws SaxonApiException{
	    final String XSLT_PATH = "jsontoxml.xsl";
	    final String JSON = "{\"desc\"    : \"Distances between several cities, in kilometers.\",\"updated\" : \"2014-02-04T18:50:45\",\"uptodate\": true,\"author\"  : null,\"cities\"  : {\"Brussels\": [{\"to\": \"London\",    \"distance\": 322},{\"to\": \"Paris\",     \"distance\": 265},{\"to\": \"Amsterdam\", \"distance\": 173}],\"London\": [{\"to\": \"Brussels\",  \"distance\": 322},{\"to\": \"Paris\",     \"distance\": 344},{\"to\": \"Amsterdam\", \"distance\": 358}],\"Paris\": [{\"to\": \"Brussels\",  \"distance\": 265},{\"to\": \"London\",    \"distance\": 344},{\"to\": \"Amsterdam\", \"distance\": 431}],\"Amsterdam\": [{\"to\": \"Brussels\",  \"distance\": 173},{\"to\": \"London\",    \"distance\": 358},{\"to\": \"Paris\",     \"distance\": 431}]}}";
        File file=new File(XSLT_PATH);
	    OutputStream outputStream = System.out;    
	    Processor processor = new Processor(false);    
	    Serializer serializer = processor.newSerializer();
	    serializer.setOutputStream(outputStream);    
	    XsltCompiler compiler = processor.newXsltCompiler();
	    XsltExecutable executable = compiler.compile(new StreamSource(new File(XSLT_PATH)));    
	    XsltTransformer transformer = executable.load();
	    transformer.setInitialTemplate(new QName("init")); 
	    transformer.setParameter(new QName("jsonText"), new 
	    XdmAtomicValue(JSON));
	    transformer.setDestination(serializer);
	    transformer.transform();
	}
}
