/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.tghu.filebrowser.IFileBrowser;
import org.dsi.ifc.filebrowser.Path;

public interface IFileBrowserSession {
    public static final long WAIT_TIMEOUT;
    public static final long WAIT_TIMEOUT_RESOURCE_LOCATORS;

    default public int getSession() {
    }

    default public void close() {
    }

    default public Path pwd() {
    }

    default public void setFileTypeFilter(int n) {
    }

    default public int getFileTypeFilter() {
    }

    default public void setFileExtensionFilter(String[] stringArray) {
    }

    default public String[] getFileExtensionFilter() {
    }

    default public IFileBrowser getSelection() {
    }
}

