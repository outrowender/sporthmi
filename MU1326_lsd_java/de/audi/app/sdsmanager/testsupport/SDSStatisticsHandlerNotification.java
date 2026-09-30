/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.testsupport.DefaultTestSupportHandlerNotification;

public class SDSStatisticsHandlerNotification
extends DefaultTestSupportHandlerNotification {
    private volatile boolean testSupportStatisticsVisible = false;

    public boolean isVisible() {
        return this.testSupportStatisticsVisible;
    }

    public void debugDataVisible(boolean bl) {
        this.testSupportStatisticsVisible = bl;
    }
}

