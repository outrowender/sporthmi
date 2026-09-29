/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.adb.AddAddressToContactSelectionListRow;
import de.audi.app.navi.evo.search.AdbContactsGuiSearchHandler;
import de.audi.app.navi.evo.search.AdbContactsGuiSearchHandler$2;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.command.NavCommand;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;

class AdbContactsGuiSearchHandler$2$1
extends NavCommand {
    private final /* synthetic */ boolean val$locationExisted;
    private final /* synthetic */ int val$addressType;
    private final /* synthetic */ AdbContactsGuiSearchHandler$2 this$1;

    AdbContactsGuiSearchHandler$2$1(AdbContactsGuiSearchHandler$2 adbContactsGuiSearchHandler$2, String string, boolean bl, int n) {
        this.this$1 = adbContactsGuiSearchHandler$2;
        this.val$locationExisted = bl;
        this.val$addressType = n;
        super(string);
    }

    @Override
    public void execute() {
        Object object;
        Buffer buffer = new Buffer();
        if (this.val$locationExisted) {
            object = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
            this.logger.log(-2137614336, "AdbContactsGuiSearchHandler#createAddRowCommand - navlocation=%1", object);
            String[] stringArray = AdbContactsGuiSearchHandler$2.access$200((AdbContactsGuiSearchHandler$2)this.this$1).adbInterAppService.getLocationNameForNavLocation((NavLocation)object);
            buffer.append(stringArray[0]);
            if (!"".equals(stringArray[1])) {
                buffer.append(", ").append(stringArray[1]);
            }
        }
        object = new AddAddressToContactSelectionListRow(this.val$addressType, this.val$locationExisted, buffer.toString(), this.val$addressType);
        AdbContactsGuiSearchHandler.access$100(AdbContactsGuiSearchHandler$2.access$200(this.this$1)).append((EvoListRow)object);
        this.getCommandList().commandFinished();
    }
}

