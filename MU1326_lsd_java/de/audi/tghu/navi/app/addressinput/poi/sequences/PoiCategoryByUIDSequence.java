/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractStartPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;

public class PoiCategoryByUIDSequence
extends AbstractStartPoiInputSequence {
    private final IVehicle vehicle;

    public PoiCategoryByUIDSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, 32783, poiSearchArea, navigationEnv, iDetailsScreen);
        this.vehicle = iVehicle;
    }

    public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startResultsSequence(iPoiSpellerModelAccess, n);
            return;
        }
        this.currentInputSequence = new PoiResultsGeneralInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, true, n, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiCategoryByUIDSequence#start() ");
        CommandList commandList = this.createStartSequence();
        commandList.execute("PoiCategoryByUIDSequence#start");
    }

    protected int getSortOrder() {
        return 0;
    }

    protected String getStringId() {
        return "PoiCategoryByUIDSequence";
    }
}

