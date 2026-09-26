/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.AbstractHMIViewListenerEvo;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.media.IMediaValues;
import de.audi.remotehmi.media.MediaUtilities;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.util.Util;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IViewNpsListenerInterface;
import de.audi.tghu.online.app.remotehmi.onlinemedia.MediaValues;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HMIViewNpsListener
extends AbstractHMIViewListenerEvo
implements IViewNpsListenerInterface {
    public static final int NPS_MODE_SINGLE;
    public static final int NPS_MODE_LIST;
    private static final int LINE_1_TEXT;
    private static final int LINE_2_TEXT;
    private static final int LINE_3_TEXT;
    private static final int LINE_1_IMAGE;
    private static final int LINE_2_IMAGE;
    private static final int LINE_3_IMAGE;
    private static final int MAIN_MODEL_COUNT;
    static List mainModelDescription;
    private static final int TIME_LEFT;
    private static final int TIME_PLAYING;
    private static final int TIME_PROGRESS_BAR;
    private static final int TIME_MODEL_COUNT;
    static List timeModelDescription;
    private IMediaValues mediaValues = new MediaValues();
    private HMIModelApp[] mainModels = new HMIModelApp[6];
    private Object[] values = new Object[6];
    private ModelGroup timeModelGroup;
    private HMIModelApp[] timeModels = new HMIModelApp[3];
    private static final int TIME_TOTAL;
    private Object[] timeValues = new Object[4];

    public HMIViewNpsListener(LogChannel logChannel, ModelGroup modelGroup, OnlineModelBankAccess onlineModelBankAccess, HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        super(logChannel, modelGroup, onlineModelBankAccess, hMIService, remoteHMIServiceEvo);
        this.timeModelGroup = new ModelGroup();
        this.initModels();
        this.updateTimeValues();
    }

    private void initModels() {
        int n;
        this.mainModels[3] = this.hmiService.getResourceLocatorModel(-2028199168);
        this.mainModels[0] = this.hmiService.getLabelModel(-2145639680);
        this.mainModels[4] = this.hmiService.getResourceLocatorModel(-2112085248);
        this.mainModels[1] = this.hmiService.getLabelModel(2132550400);
        this.mainModels[5] = this.hmiService.getResourceLocatorModel(-2128862464);
        this.mainModels[2] = this.hmiService.getLabelModel(2115773184);
        this.timeModels[0] = this.hmiService.getLabelModel(-2044976384);
        this.timeModels[1] = this.hmiService.getLabelModel(-2078530816);
        this.timeModels[2] = (RangeModel2DApp)((Object)this.hmiService.getModel(1511924480));
        for (n = 0; n < 6; ++n) {
            this.mainModelGroup.add(this.mainModels[n]);
        }
        for (n = 0; n < this.timeModels.length; ++n) {
            this.timeModelGroup.add(this.timeModels[n]);
        }
    }

    @Override
    public void updateViewProperties(HMIProperties hMIProperties, boolean bl, RemoteHMIContext remoteHMIContext) {
        this.logChannel.log(1078071040, "HMIViewNpsListener#updateViewProperties");
        this.handleScreenType(hMIProperties);
        super.updateViewProperties(hMIProperties, bl, remoteHMIContext);
        String[] stringArray = hMIProperties.getStringArray("subtitle");
        if (stringArray != null && stringArray.length > 0) {
            this.setTitle(stringArray[0]);
        } else {
            this.logChannel.log(-1601830656, "HMIViewNpsListener#updateViewProperties: subtitle is null or empty!");
        }
        this.setNowPlayingScreenMode(1);
        Object object = hMIProperties.get("gridList");
        if (!(object instanceof IGridList)) {
            throw new IllegalArgumentException(new StringBuffer().append("HMIViewNpsListener#updateViewProperties() invalid gridList object: ").append(object).toString());
        }
        this.updateLineLeadingIcons((IGridList)object);
    }

    @Override
    public void updateTimeValues() {
        this.logChannel.log(1078071040, "HMIViewNpsListener#updateTimeValues()");
        this.timeValues[1] = this.mediaValues.getTimePlayingAsString();
        this.timeValues[2] = new Integer(this.mediaValues.getTimePlaying());
        this.timeValues[0] = new StringBuffer().append("-").append(this.mediaValues.getTimeLeftAsString()).toString();
        this.timeValues[3] = new Integer(this.mediaValues.getTimeTotal());
        this.refreshModels(this.timeModels, this.timeValues, this.timeModelGroup);
    }

    @Override
    public void updateMetadataValues() {
        this.logChannel.log(1078071040, "HMIViewNpsListener#updateMetadataValues(): mediaValues=%1", (Object)this.mediaValues);
        this.values[2] = this.mediaValues.getLine3Text();
        this.values[1] = this.mediaValues.getLine2Text();
        this.values[0] = this.mediaValues.getLine1Text();
        this.refreshModels(this.mainModels, this.values, this.mainModelGroup);
    }

    public void setTitle(String string) {
        this.hmiService.getLabelModel(-1994644736).setText(string);
    }

    public void resetLineLeadingIcons() {
        this.values[3] = null;
        this.values[4] = null;
        this.values[5] = null;
        this.refreshModels(this.mainModels, this.values, this.mainModelGroup);
    }

    private void refreshModels(HMIModelApp[] hMIModelAppArray, Object[] objectArray, ModelGroup modelGroup) {
        boolean bl = modelGroup == this.mainModelGroup;
        this.logChannel.log(1078071040, "HMIViewNpsListener#refreshModels: modelGroup %1", (Object)(bl ? "mainModelGroup" : "timeModelGroup"));
        boolean bl2 = false;
        for (int i2 = 0; i2 < hMIModelAppArray.length; ++i2) {
            String string = (String)(bl ? mainModelDescription.get(i2) : timeModelDescription.get(i2));
            if (!this.checkAndChangeModel(hMIModelAppArray[i2], objectArray[i2], false, string)) continue;
            bl2 = true;
        }
        if (bl2) {
            modelGroup.flush();
        }
    }

    private boolean checkAndChangeModel(HMIModelApp hMIModelApp, Object object, boolean bl, String string) {
        if (hMIModelApp == null) {
            this.logChannel.log(-1601830656, "HMIViewNpsListener#checkAndChangeModel: model provided is null for value = %1", object);
            return false;
        }
        if (hMIModelApp instanceof LabelModelApp && (object instanceof String || object == null)) {
            String string2 = (String)object;
            LabelModelApp labelModelApp = (LabelModelApp)hMIModelApp;
            String string3 = labelModelApp.getText();
            if (string3 == null || !string3.equals(string2)) {
                labelModelApp.setText(string2);
                this.logChannel.log(-2137614336, "HMIViewNpsListener#checkAndChangeModel: label model %1 : old value = '%2', new value = '%3'", (Object)string, (Object)string3, (Object)string2);
                return true;
            }
        } else if (hMIModelApp instanceof RangeModel2DApp && object instanceof Integer) {
            int n = (Integer)object;
            RangeModel2DApp rangeModel2DApp = (RangeModel2DApp)hMIModelApp;
            int n2 = rangeModel2DApp.getValueX();
            if (n2 != n) {
                rangeModel2DApp.setValue(n, rangeModel2DApp.getValueY());
                this.logChannel.log(1078071040, "HMIViewNpsListener#checkAndChangeModel: valueX '%1' and valueY '%2'", (long)rangeModel2DApp.getValueX(), (long)rangeModel2DApp.getValueY());
                int n3 = (Integer)this.timeValues[3];
                if (rangeModel2DApp.getMaximumX() != n3) {
                    rangeModel2DApp.setLimitsX(0, n3, 1);
                }
                return true;
            }
        } else if (hMIModelApp instanceof ResourceLocatorModelApp && (object instanceof String || object == null)) {
            int n;
            String string4;
            String string5 = (String)object;
            ResourceLocatorModelApp resourceLocatorModelApp = (ResourceLocatorModelApp)hMIModelApp;
            String string6 = resourceLocatorModelApp.getResourceLocator().getResourceURI();
            int n4 = resourceLocatorModelApp.getResourceLocator().getResourceID();
            this.logChannel.log(-2137614336, "HMIViewNpsListener#checkAndChangeModel() model %1: old image = '%2', old ID = '%3'", (Object)string, (Object)string6, (long)n4);
            String string7 = string4 = string5 == null || string5.trim().length() == 0 ? ResourceLocatorModelApp.UNDEFINED_URI : string5;
            if (bl && StringUtilities.equals(string4, ResourceLocatorModelApp.UNDEFINED_URI)) {
                String string8 = this.mediaValues.getLine3Text();
                n = MediaUtilities.calculateIdFromAlbum(string8, -1);
                this.logChannel.log(-2137614336, "HMIViewNpsListener#checkAndChangeModel() system image %1 used for album '%2'.", (Object)Util.createInteger(n), (Object)string8);
            } else {
                n = -1;
            }
            if (!StringUtilities.equals(string6, string4) || n4 != n) {
                resourceLocatorModelApp.setResourceLocator(n, string4);
                this.logChannel.log(-2137614336, "HMIViewNpsListener#checkAndChangeModel() model %1: new image = '%2', new ID = '%3'", (Object)string, (Object)string4, (long)n);
                return true;
            }
        } else {
            this.logChannel.log(10000, "HMIViewNpsListener#checkAndreplaceModel() invalid pair of %1 model = '%2' and modelValue = '%3'", (Object)string, (Object)hMIModelApp, object);
            return false;
        }
        this.logChannel.log(-2137614336, "HMIViewNpsListener#checkAndChangeModel: model %1: new and old value = '%2' are the same.", (Object)string, object);
        return false;
    }

    @Override
    public void keyPressedVirtualButton(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "HMIViewNpsListener#keyPressedVirtualButton keyID '%1' modelID '%2'", (long)n2, (long)n);
        int n4 = this.isDefaultCursorAvailable() ? this.getOldCursor().getFocus().getIndex() : -1;
        String string = this.getSelectedId(n4);
        if (n2 == 15) {
            String string2 = this.getReturnId();
            this.invokeAction(104, n4, string, string2);
            return;
        }
    }

    @Override
    public void setRadioMode(boolean bl) {
        this.hmiService.getChoiceModel(-1055120640).setValue(bl ? 0 : 1);
    }

    @Override
    public void updateCover(String string) {
        ResourceLocatorModelApp resourceLocatorModelApp = this.hmiService.getResourceLocatorModel(-2095308032);
        String string2 = resourceLocatorModelApp.getResourceLocator() == null ? "" : resourceLocatorModelApp.getResourceLocator().getResourceURI();
        this.logChannel.log(1078071040, "HMIViewNpsListener#updateCover: updating coverart with image '%1', old value '%2'", (Object)string, (Object)string2);
        boolean bl = this.checkAndChangeModel(resourceLocatorModelApp, string, true, "ALBUM COVER");
        if (bl) {
            this.mediaValues.setCover(string);
        }
    }

    public void updateLineLeadingIcons(IGridList iGridList) {
        try {
            this.updateLineLeadingIconsWork(iGridList);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.logChannel.log(1078071040, "HMIViewNpsListener#updateLineLeadingIcons: new grid has illegal format, clearing old icons: exception=%1, gridList=%2", (Object)illegalArgumentException, (Object)iGridList);
            this.resetLineLeadingIcons();
        }
    }

    public void updateLineLeadingIconsWork(IGridList iGridList) {
        int n;
        int n2 = n = iGridList == null ? 0 : iGridList.size();
        if (n != 1) {
            throw new IllegalArgumentException(new StringBuffer().append("HMIViewNpsListener#updateLineLeadingIconsWork: invalid amount of grids(1 allowed): ").append(n).toString());
        }
        IGrid iGrid = (IGrid)iGridList.get(0);
        this.logChannel.log(1078071040, "HMIViewNpsListener#updateLineLeadingIconsWork: new grid: %1", (Object)iGrid);
        this.logChannel.log(1078071040, "HMIViewNpsListener#updateLineLeadingIconsWork: grid drawers: %1", (Object)iGrid.getDrawerTypes());
        int n3 = iGrid.size();
        if (n3 != 6 && n3 != 3) {
            throw new IllegalArgumentException(new StringBuffer().append("HMIViewNpsListener#updateLineLeadingIconsWork: invalid amount of grid-cells(must be 3 or 6): ").append(n3).toString());
        }
        if (n3 != 6) {
            this.logChannel.log(1078071040, "HMIViewNpsListener#updateLineLeadingIconsWork: No images delivered. Using default line leading icons.");
            return;
        }
        this.values[3] = ((IGridCell)iGrid.get(0)).getStringValue();
        this.values[4] = ((IGridCell)iGrid.get(2)).getStringValue();
        this.values[5] = ((IGridCell)iGrid.get(4)).getStringValue();
        this.logChannel.log(1078071040, "HMIViewNpsListener#updateLineLeadingIcons: titleImage=%1, artistImage=%2, albumImage=%3;", this.values[3], this.values[4], this.values[5]);
        this.refreshModels(this.mainModels, this.values, this.mainModelGroup);
    }

    @Override
    public IMediaValues getMediaValues() {
        return this.mediaValues;
    }

    @Override
    public void updateBufferState(int n) {
        this.logChannel.log(1078071040, "HMIViewNpsListener#updateBufferState: fillstate - %1", (long)n);
        RangeModel2DApp rangeModel2DApp = (RangeModel2DApp)this.timeModels[2];
        int n2 = rangeModel2DApp.getValueX();
        rangeModel2DApp.setLimitsY(0, 100, 1);
        rangeModel2DApp.setValue(n2, n);
        this.logChannel.log(1078071040, "HMIViewNpsListener#updateBufferState: x : %1, y : %2", (long)rangeModel2DApp.getValueX(), (long)rangeModel2DApp.getValueY());
        this.timeModelGroup.flush();
    }

    public void setBufferState(int n) {
    }

    @Override
    public void setBufferState(String string) {
    }

    @Override
    public void updateActiveSource(MediaSlotInfo mediaSlotInfo) {
    }

    static {
        mainModelDescription = Collections.unmodifiableList(Arrays.asList(new String[]{"line1Text", "line2Text", "line3Text", "line1Image", "line2Image", "line3Image"}));
        timeModelDescription = Collections.unmodifiableList(Arrays.asList(new String[]{"timeLeft", "timePlaying", "timeProgressBar"}));
    }
}

