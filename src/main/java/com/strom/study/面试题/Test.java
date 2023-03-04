package com.strom.study.面试题;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;

public class Test {

  /**
   * 面试题:我们知道文件存储可以存储一些数据，我们现在想要利用文件存储的方法，来构建一类类似于redis 的持久化存储类。
   * 它可以存储不同类型的对象，并且可以设置过期时间，当过期时间到达时，对象会被自动删除或不可访问。
   * 注意，这里的存储对象期望可以是尽可能支持广泛类型的对象，而不仅仅是特定的类型的对象。
   * 请实现以下的DataSave类的saveLoad方法以实现我们的目标，并保iunitest方法中的测试通过。 (可以添加其他的辅助方法及类)
   * 提示:实现以下问题的方法很多，并没有唯一答案，请尽可能是供简洁的实现。我们重点关注代码的可读性和可维护性及思路
   * 提交格式:请提供实现的代码，并且提供运行结果的截图。
   * 斗
   * 
   */

  // 文件存储格式
  static class FileSaveDemo {
    private String key;

    private String jsonFile;

    private String createDate;

    private String expiraTime;

    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getJsonFile() {
      return jsonFile;
    }

    public void setJsonFile(String jsonFile) {
      this.jsonFile = jsonFile;
    }

    public String getCreateDate() {
      return createDate;
    }

    public void setCreateDate(String createDate) {
      this.createDate = createDate;
    }

    public String getExpiraTime() {
      return expiraTime;
    }

    public void setExpiraTime(String expiraTime) {
      this.expiraTime = expiraTime;
    }
  }

  // 数据保存

  public static void DataSave(File file, FileSaveDemo fileSaveDemo) throws IOException {

    FileOutputStream fileOutputStream = new FileOutputStream(file);// 实例化FileOutputStream
    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");// 将字符流转换为字节流
    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);// 创建字符缓冲输出流对象

    // 格式化
    String JsonString = JSON.toJSONString(fileSaveDemo);
    bufferedWriter.write(JsonString);
    bufferedWriter.flush();
    bufferedWriter.close();
  }

  // 数据保存
  public static void saveLoad(Object object, String expTime) throws IOException {
    File file = new File("Test.json");
    if (!file.exists())// 判断文件是否存在，若不存在则新建
    {
      file.createNewFile();
    }

    // 生成存储对象---已json的格式
    FileSaveDemo fileSaveDemo = new FileSaveDemo();
    Random random = new Random();
    fileSaveDemo.setKey(String.valueOf(random.nextInt(1000000)));
    fileSaveDemo.setJsonFile(JSON.toJSONString(object));
    fileSaveDemo.setCreateDate(new Date().toString());
    fileSaveDemo.setExpiraTime(expTime);

    DataSave(file, fileSaveDemo);
  }

  public static void main(String[] args) {
    Map map = new HashMap<>();
  }

}
