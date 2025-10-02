package gitlet;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Stage implements Serializable {
    private Map<String,String> added;   //用Map构建文件名和blobId的映射,<FileName,blobId>
    private Map<String,String> removed;


    public Stage(){
        added = new HashMap<String,String>();
        removed=new HashMap<>();
    }


    public Map<String, String> getAdded() {
        return added;
    }








}
