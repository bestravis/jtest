/**
 * 单例需要注意：
 * 1.构造方法需要加上private
 * 2.多线程下可能会破坏实例，这时需要通过，1 Synchronized 修饰getInstance ，2 classloader 来解决 3双重检查+Synchronized+Volatile
 * 3.如果通过成员变量定义后立马初始化，这时classloader会保证线程安全（类加载时就初始化，浪费内存）
 * 4.即使线程安全了，也要考虑反射，反序列化，克隆的情况
 * 反射：反射创建对象是基于构造方法的，所以在构造方法里判断实例是否创建过，若已存在可报错提示。（加入flag，锁住对象来判断单例的存在与否）https://www.cnblogs.com/call-me-pengye/p/11169051.html
 * 反序列化：不实现序列化 ，如果一定要实现，则重写反序列化的readResolve方法，直接返回现有实例
 * 克隆：重写克隆方法，直接返回现有实例
 *
 */
package design_patterns.singleton;