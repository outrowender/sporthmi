/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.media.ListEntry;

public interface DSIMediaBrowserC {
    public void setContentFilter(int var1) throws MethodException;

    public void setBrowseMode(int var1) throws MethodException;

    public void setBrowseMedia(long var1, long var3) throws MethodException;

    public void changeFolder(ListEntry[] var1) throws MethodException;

    public void requestList(long var1, int var3, int var4, int var5) throws MethodException;

    public void requestPickList(long[] var1) throws MethodException;

    public void enableRecurseSubdirectories(boolean var1) throws MethodException;

    public void addSelection(boolean var1, int var2, long var3, int var5, boolean var6) throws MethodException;

    public void undoLastSelection() throws MethodException;

    public void resetSelection() throws MethodException;

    public void setSearchString(String var1) throws MethodException;

    public void setSearchCriteria(int var1) throws MethodException;

    public void activateSearchSpeller() throws MethodException;

    public void deactivateSearchSpeller() throws MethodException;

    public void selectSearchResult(long var1) throws MethodException;

    public void requestSearchList(long var1, int var3, int var4) throws MethodException;

    public void resetSearchString() throws MethodException;

    public void requestSearchListExt(long var1, int var3, int var4) throws MethodException;

    public void requestFullyQualifiedName(long var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

