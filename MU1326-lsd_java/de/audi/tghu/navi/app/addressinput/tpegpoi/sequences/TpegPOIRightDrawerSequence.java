/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIBaseSequence;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIRightDrawerSequence$1;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIRightDrawerSequence$2;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.navigation.LIValueListElement;

public class TpegPOIRightDrawerSequence
extends TpegPOIBaseSequence {
    private final IPoiService poiService;
    private final IDetailsScreen detailsHMIListener;

    public TpegPOIRightDrawerSequence(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IPoiService iPoiService, IDetailsScreen iDetailsScreen) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.poiService = iPoiService;
        this.detailsHMIListener = iDetailsScreen;
    }

    public void poiSearchNearDestination(LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "%1#poiSearchNearDestination - poiToDisplay: %2", (Object)this.CLASS_NAME, (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new TpegPOIRightDrawerSequence$1(this, "POI Search Near Destination"));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#poiSearchNearDestination").toString());
    }

    public void showDetails(LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "%1#showDetails - poiToDisplay: %2", (Object)this.CLASS_NAME, (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new TpegPOIRightDrawerSequence$2(this, "Show details"));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showDetails").toString());
    }

    static /* synthetic */ IPoiService access$000(TpegPOIRightDrawerSequence tpegPOIRightDrawerSequence) {
        return tpegPOIRightDrawerSequence.poiService;
    }

    static /* synthetic */ IDetailsScreen access$100(TpegPOIRightDrawerSequence tpegPOIRightDrawerSequence) {
        return tpegPOIRightDrawerSequence.detailsHMIListener;
    }
}

