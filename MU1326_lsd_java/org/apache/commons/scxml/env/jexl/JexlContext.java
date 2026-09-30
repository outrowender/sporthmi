/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env.jexl;

import java.util.Map;
import org.apache.commons.scxml.Builtin;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.env.SimpleContext;

public class JexlContext
extends SimpleContext
implements org.apache.commons.jexl.JexlContext {
    private static final long serialVersionUID = 1L;

    public JexlContext() {
        this.getVars().put("_builtin", new Builtin());
    }

    public JexlContext(Map map) {
        super(map);
        this.getVars().put("_builtin", new Builtin());
    }

    public JexlContext(Context context) {
        super(context);
        this.getVars().put("_builtin", new Builtin());
    }

    public void setVars(Map map) {
        super.setVars(map);
        this.getVars().put("_builtin", new Builtin());
    }

    public Map getVars() {
        return super.getVars();
    }

    public void reset() {
        super.reset();
        this.getVars().put("_builtin", new Builtin());
    }
}

