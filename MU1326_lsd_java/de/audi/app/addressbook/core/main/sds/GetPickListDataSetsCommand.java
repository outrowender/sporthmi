/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.sds;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.sds.ADBSDSHandler;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import org.dsi.ifc.organizer.DataSet;

public class GetPickListDataSetsCommand
extends AbstractADBCommand {
    private AbstractAddressBookApplication appAdr;
    private long[] sdsEntryIDs;
    private String[] sdsNames;
    private int[] sdsGraphemGroupCounters;
    private ADBSDSHandler sdsHandler;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$sds$GetPickListDataSetsCommand;

    public GetPickListDataSetsCommand(AbstractAddressBookApplication abstractAddressBookApplication, long[] lArray, String[] stringArray, int[] nArray, ADBSDSHandler aDBSDSHandler) {
        super(abstractAddressBookApplication);
        this.appAdr = abstractAddressBookApplication;
        this.sdsEntryIDs = lArray;
        this.sdsNames = stringArray;
        this.sdsGraphemGroupCounters = nArray;
        this.sdsHandler = aDBSDSHandler;
    }

    public void execute() {
        this.logger.log(10000000, "GetPickListDataSetsCommand#execute()");
        long[] lArray = GetPickListDataSetsCommand.stripInvalidEntryIDs(this.sdsEntryIDs);
        if (lArray.length == 0) {
            this.fillPickListModel(new DataSet[0]);
            this.sdsHandler.fillAdbPickListResult(0);
            this.commandList.commandFinished();
        } else {
            boolean bl = this.adbDSIAccess.getEntryDataSets(lArray, 0, 0);
            if (!bl) {
                this.logger.log(10000, "GetPickListDataSetsCommand#execute(): dsi call was not successful, finishing command.");
                this.commandList.commandFinished();
                this.sdsHandler.fillAdbPickListResult(1);
            }
        }
    }

    public static long[] stripInvalidEntryIDs(long[] lArray) {
        ArrayList arrayList = new ArrayList(lArray.length);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            if (lArray[i2] == 0L) continue;
            arrayList.add(new Long(lArray[i2]));
        }
        long[] lArray2 = new long[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); ++i3) {
            lArray2[i3] = (Long)arrayList.get(i3);
        }
        return lArray2;
    }

    public void getEntryDataSetsResult(int n, DataSet[] dataSetArray) {
        if (this.logger.isDebug()) {
            this.logger.log(10000000, "GetPickListDataSetsCommand#getEntryDataSetsResult(): entryDataSetList: %1, success: %2", (Object)ADBDbgUtils.dbg(dataSetArray), (Object)ADBDbgUtils.dbgSuccessFlag(n));
        }
        if (n == 0 && dataSetArray != null && dataSetArray.length > 0) {
            this.fillPickListModel(dataSetArray);
            this.sdsHandler.fillAdbPickListResult(0);
        } else {
            this.sdsHandler.fillAdbPickListResult(1);
        }
        this.commandList.commandFinished();
    }

    private void fillPickListModel(DataSet[] dataSetArray) {
        BaseListModelApp baseListModelApp = this.appAdr.getHMIService().getBaseListModel(3867);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        block0: for (int i2 = 0; i2 < this.sdsEntryIDs.length; ++i2) {
            EvoListRow evoListRow;
            if (this.sdsEntryIDs[i2] == 0L) {
                String string = new Buffer("(").append(this.sdsGraphemGroupCounters[i2]).append(")").toString();
                evoListRow = new EvoListRow(i2, 5);
                evoListRow.setInteger(0, 0);
                evoListRow.setText(1, this.sdsNames[i2]);
                evoListRow.setLong(2, -1L);
                evoListRow.setInteger(3, 1);
                evoListRow.setText(4, string);
                baseListModelApp2.append(evoListRow);
                continue;
            }
            for (int i3 = 0; i3 < dataSetArray.length; ++i3) {
                if (this.sdsEntryIDs[i2] != dataSetArray[i3].entryId) continue;
                evoListRow = new EvoListRow(i2, 5);
                evoListRow.setInteger(0, ADBModelUtils.getEntryTypeModelValue(dataSetArray[i3].getEntryType()));
                evoListRow.setText(1, dataSetArray[i3].getGeneralDescription1());
                evoListRow.setLong(2, dataSetArray[i3].getEntryId());
                evoListRow.setInteger(3, 0);
                evoListRow.setText(4, "");
                baseListModelApp2.append(evoListRow);
                continue block0;
            }
            this.logger.log(10000, "GetPickListDataSetsCommand#fillPickListModel(): entryID %1 could not be found in entryDataSetList!", this.sdsEntryIDs[i2]);
        }
        baseListModelApp.update(baseListModelApp2);
    }

    public static void createGetPickListDataSetsCommand(AbstractAddressBookApplication abstractAddressBookApplication, long[] lArray, String[] stringArray, int[] nArray, ADBSDSHandler aDBSDSHandler) {
        GetPickListDataSetsCommand getPickListDataSetsCommand = new GetPickListDataSetsCommand(abstractAddressBookApplication, lArray, stringArray, nArray, aDBSDSHandler);
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(getPickListDataSetsCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$sds$GetPickListDataSetsCommand == null ? (class$de$audi$app$addressbook$core$main$sds$GetPickListDataSetsCommand = GetPickListDataSetsCommand.class$("de.audi.app.addressbook.core.main.sds.GetPickListDataSetsCommand")) : class$de$audi$app$addressbook$core$main$sds$GetPickListDataSetsCommand).getName());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

