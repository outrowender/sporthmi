/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBrowser;
import de.audi.tghu.swdl.ude.handler.AbstractClient;
import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.io.File;
import org.dsi.ifc.browser.DSIBrowser;
import org.dsi.ifc.browser.DSIBrowserListener;
import org.dsi.ifc.browser.KeyboardInfo;

public class BrowserHandler
extends AbstractClient
implements DSIBrowserListener {
    private final String logClass;
    private DSIBrowser dsi;

    public BrowserHandler(int n, LogChannel logChannel) {
        super(logChannel, new File(WORKING_DIR, new StringBuffer().append("browser").append(n).toString()));
        this.logClass = new StringBuffer().append("BrowserHandler").append(n).toString();
        this.dsi = new NullDSIBrowser(logChannel);
    }

    @Override
    public void startImport(AbstractIETask abstractIETask) {
        if (!new File(this.file).exists()) {
            this.lc.log(1078071040, "[%1.startImport] File not found: %2", (Object)this.logClass, (Object)this.file);
            abstractIETask.updateClientResult(this, this.file, false, true);
            return;
        }
        this.lc.log(-2137614336, "[%1.startImport] %2", (Object)this.logClass, (Object)this.file);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.importBrowserData(this.file);
    }

    @Override
    public void startExport(AbstractIETask abstractIETask) {
        this.lc.log(-2137614336, "[%1.startExport] %2", (Object)this.logClass, (Object)this.file);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.exportBrowserData(this.file);
    }

    @Override
    public void importBrowserDataResult(int n) {
        boolean bl = n == 0;
        this.lc.log(-2137614336, "[%1.importBrowserDataResult] status:%3 success:%2", (Object)this.logClass, (Object)String.valueOf(bl), (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[%1.importBrowserDataResult]", (Object)this.logClass, (Throwable)exception);
        }
    }

    @Override
    public void exportBrowserDataResult(int n) {
        boolean bl = n == 0;
        this.lc.log(-2137614336, "[%1.exportBrowserDataResult] status:%3 success:%2", (Object)this.logClass, (Object)String.valueOf(bl), (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[%1.exportBrowserDataResult]", (Object)this.logClass, (Throwable)exception);
        }
    }

    @Override
    public int getID() {
        return 5;
    }

    public String toString() {
        return this.logClass;
    }

    @Override
    public void addService(Object object) {
        this.lc.log(-2137614336, "[%1.registerDSI] %2", (Object)this.logClass, object);
        this.dsi = (DSIBrowser)object;
    }

    @Override
    public void removeService(Object object) {
        this.lc.log(-2137614336, "[%1.removeDSI] %2", (Object)this.logClass, object);
        this.dsi = new NullDSIBrowser(this.lc);
    }

    @Override
    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }
}

