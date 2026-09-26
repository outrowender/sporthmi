/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.combi.bap.app.audio.list.SourceListHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.audiosd.serializer.SourceList_ChangedArray;
import de.vw.mib.bap.generated.audiosd.serializer.SourceList_Data;
import de.vw.mib.bap.generated.audiosd.serializer.SourceList_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class SourceListAdapterBAP
extends AbstractListAdapterBAP {
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPAudioSource;

    public SourceListAdapterBAP(AbstractCombiModule abstractCombiModule, SourceListHandler sourceListHandler) {
        super(abstractCombiModule, 32, sourceListHandler);
    }

    public void sendEmptyList() {
    }

    @Override
    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[1] || blArray[0];
        boolean bl2 = blArray[1] || blArray[0];
        boolean bl3 = blArray[4] || blArray[1] || blArray[0];
        boolean bl4 = blArray[2] || blArray[0];
        boolean bl5 = blArray[3] || blArray[1] || blArray[0];
        return CombiBAPAudioSource.getRecordAddress(false, bl, bl2, bl3, bl4, bl5);
    }

    @Override
    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        SourceList_Data sourceList_Data = new SourceList_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPAudioSource) {
            CombiBAPAudioSource combiBAPAudioSource = (CombiBAPAudioSource)combiBAPArrayElement;
            sourceList_Data.setPos(combiBAPAudioSource.getPosID());
            sourceList_Data.sourceType = combiBAPAudioSource.getSourceType();
            sourceList_Data.instance_Id = combiBAPAudioSource.getInstanceId();
            sourceList_Data.mediaType = combiBAPAudioSource.getMediaType();
            sourceList_Data.name.setContent(combiBAPAudioSource.getName());
            sourceList_Data.attributes.builtInAndReady = !combiBAPAudioSource.getAttributes().isBuiltInButNotReady();
            sourceList_Data.attributes.mediumAudioNoError = !combiBAPAudioSource.getAttributes().isMediaAudioSourceError();
            sourceList_Data.attributes.mediumIsNotBeingLoaded = !combiBAPAudioSource.getAttributes().isMediaIsBeingLoaded();
            sourceList_Data.attributes.mediaIsPlayable = !combiBAPAudioSource.getAttributes().isMediaIsNotPlayable();
            sourceList_Data.attributes.mediumIsReadable = !combiBAPAudioSource.getAttributes().isMediaIsNotReadable();
            sourceList_Data.attributes.noImportRunning = !combiBAPAudioSource.getAttributes().isImportRunning();
            sourceList_Data.attributes.mediumSupportBrowserList = !combiBAPAudioSource.getAttributes().isMediumDoesNotSupportBrowserList();
        } else {
            this.logChannel.log(10000, "[SourceListAdapterBAP#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPAudioSource == null ? (class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPAudioSource = SourceListAdapterBAP.class$("de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource")) : class$de$audi$atip$interapp$combi$bap$audio$data$CombiBAPAudioSource).getName(), (Object)super.getClass().getName());
        }
        return sourceList_Data;
    }

    @Override
    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        SourceList_Data sourceList_Data = new SourceList_Data(arrayHeader);
        sourceList_Data.setPos(n);
        return sourceList_Data;
    }

    @Override
    protected ChangedArray createChangedArraySerializer() {
        return new SourceList_ChangedArray();
    }

    @Override
    protected StatusArray createStatusArraySerializer() {
        return new SourceList_StatusArray();
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

