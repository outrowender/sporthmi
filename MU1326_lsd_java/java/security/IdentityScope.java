/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.PriviAction;
import java.security.AccessController;
import java.security.Identity;
import java.security.KeyManagementException;
import java.security.Principal;
import java.security.PublicKey;
import java.util.Enumeration;

public abstract class IdentityScope
extends Identity {
    private static final long serialVersionUID = -2337346281189773310L;
    static IdentityScope systemScope;

    protected IdentityScope() {
    }

    public IdentityScope(String string) {
        super(string);
    }

    public IdentityScope(String string, IdentityScope identityScope) throws KeyManagementException {
        super(string, identityScope);
    }

    public abstract void addIdentity(Identity var1) throws KeyManagementException;

    public abstract void removeIdentity(Identity var1) throws KeyManagementException;

    public abstract Enumeration identities();

    public Identity getIdentity(Principal principal) {
        Enumeration enumeration = this.identities();
        while (enumeration.hasMoreElements()) {
            Identity identity = (Identity)enumeration.nextElement();
            if (!identity.getName().equals(principal.getName())) continue;
            return identity;
        }
        return null;
    }

    public abstract Identity getIdentity(PublicKey var1);

    public abstract Identity getIdentity(String var1);

    protected static void setSystemScope(IdentityScope identityScope) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("setSystemScope");
        }
        systemScope = identityScope;
    }

    public abstract int size();

    public String toString() {
        String string = "Name : " + this.getName();
        if (this.getScope() != null) {
            string = String.valueOf(string) + "\nScope name : " + this.getScope().getName();
        }
        string = String.valueOf(string) + "\nNumber of identities : " + this.size();
        return string;
    }

    public static IdentityScope getSystemScope() {
        if (systemScope != null) {
            return systemScope;
        }
        String string = (String)AccessController.doPrivileged(PriviAction.getSecurityProperty("system.scope"));
        if (string != null) {
            try {
                Class clazz = Class.forName(string);
                systemScope = (IdentityScope)clazz.newInstance();
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InstantiationException instantiationException) {}
        }
        return systemScope;
    }
}

