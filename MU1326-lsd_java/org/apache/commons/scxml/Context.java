/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.util.Map;

public interface Context {
    default public void set(String string, Object object) {
    }

    default public void setLocal(String string, Object object) {
    }

    default public Object get(String string) {
    }

    default public boolean has(String string) {
    }

    default public Map getVars() {
    }

    default public void reset() {
    }

    default public Context getParent() {
    }
}

