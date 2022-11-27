package me.study.gofdesignpattern.creational_patterns.singleton;

/**
 * enum을 사용하면 깨지지 않는 완전한 싱글턴을 보장한다.
 * 리플랙션과 직렬화&역직렬화 과정에서도 안전하다.
 */
public enum Settings6 {

    INSTANCE;
}
