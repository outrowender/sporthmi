/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.util;

import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import java.util.List;
import org.dsi.ifc.online.PortalADBEntry;

public class OnlineDestinationResultSearchUtility {
    private LogChannel logger;
    private ListModelApp resultList;
    private ChoiceModelApp stateModel;

    public OnlineDestinationResultSearchUtility(LogChannel logChannel, ListModelApp listModelApp, ChoiceModelApp choiceModelApp) {
        this.logger = logChannel;
        this.resultList = listModelApp;
        this.stateModel = choiceModelApp;
        logChannel.log(1078071040, "OnlineDestinationResultSearchUtility#OnlineDestinationResultSearchUtility()");
    }

    public void handleResultSearch(String string, List list) {
        this.logger.log(-2137614336, "OnlineDestinationResultSearchUtility#handleResultSearch() searchString %1", (Object)string);
        if (string != null) {
            string = string.trim();
            this.stateModel.setValue(0);
            this.resultList.beginTransaction();
            this.resultList.clear();
            int n = string.length();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                PortalADBEntry portalADBEntry = (PortalADBEntry)list.get(i2);
                String string2 = portalADBEntry.generalDescription;
                if (n > 0) {
                    int[] nArray = this.matches(string2, string);
                    if (string2 == null || nArray.length <= 1) continue;
                    this.resultList.addRow(new ListCell[]{new IconCell(0), new TextListCell(string2), new LongListCell(portalADBEntry.entryID), new TextListCell("")});
                    continue;
                }
                this.resultList.addRow(new ListCell[]{new IconCell(0), new TextListCell(string2), new LongListCell(portalADBEntry.entryID), new TextListCell("")});
            }
            this.resultList.endTransaction();
            this.stateModel.setValue(1);
        }
    }

    private int[] matches(String string, String string2) {
        int[] nArray;
        String string3;
        if (string == null) {
            return new int[0];
        }
        if (string2 == null) {
            return new int[0];
        }
        String string4 = string.toLowerCase();
        int n = string4.indexOf(string3 = string2.toLowerCase());
        if (n == -1) {
            nArray = new int[]{};
        } else {
            int[] nArray2 = new int[2];
            nArray2[0] = n;
            nArray = nArray2;
            nArray2[1] = n + string2.length();
        }
        return nArray;
    }
}

