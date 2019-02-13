package com.example.kson.ksonanotation.butterknife;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ButterKnife {
    public static void bind(Activity activity){
        bindContentView(activity);
        try {
            bindViews(activity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 绑定根布局
     * @param activity
     */
    private static void bindContentView(Activity activity) {

        //

        try {
            Class<?> c = activity.getClass();
            //得到类的注解
            ContentView contentView = c.getAnnotation(ContentView.class);
            if (contentView!=null){
                int layoutId = contentView.value();
                Method method = c.getMethod("setContentView",int.class);
                //执行方法
                method.invoke(activity,layoutId);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 绑定控件
     * @param activity
     */
    private static void bindViews(Activity activity) throws IllegalAccessException {

        Class<?> c = activity.getClass();//字节码对象
        Field[] fields = c.getDeclaredFields();//所有的属性对象
        if (fields!=null&&fields.length>0){
            for (Field field : fields) {
                BindView bindView = field.getAnnotation(BindView.class);
                if (bindView!=null){
                    View view = activity.findViewById(bindView.value());
                    field.setAccessible(true);//允许访问
                    field.set(activity,view);//属性的值是什么？
                }


            }
        }


    }


}
