/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.mapcode;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.mapcode.IMapCodeScreenListener;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;
import de.audi.tghu.navi.app.util.Util;

public class MapcodeScreenListener
implements MatchSpellerListener,
ButtonListener,
MenuModelListener,
ILocationDisambiguationCallback,
IMapCodeScreenListener {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final IPreviewMap previewMap;
    private final MapcodeInputSequence inputSequence;
    private static final int START_RG_BUTTON_MODEL_ID = DIScreensEvo.getDiJpMapcodeScreenButtonModel();
    private static final int SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID = DIScreensEvo.getDiDestMapCodeSaveAsHomeButton();
    private static final int SUBMIT_ADDRESS_TO_ADB_BUTTON_ID = DIScreensEvo.getDiDestMapCodeUseThisPositionButton();
    private static final int MATCHSPELLER_MODEL_ID = DIScreensEvo.getDiJpMapcodeScreenSpellerModel();
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiJpMapcodeScreenMenuModel();
    private static final int PROPERTY_MODEL_ID = DIScreensEvo.getDiJpMapcodePropertyModel();
    private static final int DEST_OPT_METHODS_BUTTON_ID = DIScreensEvo.getDiOPTSelectMapCodeButton();
    private MenuModelApp menuModel;
    private MatchspellerModelApp matchSpellerModel;
    private boolean isSpellerOpen = false;
    private final ILocationDisambiguatorPopupHandler popupHandler;
    private final ILocationDisambiguatorSequence locationDisambiguationSequence;

    public MapcodeScreenListener(NavigationEnv navigationEnv, LogChannel logChannel, IPreviewMap iPreviewMap, MapcodeInputSequence mapcodeInputSequence, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler, ILocationDisambiguatorSequence iLocationDisambiguatorSequence) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.previewMap = iPreviewMap;
        this.inputSequence = mapcodeInputSequence;
        this.popupHandler = iLocationDisambiguatorPopupHandler;
        this.locationDisambiguationSequence = iLocationDisambiguatorSequence;
        this.initListener();
        navigationEnv.getPropertyModel(PROPERTY_MODEL_ID).setProperties(160082217, new int[0]);
    }

    private void initListener() {
        this.menuModel = this.env.getMenuModel(MENU_MODEL_ID);
        this.menuModel.setListener(this);
        this.matchSpellerModel = this.env.getMatchSpellerModel(MATCHSPELLER_MODEL_ID);
        this.matchSpellerModel.setSpellerListener(this);
        this.env.getButtonModel(START_RG_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(SUBMIT_ADDRESS_TO_ADB_BUTTON_ID).setButtonListener(this);
        this.env.getButtonModel(DEST_OPT_METHODS_BUTTON_ID).setButtonListener(this);
    }

    @Override
    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#textChanged(%1, %2, %3, %4)").toString(), (Object)Integer.toString(n), (Object)string, (Object)Character.toString(c2), (Object)Integer.toString(n2));
        Util.setModelStatus(this.matchSpellerModel, 0);
        if ("".equals(string)) {
            this.inputSequence.deleteAllCharacters();
        } else if (c2 == '\b') {
            this.inputSequence.undoCharacter();
        } else {
            this.inputSequence.addCharacter(Character.toString(c2));
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyTyped(%2, %3, %4)", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        if (n == DEST_OPT_METHODS_BUTTON_ID) {
            this.getStartCommandList().execute(new StringBuffer().append(this.CLASS_NAME).append("#Start Map Code Input").toString());
            this.env.fireModelEvent(n, n3);
        } else if (n == START_RG_BUTTON_MODEL_ID) {
            this.locationDisambiguationSequence.startDisambiguationForMapCode(this, 0, n, n3);
        } else if (n == SUBMIT_ADDRESS_AS_HOME_ADDRESS_BUTTON_ID) {
            this.locationDisambiguationSequence.startDisambiguationForMapCode(this, 4, n, n3);
        } else if (n == SUBMIT_ADDRESS_TO_ADB_BUTTON_ID) {
            this.locationDisambiguationSequence.startDisambiguationForMapCode(this, 3, n, n3);
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused of menu model was called with menuItemID=%2 , model=%3, uniqueListRowID=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Long.toString(l));
        if (n == MATCHSPELLER_MODEL_ID) {
            if (this.isSpellerOpen) {
                this.inputSequence.hidePreviewMap(this.previewMap);
            } else {
                this.inputSequence.showPreviewMapAroundCCP(this.previewMap);
            }
        } else {
            this.inputSequence.updatePreviewMap();
        }
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#commandPressed(%1, %2, %3)").toString(), (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        if (n == MATCHSPELLER_MODEL_ID) {
            if (n2 == 4712) {
                this.isSpellerOpen = false;
                if (this.matchSpellerModel.getStatus() == 1) {
                    this.inputSequence.updatePreviewMap();
                } else {
                    this.inputSequence.showPreviewMapAroundCCP(this.previewMap);
                }
            } else if (n2 == 4711) {
                this.isSpellerOpen = true;
                this.inputSequence.hidePreviewMap(this.previewMap);
            }
        }
    }

    @Override
    public void locationDisambiguationCallback(LocationDisambiguationWrapper locationDisambiguationWrapper) {
        this.logChannel.log(-2137614336, "%1#locationDisambiguationCallback() - action=%2, modelId=%3", (Object)this.CLASS_NAME, (long)locationDisambiguationWrapper.getAction(), (long)locationDisambiguationWrapper.getModelId());
        this.popupHandler.startPopupHandling(locationDisambiguationWrapper);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

