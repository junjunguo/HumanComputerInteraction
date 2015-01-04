/**
 * Created by GuoJunjun on 04.01.15.
 */

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class DownloadFiles {
    /**
     * @param filename
     *         "101153714"
     * @param urllink
     *         "http://static.panoramio.com/photos/large/101153714.jpg"
     * @param filetype
     *         ".jpg"
     * @param location
     *         "/Users/junjun/Downloads"
     *
     * @return process message
     */
    public static String Download(String filename, String urllink, String filetype, String location) {
        String message = "";
        String fileName = filename + filetype;

        URL link = null;
        try {
            link = new URL(urllink);
            InputStream in = new BufferedInputStream(link.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();

            FileOutputStream fos = new FileOutputStream(location + "/" + fileName);
            fos.write(response);
            fos.close();
            message = "done ! " + location + "/" + filename;
        } catch (MalformedURLException e) {
            message = e.getMessage();
        } catch (FileNotFoundException e) {
            message = e.getMessage();
        } catch (IOException e) {
            message = e.getMessage();
        } finally {
            return message;
        }
    }

    //    public static void main(String[] args) {
    //        System.out.println(DownloadFiles.Download("101153714", "http://static.panoramio
    // .com/photos/large/101153714.jpg", ".jpg",
    //                "/Users/junjun/Downloads"));
    //    }
}



