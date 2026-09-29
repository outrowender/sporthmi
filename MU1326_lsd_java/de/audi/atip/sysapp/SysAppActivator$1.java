/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.SysAppDiag
 *  de.mib.swdiagnosis.TextEditorModelDiag
 *  de.mib.swdiagnosis.WavePlayerDiag
 */
package de.audi.atip.sysapp;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.sysapp.SysAppActivator;
import de.mib.swdiagnosis.SysAppDiag;
import de.mib.swdiagnosis.TextEditorModelDiag;
import de.mib.swdiagnosis.WavePlayerDiag;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SysAppActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SysAppActivator this$0;

    SysAppActivator$1(SysAppActivator sysAppActivator) {
        this.this$0 = sysAppActivator;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = SysAppActivator.access$000(this.this$0).getService(serviceReference);
        if (object instanceof DSICarTimeUnitsLanguage) {
            int[] nArray = new int[]{19, 20, 2, 3, 21, 7};
            ((DSICarTimeUnitsLanguage)object).setNotification(nArray, (DSIListener)SysAppActivator.access$100(this.this$0).getDSICarTimeUnitsLanguageListener());
            return object;
        }
        if (object instanceof DSIGeneralVehicleStates) {
            int[] nArray = new int[]{7, 22, 8, 9, 10, 11, 12, 13, 14, 6, 15, 17, 18, 19};
            ((DSIGeneralVehicleStates)object).setNotification(nArray, (DSIListener)SysAppActivator.access$100(this.this$0).getGeneralVehicleStateHandler());
            SysAppActivator.access$200(this.this$0).getStartupManager().logStartupEvent("[APS] DSIGeneralVehicleState connected!");
            return object;
        }
        if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new SysAppDiag(SysAppActivator.access$200(this.this$0)));
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new WavePlayerDiag(SysAppActivator.access$200(this.this$0)));
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new TextEditorModelDiag(SysAppActivator.access$200(this.this$0)));
            return object;
        }
        if (object instanceof SDSService) {
            SysAppActivator.access$100(this.this$0).getGeneralVehicleStateHandler().setSDSService((SDSService)object);
            return object;
        }
        if (!(object instanceof HMIAudioService)) {
            SysAppActivator.access$400(this.this$0).ungetService(serviceReference);
            return null;
        }
        Object object2 = serviceReference.getProperty("AUDIO_CLIENT_ID");
        if (HMIAudioService.CLIENT_CAR.equals(object2)) {
            SysAppActivator.access$100(this.this$0).getGeneralVehicleStateHandler().registerAudioService((HMIAudioService)object);
            return object;
        }
        SysAppActivator.access$300(this.this$0).ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        SysAppActivator.access$500(this.this$0).ungetService(serviceReference);
        if (object.equals(SysAppActivator.access$600(this.this$0))) {
            SysAppActivator.access$602(this.this$0, null);
            SysAppActivator.access$700(this.this$0).log(-1601830656, "restart DSICarTimeUnitsLanguage");
            SysAppActivator.access$800(this.this$0).startDSIService((SysAppActivator.class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (SysAppActivator.class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = SysAppActivator.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : SysAppActivator.class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName(), 0);
        } else if (object.equals(SysAppActivator.access$900(this.this$0))) {
            SysAppActivator.access$902(this.this$0, null);
            SysAppActivator.access$700(this.this$0).log(-1601830656, "restart DSIGeneralVehicleStates");
            SysAppActivator.access$1000(this.this$0).startDSIService((SysAppActivator.class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (SysAppActivator.class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = SysAppActivator.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : SysAppActivator.class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), 0);
        } else if (object instanceof SDSService) {
            SysAppActivator.access$700(this.this$0).log(-1601830656, "unregister SDSService");
            SysAppActivator.access$100(this.this$0).getGeneralVehicleStateHandler().setSDSService(null);
        } else if (object instanceof HMIAudioService) {
            SysAppActivator.access$700(this.this$0).log(-1601830656, "unregister HMIAudioService");
            SysAppActivator.access$100(this.this$0).getGeneralVehicleStateHandler().deregisterAudioService();
        }
    }
}

