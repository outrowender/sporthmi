/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.NewUnrequestItemsCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIResultListModelAccess;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIBaseSequence;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence$1;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence$2;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence$3;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence$4;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.navigation.LIValueListElement;

public class TpegPOIResultListSequence
extends TpegPOIBaseSequence {
    private final ITpegPOIResultListModelAccess modelAccess;
    private final IStartGuidanceToDestinationSequence startGuidanceSequence;
    private final IPreviewMap previewMap;

    public TpegPOIResultListSequence(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, ITpegPOIResultListModelAccess iTpegPOIResultListModelAccess, SpellerStack spellerStack, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IPreviewMap iPreviewMap) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.modelAccess = iTpegPOIResultListModelAccess;
        this.startGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.previewMap = iPreviewMap;
    }

    public CommandList getResultListCommandList(long l) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(110)));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(0));
        commandList.add(new TpegPOIResultListSequence$1(this, "TpegPOIResultListSequence#getResultListCommandList update categorie label", l));
        commandList.add(new LISPSelectListItemCommand((int)l));
        commandList.add(new TpegPOIResultListSequence$2(this));
        return commandList;
    }

    public void requestNextResultListWindow(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new NewModelUpdateResultScreenWithSpellerForRequestCommand(this.modelAccess, n2, n));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestNextResultListWindows").toString());
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NewUnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    public void preparePreviewMap(LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "%1#preparePreviewMap - poiToDisplay: %2", (Object)this.CLASS_NAME, (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new TpegPOIResultListSequence$3(this, "Update preview map to focused POI"));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#preparePreviewMap").toString());
    }

    public void executeItemSelect(LIValueListElement lIValueListElement, HomeAddressHandler homeAddressHandler) {
        this.logChannel.log(-2137614336, "%1#startGuidanceFromSelectedPOI - selectedPOI: %2", (Object)this.CLASS_NAME, (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new TpegPOIResultListSequence$4(this, "Start route guidance", homeAddressHandler));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#startGuidanceFromSelectedPOI").toString());
    }

    static /* synthetic */ ITpegPOIResultListModelAccess access$000(TpegPOIResultListSequence tpegPOIResultListSequence) {
        return tpegPOIResultListSequence.modelAccess;
    }

    static /* synthetic */ IPreviewMap access$100(TpegPOIResultListSequence tpegPOIResultListSequence) {
        return tpegPOIResultListSequence.previewMap;
    }

    static /* synthetic */ IStartGuidanceToDestinationSequence access$200(TpegPOIResultListSequence tpegPOIResultListSequence) {
        return tpegPOIResultListSequence.startGuidanceSequence;
    }
}

