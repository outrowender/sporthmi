/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.details;

import de.audi.app.navi.evo.addressinput.poi.models.GuiModelAccessDetailsLocationPoi;
import de.audi.app.navi.evo.details.DetailsHMIListener;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationBrowser;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.NaviInterface;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;

public class DetailsHMIListenerAsia
extends DetailsHMIListener
implements ILocationDisambiguationCallback {
    private static final int DISABLE_POI_BROWSER;
    private static final int ENABLE_POI_BROWSER;
    private final ILocationDisambiguatorSequence locationDisambiguatorSequence;
    private final ILocationDisambiguatorPopupHandler locationDisambiguator;

    public DetailsHMIListenerAsia(NavigationEnv navigationEnv, NaviInterface naviInterface, MapInterface mapInterface, NavigationBrowser navigationBrowser, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IconHandler iconHandler, ITelService iTelService, ILocationDisambiguatorSequence iLocationDisambiguatorSequence, ICommandListFactory iCommandListFactory, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler) {
        super(navigationEnv, naviInterface, mapInterface, navigationBrowser, iStartGuidanceToDestinationSequence, iconHandler, iTelService, iCommandListFactory);
        this.locationDisambiguatorSequence = iLocationDisambiguatorSequence;
        this.locationDisambiguator = iLocationDisambiguatorPopupHandler;
    }

    @Override
    public void enterDetailsScreen(NavLocation navLocation) {
        super.enterDetailsScreen(navLocation);
        this.env.getChoiceModel(-668989952).setValue(this.isPoiBrowserAvailable(navLocation));
    }

    private int isPoiBrowserAvailable(NavLocation navLocation) {
        String string = LocationFormatter.getURLAddress(navLocation);
        if (!Util.isEmpty(string)) {
            this.logChannel.log(-2137614336, "%1#isPoiBrowserAvailable - url found (%2)", (Object)this.CLASS_NAME, (Object)string);
            return 1;
        }
        return 0;
    }

    @Override
    public void enterDetailsScreenOperatorCall(OperatorCallResult operatorCallResult) {
        this.logChannel.log(-2137614336, "%1#enterDetailsScreenOperatorCall", (Object)this.CLASS_NAME);
        super.enterDetailsScreenOperatorCall(operatorCallResult);
        String string = operatorCallResult.getAddress().getUrl();
        if (!Util.isEmpty(string)) {
            this.logChannel.log(-2137614336, "%1#enterDetailsScreenOperatorCall - url found (%2), enabling browser", (Object)this.CLASS_NAME, (Object)string);
            this.env.getChoiceModel(-668989952).setValue(1);
        } else {
            this.logChannel.log(-2137614336, "%1#enterDetailsScreenOperatorCall - no url found, disabling browser.", (Object)this.CLASS_NAME);
            this.env.getChoiceModel(-668989952).setValue(0);
        }
        GuiModelAccessDetailsLocationPoi guiModelAccessDetailsLocationPoi = new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHandler);
        guiModelAccessDetailsLocationPoi.onUpdateLocation(operatorCallResult);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyTyped - modelId: %2, keyId: %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.resetPreviousLocation();
        if (n == -2128673280) {
            NavLocation navLocation = this.detailsHandler.getLocation();
            this.locationDisambiguatorSequence.startDisambiguationForNavLocation(navLocation, this, 0, n, n3);
        } else if (n == -618658304) {
            this.env.fireModelEvent(n, n3);
            String string = LocationFormatter.getURLAddress(this.detailsHandler.getLocation());
            this.logChannel.log(-2137614336, "%1#keyTyped(NAV_MAP_SHOW_DETAILS_ONLINE_POI_ADDITIONAL_INFO_BUTTON) - loading URL: '%2' ", (Object)this.CLASS_NAME, (Object)string);
            boolean bl = this.navigationBrowser.loadURL(2, string, true);
            if (!bl) {
                this.logChannel.log(10000, "%1#keyTyped(NAV_MAP_SHOW_DETAILS_ONLINE_POI_ADDITIONAL_INFO_BUTTON) - failed to load url: '%2' ", (Object)this.CLASS_NAME, (Object)string);
            }
        } else {
            super.keyTyped(n, n2, n3);
        }
    }

    @Override
    public void locationDisambiguationCallback(LocationDisambiguationWrapper locationDisambiguationWrapper) {
        this.locationDisambiguator.startPopupHandling(locationDisambiguationWrapper);
    }
}

