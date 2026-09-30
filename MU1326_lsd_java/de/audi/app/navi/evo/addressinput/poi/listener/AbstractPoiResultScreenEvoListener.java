/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiScreenHmiListener;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.CmdNaviPreviewMapPrepare;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractPoiResultScreenEvoListener
extends AbstractPoiScreenHmiListener
implements BaseListModelListener {
    protected CmdNaviPreviewMapPrepare preparePreviewMapCommand;
    private final AsyncNavLocationExtractor extractor;
    private final LabelModelApp telephoneNumberLabel;
    protected long currentlyFocusedListIndex;
    protected boolean previewMapComplete;
    private static final int ACTIVE_POI_CONTEXT_DESTINATION = 0;
    private static final int ACTIVE_POI_CONTEXT_MAP = 1;
    private boolean running = false;

    public AbstractPoiResultScreenEvoListener(NavigationEnv navigationEnv, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea, AsyncNavLocationExtractor asyncNavLocationExtractor) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea);
        this.telephoneNumberLabel = navigationEnv.getLabelModel(401896);
        this.extractor = asyncNavLocationExtractor;
    }

    public void itemFocused(final EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#itemFocused - list model - row=%1, model=%2, index=%3").toString(), (Object)evoListRow, (long)n, (long)n2);
        this.previewMapComplete = false;
        this.preparePreviewMap();
        NavLocationCallback navLocationCallback = new NavLocationCallback(){

            public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                AbstractPoiResultScreenEvoListener.this.isPoiCallable(navLocation, evoListRow);
                AbstractPoiResultScreenEvoListener.this.itemFocusedCallBack(navLocation);
            }
        };
        this.extractor.executeCallbackWithNavLocation(evoListRow, 0, navLocationCallback);
    }

    protected abstract void itemFocusedCallBack(NavLocation var1);

    private void isPoiCallable(NavLocation navLocation, EvoListRow evoListRow) {
        if (PoiUtil.checkIfPoiIsCallable(navLocation, this.env)) {
            this.setTelephoneNumberForLabel(navLocation);
            PropertyListCell propertyListCell = (PropertyListCell)evoListRow.getCell(3);
            int[] nArray = propertyListCell.getProperties();
            boolean bl = true;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] != -1996031499) continue;
                bl = false;
                break;
            }
            if (bl) {
                propertyListCell = PropertyListCell.create(propertyListCell.getCategory(), this.createPropertyForPhoneNumber(nArray));
                evoListRow.setPropertyCell(3, propertyListCell);
            }
        } else {
            this.telephoneNumberLabel.setText("");
        }
    }

    private int[] createPropertyForPhoneNumber(int[] nArray) {
        int n = this.env.getChoiceModel(401894).getValue();
        this.logChannel.log(10000000, "%1#createPropertyForPhoneNumber - current choice model value=%2", (Object)this.CLASS_NAME, (long)n);
        int[] nArray2 = new int[nArray.length + 1];
        System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, nArray.length);
        if (n == 0) {
            nArray2[nArray.length] = -1996031499;
        } else if (n == 1) {
            nArray2[nArray.length] = -1245389573;
        } else {
            this.env.getPOILogChannel().log(100000, "%1#createPropertyForPhoneNumber - choice model has an unknown value! value=%2", (Object)this.CLASS_NAME, (long)n);
        }
        return nArray2;
    }

    private void setTelephoneNumberForLabel(NavLocation navLocation) {
        String string = LocationFormatter.formatPhonenumber(navLocation);
        this.logChannel.log(10000000, "%1#setTelephoneNumberForLabel - number=%2", (Object)this.CLASS_NAME, (Object)string);
        this.telephoneNumberLabel.setText(string);
    }

    protected void setSpellerStatusWaiting(int n) {
        this.logChannel.log(10000000, "%1#setSpellerStatusWaiting for model=%2", (Object)this.CLASS_NAME, (long)n);
        Util.setModelStatus(this.env.getMatchSpellerModel(n), 0);
    }

    public void updateSearchStarted() {
        this.logChannel.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#updateSearchStarted").toString());
        this.previewMapComplete = false;
        CommandList commandList = this.poiManager.getCommandlist();
        commandList.add(new HidePreviewMapCommand(this.previewMapInterface));
        commandList.execute("AbstractPoiResultScreenEvoListener hidePreviewMap");
    }

    protected void displayPreviewMap(final int n, final AbstractPoiScreenInputSequence abstractPoiScreenInputSequence, final int n2) {
        if (this.running || this.previewMapComplete && !this.preparePreviewMapCommand.getHidePreviewMap()) {
            this.logChannel.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#displayPreviewMap is already running or complete").toString());
            return;
        }
        this.running = true;
        CommandList commandList = this.poiManager.getCommandlist();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#displayPreviewMap delay computing of POIs to display").toString()){

            public void execute() {
                int n3 = SpellerStack.getInstance().getActiveSC().getContextID();
                if (n3 == 10 || n3 == 9 || n3 == 11 || n3 == 15) {
                    if (!AbstractPoiResultScreenEvoListener.this.previewMapComplete || AbstractPoiResultScreenEvoListener.this.preparePreviewMapCommand.getHidePreviewMap()) {
                        AbstractPoiResultScreenEvoListener.this.createPreparePreviewMapCommand(n, abstractPoiScreenInputSequence, n2);
                    }
                } else {
                    this.logger.log(10000000, "AbstractPoiResultScreenEvoListener#displayPreviewMap call will be ignored for context %1", (Object)SpellerContextManager.contextIDToString(n3));
                }
                AbstractPoiResultScreenEvoListener.this.running = false;
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#displayPreviewMap").toString());
    }

    protected void createPreparePreviewMapCommand(int n, AbstractPoiScreenInputSequence abstractPoiScreenInputSequence, int n2) {
        int n3 = this.calculateItemsToDisplay(n2);
        if (n3 > 3) {
            n3 = 3;
        }
        this.logChannel.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#createPreparePreviewMapCommand itemsDisplay = %1").toString(), (long)n3);
        LIValueListElement[] lIValueListElementArray = new LIValueListElement[n3];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            EvoListRow evoListRow = this.env.getTiledListModel(n2).getRow(i2);
            lIValueListElementArray[i2] = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
            if (lIValueListElementArray[i2] == null) continue;
            n4 = i2 + 1;
        }
        LIValueListElement[] lIValueListElementArray2 = new LIValueListElement[n4];
        for (int i3 = 0; i3 < lIValueListElementArray2.length; ++i3) {
            lIValueListElementArray2[i3] = lIValueListElementArray[i3];
        }
        if (lIValueListElementArray2.length == 3) {
            this.previewMapComplete = true;
        }
        if (this.poiManager.isPreviewMapPossible() && lIValueListElementArray2.length == 0) {
            this.logChannel.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#createPreparePreviewMapCommand no POIs to display listToDisplayInMap.length = 0").toString());
            return;
        }
        this.preparePreviewMapCommand = abstractPoiScreenInputSequence.preparePreviewMap(this.previewMapInterface, lIValueListElementArray2);
    }

    private int calculateItemsToDisplay(int n) {
        int n2 = 0;
        TiledListModelApp tiledListModelApp = this.env.getTiledListModel(n);
        for (int i2 = 0; i2 < 3 && tiledListModelApp.getRow(i2) != null; ++i2) {
            ++n2;
        }
        return n2;
    }
}

