/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.content.IContent;
import de.audi.app.media.source.ISourceSlot;

public interface IContentListener {
    default public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
    }

    default public void contentActivationFinished(IContent iContent) {
    }

    default public void contentDeactivated(IContent iContent) {
    }
}

