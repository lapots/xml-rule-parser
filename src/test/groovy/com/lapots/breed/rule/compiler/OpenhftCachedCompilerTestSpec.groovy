package com.lapots.breed.rule.compiler

import spock.lang.Specification

class OpenhftCachedCompilerTestSpec extends Specification {

    def "should compile class"() {
        setup:
            def code = this.getClass().getResource("/simple_class.txt").text
            def compiler = new OpenhftCachedCompiler()
        when:
            Class<?> clz = compiler.compile(code, this.getClass().getClassLoader())
        then:
            assert 1 == clz.newInstance().execute() // dynamic has its benefits
    }
}
