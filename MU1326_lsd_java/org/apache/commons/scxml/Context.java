/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.util.Map;

public interface Context {
    public void set(String var1, Object var2);

    public void setLocal(String var1, Object var2);

    public Object get(String var1);

    public boolean has(String var1);

    public Map getVars();

    public void reset();

    public Context getParent();
}

