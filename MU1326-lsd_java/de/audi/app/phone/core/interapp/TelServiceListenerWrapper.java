/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.atip.phone.ITelServiceListener;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelServiceListenerWrapper
extends TelDefaultDSIResponseListener {
    private final ITelServiceListener serviceListener;

    public TelServiceListenerWrapper(ITelServiceListener iTelServiceListener) {
        if (iTelServiceListener == null) {
            throw new IllegalArgumentException("TelServiceListenerWrapper: serviceListener is null");
        }
        this.serviceListener = iTelServiceListener;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        this.serviceListener.dialNumberResponse(this.mapResultCode(n));
    }

    protected int mapResultCode(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 9: {
                return 9;
            }
            case 5: {
                return 5;
            }
            case 14: {
                return 14;
            }
            case 13: {
                return 13;
            }
            case 12: {
                return 12;
            }
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 7: {
                return 7;
            }
            case 15: {
                return 15;
            }
            case 16: {
                return 16;
            }
            case 6: {
                return 6;
            }
            case 11: {
                return 11;
            }
            case 8: {
                return 8;
            }
            case 0: {
                return 0;
            }
            case 4: {
                return 4;
            }
            case 65541: {
                return 16;
            }
        }
        return 4;
    }
}

