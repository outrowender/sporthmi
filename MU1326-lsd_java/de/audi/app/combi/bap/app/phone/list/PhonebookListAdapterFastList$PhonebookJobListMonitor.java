/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.arrays.AbstractArrayJobListMonitor;
import de.audi.app.bap.fw.arrays.ArrayJobList;
import de.audi.app.combi.bap.app.phone.list.PhonebookListAdapterFastList;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

class PhonebookListAdapterFastList$PhonebookJobListMonitor
extends AbstractArrayJobListMonitor {
    private final /* synthetic */ PhonebookListAdapterFastList this$0;

    public PhonebookListAdapterFastList$PhonebookJobListMonitor(PhonebookListAdapterFastList phonebookListAdapterFastList, LogChannel logChannel) {
        this.this$0 = phonebookListAdapterFastList;
        super(logChannel);
    }

    @Override
    public void epilogue(CommandList commandList) {
        if (commandList instanceof ArrayJobList) {
            PhonebookListAdapterFastList.access$000(this.this$0).responsePhoneBookJobs(255, 10);
        }
        super.epilogue(commandList);
    }

    @Override
    public void notifyJobFinished(int n) {
        PhonebookListAdapterFastList.access$000(this.this$0).responsePhoneBookJobs(n, 0);
    }

    @Override
    public void notifyJobCancelled(int n) {
        PhonebookListAdapterFastList.access$000(this.this$0).responsePhoneBookJobs(n, 2);
    }
}

