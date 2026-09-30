/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport.handler;

public interface ITestSupportHandler {
    public void init();

    public void deinit();

    public void updateData(String[] var1);

    public void updateCommandList();
}

