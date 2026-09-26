/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.oneshot.IOneshotDestinationTypeMapper;
import de.audi.app.sdsmanager.oneshot.IOneshotFilterStrategy;
import de.audi.app.sdsmanager.oneshot.IOneshotListModeMapper;
import de.audi.app.sdsmanager.oneshot.IOneshotPicklistHandling;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.log.LogChannel;

public class OneshotHandler {
    public static final int ONESHOT_USECASE_NAVI_VDE;
    public static final int ONESHOT_USECASE_NAVI_POI_CITY;
    public static final int ONESHOT_USECASE_MEDIA_G2P;
    public static final int ONESHOT_USECASE_MEDIA_SINGLESLOT;
    public static final int LEVEL_0;
    public static final int LEVEL_1;
    public static final int LEVEL_2;
    public static final int LEVEL_3;
    public static final int LEVEL_4;
    protected LogChannel logger = Logger.getMainLog();
    protected final HMIService hmi;
    protected IPicklist initialPicklist;
    protected IPicklist currentPicklist;
    protected NaviService$OneshotData[] oneshotDataStorage;
    protected int numberOfOneshotLevels;
    protected int[][] oneshotListModeToOneshotLevel;
    protected int[] oneshotLevelToLabelModels;
    private IOneshotPicklistHandling picklistHandlingStrategy;
    private IOneshotListModeMapper listModeMapper;
    private IOneshotDestinationTypeMapper destinationTypeMapper;
    private IOneshotFilterStrategy filterStrategy;

    public OneshotHandler(HMIService hMIService, int n, IOneshotPicklistHandling iOneshotPicklistHandling, IOneshotListModeMapper iOneshotListModeMapper, IOneshotDestinationTypeMapper iOneshotDestinationTypeMapper, IOneshotFilterStrategy iOneshotFilterStrategy, int[] nArray) {
        this.hmi = hMIService;
        this.numberOfOneshotLevels = n;
        this.picklistHandlingStrategy = iOneshotPicklistHandling;
        this.listModeMapper = iOneshotListModeMapper;
        this.destinationTypeMapper = iOneshotDestinationTypeMapper;
        this.filterStrategy = iOneshotFilterStrategy;
        this.oneshotLevelToLabelModels = nArray;
        this.oneshotDataStorage = new NaviService$OneshotData[this.numberOfOneshotLevels];
    }

    void initialize(IPicklist iPicklist) {
        this.logger.log(-2137614336, "OneshotHandler#initialize(): initialize with picklist %1", (Object)iPicklist);
        this.initialPicklist = iPicklist;
        this.currentPicklist = null;
        this.oneshotDataStorage = new NaviService$OneshotData[this.numberOfOneshotLevels];
        this.clearOneshotData(0);
    }

    public IPicklist getCurrentPicklist() {
        return this.currentPicklist;
    }

    public NaviService$OneshotData getOneshotData(int n) {
        if (this.oneshotDataStorage.length <= n) {
            return null;
        }
        return this.oneshotDataStorage[n];
    }

    public void setOneshotData(NaviService$OneshotData naviService$OneshotData, int n) {
        if (n >= this.numberOfOneshotLevels) {
            return;
        }
        String string = naviService$OneshotData == null ? "" : naviService$OneshotData.getText();
        String string2 = naviService$OneshotData == null ? "" : naviService$OneshotData.getStringId();
        long l = naviService$OneshotData == null ? -1L : naviService$OneshotData.getObjId();
        this.oneshotDataStorage[n] = new NaviService$OneshotData(string, string2, l);
        this.setOneshotLabelModel(n, string);
    }

