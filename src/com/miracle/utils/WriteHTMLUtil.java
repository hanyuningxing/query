package com.miracle.utils;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.miracle.common.Constant;


public class WriteHTMLUtil {
	protected static Logger logger = LoggerFactory.getLogger(WriteHTMLUtil.class);
    public static void writeHtm(String dir,String fileName,String value,String charString){
 		File dirFile = null;
 	
 		File file = null;
 		FileOutputStream fos=null;
 		BufferedOutputStream bos=null;
 		DataOutputStream dos =null;
 		String context=Constant.ROOTPATH;
 		logger.error("RootPath"+context);
 		try {
 				    	dirFile = new File(combinePath(context,dir));
 				    	dirFile.setWritable(true,false);
 				    	if (!dirFile.exists()) {
 							dirFile.mkdirs();
 						}
 				 		file = new File(combinePath(context,dir+fileName));
 				 		file.setWritable(true,false);
 				 		if (!file.exists()) {
 				 			file.createNewFile();
 						}
 						fos=new FileOutputStream(file);
 						bos=new BufferedOutputStream(fos);
 						dos=new DataOutputStream(bos);
 					    dos.write(value.getBytes(charString));
 					    dos.flush();
 		}
 		catch (IOException e) {
 			e.printStackTrace();
 			logger.error(e.getMessage());
 		} finally {
 			try {
 				if(null!=dos)dos.flush();
 				if(null!=fos)fos.close();
 				if(null!=bos)bos.close();
 				if(null!=dos)dos.close();
 	 		}
 	 	    catch (IOException e){
 	 			e.printStackTrace();
 	 			logger.error(e.getMessage());
 	 		}   
	   }
 		
 	}
	public static final String combinePath(String base,String child){
        base = base.trim();
        child= child.trim();
        if(base.endsWith("/")||base.endsWith("\\"))
        {
            if(child.startsWith("/")||child.startsWith("\\"))
                return base+ child.substring(1);
            else
                return base+child;
        }
        else{
            if(child.startsWith("/")||child.startsWith("\\") )
                return base+child;
            else
                return base+'/'+child;
        }
    }	
		
}