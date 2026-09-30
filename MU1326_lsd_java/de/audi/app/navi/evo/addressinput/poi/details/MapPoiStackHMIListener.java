/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.details;

import de.audi.app.navi.evo.addressinput.poi.details.PoiStackListRow;
import de.audi.app.navi.evo.addressinput.poi.models.GuiModelAccessDetailsLocationPoi;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class MapPoiStackHMIListener
implements BaseListModelListener {
    private final LogChannel logChannel;
    private final NavigationEnv env;
    private final IconHandler iconHandler;
    private final IDestinationHandler detailsHandler;
    private IPoiInputSequence stackSequence;
    private final IPreviewMap previewMap;
    private final ICommandListFactory commandListFactory;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public MapPoiStackHMIListener(NavigationEnv navigationEnv, IconHandler iconHandler, IDestinationHandler iDestinationHandler, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.iconHandler = iconHandler;
        this.detailsHandler = iDestinationHandler;
        this.commandListFactory = iCommandListFactory;
        this.previewMap = iPreviewMap;
    }

    public void setStackSequence(IPoiInputSequence iPoiInputSequence) {
        this.stackSequence = iPoiInputSequence;
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#itemSelected. row: %1, model: %2, index: %3").toString(), (Object)evoListRow, (long)n, (long)n2);
        if (evoListRow instanceof PoiStackListRow && n == this.getStackListModel()) {
            LIValueListElement lIValueListElement = ((PoiStackListRow)evoListRow).getElement();
            this.stackSequence.selectListElement(lIValueListElement);
            this.stackSequence.retrieveNavLocation(new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHandler));
        }
        this.logChannel.log(10000000, "%1#itemSelected - fire model event", (Object)this.CLASS_NAME);
        this.env.fireModelEvent(n, n4);
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#itemFocused. row: %1, model: %2, index: %3").toString(), (Object)evoListRow, (long)n, (long)n2);
        if (evoListRow instanceof PoiStackListRow) {
            LIValueListElement lIValueListElement = ((PoiStackListRow)evoListRow).getElement();
            if (lIValueListElement != null) {
                CommandList commandList = this.commandListFactory.createCommandList();
                commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
                commandList.add(new NavCommand("Get element from response container and focus preview map"){

                    public void execute() {
                        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                        this.logger.log(10000000, "selectedLocation=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
                        MapPoiStackHMIListener.this.previewMap.setPreviewPOIsOnboard(new NavLocation[]{navLocation}, 1, null, null);
                        this.getCommandList().commandFinished();
                    }
                });
                commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemFocused").toString());
            } else {
                this.logChannel.log(10000, "%1#itemFocused - retrieved element is null!");
            }
        } else {
            this.logChannel.log(10000, "%1#itemFocused - no PoiStackListRow focused!", (Object)this.CLASS_NAME);
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private int getStackListModel() {
        return 401114;
    }
}

