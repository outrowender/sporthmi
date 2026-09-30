/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaListManager;
import java.util.ArrayList;
import org.dsi.ifc.navigation.ViaPointListElement;

public class LiGetViaPointListCommand
extends NavCommand {
    private ViaListManager listener;
    private int windowSize;
    private int offset;
    private int anchorId;
    private int openedListAnchorId;

    public LiGetViaPointListCommand(ViaListManager viaListManager, int n, int n2, int n3, int n4) {
        this.listener = viaListManager;
        this.windowSize = n;
        this.offset = n2;
        this.anchorId = n3;
        this.openedListAnchorId = n4;
    }

    public void execute() {
        this.logger.log(10000000, "LiGetViaPointListCommand#execute() - calling liGetViaPointList() ");
        this.getDSINavigation().liGetViaPointList(this.windowSize, this.offset, this.anchorId, this.openedListAnchorId);
    }

    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
        this.logger.log(10000000, "LiGetViaPointListCommand#liGetViaPointListResult()");
        if (this.listener != null) {
            this.listener.updateViaList(n, viaPointListElementArray, n2, n3);
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LiGetViaPointListCommand#liGetViaPointListResult() - no listener registered!");
            this.getCommandList().commandAborted("no listener");
        }
    }

    void dummyResult() {
        ArrayList arrayList = new ArrayList(15);
        arrayList.add(new ViaPointListElement(1, "St\u00e4dte", -1L, null, true, -1L, 5));
        if (this.openedListAnchorId == 1) {
            arrayList.add(new ViaPointListElement(10, "Amberg", -1L, null, false, 1L, 0));
            arrayList.add(new ViaPointListElement(11, "Erlangen", -1L, null, false, 1L, 0));
            arrayList.add(new ViaPointListElement(12, "Ingolstadt", -1L, null, false, 1L, 0));
            arrayList.add(new ViaPointListElement(13, "M\u00fcnchen", -1L, null, false, 1L, 0));
            arrayList.add(new ViaPointListElement(14, "N\u00fcrnberg", -1L, null, false, 1L, 0));
        }
        arrayList.add(new ViaPointListElement(20, "Grenz\u00fcberg\u00e4nge", -1L, null, true, -1L, 0));
        arrayList.add(new ViaPointListElement(21, "F\u00e4hren", -1L, null, true, -1L, 0));
        arrayList.add(new ViaPointListElement(22, "Fl\u00fcsse", -1L, null, true, -1L, 0));
        arrayList.add(new ViaPointListElement(23, "Landkreise", -1L, null, true, -1L, 0));
        arrayList.add(new ViaPointListElement(24, "Autobahnkreuze", -1L, null, true, -1L, 0));
        ViaPointListElement[] viaPointListElementArray = new ViaPointListElement[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            viaPointListElementArray[i2] = (ViaPointListElement)arrayList.get(i2);
        }
        this.liGetViaPointListResult(1, viaPointListElementArray, viaPointListElementArray.length, 0);
    }
}

