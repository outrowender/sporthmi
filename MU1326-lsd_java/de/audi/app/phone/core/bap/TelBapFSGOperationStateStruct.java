/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

import de.esolutions.fw.util.commons.Buffer;

public class TelBapFSGOperationStateStruct {
    private final int telState;
    private final boolean privacyModeActive;
    private final boolean enhancedPrivacyModeActive;

    public TelBapFSGOperationStateStruct(int n, boolean bl, boolean bl2) {
        this.telState = n;
        this.privacyModeActive = bl;
        this.enhancedPrivacyModeActive = bl2;
    }

    public int getTelState() {
        return this.telState;
    }

    public boolean isPrivacyModeActive() {
        return this.privacyModeActive;
    }

    public boolean isEnhancedPrivacyModeActive() {
        return this.enhancedPrivacyModeActive;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelBapFSGOperationStateStruct(");
        buffer.append("telState=");
        buffer.append(this.telState);
        buffer.append(", ");
        buffer.append("privacyModeActive=");
        buffer.append(this.privacyModeActive);
        buffer.append(", ");
        buffer.append("enhancedPrivacyModeActive=");
        buffer.append(this.enhancedPrivacyModeActive);
        buffer.append(", ");
        buffer.append(")");
        return buffer.toString();
    }

    public int hashCode() {
        int n = this.privacyModeActive ? 1 : 0;
        int n2 = this.enhancedPrivacyModeActive ? 1 : 0;
        int n3 = 1;
        n3 = 31 * (n3 + this.telState + n + n2);
        return n3;
    }

    public boolean equals(Object object) {
        if (object instanceof TelBapFSGOperationStateStruct) {
            TelBapFSGOperationStateStruct telBapFSGOperationStateStruct = (TelBapFSGOperationStateStruct)object;
            return telBapFSGOperationStateStruct.telState == this.telState && telBapFSGOperationStateStruct.privacyModeActive == this.privacyModeActive && telBapFSGOperationStateStruct.enhancedPrivacyModeActive == this.enhancedPrivacyModeActive;
        }
        return false;
    }
}

