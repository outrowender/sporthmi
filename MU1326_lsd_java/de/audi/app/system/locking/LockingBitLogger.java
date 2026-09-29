/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class LockingBitLogger
implements TimerListener {
    private static final Object mutex = new Object();
    private static LockingBitLogger instance = null;
    private final IFrameworkAccess fw;
    private final LogChannel log;
    private final Object[] namedBitIndexMap = new Object[]{"Tuner", new int[]{0, 16}, "Media", new int[]{16, 24}, "Phone", new int[]{40, 16}, "Navigation", new int[]{56, 40}, "Car", new int[]{96, 24}, "Misc", new int[]{120, 48}};
    private Timer reoccuringLogTimer = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void start(IFrameworkAccess iFrameworkAccess) {
        Object object = mutex;
        synchronized (object) {
            if (instance == null) {
                instance = new LockingBitLogger(iFrameworkAccess);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void stop() {
        Object object = mutex;
        synchronized (object) {
            if (instance != null) {
                instance.stopLogging();
                instance = null;
            }
        }
    }

    private LockingBitLogger(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("App.System.Locking");
        this.reoccuringLogTimer = new Timer("WriteLockingBitsToLogTimer", 0, false, this);
        this.reoccuringLogTimer.start();
    }

    public void stopLogging() {
        this.reoccuringLogTimer.cancel();
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(this.reoccuringLogTimer)) {
            this.writeToLog();
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    private void writeToLog() {
        byte[] byArray = this.fw.getStorageMgr().getByteArray(-536825343, 105, new byte[0]);
        if (byArray == null || byArray.length == 0) {
            this.log.log(-2137614336, "LockingBitLogger#writeToLog() - No locking bits defined in persistence (Persistence response was null or empty).");
            return;
        }
        int[] nArray = this.convertByteArrayToBitStream(byArray);
        for (int i2 = 0; i2 < this.namedBitIndexMap.length - 1; i2 += 2) {
            String string = (String)this.namedBitIndexMap[i2];
            int[] nArray2 = (int[])this.namedBitIndexMap[i2 + 1];
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            for (int i3 = 0; i3 < nArray2[1]; ++i3) {
                stringBuffer.append(nArray[nArray2[0] + i3]);
                if (i3 >= nArray2[1] - 1) continue;
                stringBuffer.append(", ");
            }
            stringBuffer.append("]");
            this.log.log(-2137614336, "LockingBitLogger#writeToLog() - %1: %2", (Object)string, (Object)stringBuffer.toString());
        }
    }

    private int[] convertByteArrayToBitStream(byte[] byArray) {
        int[] nArray = new int[byArray.length * 8];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            int n = 0xFF & byArray[i2];
            int n2 = 1;
            for (int i3 = 0; i3 < 8; ++i3) {
                int n3 = n & n2;
                nArray[8 * i2 + i3] = n3 > 0 ? 1 : 0;
                n2 <<= 1;
            }
        }
        return nArray;
    }
}

