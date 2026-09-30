/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIFileBrowserC {
    public void start(Path var1) throws MethodException;

    public void setFileExtensionFilter(int var1, String[] var2) throws MethodException;

    public void setFileTypeFilter(int var1, int var2) throws MethodException;

    public void stop(int var1) throws MethodException;

    public void getViewWindow(int var1, int var2, int var3) throws MethodException;

    public void getViewWindowWithPreviews(int var1, int var2, int var3) throws MethodException;

    public void getViewWindowFromFile(int var1, int var2, BrowsedFile var3, int var4) throws MethodException;

    public void getResourceLocatorWindow(int var1, int var2, int var3) throws MethodException;

    public void getSelectedFiles(int var1) throws MethodException;

    public void getResourceLocators(int var1, BrowsedFileSet var2) throws MethodException;

    public void getFileCount(int var1) throws MethodException;

    public void getFileCountWithFileTypeFilter(int var1, int var2) throws MethodException;

    public void setSelectionSingle(int var1, BrowsedFile var2, boolean var3) throws MethodException;

    public void setSelection(int var1, int var2) throws MethodException;

    public void changeFolder(int var1, Path var2) throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void startSpeller(int var1, int var2) throws MethodException;

    public void addSpellerChars(int var1, String var2) throws MethodException;

    public void removeSpellerChar(int var1) throws MethodException;

    public void stopSpeller(int var1) throws MethodException;

    public void setFileTypeActive(boolean var1) throws MethodException;

    public void validateSpellerChars(int var1, String var2) throws MethodException;

    public void deleteAllPreviewFiles() throws MethodException;

    public void createPreviewImage(ResourceLocator var1, int var2, int var3) throws MethodException;

    public void cancelPreviewCreation() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

