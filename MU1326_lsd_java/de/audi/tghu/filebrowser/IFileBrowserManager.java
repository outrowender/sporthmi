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
    public IFileBrowser open(Path var1, String[] var2);

    public void close(int var1);

    public void resetModels(IFileBrowserModelAccess var1);

    public DSIFileBrowser getDSI();

    public void createPreviewImage(ResourceLocator var1, int var2, int var3, DSIFileBrowserListener var4);

    public ResourceLocator createPreviewImage(ResourceLocator var1, int var2, int var3);

    public void cancelPreviewCreation();

    public void deleteAllPreviewFiles();

    public IModelFileBrowser open(Path var1, String[] var2, IFileBrowserModelAccess var3);

    public IModelFileBrowser open(Path var1, String[] var2, IFileBrowserModelAccess var3, IEvoFileListRowBuilder var4);
}

