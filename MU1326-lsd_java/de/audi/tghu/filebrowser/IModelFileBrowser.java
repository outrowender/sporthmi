/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.tghu.filebrowser.IFileBrowserSession;
import org.dsi.ifc.global.ResourceLocator;

public interface IModelFileBrowser
extends IFileBrowserSession {
    default public int getFileCount() {
    }

    default public boolean chdirUp() {
    }

    default public ResourceLocator[] getResourceLocators(int n, int n2) {
    }

    default public void importSpellerActive(boolean bl) {
    }
}

