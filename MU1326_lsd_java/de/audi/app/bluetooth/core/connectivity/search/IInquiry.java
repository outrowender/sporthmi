/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.search;

import de.audi.app.bluetooth.core.connectivity.search.IDiscoveredServiceHandler;

public interface IInquiry {
    public static final int INQUIRYLENGTH = 48;
    public static final int MAX_NUM_DEVICES = 50;
    public static final int STATE_IDLE = 0;
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_ABORTING = 2;

    public void startInquiry(int var1);

    public void abortInquiry();

    public void inquiryEnded(int var1);

    public void getServices(String var1, IDiscoveredServiceHandler var2);

    public void resetSearchState();
}

