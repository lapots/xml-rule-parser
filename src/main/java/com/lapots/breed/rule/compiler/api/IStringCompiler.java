package com.lapots.breed.rule.compiler.api;

/**
 * Interface for string compilers.
 */
public interface IStringCompiler {
    /**
     * Compiles string representation of java code.
     * @param code java code
     * @param classLoader class loader to use
     * @return compiled class instance
     */
    Class<?> compile(String code, ClassLoader classLoader);
}
