/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

import de.audi.atip.testsupport.TestSupportDataReceiverEntry;

public interface ITestSupportDataReceiver {
    public String getName();

    public void entrySelected(int var1);

    public TestSupportDataReceiverEntry[] getEntries();
}

