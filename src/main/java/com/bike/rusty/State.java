package com.bike.rusty;

public interface State<T> {

    String getName();
    void update(T data);
    void entering(T data);
    void exiting(T data);
}
