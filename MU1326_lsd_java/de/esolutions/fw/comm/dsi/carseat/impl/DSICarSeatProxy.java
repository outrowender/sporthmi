/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carseat.DSICarSeat;
import de.esolutions.fw.comm.dsi.carseat.DSICarSeatC;
import de.esolutions.fw.comm.dsi.carseat.DSICarSeatReply;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatReplyService;
import de.esolutions.fw.comm.dsi.carseat.impl.MassageDataSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatAdjustmentSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatContentSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatPneumaticContentSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SeatSpecialPositionSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SwitcherDataBackForwardSerializer;
import de.esolutions.fw.comm.dsi.carseat.impl.SwitcherDataUpDownSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public class DSICarSeatProxy
implements DSICarSeat,
DSICarSeatC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carseat.DSICarSeat");
    private Proxy proxy;

    public DSICarSeatProxy(int n, DSICarSeatReply dSICarSeatReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("976ded31-4347-5c8a-b0f7-4d6039c98f40", n, "6624341b-1b4d-57c4-90da-cc721454ffbb", "dsi.carseat.DSICarSeat");
        DSICarSeatReplyService dSICarSeatReplyService = new DSICarSeatReplyService(dSICarSeatReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarSeatReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setSeatRadioKeyAutomatic(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void setSeatCodriverSettingsFromRear(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void setSeatCodriverSettingsFromDriver(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void setSeatEasyEntryFrontLeft(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    public void setSeatEasyEntryFrontRight(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void setSeatEasyEntryRearLeft(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void setSeatEasyEntryRearRight(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    public void setSeatSpecialPosition(final SeatSpecialPosition seatSpecialPosition) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SeatSpecialPositionSerializer.putOptionalSeatSpecialPosition(iSerializer, seatSpecialPosition);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void setSeatSpecialPositionRearCoDriver(final SeatSpecialPosition seatSpecialPosition) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SeatSpecialPositionSerializer.putOptionalSeatSpecialPosition(iSerializer, seatSpecialPosition);
            }
        };
        this.proxy.remoteCallMethod((short)79, iSerializable);
    }

    public void showSeatPopup(final SeatContent seatContent) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SeatContentSerializer.putOptionalSeatContent(iSerializer, seatContent);
            }
        };
        this.proxy.remoteCallMethod((short)85, iSerializable);
    }

    public void cancelSeatPopup(final SeatContent seatContent, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SeatContentSerializer.putOptionalSeatContent(iSerializer, seatContent);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)72, iSerializable);
    }

    public void setSeatHMIIsReady(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void setSeatPneumaticCodriverSettingsFromDriver(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)49, genericSerializable);
    }

    public void showSeatPneumaticPopup(final SeatPneumaticContent seatPneumaticContent) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SeatPneumaticContentSerializer.putOptionalSeatPneumaticContent(iSerializer, seatPneumaticContent);
            }
        };
        this.proxy.remoteCallMethod((short)52, iSerializable);
    }

    public void cancelSeatPneumaticPopup(final SeatPneumaticContent seatPneumaticContent, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SeatPneumaticContentSerializer.putOptionalSeatPneumaticContent(iSerializer, seatPneumaticContent);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)47, iSerializable);
    }

    public void setSeatSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)51, null);
    }

    public void setSeatPneumaticSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)50, null);
    }

    public void startSeatMoveRearSeatDisplay() throws MethodException {
        this.proxy.remoteCallMethod((short)87, null);
    }

    public void abortSeatMoveRearSeatDisplay() throws MethodException {
        this.proxy.remoteCallMethod((short)68, null);
    }

    public void setSeatMassageData(final int n, final MassageData massageData) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                MassageDataSerializer.putOptionalMassageData(iSerializer, massageData);
            }
        };
        this.proxy.remoteCallMethod((short)128, iSerializable);
    }

    public void setSeatSwitcherDataUp(final int n, final SwitcherDataUpDown switcherDataUpDown) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                SwitcherDataUpDownSerializer.putOptionalSwitcherDataUpDown(iSerializer, switcherDataUpDown);
            }
        };
        this.proxy.remoteCallMethod((short)133, iSerializable);
    }

    public void setSeatSwitcherDataDown(final int n, final SwitcherDataUpDown switcherDataUpDown) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                SwitcherDataUpDownSerializer.putOptionalSwitcherDataUpDown(iSerializer, switcherDataUpDown);
            }
        };
        this.proxy.remoteCallMethod((short)132, iSerializable);
    }

    public void setSeatSwitcherDataForward(final int n, final SwitcherDataBackForward switcherDataBackForward) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                SwitcherDataBackForwardSerializer.putOptionalSwitcherDataBackForward(iSerializer, switcherDataBackForward);
            }
        };
        this.proxy.remoteCallMethod((short)83, iSerializable);
    }

    public void setSeatSwitcherDataBack(final int n, final SwitcherDataBackForward switcherDataBackForward) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                SwitcherDataBackForwardSerializer.putOptionalSwitcherDataBackForward(iSerializer, switcherDataBackForward);
            }
        };
        this.proxy.remoteCallMethod((short)81, iSerializable);
    }

    public void setSeatAdjustment(final int n, final SeatAdjustment seatAdjustment) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                SeatAdjustmentSerializer.putOptionalSeatAdjustment(iSerializer, seatAdjustment);
            }
        };
        this.proxy.remoteCallMethod((short)74, iSerializable);
    }

    public void startSeatDeleteSpecialPosition(boolean bl, boolean bl2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)86, genericSerializable);
    }

    public void setSeatCoDriverSettingsFromRearActivation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)75, genericSerializable);
    }

    public void setSeatFoldHeadRestRearDriver(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)77, genericSerializable);
    }

    public void setSeatFoldHeadRestRearCoDriver(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)76, genericSerializable);
    }

    public void setSeatStopButton(int n, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)80, genericSerializable);
    }

    public void setSeatPremiumMassageData(final int n, final MassageData massageData) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                MassageDataSerializer.putOptionalMassageData(iSerializer, massageData);
            }
        };
        this.proxy.remoteCallMethod((short)130, iSerializable);
    }

    public void setSeatPremiumMassageSwitcher(int n, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)131, genericSerializable);
    }

    public void setSeatMassageSwitcher(int n, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)129, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)7, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)3, null);
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
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }
}

