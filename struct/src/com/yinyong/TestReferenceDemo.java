package com.yinyong;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class TestReferenceDemo {
    public static void main(String[] args) throws Exception {
//        testReference();
//       testSoftReference();
//        testWeakReference();
//        testWeakHashMap();
//        testReferenceQueue();
        testPhantomReference();
    }

    /**
     * 强引用
     */
    public static void testReference(){
        Object oa = new Object();//一个对象实例化
        Object ob = oa;//ob将与oa拥有同样的引用
        //此时 原本oa指向的内存空间 不会成为垃圾空间 因为有ob进行引用
        oa = null;//oa对象已经断开了对原始对象的引用
        System.gc();
        System.out.println(ob);//java.lang.Object@4554617c
    }

    /**
     * 软引用
     */
    public static void testSoftReference(){
        String str = new String("www.cn");
        SoftReference<String> ref = new SoftReference<String>(str);//加入到软引用中
        str  = null;//强引用断开连接
        System.gc();
        System.out.println(ref.get());//不进行手工gcwww.cn   进行手工gc www.cn
        //因为此时空间还很富裕，所以还没有释放
    }

    /**
     * 弱引用
     */
    public static void testWeakReference(){
        String str = new String("www.cn");
        WeakReference<String> ref = new WeakReference<String>(str);//加入到弱引用中
        str  = null;//强引用断开连接
        System.gc();
        System.out.println(ref.get());//不进行手工gcwww.cn   进行手工null

    }
    public static void testWeakHashMap(){
        Map weakHashMap = new WeakHashMap<Integer, String>();
        weakHashMap.put(new Integer(1), new String("A"));
        weakHashMap.put(new Integer(2), new String("B"));
        System.gc();
        System.out.println(weakHashMap);//不进行手工gc {2=B, 1=A} 进行手工gc {}

    }

    /**
     * 引用队列
     */
    public static void testReferenceQueue() throws  Exception{
        String str = new String("hello");
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        WeakReference<String> weak = new WeakReference<String>(str,queue);
        str = null;//断开强引用
        System.out.println(weak.isEnqueued());//此时有内容
        System.gc();
        Thread.sleep(100);
        System.out.println(weak.isEnqueued());
        System.out.println(queue.poll());//观察此时队列里是否有内容
    }
    /**
     * 幽灵引用
     */
    public static void testPhantomReference() throws InterruptedException {
        String str = new String("hello");
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(str,queue);
        str = null;
        System.gc();
        Thread.sleep(200);
        System.out.println(pr.isEnqueued());   //true
        System.out.println(pr.get());  //null
        System.out.println(queue.poll()); //java.lang.ref.PhantomReference@4554617c

    }
}
