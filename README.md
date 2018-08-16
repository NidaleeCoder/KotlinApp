# KotlinApp 动手撸一个kotlin开发的app，来学习巩固kotlin知识

####2018.8.15

- kotlin延迟初始化：lateinit var  与 lazy by 的区别 

- kotlin中标准函数的使用：run、with、let、also、apply

###2018.8.16 lambda表达式

优点：语法简洁；与Java良好的互通性，兼容Java8以下使用lambda；真正的闭包

分类：普通lambda表达式，带接收者的lambda表达式

语法：始终使用{}包裹，有实参，有函数体

语法简化：
- 如果最后一个实参是lambda表达式，可以将lambda表达式放在括号外边
- 如果lambda表达式为函数的唯一实参，可以省略括号
- 可以自动推导类型
- 可以使用默认参数名it

返回值：始终未函数体的最后一行

性能优化：要了解lambda表达式的本质，原理。lambda表达式作为参数传递给其他函数，称为高阶函数，这里应声明为内联函数。根据lambda表达式的原理，lambda最终会编译成一个FunctionN的类，调用的时候使用FunctionN的实例调用invoke方法，也就是说，每个lambda表达式编译后都是一个类。如果声明为内联函数，在调用时不会生成FunctionN的类，而是在调用的时候把调用的方法直接给替换上去，降低了性能开销。
