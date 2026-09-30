/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport.handler;

import de.audi.atip.testsupport.TestSupportDataReceiverEntry;

public interface ITestSupportHandlerNotification {
    public void debugDataVisible(boolean var1);

    public void commandEntrySelected(int var1);

    public TestSupportDataReceiverEntry[] getCommandEntries();
}

