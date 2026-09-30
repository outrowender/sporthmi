/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.tghu.filebrowser.IFileBrowserSession;
import org.dsi.ifc.global.ResourceLocator;

public interface IModelFileBrowser
extends IFileBrowserSession {
    public int getFileCount();

    public boolean chdirUp();

    public ResourceLocator[] getResourceLocators(int var1, int var2);

    public void importSpellerActive(boolean var1);
}

