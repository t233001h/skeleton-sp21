package gitlet;

import java.io.File;
import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public File CWD;
    /** The .gitlet directory. */
    public File GITLET_DIR ;

    public File OBJ_DIR ;
    public File COMMIT_DIR;
    public File BLOB_DIR;

    public File REFS_DIR;
    public File HEADS_DIR;

    public File HEAD;
    public File STAGE;


    public Repository(){
        this.CWD = new File(System.getProperty("user.dir"));
        configDir();
    }

    private void configDir(){
        GITLET_DIR=join(CWD,".gitlet");
        OBJ_DIR=join(GITLET_DIR,"obj");
        COMMIT_DIR=join(OBJ_DIR,"commit");
        BLOB_DIR=join(OBJ_DIR,"blob");
        REFS_DIR=join(GITLET_DIR,"refs");
        HEADS_DIR=join(REFS_DIR,"heads");
        HEAD=join(GITLET_DIR,"head");
        STAGE=join(GITLET_DIR,"stage");

    }

    private boolean isInitialized(){
        return GITLET_DIR.exists()&&GITLET_DIR.isDirectory();
    }

    /* TODO: fill in the rest of this class. */
    public void init(){
        if(isInitialized()){
            System.out.println("A Gitlet version-control system already exists in the current directory.");
            System.exit(0);//failure case:判断GITLET_DIR是否存在
        }

        //创建文件夹
        GITLET_DIR.mkdir();
        OBJ_DIR.mkdir();
        COMMIT_DIR.mkdir();
        BLOB_DIR.mkdir();
        REFS_DIR.mkdir();
        HEADS_DIR.mkdir();
        //创建stage
        writeObject(STAGE,new Stage());

        //创建初始commit
        Commit initComit=new Commit();
        //序列化commit
        writeCommitToFile(initComit);


        //创建分支，分支中写入initCommit的Hash
        String branchName="master";
        File MASTER=join(HEADS_DIR,"master");
        String initCommitId= initComit.getCommitId();
        writeContents(MASTER,initCommitId);

        //创建head的，写入分支名字
        writeContents(HEAD,branchName);
    }
        //.gitlet/
        //├─ objects/          # 存储所有“对象”（Commit、Blob）
        //├─ refs/             # 存储分支、标签的引用（指针）
        //│  └─ heads/         # 存储分支指针（如 main 分支指向哪个 Commit）
        //├─ HEAD              # 指向当前所在的分支（“当前分支的指针”）
        //├─ staging           # 暂存区文件（记录待提交的新增/删除操作）


    public void add(String fileName){//把文件加入stage
        Blob blob=new Blob(fileName,CWD);
        String blobId=blob.getId();
        //获得head处与stage中与需要add的sha1
        Commit head=getHead();
        Stage stage=readObject(STAGE,Stage.class);
        String headId=head.getBlobs().getOrDefault(fileName,"");//bolbs 为HashMap，使用getOrDefault 从文件名查找对应SHA1，若不存在返回DeFault
        String stageId=stage.getAdded().getOrDefault(fileName,"");//

        if(blobId.equals(headId)){//文件内容没变，无需修改
            if(!blobId.equals(stageId)){//stage中文件内容与当前不同，需要修改

            }
        }
        //文件内容变了，再判断stage中是否add过
        else if (!blobId.equals(stageId)) {//需要更新stage

        }


    }


    private void writeCommitToFile(Commit commit){
        File file=new File(COMMIT_DIR,commit.getCommitId());
        writeObject(file,commit);
    }

    private Commit getHead(){
        String branchName=getHeadBranchName();//获得分支名
        File branchFile=getBranchFilefromName(branchName);//从分支名获得分支文件

        //getCommitFromBranchFile
       Commit head=getCommitFromBracnchFile(branchFile);
        return head;
    }

    private String getHeadBranchName(){//获得分支名,

        //注意failure case
        return readContentsAsString(HEAD);
    }

    private File getBranchFilefromName(String branchName){//从分支名获得分支文件


        //failure case

        return join(HEADS_DIR,branchName);
    }

    private Commit getCommitFromBracnchFile(File branchFile){
        String CommitId=readContentsAsString(branchFile);
        return getCommitFromId(CommitId);
    }

    private Commit getCommitFromId(String commitId){
        File commitFile=join(COMMIT_DIR,commitId);
        return readObject(commitFile,Commit.class);
    }

    private Stage readStage(){
        return readObject(STAGE,Stage.class);
    }
}
