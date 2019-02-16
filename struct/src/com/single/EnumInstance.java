package com.single;

public enum EnumInstance {
    INSTANCE{
        protected void print(){
            System.out.println("hello");
        }
    };
    protected abstract void print();

    private  Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance(){
        return INSTANCE;
    }
}
