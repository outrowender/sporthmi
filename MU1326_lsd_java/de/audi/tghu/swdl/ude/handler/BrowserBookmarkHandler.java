/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBrowserBookmark;
import de.audi.tghu.swdl.ude.handler.AbstractClient;
import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.io.File;
import org.dsi.ifc.browser.DSIBrowserBookmark;
import org.dsi.ifc.browser.DSIBrowserBookmarkListener;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.PathInfo;

public class BrowserBookmarkHandler
extends AbstractClient
implements DSIBrowserBookmarkListener {
    private final String logClass;
    private DSIBrowserBookmark dsi;

    public BrowserBookmarkHandler(int n, LogChannel logChannel) {
        super(logChannel, new File(WORKING_DIR, "browser_bookmark" + n));
        this.logClass = "BrowserBookmarkHandler" + n;
        this.dsi = new NullDSIBrowserBookmark(logChannel);
    }

    public void startImport(AbstractIETask abstractIETask) {
        if (!new File(this.file).exists()) {
            this.lc.log(1000000, "[%1.startImport] File not found: %2", (Object)this.logClass, (Object)this.file);
            abstractIETask.updateClientResult(this, this.file, false, true);
            return;
        }
        PathInfo pathInfo = new PathInfo(0, this.file);
        this.lc.log(10000000, "[%1.startImport] %2", (Object)this.logClass, (Object)pathInfo);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.importBookmarks(pathInfo, false, true);
    }

    public void startExport(AbstractIETask abstractIETask) {
        PathInfo pathInfo = new PathInfo(0, this.file);
        this.lc.log(10000000, "[%1.startExport] %2", (Object)this.logClass, (Object)pathInfo);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.exportBookmarks(pathInfo);
    }

    public void importBookmarksResult(PathInfo pathInfo, ImportReport importReport, int n) {
        boolean bl = n == 0;
        this.lc.log(10000000, "[%1.importBookmarksResult] %2 %3", (Object)this.logClass, (Object)pathInfo, (Object)importReport);
        this.lc.log(10000000, "[%1.importBookmarksResult] success:%2 result:%3", (Object)this.logClass, (Object)String.valueOf(bl), (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[%1.importBookmarksResult]", (Object)this.logClass, (Throwable)exception);
        }
    }

    public void exportBookmarksResult(PathInfo pathInfo, int n) {
        boolean bl = n == 0;
        this.lc.log(10000000, "[%1.exportBookmarksResult] %2", (Object)this.logClass, (Object)pathInfo);
        this.lc.log(10000000, "[%1.exportBookmarksResult] success:%2 result:%3", (Object)this.logClass, (Object)String.valueOf(bl), (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[%1.exportBookmarksResult]", (Object)this.logClass, (Throwable)exception);
        }
    }

    public int getID() {
        return 6;
    }

    public String toString() {
        return this.logClass;
    }

    public void addService(Object object) {
        this.lc.log(10000000, "[%1.registerDSI] %2", (Object)this.logClass, object);
        this.dsi = (DSIBrowserBookmark)object;
    }

    public void removeService(Object object) {
        this.lc.log(10000000, "[%1.removeService] %2", (Object)this.logClass, object);
        this.dsi = new NullDSIBrowserBookmark(this.lc);
    }

    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }
}

