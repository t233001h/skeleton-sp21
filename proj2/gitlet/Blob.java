package gitlet;

import java.io.File;

import static gitlet.Utils.*;

public class Blob {
    private String filename;
    private byte[] contents;
    private String id;

    public Blob(String filename,File CWD) {
        this.filename = filename;
        File f =join(CWD,filename);
        if(f.exists()) {
            contents =readContents(f);
            id=sha1(filename,contents);
        }
        else {      // 对不存在的文件也进行处理是为了标记删除的情况，确保能正确记录被删除的文件
            contents=null;
            id=sha1(filename);

        }

    }

    public String getFilename() {
        return filename;
    }

    public String getId() {
        return id;
    }
}
