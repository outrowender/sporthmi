/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ActiveSourceState;

public interface IActiveSourceListener {
    public void activeSourceChanged(boolean var1, ActiveSourceState var2);

    public void sourceDeactivated();
}

