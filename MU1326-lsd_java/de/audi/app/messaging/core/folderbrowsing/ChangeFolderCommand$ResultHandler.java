/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import org.dsi.ifc.messaging.FolderEntry;

interface ChangeFolderCommand$ResultHandler {
    default public void handleResult(boolean bl, int n, FolderEntry folderEntry, int n2, int n3, int n4) {
    }
}

