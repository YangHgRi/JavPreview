package com.yanghgri;

import java.util.Scanner;

public class GetCommand {
  private GetCommand() {}

  private static final Scanner SCANNER = new Scanner(System.in);

  public static String getCommand() {
    System.out.println("请输入番号,输入exit退出");
    return SCANNER.nextLine();
  }
}
