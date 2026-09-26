/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.mapcode;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.util.Util;

public class MapCodeRightDrawerListener
implements OptionModelListener,
ILocationDisambiguationCallback {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final NavigationEnv env;
    private final MapInterface mapInterface;
    private final LogChannel logChannel;
    private final ILocationDisambiguatorSequence locationDisambiguatonSequence;
    private final ILocationDisambiguatorPopupHandler locationDisambiguatonPopupHandler;
    private static final int WIDGET_ID;
    private static final int MAP_CODE_SCREEN_BUTTON;
    private static final int STORE_AS_FAVORITE_OPTION_MODEL_ID;
    private static final int POI_NEAR_DESTINATION_OPTION_MODEL_ID;
    private static final int SHOW_IN_MAP_OPTION_MODEL_ID;
    private static final int ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID;

    public MapCodeRightDrawerListener(NavigationEnv navigationEnv, MapInterface mapInterface, ILocationDisambiguatorSequence iLocationDisambiguatorSequence, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler) {
        this.env = navigationEnv;
        this.mapInterface = mapInterface;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.locationDisambiguatonSequence = iLocationDisambiguatorSequence;
        this.locationDisambiguatonPopupHandler = iLocationDisambiguatorPopupHandler;
        this.initListeners();
    }

    protected void initListeners() {
        this.registerOptionListenersForOption(STORE_AS_FAVORITE_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(POI_NEAR_DESTINATION_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID);
        this.registerOptionListenersForOption(SHOW_IN_MAP_OPTION_MODEL_ID);
    }

    private void registerOptionListenersForOption(int n) {
        OptionModelApp optionModelApp = this.env.getHMIService().getOptionModel(n);
        optionModelApp.setCustomIDListener(this, 3);
        optionModelApp.setListener(this, MAP_CODE_SCREEN_BUTTON);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "%1#keyPressed - modelId=%2, targetModelId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n2 == MAP_CODE_SCREEN_BUTTON) {
            if (n == STORE_AS_FAVORITE_OPTION_MODEL_ID) {
                this.locationDisambiguatonSequence.startDisambiguationForMapCode(this, 1, n, n5);
            } else if (n == POI_NEAR_DESTINATION_OPTION_MODEL_ID) {
                this.locationDisambiguatonSequence.startDisambiguationForMapCode(this, 5, n, n5);
            } else if (n == SHOW_IN_MAP_OPTION_MODEL_ID) {
                this.mapInterface.destOptShowInMap(this.env.getContainer().getSelectedLocation());
                this.env.getHMIService().getOptionModel(n).fireEvent(n5);
            } else if (n == ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID) {
                this.locationDisambiguatonSequence.startDisambiguationForMapCode(this, 2, n, n5);
            }
        }
    }

    @Override
    public void locationDisambiguationCallback(LocationDisambiguationWrapper locationDisambiguationWrapper) {
        this.locationDisambiguatonPopupHandler.startPopupHandling(locationDisambiguationWrapper);
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    static {
        MAP_CODE_SCREEN_BUTTON = DIScreensEvo.getDiJpMapcodeScreenButtonModel();
        STORE_AS_FAVORITE_OPTION_MODEL_ID = DIScreensEvo.getDiJpStoreDestinationAsFavoriteOptionModel();
        POI_NEAR_DESTINATION_OPTION_MODEL_ID = DIScreensEvo.getDiJpPoiNearDestinationOptionModel();
        SHOW_IN_MAP_OPTION_MODEL_ID = DIScreensEvo.getDiJpShowInMapOptionModel();
        ADD_DESTINATION_TO_CONTACT_OPTION_MODEL_ID = DIScreensEvo.getDiJpAddDestinationToContactOptionModel();
    }
}

