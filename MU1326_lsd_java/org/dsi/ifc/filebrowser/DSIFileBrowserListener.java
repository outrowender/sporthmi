/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.filebrowser;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIFileBrowserListener
extends DSIListener {
    public void startResult(int var1, int var2, Path var3);

    public void setFileExtensionFilterResult(int var1, int var2);

    public void setFileTypeFilterResult(int var1, int var2);

    public void getViewWindowResult(int var1, int var2, int var3, BrowsedFileSet var4, int var5);

    public void getViewWindowWithPreviewsResult(int var1, int var2, int var3, BrowsedFileSet var4, PreviewInfo[] var5, int var6);

    public void getResourceLocatorWindowResult(int var1, int var2, int var3, ResourceLocator[] var4, int var5);

    public void indicateSelectionResult(int var1, int var2, int var3);

    public void changeFolderResult(int var1, int var2, Path var3);

    public void getSelectedFilesResult(int var1, int var2, int var3);

    public void getResourceLocatorsResult(int var1, int var2, ResourceLocator[] var3);

    public void getFileCountResult(int var1, int var2, int var3);

    public void getFileCountWithFileTypeFilterResult(int var1, int var2, int var3, int var4);

    public void spellerResult(int var1, int var2, String var3, String var4);

    public void setLanguageResult(int var1, String var2);

    public void setFileTypeActiveResult(int var1);

    public void validateSpellerCharsResult(int var1, int var2, String var3, String var4);

    public void createPreviewImageResult(ResourceLocator var1, ResourceLocator var2, int var3);

    public void cancelPreviewCreationResult(int var1);
}

