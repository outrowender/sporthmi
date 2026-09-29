/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap.sos;

import de.audi.app.ecall.core.bap.sos.ScreenContext;

public final class ScreenContext$Builder {
    private int connectingScreen;
    private int connectedScreen;
    private int callBackIncomingScreen;
    private int sendingDataScreen;
    private int accomplishedScreen;
    private int failedScreen;
    private int canceledScreen;
    private int redialScreen;

    public ScreenContext$Builder setConnectingScreen(int n) {
        this.connectingScreen = n;
        return this;
    }

    public ScreenContext$Builder setConnectedScreen(int n) {
        this.connectedScreen = n;
        return this;
    }

    public ScreenContext$Builder setCallBackIncomingScreen(int n) {
        this.callBackIncomingScreen = n;
        return this;
    }

    public ScreenContext$Builder setSendingDataScreen(int n) {
        this.sendingDataScreen = n;
        return this;
    }

    public ScreenContext$Builder setAccomplishedScreen(int n) {
        this.accomplishedScreen = n;
        return this;
    }

    public ScreenContext$Builder setFailedScreen(int n) {
        this.failedScreen = n;
        return this;
    }

    public ScreenContext$Builder setCanceledScreen(int n) {
        this.canceledScreen = n;
        return this;
    }

    public ScreenContext$Builder setRedialScreen(int n) {
        this.redialScreen = n;
        return this;
    }

    public ScreenContext build() {
        return new ScreenContext(this.connectingScreen, this.connectedScreen, this.callBackIncomingScreen, this.sendingDataScreen, this.accomplishedScreen, this.failedScreen, this.canceledScreen, this.redialScreen);
    }
}

