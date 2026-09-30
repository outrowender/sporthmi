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

public class RSESyncCriteria
extends RSENaviCommand {
    private Criteria criteria;

    public RSESyncCriteria() {
        super(1282);
    }

    public RSESyncCriteria(Criteria criteria) {
        this();
        this.criteria = criteria;
    }

    public void decode(DataInputStream dataInputStream) {
        log.log(10000000, "RSESyncCriteria#decode - enter");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
            this.criteria = (Criteria)objectInputStream.readObject();
        }
        catch (IOException iOException) {
            log.log(10000, "RSESyncCriteria#decode", (Throwable)iOException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            log.log(10000, "RSESyncCriteria#decode", (Throwable)classNotFoundException);
        }
        log.log(10000000, "RSESyncCriteria#decode - exit");
    }

    public void encode(DataOutputStream dataOutputStream) {
        log.log(10000000, "RSESyncCriteria#encode - enter");
        try {
            this.encodeHeader(dataOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            objectOutputStream.writeObject(this.criteria);
            objectOutputStream.flush();
        }
        catch (IOException iOException) {
            log.log(10000, "RSESyncCriteria#encode", (Throwable)iOException);
        }
        log.log(10000000, "RSESyncCriteria#encode - exit");
    }

    public void execute(AbstractRSEConnection abstractRSEConnection) {
        log.log(10000000, "RSESyncCriteria#execute()");
    }
}

