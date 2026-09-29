/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.tghu.navi.app.command.poi.EHGetAllCategoriesCommand;
import de.audi.tghu.navi.app.poi.POICategoryManager;
import de.audi.tghu.navi.app.poi.POICategoryManager$3$1;
import org.dsi.ifc.navigation.Category;

class POICategoryManager$3
extends EHGetAllCategoriesCommand {
    private final /* synthetic */ POICategoryManager this$0;

    POICategoryManager$3(POICategoryManager pOICategoryManager, String string, int n) {
        this.this$0 = pOICategoryManager;
        super(string, n);
    }

    @Override
    protected void processCategories(Category[] categoryArray) {
        this.navigation.getDispatcher().execute(new POICategoryManager$3$1(this, categoryArray));
    }

    static /* synthetic */ POICategoryManager access$300(POICategoryManager$3 pOICategoryManager$3) {
        return pOICategoryManager$3.this$0;
    }
}

