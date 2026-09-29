/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.evo.content.data.DataPlayer;
import de.audi.app.media.i18n.I18NString;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

public class DataPlayerHMIHandler
extends AbstractMediaTerminalComponent
implements RangeListener {
    private static final String LOGCLASS;
    private final DataPlayer dataPlayer;
    private final ModelGroup trackDetailsModelGroup = new ModelGroup();
    private final ModelGroup playPositionModelGroup = new ModelGroup();

    public DataPlayerHMIHandler(IMediaTerminal iMediaTerminal, DataPlayer dataPlayer) {
        super(iMediaTerminal);
        this.dataPlayer = dataPlayer;
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"DataPlayerHMIHandler");
        RangeModelApp rangeModelApp = this.getRangeModel(-921763072);
        rangeModelApp.setLimits(0, 100, 1);
        rangeModelApp.setValue(0);
        this.getButtonModel(-988871936).setButtonListener(this);
        this.getChoiceModel(-871431424).setValue(0);
        this.trackDetailsModelGroup.add(this.getModel(-837876992));
        this.trackDetailsModelGroup.add(this.getModel(-821099776));
        this.trackDetailsModelGroup.add(this.getModel(-1190198528));
        this.trackDetailsModelGroup.add(this.getModel(-1173421312));
        this.trackDetailsModelGroup.add(this.getModel(-1156644096));
        this.trackDetailsModelGroup.add(this.getModel(-1139866880));
        this.trackDetailsModelGroup.add(this.getModel(135267072));
        this.trackDetailsModelGroup.add(this.getModel(168821504));
        this.trackDetailsModelGroup.add(this.getModel(152044288));
        this.playPositionModelGroup.add(this.getModel(-955317504));
        this.playPositionModelGroup.add(this.getModel(-938540288));
        this.playPositionModelGroup.add(this.getModel(-921763072));
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"DataPlayerHMIHandler");
        this.getButtonModel(-988871936).setButtonListener(null);
        this.trackDetailsModelGroup.removeAll();
        this.playPositionModelGroup.removeAll();
    }

    protected void setTitleData(I18NString i18NString, I18NString i18NString2, I18NString i18NString3, I18NString i18NString4, boolean bl, int n, int n2) {
        if (i18NString.isEmpty()) {
            this.getLabelModel(-837876992).setText(i18NString2.getI18NString());
            this.getChoiceModel(-821099776).setValue(i18NString2.getI18NKey());
        } else {
            this.getLabelModel(-837876992).setText(i18NString.getI18NString());
            this.getChoiceModel(-821099776).setValue(i18NString.getI18NKey());
        }
        this.getLabelModel(-1156644096).setText(i18NString4.getI18NString());
        this.getChoiceModel(-1139866880).setValue(i18NString4.getI18NKey());
        this.getLabelModel(-1190198528).setText(i18NString3.getI18NString());
        this.getChoiceModel(-1173421312).setValue(i18NString3.getI18NKey());
        this.getChoiceModel(135267072).setValue(bl ? 1 : 0);
        this.getLabelModel(152044288).setText(Integer.toString(n + 1));
        this.getLabelModel(168821504).setText(Integer.toString(n2));
        this.trackDetailsModelGroup.flush();
    }

    protected void clearTitleData() {
        this.logger.hmi().log(1078071040, "[%1.clearTitleData]", (Object)"DataPlayerHMIHandler");
        this.getLabelModel(-837876992).setText("");
        this.getChoiceModel(-821099776).setValue(0);
        this.getLabelModel(-1156644096).setText("");
        this.getChoiceModel(-1139866880).setValue(0);
        this.getLabelModel(-1190198528).setText("");
        this.getChoiceModel(-1173421312).setValue(0);
        this.getChoiceModel(135267072).setValue(0);
        this.getLabelModel(152044288).setText("0");
        this.getLabelModel(168821504).setText("0");
        this.trackDetailsModelGroup.flush();
    }

    protected void setPlayTime(String string, String string2, int n) {
        this.getLabelModel(-955317504).setText(string);
        this.getLabelModel(-938540288).setText(string2);
        this.getRangeModel(-921763072).setValue(n);
        this.playPositionModelGroup.flush();
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200645: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] DATA_PLAYER_MORE_LIKE_THIS_BUTTON.", (Object)"DataPlayerHMIHandler");
                this.dataPlayer.playMoreLikeThis();
                this.getModel(-988871936).fireEvent(n3);
                break;
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
    }

    @Override
    public void increment(int n, int n2, int n3) {
    }

    public void setPlaybackStopped(boolean bl) {
        this.logger.main().log(1078071040, "[%1.setPlaybackStopped] isPlaybackStopped: '%2'.", (Object)"DataPlayerHMIHandler", (Object)(bl ? "ENABLE" : "DISABLE"));
        this.getChoiceModel(-1810824448).setValue(bl ? 1 : 0);
        if (bl && this.getChoiceModel(-1274084608).getValue() == 2) {
            this.logger.main().log(1078071040, "[%1.setPlaybackStopped] Open the left drawer.");
            DrawerEvent drawerEvent = new DrawerEvent(this.getTerminal().getFramework().getHMIService().getRootWindow(this.getTerminal().getTerminalID()), 8);
            this.getTerminal().getFramework().getHMIService().getEventDispatcher().postEvent(drawerEvent);
        } else {
            this.logger.main().log(1078071040, "[%1.setPlaybackStopped] Nothing to do.");
        }
    }
}

