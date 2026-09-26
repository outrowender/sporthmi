/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li.sc;

import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.esolutions.fw.util.commons.Buffer;

public class SpellerContext {
    private final int contextID;

    public SpellerContext(int n) {
        this.contextID = n;
        this.reset();
    }

    public int getContextID() {
        return this.contextID;
    }

    public String toString() {
        return SpellerContextManager.contextIDToString(this.contextID);
    }

    public void reset() {
    }

    public String printStatus() {
        Buffer buffer = new Buffer();
        buffer.append(this).append('\n');
        buffer.append("status n/a").append('\n');
        return buffer.toString();
    }
}

