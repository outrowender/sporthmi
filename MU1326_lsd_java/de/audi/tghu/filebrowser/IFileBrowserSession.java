/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.tghu.filebrowser.IFileBrowser;
import org.dsi.ifc.filebrowser.Path;

public interface IFileBrowserSession {
    public static final long WAIT_TIMEOUT = 5000L;
    public static final long WAIT_TIMEOUT_RESOURCE_LOCATORS = 20000L;

    public int getSession();

    public void close();

    public Path pwd();

    public void setFileTypeFilter(int var1);

    public int getFileTypeFilter();

    public void setFileExtensionFilter(String[] var1);

    public String[] getFileExtensionFilter();

    public IFileBrowser getSelection();
}

