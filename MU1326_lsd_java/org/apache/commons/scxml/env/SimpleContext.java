/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.Context;

public class SimpleContext
implements Context,
Serializable {
    private static final long serialVersionUID = 1L;
    private Log log = LogFactory.getLog(class$org$apache$commons$scxml$Context == null ? (class$org$apache$commons$scxml$Context = SimpleContext.class$("org.apache.commons.scxml.Context")) : class$org$apache$commons$scxml$Context);
    private Context parent;
    private Map vars;
    static /* synthetic */ Class class$org$apache$commons$scxml$Context;

    public SimpleContext() {
        this(null, null);
    }

    public SimpleContext(Context context) {
        this(context, null);
    }

    public SimpleContext(Map map) {
        this(null, map);
    }

    public SimpleContext(Context context, Map map) {
        this.parent = context;
        this.vars = map == null ? new HashMap() : map;
    }

    public void set(String string, Object object) {
        if (this.vars.containsKey(string)) {
            this.setLocal(string, object);
        } else if (this.parent != null && this.parent.has(string)) {
            this.parent.set(string, object);
        } else {
            this.setLocal(string, object);
        }
    }

    public Object get(String string) {
        if (this.vars.containsKey(string)) {
            return this.vars.get(string);
        }
        if (this.parent != null) {
            return this.parent.get(string);
        }
        return null;
    }

    public boolean has(String string) {
        if (this.vars.containsKey(string)) {
            return true;
        }
        return this.parent != null && this.parent.has(string);
    }

    public void reset() {
        this.vars.clear();
    }

    public Context getParent() {
        return this.parent;
    }

    public void setLocal(String string, Object object) {
        this.vars.put(string, object);
        if (this.log.isDebugEnabled() && !string.equals("_ALL_STATES")) {
            this.log.debug(new StringBuffer().append(string).append(" = ").append(String.valueOf(object)).toString());
        }
    }

    protected void setVars(Map map) {
        this.vars = map;
    }

    public Map getVars() {
        return this.vars;
    }

    protected void setLog(Log log) {
        this.log = log;
    }

    protected Log getLog() {
        return this.log;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

