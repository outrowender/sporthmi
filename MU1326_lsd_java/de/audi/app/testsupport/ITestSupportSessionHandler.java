/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportSession;

public interface ITestSupportSessionHandler {
    default public void updateData(TestSupportSession testSupportSession) {
    }

    default public void activateMenuEntry(TestSupportSession testSupportSession, boolean bl) {
    }

    default public void flashText(String string, long l) {
    }

    default public void flashScreen() {
    }
}

