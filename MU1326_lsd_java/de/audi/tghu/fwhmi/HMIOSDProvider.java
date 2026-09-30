/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.event.EventDispatcherAdmin;
import de.audi.atip.testsupport.IOSDDataProvider;
import de.audi.atip.testsupport.ITestSupportSession;

public class HMIOSDProvider
implements IOSDDataProvider {
    private final EventDispatcherAdmin dispatcher;

    public HMIOSDProvider(EventDispatcherAdmin eventDispatcherAdmin) {
        this.dispatcher = eventDispatcherAdmin;
    }

    public String getName() {
        return "HMI Event Queue Statistics";
    }

    public String[] getData() {
        return this.dispatcher.getStatisticData();
    }

    public void setTestSupport(ITestSupportSession iTestSupportSession) {
    }
}

