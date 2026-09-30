/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.ITestSupportReceiverSessionHandler;
import de.audi.app.testsupport.TestSupportBemRecListHandler;
import de.audi.app.testsupport.TestSupportIDGenerator;
import de.audi.app.testsupport.TestSupportReceiverSession;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.ITestSupportDataReceiver;
import de.audi.atip.testsupport.ITestSupportReceiverSession;
import java.util.HashMap;

public class TestSupportReceiverSessionHandler
implements ITestSupportReceiverSessionHandler {
    private final LogChannel logChannel;
    private final TestSupportBemRecListHandler menuHandler;
    private HashMap registeredReceivers = new HashMap();
    private HashMap receiverSessionMapping = new HashMap();
    private final TestSupportIDGenerator idGenerator;
    private final Object mutex = new Object();

    public TestSupportReceiverSessionHandler(TestSupportBemRecListHandler testSupportBemRecListHandler, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.menuHandler = testSupportBemRecListHandler;
        this.idGenerator = new TestSupportIDGenerator();
    }

    public void init() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.idGenerator.reset();
        Object object = this.mutex;
        synchronized (object) {
            this.registeredReceivers.clear();
            this.receiverSessionMapping.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ITestSupportReceiverSession registerDataReceiver(ITestSupportDataReceiver iTestSupportDataReceiver) {
        this.logChannel.log(1000000, "[TestSupportReceiverSessionHandler#registerDataReceiver] receiver '%1' has registered", (Object)iTestSupportDataReceiver.getName());
        Object object = this.mutex;
        synchronized (object) {
            int n = this.idGenerator.getID();
            this.logChannel.log(1000000, "[TestSupportReceiverSessionHandler#registerDataReceiver] using Session-ID '%2' for receiver '%1' internally", (Object)iTestSupportDataReceiver.getName(), (long)n);
            TestSupportReceiverSession testSupportReceiverSession = (TestSupportReceiverSession)this.registeredReceivers.get(new Integer(n));
            if (testSupportReceiverSession != null) {
                this.logChannel.log(100000, "[TestSupportReceiverSessionHandler#registerDataReceiver] receiver '%1' already registered", (Object)iTestSupportDataReceiver);
                return testSupportReceiverSession;
            }
            TestSupportReceiverSession testSupportReceiverSession2 = new TestSupportReceiverSession(iTestSupportDataReceiver, this, this.logChannel, n);
            this.registeredReceivers.put(new Integer(n), testSupportReceiverSession2);
            this.receiverSessionMapping.put(iTestSupportDataReceiver, testSupportReceiverSession2);
            String string = testSupportReceiverSession2.getReceiver().getName();
            this.menuHandler.addReceiverEntry(testSupportReceiverSession2.getID(), string != null && string.length() > 0 ? string : "UNKNOWN RECEIVER, ID: " + n);
            return testSupportReceiverSession2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deRegisterDataReceiver(ITestSupportDataReceiver iTestSupportDataReceiver) {
        this.logChannel.log(1000000, "[TestSupportReceiverSessionHandler#deRegisterDataReceiver] receiver '%1' has de-registered", (Object)iTestSupportDataReceiver.getName());
        Object object = this.mutex;
        synchronized (object) {
            TestSupportReceiverSession testSupportReceiverSession = (TestSupportReceiverSession)this.receiverSessionMapping.get(iTestSupportDataReceiver);
            if (testSupportReceiverSession != null) {
                this.menuHandler.removeReceiverEntry(testSupportReceiverSession.getID());
                this.registeredReceivers.remove(new Integer(testSupportReceiverSession.getID()));
            }
        }
    }

    public void entriesUpdated(int n) {
        this.menuHandler.entriesUpdated(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TestSupportReceiverSession getSession(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return (TestSupportReceiverSession)this.registeredReceivers.get(new Integer(n));
        }
    }
}

