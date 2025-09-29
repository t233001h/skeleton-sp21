package gitlet;
// TODO: any imports you need here
// TODO: You'll likely use this in this class
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.List;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */


    private String commitId;
    private String message;
    private Date timeStamp;
    private HashMap<String,String> blobs;
    private List<String> parents ;
    /* TODO: fill in the rest of this class. */


    public Commit() {
        message = "initial commit";
        timeStamp = new Date(0);
        parents=new ArrayList<>();
        blobs = new HashMap<>();
        commitId = Utils.sha1(message, timeStamp.toString(),parents.toString(),blobs.toString());
        //sha1仅接收字符串和byte[],且传入顺序会影响结果
    }

    public String getCommitId() {
        return commitId;
    }


}
