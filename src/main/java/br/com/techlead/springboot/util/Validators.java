package br.com.techlead.springboot.util;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class Validators {

    private Set<String> messages;

    private Validators() {
        this.messages = new HashSet<>();
    }

    public static Validators create() {
        return new Validators();
    }

    public Validators notNull(Object value, String msg) {
        if (value == null) messages.add(msg);
        return this;
    }
    
    public Validators notEmpty(String value, String msg) {
        if (value == null || value.isEmpty()) messages.add(msg);
        return this;
    }

    public Validators notEquals(String source, String target, String msg) {
        if (source == null || target == null || !source.equals(target)) messages.add(msg);
        return this;
    }

    public Validators notTrue(Boolean value, String msg) {
        if (!value) messages.add(msg);
        return this;
    }

    public Validators otherwise(Class<? extends RuntimeException> exception) throws RuntimeException {
        if(messages.isEmpty()) return this;

        StringBuilder msg = new StringBuilder(messages.size());
        messages.forEach(message -> msg.append(message + "\n"));

        try {
            throw exception.getDeclaredConstructor(String.class).newInstance(msg.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return this;
    }
}
