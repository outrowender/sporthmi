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

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log("setNotification");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log("setNotification");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log("setNotification");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log("clearNotification");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log("clearNotification");
    }

    @Override
    public void setContentFilter(int n) {
        this.log("setContentFilter");
    }

    @Override
    public void setBrowseMode(int n) {
        this.log("setBrowseMode");
    }

    @Override
    public void setBrowseMedia(long l, long l2) {
        this.log("setBrowseMedia");
    }

    @Override
    public void changeFolder(ListEntry[] listEntryArray) {
        this.log("changeFolder");
    }

    @Override
    public void requestList(long l, int n, int n2, int n3) {
        this.log("requestList");
    }

    public void requestPickList(int n, long[] lArray) {
        this.log("requestPickList");
    }

    @Override
    public void enableRecurseSubdirectories(boolean bl) {
        this.log("enableRecurseSubdirectories");
    }

    @Override
    public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
        this.log("addSelection");
    }

    @Override
    public void undoLastSelection() {
        this.log("undoLastSelection");
    }

    @Override
    public void resetSelection() {
        this.log("resetSelection");
    }

    @Override
    public void setSearchString(String string) {
        this.log("setSearchString");
    }

    @Override
    public void setSearchCriteria(int n) {
        this.log("setSearchCriteria");
    }

    @Override
    public void activateSearchSpeller() {
        this.log("activateSearchSpeller");
    }

    @Override
    public void deactivateSearchSpeller() {
        this.log("deactivateSearchSpeller");
    }

    @Override
    public void selectSearchResult(long l) {
        this.log("selectSearchResult");
    }

    @Override
    public void requestSearchList(long l, int n, int n2) {
        this.log("requestSearchList");
    }

    @Override
    public void resetSearchString() {
        this.log("resetSearchString");
    }

    @Override
    public void requestSearchListExt(long l, int n, int n2) {
        this.log("requestSearchListExt");
    }

    @Override
    public void requestPickList(long[] lArray) {
        this.log("requestPickList");
    }

    @Override
    public void requestFullyQualifiedName(long l) {
        this.log("requestFullyQualifiedName");
    }
}

