/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportSession;
import de.audi.app.testsupport.TestSupportSessionHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ScreenDebugInfoEvent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import java.util.ArrayList;

public class TestSupportOSOHandler {
    private static final long TIME = 500L;
    private final LogChannel logChannel;
    private TestSupportSessionHandler sessionHandler;
    private final OSOQueue queue;
    private final IFrameworkAccess framework;

    protected TestSupportOSOHandler(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.framework = iFrameworkAccess;
        this.queue = new OSOQueue();
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
        this.logChannel.log(1000000, "[TestSupportOSOHandler#updateData] providerID='%1'", (long)n);
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

    class OSOQueue
    implements TimerListener {
        private volatile String[] data;
        private final Object mutex = new Object();
        private Timer timer = new Timer("OSOQueue", 500L, false, this);
        private volatile boolean osoEmpty = true;

        protected OSOQueue() {
        }

        protected void init() {
            this.timer.start();
        }

        protected void deinit() {
            this.timer.cancel();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void update(String[] stringArray) {
            TestSupportOSOHandler.this.logChannel.log(1000000, "[OSOQueue#update]", (Object)stringArray);
            Object object = this.mutex;
            synchronized (object) {
                this.data = stringArray;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void clearOSO() {
            TestSupportOSOHandler.this.logChannel.log(1000000, "[OSOQueue#clear]");
            Object object = this.mutex;
            synchronized (object) {
                if (!this.osoEmpty) {
                    this.osoEmpty = true;
                    TestSupportOSOHandler.this.framework.getHMIService().getEventDispatcher().postEvent(TestSupportOSOHandler.this.createEvent(null));
                    this.data = null;
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            if (this.data == null) {
                return;
            }
            TestSupportOSOHandler.this.logChannel.log(1000000, "[OSOQueue#fireTimer] new data: %1", (Object)this.data);
            Object object = this.mutex;
            synchronized (object) {
                this.osoEmpty = false;
                TestSupportOSOHandler.this.framework.getHMIService().getEventDispatcher().postEvent(TestSupportOSOHandler.this.createEvent(this.data));
                this.data = null;
            }
        }

        public void cancelTimer(Timer timer) {
            TestSupportOSOHandler.this.framework.getHMIService().getEventDispatcher().postEvent(TestSupportOSOHandler.this.createEvent(new String[0]));
        }
    }
}

