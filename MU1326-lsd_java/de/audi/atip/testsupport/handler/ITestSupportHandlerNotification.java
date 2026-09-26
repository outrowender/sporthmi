/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport.handler;

import de.audi.atip.testsupport.TestSupportDataReceiverEntry;

public interface ITestSupportHandlerNotification {
    default public void debugDataVisible(boolean bl) {
    }

    default public void commandEntrySelected(int n) {
    }

    default public TestSupportDataReceiverEntry[] getCommandEntries() {
    }
}

