/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.SwdlEnv;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public abstract class AbstractSwdlDSIHandler
implements DSIListener,
IDSIClient {
    static final String[] EMPTY_STRING_ARRAY = new String[0];
    static final long[] EMPTY_LONG_ARRAY = new long[0];
    static final int[] EMPTY_INT_ARRAY = new int[0];
    static final short[] EMPTY_SHORT_ARRAY = new short[0];
    private final String name;
    private final String asyncErrorTemplate;
    private final SwdlEnv swdlEnv;
    private DSIBase dsi;

    AbstractSwdlDSIHandler(String string, SwdlEnv swdlEnv) {
        this.name = string;
        this.asyncErrorTemplate = "[AbstractSwdlDSIHandler] ".concat(string).concat(" AsyncException(errorCode: %2, errorMsg: %1, requestType: %3) ocurred!");
        this.swdlEnv = swdlEnv;
    }

    private String getName() {
        return this.name;
    }

    protected final AbstractSwdlTextFactory getTextFactory() {
        return this.swdlEnv.getTextFactory();
    }

    protected SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    protected final LogChannel getLogDSI() {
        return this.getSwdlEnv().getLogDSI();
    }

    protected void logStartupEvent(String string) {
        this.getSwdlEnv().logStartupEvent(string);
    }

    protected final DSIBase getDSI() {
        return this.dsi;
    }

    public final boolean isDSIAvailable() {
        return this.dsi != null;
    }

    public final boolean equalsDSI(Object object) {
        return this.dsi == object;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.dsi = dSIBase;
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[0];
    }

    public void setNotification(int[] nArray) {
        if (this.getDSI() != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.getLogDSI().log(1078071040, "[AbstractSwdlDSIHandler] %1.setNotification for attribute %2", (Object)this.getName(), (long)nArray[i2]);
            }
            this.getDSI().setNotification(nArray, (DSIListener)this);
        }
    }

    public void clearNotification(int[] nArray) {
        if (this.getDSI() != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.getLogDSI().log(1078071040, "[AbstractSwdlDSIHandler] %1.clearNotification for attribute %2", (Object)this.getName(), (long)nArray[i2]);
            }
            this.getDSI().clearNotification(nArray, (DSIListener)this);
        }
    }

    void dsiCallbackError(String string, Throwable throwable) {
        this.getLogDSI().log(10000, "[AbstractSwdlDSIHandler] %1.%2() callback failed!", (Object)this.getName(), (Object)string);
        this.getLogDSI().log(10000, "[AbstractSwdlDSIHandler]", throwable);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getLogDSI().log(10000, this.asyncErrorTemplate, (Object)string, (long)n, (long)n2);
    }
}

