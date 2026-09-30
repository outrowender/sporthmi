/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.extension.IContentProvider;
import de.audi.app.media.extension.IMediaTerminalExtension;
import de.audi.app.media.sdis.MediaSDISController;

public class MediaSDISTerminalExtension
implements IMediaTerminalExtension {
    private MediaSDISController controller;

    public void initExtension(IMediaTerminal iMediaTerminal) {
        this.controller = new MediaSDISController(iMediaTerminal);
        this.controller.init();
    }

    public void deinitExtension() {
        this.controller.deinit();
    }

    public IContentProvider getContentProvider() {
        return null;
    }
}

