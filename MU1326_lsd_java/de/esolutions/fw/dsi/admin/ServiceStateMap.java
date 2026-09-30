/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import java.util.HashMap;
import java.util.Map;

public final class ServiceStateMap {
    public static final int ADDED = 0;
    public static final int PENDING = 1;
    public static final int REGISTERED = 2;
    private final Map svcMap = new HashMap();

    public synchronized boolean checkAndAddService(String string, int n) {
        if (string == null) {
            return false;
        }
        String string2 = this.genKey(string, n);
        State state = this.getState(string, n);
        if (state != null) {
            state.stopFlag = false;
            state.restartFlag = true;
            return false;
        }
        this.svcMap.put(string2, new State());
        return true;
    }

    public synchronized boolean removeService(String string, int n) {
        if (string == null) {
            return false;
        }
        String string2 = this.genKey(string, n);
        return this.svcMap.remove(string2) != null;
    }

    public synchronized boolean removeStopFlag(String string, int n) {
        if (string == null) {
            return false;
        }
        String string2 = this.genKey(string, n);
        State state = (State)this.svcMap.get(string2);
        if (state == null) {
            return false;
        }
        state.stopFlag = false;
        return true;
    }

    public synchronized boolean setServiceState(String string, int n, int n2) {
        State state = this.getState(string, n);
        if (state == null) {
            return false;
        }
        state.state = n2;
        return true;
    }

    public synchronized Integer getServiceState(String string, int n) {
        State state = this.getState(string, n);
        if (state == null) {
            return null;
        }
        return new Integer(state.state);
    }

    public synchronized boolean isEmpty() {
        return this.svcMap.isEmpty();
    }

    public synchronized Boolean checkAndSetStopFlag(String string, int n) {
        State state = this.getState(string, n);
        if (state == null) {
            return null;
        }
        if (!state.stopFlag) {
            state.stopFlag = true;
            state.restartFlag = false;
            return new Boolean(true);
        }
        return new Boolean(false);
    }

    public synchronized Boolean getStopFlag(String string, int n) {
        State state = this.getState(string, n);
        if (state == null) {
            return null;
        }
        return new Boolean(state.stopFlag);
    }

    private String genKey(String string, int n) {
        return string + Integer.toString(n);
    }

    private State getState(String string, int n) {
        if (string == null) {
            return null;
        }
        String string2 = this.genKey(string, n);
        State state = (State)this.svcMap.get(string2);
        return state;
    }

    public synchronized Boolean checkAndClearStopFlag(String string, int n) {
        State state = this.getState(string, n);
        if (state == null) {
            return null;
        }
        if (state.stopFlag) {
            state.stopFlag = false;
            return new Boolean(true);
        }
        return new Boolean(false);
    }

    public synchronized Boolean checkAndClearRestartFlag(String string, int n) {
        State state = this.getState(string, n);
        if (state == null) {
            return null;
        }
        if (state.restartFlag) {
            state.restartFlag = false;
            return new Boolean(true);
        }
        return new Boolean(false);
    }

    public synchronized boolean removeRestartFlag(String string, int n) {
        if (string == null) {
            return false;
        }
        String string2 = this.genKey(string, n);
        State state = (State)this.svcMap.get(string2);
        if (state == null) {
            return false;
        }
        state.restartFlag = false;
        return true;
    }

    private static class State {
        public int state = 0;
        public boolean stopFlag = false;
        public boolean restartFlag;
    }
}

