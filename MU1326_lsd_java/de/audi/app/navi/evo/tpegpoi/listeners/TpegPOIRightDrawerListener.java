/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi.listeners;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRow;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiRightDrawerHmiListener;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIRightDrawerSequence;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.navigation.LIValueListElement;

public class TpegPOIRightDrawerListener
extends AbstractPoiRightDrawerHmiListener {
    private int resultListModelId = 0;
    private final TpegPOIRightDrawerSequence sequence;
    private static final int STORE_AS_FAVORITE_OPTION_MODEL_ID = DIScreensEvo.getDiKrStoreDestinationAsFavoriteOptionModel();
    private static final int POI_NEAR_DESTINATION_OPTION_MODEL_ID = DIScreensEvo.getDiKrPoiNearDestinationOptionModel();
    private static final int SHOW_IN_MAP_OPTION_MODEL_ID = DIScreensEvo.getDiKrShowInMapOptionModel();
    private static final int SHOW_DETAILS_OPTION_MODEL_ID = 402095;

    public TpegPOIRightDrawerListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, MapInterface mapInterface, NaviADBHandler naviADBHandler, ITelService iTelService, TpegPOIRightDrawerSequence tpegPOIRightDrawerSequence, int n) {
        super(navigationEnv, iCommandListFactory, iNaviFavoriteHandler, mapInterface, naviADBHandler, iTelService);
        this.sequence = tpegPOIRightDrawerSequence;
        this.resultListModelId = n;
        this.initOptionModelListener();
    }

    private void initOptionModelListener() {
        this.env.getHMIService().getOptionModel(STORE_AS_FAVORITE_OPTION_MODEL_ID).setListener(this, this.resultListModelId);
        this.env.getHMIService().getOptionModel(POI_NEAR_DESTINATION_OPTION_MODEL_ID).setListener(this, this.resultListModelId);
        this.env.getHMIService().getOptionModel(SHOW_IN_MAP_OPTION_MODEL_ID).setListener(this, this.resultListModelId);
        this.env.getHMIService().getOptionModel(402095).setListener(this, this.resultListModelId);
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, "%1#keyTyped - modelId=%2, targetModelId=%3, targetWidgetId=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (long)n4);
        EvoListRow evoListRow = this.env.getTiledListModel(n2).getRow(n3);
        if (evoListRow instanceof LiValueListRow) {
            LIValueListElement lIValueListElement = ((LiValueListRow)evoListRow).getElement();
            if (n == STORE_AS_FAVORITE_OPTION_MODEL_ID) {
                String string = "";
                if (evoListRow instanceof PoiIconedResultsListRow) {
                    string = (String)evoListRow.getCell(1);
                } else {
                    this.logChannel.log(10000, "%1#keyPressed - Unknown type of row for extracting favorite name.", (Object)this.CLASS_NAME);
                }
                this.saveAsFavorite(lIValueListElement, string, null);
            } else if (n == POI_NEAR_DESTINATION_OPTION_MODEL_ID) {
                this.sequence.poiSearchNearDestination(lIValueListElement);
            } else if (n == SHOW_IN_MAP_OPTION_MODEL_ID) {
                this.showInMap(lIValueListElement, null);
            } else if (n == 402095) {
                this.sequence.showDetails(lIValueListElement);
            }
        }
        this.env.getHMIService().getOptionModel(n).fireEvent(n5);
    }
}

