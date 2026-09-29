/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.AbstractWindow;

public class AbstractWindow$NativeWindowUpdater
implements Runnable {
    private static boolean doUpdate = false;
    private final boolean working;
    private AbstractWindow window;
    private int timerIntervall = 400;

    public AbstractWindow$NativeWindowUpdater(AbstractWindow abstractWindow, int n) {
        this.working = true;
        this.window = abstractWindow;
        this.timerIntervall = n;
    }

    public static void startUpdating() {
        doUpdate = true;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            Thread.interrupted();
        }
        while (true) {
            try {
                Thread.sleep(this.timerIntervall);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
            if (!doUpdate) continue;
            this.window.postRepaintEvent();
        }
    }
}

