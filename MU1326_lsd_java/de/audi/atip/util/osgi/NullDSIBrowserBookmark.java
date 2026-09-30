/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.DSIBrowserBookmark;
import org.dsi.ifc.browser.PathInfo;

public class NullDSIBrowserBookmark
extends NullDSIBase
implements DSIBrowserBookmark {
    public NullDSIBrowserBookmark(LogChannel logChannel) {
        super(logChannel, "DSIBrowserBookmark");
    }

    public void listBookmarks(String string) {
        this.log();
    }

    public void addBookmark(Bookmark bookmark) {
        this.log();
    }

    public void editBookmark(Bookmark bookmark, Bookmark bookmark2) {
        this.log();
    }

    public void deleteBookmark(Bookmark bookmark) {
        this.log();
    }

    public void createFolder(Bookmark bookmark) {
        this.log();
    }

    public void deleteFolder(String string) {
        this.log();
    }

    public void renameFolder(String string, String string2) {
        this.log();
    }

    public void exportBookmarks(PathInfo pathInfo) {
        this.log();
    }

    public void importBookmarks(PathInfo pathInfo, boolean bl, boolean bl2) {
        this.log();
    }

    public void getQuotaInformation() {
        this.log();
    }
}

