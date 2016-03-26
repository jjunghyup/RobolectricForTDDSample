package com.example.tdd.runner;

import com.example.tdd.myapplication.LoginHandler;
import com.example.tdd.shadow.ShadowLoginHandler;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;

import java.lang.reflect.Method;

/**
 * Created by cholong on 16. 3. 26..
 */
public class CustomGradleTestRunner extends RobolectricGradleTestRunner {

    public CustomGradleTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public InstrumentationConfiguration createClassLoaderConfig() {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
        builder.addInstrumentedClass(LoginHandler.class.getName());
        return builder.build();
    }
}
