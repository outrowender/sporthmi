/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItem;
import de.audi.tghu.swdl.app.list.ISwdlListItem;

public abstract class AbstractSwdlListItemText
extends AbstractSwdlListItem {
    private final AbstractSwdlTextFactory swdlTextFactory;

    public AbstractSwdlListItemText(ISwdlListItem iSwdlListItem, int n, String string, AbstractSwdlTextFactory abstractSwdlTextFactory) {
        super(iSwdlListItem, n, string);
        this.swdlTextFactory = abstractSwdlTextFactory;
    }

    protected final AbstractSwdlTextFactory getTextFactory() {
        return this.swdlTextFactory;
    }
}

