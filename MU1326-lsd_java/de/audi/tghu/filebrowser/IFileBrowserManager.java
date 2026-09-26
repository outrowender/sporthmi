/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.tghu.filebrowser.IEvoFileListRowBuilder;
import de.audi.tghu.filebrowser.IFileBrowser;
import de.audi.tghu.filebrowser.IFileBrowserModelAccess;
import de.audi.tghu.filebrowser.IModelFileBrowser;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.dsi.ifc.filebrowser.DSIFileBrowserListener;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public interface IFileBrowserManager {
    default public IFileBrowser open(Path path, String[] stringArray) {
    }

    default public void close(int n) {
    }

    default public void resetModels(IFileBrowserModelAccess iFileBrowserModelAccess) {
    }

    default public DSIFileBrowser getDSI() {
    }

    default public void createPreviewImage(ResourceLocator resourceLocator, int n, int n2, DSIFileBrowserListener dSIFileBrowserListener) {
    }

    default public ResourceLocator createPreviewImage(ResourceLocator resourceLocator, int n, int n2) {
    }

    default public void cancelPreviewCreation() {
    }

    default public void deleteAllPreviewFiles() {
    }

    default public IModelFileBrowser open(Path path, String[] stringArray, IFileBrowserModelAccess iFileBrowserModelAccess) {
    }

    default public IModelFileBrowser open(Path path, String[] stringArray, IFileBrowserModelAccess iFileBrowserModelAccess, IEvoFileListRowBuilder iEvoFileListRowBuilder) {
    }
}

