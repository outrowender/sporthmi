/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.extension;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;

public interface IContentProvider {
    default public boolean provideContent(int n) {
    }

    default public IContent createContent(int n, IContentContext iContentContext, IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
    }
}

