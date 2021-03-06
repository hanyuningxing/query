package com.miracle.utils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.miracle.common.Constant;

public class FileUtils {
	 static final int BUFFER_SIZE = 16 * 1024 ;
	 public static final String path = "/upload/"+DateUtil.getLocalDate("yy-MM")+"/";
	 public static void copy(File src, File dst) throws IOException  {
        	if (!dst.exists()) {
        		 dst.createNewFile();
			}
            InputStream in = null ;
            OutputStream out = null ;
             try  {                
                in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
                out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                 byte [] buffer = new byte [BUFFER_SIZE];
                 while (in.read(buffer) > 0 )  {
                    out.write(buffer);
                } 
             } finally  {
                 if ( null != in)  {
                    in.close();
                } 
                  if ( null != out)  {
                    out.close();
                } 
            } 
    } 
	 public static Boolean checkFileExists(String path) throws IOException  {
		String context=Constant.ROOTPATH;
		File file = new File(combinePath(context,path));
		return file.exists();
         
     } 
	 public static final String combinePath(String base,String child){
	        base = base.trim();
	        child= child.trim();
	        if(base.endsWith("/")||base.endsWith("//"))
	        {
	            if(child.startsWith("/")||child.startsWith("//"))
	                return base+ child.substring(1);
	            else
	                return base+child;
	        }
	        else{
	            if(child.startsWith("/")||child.startsWith("//") )
	                return base+child;
	            else
	                return base+'/'+child;
	        }
	 }	
	 public static boolean isImage(File file) throws IOException{   
	        boolean flag = false;    
	        ImageInputStream is = ImageIO.createImageInputStream(file);   
	        if(null == is){   
	                return flag;   
	        }
	        Iterator iter = ImageIO.getImageReaders(is);
	        if (!iter.hasNext()) {
	        	 return flag;   
	        }
	        ImageReader reader = (ImageReader)iter.next();
	        flag = isImage(reader.getFormatName());
	        is.close();   
	        flag = true;   
	        return flag;   
	}  
	 /**
	 * 判断文件是否为图片文件(GIF,PNG,JPG)
	 * @param srcFileName
	 * @return
	 */
	 public static boolean isImage(String srcFileName) {
		 FileInputStream imgFile = null;
		 byte[] b = new byte[10];
		 int l = -1;
		 try {
		 imgFile = new FileInputStream(srcFileName);
		 l = imgFile.read(b);
		 imgFile.close();
		 } catch (Exception e) {
		 return false;
		 }
		 if (l == 10) {
		 byte b0 = b[0];
		 byte b1 = b[1];
		 byte b2 = b[2];
		 byte b3 = b[3];
		 byte b6 = b[6];
		 byte b7 = b[7];
		 byte b8 = b[8];
		 byte b9 = b[9];
		 if (b0 == (byte) 'G' && b1 == (byte) 'I' && b2 == (byte) 'F') {
		 return true;
		 } else if (b1 == (byte) 'P' && b2 == (byte) 'N' && b3 == (byte) 'G') {
		 return true;
		 } else if (b6 == (byte) 'J' && b7 == (byte) 'F' && b8 == (byte) 'I'&& b9 == (byte) 'F') {
		 return true;
		 } else {
		 return false;
		 }
		 } else {
		 return false;
		 }
	 }
	 
	 public static void contentToTxt(String filePath, String content) {  
	        String str = new String(); //原有txt内容  
	        String s1 = new String();//内容更新  
	        try {  
	            File f = new File(filePath);  
	            if (f.exists()) {  
	                System.out.print("文件存在");  
	            } else {  
	                System.out.print("文件不存在");  
	                f.createNewFile();// 不存在则创建  
	            }  
	            BufferedReader input = new BufferedReader(new FileReader(f));  
	  
	            while ((str = input.readLine()) != null) {  
	                s1 += str + "\n";  
	            }  
	            System.out.println(s1);  
	            input.close();  
	            s1 += content;  
	  
	            BufferedWriter output = new BufferedWriter(new FileWriter(f));  
	            output.write(s1);  
	            output.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	  
	        }  
	    }  
}
