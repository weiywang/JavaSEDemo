package netEase;

import java.util.*;

public class WyTest {



    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            int personNumber = sc.nextInt();
            int[] grades = new int[personNumber];
            int[] backupGrades = new int[personNumber];
            List personGrades = new ArrayList<>();
            List<Integer> questions = new ArrayList<>();

            for(int i = 0;i < personNumber;i++){
                int temp = sc.nextInt();
//                personGrades.add(temp);
                grades[i] = temp;
//                System.out.println("test:"+temp);
            }


//            int questionNumber = sc.nextInt();
//            double[] res = new double[questionNumber];
//            for(int i = 0;i < questionNumber;i++){
//                int temp = sc.nextInt();
//                for(int j = 0; j < personNumber; j++){
//                    if(personGrades.){
//
//                    }
//                }
//            }

            backupGrades = grades;
            Arrays.sort(grades);
            personGrades = Arrays.asList(grades);


            int questionNumber = sc.nextInt();
            double[] res = new double[questionNumber];
            for(int i = 0;i < questionNumber;i++){
                int temp = sc.nextInt();
                double tempRes = (double) (personGrades.lastIndexOf(backupGrades[temp])*100) / (double)personNumber;
                System.out.printf("%.6f", tempRes);
//                questions.add(temp);
//                System.out.println("test:"+temp);
            }





        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


// 本题为考试多行输入输出规范示例，无需提交，不计分。
//import java.util.Scanner;
//
//public class Test {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int ans = 0, x;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                x = sc.nextInt();
//                ans += x;
//            }
//        }
//        System.out.println(ans);
//    }
//}


// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
//import java.util.Scanner;
//public class Test {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }
//}