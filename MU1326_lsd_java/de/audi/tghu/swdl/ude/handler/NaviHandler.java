/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSINavigation;
import de.audi.tghu.swdl.ude.handler.AbstractClient;
import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.io.File;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;

public final class NaviHandler
extends AbstractClient
implements DSINavigationListener {
    private DSINavigation dsi;

    public NaviHandler(LogChannel logChannel) {
        super(logChannel, new File(WORKING_DIR, "navigation"));
        this.dsi = new NullDSINavigation(logChannel);
    }

    public String toString() {
        return "NaviHandler";
    }

    public int getID() {
        return 2;
    }

    public void addService(Object object) {
        this.lc.log(10000000, "[NaviHandler.registerDSI] %1", object);
        this.dsi = (DSINavigation)object;
    }

    public void removeService(Object object) {
        this.lc.log(10000000, "[NaviHandler.removeService] %1", object);
        this.dsi = new NullDSINavigation(this.lc);
    }

    public void startExport(AbstractIETask abstractIETask) {
        this.lc.log(10000000, "[NaviHandler.startExport] -> DSINavigation.createExportFile(%1, %2)", (Object)this.file, 0L);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.createExportFile(this.file, 0);
    }

    public void startImport(AbstractIETask abstractIETask) {
        if (!new File(this.file).exists()) {
            this.lc.log(1000000, "[NaviHandler.startImport] File not found: %1", (Object)this.file);
            abstractIETask.updateClientResult(this, this.file, false, true);
            return;
        }
        this.lc.log(10000000, "[NaviHandler.startImport] -> DSINavigation.importFile(%1, %2)", (Object)this.file, 0L);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.importFile(this.file, 0);
    }

    public void createExportFileResult(int n, boolean bl) {
        this.lc.log(10000000, "[NaviHandler] <- DSINavigationListener.createExportFileResult(%2, %1)", bl, (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[NaviHandler.createExportFileResult]", (Throwable)exception);
        }
    }

    public void importFileResult(int n, boolean bl) {
        this.lc.log(10000000, "[NaviHandler] <- DSINavigationListener.importFileResult(%2, %1)", bl, (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[NaviHandler.importFileResult]", (Throwable)exception);
        }
    }

    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }
}

