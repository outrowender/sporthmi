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
    private static final String LOGCLASS = "DataPlayerHMIHandler";
    private final DataPlayer dataPlayer;
    private final ModelGroup trackDetailsModelGroup = new ModelGroup();
    private final ModelGroup playPositionModelGroup = new ModelGroup();

    public DataPlayerHMIHandler(IMediaTerminal iMediaTerminal, DataPlayer dataPlayer) {
        super(iMediaTerminal);
        this.dataPlayer = dataPlayer;
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        RangeModelApp rangeModelApp = this.getRangeModel(200649);
        rangeModelApp.setLimits(0, 100, 1);
        rangeModelApp.setValue(0);
        this.getButtonModel(200645).setButtonListener(this);
        this.getChoiceModel(200652).setValue(0);
        this.trackDetailsModelGroup.add(this.getModel(200654));
        this.trackDetailsModelGroup.add(this.getModel(200655));
        this.trackDetailsModelGroup.add(this.getModel(200633));
        this.trackDetailsModelGroup.add(this.getModel(200634));
        this.trackDetailsModelGroup.add(this.getModel(200635));
        this.trackDetailsModelGroup.add(this.getModel(200636));
        this.trackDetailsModelGroup.add(this.getModel(200712));
        this.trackDetailsModelGroup.add(this.getModel(200714));
        this.trackDetailsModelGroup.add(this.getModel(200713));
        this.playPositionModelGroup.add(this.getModel(200647));
        this.playPositionModelGroup.add(this.getModel(200648));
        this.playPositionModelGroup.add(this.getModel(200649));
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.getButtonModel(200645).setButtonListener(null);
        this.trackDetailsModelGroup.removeAll();
        this.playPositionModelGroup.removeAll();
    }

    protected void setTitleData(I18NString i18NString, I18NString i18NString2, I18NString i18NString3, I18NString i18NString4, boolean bl, int n, int n2) {
        if (i18NString.isEmpty()) {
            this.getLabelModel(200654).setText(i18NString2.getI18NString());
            this.getChoiceModel(200655).setValue(i18NString2.getI18NKey());
        } else {
            this.getLabelModel(200654).setText(i18NString.getI18NString());
            this.getChoiceModel(200655).setValue(i18NString.getI18NKey());
        }
        this.getLabelModel(200635).setText(i18NString4.getI18NString());
        this.getChoiceModel(200636).setValue(i18NString4.getI18NKey());
        this.getLabelModel(200633).setText(i18NString3.getI18NString());
        this.getChoiceModel(200634).setValue(i18NString3.getI18NKey());
        this.getChoiceModel(200712).setValue(bl ? 1 : 0);
        this.getLabelModel(200713).setText(Integer.toString(n + 1));
        this.getLabelModel(200714).setText(Integer.toString(n2));
        this.trackDetailsModelGroup.flush();
    }

    protected void clearTitleData() {
        this.logger.hmi().log(1000000, "[%1.clearTitleData]", (Object)LOGCLASS);
        this.getLabelModel(200654).setText("");
        this.getChoiceModel(200655).setValue(0);
        this.getLabelModel(200635).setText("");
        this.getChoiceModel(200636).setValue(0);
        this.getLabelModel(200633).setText("");
        this.getChoiceModel(200634).setValue(0);
        this.getChoiceModel(200712).setValue(0);
        this.getLabelModel(200713).setText("0");
        this.getLabelModel(200714).setText("0");
        this.trackDetailsModelGroup.flush();
    }

    protected void setPlayTime(String string, String string2, int n) {
        this.getLabelModel(200647).setText(string);
        this.getLabelModel(200648).setText(string2);
        this.getRangeModel(200649).setValue(n);
        this.playPositionModelGroup.flush();
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200645: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] DATA_PLAYER_MORE_LIKE_THIS_BUTTON.", (Object)LOGCLASS);
                this.dataPlayer.playMoreLikeThis();
                this.getModel(200645).fireEvent(n3);
                break;
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void decrement(int n, int n2, int n3) {
    }

    public void increment(int n, int n2, int n3) {
    }

    public void setPlaybackStopped(boolean bl) {
        this.logger.main().log(1000000, "[%1.setPlaybackStopped] isPlaybackStopped: '%2'.", (Object)LOGCLASS, (Object)(bl ? "ENABLE" : "DISABLE"));
        this.getChoiceModel(201108).setValue(bl ? 1 : 0);
        if (bl && this.getChoiceModel(200628).getValue() == 2) {
            this.logger.main().log(1000000, "[%1.setPlaybackStopped] Open the left drawer.");
            DrawerEvent drawerEvent = new DrawerEvent(this.getTerminal().getFramework().getHMIService().getRootWindow(this.getTerminal().getTerminalID()), 8);
            this.getTerminal().getFramework().getHMIService().getEventDispatcher().postEvent(drawerEvent);
        } else {
            this.logger.main().log(1000000, "[%1.setPlaybackStopped] Nothing to do.");
        }
    }
}

