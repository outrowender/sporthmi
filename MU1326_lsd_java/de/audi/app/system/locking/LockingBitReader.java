/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

import de.audi.app.system.locking.LockingBitLogger;
import de.audi.app.system.locking.LockingBitWrapper;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public final class LockingBitReader
implements TimerListener {
    private static int readIterationCounter = 1;
    private final IFrameworkAccess fw;
    private final LogChannel logChannel;
    private Timer retryReadTimer;

    public LockingBitReader(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.logChannel = iFrameworkAccess.getLogChannel("App.System.Locking");
        this.retryReadTimer = new Timer("LockingBitReader#LockingBitReader()", 5000L, true, this);
        this.retryReadTimer.restart();
        if (this.logChannel.isDebug()) {
            LockingBitLogger.start(iFrameworkAccess);
        } else {
            LockingBitLogger.stop();
        }
    }

    private void loadBits() {
        this.logChannel.log(10000000, "LockingBitReader#loadBits() --> Entered");
        byte[] byArray = this.fw.getStorageMgr().getByteArray(28442848, 105, new byte[0]);
        if ((byArray == null || byArray.length == 0) && readIterationCounter < 3) {
            this.logChannel.log(100000, "LockingBitReader#loadBits() - Persistence was not able to provide data in try %1. Retry in 2 seconds", (long)readIterationCounter);
            ++readIterationCounter;
            this.retryReadTimer = new Timer("LockingBitReader#loadBits()", 2000L, true, this);
            this.retryReadTimer.restart();
            return;
        }
        if (byArray != null && byArray.length > 0) {
            int[] nArray = this.convertByteArrayToBitStream(byArray);
            this.logChannel.log(10000000, "LockingBitReader#loadBits() - Persistence provided data");
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n;
                int[] nArray2 = LockingBitWrapper.getModelsForBitId(i2);
                if (nArray2 != null && nArray2.length > 0) {
                    for (n = 0; n < nArray2.length; ++n) {
                        this.fw.getHMIService().getChoiceModel(nArray2[n]).setValue(nArray[i2]);
                    }
                }
                for (n = 0; n < LockingBitWrapper.FUNCTIONAL_BIT_LIST.length; ++n) {
                    if (i2 != LockingBitWrapper.FUNCTIONAL_BIT_LIST[n]) continue;
                    LockingBitWrapper.setFunctionBitState(i2, nArray[i2]);
                }
            }
        } else {
            this.logChannel.log(10000, "LockingBitReader#loadBits() - The persistence was not able to provide locking bits after 3 tries! No defaults are defined! No locking will take place!");
            this.fw.getStartupMgr().logStartupEvent("LockingBitReader#loadBits() - The persistence was not able to provide locking bits after 3 tries! No defaults are defined! No locking will take place!");
        }
        LockingBitWrapper.setReady(true);
        this.logChannel.log(10000000, "LockingBitReader#loadBits() <-- Exit");
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

    public void fireTimer(Timer timer) {
        if (timer.equals(this.retryReadTimer)) {
            this.loadBits();
        }
    }

    public void cancelTimer(Timer timer) {
    }
}

