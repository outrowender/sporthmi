/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.AbstractSwdlDSIHandler;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerLogging$UnusualEvent;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ILoggingManager;
import org.dsi.ifc.swdllogging.DSISwdlLogging;
import org.dsi.ifc.swdllogging.DSISwdlLoggingListener;

public class SwdlDSIHandlerLogging
extends AbstractSwdlDSIHandler
implements DSISwdlLoggingListener {
    private static final String CLASSNAME;
    protected ILoggingManager loggingManager = null;

    SwdlDSIHandlerLogging(SwdlEnv swdlEnv) {
        super("SwdlDSIHandlerLogging", swdlEnv);
    }

    private DSISwdlLogging getDSISwdlLogging() {
        return (DSISwdlLogging)this.getDSI();
    }

    public void setLoggingManager(ILoggingManager iLoggingManager) {
        this.loggingManager = iLoggingManager;
    }

    public void doGetHistory() {
        this.getLogDSI().log(-2137614336, "%1 -> getHistory()", (Object)"[SwdlDSIHandlerDeviceInfo]");
        this.getDSISwdlLogging().getHistory();
    }

    @Override
    public void getHistory(String[] stringArray, int[] nArray) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- SwdlLogging.getHistory( %2, %3 ) ", (Object)"[SwdlDSIHandlerDeviceInfo]", (Object)stringArray, (Object)nArray);
            if (stringArray != null && nArray != null) {
                this.loggingManager.updateHistory(stringArray, nArray);
            } else {
                this.loggingManager.updateHistory(EMPTY_STRING_ARRAY, EMPTY_INT_ARRAY);
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("getHistory", exception);
        }
    }

    public void doSetUpdate(String string) {
        this.getLogDSI().log(1078071040, "%1 -> setUpdate( %2 )", (Object)"[SwdlDSIHandlerDeviceInfo]", (Object)string);
        this.getDSISwdlLogging().setUpdate(string);
    }

    @Override
    public void setUpdate(int n) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- SwdlLogging.setUpdate( %2 ) ", (Object)"[SwdlDSIHandlerDeviceInfo]", (long)n);
            this.loggingManager.setUpdate(n);
        }
        catch (Exception exception) {
            this.dsiCallbackError("setUpdate", exception);
        }
    }

    public void doSelectSubUpdate(int n) {
        this.getDSISwdlLogging().selectSubUpdate(n);
    }

    public void doGetGeneralInformation() {
        this.getLogDSI().log(-2137614336, "%1 -> getGeneralInformation()", (Object)"[SwdlDSIHandlerDeviceInfo]");
        this.getDSISwdlLogging().getGeneralInformation();
    }

    public void getGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, int n, int[] nArray, boolean bl3, int n2) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- getGeneralInformation( %2, %3 ) ", (Object)"[SwdlDSIHandlerDeviceInfo]", (Object)string3, (Object)string);
            this.getLogDSI().log(1078071040, "%1 <- getGeneralInformation( signature = %2 ) ", (Object)"[SwdlDSIHandlerDeviceInfo]", (Object)nArray);
            this.loggingManager.updateGeneralInformation(bl, string, string2, bl2, string3, n, nArray, bl3, n2);
        }
        catch (Exception exception) {
            this.dsiCallbackError("getGeneralInformation", exception);
        }
    }

    public void getGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, int n, int[] nArray, boolean bl3, int n2, int[] nArray2) {
        this.getGeneralInformation(bl, string, string2, bl2, string3, n, nArray, bl3, n2);
    }

    @Override
    public void getGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, String string4, int[] nArray, boolean bl3, int n, int[] nArray2) {
        this.getGeneralInformation(bl, string, string2, bl2, string3, 0, nArray, bl3, n);
    }

    private final SwdlDSIHandlerLogging$UnusualEvent getUnusualEventData(int n) {
        String[] stringArray = this.getTextFactory().getUnusualEventData(n);
        return new SwdlDSIHandlerLogging$UnusualEvent(this, stringArray[0], stringArray[1]);
    }

    public void doGetUnusualEvents() {
        this.getLogDSI().log(-2137614336, "%1 -> getUnusualEvents()", (Object)"[SwdlDSIHandlerDeviceInfo]");
        this.getDSISwdlLogging().getUnusualEvents();
    }

    @Override
    public void getUnusualEvents(int[] nArray, String[] stringArray) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- getUnusualEvents( %2, %3 ) ", (Object)"[SwdlDSIHandlerDeviceInfo]", (Object)nArray, (Object)stringArray);
            if (nArray == null) {
                nArray = EMPTY_INT_ARRAY;
            }
            if (stringArray == null) {
                stringArray = EMPTY_STRING_ARRAY;
            }
            String[] stringArray2 = new String[nArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                stringArray2[i2] = SwdlDSIHandlerLogging$UnusualEvent.access$000(this.getUnusualEventData(nArray[i2]));
            }
            this.loggingManager.updateUnusualEvents(stringArray2, stringArray);
        }
        catch (Exception exception) {
            this.dsiCallbackError("getUnusualEvents", exception);
        }
    }

    public void doGetUnusualEvent(int n) {
        this.getLogDSI().log(1078071040, "%1 -> getUnusualEvent( %2 )", (Object)"[SwdlDSIHandlerDeviceInfo]", (long)n);
        this.getDSISwdlLogging().getUnusualEvent(n);
    }

    @Override
    public void getUnusualEvent(int n, String string, String string2, String string3, byte by, int n2) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- getUnusualEvent( %4, %2, %3 ) ", (Object)"[SwdlDSIHandlerDeviceInfo]", (Object)string2, (Object)string3, (long)n);
            String string4 = SwdlDSIHandlerLogging$UnusualEvent.access$100(this.getUnusualEventData(n));
            String string5 = StringUtilities.formatMessage(string4, new String[]{string2, string3, Byte.toString(by), string, Integer.toString(n2)});
            this.loggingManager.updateUnusualEvent(string5, n, string, string2, string3, by, n2);
        }
        catch (Exception exception) {
            this.dsiCallbackError("getUnusualEvent", exception);
        }
    }
}

