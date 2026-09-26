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

    @Override
    public void listBookmarks(String string) {
        this.log();
    }

    @Override
    public void addBookmark(Bookmark bookmark) {
        this.log();
    }

    @Override
    public void editBookmark(Bookmark bookmark, Bookmark bookmark2) {
        this.log();
    }

    @Override
    public void deleteBookmark(Bookmark bookmark) {
        this.log();
    }

    @Override
    public void createFolder(Bookmark bookmark) {
        this.log();
    }

    @Override
    public void deleteFolder(String string) {
        this.log();
    }

    @Override
    public void renameFolder(String string, String string2) {
        this.log();
    }

    @Override
    public void exportBookmarks(PathInfo pathInfo) {
        this.log();
    }

    @Override
    public void importBookmarks(PathInfo pathInfo, boolean bl, boolean bl2) {
        this.log();
    }

    @Override
    public void getQuotaInformation() {
        this.log();
    }
}

