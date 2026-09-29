/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.ITestSupportReceiverSessionHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.ITestSupportDataReceiver;
import de.audi.atip.testsupport.ITestSupportReceiverSession;

public class TestSupportReceiverSession
implements ITestSupportReceiverSession {
    private final ITestSupportDataReceiver receiver;
    private final ITestSupportReceiverSessionHandler sessionHandler;
    private final LogChannel logChannel;
    private final int id;

    public TestSupportReceiverSession(ITestSupportDataReceiver iTestSupportDataReceiver, ITestSupportReceiverSessionHandler iTestSupportReceiverSessionHandler, LogChannel logChannel, int n) {
        this.receiver = iTestSupportDataReceiver;
        this.sessionHandler = iTestSupportReceiverSessionHandler;
        this.logChannel = logChannel;
        this.id = n;
    }

    public int getID() {
        return this.id;
    }

    public ITestSupportDataReceiver getReceiver() {
        return this.receiver;
    }

    @Override
    public void entriesUpdated() {
        this.sessionHandler.entriesUpdated(this.id);
    }
}

