package Log;



import org.apache.log4j.FileAppender;
import reporter.dateTimeConfiguration;

public class NewFileAppender extends FileAppender 
{
	public void setFile(String file) {
        super.setFile(prependDate(file));
    }

    private static String prependDate(String filename) {
        return filename + "_" + dateTimeConfiguration.getDateStamp() + ".log" ;
    }

}
