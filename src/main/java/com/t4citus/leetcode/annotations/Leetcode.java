package com.t4citus.leetcode.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Leetcode {
    String title();

    Difficulty difficulty() default Difficulty.NONE;
    String url() default "";

    enum Difficulty { EASY, MEDIUM, HARD, NONE }
}
