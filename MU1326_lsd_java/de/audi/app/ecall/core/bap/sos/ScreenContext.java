/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap.sos;

public class ScreenContext {
    final int connectingScreen;
    final int connectedScreen;
    final int callBackIncomingScreen;
    final int sendingDataScreen;
    final int accomplishedScreen;
    final int failedScreen;
    final int canceledScreen;
    final int redialScreen;

    private ScreenContext(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.connectingScreen = n;
        this.connectedScreen = n2;
        this.callBackIncomingScreen = n3;
        this.sendingDataScreen = n4;
        this.accomplishedScreen = n5;
        this.failedScreen = n6;
        this.canceledScreen = n7;
        this.redialScreen = n8;
    }
}

