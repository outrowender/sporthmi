.version 50 0 
.class public super [71] 
.super [73] 
.field private [74] [75] 
.field public static final [76] [77] 

.method public [79] : [80] 
    .attribute [78] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     new [13] 
L8:     dup 
L9:     invokespecial [11] 
L12:    putfield [14] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [78] .code stack 5 locals 3 
L0:     aload_0 
L1:     iload_1 
L2:     invokevirtual [8] 
L5:     istore_3 
L6:     iload_3 
L7:     iload_2 
L8:     if_icmple L13 
L11:    iconst_0 
L12:    areturn 
L13:    aload_0 
L14:    getfield [7] 
L17:    dup 
L18:    astore 4 
L20:    monitorenter 
        .catch [0] from L21 to L50 using L53 
L21:    aload_0 
L22:    getfield [7] 
L25:    new [15] 
L28:    dup 
L29:    iload_1 
L30:    invokespecial [12] 
L33:    new [15] 
L36:    dup 
L37:    iload_2 
L38:    invokespecial [12] 
L41:    invokeinterface [16] 0 
L46:    pop 
L47:    aload 4 
L49:    monitorexit 
L50:    goto L61 
        .catch [0] from L53 to L58 using L53 
L53:    astore 5 
L55:    aload 4 
L57:    monitorexit 
L58:    aload 5 
L60:    athrow 
L61:    iconst_1 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [78] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [7] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L35 using L38 
L7:     aload_0 
L8:     getfield [7] 
L11:    new [15] 
L14:    dup 
L15:    iload_1 
L16:    invokespecial [12] 
L19:    new [15] 
L22:    dup 
L23:    iconst_0 
L24:    invokespecial [12] 
L27:    invokeinterface [16] 0 
L32:    pop 
L33:    aload_2 
L34:    monitorexit 
L35:    goto L43 
        .catch [0] from L38 to L41 using L38 
L38:    astore_3 
L39:    aload_2 
L40:    monitorexit 
L41:    aload_3 
L42:    athrow 
L43:    return 
L44:    
    .end code 
.end method 

.method public synchronized [85] : [86] 
    .attribute [78] .code stack 4 locals 3 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     getfield [7] 
L6:     dup 
L7:     astore_3 
L8:     monitorenter 
        .catch [0] from L9 to L32 using L35 
L9:     aload_0 
L10:    getfield [7] 
L13:    new [15] 
L16:    dup 
L17:    iload_1 
L18:    invokespecial [12] 
L21:    invokeinterface [17] 0 
L26:    checkcast [3] 
L29:    astore_2 
L30:    aload_3 
L31:    monitorexit 
L32:    goto L42 
        .catch [0] from L35 to L39 using L35 
L35:    astore 4 
L37:    aload_3 
L38:    monitorexit 
L39:    aload 4 
L41:    athrow 
L42:    aload_2 
L43:    ifnonnull L48 
L46:    iconst_0 
L47:    areturn 
L48:    aload_2 
L49:    invokevirtual [9] 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [18] 
.const [3] = Class [19] 
.const [4] = Class [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Field [23] [24] 
.const [8] = Method [25] [26] 
.const [9] = Method [27] [28] 
.const [10] = Method [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Class [35] 
.const [14] = Field [36] [37] 
.const [15] = Class [38] 
.const [16] = InterfaceMethod [39] [40] 
.const [17] = InterfaceMethod [41] [42] 
.const [18] = Utf8 java/util/HashMap 
.const [19] = Utf8 java/lang/Short 
.const [20] = Utf8 de/esolutions/fw/comm/agent/agentdir/AgentDirectory 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 java/util/Map 
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
.const [35] = Utf8 java/util/HashMap 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Utf8 java/lang/Short 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Class [67] 
.const [42] = NameAndType [68] [69] 
.const [43] = Utf8 de/esolutions/fw/comm/agent/agentdir/AgentDirectory 
.const [44] = Utf8 agentMap 
.const [45] = Utf8 Ljava/util/Map; 
.const [46] = Utf8 de/esolutions/fw/comm/agent/agentdir/AgentDirectory 
.const [47] = Utf8 getAgentEpoch 
.const [48] = Utf8 (S)S 
.const [49] = Utf8 java/lang/Short 
.const [50] = Utf8 shortValue 
.const [51] = Utf8 ()S 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 <init> 
.const [54] = Utf8 ()V 
.const [55] = Utf8 java/util/HashMap 
.const [56] = Utf8 <init> 
.const [57] = Utf8 ()V 
.const [58] = Utf8 java/lang/Short 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (S)V 
.const [61] = Utf8 de/esolutions/fw/comm/agent/agentdir/AgentDirectory 
.const [62] = Utf8 agentMap 
.const [63] = Utf8 Ljava/util/Map; 
.const [64] = Utf8 java/util/Map 
.const [65] = Utf8 put 
.const [66] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [67] = Utf8 java/util/Map 
.const [68] = Utf8 get 
.const [69] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [70] = Utf8 de/esolutions/fw/comm/agent/agentdir/AgentDirectory 
.const [71] = Class [70] 
.const [72] = Utf8 java/lang/Object 
.const [73] = Class [72] 
.const [74] = Utf8 agentMap 
.const [75] = Utf8 Ljava/util/Map; 
.const [76] = Utf8 EPOCH_NONE 
.const [77] = Utf8 S 
.const [78] = Utf8 Code 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 updateAgent 
.const [82] = Utf8 (SS)Z 
.const [83] = Utf8 resetAgent 
.const [84] = Utf8 (S)V 
.const [85] = Utf8 getAgentEpoch 
.const [86] = Utf8 (S)S 
.end class 
