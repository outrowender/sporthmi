/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.search;

import de.audi.app.bluetooth.core.connectivity.search.IDiscoveredServiceHandler;

public interface IInquiry {
    public static final int INQUIRYLENGTH;
    public static final int MAX_NUM_DEVICES;
    public static final int STATE_IDLE;
    public static final int STATE_ACTIVE;
    public static final int STATE_ABORTING;

    default public void startInquiry(int n) {
    }

    default public void abortInquiry() {
    }

    default public void inquiryEnded(int n) {
    }

    default public void getServices(String string, IDiscoveredServiceHandler iDiscoveredServiceHandler) {
    }

    default public void resetSearchState() {
    }
}

