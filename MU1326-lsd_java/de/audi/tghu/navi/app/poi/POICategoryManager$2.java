/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.POICategoryManager;
import org.dsi.ifc.navigation.Category;

class POICategoryManager$2
extends NavCommand {
    private final /* synthetic */ int val$mapStyleType;
    private final /* synthetic */ POICategoryManager this$0;

    POICategoryManager$2(POICategoryManager pOICategoryManager, String string, int n) {
        this.this$0 = pOICategoryManager;
        this.val$mapStyleType = n;
        super(string);
    }

    @Override
    public void execute() {
        POICategoryManager.access$100(this.this$0).log(-2137614336, "POICategoryManager#fetchPOICategories() - notify %1 registered observers", (long)POICategoryManager.access$000(this.this$0));
        Category[] categoryArray = (Category[])this.getCommandList().get("ehGetAllCatKey");
        for (int i2 = 0; i2 < POICategoryManager.access$000(this.this$0); ++i2) {
            try {
                POICategoryManager.access$200(this.this$0)[i2].processCategories(this.val$mapStyleType, categoryArray);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this.getCommandList().commandFinished();
    }
}

