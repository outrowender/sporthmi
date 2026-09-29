/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

import de.audi.atip.testsupport.ITestSupportDataProvider;
import de.audi.atip.testsupport.ITestSupportDataReceiver;
import de.audi.atip.testsupport.ITestSupportReceiverSession;
import de.audi.atip.testsupport.ITestSupportSession;

public interface ITestSupportService {
    default public ITestSupportSession registerDataProvider(ITestSupportDataProvider iTestSupportDataProvider) {
    }

    default public void deRegisterDataProvider(ITestSupportDataProvider iTestSupportDataProvider) {
    }

    default public ITestSupportReceiverSession registerDataReceiver(ITestSupportDataReceiver iTestSupportDataReceiver) {
    }

    default public void deRegisterDataReceiver(ITestSupportDataReceiver iTestSupportDataReceiver) {
    }
}

