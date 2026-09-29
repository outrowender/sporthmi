/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.atip.log.LogChannel;

public abstract class AbstractDSIListener {
    protected final LogChannel logger;

    public AbstractDSIListener(LogChannel logChannel) {
        if (logChannel == null) {
            throw new IllegalArgumentException();
        }
        this.logger = logChannel;
    }

    protected abstract String getLogClass() {
    }

    protected final boolean isUpdateValid(String string, int n, int n2) {
        switch (n2) {
            case 1: {
                return true;
            }
            case 2: {
                this.logger.log(1078071040, "[%1.%2] [%3] Received invalid update.", (Object)this.getLogClass(), (Object)string, (long)n);
                return false;
            }
            case 0: {
                this.logger.log(1078071040, "[%1.%2] [%3] Received invalid unknown update.", (Object)this.getLogClass(), (Object)string, (long)n);
                return false;
            }
        }
        this.logger.log(1078071040, "[%1.%2] [%3] Received undefined invalid update (validFlag='%4').", (Object)this.getLogClass(), (Object)string, (Object)new Integer(n), (Object)new Integer(n2));
        return false;
    }

    protected final boolean isUpdateRelevant(String string, int n, int n2) {
        return this.isUpdateValid(string, n, n2);
    }
}

