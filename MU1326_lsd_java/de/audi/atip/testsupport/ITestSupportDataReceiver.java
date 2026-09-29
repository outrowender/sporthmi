/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

import de.audi.atip.testsupport.TestSupportDataReceiverEntry;

public interface ITestSupportDataReceiver {
    default public String getName() {
    }

    default public void entrySelected(int n) {
    }

    default public TestSupportDataReceiverEntry[] getEntries() {
    }
}

