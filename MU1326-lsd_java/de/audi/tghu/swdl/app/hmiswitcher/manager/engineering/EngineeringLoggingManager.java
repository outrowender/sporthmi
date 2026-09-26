/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.engineering;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerLogging;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractLoggingManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringDeviceInfoManager;
import de.audi.tghu.swdl.app.list.SwdlListHandlerHistory;
import de.audi.tghu.swdl.app.list.SwdlListHandlerUnusualEvent;
import de.audi.tghu.swdl.app.list.SwdlListItemHistory;
import de.audi.tghu.swdl.app.list.SwdlListItemUnusualEvent;

public class EngineeringLoggingManager
extends AbstractLoggingManager
implements ButtonListener,
ListListener {
    SwdlListHandlerHistory swdlHistoryList;
    SwdlListHandlerUnusualEvent swdlUnusualEventList;
    SwdlListItemHistory currentHistory;
    SwdlListItemUnusualEvent currentUnusualEvent;
    private final AbstractEngineeringDeviceInfoManager engineeringDeviceInfoManager;
    private final SwdlDSIHandlerLogging loggingDSIHandler;

    public EngineeringLoggingManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, AbstractEngineeringDeviceInfoManager abstractEngineeringDeviceInfoManager, SwdlDSIHandlerLogging swdlDSIHandlerLogging) {
        super(swdlEnv, abstractPopupManager);
        this.loggingDSIHandler = swdlDSIHandlerLogging;
        this.engineeringDeviceInfoManager = abstractEngineeringDeviceInfoManager;
        this.swdlHistoryList = new SwdlListHandlerHistory(this.getSwdlEnv(), this, this.getSwdlModels().getHistoryList());
        this.swdlUnusualEventList = new SwdlListHandlerUnusualEvent(this.getSwdlEnv(), this, this.getSwdlModels().getUnusualEventList());
        this.getSwdlModels().getDeviceSelectionButton().setButtonListener(this);
        this.getSwdlModels().getDeviceSummaryButton().setButtonListener(this);
        this.getSwdlModels().getGeneralInfoButton().setButtonListener(this);
        this.getSwdlModels().getUnusualEventsButton().setButtonListener(this);
        this.getSwdlModels().getSubUpdatesList().setListListener(this);
        this.getSwdlModels().getLogSequentialStepCountChoice().forceUpdate(true);
    }

    private final SwdlDSIHandlerLogging getLoggingDSIHandler() {
        return this.loggingDSIHandler;
    }

    private final AbstractEngineeringDeviceInfoManager getEngineeringDeviceInfoManager() {
        return this.engineeringDeviceInfoManager;
    }

    @Override
    public void doGetHistory() {
        this.getLogHMI().log(1078071040, "SwdlLogging.doGetHistory()");
        this.getLoggingDSIHandler().doGetHistory();
    }

    @Override
    public void updateHistory(String[] stringArray, int[] nArray) {
        this.getLogHMI().log(1078071040, "SwdlLogging.updateHistory(%1, %2)", (Object)stringArray, (Object)nArray);
        this.swdlHistoryList.updateList(stringArray, nArray);
    }

    @Override
    public void setUpdate(int n) {
        this.getLogHMI().log(1078071040, "SwdlLogging.setUpdate(%1)", (long)n);
        this.currentHistory.setSubUpdates(n);
        if (n == 0) {
            this.getLoggingDSIHandler().doGetGeneralInformation();
        } else {
            this.getSwdlModels().getSubUpdatesList().clear();
            this.getSwdlModels().getSubUpdatesList().setMaxColumns(2);
            this.getSwdlModels().getSubUpdatesList().setMaxRows(n);
            for (int i2 = 0; i2 < n; ++i2) {
                ListCell[] listCellArray = new ListCell[]{new TextListCell(new StringBuffer().append("Step ").append(Integer.toString(i2 + 1)).toString()), new IntegerListCell(i2, 99)};
                this.getSwdlModels().getSubUpdatesList().addRow(listCellArray);
            }
        }
        this.getSwdlModels().getLogSequentialStepCountChoice().setValue(n);
    }

    @Override
    public void updateGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, int n, int[] nArray, boolean bl3, int n2) {
        this.getLogHMI().log(1078071040, "SwdlLogging.updateGeneralInformation(%1, %2)", (Object)string3, (Object)string);
        String string4 = this.getTextFactory().getUpdateGeneralInformationText(bl, string, string2, bl2, string3, n, nArray, bl3, n2);
        this.getSwdlModels().getHistoryGeneralInfoLabel().setText(string4);
        this.getSwdlModels().getHistorySignatureLabel().setText(this.getTextFactory().getUpdateSignatureText(nArray));
    }

    @Override
    public void doGetUnusualEvents() {
        this.getLoggingDSIHandler().doGetUnusualEvents();
    }

    @Override
    public void updateUnusualEvents(String[] stringArray, String[] stringArray2) {
        this.getLogHMI().log(1078071040, "SwdlLogging.updateUnusualEvents(%1, %2)", (Object)stringArray, (Object)stringArray2);
        this.swdlUnusualEventList.updateList(stringArray2, stringArray);
    }

    @Override
    public void doGetUnusualEvent(int n) {
        this.getLoggingDSIHandler().doGetUnusualEvent(n);
    }

    @Override
    public void updateUnusualEvent(String string, int n, String string2, String string3, String string4, byte by, int n2) {
        this.getLogHMI().log(1078071040, "SwdlLogging.getUnusualEvent(%3, %1, %2)", (Object)string3, (Object)string4, (long)n);
        this.getSwdlModels().getHistoryUnusualEventLabel().setText(string);
    }

    @Override
    public void selectHistory(int n) {
        this.getSwdlModels().getSubUpdatesList().clear();
        this.currentHistory = (SwdlListItemHistory)this.swdlHistoryList.getEntry(n);
        this.getSwdlModels().getLogReleaseNameLabel().setText(this.currentHistory.getName());
        this.swdlUnusualEventList.setBase(this.currentHistory);
        this.getLoggingDSIHandler().doSetUpdate(new StringBuffer().append(this.currentHistory.getDate()).append(" ").append(this.currentHistory.getName()).toString());
    }

    @Override
    public void selectUnusualEvent(int n) {
        this.currentUnusualEvent = (SwdlListItemUnusualEvent)this.swdlUnusualEventList.getEntry(n);
        this.getLoggingDSIHandler().doGetUnusualEvent(this.currentUnusualEvent.getId());
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.getLogHMI().log(14808325, "ignore keyPressed(%1) Event!", (long)n);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.getLogHMI().log(14808325, "ignore keyReleased(%1) Event!", (long)n);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.getLogHMI().log(1078071040, "Key Typed: %1", (long)n);
        switch (n) {
            case 1700083: {
                this.getEngineeringDeviceInfoManager().doGetDevices(3, null, true);
                this.getSwdlModels().getDeviceSelectionButton().fireEvent(n3);
                break;
            }
            case 1700084: {
                this.getEngineeringDeviceInfoManager().doGetDevices(4, null, true);
                this.getSwdlModels().getDeviceSummaryButton().fireEvent(n3);
                break;
            }
            case 1700085: {
                this.getLoggingDSIHandler().doGetGeneralInformation();
                this.getSwdlModels().getGeneralInfoButton().fireEvent(n3);
                break;
            }
            case 1700090: {
                this.doGetUnusualEvents();
                this.getSwdlModels().getUnusualEventsButton().fireEvent(n3);
                break;
            }
            default: {
                this.getLogHMI().log(-2137614336, "ignore keyTyped( %1 ) Event!", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.getSwdlModels().getSubUpdatesList().getID()) {
            this.getLoggingDSIHandler().doSelectSubUpdate(n2);
            this.getLoggingDSIHandler().doGetGeneralInformation();
            this.getSwdlModels().getSubUpdatesList().fireEvent(n4);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

