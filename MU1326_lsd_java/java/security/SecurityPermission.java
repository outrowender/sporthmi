/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.BasicPermission;

public final class SecurityPermission
extends BasicPermission {
    private static final long serialVersionUID = 5236109936224050470L;
    static final SecurityPermission permissionToGetPolicy = new SecurityPermission("getPolicy");
    static final SecurityPermission permissionToSetPolicy = new SecurityPermission("setPolicy");

    public SecurityPermission(String string) {
        super(string);
    }

    public SecurityPermission(String string, String string2) {
        super(string, string2);
    }
}

