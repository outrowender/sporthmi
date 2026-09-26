/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.Logger;
import de.audi.tuner.app.storage.TunerStorage;

public abstract class AbstractSetupHandler {
    private int logLevel = -2137614336;
    private int[] currentSetup;
    private String whoAmI;
    protected final Logger logger;
    protected final TunerStorage storage;
    private boolean initialized = false;

    public AbstractSetupHandler(String string, Logger logger, TunerStorage tunerStorage) {
        this.whoAmI = string;
        this.logger = logger;
        this.storage = tunerStorage;
    }

    public void init() {
        this.currentSetup = this.loadSetup();
        this.currentSetup = this.checkSetupByVariant(this.currentSetup);
        this.logger.main.log(this.logLevel, "[%1SetupHandler#init], Initial setup is %2", (Object)this.whoAmI, (Object)this.currentSetup);
        this.initialized = true;
    }

    public void valueUpdated(int n, int n2) {
        if (this.initialized) {
            if (n2 >= 0 && n2 < this.currentSetup.length) {
                if (n != this.currentSetup[n2]) {
                    this.logger.main.log(this.logLevel, "[%1SetupHandler#valueUpdated], Value at position %2 changed (now %3)", (Object)this.whoAmI, (long)n2, (long)n);
                    this.currentSetup[n2] = n;
                    this.storeSetup(this.currentSetup);
                } else {
                    this.logger.main.log(this.logLevel, "[%1SetupHandler#valueUpdated], Value at position %2 did not change (still %3)", (Object)this.whoAmI, (long)n2, (long)this.currentSetup[n2]);
                }
            } else {
                this.logger.main.log(10000, "[%1SetupHandler#valueUpdated], Invalid index (%1) for setup (length %2)", (Object)this.whoAmI, (long)n2, (long)this.currentSetup.length);
            }
        } else {
            this.logger.main.log(10000, "[%1SetupHandler#valueUpdated], skipping, not initialized", (Object)this.whoAmI);
        }
    }

    public void valueUpdated(int[] nArray, int n) {
        if (this.initialized) {
            if (this.currentSetup.length != n + nArray.length) {
                int[] nArray2 = new int[n + nArray.length];
                System.arraycopy((Object)this.currentSetup, 0, (Object)nArray2, 0, n);
                this.currentSetup = nArray2;
            }
            boolean bl = false;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] == this.currentSetup[n + i2]) continue;
                bl = true;
                break;
            }
            if (bl) {
                System.arraycopy((Object)nArray, 0, (Object)this.currentSetup, n, nArray.length);
                this.storeSetup(this.currentSetup);
            }
        } else {
            this.logger.main.log(10000, "[%1SetupHandler#valueUpdated], skipping, not initialized", (Object)this.whoAmI);
        }
    }

    public int[] getCurrentSetup() {
        return this.initialized ? this.currentSetup : null;
    }

    protected abstract int[] loadSetup() {
    }

    protected abstract int[] checkSetupByVariant(int[] nArray) {
    }

    protected abstract void storeSetup(int[] nArray) {
    }
}

