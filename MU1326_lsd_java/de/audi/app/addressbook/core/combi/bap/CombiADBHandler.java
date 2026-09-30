/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.combi.bap;

import de.audi.app.addressbook.core.combi.bap.CombiADBDSIDefaultListener;
import de.audi.app.addressbook.core.combi.bap.CombiADBStateHandler;
import de.audi.app.addressbook.core.combi.bap.CombiBAPServiceHandler;
import de.audi.app.addressbook.core.combi.bap.commands.GetCombiViewSizeCommand;
import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBStartupHandler;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.AbstractADBHandler;
import de.audi.app.addressbook.core.common.commands.ADBDSIDefaultListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.organizer.IndexInformation;

public class CombiADBHandler
extends AbstractADBHandler {
    private CombiADBStateHandler combiStateHandler = new CombiADBStateHandler(this);
    private CombiBAPServiceHandler combiService = new CombiBAPServiceHandler(this, this.log);
    private IndexInformation alphabeticalIndex;

    public CombiADBHandler(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess, iFrameworkAccess.getLogChannel("App.AddressBook.Combi"), iFrameworkAccess.getLogChannel("App.AddressBook.CombiCmdList"));
    }

    public CombiADBStateHandler getStateHandler() {
        return this.combiStateHandler;
    }

    public CombiBAPServiceHandler getCombiService() {
        return this.combiService;
    }

    public void updateAlphabeticalIndex(IndexInformation[] indexInformationArray) {
        if (indexInformationArray != null) {
            for (int i2 = 0; i2 < indexInformationArray.length; ++i2) {
                if (indexInformationArray[i2] == null || indexInformationArray[i2].getViewtype() != 1) continue;
                this.log.log(1000000, "CombiADBHandler#updateAlphabeticalIndex(): received alphabeticalIndex for view type PHONE.");
                this.alphabeticalIndex = indexInformationArray[i2];
            }
        }
    }

    public int findPosByChar(char c2) {
        if (this.alphabeticalIndex == null) {
            this.log.log(10000, "CombiADBHandler#findPosByChar(): alphabeticalIndex not (yet) available!");
            return -1;
        }
        int n = -1;
        CharacterInfo[] characterInfoArray = this.alphabeticalIndex.getCharacterInfo();
        if (characterInfoArray != null) {
            for (int i2 = 0; i2 < characterInfoArray.length; ++i2) {
                if (characterInfoArray[i2] == null || characterInfoArray[i2].getValue() != c2) continue;
                n = characterInfoArray[i2].getIndex();
                break;
            }
        }
        return n;
    }

    public int getInitStartupCompleteMask() {
        return 229;
    }

    public void handleInvalidData(int n, boolean bl) {
        this.log.log(1000000, "CombiADBHandler#handleInvalidData(): reason: %1", (Object)ADBDbgUtils.dbgInvalidDataReason(n));
        GetCombiViewSizeCommand.createGetCombiViewSizeCommand(this, true, false);
    }

    protected ADBDSIDefaultListener getNewADBDSIDefaultListener(LogChannel logChannel, ADBStartupHandler aDBStartupHandler, ADBApplication aDBApplication) {
        return new CombiADBDSIDefaultListener(logChannel, aDBStartupHandler, this);
    }

    public void setAdbReady(boolean bl) {
        this.combiStateHandler.setAdbReady(bl);
        GetCombiViewSizeCommand.createGetCombiViewSizeCommand(this, true, false);
    }

    public void updateDownloadState(int n, int n2) {
        this.log.log(1000000, "CombiADBHandler#updateDownloadState(): downloadState: %1, failureReason: %2", (Object)ADBDbgUtils.dbgDownloadState(n), (Object)ADBDbgUtils.dbgFailureReason(n2));
        this.combiStateHandler.setDownloadActive(ADBUtils.isDownloadStateActive(n));
        if (n == 0) {
            this.combiStateHandler.resetDownloadProgress();
        }
    }
}

