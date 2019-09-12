package HuaWei;

import java.util.*;
public class Answer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String line2 = line.replaceAll("-{2,}"," ");
        String line3 = line2.replaceAll("[^0-9a-zA-Z\\-]", " ");
        String line6 = line3.replaceAll("[^0-9a-zA-Z]-", " ");
        String line7 = line6.replaceAll("-[^0-9a-zA-Z]", " ");
        String[] line4 = line7.split("\\s+");
        String line5 = "";
        for(int i = line4.length-1; i >=0; i--){
            line5 = line5 + line4[i] + " ";
        }
        System.out.println(line5.trim());
    }
}
