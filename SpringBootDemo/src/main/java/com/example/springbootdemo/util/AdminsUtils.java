package com.example.springbootdemo.util;


import com.example.springbootdemo.entity.Admins;

public abstract class AdminsUtils {
    private static final ThreadLocal<Admins> ADMINS_THREAD_LOCAL = new ThreadLocal<Admins>();

    public static void removeAdmins(){
        ADMINS_THREAD_LOCAL.remove();
    }

    public static void storeAdmins(Admins admins){
        ADMINS_THREAD_LOCAL.set(admins);
    }

    public static Admins getAdmins(){
        return ADMINS_THREAD_LOCAL.get();
    }
    
}