    public byte filterPicklist(int n) {
        Object object;
        int n2 = this.listModeMapper.mapToOneshotLevel(n);
        this.logger.log(-2137614336, "OneshotHandler#filterPicklist: listmode=%1, level=%2!", (long)n, (long)n2);
        if (n2 == 128) {
            return -1;
        }
        String[] stringArray = this.getOneshotFilterStrings(n2);
        byte by = 0;
        if (stringArray != null) {
            object = this.filterStrategy.filterEntryPicklist(this.initialPicklist, stringArray, n2);
            this.currentPicklist = object;
            int n3 = object.getSize();
            by = SDSUtils.getPicklistSizeConstant(n3);
            this.logger.log(-2137614336, "OneshotHandler#filterPicklist: number of entries %1 => sizeConstant %2!", (long)n3, (long)by);
        }
        SDSModelAccess.setNBestListSlotXModel(by, n2 + this.picklistHandlingStrategy.getSlotLevelOffset());
        switch (by) {
            case 0: {
                this.logger.log(-2137614336, "OneshotHandler#filterPicklist: Clearing oneshot data from level %1 for RECOG_EMPTY!", (long)n2);
                this.clearOneshotData(n2);
                break;
            }
            case 1: {
                this.clearOneshotData(n2 + 1);
                this.setOneshotData(this.currentPicklist.getSlot(0, 0), n2);
                object = this.getOneshotData(n2);
                SDSModelAccess.setSlotModel(n2 + 1, ((NaviService$OneshotData)object).getText());
                SDSModelAccess.setSlotModelStringID(n2 + 1, ((NaviService$OneshotData)object).getStringId());
                SDSModelAccess.setListLineDataGetModel(((NaviService$OneshotData)object).getText());
                break;
            }
            case 2: 
            case 3: {
                this.logger.log(-2137614336, "OneshotHandler#filterPicklist: Multiple entries found => NOP!");
                break;
            }
            default: {
                this.logger.log(-1601830656, "OneshotHandler#filterPicklist: Unhandled sizeConstant %1!", (long)by);
            }
        }
        return by;
    }

    private String[] getOneshotFilterStrings(int n) {
        String[] stringArray = new String[n];
        if (n == 0) {
            return stringArray;
        }
        if (n >= this.oneshotDataStorage.length) {
            return null;
        }
        for (int i2 = 0; i2 < n; ++i2) {
            NaviService$OneshotData naviService$OneshotData = this.oneshotDataStorage[i2];
            stringArray[i2] = naviService$OneshotData == null ? "" : naviService$OneshotData.getText();
        }
        return stringArray;
    }

    public void handlePicklistTitle(int n) {
        this.picklistHandlingStrategy.handlePicklistTitle(n);
    }

    public NaviService$OneshotData matchSlotToOneshotPicklist(IPicklistSlot iPicklistSlot, int n) {
        IPicklistElement iPicklistElement;
        int n2 = this.listModeMapper.mapToOneshotLevel(n);
        this.logger.log(-2137614336, "[OneshotHandler#matchSlotToOneshotPicklist] for column %1", (long)n2);
        if (iPicklistSlot == null || iPicklistSlot.getIndex() < 0) {
            this.logger.log(-1601830656, "[OneshotHandler#matchSlotToOneshotPicklist] -> slot or index invalid");
            return null;
        }
        int n3 = this.initialPicklist.getPositionForSlotIndex(iPicklistSlot.getIndex());
        IPicklistElement iPicklistElement2 = iPicklistElement = this.initialPicklist == null ? null : this.initialPicklist.get(n3);
        if (iPicklistElement == null) {
            this.logger.log(-1601830656, "[OneshotHandler#matchSlotToOneshotPicklist] -> no picklist element for index %1", (long)n3);
            return null;
        }
        String[] stringArray = this.getOneshotFilterStrings(n2);
        if (stringArray == null) {
            this.logger.log(-1601830656, "[OneshotHandler#matchSlotToOneshotPicklist] -> invalid filter strings for column %1", (long)n2);
            return null;
        }
        IPicklistSlot[] iPicklistSlotArray = iPicklistElement.getSlots();
        if (SDSUtils.areSlotsInvalidForColumn(iPicklistSlotArray, n2)) {
            this.logger.log(-1601830656, "[OneshotHandler#matchSlotToOneshotPicklist] Empty/invalid slot for entry!");
            return null;
        }
        boolean bl = SDSUtils.matchFilterStrings(stringArray, iPicklistSlotArray);
        this.logger.log(-2137614336, "[OneshotHandler#matchSlotToOneshotPicklist] %1 entry!", (Object)(bl ? "Matching" : "Mismatch for"));
        if (!bl) {
            return null;
        }
        IPicklistSlot iPicklistSlot2 = iPicklistSlotArray[n2];
        this.setOneshotData(iPicklistSlot2, n2);
        return this.getOneshotData(n2);
    }

