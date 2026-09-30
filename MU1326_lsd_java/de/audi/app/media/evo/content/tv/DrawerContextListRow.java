/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.tv;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.media.IMediaDrawerElement;

public class DrawerContextListRow
extends EvoListRow {
    private static final int MAX_COLUMNS = 1;
    private static final int COL_ID = 0;
    private static final int DRAWER_OFFSET = 20;
    private final IMediaDrawerElement mediaDrawerElement;

    public DrawerContextListRow(DrawerContextListRow drawerContextListRow) {
        super(drawerContextListRow);
        this.mediaDrawerElement = drawerContextListRow.mediaDrawerElement;
    }

    public DrawerContextListRow(IMediaDrawerElement iMediaDrawerElement) {
        super(iMediaDrawerElement.getID(), 1);
        this.mediaDrawerElement = iMediaDrawerElement;
        this.setInteger(0, iMediaDrawerElement.getID() + 20);
    }

    public DrawerContextListRow(IMediaDrawerElement iMediaDrawerElement, int n) {
        super(iMediaDrawerElement.getID(), 1);
        this.mediaDrawerElement = iMediaDrawerElement;
        this.setInteger(0, iMediaDrawerElement.getID() + n);
    }

    public int getCategoryId() {
        return this.getInteger(0);
    }

    public IMediaDrawerElement getMediaDrawerElement() {
        return this.mediaDrawerElement;
    }

    public EvoListRow copy() {
        return new DrawerContextListRow(this);
    }
}

