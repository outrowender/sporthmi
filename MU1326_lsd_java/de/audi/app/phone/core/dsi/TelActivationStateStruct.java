/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

public class TelActivationStateStruct
extends ActivationStateStruct {
    private static boolean containsFeature(int n, int n2) {
        return (n2 & n) == n;
    }

    private static String getTelFeatName(int n) {
        switch (n) {
            case 64: {
                return "ADD_TO_CONFERENCE";
            }
            case 16: {
                return "ENHCALL";
            }
            case 128: {
                return "ENHCONFERENCE_TRANSFER";
            }
            case 32: {
                return "ENHSTAT";
            }
            case 1: {
                return "INBAND";
            }
            case 2: {
                return "REJECTCALL";
            }
            case 256: {
                return "REJECTMOBILE";
            }
            case 4: {
                return "RESPHOLD";
            }
            case 8: {
                return "THREEWAY";
            }
            case 0: {
                return "UNKNOWN";
            }
        }
        return "Unknown telFeat " + n;
    }

    private static String getTelFeatures(int n) {
        Buffer buffer = new Buffer();
        buffer.append(n);
        buffer.append("(");
        if (n == 0) {
            buffer.append(TelActivationStateStruct.getTelFeatName(n));
        } else {
            int n2 = 0;
            int n3 = 0;
            for (int i2 = 0; i2 < 32; ++i2) {
                n2 = n2 == 0 ? 1 : (n2 <<= 1);
                if (!TelActivationStateStruct.containsFeature(n2, n)) continue;
                if (n3 > 0) {
                    buffer.append('|');
                }
                buffer.append(TelActivationStateStruct.getTelFeatName(n2));
                ++n3;
            }
        }
        buffer.append(")");
        return buffer.toString();
    }

    public TelActivationStateStruct(ActivationStateStruct activationStateStruct) {
        if (activationStateStruct != null) {
            this.telActivationState = activationStateStruct.telActivationState;
            this.telFeat = activationStateStruct.telFeat;
            this.telHFPVersion = activationStateStruct.telHFPVersion;
            this.telMode = activationStateStruct.telMode;
            this.telPhoneModuleState = activationStateStruct.telPhoneModuleState;
        }
    }

    public TelActivationStateStruct(int n, int n2, int n3, short s, String string) {
        super(n, n2, n3, s, string);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ActivationStateStruct");
        buffer.append('(');
        buffer.append("telActivationState");
        buffer.append('=');
        buffer.append(this.telActivationState);
        buffer.append(',');
        buffer.append("telPhoneModuleState");
        buffer.append('=');
        buffer.append(this.telPhoneModuleState);
        buffer.append(',');
        buffer.append("telMode");
        buffer.append('=');
        buffer.append(this.telMode);
        buffer.append(',');
        buffer.append("telFeat");
        buffer.append('=');
        buffer.append(TelActivationStateStruct.getTelFeatures(this.telFeat));
        buffer.append(',');
        buffer.append("telHFPVersion");
        buffer.append('=');
        buffer.append('\"');
        buffer.append(this.telHFPVersion);
        buffer.append('\"');
        buffer.append(')');
        return buffer.toString();
    }
}

