/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.util.CopyOnWriteArrayList;
import de.audi.tv.app.util.Handler;
import de.audi.tv.app.util.Handler$Builder;
import de.audi.tv.app.util.Handler$IHandlingStrategy;
import de.audi.tv.app.util.Handler$IMessageCodeToStringConverter;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.Predicates$Predicate;
import de.audi.tv.app.util.sm.IOnStateChangedListener;
import de.audi.tv.app.util.sm.IState;
import de.audi.tv.app.util.sm.State;
import de.audi.tv.app.util.sm.StateMachine;
import de.audi.tv.app.util.sm.StateMachine$SmImpl$HaltingState;
import de.audi.tv.app.util.sm.StateMachine$SmImpl$QuittingState;
import de.audi.tv.app.util.sm.StateMachine$SmImpl$StateInfo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class StateMachine$SmImpl
implements Handler$IHandlingStrategy {
    private boolean mDbg = false;
    private final String logTag;
    private final LogChannel lc;
    private static final Object SM_HANDLER_INTERNAL_MESSAGE_INDICATOR = "SM_HANDLER_INTERNAL_MESSAGE_INDICATOR";
    private final Handler handler;
    private Message mMsg;
    private boolean mIsConstructionCompleted;
    private StateMachine$SmImpl$StateInfo[] mStateStack;
    private int mStateStackTopIndex = -1;
    private StateMachine$SmImpl$StateInfo[] mTempStateStack;
    private int mTempStateStackCount;
    private final StateMachine$SmImpl$HaltingState mHaltingState = new StateMachine$SmImpl$HaltingState(this, null);
    private final StateMachine$SmImpl$QuittingState mQuittingState = new StateMachine$SmImpl$QuittingState(this, null);
    private final Map mStateInfo = new HashMap();
    private State mInitialState;
    private State mDestState;
    private final List mDeferredMessages = new ArrayList();
    private final StateMachine mSm;
    private final CopyOnWriteArrayList onStateChangedListeners;

    public StateMachine$SmImpl(DispatcherBase dispatcherBase, Handler$IMessageCodeToStringConverter handler$IMessageCodeToStringConverter, LogChannel logChannel, String string, StateMachine stateMachine) {
        this.mSm = stateMachine;
        this.handler = new Handler$Builder().setHandlingStrategy(this).setDispatcher(dispatcherBase).setMessageCodeToStringConverter(handler$IMessageCodeToStringConverter).getHandler();
        this.lc = logChannel;
        this.logTag = string;
        this.onStateChangedListeners = new CopyOnWriteArrayList();
        this.addState(this.mHaltingState, null);
        this.addState(this.mQuittingState, null);
    }

    @Override
    public void handleMessage(Message message) {
        this.mMsg = message;
        if (this.mIsConstructionCompleted) {
            this.processMsg(message);
        } else if (!this.mIsConstructionCompleted && this.mMsg.getCode() == -2 && this.mMsg.obj == SM_HANDLER_INTERNAL_MESSAGE_INDICATOR) {
            this.mIsConstructionCompleted = true;
            this.invokeEnterMethods(0, this.mMsg);
        } else {
            this.lc.log(1000, "%1.handleMessage: The start method not called, received msg: %2", (Object)this.logTag, (Object)message);
        }
        this.performTransitions(message);
    }

    private void performTransitions(Message message) {
        State state = null;
        while (this.mDestState != null) {
            state = this.mDestState;
            this.mDestState = null;
            StateMachine$SmImpl$StateInfo stateInfo = this.setupTempStateStackWithStatesToEnter(state);
            this.invokeExitMethods(stateInfo, message);
            int n = this.moveTempStateStackToStateStack();
            this.invokeEnterMethods(n, message);
            this.moveDeferredMessageAtFrontOfQueue();
        }
        if (state != null) {
            if (state == this.mQuittingState) {
                this.mSm.onQuitting();
            } else if (state == this.mHaltingState) {
                this.mSm.onHalting();
            }
        }
    }

    private final void completeConstruction() {
        int n = 0;
        Object object = this.mStateInfo.values().iterator();
        while (object.hasNext()) {
            StateMachine$SmImpl$StateInfo stateMachine$SmImpl$StateInfo = (StateMachine$SmImpl$StateInfo)object.next();
            int n2 = 0;
            StateMachine$SmImpl$StateInfo stateMachine$SmImpl$StateInfo2 = stateMachine$SmImpl$StateInfo;
            while (stateMachine$SmImpl$StateInfo2 != null) {
                stateMachine$SmImpl$StateInfo2 = stateMachine$SmImpl$StateInfo2.parentStateInfo;
                ++n2;
            }
            if (n >= n2) continue;
            n = n2;
        }
        this.mStateStack = new StateMachine$SmImpl$StateInfo[n];
        this.mTempStateStack = new StateMachine$SmImpl$StateInfo[n];
        this.setupInitialStateStack();
        object = this.handler.obtainMessage(-2);
        ((Message)object).obj = SM_HANDLER_INTERNAL_MESSAGE_INDICATOR;
        ((Message)object).tag = "SM_INIT_CMD";
        ((Message)object).sendToTarget();
        this.lc.log(-2137614336, "[%1.completeConstruction]", (Object)this.logTag);
    }

    private final void processMsg(Message message) {
        StateMachine$SmImpl$StateInfo stateMachine$SmImpl$StateInfo = this.mStateStack[this.mStateStackTopIndex];
        Buffer buffer = new Buffer(5);
        this.lc.log(-2137614336, "[%1.processMsg] %3 - %2", (Object)this.logTag, (Object)message.toString(), (Object)stateMachine$SmImpl$StateInfo.state.getName());
        while (!stateMachine$SmImpl$StateInfo.state.processMessage(message)) {
            stateMachine$SmImpl$StateInfo = stateMachine$SmImpl$StateInfo.parentStateInfo;
            if (stateMachine$SmImpl$StateInfo == null) {
                this.mSm.unhandledMessage(message);
                break;
            }
            this.lc.log(-2137614336, "[%1.processMsg] %2\\ %3", (Object)this.logTag, (Object)buffer.toString(), (Object)stateMachine$SmImpl$StateInfo.state.getName(), (Object)this.mSm.getName());
            buffer.append(' ');
        }
    }

    private final void invokeExitMethods(StateMachine$SmImpl$StateInfo stateMachine$SmImpl$StateInfo, Message message) {
        while (this.mStateStackTopIndex >= 0 && this.mStateStack[this.mStateStackTopIndex] != stateMachine$SmImpl$StateInfo) {
            State state = this.mStateStack[this.mStateStackTopIndex].state;
            state.exit(message);
            this.mStateStack[this.mStateStackTopIndex].active = false;
            --this.mStateStackTopIndex;
        }
    }

    private final void invokeEnterMethods(int n, Message message) {
        for (int i2 = n; i2 <= this.mStateStackTopIndex; ++i2) {
            this.onStateChanged(this.mStateStack[i2].state);
            this.mStateStack[i2].state.enter(message);
            this.mStateStack[i2].active = true;
        }
    }

    private final void moveDeferredMessageAtFrontOfQueue() {
        for (int i2 = this.mDeferredMessages.size() - 1; i2 >= 0; --i2) {
            Message message = (Message)this.mDeferredMessages.get(i2);
            this.lc.log(-2137614336, "[%1.moveDeferredMessageAtFrontOfQueue] %2", (Object)this.logTag, (Object)message.toString());
            this.handler.sendMessage(message);
        }
        this.mDeferredMessages.clear();
    }

    private final int moveTempStateStackToStateStack() {
        int n = this.mStateStackTopIndex + 1;
        int n2 = n;
        for (int i2 = this.mTempStateStackCount - 1; i2 >= 0; --i2) {
            this.mStateStack[n2] = this.mTempStateStack[i2];
            ++n2;
        }
        this.mStateStackTopIndex = n2 - 1;
        return n;
    }

    private final StateMachine$SmImpl$StateInfo setupTempStateStackWithStatesToEnter(State state) {
        this.mTempStateStackCount = 0;
        StateMachine$SmImpl$StateInfo stateMachine$SmImpl$StateInfo = (StateMachine$SmImpl$StateInfo)this.mStateInfo.get(state);
        do {
            this.mTempStateStack[this.mTempStateStackCount++] = stateMachine$SmImpl$StateInfo;
        } while ((stateMachine$SmImpl$StateInfo = stateMachine$SmImpl$StateInfo.parentStateInfo) != null && !stateMachine$SmImpl$StateInfo.active);
        return stateMachine$SmImpl$StateInfo;
    }

    private final void setupInitialStateStack() {
        StateMachine$SmImpl$StateInfo stateMachine$SmImpl$StateInfo = (StateMachine$SmImpl$StateInfo)this.mStateInfo.get(this.mInitialState);
        this.mTempStateStackCount = 0;
        while (stateMachine$SmImpl$StateInfo != null) {
            this.mTempStateStack[this.mTempStateStackCount] = stateMachine$SmImpl$StateInfo;
            stateMachine$SmImpl$StateInfo = stateMachine$SmImpl$StateInfo.parentStateInfo;
            ++this.mTempStateStackCount;
        }
        this.mStateStackTopIndex = -1;
        this.moveTempStateStackToStateStack();
    }

    public final Message getCurrentMessage() {
        return this.mMsg;
    }

    private final IState getCurrentState() {
        return this.mStateStack[this.mStateStackTopIndex].state;
    }

    private final StateMachine$SmImpl$StateInfo addState(State state, State state2) {
        StateMachine$SmImpl$StateInfo stateMachine$SmImpl$StateInfo;
        StateMachine$SmImpl$StateInfo stateMachine$SmImpl$StateInfo2 = null;
        if (state2 != null && (stateMachine$SmImpl$StateInfo2 = (StateMachine$SmImpl$StateInfo)this.mStateInfo.get(state2)) == null) {
            stateMachine$SmImpl$StateInfo2 = this.addState(state2, null);
        }
        if ((stateMachine$SmImpl$StateInfo = (StateMachine$SmImpl$StateInfo)this.mStateInfo.get(state)) == null) {
            stateMachine$SmImpl$StateInfo = new StateMachine$SmImpl$StateInfo(this, null);
            this.mStateInfo.put(state, stateMachine$SmImpl$StateInfo);
        }
        if (stateMachine$SmImpl$StateInfo.parentStateInfo != null && stateMachine$SmImpl$StateInfo.parentStateInfo != stateMachine$SmImpl$StateInfo2) {
            throw new IllegalArgumentException("state already added");
        }
        stateMachine$SmImpl$StateInfo.state = state;
        stateMachine$SmImpl$StateInfo.parentStateInfo = stateMachine$SmImpl$StateInfo2;
        stateMachine$SmImpl$StateInfo.active = false;
        return stateMachine$SmImpl$StateInfo;
    }

    private final void setInitialState(State state) {
        this.mInitialState = state;
    }

    private final void transitionTo(IState iState) {
        this.mDestState = (State)iState;
        this.lc.log(-2137614336, "[%1.transitionTo] from %2 to %3", (Object)this.logTag, (Object)this.mStateStack[this.mStateStackTopIndex].state.getName(), (Object)this.mDestState.getName());
    }

    private final void deferMessage(Message message) {
        this.lc.log(-2137614336, "[%1.deferMessage] %2", (Object)this.logTag, (Object)message.toString());
        Message message2 = this.handler.obtainMessage(message.getCode());
        message2.arg1 = message.arg1;
        message2.arg2 = message.arg2;
        message2.obj = message.obj;
        this.mDeferredMessages.add(message2);
    }

    private final boolean isDbg() {
        return this.mDbg;
    }

    private final void setDbg(boolean bl) {
        this.mDbg = bl;
    }

    public Collection getStates() {
        return this.mStateInfo.keySet();
    }

    private void onStateChanged(State state) {
        Iterator iterator = this.onStateChangedListeners.iterator();
        while (iterator.hasNext()) {
            IOnStateChangedListener iOnStateChangedListener = (IOnStateChangedListener)iterator.next();
            iOnStateChangedListener.onStateChanged(state);
        }
    }

    public void addOnStateChangedListener(IOnStateChangedListener iOnStateChangedListener) {
        this.onStateChangedListeners.add(iOnStateChangedListener);
    }

    public boolean removeMessages(int n) {
        Iterator iterator = this.mDeferredMessages.iterator();
        while (iterator.hasNext()) {
            Message message = (Message)iterator.next();
            if (message.getCode() != n) continue;
            iterator.remove();
            this.lc.log(-2137614336, "[%1.removeMessages] removing deferred message %2", (Object)this.logTag, (Object)message.toString());
        }
        return this.handler.removeMessages(n);
    }

    public void removeMessages(Predicates$Predicate predicates$Predicate) {
        Iterator iterator = this.mDeferredMessages.iterator();
        while (iterator.hasNext()) {
            Message message = (Message)iterator.next();
            if (!predicates$Predicate.apply(message)) continue;
            iterator.remove();
            this.lc.log(-2137614336, "[%1.removeMessages] removing deferred message %2", (Object)this.logTag, (Object)message.toString());
        }
        this.handler.removeMessages(predicates$Predicate);
    }

    public boolean hasMessages(int n) {
        return false;
    }

    static /* synthetic */ StateMachine access$200(StateMachine$SmImpl stateMachine$SmImpl) {
        return stateMachine$SmImpl.mSm;
    }

    static /* synthetic */ StateMachine$SmImpl$StateInfo access$400(StateMachine$SmImpl stateMachine$SmImpl, State state, State state2) {
        return stateMachine$SmImpl.addState(state, state2);
    }

    static /* synthetic */ IState access$500(StateMachine$SmImpl stateMachine$SmImpl) {
        return stateMachine$SmImpl.getCurrentState();
    }

    static /* synthetic */ void access$600(StateMachine$SmImpl stateMachine$SmImpl, State state) {
        stateMachine$SmImpl.setInitialState(state);
    }

    static /* synthetic */ void access$700(StateMachine$SmImpl stateMachine$SmImpl, IState iState) {
        stateMachine$SmImpl.transitionTo(iState);
    }

    static /* synthetic */ StateMachine$SmImpl$HaltingState access$800(StateMachine$SmImpl stateMachine$SmImpl) {
        return stateMachine$SmImpl.mHaltingState;
    }

    static /* synthetic */ void access$900(StateMachine$SmImpl stateMachine$SmImpl, Message message) {
        stateMachine$SmImpl.deferMessage(message);
    }

    static /* synthetic */ Handler access$1000(StateMachine$SmImpl stateMachine$SmImpl) {
        return stateMachine$SmImpl.handler;
    }

    static /* synthetic */ boolean access$1100(StateMachine$SmImpl stateMachine$SmImpl) {
        return stateMachine$SmImpl.isDbg();
    }

    static /* synthetic */ void access$1200(StateMachine$SmImpl stateMachine$SmImpl, boolean bl) {
        stateMachine$SmImpl.setDbg(bl);
    }

    static /* synthetic */ void access$1300(StateMachine$SmImpl stateMachine$SmImpl) {
        stateMachine$SmImpl.completeConstruction();
    }
}

