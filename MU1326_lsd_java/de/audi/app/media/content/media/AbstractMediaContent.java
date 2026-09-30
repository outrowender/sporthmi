/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.AbstractContent;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.IContentMedia;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.NullPlayer;

public abstract class AbstractMediaContent
extends AbstractContent
implements IContentMedia {
    public AbstractMediaContent(int n, IContentContext iContentContext, IMediaTerminal iMediaTerminal) {
        super(n, iContentContext, iMediaTerminal);
    }

    public IPlayer getPlayer() {
        return new NullPlayer();
    }

    public void diagResetBrowser() {
    }
}

