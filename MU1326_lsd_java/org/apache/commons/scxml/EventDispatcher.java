/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.util.List;
import java.util.Map;

public interface EventDispatcher {
    public void cancel(String var1);

    public void send(String var1, String var2, String var3, String var4, Map var5, Object var6, long var7, List var9);
}

