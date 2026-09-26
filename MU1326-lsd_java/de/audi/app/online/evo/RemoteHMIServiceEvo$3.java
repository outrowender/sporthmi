/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.interapp.OnlineServiceListener$OnlineSpeechDictionary;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ISpeechDictionary;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import java.util.ArrayList;
import java.util.List;

class RemoteHMIServiceEvo$3
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ RemoteHMIServiceEvo this$0;

    RemoteHMIServiceEvo$3(RemoteHMIServiceEvo remoteHMIServiceEvo, String string, LogChannel logChannel) {
        this.this$0 = remoteHMIServiceEvo;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$logChannel.log(1078071040, "RemoteHMIServiceEvo#ctor (AbstractCommandHandler): received dictionaries.");
        if (object instanceof List) {
            String string = null;
            String string2 = null;
            int n2 = 2;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < ((List)object).size(); ++i2) {
                if (((List)object).get(i2) instanceof ISpeechDictionary) {
                    ISpeechDictionary iSpeechDictionary = (ISpeechDictionary)((List)object).get(i2);
                    if (string != null && !string.equals(iSpeechDictionary.getFormat()) || string2 != null && !string2.equals(iSpeechDictionary.getLanguage())) {
                        this.val$logChannel.log(10000, "RemoteHMIHandlerImpl#ctor (AbstractCommandHandler): format or language of available dictionaries do not fit");
                        continue;
                    }
                    string = iSpeechDictionary.getFormat();
                    string2 = iSpeechDictionary.getLanguage();
                    n2 = iSpeechDictionary.getType();
                    arrayList.addAll(iSpeechDictionary.getDictionaryEntries());
                    continue;
                }
                this.val$logChannel.log(1078071040, "RemoteHMIHandlerImpl#ctor (AbstractCommandHandler): payload not of type SpeechDictionary, no registration of Online-Dictionary");
            }
            if (string2 != null && string != null && arrayList != null && !arrayList.isEmpty()) {
                OnlineServiceListener$OnlineSpeechDictionary onlineServiceListener$OnlineSpeechDictionary = new OnlineServiceListener$OnlineSpeechDictionary(n2, string2, string, arrayList);
                this.val$logChannel.log(1078071040, "RemoteHMIHandlerImpl#ctor (AbstractCommandHandler): setting dictionary %1 at onlineServiceListener", (Object)onlineServiceListener$OnlineSpeechDictionary.toString());
                this.this$0.getASR().getOnlineServiceListener().setDictionary(onlineServiceListener$OnlineSpeechDictionary);
            } else {
                this.val$logChannel.log(10000, "RemoteHMIHandlerImpl#ctor (AbstractCommandHandler): dictionary cannot be set due to missing fields");
            }
        }
    }
}

