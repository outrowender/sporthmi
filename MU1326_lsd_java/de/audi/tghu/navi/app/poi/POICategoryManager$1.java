/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.tghu.navi.app.command.poi.EHGetAllCategoriesCommand;
import de.audi.tghu.navi.app.poi.POICategoryManager;
import org.dsi.ifc.navigation.Category;

class POICategoryManager$1
extends EHGetAllCategoriesCommand {
    private final /* synthetic */ POICategoryManager this$0;

    POICategoryManager$1(POICategoryManager pOICategoryManager, String string, int n) {
        this.this$0 = pOICategoryManager;
        super(string, n);
    }

    @Override
    protected void processCategories(Category[] categoryArray) {
        this.getCommandList().put("ehGetAllCatKey", categoryArray);
    }
}

