/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.invoke;

import java.util.Map;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.invoke.InvokerException;

public interface Invoker {
    public void setParentStateId(String var1);

    public void setSCInstance(SCInstance var1);

    public void invoke(String var1, Map var2) throws InvokerException;

    public void parentEvents(TriggerEvent[] var1) throws InvokerException;

    public void cancel() throws InvokerException;
}

