/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

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
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor$ButtonListener;
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
        RadiotextHyperlinkProcessor$ButtonListener radiotextHyperlinkProcessor$ButtonListener = new RadiotextHyperlinkProcessor$ButtonListener(this, null);
        this.models.getButtonModel(-1115094784).setButtonListener(radiotextHyperlinkProcessor$ButtonListener);
        this.models.getButtonModel(-1064763136).setButtonListener(radiotextHyperlinkProcessor$ButtonListener);
        this.models.getButtonModel(-1131872000).setButtonListener(radiotextHyperlinkProcessor$ButtonListener);
        this.models.getButtonModel(-1148649216).setButtonListener(radiotextHyperlinkProcessor$ButtonListener);
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
        RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction radiotextHyperlinkProcessor$AbstractPendingHyperlinkAction;
        switch (n) {
            case 41: 
            case 42: 
            case 43: {
                radiotextHyperlinkProcessor$AbstractPendingHyperlinkAction = new PhonePendingHyperlinkAction(this, this.basics, string, this.phone);
                break;
            }
            case 59: {
                radiotextHyperlinkProcessor$AbstractPendingHyperlinkAction = new NavPendingHyperlinkAction(this, this.basics, string, this.navi);
                break;
            }
            case 44: 
            case 45: {
                if (Utilities.isStd()) {
                    radiotextHyperlinkProcessor$AbstractPendingHyperlinkAction = null;
                    break;
                }
                radiotextHyperlinkProcessor$AbstractPendingHyperlinkAction = new SMSPendingHyperlinkAction(this, this.basics, string, this.messaging);
                break;
            }
            default: {
                radiotextHyperlinkProcessor$AbstractPendingHyperlinkAction = null;
            }
        }
        return radiotextHyperlinkProcessor$AbstractPendingHyperlinkAction;
    }

    private void setLastPreparedPendingAction(IPendingHyperlinkAction iPendingHyperlinkAction) {
        this.lastPreparedPendingAction = iPendingHyperlinkAction;
    }

    static /* synthetic */ void access$100(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, IPendingHyperlinkAction iPendingHyperlinkAction) {
        radiotextHyperlinkProcessor.setLastPreparedPendingAction(iPendingHyperlinkAction);
    }

    static /* synthetic */ IPendingHyperlinkAction access$200(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        return radiotextHyperlinkProcessor.lastPreparedPendingAction;
    }

    static /* synthetic */ TunerModels access$300(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        return radiotextHyperlinkProcessor.models;
    }
}

