/*
 * Decompiled with CFR 0.152.
 */
package java.security.acl;

import java.security.Principal;
import java.util.Enumeration;

public interface Group
extends Principal {
    public boolean addMember(Principal var1);

    public boolean isMember(Principal var1);

    public Enumeration members();

    public boolean removeMember(Principal var1);
}

