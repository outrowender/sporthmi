/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.context;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.jexl.JexlContext;

public class HashMapContext
extends HashMap
implements JexlContext {
    static final long serialVersionUID;

    @Override
    public void setVars(Map map) {
        this.clear();
        this.putAll(map);
    }

    @Override
    public Map getVars() {
        return this;
    }
}

