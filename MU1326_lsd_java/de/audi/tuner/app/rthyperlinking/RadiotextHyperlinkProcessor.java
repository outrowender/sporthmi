/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.interapp.IMessagingService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.def.NullNaviService;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.NullITelServiceSDS;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.rthyperlinking.IPendingHyperlinkAction;
import de.audi.tuner.app.rthyperlinking.NavPendingHyperlinkAction;
import de.audi.tuner.app.rthyperlinking.PhonePendingHyperlinkAction;
import de.audi.tuner.app.rthyperlinking.SMSPendingHyperlinkAction;
import de.audi.tuner.ifc.NullMessagingService;

public class RadiotextHyperlinkProcessor {
    public static final int[] HYPERLINK_TAGS = new int[]{41, 42, 43, 59, 44, 45};
    public static final int[] HYPERLINK_TAGS_MIB2_STD = new int[]{41, 42, 43, 59};
    private final TunerBasics basics;
    private final TunerModels models;
    private ITelService phone;
    private NaviService navi;
    private IMessagingService messaging;
    private IPendingHyperlinkAction lastPreparedPendingAction;

    public RadiotextHyperlinkProcessor(TunerBasics tunerBasics) {
        this.basics = tunerBasics;
        this.models = tunerBasics.getModels();
        this.phone = new NullITelServiceSDS(this.basics.getLogger().hmi);
        this.navi = new NullNaviService(this.basics.getLogger().hmi);
        this.messaging = new NullMessagingService(this.basics.getLogger().hmi);
        ButtonListener buttonListener = new ButtonListener();
        this.models.getButtonModel(100797).setButtonListener(buttonListener);
        this.models.getButtonModel(100800).setButtonListener(buttonListener);
        this.models.getButtonModel(100796).setButtonListener(buttonListener);
        this.models.getButtonModel(100795).setButtonListener(buttonListener);
    }

    public void register(ITelService iTelService) {
        if (iTelService == null) {
            iTelService = new NullITelServiceSDS(this.basics.getLogger().hmi);
        }
        this.phone = iTelService;
    }

    public void register(NaviService naviService) {
        if (naviService == null) {
            naviService = new NullNaviService(this.basics.getLogger().hmi);
        }
        this.navi = naviService;
    }

    public void register(IMessagingService iMessagingService) {
        if (iMessagingService == null) {
            iMessagingService = new NullMessagingService(this.basics.getLogger().hmi);
        }
        this.messaging = iMessagingService;
    }

    public IPendingHyperlinkAction determinePendingHyperlinkActionFor(String string, RadioTextPlusStorage radioTextPlusStorage) {
        for (int i2 = 0; i2 < HYPERLINK_TAGS.length; ++i2) {
            int n = HYPERLINK_TAGS[i2];
            String string2 = radioTextPlusStorage.getTag(n);
            if (Utilities.isEmpty(string2) || string.indexOf(string2) == -1) continue;
            return this.createPendingHyperlinkAction(n, string2);
        }
        return null;
    }

    private IPendingHyperlinkAction createPendingHyperlinkAction(int n, String string) {
        AbstractPendingHyperlinkAction abstractPendingHyperlinkAction;
        switch (n) {
            case 41: 
            case 42: 
            case 43: {
                abstractPendingHyperlinkAction = new PhonePendingHyperlinkAction(this, this.basics, string, this.phone);
                break;
            }
            case 59: {
                abstractPendingHyperlinkAction = new NavPendingHyperlinkAction(this, this.basics, string, this.navi);
                break;
            }
            case 44: 
            case 45: {
                if (Utilities.isStd()) {
                    abstractPendingHyperlinkAction = null;
                    break;
                }
                abstractPendingHyperlinkAction = new SMSPendingHyperlinkAction(this, this.basics, string, this.messaging);
                break;
            }
            default: {
                abstractPendingHyperlinkAction = null;
            }
        }
        return abstractPendingHyperlinkAction;
    }

    private void setLastPreparedPendingAction(IPendingHyperlinkAction iPendingHyperlinkAction) {
        this.lastPreparedPendingAction = iPendingHyperlinkAction;
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (RadiotextHyperlinkProcessor.this.lastPreparedPendingAction != null) {
                RadiotextHyperlinkProcessor.this.lastPreparedPendingAction.execute();
                RadiotextHyperlinkProcessor.this.models.getButtonModel(n).fireEvent(n3);
            }
        }
    }

    public static abstract class AbstractPendingHyperlinkAction
    implements IPendingHyperlinkAction {
        public static final int ACTIONTYPE_NAV = 0;
        public static final int ACTIONTYPE_PHONE = 1;
        public static final int ACTIONTYPE_SMS = 2;
        public static final int ACTIONTYPE_MAIL = 3;
        private final RadiotextHyperlinkProcessor processor;
        protected final TunerModels models;
        protected final int actionType;
        protected final String hyperlinkContent;
        protected final TunerBasics basics;

        public AbstractPendingHyperlinkAction(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, TunerBasics tunerBasics, int n, String string) {
            this.processor = radiotextHyperlinkProcessor;
            this.models = tunerBasics.getModels();
            this.actionType = n;
            this.hyperlinkContent = string;
            this.basics = tunerBasics;
        }

        public void prepare() {
            this.processor.setLastPreparedPendingAction(this);
            this.models.getLabelModel(100799).setText(this.hyperlinkContent);
            this.models.getChoiceModel(100798).setValue(this.actionType);
        }
    }
}

