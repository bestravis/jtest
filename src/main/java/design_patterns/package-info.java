/**
 * 工厂，适合创建复杂对象时
 * 单例：
 *   懒汉式：线程不安全，加Synchronized解决。 但加锁效率会差一些，适合对效率不敏感的场景
 *   饿汉式：线程安全，通过classloader避免了线程安全问题（类加载时就初始化，浪费内存） TODO 补充classloader初始化对象适合的流程
 *   双重检查：线程安全，切记成员变量加上volatile，先检查null，加锁，再检查null。
 *   枚举：
 * 代理
 * 委派
 * 观察者
 * 策略
 * 模板
 */
package design_patterns;