/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractScreenAccess;
import de.audi.app.online.evo.DefaultScreenAccess;
import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.ui.mib2.Properties$BackBehavior;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.util.RangeCounter;
import java.util.ArrayList;
import java.util.List;

public class AbstractHMIViewListenerEvo
extends AbstractHMIViewListener {
    public static final int MODEL_RANGE_START;
    public static final int MODEL_RANGE_SIZE;
    protected final AbstractScreenAccess screenAccess;
    private RemoteHMIServiceEvo remoteHmiServiceEvo;
    protected static final RangeCounter rangeCounter;

    public AbstractHMIViewListenerEvo(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        this(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo, new DefaultScreenAccess(onlineModelBankAccess.getChoiceModel(1025254144), logChannel));
    }

    public AbstractHMIViewListenerEvo(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo, AbstractScreenAccess abstractScreenAccess) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo);
        this.remoteHmiServiceEvo = remoteHMIServiceEvo;
        this.screenAccess = abstractScreenAccess;
    }

    @Override
    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        Object object;
        this.logChannel.log(-2137614336, "AbstractHMIViewListenerEvo#updateViewProperties: Called for context '%1'", (Object)remoteHMIContext);
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        this.modelBank.getChoiceModel(823927552).setValue(1);
        List list = (List)hMIProperties.get("type");
        list = list == null ? new ArrayList() : list;
        this.logChannel.log(-2137614336, "AbstractHMIViewListenerEvo#updateViewProperties: Properties.PROP_VIEW_DATA_TYPE defined are '%1'", (Object)list.toString());
        this.setViewDataTypes(list);
        if (bl || !(this instanceof HMIViewGridListener)) {
            object = this.remoteHmiServiceEvo.getRightDrawerHandler();
            ((RightDrawerHandler)object).updateRightDrawer(list, rangeCounter, null, null);
        }
        object = this.remoteHmiServiceEvo.getLeftDrawerHandler();
        if (remoteHMIContext == null) {
            this.logChannel.log(10000, "AbstractHMIViewListenerEvo#updateViewProperties: RemoteHMIContext is null! currently selected left drawer entry cannot be stored!");
        } else {
            ((LeftDrawerHandler)object).populateSubListAndSetSelection(remoteHMIContext);
        }
        Properties$BackBehavior properties$BackBehavior = (Properties$BackBehavior)hMIProperties.get("backBehavior");
        if (properties$BackBehavior != null) {
            ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(-1172561152);
            this.logChannel.log(1078071040, "AbstractHMIViewListenerEvo#updateViewProperties: using back behavior %1", (Object)properties$BackBehavior);
            choiceModelApp.setValue(properties$BackBehavior.isSelectionDrawerOpenedOnHkReturn() ? 1 : 0);
        }
    }

    public boolean handleScreenType(HMIProperties hMIProperties) {
        boolean bl = this.screenAccess.isMainScreen();
        boolean bl2 = this.screenAccess.switchScreen(this.isScreenTypeMain(hMIProperties));
        this.logChannel.log(1078071040, "AbstractHMIViewListenerEvo#handleScreenType: screen type: old=%1, new=%2", (Object)this.getScreenTypeDescription(bl), (Object)this.getScreenTypeDescription(this.screenAccess.isMainScreen()));
        return bl2;
    }

    private boolean isScreenTypeMain(HMIProperties hMIProperties) {
        String string = hMIProperties.getString("screenType");
        this.logChannel.log(-2137614336, "AbstractHMIViewListenerEvo#isScreenTypeMain: screen type '%1'", (Object)string);
        if (string == null || string.length() == 0) {
            return true;
        }
        if (string.equals("options")) {
            return false;
        }
        if (string.equals("main")) {
            return true;
        }
        this.logChannel.log(-1601830656, "AbstractHMIViewListenerEvo#isScreenTypeMain: Unknown screen type '%1' given, using main", (Object)string);
        return true;
    }

    public boolean isScreenTypeMain() {
        return this.screenAccess.isMainScreen();
    }

    public String getScreenTypeDescription(boolean bl) {
        return bl ? "main" : "options";
    }

    public static RangeCounter getRangeCounter() {
        return rangeCounter;
    }

    static {
        rangeCounter = new RangeCounter(-1327815936, 1354956800);
    }
}

