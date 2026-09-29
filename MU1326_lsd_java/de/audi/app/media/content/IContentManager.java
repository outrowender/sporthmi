/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.source.IActivationContext;

public interface IContentManager {
    default public IContent getActiveContent() {
    }

    default public void activateContent(IActivationContext iActivationContext) {
    }

    default public void deactivateActiveContent() {
    }

    default public IContent getContent(int n) {
    }

    default public void addContentListener(IContentListener iContentListener) {
    }

    default public void removeContentListener(IContentListener iContentListener) {
    }
}

