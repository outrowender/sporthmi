/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportOSOHandler;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class TestSupportOSOHandler$OSOQueue
implements TimerListener {
    private volatile String[] data;
    private final Object mutex = new Object();
    private Timer timer = new Timer("OSOQueue", 0, false, this);
    private volatile boolean osoEmpty = true;
    private final /* synthetic */ TestSupportOSOHandler this$0;

    protected TestSupportOSOHandler$OSOQueue(TestSupportOSOHandler testSupportOSOHandler) {
        this.this$0 = testSupportOSOHandler;
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
        TestSupportOSOHandler.access$000(this.this$0).log(1078071040, "[OSOQueue#update]", (Object)stringArray);
        Object object = this.mutex;
        synchronized (object) {
            this.data = stringArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void clearOSO() {
        TestSupportOSOHandler.access$000(this.this$0).log(1078071040, "[OSOQueue#clear]");
        Object object = this.mutex;
        synchronized (object) {
            if (!this.osoEmpty) {
                this.osoEmpty = true;
                TestSupportOSOHandler.access$200(this.this$0).getHMIService().getEventDispatcher().postEvent(TestSupportOSOHandler.access$100(this.this$0, null));
                this.data = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (this.data == null) {
            return;
        }
        TestSupportOSOHandler.access$000(this.this$0).log(1078071040, "[OSOQueue#fireTimer] new data: %1", (Object)this.data);
        Object object = this.mutex;
        synchronized (object) {
            this.osoEmpty = false;
            TestSupportOSOHandler.access$200(this.this$0).getHMIService().getEventDispatcher().postEvent(TestSupportOSOHandler.access$100(this.this$0, this.data));
            this.data = null;
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        TestSupportOSOHandler.access$200(this.this$0).getHMIService().getEventDispatcher().postEvent(TestSupportOSOHandler.access$100(this.this$0, new String[0]));
    }
}

