/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.actionproxy;

import de.audi.app.media.content.media.utils.MediaUtils;
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
        buffer.append("'").append(this.methodID).append("','").append(MediaUtils.getTerminalIDToStr(this.terminalID)).append("'");
        return buffer.toString();
    }
}

