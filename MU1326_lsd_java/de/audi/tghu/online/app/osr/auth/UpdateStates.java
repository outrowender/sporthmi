/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import java.util.HashMap;

public final class UpdateStates
extends HashMap {
    private static final long serialVersionUID = -7344014020055883599L;

    public UpdateStates() {
        this.put(new Integer(0), "UPDATE_ADD");
        this.put(new Integer(1), "UPDATE_REMOVE");
        this.put(new Integer(2), "UPDATE_CHANGE");
        this.put(new Integer(3), "UPDATE_ERROR");
    }
}