    public int determineCorrectOneshotEvent() {
        int n = 3007;
        block7: for (int i2 = 0; i2 < this.oneshotDataStorage.length && !this.mustOneshotLevelBeFilled(i2); ++i2) {
            if (i2 == this.numberOfOneshotLevels - 1) {
                n = 3000;
                break;
            }
            switch (i2) {
                case 0: {
                    n = 1302069248;
                    continue block7;
                }
                case 1: {
                    n = 1318846464;
                    continue block7;
                }
                case 2: {
                    n = 1335623680;
                    continue block7;
                }
                case 3: {
                    n = 1352400896;
                    continue block7;
                }
                case 4: {
                    n = 1369178112;
                    continue block7;
                }
            }
        }
        return n;
    }

    private boolean mustOneshotLevelBeFilled(int n) {
        boolean bl = SDSUtils.isEmpty(this.oneshotDataStorage[n]);
        if (bl) {
            for (int i2 = n + 1; i2 < this.oneshotDataStorage.length && (bl = SDSUtils.isEmpty(this.oneshotDataStorage[i2])); ++i2) {
            }
        }
        return bl;
    }

    protected void setOneshotLabelModel(int n, String string) {
        if (n > this.oneshotLevelToLabelModels.length || n < 0) {
            return;
        }
        LabelModelApp labelModelApp = this.hmi.getLabelModel(this.oneshotLevelToLabelModels[n]);
        if (labelModelApp == null) {
            return;
        }
        labelModelApp.setText(string);
    }

    public void setOneshotLabelModelForDestinationType(int n, String string) {
        this.setOneshotLabelModel(this.destinationTypeMapper.mapToOneshotLevel(n), string);
    }

    private void clearOneshotData(int n) {
        for (int i2 = n; i2 < this.numberOfOneshotLevels; ++i2) {
            this.oneshotDataStorage[i2] = new NaviService$OneshotData("", "");
            this.setOneshotLabelModel(i2, "");
        }
    }

    public boolean setOneshotData(IPicklistElement iPicklistElement, int n) {
        this.logger.log(-2137614336, "OneshotHandler#storeOneshotData: picklistMode=%1", (long)n);
        int n2 = this.listModeMapper.mapToOneshotLevel(n);
        this.logger.log(-2137614336, "OneshotHandler#storeOneshotData: oneshotLevel=%1!", (long)n2);
        if (n2 == 128) {
            this.logger.log(-2137614336, "OneshotHandler#storeOneshotData: Oneshot not active => NOP!");
            return true;
        }
        if (iPicklistElement == null || SDSUtils.isEmpty(iPicklistElement.getSlots())) {
            return false;
        }
        this.setOneshotData(iPicklistElement.getSlots()[0], n2);
        return true;
    }

    public void setOneshotData(IPicklistSlot[] iPicklistSlotArray) {
        int n = SDSUtils.isEmpty(iPicklistSlotArray) ? 0 : iPicklistSlotArray.length;
        for (int i2 = 0; i2 < this.numberOfOneshotLevels && i2 < n; ++i2) {
            this.setOneshotData(iPicklistSlotArray[i2], i2);
        }
    }

    public void setOneshotData(IPicklistSlot iPicklistSlot, int n) {
        this.logger.log(-2137614336, "OneshotHandler#setOneshotdata: slot=%1, level=%2", (Object)iPicklistSlot, (long)n);
        if (n >= this.numberOfOneshotLevels) {
            return;
        }
        String string = iPicklistSlot == null ? "" : iPicklistSlot.getText();
        String string2 = iPicklistSlot == null ? "" : iPicklistSlot.getObjectStringID();
        long l = iPicklistSlot == null ? -1L : iPicklistSlot.getObjID();
        this.oneshotDataStorage[n] = new NaviService$OneshotData(string, string2, l);
        this.setOneshotLabelModel(n, string);
    }

    public boolean rearrangeInitialPicklist(int[] nArray) {
        IPicklist iPicklist = this.initialPicklist.getRearrangedPicklist(nArray);
        if (iPicklist == null) {
            this.logger.log(-1601830656, "OneshotHandler#rearrangeInitialPicklist: failed.");
            return false;
        }
        this.initialPicklist = iPicklist;
        this.logger.log(-2137614336, "OneshotHandler#rearrangeInitialPicklist: new initialPicklist: \n%1.", (Object)this.initialPicklist.toString());
        return true;
    }
}

