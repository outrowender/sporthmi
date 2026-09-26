/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.TopPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.TopPoiResultsByUIDWrapperSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.TopPoiResultsByUIDWrapperSequence$2;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.navigation.LISpellerData;

public class TopPoiResultsByUIDWrapperSequence
extends AbstractWrapperSequence {
    private final LogChannel lc;
    private final ICommandListFactory commandListFactory;
    private final PoiSearchArea searchArea;
    private final NavigationEnv env;
    private final IVehicle vehicle;
    private final IPoiSpellerModelAccess startSepellerModelAccess;
    private final IPoiSpellerModelAccess resultsModelAccess;
    private final int minInitialResults;
    private final int categoryID;
    protected LISpellerData initialSpellerState;

    public TopPoiResultsByUIDWrapperSequence(ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, IVehicle iVehicle, IPoiSpellerModelAccess iPoiSpellerModelAccess, IPoiSpellerModelAccess iPoiSpellerModelAccess2, int n, int n2, IDetailsScreen iDetailsScreen) {
        super(iDetailsScreen);
        this.lc = navigationEnv.getLogChannel();
        this.commandListFactory = iCommandListFactory;
        this.searchArea = poiSearchArea;
        this.env = navigationEnv;
        this.vehicle = iVehicle;
        this.resultsModelAccess = iPoiSpellerModelAccess2;
        this.startSepellerModelAccess = iPoiSpellerModelAccess;
        this.minInitialResults = n;
        this.categoryID = n2;
    }

    @Override
    public void start() {
        this.lc.log(-2137614336, "[PoiInput] TopPoiResultsByUIDWrapperSequence#start()");
        CommandList commandList = this.getStartSequence();
        commandList.execute("TopPoiResultsByUIDWrapperSequence#start");
    }

    @Override
    protected CommandList restoreCurrent() {
        if (this.initialSpellerState == null) {
            this.env.getLogChannel().log(-1601830656, "[PoiInput] TopPoiResultsByUIDWrapperSequence#Invalid sequence state - spellerState is null.");
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        return commandList;
    }

    public CommandList getStartSequence() {
        this.lc.log(-2137614336, "[PoiInput] TopPoiResultsByUIDWrapperSequence#getStartSequence()");
        TopPoiInputSequence topPoiInputSequence = new TopPoiInputSequence(this.startSepellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.vehicle, this.detailsScreen);
        this.currentInputSequence = topPoiInputSequence;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new TopPoiResultsByUIDWrapperSequence$1(this));
        commandList.add(topPoiInputSequence.createStartSequence());
        commandList.add(new TopPoiResultsByUIDWrapperSequence$2(this));
        return commandList;
    }

    static /* synthetic */ int access$000(TopPoiResultsByUIDWrapperSequence topPoiResultsByUIDWrapperSequence) {
        return topPoiResultsByUIDWrapperSequence.categoryID;
    }

    static /* synthetic */ IPoiSpellerModelAccess access$100(TopPoiResultsByUIDWrapperSequence topPoiResultsByUIDWrapperSequence) {
        return topPoiResultsByUIDWrapperSequence.resultsModelAccess;
    }

    static /* synthetic */ ICommandListFactory access$200(TopPoiResultsByUIDWrapperSequence topPoiResultsByUIDWrapperSequence) {
        return topPoiResultsByUIDWrapperSequence.commandListFactory;
    }

    static /* synthetic */ PoiSearchArea access$300(TopPoiResultsByUIDWrapperSequence topPoiResultsByUIDWrapperSequence) {
        return topPoiResultsByUIDWrapperSequence.searchArea;
    }

    static /* synthetic */ IVehicle access$400(TopPoiResultsByUIDWrapperSequence topPoiResultsByUIDWrapperSequence) {
        return topPoiResultsByUIDWrapperSequence.vehicle;
    }

    static /* synthetic */ int access$500(TopPoiResultsByUIDWrapperSequence topPoiResultsByUIDWrapperSequence) {
        return topPoiResultsByUIDWrapperSequence.minInitialResults;
    }
}

