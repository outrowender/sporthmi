/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;

public class SystemGraphemicGroupRecognizedCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;
    private final SpeechRecognitionHandler srHandler;

    public SystemGraphemicGroupRecognizedCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, SpeechRecognitionHandler speechRecognitionHandler) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.srHandler = speechRecognitionHandler;
    }

    @Override
    public void execute() {
        int n;
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        byte by = this.nBestStorage.getRecogResultGraphGroupType();
        this.logger.log(-2137614336, "%1#execute: graphGroupType=%2!", (Object)this.getName(), (long)by);
        switch (by) {
            case 0: {
                n = 5001;
                this.logger.log(-2137614336, "%1#execute: No GG recognized!", (Object)this.getName());
                break;
            }
            case 1: {
                n = 5000;
                this.nBestStorage.addGGRefinementToNBestListHistory();
                break;
            }
            case 2: {
                int n2 = this.nBestStorage.getSpellingGraphGroupID();
                this.logger.log(-2137614336, "%1#execute: Spelling GG recognized, requesting entries for graphGroupID %2!", (Object)this.getName(), (long)n2);
                this.srHandler.reqGGAsNBest(n2);
                return;
            }
            default: {
                n = 3001;
                this.logger.log(-1601830656, "%1#execute: Unhandled graphGroupType %2, sending ERROR!", (Object)this.getName(), (long)by);
            }
        }
        this.sendResult(n);
    }

    public void responseRequestGGAsNBestList(int n, NBestList nBestList) {
        if (n != 0 || SDSUtils.isEmpty(nBestList)) {
            this.logger.log(-1601830656, "%1#responseRequestGGAsNBestList: replyCode %2 or N-Best list empty, sending ERROR!", (Object)this.getName(), (long)n);
            this.sendResult(3001);
            return;
        }
        NBestListEntry[] nBestListEntryArray = nBestList.getEntries();
        this.logger.log(-2137614336, "%1#responseRequestGGAsNBestList: replyCode=%2 and N-Best result length=%3!", (Object)this.getName(), (long)n, (long)nBestListEntryArray.length);
        this.nBestStorage.addGGSpellingRefinementToNBestListHistory(nBestListEntryArray);
        SDSUtils.handleDisambiguationLabels(nBestListEntryArray);
        this.sendResult(5000);
    }
}

