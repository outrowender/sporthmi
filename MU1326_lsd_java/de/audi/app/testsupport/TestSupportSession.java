/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.ITestSupportSessionHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.ITestSupportDataProvider;
import de.audi.atip.testsupport.ITestSupportSession;

public class TestSupportSession
implements ITestSupportSession {
    private volatile int status = 0;
    private final ITestSupportSessionHandler sessionHandler;
    private final LogChannel logChannel;
    private final ITestSupportDataProvider provider;
    private volatile String[] data;
    private final int id;

    protected TestSupportSession(ITestSupportDataProvider iTestSupportDataProvider, ITestSupportSessionHandler iTestSupportSessionHandler, LogChannel logChannel, int n) {
        this.sessionHandler = iTestSupportSessionHandler;
        this.logChannel = logChannel;
        this.provider = iTestSupportDataProvider;
        this.data = new String[0];
        this.id = n;
    }

    public void activateMenuEntry(boolean bl) {
        this.logChannel.log(1000000, "[TestSupportSession#activateMenuEntry] providerID='%2', activate='%1'", bl, (long)this.id);
        this.sessionHandler.activateMenuEntry(this, bl);
    }

    public void flashText(String string, long l) {
        this.logChannel.log(1000000, "[TestSupportSession#flashText] providerID='%1'", (long)this.id);
        this.sessionHandler.flashText(string, l);
    }

    public void flashScreen() {
        this.logChannel.log(1000000, "[TestSupportSession#flashScreen] providerID='%1'", (long)this.id);
        this.sessionHandler.flashScreen();
    }

    public void updateData(String[] stringArray) {
        this.logChannel.log(1000000, "[TestSupportSession#updateData] providerID='%1'", (long)this.id);
        this.data = stringArray;
        this.sessionHandler.updateData(this);
    }

    public int getStatus() {
        return this.status;
    }

    public int getID() {
        return this.id;
    }

    protected void setStatus(int n) {
        this.logChannel.log(1000000, "[TestSupportSession#setStatus] status for providerID='%1' set to '%2'", (long)this.id, (long)n);
        this.status = n;
        this.provider.updateStatus(n);
    }

    protected ITestSupportDataProvider getProvider() {
        return this.provider;
    }

    protected String[] getData() {
        if (this.data == null) {
            return new String[0];
        }
        return this.data;
    }
}

