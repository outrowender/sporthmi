/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.PathInfo;

public interface DSIBrowserBookmarkC {
    public void listBookmarks(String var1) throws MethodException;

    public void addBookmark(Bookmark var1) throws MethodException;

    public void editBookmark(Bookmark var1, Bookmark var2) throws MethodException;

    public void deleteBookmark(Bookmark var1) throws MethodException;

    public void createFolder(Bookmark var1) throws MethodException;

    public void deleteFolder(String var1) throws MethodException;

    public void renameFolder(String var1, String var2) throws MethodException;

    public void exportBookmarks(PathInfo var1) throws MethodException;

    public void importBookmarks(PathInfo var1, boolean var2, boolean var3) throws MethodException;

    public void getQuotaInformation() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

