package com.lapots.breed.rule.compiler;

import com.lapots.breed.rule.compiler.api.IStringCompiler;
import net.openhft.compiler.CompilerUtils;

import static com.lapots.breed.rule.internal.Constants.CLASS_CODE;
import static com.lapots.breed.rule.internal.Constants.PACKAGE_CODE;

/**
 * OpenHFT compiler.
 */
public class OpenhftCachedCompiler implements IStringCompiler {
    @Override
    public Class<?> compile(String code, ClassLoader classLoader) {
        String className = findClassName(code);
        try {
            return CompilerUtils.CACHED_COMPILER.loadFromJava(classLoader, className, code);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Failed to compile class");
        }
    }

    /**
     * As class body is simple I can find the class name.
     * @param code java code
     * @return class name
     */
    private String findClassName(String code) {
        code = code.trim();
        // TODO:rethink
        String clsPackage =
                code.substring(code.indexOf(PACKAGE_CODE) + PACKAGE_CODE.length(), code.indexOf(";")).trim();
        String className = code.substring(code.indexOf(CLASS_CODE) + CLASS_CODE.length(), code.indexOf("{")).trim();

        return clsPackage + "." + className;
    }
}
