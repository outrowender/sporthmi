/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.util.CopyOnWriteArrayList;
import de.audi.tv.app.util.Handler;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.Predicates;
import de.audi.tv.app.util.sm.IOnStateChangedListener;
import de.audi.tv.app.util.sm.IState;
import de.audi.tv.app.util.sm.State;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StateMachine {
    private final String mLogTag;
    private final String mName;
    private final LogChannel lc;
    private static final int SM_INIT_CMD = -2;
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    private SmImpl mSmImpl;

    protected StateMachine(String string, LogChannel logChannel, DispatcherBase dispatcherBase, Handler.IMessageCodeToStringConverter iMessageCodeToStringConverter) {
        this.mName = string;
        this.mLogTag = "StateMachine[" + string + "]";
        this.lc = logChannel;
        this.mSmImpl = new SmImpl(dispatcherBase, iMessageCodeToStringConverter, logChannel, this.mLogTag, this);
    }

    public final void addState(State state, State state2) {
        this.mSmImpl.addState(state, state2);
    }

    public final Collection getStates() {
        return this.mSmImpl.getStates();
    }

    public final IState getCurrentState() {
        return this.mSmImpl.getCurrentState();
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
        this.mSmImpl.addState(state, null);
    }

    protected final void setInitialState(State state) {
        this.mSmImpl.setInitialState(state);
    }

    protected final void transitionTo(IState iState) {
        this.mSmImpl.transitionTo(iState);
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
            if (!state.getClass().equals(clazz)) continue;
            return state;
        }
        this.lc.log(10000, "[%1.transitionTo] was not able to resolve a %2", (Object)this.mLogTag, (Object)clazz.toString());
        return null;
    }

    protected final void transitionToHaltingState() {
        this.mSmImpl.transitionTo(this.mSmImpl.mHaltingState);
    }

    protected final void deferMessage(Message message) {
        this.mSmImpl.deferMessage(message);
    }

    protected void unhandledMessage(Message message) {
        this.lc.log(100000, "[%1.unhandledMessage] %2 was not handled", (Object)this.mLogTag, (Object)message.toString());
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
        return this.mSmImpl.handler.obtainMessage(n);
    }

    public final void sendMessage(int n) {
        this.mSmImpl.handler.sendMessage(this.obtainMessage(n));
    }

    public final void sendMessage(int n, Object object) {
        this.mSmImpl.handler.sendMessage(n, object);
    }

    public final void sendMessage(Message message) {
        this.mSmImpl.handler.sendMessage(message);
    }

    public void sendMessage(int n, int n2, int n3, Object object) {
        this.mSmImpl.handler.sendMessage(n, n2, n3, object);
    }

    public void sendMessage(int n, int n2, int n3) {
        this.mSmImpl.handler.sendMessage(n, n2, n3);
    }

    public void sendMessage(int n, int n2) {
        this.mSmImpl.handler.sendMessage(n, n2);
    }

    public void sendMessage(int n, int n2, Object object) {
        this.mSmImpl.handler.sendMessage(n, n2, object);
    }

    public final void sendMessageDelayed(int n, long l) {
        this.mSmImpl.handler.sendMessageDelayed(this.obtainMessage(n), l);
    }

    public final void sendMessageDelayed(int n, Object object, long l) {
        Message message = this.mSmImpl.handler.obtainMessage(n);
        message.obj = object;
        this.mSmImpl.handler.sendMessageDelayed(message, l);
    }

    public final void sendMessageDelayed(Message message, long l) {
        this.mSmImpl.handler.sendMessageDelayed(message, l);
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

    public final void removeMessages(Predicates.Predicate predicate) {
        this.mSmImpl.removeMessages(predicate);
    }

    public final Message getCurrentMessage() {
        return this.mSmImpl.getCurrentMessage();
    }

    public final boolean hasMessages(int n) {
        return this.mSmImpl.hasMessages(n);
    }

    public boolean isDbg() {
        return this.mSmImpl.isDbg();
    }

    public void setDbg(boolean bl) {
        this.mSmImpl.setDbg(bl);
    }

    public void start() {
        this.mSmImpl.completeConstruction();
    }

    private static class SmImpl
    implements Handler.IHandlingStrategy {
        private boolean mDbg = false;
        private final String logTag;
        private final LogChannel lc;
        private static final Object SM_HANDLER_INTERNAL_MESSAGE_INDICATOR = "SM_HANDLER_INTERNAL_MESSAGE_INDICATOR";
        private final Handler handler;
        private Message mMsg;
        private boolean mIsConstructionCompleted;
        private StateInfo[] mStateStack;
        private int mStateStackTopIndex = -1;
        private StateInfo[] mTempStateStack;
        private int mTempStateStackCount;
        private final HaltingState mHaltingState = new HaltingState();
        private final QuittingState mQuittingState = new QuittingState();
        private final Map mStateInfo = new HashMap();
        private State mInitialState;
        private State mDestState;
        private final List mDeferredMessages = new ArrayList();
        private final StateMachine mSm;
        private final CopyOnWriteArrayList onStateChangedListeners;

        public SmImpl(DispatcherBase dispatcherBase, Handler.IMessageCodeToStringConverter iMessageCodeToStringConverter, LogChannel logChannel, String string, StateMachine stateMachine) {
            this.mSm = stateMachine;
            this.handler = new Handler.Builder().setHandlingStrategy(this).setDispatcher(dispatcherBase).setMessageCodeToStringConverter(iMessageCodeToStringConverter).getHandler();
            this.lc = logChannel;
            this.logTag = string;
            this.onStateChangedListeners = new CopyOnWriteArrayList();
            this.addState(this.mHaltingState, null);
            this.addState(this.mQuittingState, null);
        }

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
                StateInfo stateInfo = this.setupTempStateStackWithStatesToEnter(state);
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
                StateInfo stateInfo = (StateInfo)object.next();
                int n2 = 0;
                StateInfo stateInfo2 = stateInfo;
                while (stateInfo2 != null) {
                    stateInfo2 = stateInfo2.parentStateInfo;
                    ++n2;
                }
                if (n >= n2) continue;
                n = n2;
            }
            this.mStateStack = new StateInfo[n];
            this.mTempStateStack = new StateInfo[n];
            this.setupInitialStateStack();
            object = this.handler.obtainMessage(-2);
            ((Message)object).obj = SM_HANDLER_INTERNAL_MESSAGE_INDICATOR;
            ((Message)object).tag = "SM_INIT_CMD";
            ((Message)object).sendToTarget();
            this.lc.log(10000000, "[%1.completeConstruction]", (Object)this.logTag);
        }

        private final void processMsg(Message message) {
            StateInfo stateInfo = this.mStateStack[this.mStateStackTopIndex];
            Buffer buffer = new Buffer(5);
            this.lc.log(10000000, "[%1.processMsg] %3 - %2", (Object)this.logTag, (Object)message.toString(), (Object)stateInfo.state.getName());
            while (!stateInfo.state.processMessage(message)) {
                stateInfo = stateInfo.parentStateInfo;
                if (stateInfo == null) {
                    this.mSm.unhandledMessage(message);
                    break;
                }
                this.lc.log(10000000, "[%1.processMsg] %2\\ %3", (Object)this.logTag, (Object)buffer.toString(), (Object)stateInfo.state.getName(), (Object)this.mSm.getName());
                buffer.append(' ');
            }
        }

        private final void invokeExitMethods(StateInfo stateInfo, Message message) {
            while (this.mStateStackTopIndex >= 0 && this.mStateStack[this.mStateStackTopIndex] != stateInfo) {
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
                this.lc.log(10000000, "[%1.moveDeferredMessageAtFrontOfQueue] %2", (Object)this.logTag, (Object)message.toString());
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

        private final StateInfo setupTempStateStackWithStatesToEnter(State state) {
            this.mTempStateStackCount = 0;
            StateInfo stateInfo = (StateInfo)this.mStateInfo.get(state);
            do {
                this.mTempStateStack[this.mTempStateStackCount++] = stateInfo;
            } while ((stateInfo = stateInfo.parentStateInfo) != null && !stateInfo.active);
            return stateInfo;
        }

        private final void setupInitialStateStack() {
            StateInfo stateInfo = (StateInfo)this.mStateInfo.get(this.mInitialState);
            this.mTempStateStackCount = 0;
            while (stateInfo != null) {
                this.mTempStateStack[this.mTempStateStackCount] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
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

        private final StateInfo addState(State state, State state2) {
            StateInfo stateInfo;
            StateInfo stateInfo2 = null;
            if (state2 != null && (stateInfo2 = (StateInfo)this.mStateInfo.get(state2)) == null) {
                stateInfo2 = this.addState(state2, null);
            }
            if ((stateInfo = (StateInfo)this.mStateInfo.get(state)) == null) {
                stateInfo = new StateInfo();
                this.mStateInfo.put(state, stateInfo);
            }
            if (stateInfo.parentStateInfo != null && stateInfo.parentStateInfo != stateInfo2) {
                throw new IllegalArgumentException("state already added");
            }
            stateInfo.state = state;
            stateInfo.parentStateInfo = stateInfo2;
            stateInfo.active = false;
            return stateInfo;
        }

        private final void setInitialState(State state) {
            this.mInitialState = state;
        }

        private final void transitionTo(IState iState) {
            this.mDestState = (State)iState;
            this.lc.log(10000000, "[%1.transitionTo] from %2 to %3", (Object)this.logTag, (Object)this.mStateStack[this.mStateStackTopIndex].state.getName(), (Object)this.mDestState.getName());
        }

        private final void deferMessage(Message message) {
            this.lc.log(10000000, "[%1.deferMessage] %2", (Object)this.logTag, (Object)message.toString());
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
                this.lc.log(10000000, "[%1.removeMessages] removing deferred message %2", (Object)this.logTag, (Object)message.toString());
            }
            return this.handler.removeMessages(n);
        }

        public void removeMessages(Predicates.Predicate predicate) {
            Iterator iterator = this.mDeferredMessages.iterator();
            while (iterator.hasNext()) {
                Message message = (Message)iterator.next();
                if (!predicate.apply(message)) continue;
                iterator.remove();
                this.lc.log(10000000, "[%1.removeMessages] removing deferred message %2", (Object)this.logTag, (Object)message.toString());
            }
            this.handler.removeMessages(predicate);
        }

        public boolean hasMessages(int n) {
            return false;
        }

        private class StateInfo {
            State state;
            StateInfo parentStateInfo;
            boolean active;

            private StateInfo() {
            }

            public String toString() {
                return new StringBuffer().append("state=").append(this.state.getName()).append(",active=").append(this.active).append(",parent=").append(this.parentStateInfo == null ? "null" : this.parentStateInfo.state.getName()).toString();
            }
        }

        private class HaltingState
        extends State {
            private HaltingState() {
            }

            public boolean processMessage(Message message) {
                SmImpl.this.mSm.haltedProcessMessage(message);
                return true;
            }
        }

        private class QuittingState
        extends State {
            private QuittingState() {
            }

            public boolean processMessage(Message message) {
                return false;
            }
        }
    }
}

