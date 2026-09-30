/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth;

import de.esolutions.fw.comm.core.method.MethodException;

public interface PairingCodeValidatorC {
    public void validatePairingCode(String var1, String var2, int var3, int var4) throws MethodException;

    public void updateActiveProfile(int var1, String var2, String var3) throws MethodException;
}

