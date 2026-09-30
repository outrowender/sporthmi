/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.Serializable;
import java.security.Guard;

public class GuardedObject
implements Serializable {
    private static final long serialVersionUID = -5240450096227834308L;
    Object object;
    Guard guard;

    public GuardedObject(Object object, Guard guard) {
        this.object = object;
        this.guard = guard;
    }

    public Object getObject() throws SecurityException {
        if (this.guard != null) {
            this.guard.checkGuard(this.object);
        }
        return this.object;
    }
}

