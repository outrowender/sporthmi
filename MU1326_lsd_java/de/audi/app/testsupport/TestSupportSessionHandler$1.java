/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportSession;
import de.audi.app.testsupport.TestSupportSessionHandler;

class TestSupportSessionHandler$1
implements Runnable {
    private final /* synthetic */ int val$providerID;
    private final /* synthetic */ TestSupportSession val$session;
    private final /* synthetic */ TestSupportSessionHandler this$0;

    TestSupportSessionHandler$1(TestSupportSessionHandler testSupportSessionHandler, int n, TestSupportSession testSupportSession) {
        this.this$0 = testSupportSessionHandler;
        this.val$providerID = n;
        this.val$session = testSupportSession;
    }

    @Override
    public void run() {
        TestSupportSessionHandler.access$000(this.this$0).log(1078071040, "[TestSupportSessionHandler#registerDataProvider] JOB: setting state of provider '%1' to OSO_VISIBLE, started by VM Parameter", (long)this.val$providerID);
        this.val$session.setStatus(3);
    }
}

