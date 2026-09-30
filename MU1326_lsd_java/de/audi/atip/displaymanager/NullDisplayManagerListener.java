/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.interapp.displaymanager.IDisplayManagerListener;
import de.audi.atip.log.LogChannel;

public class NullDisplayManagerListener
implements IDisplayManagerListener {
    private static final String LOGCLASS = "NullDisplayManagerListener";
    private final LogChannel logger;

    public NullDisplayManagerListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void startComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "[%1.startComponentResult]", (Object)LOGCLASS);
    }

    public void stopComponentResult(int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "[%1.stopComponentResult]", (Object)LOGCLASS);
    }

    public void setCroppingResult(int n) {
        this.logger.log(1000000, "[%1.setCroppingResult]", (Object)LOGCLASS);
    }

    public void error() {
        this.logger.log(1000000, "[%1.error]", (Object)LOGCLASS);
    }
}

