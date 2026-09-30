/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaBrowser;
import org.dsi.ifc.media.ListEntry;

public class NullDSIMediaBrowser
extends NullService
implements DSIMediaBrowser {
    public NullDSIMediaBrowser(LogChannel logChannel) {
        super(logChannel, "DSIMediaBrowser");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void setNotification(DSIListener dSIListener) {
        this.log("setNotification");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log("clearNotification");
    }

    public void setContentFilter(int n) {
        this.log("setContentFilter");
    }

    public void setBrowseMode(int n) {
        this.log("setBrowseMode");
    }

    public void setBrowseMedia(long l, long l2) {
        this.log("setBrowseMedia");
    }

    public void changeFolder(ListEntry[] listEntryArray) {
        this.log("changeFolder");
    }

    public void requestList(long l, int n, int n2, int n3) {
        this.log("requestList");
    }

    public void requestPickList(int n, long[] lArray) {
        this.log("requestPickList");
    }

    public void enableRecurseSubdirectories(boolean bl) {
        this.log("enableRecurseSubdirectories");
    }

    public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
        this.log("addSelection");
    }

    public void undoLastSelection() {
        this.log("undoLastSelection");
    }

    public void resetSelection() {
        this.log("resetSelection");
    }

    public void setSearchString(String string) {
        this.log("setSearchString");
    }

    public void setSearchCriteria(int n) {
        this.log("setSearchCriteria");
    }

    public void activateSearchSpeller() {
        this.log("activateSearchSpeller");
    }

    public void deactivateSearchSpeller() {
        this.log("deactivateSearchSpeller");
    }

    public void selectSearchResult(long l) {
        this.log("selectSearchResult");
    }

    public void requestSearchList(long l, int n, int n2) {
        this.log("requestSearchList");
    }

    public void resetSearchString() {
        this.log("resetSearchString");
    }

    public void requestSearchListExt(long l, int n, int n2) {
        this.log("requestSearchListExt");
    }

    public void requestPickList(long[] lArray) {
        this.log("requestPickList");
    }

    public void requestFullyQualifiedName(long l) {
        this.log("requestFullyQualifiedName");
    }
}

