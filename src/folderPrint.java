import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by yx on 2018/8/6.
 */
public class folderPrint {
    private int fileLevel;
    public String createPrintStr(String name, int level) {
        //输出的前缀
        String printStr = "";
        //按层次进行缩进
        for (int i = 0; i < level; i++) {
            printStr = printStr + "  ";
        }
        printStr = printStr + "- " + name;
        return printStr;
    }

    /*
    输出给定的目录
     */
    public void printDir(String dirPath) {
        //将给定的目录进行分割
        String[] dirNameList = dirPath.split("\\\\");
        fileLevel = dirNameList.length;
        // 按格式输出
        for (int i = 0; i < dirNameList.length; i ++) {
            System.out.println(createPrintStr(dirNameList[i], i));
        }
    }
    public void readFile(String dirPath) {
        // 建立当前目录中文件的File对象
        File file = new File(dirPath);
        // 取得代表目录中所有文件的File对象数组
        File[] list = file.listFiles();
        // 遍历file数组
        for (int i = 0; i < list.length; i++) {
            if (list[i].isDirectory()) {
                System.out.println(createPrintStr(list[i].getName(), fileLevel));
                fileLevel ++;
                // 递归子目录
                readFile(list[i].getPath());
                fileLevel --;
            } else {
                System.out.println(createPrintStr(list[i].getName(), fileLevel));
            }
        }
    }

    public static void main(String[] args) {
        folderPrint rd = new folderPrint();
        String dirPath = "D:\\test";
        rd.printDir(dirPath);
        rd.readFile(dirPath);
    }

}

