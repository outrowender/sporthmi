/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiResultsLimitedInputSequence
extends PoiResultsGeneralInputSequence {
    public PoiResultsLimitedInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, boolean bl, int n) {
        super(iPoiSpellerModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, lIValueListElement, iVehicle, bl, n, null);
    }

    public CommandList createStartSequence() {
        CommandList commandList = super.createStartSequence();
        commandList.add(new LISPRequestValueListByListIndexCommand(0, true));
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerCommand(this.modelAccess));
            commandList.add(new ModelUpdateFullListCommand(this.modelAccess, this.commandListFactory, this.minimumInitialResults));
        }
        return commandList;
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.updatePoiSubstringSearchStatus(valueListStatus);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsLimitedInputSequence#updatePoiSubstringSearchStatus() - ignore");
    }
}

