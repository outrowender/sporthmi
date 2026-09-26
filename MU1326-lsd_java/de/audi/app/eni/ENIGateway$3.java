/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;
import de.audi.atip.interapp.bap.eni.data.User;

class ENIGateway$3
implements Runnable {
    private final /* synthetic */ User[] val$users;
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$3(ENIGateway eNIGateway, User[] userArray) {
        this.this$0 = eNIGateway;
        this.val$users = userArray;
    }

    @Override
    public void run() {
        ENIGateway.access$000(this.this$0).log(1078071040, "ENIGateway#onUserList: received %1 users", this.val$users == null ? -1L : (long)this.val$users.length);
        if (ENIGateway.access$200(this.this$0) != null) {
            ENIGateway.access$200(this.this$0).onUserList(this.val$users);
        }
    }
}

