/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import java.util.NoSuchElementException;

public abstract class AbstractEventMediator
implements EventMediator {
    protected static final int CRITICAL_DATA_ERROR = 10000;
    protected static final int DATA_ERROR = 10000;
    public static final int EVENT_TRACE = 1000000;
    public static final long DELAY_DEFAULT = 3000L;
    public static final long DELAY_MIN = 1L;
    protected volatile boolean active;
    protected volatile boolean started = false;
    private int postponedAction = -1;
    protected int action;
    protected volatile boolean listening = false;
    protected MediatorManager manager;
    protected int[] triggerModelIDList;
    private final long id;

    protected AbstractEventMediator(long l, MediatorManager mediatorManager, int n) {
        this(l, mediatorManager, n, null);
    }

    protected AbstractEventMediator(long l, MediatorManager mediatorManager, int n, int n2) {
        this(l, mediatorManager, n, new int[]{n2});
    }

    protected AbstractEventMediator(long l, MediatorManager mediatorManager, int n, int[] nArray) {
        this.manager = mediatorManager;
        this.action = n;
        this.triggerModelIDList = nArray;
        this.id = l;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isStarted() {
        return this.started;
    }

    public int activate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[AbstractEventMediator#activate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.active = true;
        return -1;
    }

    public int reactivate(boolean bl) {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[AbstractEventMediator#reactivate] (MEDID#%1), postponedAction: (EVENTID#2)", (Object)Long.toString(this.getID()), (long)this.getPostponedActionWithoutReset());
        }
        this.active = true;
        return this.getPostponedAction();
    }

    public void deactivate() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[AbstractEventMediator#deactivate] (MEDID#%1)", (Object)Long.toString(this.getID()));
        }
        this.active = false;
    }

    public boolean locksScreen() {
        return false;
    }

    protected void triggerAction(int n) {
        if (this.active) {
            this.manager.getEventLogChannel().log(1000000, "[AbstractEventMediator#triggerAction] mediator (MEDID#%2) fires state machine event (EVENTID#%1)", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
            if (this.manager.getLogChannel().isDebug2()) {
                this.manager.getLogChannel().log(100000000, "[AbstractEventMediator#triggerAction] mediator (MEDID#%2) fires state machine event (EVENTID#%1)", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
            }
            this.manager.fireEvent(n);
        } else {
            this.manager.getEventLogChannel().log(1000000, "[AbstractEventMediator#triggerAction] inactive mediator (MEDID#%2) postpones state machine event (EVENTID#%1)", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
            if (this.manager.getLogChannel().isDebug2()) {
                this.manager.getLogChannel().log(100000000, "[AbstractEventMediator#triggerAction] inactive mediator (MEDID#%2) postpones state machine event (EVENTID#%1)", (Object)Integer.toString(n), (Object)Long.toString(this.getID()));
            }
            this.postponedAction = n;
        }
    }

    protected boolean hasPostponedAction() {
        return this.postponedAction != -1;
    }

    protected void resetPostponedAction() {
        this.postponedAction = -1;
    }

    protected int getPostponedAction() {
        int n = this.postponedAction;
        this.postponedAction = -1;
        return n;
    }

    protected int getPostponedActionWithoutReset() {
        return this.postponedAction;
    }

    protected void startListening() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[AbstractEventMediator#startListeing] (MEDID#%1), currently listening=%2", (Object)Long.toString(this.getID()), (Object)Boolean.toString(this.listening));
        }
        if (this.listening || this.triggerModelIDList == null) {
            return;
        }
        this.manager.registerMediator(this, this.triggerModelIDList);
        for (int i2 = 0; i2 < this.triggerModelIDList.length; ++i2) {
            try {
                HMIModel hMIModel = this.manager.getModel(this.triggerModelIDList[i2]);
                hMIModel.addReference();
                continue;
            }
            catch (NoSuchElementException noSuchElementException) {
                this.manager.getLogChannel().log(10000, "[AbstractEventMediator#startListening] mediator (MEDID#%2) unable to retrieve model (MODELID#%1)", (Object)Integer.toString(this.triggerModelIDList[i2]), (Object)Long.toString(this.getID()), (Object)noSuchElementException);
            }
        }
        this.listening = true;
    }

    protected void stopListening() {
        if (this.manager.getLogChannel().isDebug2()) {
            this.manager.getLogChannel().log(100000000, "[AbstractEventMediator#stopListeing] (MEDID#%1), currently listening=%2", (Object)Long.toString(this.getID()), (Object)Boolean.toString(this.listening));
        }
        if (!this.listening) {
            return;
        }
        this.manager.unregisterMediator(this, this.triggerModelIDList);
        for (int i2 = 0; i2 < this.triggerModelIDList.length; ++i2) {
            try {
                HMIModel hMIModel = this.manager.getModel(this.triggerModelIDList[i2]);
                if (hMIModel != null) {
                    hMIModel.removeReference();
                    continue;
                }
                this.manager.getLogChannel().log(100000, "[AbstractEventMediator#stopListening] mediator unable to retreive model (MODELID#%1) in order to remove reference", (long)this.triggerModelIDList[i2]);
                continue;
            }
            catch (NoSuchElementException noSuchElementException) {
                this.manager.getLogChannel().log(100000, "[AbstractEventMediator#stopListening] mediator unable to retrieve model (MODELID#%1) in order to remove reference ", (long)this.triggerModelIDList[i2], (Throwable)noSuchElementException);
            }
        }
        this.listening = false;
    }

    protected IFrameworkAccess getFramework() {
        return this.manager.getFramework();
    }

    public void createErrorLog(String string) {
        this.createErrorLog(string, null);
    }

    public void createErrorLog(String string, Exception exception) {
    }

    public abstract int getType();

    public long getID() {
        return this.id;
    }
}

