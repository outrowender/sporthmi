/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.source.IActivationContext;

public interface IContentManager {
    public IContent getActiveContent();

    public void activateContent(IActivationContext var1);

    public void deactivateActiveContent();

    public IContent getContent(int var1);

    public void addContentListener(IContentListener var1);

    public void removeContentListener(IContentListener var1);
}

