.version 50 0 
.class public super [51] 
.super [53] 
.field private final [54] [55] 

.method public [57] : [58] 
    .attribute [56] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [9] 
L6:     aload_3 
L7:     iconst_m1 
L8:     aload_0 
L9:     invokeinterface [11] 0 
L14:    aload_0 
L15:    new [12] 
L18:    dup 
L19:    aload_0 
L20:    aload_1 
L21:    aconst_null 
L22:    invokespecial [10] 
L25:    putfield [13] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [56] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [8] 
L4:     checkcast [3] 
L7:     astore_1 
L8:     aconst_null 
L9:     aload_1 
L10:    if_acmpeq L17 
L13:    aload_1 
L14:    goto L21 
L17:    aload_0 
L18:    getfield [7] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Class [18] 
.const [7] = Field [19] [20] 
.const [8] = Method [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = InterfaceMethod [27] [28] 
.const [12] = Class [29] 
.const [13] = Field [30] [31] 
.const [14] = Utf8 de/audi/app/media/transfer/queue/TransferQueue$NullTransferJob 
.const [15] = Utf8 de/audi/app/media/transfer/queue/AbstractJobTransfer 
.const [16] = Utf8 de/audi/app/media/transfer/queue/TransferQueue 
.const [17] = Utf8 de/audi/app/media/queue/Queue 
.const [18] = Utf8 de/audi/app/media/diagnosis/IDiagnosisManager 
.const [19] = Class [32] 
.const [20] = NameAndType [33] [34] 
.const [21] = Class [35] 
.const [22] = NameAndType [36] [37] 
.const [23] = Class [38] 
.const [24] = NameAndType [39] [40] 
.const [25] = Class [41] 
.const [26] = NameAndType [42] [43] 
.const [27] = Class [44] 
.const [28] = NameAndType [45] [46] 
.const [29] = Utf8 de/audi/app/media/transfer/queue/TransferQueue$NullTransferJob 
.const [30] = Class [47] 
.const [31] = NameAndType [48] [49] 
.const [32] = Utf8 de/audi/app/media/transfer/queue/TransferQueue 
.const [33] = Utf8 NULL_TRANSFER_JOB 
.const [34] = Utf8 Lde/audi/app/media/transfer/queue/TransferQueue$NullTransferJob; 
.const [35] = Utf8 de/audi/app/media/transfer/queue/TransferQueue 
.const [36] = Utf8 getRunningJob 
.const [37] = Utf8 ()Lde/audi/app/media/queue/IQueueJob; 
.const [38] = Utf8 de/audi/app/media/queue/Queue 
.const [39] = Utf8 <init> 
.const [40] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;)V 
.const [41] = Utf8 de/audi/app/media/transfer/queue/TransferQueue$NullTransferJob 
.const [42] = Utf8 <init> 
.const [43] = Utf8 (Lde/audi/app/media/transfer/queue/TransferQueue;Lde/audi/atip/log/LogChannel;Lde/audi/app/media/transfer/queue/TransferQueue$1;)V 
.const [44] = Utf8 de/audi/app/media/diagnosis/IDiagnosisManager 
.const [45] = Utf8 addDataProvider 
.const [46] = Utf8 (ILde/audi/app/media/diagnosis/IDiagnosisDataProvider;)V 
.const [47] = Utf8 de/audi/app/media/transfer/queue/TransferQueue 
.const [48] = Utf8 NULL_TRANSFER_JOB 
.const [49] = Utf8 Lde/audi/app/media/transfer/queue/TransferQueue$NullTransferJob; 
.const [50] = Utf8 de/audi/app/media/transfer/queue/TransferQueue 
.const [51] = Class [50] 
.const [52] = Utf8 de/audi/app/media/queue/Queue 
.const [53] = Class [52] 
.const [54] = Utf8 NULL_TRANSFER_JOB 
.const [55] = Utf8 Lde/audi/app/media/transfer/queue/TransferQueue$NullTransferJob; 
.const [56] = Utf8 Code 
.const [57] = Utf8 <init> 
.const [58] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/media/diagnosis/IDiagnosisManager;)V 
.const [59] = Utf8 getRunningTransferJob 
.const [60] = Utf8 ()Lde/audi/app/media/transfer/queue/AbstractJobTransfer; 
.end class 
