/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.ecall.BAPArrayElementListECall;
import de.audi.app.bap.ecall.DataEcall$1;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber$Builder;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_Data;

public final class DataEcall {
    private static final int INITIAL_AUDIO_SOURCE;
    private final BAPArrayElementListECall allowedEmergencyNumbers;
    private volatile int currentAudioSource = 5;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$data$EmergencyNumber;

    public DataEcall(LogChannel logChannel) {
        this.allowedEmergencyNumbers = new BAPArrayElementListECall(logChannel);
    }

    public void setCurrentAudioSource(int n) {
        this.currentAudioSource = n;
    }

    public int getCurrentAudioSource() {
        return this.currentAudioSource;
    }

    public BAPArrayElementListECall getAllowedEmergencyNumbers() {
        return this.allowedEmergencyNumbers;
    }

    public EmergencyNumber[] emergencyNumbers() {
        return (EmergencyNumber[])this.allowedEmergencyNumbers.toArray(class$de$audi$atip$interapp$bap$ecall$data$EmergencyNumber == null ? (class$de$audi$atip$interapp$bap$ecall$data$EmergencyNumber = DataEcall.class$("de.audi.atip.interapp.bap.ecall.data.EmergencyNumber")) : class$de$audi$atip$interapp$bap$ecall$data$EmergencyNumber, new DataEcall$1(this));
    }

    private static EmergencyNumber convertFromAllowedEmergencyNumbersData(AllowedEmergencyNumbers_Data allowedEmergencyNumbers_Data) {
        EmergencyNumber$Builder emergencyNumber$Builder = EmergencyNumber.builder();
        emergencyNumber$Builder.setId(allowedEmergencyNumbers_Data.id.toString());
        emergencyNumber$Builder.setTelNumber(allowedEmergencyNumbers_Data.telNumber.toString());
        return emergencyNumber$Builder.build();
    }

    public void clear() {
        this.currentAudioSource = 5;
        this.allowedEmergencyNumbers.clear();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ EmergencyNumber access$000(AllowedEmergencyNumbers_Data allowedEmergencyNumbers_Data) {
        return DataEcall.convertFromAllowedEmergencyNumbersData(allowedEmergencyNumbers_Data);
    }
}

