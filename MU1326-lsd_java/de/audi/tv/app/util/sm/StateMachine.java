/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.util.Handler$IMessageCodeToStringConverter;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.Predicates$Predicate;
import de.audi.tv.app.util.sm.IOnStateChangedListener;
import de.audi.tv.app.util.sm.IState;
import de.audi.tv.app.util.sm.State;
import de.audi.tv.app.util.sm.StateMachine$SmImpl;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Collection;
import java.util.Iterator;

public class StateMachine {
    private final String mLogTag;
    private final String mName;
    private final LogChannel lc;
    private static final int SM_INIT_CMD;
    public static final boolean HANDLED;
    public static final boolean NOT_HANDLED;
    private StateMachine$SmImpl mSmImpl;

    protected StateMachine(String string, LogChannel logChannel, DispatcherBase dispatcherBase, Handler$IMessageCodeToStringConverter handler$IMessageCodeToStringConverter) {
        this.mName = string;
        this.mLogTag = new StringBuffer().append("StateMachine[").append(string).append("]").toString();
        this.lc = logChannel;
        this.mSmImpl = new StateMachine$SmImpl(dispatcherBase, handler$IMessageCodeToStringConverter, logChannel, this.mLogTag, this);
    }

    public final void addState(State state, State state2) {
        StateMachine$SmImpl.access$400(this.mSmImpl, state, state2);
    }

    public final Collection getStates() {
        return this.mSmImpl.getStates();
    }

    public final IState getCurrentState() {
        return StateMachine$SmImpl.access$500(this.mSmImpl);
    }

    public final String getCurrentStateName() {
        try {
            return this.getCurrentState().toString();
        }
        catch (Exception exception) {
            return "<not started>";
        }
    }

    public final void addState(State state) {
        StateMachine$SmImpl.access$400(this.mSmImpl, state, null);
    }

    protected final void setInitialState(State state) {
        StateMachine$SmImpl.access$600(this.mSmImpl, state);
    }

    protected final void transitionTo(IState iState) {
        StateMachine$SmImpl.access$700(this.mSmImpl, iState);
    }

    protected final void transitionTo(Class clazz) {
        State state = this.getStateForClass(clazz);
        if (state != null) {
            this.transitionTo(state);
        }
    }

    public State getStateForClass(Class clazz) {
        Iterator iterator = this.getStates().iterator();
        while (iterator.hasNext()) {
            State state = (State)iterator.next();
            if (!super.getClass().equals(clazz)) continue;
            return state;
        }
        this.lc.log(10000, "[%1.transitionTo] was not able to resolve a %2", (Object)this.mLogTag, (Object)clazz.toString());
        return null;
    }

    protected final void transitionToHaltingState() {
        StateMachine$SmImpl.access$700(this.mSmImpl, StateMachine$SmImpl.access$800(this.mSmImpl));
    }

    protected final void deferMessage(Message message) {
        StateMachine$SmImpl.access$900(this.mSmImpl, message);
    }

    protected void unhandledMessage(Message message) {
        this.lc.log(-1601830656, "[%1.unhandledMessage] %2 was not handled", (Object)this.mLogTag, (Object)message.toString());
    }

    protected void haltedProcessMessage(Message message) {
    }

    protected void onHalting() {
    }

    protected void onQuitting() {
    }

    public final void addOnStateChangedListener(IOnStateChangedListener iOnStateChangedListener) {
        this.mSmImpl.addOnStateChangedListener(iOnStateChangedListener);
    }

    public final String getName() {
        return this.mName;
    }

    public final Message obtainMessage(int n) {
        return StateMachine$SmImpl.access$1000(this.mSmImpl).obtainMessage(n);
    }

    public final void sendMessage(int n) {
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessage(this.obtainMessage(n));
    }

    public final void sendMessage(int n, Object object) {
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessage(n, object);
    }

    public final void sendMessage(Message message) {
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessage(message);
    }

    public void sendMessage(int n, int n2, int n3, Object object) {
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessage(n, n2, n3, object);
    }

    public void sendMessage(int n, int n2, int n3) {
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessage(n, n2, n3);
    }

    public void sendMessage(int n, int n2) {
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessage(n, n2);
    }

    public void sendMessage(int n, int n2, Object object) {
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessage(n, n2, object);
    }

    public final void sendMessageDelayed(int n, long l) {
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessageDelayed(this.obtainMessage(n), l);
    }

    public final void sendMessageDelayed(int n, Object object, long l) {
        Message message = StateMachine$SmImpl.access$1000(this.mSmImpl).obtainMessage(n);
        message.obj = object;
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessageDelayed(message, l);
    }

    public final void sendMessageDelayed(Message message, long l) {
        StateMachine$SmImpl.access$1000(this.mSmImpl).sendMessageDelayed(message, l);
    }

    protected final void sendMessageAtFrontOfQueue(int n, Object object) {
    }

    protected final void sendMessageAtFrontOfQueue(int n) {
    }

    protected final void sendMessageAtFrontOfQueue(Message message) {
    }

    public final void removeMessages(int n) {
        this.mSmImpl.removeMessages(n);
    }

    public final void removeMessages(Predicates$Predicate predicates$Predicate) {
        this.mSmImpl.removeMessages(predicates$Predicate);
    }

    public final Message getCurrentMessage() {
        return this.mSmImpl.getCurrentMessage();
    }

    public final boolean hasMessages(int n) {
        return this.mSmImpl.hasMessages(n);
    }

    public boolean isDbg() {
        return StateMachine$SmImpl.access$1100(this.mSmImpl);
    }

    public void setDbg(boolean bl) {
        StateMachine$SmImpl.access$1200(this.mSmImpl, bl);
    }

    public void start() {
        StateMachine$SmImpl.access$1300(this.mSmImpl);
    }
}

