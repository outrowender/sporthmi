/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.extension;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.extension.IContentProvider;

public interface IMediaTerminalExtension {
    public static final String SERVICE_PROPERTY_TERMINALID = "TERMINALID";

    public void initExtension(IMediaTerminal var1);

    public void deinitExtension();

    public IContentProvider getContentProvider();
}

