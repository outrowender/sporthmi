/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carparkingsystem.DSICarParkingSystem;
import de.esolutions.fw.comm.dsi.carparkingsystem.DSICarParkingSystemC;
import de.esolutions.fw.comm.dsi.carparkingsystem.DSICarParkingSystemReply;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemReplyService;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DisplayContentSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPLASystemStateSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPiloPaSystemStateSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCSoundReproductionSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCSoundSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSCameraCleaningSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSDefaultModeSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSDynParkingModeSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSOPSOverlaySerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class DSICarParkingSystemProxy
implements DSICarParkingSystem,
DSICarParkingSystemC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carparkingsystem.DSICarParkingSystem");
    private Proxy proxy;

    public DSICarParkingSystemProxy(int n, DSICarParkingSystemReply dSICarParkingSystemReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("84b9518c-66ec-58f1-8efb-ea1c6a621692", n, "6f0ad754-4b1b-5807-8e51-0f831609c79a", "dsi.carparkingsystem.DSICarParkingSystem");
        DSICarParkingSystemReplyService dSICarParkingSystemReplyService = new DSICarParkingSystemReplyService(dSICarParkingSystemReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarParkingSystemReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setHMIStateIsReady(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void setPDCDefaultParkingMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void setPDCMute(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    public void setPDCFrequenceFront(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void setPDCFrequenceRear(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    public void setPDCVolumeFront(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    public void setPDCVolumeRear(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    public void setPDCAutoActivation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    public void setPDCSystemOnOff(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    public void setPDCFrequenceRight(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    public void setPDCFrequenceLeft(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void setPDCVolumeRight(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    public void setPDCVolumeLeft(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    public void setPDCFlankGuard(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void setPDCSoundReproduction(final PDCSoundReproduction pDCSoundReproduction) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PDCSoundReproductionSerializer.putOptionalPDCSoundReproduction(iSerializer, pDCSoundReproduction);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }

    public void setPDCSoundFront(final PDCSound pDCSound) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PDCSoundSerializer.putOptionalPDCSound(iSerializer, pDCSound);
            }
        };
        this.proxy.remoteCallMethod((short)95, iSerializable);
    }

    public void setPDCSoundRear(final PDCSound pDCSound) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PDCSoundSerializer.putOptionalPDCSound(iSerializer, pDCSound);
            }
        };
        this.proxy.remoteCallMethod((short)97, iSerializable);
    }

    public void setPDCSoundLeft(final PDCSound pDCSound) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PDCSoundSerializer.putOptionalPDCSound(iSerializer, pDCSound);
            }
        };
        this.proxy.remoteCallMethod((short)96, iSerializable);
    }

    public void setPDCSoundRight(final PDCSound pDCSound) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PDCSoundSerializer.putOptionalPDCSound(iSerializer, pDCSound);
            }
        };
        this.proxy.remoteCallMethod((short)98, iSerializable);
    }

    public void setPDCPLAPreSelection(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)93, genericSerializable);
    }

    public void setPDCPLAParkMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)92, genericSerializable);
    }

    public void setPDCPLASystemState(final PDCPLASystemState pDCPLASystemState) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PDCPLASystemStateSerializer.putOptionalPDCPLASystemState(iSerializer, pDCPLASystemState);
            }
        };
        this.proxy.remoteCallMethod((short)94, iSerializable);
    }

    public void setPDCOffroadMode(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)91, genericSerializable);
    }

    public void setPDCVisualisationParkbox(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)99, genericSerializable);
    }

    public void setPDCOPSVisualisationPosition(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)90, genericSerializable);
    }

    public void setVPSFollowUpTime(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    public void setVPSColor(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }

    public void setVPSContrast(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    public void setVPSBrightness(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    public void setVPSDefaultModeRV(final VPSDefaultMode vPSDefaultMode) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                VPSDefaultModeSerializer.putOptionalVPSDefaultMode(iSerializer, vPSDefaultMode);
            }
        };
        this.proxy.remoteCallMethod((short)35, iSerializable);
    }

    public void setVPSDefaultModeFV(final VPSDefaultMode vPSDefaultMode) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                VPSDefaultModeSerializer.putOptionalVPSDefaultMode(iSerializer, vPSDefaultMode);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void setVPSDefaultModeSV(final VPSDefaultMode vPSDefaultMode) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                VPSDefaultModeSerializer.putOptionalVPSDefaultMode(iSerializer, vPSDefaultMode);
            }
        };
        this.proxy.remoteCallMethod((short)36, iSerializable);
    }

    public void setVPSDefaultModeBV(final VPSDefaultMode vPSDefaultMode) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                VPSDefaultModeSerializer.putOptionalVPSDefaultMode(iSerializer, vPSDefaultMode);
            }
        };
        this.proxy.remoteCallMethod((short)33, iSerializable);
    }

    public void setVPSDefaultView(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    public void setVPSOPSOverlay(final VPSOPSOverlay vPSOPSOverlay) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                VPSOPSOverlaySerializer.putOptionalVPSOPSOverlay(iSerializer, vPSOPSOverlay);
            }
        };
        this.proxy.remoteCallMethod((short)40, iSerializable);
    }

    public void setVPSDynamicParkingMode(final VPSDynParkingMode vPSDynParkingMode) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                VPSDynParkingModeSerializer.putOptionalVPSDynParkingMode(iSerializer, vPSDynParkingMode);
            }
        };
        this.proxy.remoteCallMethod((short)38, iSerializable);
    }

    public void setVPSSystemOnOff(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }

    public void setVPSExtCamConfig(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)127, genericSerializable);
    }

    public void setVPSExtCamManActivation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)128, genericSerializable);
    }

    public void setVPS3DBirdview(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)126, genericSerializable);
    }

    public void setVPSSystemState(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)129, genericSerializable);
    }

    public void showParkingPopup(final DisplayContent displayContent) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DisplayContentSerializer.putOptionalDisplayContent(iSerializer, displayContent);
            }
        };
        this.proxy.remoteCallMethod((short)43, iSerializable);
    }

    public void cancelParkingPopup(final DisplayContent displayContent, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DisplayContentSerializer.putOptionalDisplayContent(iSerializer, displayContent);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }

    public void requestLifeMonitoring(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    public void setPdcSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)29, null);
    }

    public void setVpsSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)42, null);
    }

    public void setARATargetTrailerAngle(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)89, genericSerializable);
    }

    public void setPDCManeuverAssistConfig(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)137, genericSerializable);
    }

    public void setPDCManeuverAssist(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)136, genericSerializable);
    }

    public void setPDCContinueDrivingAssist(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)142, genericSerializable);
    }

    public void setPDCIpaConfig(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)143, genericSerializable);
    }

    public void setPDCPiloPaSystemState(final PDCPiloPaSystemState pDCPiloPaSystemState) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PDCPiloPaSystemStateSerializer.putOptionalPDCPiloPaSystemState(iSerializer, pDCPiloPaSystemState);
            }
        };
        this.proxy.remoteCallMethod((short)144, iSerializable);
    }

    public void setVPSCameraCleaning(final VPSCameraCleaning vPSCameraCleaning) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                VPSCameraCleaningSerializer.putOptionalVPSCameraCleaning(iSerializer, vPSCameraCleaning);
            }
        };
        this.proxy.remoteCallMethod((short)145, iSerializable);
    }

    public void setWCAutoActivation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)177, genericSerializable);
    }

    public void setWCSystemOnOff(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)179, genericSerializable);
    }

    public void setWCSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)178, null);
    }

    public void showWCPopup(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)180, genericSerializable);
    }

    public void cancelWCPopup(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)170, genericSerializable);
    }

    public void requestWCPanelList(final CarArrayListUpdateInfo carArrayListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, carArrayListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)174, iSerializable);
    }

    public void enterWCPinPuk(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)173, genericSerializable);
    }

    public void abortWCEnterPinPuk() throws MethodException {
        this.proxy.remoteCallMethod((short)158, null);
    }

    public void startWCScanning() throws MethodException {
        this.proxy.remoteCallMethod((short)182, null);
    }

    public void abortWCScanning() throws MethodException {
        this.proxy.remoteCallMethod((short)160, null);
    }

    public void startWCPairing(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)181, genericSerializable);
    }

    public void abortWCPairing() throws MethodException {
        this.proxy.remoteCallMethod((short)159, null);
    }

    public void startWCSoftwareUpdate(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)183, genericSerializable);
    }

    public void abortWCSoftwareUpdate() throws MethodException {
        this.proxy.remoteCallMethod((short)161, null);
    }

    public void changeWCPin(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)172, genericSerializable);
    }

    public void abortWCChangePin() throws MethodException {
        this.proxy.remoteCallMethod((short)157, null);
    }

    public void changeWCPanelName(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)171, genericSerializable);
    }

    public void abortWCChangePanelName() throws MethodException {
        this.proxy.remoteCallMethod((short)156, null);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)12, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)5, null);
    }

    public void yySet(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)88, genericSerializable);
    }
}

