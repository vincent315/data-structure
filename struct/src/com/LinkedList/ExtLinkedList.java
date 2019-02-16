package com.LinkedList;

public class ExtLinkedList<E> {
    //链表实际存储元素
    private int size;
    //第一个元素，查询
    private Node first;
    //尾巴元素，添加
    private Node last;
    //存储节点的元素
    class Node{
        private Object object;
        //上一个节点node
        private Node prev;
        //下一个结点node
        private Node next;
    }
    //add方法
    public void add(E e){
        Node node = new Node();
        node.object = e;
        if(first == null){
            //添加第一个元素
            //给第一个元素赋值
            first = node;
        }else{
            //添加第二个以上元素
            node.prev = last;
            last.next = node;//是上一个元素的后驱节点
        }
        last = node;
        size ++;
    }
    private void chectElementIndex(int index){
        if(!isElementIndex(index)){
            throw new IndexOutOfBoundsException("查询越界");
        }
    }
    public boolean isElementIndex(int index){
        return index >=0 && index < size;
    }
    public Node getNode(int index){
        Node node = null;
        if(first !=null){
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }
    public Object get(int index){
        chectElementIndex(index);
        return getNode(index).object;
    }

    public void remove(int index){
        chectElementIndex(index);
        //获取当前节点
        Node oldNode = getNode(index);
        if(oldNode != null){
            //2.获取当前元素的上下节点
            Node oldNext = oldNode.next;
            Node oldPrev = oldNode.prev;
            //挂链
            if(oldPrev == null){
                //删除第一个元素
                first = oldNext;
            }else{
                oldPrev.next = oldNext;
                oldNode.prev = null;
            }
            if(oldNext ==null){
                last = oldPrev;
            }else{
                oldNext.prev= oldPrev;
                oldNode.next = null;
            }
            oldNode.object = null;//垃圾回收机制
            size --;
        }
    }
    public void add(int index,E e){
        // 1.循环遍历到当前index位置Node
        // 2.新增当前节点
        Node newNode = new Node();
        newNode.object = e;
        // 获取原来的节点
        Node olNode = getNode(index);
        // 获取原来上一个节点
        Node olNodePrev = olNode.prev;

        // 4.新增节点的上一个还是当前Node节点的 上一个节点,下一个就是原来的节点
        // 原来上一个节点变为当前节点
        olNode.prev = newNode;
        if (olNodePrev == null)
            first = newNode;
        else
            // 原来上一个节点的下一个节点变为当前节点
            olNodePrev.next = newNode;

        // 新节点的下一个节点为原来节点
        newNode.next = olNode;
        size++;
    }


    public static void main(String[] args) {
        ExtLinkedList<String> stringExtLinkedList = new ExtLinkedList<>();
        stringExtLinkedList.add("a");
        stringExtLinkedList.add("b");
        stringExtLinkedList.add("c");
        stringExtLinkedList.add("e");
        System.out.println("删除之前" + stringExtLinkedList.get(0));
        stringExtLinkedList.remove(0);
        System.out.println("删除之后" + stringExtLinkedList.get(0));
    }
}
