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

    public static final class Builder {
        private int connectingScreen;
        private int connectedScreen;
        private int callBackIncomingScreen;
        private int sendingDataScreen;
        private int accomplishedScreen;
        private int failedScreen;
        private int canceledScreen;
        private int redialScreen;

        public Builder setConnectingScreen(int n) {
            this.connectingScreen = n;
            return this;
        }

        public Builder setConnectedScreen(int n) {
            this.connectedScreen = n;
            return this;
        }

        public Builder setCallBackIncomingScreen(int n) {
            this.callBackIncomingScreen = n;
            return this;
        }

        public Builder setSendingDataScreen(int n) {
            this.sendingDataScreen = n;
            return this;
        }

        public Builder setAccomplishedScreen(int n) {
            this.accomplishedScreen = n;
            return this;
        }

        public Builder setFailedScreen(int n) {
            this.failedScreen = n;
            return this;
        }

        public Builder setCanceledScreen(int n) {
            this.canceledScreen = n;
            return this;
        }

        public Builder setRedialScreen(int n) {
            this.redialScreen = n;
            return this;
        }

        public ScreenContext build() {
            return new ScreenContext(this.connectingScreen, this.connectedScreen, this.callBackIncomingScreen, this.sendingDataScreen, this.accomplishedScreen, this.failedScreen, this.canceledScreen, this.redialScreen);
        }
    }
}

