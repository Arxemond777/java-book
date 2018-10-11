package __some_test;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReadContentsFromUrlAndSave
{
    public static void main(String[] args) throws InterruptedException {

        /*boolean busy = true;
        int i = 0;

        while (busy) {
            System.out.println(new Date().toString());

            if (i > 5) {
                busy = false;
                System.exit(0);
            }

            i++;

            //Thread.currentThread().sleep(1000);
            Thread.currentThread().wait(1000);

        }*/

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        Runnable getContents = new Runnable() {
            public void run() {
                System.out.println("PING!" + new Date());

                /*ReadContentsFromUrlAndSave  readContentsFromUrlAndSave = new ReadContentsFromUrlAndSave();

                try {

                    readContentsFromUrlAndSave.writeToFile(
                            readContentsFromUrlAndSave.getContents("http://example.com/"),
                            null,
                            ("test_" + new Date().toString() + ".txt") . replace(" ", "_")
                    );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }  catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        };
        ses.scheduleAtFixedRate(getContents, 5, 5, TimeUnit.SECONDS);


    }

    private final String defPath = File.separator + "tmp" + File.separator;

    private BufferedReader getContents(String uri) throws MalformedURLException, IOException {
        URL url = new URL(uri);
        URLConnection connection = url.openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        return bufferedReader;
    }

    private void writeToFile(BufferedReader br, String defPath, String fileName) throws IOException {
        if (defPath == null)
            defPath = this.defPath;

        File f = new File(defPath);
        if (!f.exists() || !f.isDirectory())
            try{

                f.mkdir();

            } catch (SecurityException e) {
                System.out.println("Error create Dir");
            }


        String inputLine;
        File file = new File(this.defPath + fileName);

        if (!file.exists())
            file.createNewFile();

        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fileWriter);

        while ((inputLine = br.readLine()) != null)
            bw.write(inputLine);

        bw.close();
        br.close();
    }
}
