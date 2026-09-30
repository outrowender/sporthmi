/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportSession;

public interface ITestSupportSessionHandler {
    public void updateData(TestSupportSession var1);

    public void activateMenuEntry(TestSupportSession var1, boolean var2);

    public void flashText(String var1, long var2);

    public void flashScreen();
}

