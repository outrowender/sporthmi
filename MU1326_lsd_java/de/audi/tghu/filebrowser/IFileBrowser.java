/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.tghu.filebrowser.IFileBrowserSession;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public interface IFileBrowser
extends IFileBrowserSession {
    public Path chdir(Path var1);

    public int getSelectedFileCount();

    public int getFileCount();

    public BrowsedFileSet getFiles(int var1, int var2);

    public ResourceLocator[] getResourceLocators(int var1, int var2);

    public boolean selectFile(BrowsedFile var1, boolean var2);

    public IFileBrowser getSelection();

    public PreviewInfo[] getFilesWithPreviews(int var1, int var2, BrowsedFileSet var3) throws IllegalArgumentException, NullPointerException;
}

