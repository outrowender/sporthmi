/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.app.navi.evo.predictivenav.FocusPreviewMapTask;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.NaviInterface;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavDSIHandler;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavListRow;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavSequence;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class PredictiveNavModelListenerEvo
implements BaseListModelListener,
ButtonListener,
ChoiceListener,
OptionModelListener {
    private static final int PICKING_OFF;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private PredictiveNavDSIHandler dsiHandler;
    private ButtonModelApp deleteAllPredictiveNav;
    private ButtonModelApp deleteLast24HoursPredictiveNav;
    private OptionModelApp deleteOnePredictiveNav;
    private ChoiceModelApp predictiveNavVisible;
    private BaseListModelApp likelyDestinationsList;
    private NavigationEnv env;
    private LogChannel logChannel;
    private NaviInterface naviInterface;
    private PredictiveNavSequence sequence;
    private final DispatcherBase dispatcher;
    private final IPreviewMap previewMap;

    public PredictiveNavModelListenerEvo(NavigationEnv navigationEnv, PredictiveNavDSIHandler predictiveNavDSIHandler, NaviInterface naviInterface, PredictiveNavSequence predictiveNavSequence, DispatcherBase dispatcherBase, IPreviewMap iPreviewMap) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPredictiveNavigationLogChannel();
        this.dsiHandler = predictiveNavDSIHandler;
        this.naviInterface = naviInterface;
        this.deleteAllPredictiveNav = navigationEnv.getButtonModel(-1541274112);
        this.deleteLast24HoursPredictiveNav = navigationEnv.getButtonModel(-1339947520);
        this.deleteOnePredictiveNav = navigationEnv.getOptionModel(-1323170304);
        this.predictiveNavVisible = navigationEnv.getChoiceModel(-1625160192);
        this.likelyDestinationsList = navigationEnv.getBaseListModel(-1641937408);
        this.sequence = predictiveNavSequence;
        this.dispatcher = dispatcherBase;
        this.previewMap = iPreviewMap;
    }

    public void registerListener() {
        this.deleteAllPredictiveNav.setButtonListener(this);
        this.deleteLast24HoursPredictiveNav.setButtonListener(this);
        this.deleteOnePredictiveNav.setListener(this, -1641937408);
        this.predictiveNavVisible.setChoiceListener(this);
        this.likelyDestinationsList.setListener(this);
    }

    public void unregisterListener() {
        this.deleteAllPredictiveNav.resetListener();
        this.deleteLast24HoursPredictiveNav.resetListener();
        this.deleteOnePredictiveNav.resetListener();
        this.predictiveNavVisible.resetListener();
        this.likelyDestinationsList.resetListener();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1078071040, new StringBuffer().append(this.CLASS_NAME).append("#keyPressed() # modelID=%1, keyID=%2, terminalID=%3").toString(), (long)n, (long)n2, (long)n3);
        if (n == this.deleteAllPredictiveNav.getID()) {
            this.dsiHandler.clearCache();
        } else if (n == this.deleteLast24HoursPredictiveNav.getID()) {
            this.dsiHandler.clearCacheLast24h();
        }
        this.env.getButtonModel(n).fireEvent(n3);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, new StringBuffer().append(this.CLASS_NAME).append("#itemSelected() # modelID=%1, itemID=%2, terminalID=%3").toString(), (long)n, (long)n2, (long)n4);
        if (n == this.predictiveNavVisible.getID()) {
            this.predictiveNavVisible.fireEvent(n4);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "%1#itemSelected() # row=%2", (Object)this.CLASS_NAME, (Object)evoListRow);
        if (evoListRow instanceof PredictiveNavListRow) {
            if (this.naviInterface != null) {
                this.logChannel.log(-2137614336, "%1#itemSelected() # startDestinationDetails", (Object)this.CLASS_NAME);
                this.env.getChoiceModel(1830815232).setValue(0);
                this.sequence.startGuidanceBySegmendID(((PredictiveNavListRow)evoListRow).getLikelyDestination().getSegmentId());
                this.likelyDestinationsList.fireEvent(n4);
            } else {
                this.logChannel.log(-2137614336, "%1#itemSelected() # naviInterface == null", (Object)this.CLASS_NAME);
            }
        } else {
            this.logChannel.log(-2137614336, "%1#itemSelected() # row is not instanceof PredictiveNavListRowEvo # index=%2", (Object)this.CLASS_NAME, (long)n2);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "%1#itemFocused() # row=%2", (Object)this.CLASS_NAME, (Object)evoListRow);
        if (evoListRow instanceof PredictiveNavListRow) {
            this.dispatcher.execute(new FocusPreviewMapTask(this.previewMap, (PredictiveNavListRow)evoListRow, this.logChannel));
        } else {
            this.logChannel.log(-1601830656, "%1#itemFocused() # focused row is not a PredictiveNavListRow", (Object)this.CLASS_NAME);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        EvoListRow evoListRow;
        this.logChannel.log(1078071040, "PredictiveNavModelListener#keyPressed() # modelID=%1, targetModelID=%2, targetRow=%3", (long)n, (long)n2, (long)n3);
        if (n == this.deleteOnePredictiveNav.getID() && n2 == this.likelyDestinationsList.getID() && (evoListRow = this.likelyDestinationsList.getRow(n3)) instanceof PredictiveNavListRow) {
            PredictiveNavListRow predictiveNavListRow = (PredictiveNavListRow)evoListRow;
            this.dsiHandler.clearCacheByDestination(predictiveNavListRow.getLikelyDestination().getDestination());
        }
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
}

