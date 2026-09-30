/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.compose.INewMessagePropertyFactory;
import de.audi.app.messaging.evo.drawer.DrawerOptions;
import de.audi.atip.hmi.model.PropertyListCell;
import java.util.ArrayList;

public final class NewMessagePropertyFactoryEvo
implements INewMessagePropertyFactory {
    public PropertyListCell create(boolean bl) {
        int n = 0;
        n = bl ? -25252172 : -1959818898;
        ArrayList arrayList = new ArrayList();
        return DrawerOptions.createPropertyListCell(n, arrayList);
    }
}

