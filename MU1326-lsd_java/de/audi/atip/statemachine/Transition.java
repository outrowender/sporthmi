/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import java.util.ArrayList;
import java.util.List;

public final class Transition
implements Cloneable {
    private static final int[] EMPTY_INT_LIST = new int[0];
    private static final String[] EMPTY_STRING_LIST = new String[0];
    public static final int INTER_MODULE_FLAG;
    public static final int MEDIATOR_START_FLAG;
    public static final int GUARD_FLAG;
    public static final int LEADS_TO_HISTORY_FLAG;
    public static final int LEADS_TO_FINAL_STATE_FLAG;
    public static final int REINITS_SCREEN_FLAG;
    public static final int ANIMATION_FLAG;
    public static final int ACTION_FLAG;
    public static final int INCLUDE_JUMP_FLAG;
    private static List objPool;
    private int transitionID = -1;
    private int flags = 0;
    private int[] trgtStateList = EMPTY_INT_LIST;
    private String[] trgtExtStateLabelList = EMPTY_STRING_LIST;
    private int[] trgtStateFlagList = EMPTY_INT_LIST;

    private Transition() {
    }

    public static Transition newTransition(int n, int n2, int[] nArray, String[] stringArray, int[] nArray2) {
        Transition transition = Transition.newInstance();
        transition.transitionID = n;
        transition.flags = n2;
        transition.trgtStateList = nArray;
        transition.trgtExtStateLabelList = stringArray;
        transition.trgtStateFlagList = nArray2;
        return transition;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    private static Transition newInstance() {
        Transition transition = null;
        int n = objPool.size();
        if (n > 0) {
            transition = (Transition)objPool.remove(n - 1);
        }
        if (transition != null) {
            return transition;
        }
        return new Transition();
    }

    public int getTransitionID() {
        return this.transitionID;
    }

    public boolean startsMediator() {
        return (this.flags & 2) == 2;
    }

    public boolean isIncludeJumpTransition() {
        return (this.flags & 0x100) == 256;
    }

    public int getMediator() {
        if (this.startsMediator()) {
            return this.trgtStateList[0];
        }
        return -1;
    }

    public int targetStates() {
        if (this.startsMediator()) {
            return 0;
        }
        return this.trgtStateList.length;
    }

    public int getTargetState(int n) {
        if (this.startsMediator(n)) {
            return -1;
        }
        if (n < this.trgtStateList.length) {
            return this.trgtStateList[n];
        }
        return -1;
    }

    public String getTargetExtStateLabel(int n) {
        if (this.startsMediator(n)) {
            return null;
        }
        if (n < this.trgtStateList.length) {
            return this.trgtExtStateLabelList[n];
        }
        return null;
    }

    public int getMediator(int n) {
        if (!this.startsMediator(n)) {
            return -1;
        }
        if (n < this.trgtStateList.length) {
            return this.trgtStateList[n];
        }
        return -1;
    }

    public boolean leadsToFinalState(int n) {
        if (n < this.trgtStateFlagList.length) {
            return (this.trgtStateFlagList[n] & 0x20) == 32;
        }
        return false;
    }

    public boolean leadsToHistory(int n) {
        if (n < this.trgtStateFlagList.length) {
            return (this.trgtStateFlagList[n] & 0x10) == 16;
        }
        return false;
    }

    public boolean reinitsScreen(int n) {
        if (n < this.trgtStateFlagList.length) {
            return (this.trgtStateFlagList[n] & 0x40) == 64;
        }
        return false;
    }

    public boolean animatesScreenChange(int n) {
        if (n < this.trgtStateFlagList.length) {
            return (this.trgtStateFlagList[n] & 0x80) == 128;
        }
        return false;
    }

    public boolean hasAction(int n) {
        if (n < this.trgtStateFlagList.length) {
            return (this.flags & 8) == 8 || (this.trgtStateFlagList[n] & 8) == 8;
        }
        return (this.flags & 8) == 8;
    }

    public boolean startsMediator(int n) {
        if (n < this.trgtStateFlagList.length) {
            return (this.flags & 2) == 2 || (this.trgtStateFlagList[n] & 2) == 2;
        }
        return (this.flags & 2) == 2;
    }

    public boolean hasGuard() {
        return (this.flags & 4) == 4;
    }

    public void dispose() {
        objPool.add(this);
    }

    static {
        objPool = new ArrayList(8);
    }
}

