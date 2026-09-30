/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;

public final class State
implements Cloneable {
    private static final int[] EMPTY_INT_LIST = new int[0];
    private static final int MAX_POOL_SIZE = 128;
    public static final int COMPOSITE_FLAG = 1;
    public static final int ENTER_ACTION_FLAG = 2;
    public static final int EXIT_ACTION_FLAG = 4;
    public static final int MEDIATOR_FLAG = 8;
    public static final int HISTORY_FLAG = 16;
    public static final int SHALLOW_HISTORY_FLAG = 48;
    public static final int DEEP_HISTORY_FLAG = 80;
    public static final int SMM_SLOT_FLAG = 129;
    public static final int INCLUDE_FLAG = 257;
    public static final int INCLUDE_SLOT_FLAG = 593;
    public static final int FOCUS_GAINED_ACTION_FLAG = 1024;
    public static final int FOCUS_LOST_ACTION_FLAG = 2048;
    public static final int SDCOMP_PROMPT = 4096;
    public static final int SDCOMP_COMMAND = 8192;
    public static final int SDCOMP_COMMAND_NO_INHERIT = 24576;
    public static final int ENTERED_ACTION_FLAG = 32768;
    private static List objPool = new ArrayList(128);
    private int stateID = -1;
    private int superstateID = -1;
    private int[] triggerEventList = EMPTY_INT_LIST;
    private int[] outgoingTransitionList = EMPTY_INT_LIST;
    private boolean isComposite = false;
    private int includeStateID = -1;
    private int screenID = -1;
    private int flags = 0;
    private int[] mediatorList = EMPTY_INT_LIST;
    private int[] syncTriggerEventList = EMPTY_INT_LIST;
    private int[] syncExitTriggerEventList = EMPTY_INT_LIST;
    private int[] syncTargetIDList = EMPTY_INT_LIST;

    private State() {
    }

    public static State newSimpleState(int n, int n2, int n3, int n4, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, int[] nArray5, int[] nArray6) {
        State state = State.newInstance();
        state.stateID = n;
        state.superstateID = n2;
        state.isComposite = false;
        state.flags = n3;
        state.includeStateID = -1;
        state.screenID = n4;
        state.triggerEventList = nArray;
        state.outgoingTransitionList = nArray2;
        state.mediatorList = nArray3;
        state.syncTriggerEventList = nArray4;
        state.syncExitTriggerEventList = nArray5;
        state.syncTargetIDList = nArray6;
        return state;
    }

    public static State newCompositeState(int n, int n2, int n3, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, int[] nArray5, int[] nArray6) {
        if ((n3 & 0x30) == 48 && (n3 & 0x50) == 80) {
            throw new IllegalArgumentException("A composite state may have either a shallow or deep history, not both!");
        }
        State state = State.newInstance();
        state.stateID = n;
        state.superstateID = n2;
        state.isComposite = true;
        state.flags = n3;
        state.includeStateID = -1;
        state.screenID = -1;
        state.triggerEventList = nArray;
        state.outgoingTransitionList = nArray2;
        state.mediatorList = nArray3;
        state.syncTriggerEventList = nArray4;
        state.syncExitTriggerEventList = nArray5;
        state.syncTargetIDList = nArray6;
        return state;
    }

    public static State newIncludeSlot(int n, int n2, int n3, int[] nArray, int[] nArray2, int n4, int[] nArray3, int[] nArray4, int[] nArray5) {
        if ((n3 & 0x30) == 48 || (n3 & 0x50) != 80) {
            throw new IllegalArgumentException("An include slot must have no shallow history, but a deep history!");
        }
        State state = State.newInstance();
        state.stateID = n;
        state.superstateID = n2;
        state.isComposite = true;
        state.flags = n3;
        state.includeStateID = n4;
        state.screenID = -1;
        state.triggerEventList = nArray;
        state.outgoingTransitionList = nArray2;
        state.mediatorList = EMPTY_INT_LIST;
        state.syncTriggerEventList = nArray3;
        state.syncExitTriggerEventList = nArray4;
        state.syncTargetIDList = nArray5;
        return state;
    }

    public Object clone() {
        State state = State.newInstance();
        state.stateID = this.stateID;
        state.superstateID = this.superstateID;
        state.isComposite = this.isComposite;
        state.flags = this.flags;
        state.includeStateID = this.includeStateID;
        state.screenID = this.screenID;
        state.triggerEventList = this.triggerEventList;
        state.outgoingTransitionList = this.outgoingTransitionList;
        state.mediatorList = this.mediatorList;
        state.syncTriggerEventList = this.syncTriggerEventList;
        state.syncExitTriggerEventList = this.syncExitTriggerEventList;
        state.syncTargetIDList = this.syncTargetIDList;
        return state;
    }

    private static State newInstance() {
        State state = null;
        int n = objPool.size();
        if (n > 0) {
            state = (State)objPool.remove(n - 1);
        }
        if (state != null) {
            return state;
        }
        return new State();
    }

    public int getStateID() {
        return this.stateID;
    }

    public int getSuperstateID() {
        return this.superstateID;
    }

    public int getOutgoingTransition(int n) {
        for (int i2 = 0; i2 < this.triggerEventList.length; ++i2) {
            if (n != this.triggerEventList[i2]) continue;
            return this.outgoingTransitionList[i2];
        }
        return -1;
    }

    public boolean isComposite() {
        return this.isComposite;
    }

    public boolean isInclude() {
        return (this.flags & 0x101) == 257;
    }

    public boolean isIncludeSlot() {
        return (this.flags & 0x251) == 593;
    }

    public int getIncludeStateID() {
        return this.includeStateID;
    }

    public int getScreenID() {
        return this.screenID;
    }

    public boolean hasHistory() {
        return (this.flags & 0x10) == 16;
    }

    public boolean hasShallowHistory() {
        return (this.flags & 0x30) == 48;
    }

    public boolean hasDeepHistory() {
        return (this.flags & 0x50) == 80;
    }

    public boolean hasEnterAction() {
        return (this.flags & 2) != 0;
    }

    public boolean hasEnteredAction() {
        return (this.flags & 0x8000) != 0;
    }

    public boolean hasExitAction() {
        return (this.flags & 4) != 0;
    }

    public boolean hasFocusGainedAction() {
        return (this.flags & 0x400) != 0;
    }

    public boolean hasFocusLostAction() {
        return (this.flags & 0x800) != 0;
    }

    public boolean hasEventMediators() {
        return (this.flags & 8) != 0;
    }

    public boolean hasSDPrompt() {
        return (this.flags & 0x1000) != 0;
    }

    public boolean hasSDCommand() {
        return (this.flags & 0x2000) != 0;
    }

    public boolean hasSDCommandWithoutInheritance() {
        return (this.flags & 0x6000) == 24576;
    }

    public int getAllFlags() {
        return this.flags;
    }

    public boolean hasSyncTriggerEvents() {
        if (this.syncTriggerEventList == null) {
            return false;
        }
        return this.syncTriggerEventList.length > 0;
    }

    public boolean hasSyncExitTriggerEvents() {
        if (this.syncExitTriggerEventList == null) {
            return false;
        }
        return this.syncExitTriggerEventList.length > 0;
    }

    public int[] getSyncTriggerEventIDs() {
        if (this.syncTriggerEventList == null) {
            return new int[0];
        }
        return this.syncTriggerEventList;
    }

    public int[] getSyncExitTriggerEventIDs() {
        if (this.syncExitTriggerEventList == null) {
            return new int[0];
        }
        return this.syncExitTriggerEventList;
    }

    public boolean hasSyncTargets() {
        if (this.syncTargetIDList == null) {
            return false;
        }
        return this.syncTargetIDList.length > 0;
    }

    public int[] getSyncTargetIDList() {
        if (this.syncTargetIDList == null) {
            return new int[0];
        }
        return this.syncTargetIDList;
    }

    public int[] getEventMediatorIDs() {
        return this.mediatorList;
    }

    public void dispose() {
        if (objPool.size() < 128) {
            objPool.add(this);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("[state=(STATEID#").append(this.stateID).append("), ");
        buffer.append("superStateID=(STATEID#").append(this.superstateID).append("), ");
        buffer.append("isComposite=").append(this.isComposite).append(", ");
        buffer.append("screenID=").append(this.screenID).append(", ");
        buffer.append("flags=").append(this.flags).append("]");
        return buffer.toString();
    }
}

