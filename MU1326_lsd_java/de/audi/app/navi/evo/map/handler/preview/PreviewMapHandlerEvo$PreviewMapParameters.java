/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.handler.preview;

import de.audi.app.navi.evo.map.handler.preview.PreviewMapHandlerEvo;

class PreviewMapHandlerEvo$PreviewMapParameters {
    public int width;
    public int height;
    public int offsetX;
    public int offsetY;
    public boolean ignoreForBackupState;
    private final /* synthetic */ PreviewMapHandlerEvo this$0;

    PreviewMapHandlerEvo$PreviewMapParameters(PreviewMapHandlerEvo previewMapHandlerEvo) {
        this.this$0 = previewMapHandlerEvo;
    }

    void setValues(int n, int n2, int n3, int n4, boolean bl) {
        this.width = n;
        this.height = n2;
        this.offsetX = n3;
        this.offsetY = n4;
        this.ignoreForBackupState = bl;
    }
}

