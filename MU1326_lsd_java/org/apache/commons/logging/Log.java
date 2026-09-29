/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.logging;

public interface Log {
    default public void debug(Object object) {
    }

    default public boolean isWarnEnabled() {
    }

    default public void warn(Object object) {
    }

    default public void error(Object object) {
    }

    default public void info(Object object) {
    }

    default public boolean isDebugEnabled() {
    }

    default public void error(Object object, Throwable throwable) {
    }

    default public boolean isErrorEnabled() {
    }

    default public boolean isInfoEnabled() {
    }

    default public boolean isFatalEnabled() {
    }

    default public void fatal(Object object, Throwable throwable) {
    }

    default public void warn(Object object, Throwable throwable) {
    }
}

