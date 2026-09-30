/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIFileBrowserReply {
    public static final String IPL_COMM_UUID = "d35f3761-409f-5775-9bad-3b4fe05de089";
    public static final String IPL_COMM_INTERFACE_KEY = "b7f8fe20-4d06-5071-980e-4b9f1153f7d1";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.9";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.9";

    public void startResult(int var1, int var2, Path var3) throws MethodException;

    public void setFileExtensionFilterResult(int var1, int var2) throws MethodException;

    public void setFileTypeFilterResult(int var1, int var2) throws MethodException;

    public void getViewWindowResult(int var1, int var2, int var3, BrowsedFileSet var4, int var5) throws MethodException;

    public void getViewWindowWithPreviewsResult(int var1, int var2, int var3, BrowsedFileSet var4, PreviewInfo[] var5, int var6) throws MethodException;

    public void getResourceLocatorWindowResult(int var1, int var2, int var3, ResourceLocator[] var4, int var5) throws MethodException;

    public void indicateSelectionResult(int var1, int var2, int var3) throws MethodException;

    public void changeFolderResult(int var1, int var2, Path var3) throws MethodException;

    public void getSelectedFilesResult(int var1, int var2, int var3) throws MethodException;

    public void getResourceLocatorsResult(int var1, int var2, ResourceLocator[] var3) throws MethodException;

    public void getFileCountResult(int var1, int var2, int var3) throws MethodException;

    public void getFileCountWithFileTypeFilterResult(int var1, int var2, int var3, int var4) throws MethodException;

    public void spellerResult(int var1, int var2, String var3, String var4) throws MethodException;

    public void setLanguageResult(int var1, String var2) throws MethodException;

    public void setFileTypeActiveResult(int var1) throws MethodException;

    public void validateSpellerCharsResult(int var1, int var2, String var3, String var4) throws MethodException;

    public void createPreviewImageResult(ResourceLocator var1, ResourceLocator var2, int var3) throws MethodException;

    public void cancelPreviewCreationResult(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

