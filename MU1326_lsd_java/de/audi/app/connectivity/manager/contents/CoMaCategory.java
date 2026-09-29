/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.CoMaCategoryPreview;
import de.audi.app.connectivity.manager.contents.CoMaRow;

public final class CoMaCategory {
    private final int categoryID;
    private final int service;
    private final boolean hasNewDeviceLine;
    private final boolean supportsMultipleSelection;
    private final CoMaRow newDeviceLine;
    private CoMaCategoryPreview preview;

    public CoMaCategory(int n, int n2, boolean bl, boolean bl2) {
        this.categoryID = n;
        this.service = n2;
        this.hasNewDeviceLine = bl;
        this.supportsMultipleSelection = bl2;
        this.newDeviceLine = bl ? new CoMaRow(n) : null;
    }

    boolean supportsMultipleSelection() {
        return this.supportsMultipleSelection;
    }

    int getCategoryID() {
        return this.categoryID;
    }

    int getService() {
        return this.service;
    }

    boolean hasNewDeviceLine() {
        return this.hasNewDeviceLine;
    }

    CoMaRow getNewDeviceLine() {
        return this.newDeviceLine;
    }

    CoMaCategoryPreview getPreview() {
        return this.preview;
    }

    public void setPreview(CoMaCategoryPreview coMaCategoryPreview) {
        this.preview = coMaCategoryPreview;
    }

    String getPreviewString() {
        return this.preview != null ? this.preview.getPreview() : "";
    }
}

