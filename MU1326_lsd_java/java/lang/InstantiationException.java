/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class InstantiationException
extends Exception {
    private static final long serialVersionUID = -8441929162975509110L;

    public InstantiationException() {
    }

    public InstantiationException(String string) {
        super(string);
    }

    InstantiationException(Class clazz) {
        super(clazz.getName());
    }
}

