/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.content.IContent;
import de.audi.app.media.source.ISourceSlot;

public interface IContentListener {
    public void contentActivated(IContent var1, ISourceSlot var2);

    public void contentActivationFinished(IContent var1);

    public void contentDeactivated(IContent var1);
}

