/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.testsupport.ITestSupportDataProvider;
import de.audi.atip.testsupport.ITestSupportSession;
import de.audi.atip.testsupport.NullTestSupportSession;
import de.audi.tghu.smi.SMIOnscreenStatisticsHandler;

class SMIOnscreenStatisticsHandler$SMDataProvider
implements ITestSupportDataProvider {
    private volatile boolean visible;
    private volatile ITestSupportSession session;
    private final String providerName;
    private final int terminalID;
    private final /* synthetic */ SMIOnscreenStatisticsHandler this$0;

    protected SMIOnscreenStatisticsHandler$SMDataProvider(SMIOnscreenStatisticsHandler sMIOnscreenStatisticsHandler, String string, int n) {
        this.this$0 = sMIOnscreenStatisticsHandler;
        this.session = new NullTestSupportSession(-1601830656, SMIOnscreenStatisticsHandler.access$000(sMIOnscreenStatisticsHandler));
        this.providerName = string;
        this.terminalID = n;
    }

    protected void setSession(ITestSupportSession iTestSupportSession) {
        this.session = iTestSupportSession;
    }

    protected synchronized void updateData() {
        if (this.visible) {
            String[] stringArray = SMIOnscreenStatisticsHandler.access$100(this.this$0, this.terminalID);
            this.session.updateData(stringArray);
        }
    }

    @Override
    public synchronized void updateStatus(int n) {
        this.visible = n == 2 || n == 3;
        this.updateData();
    }

    @Override
    public String getDataProviderName() {
        return this.providerName;
    }
}

