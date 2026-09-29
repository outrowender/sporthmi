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
    default public Path chdir(Path path) {
    }

    default public int getSelectedFileCount() {
    }

    default public int getFileCount() {
    }

    default public BrowsedFileSet getFiles(int n, int n2) {
    }

    default public ResourceLocator[] getResourceLocators(int n, int n2) {
    }

    default public boolean selectFile(BrowsedFile browsedFile, boolean bl) {
    }

    @Override
    default public IFileBrowser getSelection() {
    }

    default public PreviewInfo[] getFilesWithPreviews(int n, int n2, BrowsedFileSet browsedFileSet) {
    }
}

