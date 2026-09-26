/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiCategoriesOrResultsModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassCategoriesInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoriesOrResultsWrapperSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoriesOrResultsWrapperSequence$2;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiCategoriesOrResultsWrapperSequence
extends AbstractWrapperSequence {
    private final IPoiCategoriesOrResultsModelAccess poiModelAccess;
    private final ICommandListFactory commandListFactory;
    private final PoiSearchArea searchArea;
    private final NavigationEnv env;
    private final LIValueListElement classElement;
    private final IVehicle vehicle;
    private final int minimumResults;
    protected LISpellerData initialSpellerState;

    public PoiCategoriesOrResultsWrapperSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, PoiSearchArea poiSearchArea, LIValueListElement lIValueListElement, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        this(iPoiCategoriesOrResultsModelAccess, iCommandListFactory, navigationEnv, poiSearchArea, lIValueListElement, iVehicle, -1, iDetailsScreen);
    }

    public PoiCategoriesOrResultsWrapperSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, PoiSearchArea poiSearchArea, LIValueListElement lIValueListElement, IVehicle iVehicle, int n, IDetailsScreen iDetailsScreen) {
        super(iDetailsScreen);
        this.poiModelAccess = iPoiCategoriesOrResultsModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.searchArea = poiSearchArea;
        this.env = navigationEnv;
        this.classElement = lIValueListElement;
        this.vehicle = iVehicle;
        this.minimumResults = n;
    }

    @Override
    public void start() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiCategoriesOrResultsInputSequence#start() - classElementIndex: %1 ", (Object)this.classElement);
        PoiClassCategoriesInputSequence poiClassCategoriesInputSequence = new PoiClassCategoriesInputSequence(this.poiModelAccess.getCategoriesScreen(), this.commandListFactory, this.searchArea, this.env, this.classElement, this.vehicle, this.detailsScreen);
        this.currentInputSequence = poiClassCategoriesInputSequence;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new PoiCategoriesOrResultsWrapperSequence$1(this));
        commandList.add(poiClassCategoriesInputSequence.createStartSequence());
        commandList.add(new PoiCategoriesOrResultsWrapperSequence$2(this));
        commandList.execute("PoiCategoriesOrResultsInputSequence#start");
    }

    @Override
    protected CommandList restoreCurrent() {
        if (this.initialSpellerState == null) {
            this.env.getLogChannel().log(-1601830656, "[PoiInput] PoiBrandsFromSpellerStateWrapperSequence#Invalid sequence state - spellerState is null.");
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        return commandList;
    }

    static /* synthetic */ IPoiCategoriesOrResultsModelAccess access$000(PoiCategoriesOrResultsWrapperSequence poiCategoriesOrResultsWrapperSequence) {
        return poiCategoriesOrResultsWrapperSequence.poiModelAccess;
    }

    static /* synthetic */ ICommandListFactory access$100(PoiCategoriesOrResultsWrapperSequence poiCategoriesOrResultsWrapperSequence) {
        return poiCategoriesOrResultsWrapperSequence.commandListFactory;
    }

    static /* synthetic */ PoiSearchArea access$200(PoiCategoriesOrResultsWrapperSequence poiCategoriesOrResultsWrapperSequence) {
        return poiCategoriesOrResultsWrapperSequence.searchArea;
    }

    static /* synthetic */ IVehicle access$300(PoiCategoriesOrResultsWrapperSequence poiCategoriesOrResultsWrapperSequence) {
        return poiCategoriesOrResultsWrapperSequence.vehicle;
    }

    static /* synthetic */ int access$400(PoiCategoriesOrResultsWrapperSequence poiCategoriesOrResultsWrapperSequence) {
        return poiCategoriesOrResultsWrapperSequence.minimumResults;
    }
}

