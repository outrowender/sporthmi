/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportOSOHandler$OSOQueue;
import de.audi.app.testsupport.TestSupportSession;
import de.audi.app.testsupport.TestSupportSessionHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ScreenDebugInfoEvent;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;

public class TestSupportOSOHandler {
    private static final long TIME;
    private final LogChannel logChannel;
    private TestSupportSessionHandler sessionHandler;
    private final TestSupportOSOHandler$OSOQueue queue;
    private final IFrameworkAccess framework;

    protected TestSupportOSOHandler(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.framework = iFrameworkAccess;
        this.queue = new TestSupportOSOHandler$OSOQueue(this);
    }

    protected void setSessionHandler(TestSupportSessionHandler testSupportSessionHandler) {
        this.sessionHandler = testSupportSessionHandler;
    }

    protected void init() {
        this.queue.init();
    }

    protected void deinit() {
        this.queue.deinit();
    }

    protected void updateData(int n) {
        this.logChannel.log(1078071040, "[TestSupportOSOHandler#updateData] providerID='%1'", (long)n);
        ArrayList arrayList = (ArrayList)this.sessionHandler.getOSOSessions();
        if (arrayList.size() == 0) {
            this.queue.clearOSO();
            return;
        }
        ArrayList arrayList2 = new ArrayList(10);
        String[] stringArray = arrayList.iterator();
        while (stringArray.hasNext()) {
            TestSupportSession testSupportSession = (TestSupportSession)stringArray.next();
            arrayList2.add(testSupportSession.getProvider().getDataProviderName());
            for (int i2 = 0; i2 < testSupportSession.getData().length; ++i2) {
                arrayList2.add(testSupportSession.getData()[i2]);
            }
            arrayList2.add("");
        }
        stringArray = (String[])arrayList2.toArray(new String[arrayList2.size()]);
        this.queue.update(stringArray);
    }

    private ScreenDebugInfoEvent createEvent(String[] stringArray) {
        return new ScreenDebugInfoEvent(this.framework.getHMIService().getRootWindow(0), stringArray, 16);
    }

    static /* synthetic */ LogChannel access$000(TestSupportOSOHandler testSupportOSOHandler) {
        return testSupportOSOHandler.logChannel;
    }

    static /* synthetic */ ScreenDebugInfoEvent access$100(TestSupportOSOHandler testSupportOSOHandler, String[] stringArray) {
        return testSupportOSOHandler.createEvent(stringArray);
    }

    static /* synthetic */ IFrameworkAccess access$200(TestSupportOSOHandler testSupportOSOHandler) {
        return testSupportOSOHandler.framework;
    }
}

