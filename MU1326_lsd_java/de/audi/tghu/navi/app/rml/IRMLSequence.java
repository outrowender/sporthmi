/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

public interface IRMLSequence {
    public void start();

    public void requestCombinedRouteList(long[] var1, long var2, int var4, int var5, boolean var6);

    public void stop();
}

