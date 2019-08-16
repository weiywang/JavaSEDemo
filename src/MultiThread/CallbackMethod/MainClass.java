package MultiThread.CallbackMethod;

import MultiThread.CallbackMethod.XiaoZhang.CallPhone;


//提问者
public class MainClass {
    /**
     * java回调方法的使用
     * 实际操作时的步骤：（以本实例解释）
     * 1.在回答者的类内创建回调的接口
     * 2.在回答者的类内创建回调接口的对象，
     * 3.在提问者类里面实例化接口对象，重写接口方法
     * 2.-3.这个点很重要，回调对象的实例化，要在提问者的类内实例化，然后重写接口的方法
     * 相当于提问者先把一个联络方式给回答者，回答者找到答案后，通过固定的联络方式，来告诉提问者答案。
     * 4.调用开始新线程的start方法
     * 5.原来的提问者还可以做自己的事
     * */
    public static void main(String[] args) {
        // 小王问小张1+1=？，线程同步
        XiaoZhang xiaoZhang = new XiaoZhang();
        int i = xiaoZhang.add(1, 1);//回答1+1的答案

        // 问小张地球为什么是圆的？回调方法的使用
        //这相当于先定好一个返答案的方式，再来执行实际操作

        // 实例化回调接口的对象
        CallPhone phone = new CallPhone() {
            @Override
            public void call(String question) {
                //回答问题者，回答后，才能输出答案
                System.err.println(question);
            }
        };

        //把回调对象赋值给回答者的回调对象，回答问题者的回调对象才能回答问题
        xiaoZhang.callPhone = phone;
        System.out.println("交代完毕！");

        //相关交代完毕之后再执行查询操作，也就是开始问第二个问题
        xiaoZhang.start();

        //小王做自己的事！
        System.out.println("小王做自己的事！");
    }

}