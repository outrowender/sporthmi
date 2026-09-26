/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsLimitedInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.TopPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.AbstractWrapperSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence$4;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence$5;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class FuelWarningWrapperSequence
extends AbstractWrapperSequence {
    public static final int VICINITY_LIST;
    private LISpellerData spellerStateVicinity;
    private final IPoiSpellerModelAccess vicinityModelAccess;
    protected final IPoiSpellerModelAccess alongRouteModelAccess;
    protected final ICommandListFactory commandListFactory;
    protected final NavigationEnv env;
    private final IVehicle vehicle;
    protected final int topPoiCategory;
    private PoiResultsGeneralInputSequence vicinitySequence;
    private PoiResultsGeneralInputSequence alongRouteSequence;
    protected int maxResultsAlongRoute;
    protected int maxResultsVicinity;
    public final IPoiSpellerModelAccess vicinityModelAccessBackup;
    protected final LogChannel logChannel;

    public FuelWarningWrapperSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, IPoiSpellerModelAccess iPoiSpellerModelAccess2, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, int n, IVehicle iVehicle, int n2, int n3, IPoiSpellerModelAccess iPoiSpellerModelAccess3, IDetailsScreen iDetailsScreen) {
        super(iDetailsScreen);
        this.vicinityModelAccess = iPoiSpellerModelAccess;
        this.alongRouteModelAccess = iPoiSpellerModelAccess2;
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.vehicle = iVehicle;
        this.topPoiCategory = n;
        this.maxResultsAlongRoute = n3;
        this.maxResultsVicinity = n2;
        this.vicinityModelAccessBackup = iPoiSpellerModelAccess3;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    @Override
    public void start() {
        CommandList commandList;
        this.logChannel.log(-2137614336, "FuelWarningWrapperSequence#start() - topPoiCategory: %1, maxResultsAlongRoute: %2, maxResultsVicinity: %3", (long)this.topPoiCategory, (long)this.maxResultsAlongRoute, (long)this.maxResultsVicinity);
        if (this.maxResultsAlongRoute > 0) {
            commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), new SpellerContext(117)));
            PoiSearchArea poiSearchArea = new PoiSearchArea(this.env.getPOILogChannel());
            poiSearchArea.setSearchContext(1);
            CommandList commandList2 = this.getStartSequence(null, this.alongRouteModelAccess, poiSearchArea, this.maxResultsAlongRoute, false, true);
            commandList.add(commandList2);
            commandList.add(new FuelWarningWrapperSequence$1(this, "Check valueListCount"));
            commandList.add(this.getToggleFuelWarningCommand());
            commandList.execute("FuelWarningWrapperSequence#start#commandListAlongRoute");
        }
        if (this.maxResultsVicinity > 0) {
            commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), new SpellerContext(118)));
            commandList.add(this.createCommandListVicinity(true, this.vicinityModelAccess, this.maxResultsVicinity));
            commandList.add(this.getToggleFuelWarningCommand());
            commandList.execute("FuelWarningWrapperSequence#start#commandListVicinity");
        }
    }

    private CommandList createCommandListVicinity(boolean bl, IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        PoiSearchArea poiSearchArea = new PoiSearchArea(this.env.getPOILogChannel());
        poiSearchArea.setSearchContext(0);
        CommandList commandList2 = this.getStartSequence(null, iPoiSpellerModelAccess, poiSearchArea, n, true, bl);
        commandList.add(commandList2);
        commandList.add(new LiGetStateCommand());
        commandList.add(new FuelWarningWrapperSequence$2(this));
        return commandList;
    }

    public NavCommand getToggleFuelWarningCommand() {
        return new FuelWarningWrapperSequence$3(this, "Toggle fuel warning");
    }

    @Override
    public void restore() {
        this.logChannel.log(-2137614336, "FuelWarningWrapperSequence#restoreToPreviousState()");
        if (this.spellerStateVicinity != null) {
            this.currentInputSequence.restore();
        }
    }

    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        this.currentInputSequence = bl ? this.vicinitySequence : this.alongRouteSequence;
        this.selectListElement(lIValueListElement);
    }

    public CommandList getStartSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, IPoiSpellerModelAccess iPoiSpellerModelAccess2, PoiSearchArea poiSearchArea, int n, boolean bl, boolean bl2) {
        this.logChannel.log(-2137614336, "FuelWarningWrapperSequence#getStartSequence() - topPoiCategory: %1 ", (long)this.topPoiCategory);
        TopPoiInputSequence topPoiInputSequence = new TopPoiInputSequence(iPoiSpellerModelAccess, this.commandListFactory, poiSearchArea, this.env, this.vehicle, this.detailsScreen);
        LIValueListElement lIValueListElement = new LIValueListElement();
        lIValueListElement.poiUniqueId = this.topPoiCategory;
        PoiResultsLimitedInputSequence poiResultsLimitedInputSequence = new PoiResultsLimitedInputSequence(iPoiSpellerModelAccess2, this.commandListFactory, poiSearchArea, this.env, lIValueListElement, this.vehicle, true, n);
        if (bl) {
            this.vicinitySequence = poiResultsLimitedInputSequence;
        } else {
            this.alongRouteSequence = poiResultsLimitedInputSequence;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl2) {
            commandList.add(new FuelWarningWrapperSequence$4(this, "FuelWarningWrapperSequence#clearVicinityModel"));
            commandList.add(new FuelWarningWrapperSequence$5(this, "FuelWarningWrapperSequence#clearAlongRouteModel"));
        }
        commandList.add(topPoiInputSequence.createStartSequence());
        commandList.add(poiResultsLimitedInputSequence.createStartSequence());
        return commandList;
    }

    @Override
    protected CommandList restoreCurrent() {
        return null;
    }

    static /* synthetic */ CommandList access$000(FuelWarningWrapperSequence fuelWarningWrapperSequence, boolean bl, IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        return fuelWarningWrapperSequence.createCommandListVicinity(bl, iPoiSpellerModelAccess, n);
    }

    static /* synthetic */ LISpellerData access$102(FuelWarningWrapperSequence fuelWarningWrapperSequence, LISpellerData lISpellerData) {
        fuelWarningWrapperSequence.spellerStateVicinity = lISpellerData;
        return fuelWarningWrapperSequence.spellerStateVicinity;
    }

    static /* synthetic */ IPoiSpellerModelAccess access$200(FuelWarningWrapperSequence fuelWarningWrapperSequence) {
        return fuelWarningWrapperSequence.vicinityModelAccess;
    }
}

