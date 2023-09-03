package br.com.itcpn.gamescorehub.util;

import br.com.itcpn.gamescorehub.exception.UnexpectedError;

import java.lang.reflect.Field;

public class NonNullFieldsReflection {

    public static void setNonNullFields(Object source, Object target) throws IllegalAccessException {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();
        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true);

            for(Field targetField : targetFields) {
                targetField.setAccessible(true);

                if (sourceField.getName().equals(targetField.getName()) &&
                        sourceField.getType().equals(targetField.getType()) &&
                        sourceField.get(source) != null) {
                    try {
                        targetField.set(target, sourceField.get(source));
                    } catch (IllegalAccessException e) {
                        throw new UnexpectedError("Error while copying non-null fields");
                    }
                }
            }
        }
    }
}
