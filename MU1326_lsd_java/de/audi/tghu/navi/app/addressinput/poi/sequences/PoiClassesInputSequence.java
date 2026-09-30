/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiCategoriesOrResultsModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractStartPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassCategoriesInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiStartSearchSpellerInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoriesOrResultsWrapperSequence;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;

public class PoiClassesInputSequence
extends AbstractStartPoiInputSequence {
    private IVehicle vehicle;

    public PoiClassesInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, 32769, poiSearchArea, navigationEnv, iDetailsScreen);
        this.vehicle = iVehicle;
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiClassesInputSequence#start() ");
        CommandList commandList = this.createStartSequence();
        commandList.execute("PoiClassesInputSequence#start");
    }

    public void startCategoriesOrResultsSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startCategoriesOrResultsSequence(iPoiCategoriesOrResultsModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiClassesInputSequence#startCategoriesSequence() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiCategoriesOrResultsWrapperSequence(iPoiCategoriesOrResultsModelAccess, this.commandListFactory, this.env, this.searchArea, this.selectedElement, this.vehicle, n, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public void startCategories(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startCategories(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiClassesInputSequence#startCategoriesSequence() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiClassCategoriesInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startResultsSequence(iPoiSpellerModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiClassesInputSequence#startResultsSequence() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiResultsGeneralInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedElement, this.vehicle, false, n, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startSubstringSearch(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiClassesInputSequence#startSubstringSearch() - element: %1", (Object)this.selectedElement);
        this.currentInputSequence = new PoiStartSearchSpellerInputSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        this.currentInputSequence.start();
    }

    protected int getSortOrder() {
        return 0;
    }

    protected String getStringId() {
        return "PoiClassesInputSequence";
    }
}

