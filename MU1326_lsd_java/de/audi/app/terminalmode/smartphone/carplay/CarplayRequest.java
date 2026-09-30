/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import java.util.HashMap;
import java.util.Map;

public final class CarplayRequest {
    public static final int REQUESTTYPE_UPDATEMODE = 1;
    public static final int REQUESTTYPE_AUDIOTYPE = 2;
    public static final String AUDIOTYPE = "AUDIOTYPE";
    private final long messageId;
    private final int requestType;
    private final Map parameterMap;

    public CarplayRequest(long l, int n) {
        this.messageId = l;
        this.requestType = n;
        this.parameterMap = new HashMap();
    }

    public long getMessageId() {
        return this.messageId;
    }

    public int getType() {
        return this.requestType;
    }

    public void addParameter(String string, Object object) {
        this.parameterMap.put(string, object);
    }

    public Object getParameter(String string) {
        return this.parameterMap.get(string);
    }
}

