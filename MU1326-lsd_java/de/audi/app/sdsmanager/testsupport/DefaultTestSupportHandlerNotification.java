/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;

public class DefaultTestSupportHandlerNotification
implements ITestSupportHandlerNotification {
    @Override
    public void debugDataVisible(boolean bl) {
    }

    @Override
    public void commandEntrySelected(int n) {
    }

    @Override
    public TestSupportDataReceiverEntry[] getCommandEntries() {
        return new TestSupportDataReceiverEntry[0];
    }
}

