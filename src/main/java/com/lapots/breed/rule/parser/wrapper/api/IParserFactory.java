package com.lapots.breed.rule.parser.wrapper.api;

/**
 * Interface for factories.
 * @param <T> parser type interface
 */
public interface IParserFactory<T> {
    /**
     * Returns parser by key.
     * @param key key
     * @return parser
     */
    T getParser(String key);
}
