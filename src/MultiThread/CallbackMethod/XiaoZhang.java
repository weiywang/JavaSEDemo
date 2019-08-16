package MultiThread.CallbackMethod;


//回答者
public class XiaoZhang extends Thread {
    // 回答1+1，很简单的问题不需要线程
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // 重写run方法
    @Override
    public void run() {
        // 回答地球为什么是圆的
        askquestion();
        super.run();
    }

    // 回调接口的创建，里面要有一个回调方法
    //回调接口什么时候用呢？这个思路是最重要的
    //

    public static interface CallPhone {
        public void call(String questionAnswer);
    }

    // 回调接口的对象
    CallPhone callPhone;

    // 回答地球为什么是圆的
    private void askquestion() {
        System.err.println("开始查找资料！");
        try {
            sleep(3000);// 思考3天
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 把答案返回到回调接口的call方法里面
        if (callPhone!=null) {//提问者实例化callPhone对象，相当于提问者已经告诉我，我到时用什么方式回复答案
            //这个接口的方法实现是在提问者的类里面
            callPhone.call("知道了，！！！~~~~百度有啊");
        }
    }
}
