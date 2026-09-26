/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestHMIListener;
import de.audi.app.navi.evo.search.IntelliDestHMIListener$1$1;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.NavLocation;

class IntelliDestHMIListener$1
implements Runnable {
    private final /* synthetic */ int val$menuItemID;
    private final /* synthetic */ long val$uniqueListRowID;
    private final /* synthetic */ IntelliDestHMIListener this$0;

    IntelliDestHMIListener$1(IntelliDestHMIListener intelliDestHMIListener, int n, long l) {
        this.this$0 = intelliDestHMIListener;
        this.val$menuItemID = n;
        this.val$uniqueListRowID = l;
    }

    @Override
    public void run() {
        if (IntelliDestHMIListener.access$1600(this.this$0).isHomeAddressMenuItem(this.val$menuItemID)) {
            IntelliDestHMIListener.access$1600(this.this$0).handleHomeAddressFocus();
        } else if (this.val$menuItemID == 1595803136) {
            if (IntelliDestHMIListener.access$700(this.this$0).getFramework().isEvoHigh() && !IntelliDestHMIListener.access$700(this.this$0).getFramework().isEvoHighMMIKombi()) {
                IntelliDestHMIListener.access$500(this.this$0).hidePreviewMap();
                return;
            }
            NavLocation navLocation = IntelliDestHMIListener.access$600(this.this$0).getNavLocation(this.val$uniqueListRowID);
            IntelliDestHMIListener.access$500(this.this$0).focusPreviewMapOnDestination(navLocation);
        } else if (this.val$menuItemID == -1541470720 || this.val$menuItemID == 0x200600 || this.val$menuItemID == -518060544 || this.val$menuItemID == 220202496 || this.val$menuItemID == -937359872 || this.val$menuItemID == -870316544 || this.val$menuItemID == 1310721536 || this.val$menuItemID == -1239480832) {
            IntelliDestHMIListener.access$500(this.this$0).focusPreviewMapOnSearchResult(this.val$uniqueListRowID, this.val$menuItemID);
        } else if (this.val$menuItemID == -1222703616 || this.val$menuItemID == -501283328 || this.val$menuItemID == -903805440) {
            if (IntelliDestHMIListener.access$700(this.this$0).getFramework().isAsia()) {
                CommandList commandList = IntelliDestHMIListener.access$1000(this.this$0).createCommandList();
                commandList.add(new IntelliDestHMIListener$1$1(this, "IntelliDestHMIListener itemFocused"));
                commandList.execute("IntelliDestHMIListener itemFocused");
            } else {
                IntelliDestHMIListener.access$500(this.this$0).hidePreviewMap();
            }
        } else if (this.val$menuItemID != -1641937408) {
            IntelliDestHMIListener.access$500(this.this$0).hidePreviewMap();
        }
    }

    static /* synthetic */ IntelliDestHMIListener access$1700(IntelliDestHMIListener$1 intelliDestHMIListener$1) {
        return intelliDestHMIListener$1.this$0;
    }
}

