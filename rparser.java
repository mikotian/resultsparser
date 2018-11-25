import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;
class rparser{

    HashMap<String,Integer> parseresults(List<String> filestoparse)
    {
        HashMap hr=new HashMap<String,Integer>();

        for (String filename : filestoparse) {
            
            try{

            List<String> filecontents=Files.readAllLines(Path.of(filename));
            
            for(String result : filecontents)
            {
                String testName=result.split(",")[0];
                String testResult=result.split(",")[1];

                if(hr.containsKey(testResult)){
                    int count=(int)hr.get(testResult);
                    hr.replace(testResult, count, count+1);
                }
                else{
                    hr.put(testResult,1);
                }
            }
        }catch(FileNotFoundException fn){
            System.out.println(fn.getClass().getName()+" ::: "+fn.getMessage());
        }catch(Exception e){
            System.out.println(e.getClass().getName()+" ::: "+e.getMessage());
        }
        }

        return hr;
    }
    
    public static void main (String[] args)
    {
        rparser rp=new rparser();
        List<String> files=new ArrayList<String>();
        files.add(".\\result1.txt");
        files.add(".\\result2.txt");
        files.add(".\\result3.txt");

        HashMap<String, Integer> hm = rp.parseresults(files);

        hm.keySet().forEach(key -> System.out.println(key+" ::: "+hm.get(key)));

    }

}