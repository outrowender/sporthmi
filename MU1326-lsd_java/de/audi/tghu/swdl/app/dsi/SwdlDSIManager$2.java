/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.tghu.swdl.app.dsi.SwdlDSIManager;
import org.dsi.ifc.swdlselection.LameClient;

class SwdlDSIManager$2
implements Runnable {
    private final /* synthetic */ SwdlDSIManager this$0;

    SwdlDSIManager$2(SwdlDSIManager swdlDSIManager) {
        this.this$0 = swdlDSIManager;
    }

    @Override
    public void run() {
        this.this$0.getSelectionDSIHandler().waitForLameClients();
        SwdlDSIManager.access$200(this.this$0).sleep(0);
        this.this$0.getSelectionDSIHandler().updateLameClients(new LameClient[]{new LameClient("RU", 259), new LameClient("CDC", 261)}, 1);
        SwdlDSIManager.access$200(this.this$0).sleep(0);
        this.this$0.getSelectionDSIHandler().updateLameClients(new LameClient[]{new LameClient("CDC", 261)}, 1);
        SwdlDSIManager.access$200(this.this$0).sleep(0);
        this.this$0.getSelectionDSIHandler().updateLameClients(new LameClient[0], 1);
    }
}

