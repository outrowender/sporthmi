/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;

public class DefaultTestSupportHandlerNotification
implements ITestSupportHandlerNotification {
    public void debugDataVisible(boolean bl) {
    }

    public void commandEntrySelected(int n) {
    }

    public TestSupportDataReceiverEntry[] getCommandEntries() {
        return new TestSupportDataReceiverEntry[0];
    }
}

