/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

import de.audi.atip.testsupport.ITestSupportDataProvider;
import de.audi.atip.testsupport.ITestSupportDataReceiver;
import de.audi.atip.testsupport.ITestSupportReceiverSession;
import de.audi.atip.testsupport.ITestSupportSession;

public interface ITestSupportService {
    public ITestSupportSession registerDataProvider(ITestSupportDataProvider var1);

    public void deRegisterDataProvider(ITestSupportDataProvider var1);

    public ITestSupportReceiverSession registerDataReceiver(ITestSupportDataReceiver var1);

    public void deRegisterDataReceiver(ITestSupportDataReceiver var1);
}

