/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.extension;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;

public interface IContentProvider {
    public boolean provideContent(int var1);

    public IContent createContent(int var1, IContentContext var2, IMediaTerminal var3, IMediaDSIPlayerController var4);
}

