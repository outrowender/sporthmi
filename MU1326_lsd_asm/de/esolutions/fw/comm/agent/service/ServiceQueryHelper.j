.version 50 0 
.class public super [65] 
.super [67] 
.implements [69] 
.field private [70] [71] 
.field private [72] [73] 

.method public annotation [75] : [76] 
    .attribute [74] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [74] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aconst_null 
L3:     invokevirtual [6] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [74] .code stack 3 locals 3 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_1 
L7:     aload_2 
L8:     aload_0 
L9:     invokevirtual [7] 
L12:    aload_0 
L13:    dup 
L14:    astore_3 
L15:    monitorenter 
L16:    aload_0 
L17:    getfield [8] 
L20:    ifne L42 
L23:    aload_0 
L24:    getfield [9] 
L27:    ifnonnull L42 
        .catch [2] from L30 to L34 using L37 
        .catch [0] from L16 to L52 using L57 
L30:    aload_0 
L31:    invokespecial [11] 
L34:    goto L16 
L37:    astore 4 
L39:    goto L16 
L42:    aload_0 
L43:    getfield [9] 
L46:    ifnull L53 
L49:    iconst_1 
L50:    aload_3 
L51:    monitorexit 
L52:    areturn 
        .catch [0] from L53 to L56 using L57 
L53:    iconst_0 
L54:    aload_3 
L55:    monitorexit 
L56:    areturn 
        .catch [0] from L57 to L61 using L57 
L57:    astore 5 
L59:    aload_3 
L60:    monitorexit 
L61:    aload 5 
L63:    athrow 
L64:    
    .end code 
.end method 

.method public synchronized [81] : [82] 
    .attribute [74] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [83] : [84] 
    .attribute [74] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [85] : [86] 
    .attribute [74] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     putfield [14] 
L5:     aload_0 
L6:     invokespecial [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [87] : [88] 
    .attribute [74] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_2 
L2:     putfield [13] 
L5:     aload_0 
L6:     invokespecial [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Method [19] [20] 
.const [7] = Method [21] [22] 
.const [8] = Field [23] [24] 
.const [9] = Field [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Field [33] [34] 
.const [14] = Field [35] [36] 
.const [15] = Utf8 java/lang/InterruptedException 
.const [16] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueryHelper 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [19] = Class [37] 
.const [20] = NameAndType [38] [39] 
.const [21] = Class [40] 
.const [22] = NameAndType [41] [42] 
.const [23] = Class [43] 
.const [24] = NameAndType [44] [45] 
.const [25] = Class [46] 
.const [26] = NameAndType [47] [48] 
.const [27] = Class [49] 
.const [28] = NameAndType [50] [51] 
.const [29] = Class [52] 
.const [30] = NameAndType [53] [54] 
.const [31] = Class [55] 
.const [32] = NameAndType [56] [57] 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueryHelper 
.const [38] = Utf8 queryService 
.const [39] = Utf8 (Lde/esolutions/fw/comm/agent/Agent;Lde/esolutions/fw/comm/core/ServiceInstanceID;)Z 
.const [40] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [41] = Utf8 queryService 
.const [42] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/agent/directory/IServiceQueryReply;)V 
.const [43] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueryHelper 
.const [44] = Utf8 errorCode 
.const [45] = Utf8 I 
.const [46] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueryHelper 
.const [47] = Utf8 result 
.const [48] = Utf8 [Lde/esolutions/fw/comm/agent/directory/DirectoryEntry; 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 <init> 
.const [51] = Utf8 ()V 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 wait 
.const [54] = Utf8 ()V 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 notify 
.const [57] = Utf8 ()V 
.const [58] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueryHelper 
.const [59] = Utf8 errorCode 
.const [60] = Utf8 I 
.const [61] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueryHelper 
.const [62] = Utf8 result 
.const [63] = Utf8 [Lde/esolutions/fw/comm/agent/directory/DirectoryEntry; 
.const [64] = Utf8 de/esolutions/fw/comm/agent/service/ServiceQueryHelper 
.const [65] = Class [64] 
.const [66] = Utf8 java/lang/Object 
.const [67] = Class [66] 
.const [68] = Utf8 de/esolutions/fw/comm/agent/directory/IServiceQueryReply 
.const [69] = Class [68] 
.const [70] = Utf8 result 
.const [71] = Utf8 [Lde/esolutions/fw/comm/agent/directory/DirectoryEntry; 
.const [72] = Utf8 errorCode 
.const [73] = Utf8 I 
.const [74] = Utf8 Code 
.const [75] = Utf8 <init> 
.const [76] = Utf8 ()V 
.const [77] = Utf8 queryAllServices 
.const [78] = Utf8 (Lde/esolutions/fw/comm/agent/Agent;)Z 
.const [79] = Utf8 queryService 
.const [80] = Utf8 (Lde/esolutions/fw/comm/agent/Agent;Lde/esolutions/fw/comm/core/ServiceInstanceID;)Z 
.const [81] = Utf8 getErrorCode 
.const [82] = Utf8 ()I 
.const [83] = Utf8 getResult 
.const [84] = Utf8 ()[Lde/esolutions/fw/comm/agent/directory/DirectoryEntry; 
.const [85] = Utf8 serviceQueryResult 
.const [86] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;[Lde/esolutions/fw/comm/agent/directory/DirectoryEntry;)V 
.const [87] = Utf8 serviceQueryFailed 
.const [88] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;I)V 
.end class 
