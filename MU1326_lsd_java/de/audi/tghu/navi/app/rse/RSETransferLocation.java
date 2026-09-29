/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rse;

import de.audi.atip.rse.AbstractRSEConnection;
import de.audi.tghu.navi.app.guidance.Criteria;
import de.audi.tghu.navi.app.rse.RSENaviCommand;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RSETransferLocation
extends RSENaviCommand {
    private byte[] locationStream;
    private Criteria criteria;

    public RSETransferLocation() {
        super(1281);
    }

    public RSETransferLocation(byte[] byArray, Criteria criteria) {
        this();
        this.locationStream = byArray;
        this.criteria = criteria;
    }

    @Override
    public void decode(DataInputStream dataInputStream) {
        log.log(-2137614336, "RSETransferLocation#decode - enter");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
            this.locationStream = (byte[])objectInputStream.readObject();
            this.criteria = (Criteria)objectInputStream.readObject();
        }
        catch (IOException iOException) {
            log.log(10000, "RSETransferLocation#decode", (Throwable)iOException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            log.log(10000, "RSETransferLocation#decode", (Throwable)classNotFoundException);
        }
        log.log(-2137614336, "RSETransferLocation#decode - exit");
    }

    @Override
    public void encode(DataOutputStream dataOutputStream) {
        log.log(-2137614336, "RSETransferLocation#encode - enter");
        try {
            this.encodeHeader(dataOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            objectOutputStream.writeObject(this.locationStream);
            objectOutputStream.writeObject(this.criteria);
            objectOutputStream.flush();
        }
        catch (IOException iOException) {
            log.log(10000, "RSETransferLocation#encode", (Throwable)iOException);
        }
        log.log(-2137614336, "RSETransferLocation#encode - exit");
    }

    @Override
    public void execute(AbstractRSEConnection abstractRSEConnection) {
        log.log(-2137614336, "RSETransferLocation#execute()");
    }
}

