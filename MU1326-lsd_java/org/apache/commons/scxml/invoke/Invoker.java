/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.invoke;

import java.util.Map;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.TriggerEvent;

public interface Invoker {
    default public void setParentStateId(String string) {
    }

    default public void setSCInstance(SCInstance sCInstance) {
    }

    default public void invoke(String string, Map map) {
    }

    default public void parentEvents(TriggerEvent[] triggerEventArray) {
    }

    default public void cancel() {
    }
}

