package com.hotelapp.cucumber.cucumberTest;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PageHelper {



    public Object createPageObject(String unchangedName, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //Format class name
        String capitalizedName = WordUtils.capitalize(unchangedName);
        String pascalCaseName = capitalizedName.replaceAll("\\s", "");
        String className = "pages." + pascalCaseName;

        //Return class object
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor(WebDriver.class);
        Object pageObject = constructor.newInstance(new Object[] {driver});
        return pageObject;
    }

    public void getMethodAndInvokeNoArgs(Object pageObject, String unchangedMethodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        //Format method name
        String underscoreString = unchangedMethodName.replaceAll("\\s","_");
        String methodName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, underscoreString);
        //Return method object
        Method myMethod = pageObject.getClass().getDeclaredMethod(methodName);
        myMethod.invoke(pageObject);
    }

    public void getMethodAndInvokeWithArgs(Object pageObject, String unchangedMethodName, String data) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Format method name
        String underscoreString = unchangedMethodName.replaceAll("\\s","_");
        String methodName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, underscoreString);
        //Return method object
        Class[] paramString = new Class[1];
        paramString[0] = String.class;
        Method myMethod = pageObject.getClass().getDeclaredMethod(methodName, paramString);
        myMethod.invoke(pageObject, data);
    }
}
