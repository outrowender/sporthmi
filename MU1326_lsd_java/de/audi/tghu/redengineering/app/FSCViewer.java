/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.redengineering.app.AbstractEngineeringTextFactory;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.redengineering.app.FSCService;
import de.audi.tghu.swdl.simulators.DSISwdlSWaPSimulator;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.DSISWaP;
import org.dsi.ifc.swap.DSISWaPListener;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public final class FSCViewer
implements ButtonListener,
ListListener,
DSISWaPListener {
    private static final String CLASSNAME;
    private static final String TEXT_MISSING_STRING;
    private static final int STATE_NOT_INITIALIZED;
    private static final int STATE_IS_BLANK;
    private static final int[] imExMediaHigh;
    private static final int[] imExMediaStd;
    private final int[] imExMedia;
    private DSISWaP dsi;
    private SFscStatus[] fscList = new SFscStatus[0];
    private SFscHistory[] fscHistoryList = new SFscHistory[0];
    private int lastImportMedium = -1;
    private FSCService fscService;
    private final EngineeringEnv engineeringEnv;

    protected FSCViewer(EngineeringEnv engineeringEnv) {
        this.engineeringEnv = engineeringEnv;
        this.getLogFSC().log(1078071040, "%1 <init>", (Object)"[FSCViewer]");
        this.getInstalledFSCButton().setButtonListener(this);
        this.getSupportedFSCButton().setButtonListener(this);
        this.getImportButton().setButtonListener(this);
        this.getExportButton().setButtonListener(this);
        this.getHistoryButton().setButtonListener(this);
        this.getContinueButton().setButtonListener(this);
        this.getFSCEnterButton().setButtonListener(this);
        this.getFSCList().setListListener(this);
        this.getFSCList().setMaxColumns(3);
        this.updateFSCDisplayList();
        this.getFSCHistoryList().setListListener(this);
        this.getFSCHistoryList().setMaxColumns(2);
        this.updateFSCHistoryList();
        this.getImExMediaList().setListListener(this);
        this.getImExMediaList().setMaxColumns(3);
        this.imExMedia = 0 == engineeringEnv.getSysConst(523) ? imExMediaStd : imExMediaHigh;
        this.updateImExMediaList();
        this.getImExResultList().setListListener(this);
        this.getImExResultList().setMaxColumns(4);
        this.getFSCDetailsList().setMaxColumns(3);
        if (Boolean.getBoolean("SimulateSWDL")) {
            this.setDSI(new DSISwdlSWaPSimulator(engineeringEnv, this));
        }
        this.fscService = new FSCService(this);
    }

    private EngineeringEnv getEnv() {
        return this.engineeringEnv;
    }

    public FSCService getFscService() {
        return this.fscService;
    }

    public IHMIServiceApp getHMIService() {
        return this.getEnv().getHMIService();
    }

    private ButtonModelApp getInstalledFSCButton() {
        return this.getHMIService().getButtonModel(1003885312);
    }

    private ButtonModelApp getSupportedFSCButton() {
        return this.getHMIService().getButtonModel(1658196736);
    }

    private ButtonModelApp getImportButton() {
        return this.getHMIService().getButtonModel(852890368);
    }

    private ButtonModelApp getHistoryButton() {
        return this.getHMIService().getButtonModel(802558720);
    }

    private ButtonModelApp getExportButton() {
        return this.getHMIService().getButtonModel(785781504);
    }

    private ButtonModelApp getContinueButton() {
        return this.getHMIService().getButtonModel(836113152);
    }

    private ButtonModelApp getFSCEnterButton() {
        return this.getHMIService().getButtonModel(1876300544);
    }

    private ListModelApp getFSCList() {
        return this.getHMIService().getListModel(1020662528);
    }

    private ListModelApp getFSCHistoryList() {
        return this.getHMIService().getListModel(819335936);
    }

    private ListModelApp getImportedList() {
        return this.getHMIService().getListModel(970330880);
    }

    private ListModelApp getImExMediaList() {
        return this.getHMIService().getListModel(903222016);
    }

    private ListModelApp getImExResultList() {
        return this.getHMIService().getListModel(970330880);
    }

    private ListModelApp getFSCDetailsList() {
        return this.getHMIService().getListModel(1809191680);
    }

    private ChoiceModelApp getImExSubTitleChoice() {
        return this.getHMIService().getChoiceModel(953553664);
    }

    private LabelModelApp getFscMessageLabel() {
        return this.getHMIService().getLabelModel(1825968896);
    }

    private LabelModelApp getFscHistoryMessageLabel() {
        return this.getHMIService().getLabelModel(1842746112);
    }

    private ChoiceModelApp getImExStateChoice() {
        return this.getHMIService().getChoiceModel(936776448);
    }

    private LabelModelApp getImExResultLabel() {
        return this.getHMIService().getLabelModel(1792414464);
    }

    private LabelModelApp getFSCLoggingInfoLabel() {
        return this.getHMIService().getLabelModel(869667584);
    }

    private LogChannel getLogFSC() {
        return this.getEnv().getLogFSC();
    }

    private SFscStatus getFSC(int n) {
        SFscStatus sFscStatus = null;
        for (int i2 = 0; i2 < this.fscList.length; ++i2) {
            SFscStatus sFscStatus2 = this.fscList[i2];
            if (sFscStatus2.getSwid() != n) continue;
            sFscStatus = sFscStatus2;
            break;
        }
        return sFscStatus;
    }

    private String int2Hex(int n) {
        int[] nArray = new int[8];
        int n2 = n;
        for (int i2 = 0; i2 < 8; ++i2) {
            nArray[7 - i2] = n2 & 0xF;
            n2 >>= 4;
        }
        Buffer buffer = new Buffer();
        for (int i3 = 0; i3 < 8; ++i3) {
            buffer.append(Integer.toHexString(nArray[i3]));
        }
        return buffer.toString();
    }

    private boolean isInstalledState(int n) {
        return n == 0 || n == 1 || n == 3;
    }

    public boolean isInstalled(int n) {
        SFscStatus sFscStatus = this.getFSC(n);
        return sFscStatus != null ? this.isInstalledState(sFscStatus.getState()) : false;
    }

    private void getFSCDetail(int n, int n2, int n3) {
        this.getLogFSC().log(1078071040, "[FSCViewer] getFSCDetail( swid=0x%1, state=%2, index=%3 )", (long)n, (long)n2, (long)n3);
        this.dsi.getFscDetails(n, n2, n3);
    }

    private AbstractEngineeringTextFactory getTextFactory() {
        return this.getEnv().getTextFactory();
    }

    private void updateFSCDetailsList(SFscDetails sFscDetails) {
        this.getLogFSC().log(1078071040, "[FSCViewer] getFSCDetail( 0x%1 )", (long)sFscDetails.getSwid());
        int n = sFscDetails.getSwid();
        try {
            this.getFSCDetailsList().beginTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 updateFSCDetailsList(): begin transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
        this.getFSCDetailsList().clear();
        if (this.getFSCDetailsList().getMaxRows() < 5) {
            this.getFSCDetailsList().setMaxRows(5);
        }
        this.addFSCDetailsRow(0, this.getTextFactory().getTextConstantCode(), this.int2Hex(n));
        this.addFSCDetailsRow(1, this.getTextFactory().getTextConstantVersion(), Integer.toString(sFscDetails.getVersion()));
        this.addFSCDetailsRow(2, this.getTextFactory().getTextConstantState(), this.getStateToString(sFscDetails.getState()));
        this.addFSCDetailsRow(3, this.getTextFactory().getTextConstantVin(), sFscDetails.getVin());
        this.addFSCDetailsRow(4, this.getTextFactory().getTextConstantDate(), sFscDetails.getDate());
        try {
            this.getFSCDetailsList().endTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 updateFSCDetailsList(): end transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
    }

    private void addFSCDetailsRow(int n, String string, String string2) {
        ListCell[] listCellArray = new ListCell[]{new IntegerListCell(n, 5), new TextListCell(string), new TextListCell(string2)};
        this.getFSCDetailsList().addRow(listCellArray);
    }

    private String getStateToString(int n) {
        String string = "---";
        switch (n) {
            case 0: {
                string = this.getTextFactory().getTextConstantPermissionGranted();
                break;
            }
            case 1: {
                string = this.getTextFactory().getTextConstantIllegal();
                break;
            }
            case 2: {
                string = this.getTextFactory().getTextConstantFSCStateSupported();
                break;
            }
            case 4: {
                string = this.getTextFactory().getTextConstantPermissionPermanentWithdrawn();
                break;
            }
            case 3: {
                string = this.getTextFactory().getTextConstantPermissionTemporarilyWithdrawn();
                break;
            }
            default: {
                string = this.getTextFactory().getTextConstantFSCNoValidString();
            }
        }
        return string;
    }

    private int checkFSCState(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return n;
            }
            case -1: {
                return 5;
            }
        }
        this.getLogFSC().log(10000, "%1 getKeyStateCode invalid! ( %2 )", (Object)"[FSCViewer]", (Object)"NONE GIVEN");
        return 6;
    }

    private void updateFSCHistoryList() {
        this.getLogFSC().log(1078071040, "%1 updateFSCHistoryList()", (Object)"[FSCViewer]");
        try {
            this.getFSCHistoryList().beginTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 updateFSCHistoryList(): begin transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
        this.getFSCHistoryList().clear();
        if (this.getFSCHistoryList().getMaxRows() < this.fscHistoryList.length) {
            this.getFSCHistoryList().setMaxRows(this.fscHistoryList.length);
        }
        if (this.fscHistoryList.length > 0) {
            for (int i2 = 0; i2 < this.fscHistoryList.length; ++i2) {
                SFscHistory sFscHistory = this.fscHistoryList[i2];
                ListCell[] listCellArray = new ListCell[]{TextListCell.create(sFscHistory.getTimestamp().replace('_', ' ')), TextListCell.create(new StringBuffer().append("    0x").append(this.int2Hex(sFscHistory.getSwid())).toString())};
                this.getFscHistoryMessageLabel().setText("");
                this.getFSCHistoryList().addRow(listCellArray);
            }
        } else {
            this.getFscHistoryMessageLabel().setText(this.getTextFactory().getTextConstantFSCNoLoggingAvailable());
            this.getFSCHistoryList().clear();
        }
        try {
            this.getFSCHistoryList().endTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 updateFSCHistoryList(): end transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
        this.getHistoryButton().fireEvent(this.getEnv().getTerminalId());
    }

    private void updateFSCDisplayList() {
        this.getLogFSC().log(1078071040, "%1 updateFSCList()", (Object)"[FSCViewer]");
        try {
            this.getFSCList().beginTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 updateFSCList(): begin transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
        this.getFSCList().clear();
        if (this.getFSCList().getMaxRows() < this.fscList.length) {
            this.getFSCList().setMaxRows(this.fscList.length);
        }
        if (this.fscList.length > 0) {
            ListCell[] listCellArray = null;
            for (int i2 = 0; i2 < this.fscList.length; ++i2) {
                SFscStatus sFscStatus = this.fscList[i2];
                listCellArray = new ListCell[]{new IntegerListCell(i2, 1000), new TextListCell(this.int2Hex(sFscStatus.getSwid())), new IntegerListCell(this.checkFSCState(sFscStatus.getState()), 10)};
                this.getFscMessageLabel().setText("");
                this.getFSCList().addRow(listCellArray);
            }
        } else {
            this.getFscMessageLabel().setText(this.getTextFactory().getTextConstantFSCNotAvailable());
            this.getFSCList().clear();
        }
        try {
            this.getFSCList().endTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 updateFSCList(): end transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
    }

    private void updateFSCImportList(SFscImportStatus[] sFscImportStatusArray) {
        this.getLogFSC().log(1078071040, "%1 updateFSCImportList()", (Object)"[FSCViewer]");
        try {
            this.getImExResultList().beginTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 updateFSCImportList(): begin transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
        this.getImExResultList().clear();
        for (int i2 = 0; i2 < sFscImportStatusArray.length; ++i2) {
            SFscImportStatus sFscImportStatus = sFscImportStatusArray[i2];
            this.getLogFSC().log(1078071040, "%1 updateFSCImportList(): %2", (Object)"[FSCViewer]", (Object)sFscImportStatus);
            ListCell[] listCellArray = new ListCell[]{new IntegerListCell(i2, 1000), new TextListCell(this.int2Hex(sFscImportStatus.getSwid())), new IntegerListCell(this.checkFSCState(sFscImportStatus.getState()), 10), new IntegerListCell(0, 0)};
            this.getImExResultList().addRow(listCellArray);
        }
        this.getImExResultList().endTransaction();
        this.updateFSCDisplayList();
    }

    private void updateImExMediaList() {
        this.getLogFSC().log(1078071040, "%1 updateImExMediaList()", (Object)"[FSCViewer]");
        try {
            this.getImExMediaList().beginTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 updateImExMediaList(): begin transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
        this.getImExMediaList().clear();
        ListCell[] listCellArray = null;
        for (int i2 = 0; i2 < this.imExMedia.length; ++i2) {
            listCellArray = new ListCell[3];
            listCellArray[0] = new IntegerListCell(this.imExMedia[i2], -129);
            listCellArray[1] = new IntegerListCell(1, 10);
            this.getImExMediaList().addRow(listCellArray);
        }
        try {
            this.getImExMediaList().endTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 updateImExMediaList(): end transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.getLogFSC().log(-2137614336, "%1 keyPressed(%2)", (Object)"[FSCViewer]", (long)n);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.getLogFSC().log(-2137614336, "%1 keyReleased(%2)", (Object)"[FSCViewer]", (long)n);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.getLogFSC().log(1078071040, "%1 keyTyped(%2)", (Object)"[FSCViewer]", (long)n);
        switch (n) {
            case 1300027: {
                this.getInstalledFSCButton().fireEvent(n3);
                break;
            }
            case 1300066: {
                this.getSupportedFSCButton().fireEvent(n3);
                break;
            }
            case 1300018: {
                this.getImExSubTitleChoice().setValue(0);
                this.getImportButton().fireEvent(n3);
                break;
            }
            case 1300014: {
                this.getImExSubTitleChoice().setValue(1);
                this.getExportButton().fireEvent(n3);
                break;
            }
            case 1300015: {
                this.dsi.getHistory();
                break;
            }
            case 1300017: {
                this.getContinueButton().fireEvent(n3);
                break;
            }
            case 1300079: {
                this.updateFSCDisplayList();
                this.getFSCEnterButton().fireEvent(n3);
                break;
            }
            default: {
                this.getLogFSC().log(1078071040, "%1 keyTyped: ignoring model id %2", (Object)"[FSCViewer]", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.getLogFSC().log(1078071040, "%1 itemFocused(%2, %3)", (Object)"[FSCViewer]", (long)n, (long)n2);
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
        this.getLogFSC().log(1078071040, "%1 itemReleased(%2, %3)", (Object)"[FSCViewer]", (long)n, (long)n2);
    }

    public void startFSCImport(int n) {
        this.getLogFSC().log(1078071040, "%1 startFSCImport( %2 )", (Object)"[FSCViewer]", (long)n);
        this.getImExStateChoice().setValue(0);
        this.getImExStateChoice().setStatus(0);
        try {
            this.lastImportMedium = n;
            this.dsi.importFSCs(n);
        }
        catch (DSIException dSIException) {
            this.getLogFSC().log(10000, "%1 startFSCImport( %2 ) failed with DSIException", (Object)"[FSCViewer]", (Object)Integer.toString(n), (Object)dSIException);
            this.fscService.notifyImportFSCDone(n);
        }
    }

    private void startVersionExport(int n) {
        this.getLogFSC().log(1078071040, "FSCViewer.startVersionExport(%1)", (long)n);
        this.getImExStateChoice().setValue(0);
        this.getImExStateChoice().setStatus(0);
        try {
            this.dsi.exportCCD(n);
        }
        catch (DSIException dSIException) {
            this.getLogFSC().log(10000, "%1 startVersionExport( %2 ) failed with DSIException", (Object)"[FSCViewer]", (Object)Integer.toString(n), (Object)dSIException);
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLogFSC().log(1078071040, "%1 itemSelected(%2, %3)", (Object)"[FSCViewer]", (long)n, (long)n2);
        if (n == 1020662528) {
            SFscStatus sFscStatus = this.fscList[n2];
            int n5 = sFscStatus.getSwid();
            int n6 = sFscStatus.getState();
            this.getFSCDetail(n5, n6, sFscStatus.getIndex());
        } else if (n == 819335936) {
            this.getFscLoggingInfo(this.fscHistoryList[n2]);
            this.getFSCHistoryList().fireEvent(n4);
        } else if (n == 903222016) {
            this.getLogFSC().log(1078071040, "%1 Selected import/export medium ( %3, %2 )", (Object)"[FSCViewer]", (long)this.imExMedia[n2], (long)n2);
            if (this.getImExSubTitleChoice().getValue() == 0) {
                this.startFSCImport(this.imExMedia[n2]);
            } else {
                this.startVersionExport(this.imExMedia[n2]);
            }
            this.getImExMediaList().fireEvent(n4);
        } else {
            this.getLogFSC().log(1078071040, "Ignore itemSelected for (%1)", (long)n2);
        }
    }

    void setDSI(DSISWaP dSISWaP) {
        this.getLogFSC().log(1078071040, "%1 setDSI(%2)", (Object)"[FSCViewer]", (Object)dSISWaP);
        this.dsi = dSISWaP;
        dSISWaP.setNotification(new int[]{8, 2}, (DSIListener)this);
    }

    @Override
    public void updateFscList(SFscStatus[] sFscStatusArray, int n) {
        if (1 == n) {
            this.getLogFSC().log(1078071040, "%1 DSISwdlSelectionListener#updateFscList()", (Object)"[FSCViewer]");
            if (sFscStatusArray == null) {
                sFscStatusArray = new SFscStatus[]{};
            }
            ArrayList arrayList = new ArrayList(sFscStatusArray.length);
            for (int i2 = 0; i2 < sFscStatusArray.length; ++i2) {
                if (2 != sFscStatusArray[i2].getState()) {
                    this.getLogFSC().log(1078071040, "SFscStatus( 0x%1, %2, %3)", (long)sFscStatusArray[i2].getSwid(), (long)sFscStatusArray[i2].getState(), (long)sFscStatusArray[i2].getIndex());
                    arrayList.add(sFscStatusArray[i2]);
                    continue;
                }
                this.getLogFSC().log(1078071040, "SFscStatus( 0x%1, %2, %3) is supported, but not on the main unit; do not display", (long)sFscStatusArray[i2].getSwid(), (long)sFscStatusArray[i2].getState(), (long)sFscStatusArray[i2].getIndex());
            }
            this.fscList = new SFscStatus[arrayList.size()];
            System.arraycopy((Object)arrayList.toArray(), 0, (Object)this.fscList, 0, arrayList.size());
            this.updateFSCDisplayList();
        }
    }

    @Override
    public void getFscDetail(SFscDetails sFscDetails) {
        this.getLogFSC().log(1078071040, "%1 DSISWaPListener#getFscDetails( %2 )", (Object)"[FSCViewer]", (Object)sFscDetails);
        this.updateFSCDetailsList(sFscDetails);
        this.getFSCList().fireEvent(this.getEnv().getTerminalId());
    }

    public void getFscLoggingInfo(SFscHistory sFscHistory) {
        this.getLogFSC().log(1078071040, "%1 DSISWaPListener#getFscLoggingInfo( %2 )", (Object)"[FSCViewer]", (Object)sFscHistory);
        this.getFSCLoggingInfoLabel().setText(this.getFscLoggingText(sFscHistory));
        this.getFSCList().fireEvent(this.getEnv().getTerminalId());
    }

    private String getFscLoggingText(SFscHistory sFscHistory) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sFscHistory.getTimeStamp().replace('_', ' ')).append('\n');
        stringBuffer.append(sFscHistory.getLoginfo().replace(' ', '\n').replace('\'', ' ').replace(',', '\n'));
        return stringBuffer.toString();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getLogFSC().log(-2137614336, "%1 DSICryptoManagerHMIListener#asyncException( %3, %2, %4 )", (Object)"[FSCViewer]", (Object)string, (Object)new Integer(n), (long)n2);
    }

    private void writeResultMessage(String string) {
        try {
            this.getImExResultList().beginTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 handleExport(): begin transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
        this.getImExResultList().clear();
        this.getImExResultLabel().setText(string);
        try {
            this.getImExResultList().endTransaction();
        }
        catch (IllegalStateException illegalStateException) {
            this.getLogFSC().log(-1601830656, "%1 handleExport(): end transaction failed!", (Object)"[FSCViewer]", (Throwable)illegalStateException);
        }
        this.getImExStateChoice().setValue(0);
        this.getImExStateChoice().setStatus(1);
    }

    @Override
    public void exportCCD(int n) {
        String string;
        if (n == 0) {
            this.getLogFSC().log(10000, "%1 SWaP export is successful", (Object)"[FSCViewer]", (long)n);
            string = this.getTextFactory().getTextComstantFSCExportVersionSuccessfull();
        } else {
            this.getLogFSC().log(10000, "%1 SWaP export error. resultCode: %2", (Object)"[FSCViewer]", (long)n);
            string = this.getTextFactory().getTextComstantFSCExportVersionFailed();
        }
        this.writeResultMessage(string);
    }

    @Override
    public void importFSCsList(int n, SFscImportStatus[] sFscImportStatusArray) {
        this.getLogFSC().log(1078071040, "%1 importFSCsList(resultCode=%3, fscImportStatus=%2)", (Object)"[FSCViewer]", (Object)sFscImportStatusArray, (long)n);
        if (n == 0) {
            if (sFscImportStatusArray.length == 0) {
                this.getLogFSC().log(-2137614336, "%1 The list of imported function enabling codes is empty", (Object)"[FSCViewer]");
            } else {
                this.writeResultMessage(this.getTextFactory().getTextComstantFSCImportFeatureSuccessfull());
                this.updateFSCImportList(sFscImportStatusArray);
            }
            this.getImExStateChoice().setValue(0);
            this.getImExStateChoice().setStatus(1);
        } else {
            this.writeResultMessage(this.getTextFactory().getTextComstantFSCImportFeatureFailed());
        }
        this.fscService.notifyImportFSCDone(this.lastImportMedium);
    }

    @Override
    public void getHistoryList(SFscHistory[] sFscHistoryArray) {
        this.getLogFSC().log(-2137614336, "%1 <- getHistoryList(%2)", (Object)"[FSCViewer]", (Object)sFscHistoryArray);
        if (sFscHistoryArray.length == 0) {
            this.getLogFSC().log(-2137614336, "%1 History of function enabling codes is empty", (Object)"[FSCViewer]");
        }
        this.fscHistoryList = sFscHistoryArray;
        this.updateFSCHistoryList();
    }

    @Override
    public void checkSignature(boolean bl, String string) {
    }

    @Override
    public void checkSingleFsc(int n, int n2) {
    }

    @Override
    public void decryptFile(String string, int n) {
    }

    @Override
    public void encryptFile(String string, int n) {
    }

    @Override
    public void getPublicKey(short[] sArray, boolean bl) {
    }

    @Override
    public void updateAreFSCsSigned(boolean bl, int n) {
    }

    @Override
    public void updateConfigCheck(ConfigInfo configInfo, int n) {
    }

    @Override
    public void updateConfigFinalize(ConfigInfo configInfo, int n) {
    }

    @Override
    public void updateConfigPrepare(String string, int n) {
    }

    @Override
    public void updateIllegalFSCs(int[] nArray, int n) {
    }

    @Override
    public void updateLimitedLifetime(boolean bl, int n) {
    }

    @Override
    public void updateSoftwareEnabling(int[] nArray, int n) {
    }

    @Override
    public void importFSCs(int n, SFscImportStatus sFscImportStatus) {
        this.getLogFSC().log(1078071040, "%1 importFSs(resultCode=%3, fscImportStatus=%2)", (Object)"[FSCViewer]", (Object)sFscImportStatus, (long)n);
        if (n == 0) {
            if (sFscImportStatus == null) {
                this.getLogFSC().log(10000, "%1 The state of imported function enabling code is undefined", (Object)"[FSCViewer]");
            } else {
                this.writeResultMessage(this.getTextFactory().getTextComstantFSCImportFeatureSuccessfull());
                SFscImportStatus[] sFscImportStatusArray = new SFscImportStatus[]{sFscImportStatus};
                this.updateFSCImportList(sFscImportStatusArray);
            }
            this.getImExStateChoice().setValue(0);
            this.getImExStateChoice().setStatus(1);
        } else {
            this.writeResultMessage(this.getTextFactory().getTextComstantFSCImportFeatureFailed());
        }
        this.fscService.notifyImportFSCDone(this.lastImportMedium);
    }

    @Override
    public void getHistory(SFscHistory sFscHistory) {
    }

    static {
        imExMediaHigh = new int[]{3, 4, 5};
        imExMediaStd = new int[]{3, 4};
    }
}

