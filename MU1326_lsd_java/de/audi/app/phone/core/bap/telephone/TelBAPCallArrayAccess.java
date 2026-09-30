/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPCall;
import de.audi.atip.interapp.combi.bap.phone.data.CallStartTime;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallInfo;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallState;
import de.audi.atip.log.LogChannel;

public class TelBAPCallArrayAccess {
    private static final int MAX_CALLS = 7;
    private final TelBAPCall[] bapPhoneCalls = new TelBAPCall[7];
    private final LogChannel log;
    private final Object lock = new Object();

    TelBAPCallArrayAccess(LogChannel logChannel) {
        this.log = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    TelBAPCall getBAPCall(int n) {
        TelBAPCall telBAPCall = null;
        Object object = this.lock;
        synchronized (object) {
            if (n >= 0 && n < 7) {
                telBAPCall = this.bapPhoneCalls[n];
            }
        }
        return telBAPCall;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setArray(TelBAPCall[] telBAPCallArray) {
        Object object = this.lock;
        synchronized (object) {
            if (telBAPCallArray != null && telBAPCallArray.length == 7) {
                System.arraycopy((Object)telBAPCallArray, 0, (Object)this.bapPhoneCalls, 0, 7);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int getDSICallID(int n) {
        int n2 = -1;
        Object object = this.lock;
        synchronized (object) {
            if (n >= 0 && n < 7) {
                n2 = this.bapPhoneCalls[n] != null ? this.bapPhoneCalls[n].getCallID() : -1;
            }
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    CombiBAPCallState[] getCallStateArray() {
        CombiBAPCallState[] combiBAPCallStateArray = new CombiBAPCallState[7];
        Object object = this.lock;
        synchronized (object) {
            for (int i2 = 0; i2 < 7; ++i2) {
                combiBAPCallStateArray[i2] = this.bapPhoneCalls[i2] != null ? this.bapPhoneCalls[i2].getCallState() : null;
            }
        }
        return combiBAPCallStateArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    CombiBAPCallInfo[] getCallInfoArray() {
        CombiBAPCallInfo[] combiBAPCallInfoArray = new CombiBAPCallInfo[7];
        Object object = this.lock;
        synchronized (object) {
            for (int i2 = 0; i2 < 7; ++i2) {
                combiBAPCallInfoArray[i2] = this.bapPhoneCalls[i2] != null ? this.bapPhoneCalls[i2].getCallInfo() : null;
            }
        }
        return combiBAPCallInfoArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    CallStartTime[] getCallStartingTimesArray() {
        CallStartTime[] callStartTimeArray = new CallStartTime[7];
        Object object = this.lock;
        synchronized (object) {
            for (int i2 = 0; i2 < 7; ++i2) {
                callStartTimeArray[i2] = this.bapPhoneCalls[i2] != null ? this.bapPhoneCalls[i2].getCallStartTime() : new CallStartTime(65535);
            }
        }
        return callStartTimeArray;
    }
}

