/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.actionproxy;

import de.esolutions.fw.util.commons.Buffer;

class ActionProxyMethod {
    private final int methodID;
    private final int terminalID;

    public ActionProxyMethod(int n, int n2) {
        this.methodID = n;
        this.terminalID = n2;
    }

    public int getMethodID() {
        return this.methodID;
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    public int hashCode() {
        return new Integer(this.methodID + this.terminalID * 10000).hashCode();
    }

    public boolean equals(Object object) {
        try {
            ActionProxyMethod actionProxyMethod = (ActionProxyMethod)object;
            return actionProxyMethod.getMethodID() == this.methodID && actionProxyMethod.getTerminalID() == this.terminalID;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(10);
        buffer.append("'").append(this.methodID).append("','").append(this.terminalID).append("'");
        return buffer.toString();
    }
}

