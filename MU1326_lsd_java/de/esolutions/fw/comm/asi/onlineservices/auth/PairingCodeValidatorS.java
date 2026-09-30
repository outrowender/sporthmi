/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth;

import de.esolutions.fw.comm.asi.onlineservices.auth.PairingCodeValidatorReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface PairingCodeValidatorS {
    public void validatePairingCode(String var1, String var2, int var3, int var4, PairingCodeValidatorReply var5) throws MethodException;

    public void updateActiveProfile(int var1, String var2, String var3, PairingCodeValidatorReply var4) throws MethodException;
}

