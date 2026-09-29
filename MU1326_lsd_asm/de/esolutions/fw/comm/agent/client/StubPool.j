.version 50 0 
.class public super [161] 
.super [163] 
.field protected [164] [165] 

.method public [167] : [168] 
    .attribute [166] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     new [34] 
L8:     dup 
L9:     iload_1 
L10:    invokespecial [30] 
L13:    putfield [35] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [169] : [170] 
    .attribute [166] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [16] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [171] : [172] 
    .attribute [166] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_1 
L5:     invokevirtual [17] 
L8:     istore_2 
L9:     getstatic [3] 
L12:    iconst_1 
L13:    ldc [4] 
L15:    new [36] 
L18:    dup 
L19:    aload_0 
L20:    invokevirtual [18] 
L23:    invokespecial [31] 
L26:    new [37] 
L29:    dup 
L30:    iload_2 
L31:    invokespecial [32] 
L34:    invokevirtual [19] 
L37:    pop 
L38:    iload_2 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public synchronized [173] : [174] 
    .attribute [166] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [15] 
L4:     iload_1 
L5:     invokevirtual [20] 
L8:     checkcast [7] 
L11:    astore_2 
L12:    getstatic [3] 
L15:    iconst_1 
L16:    ldc [8] 
L18:    new [36] 
L21:    dup 
L22:    aload_0 
L23:    invokevirtual [18] 
L26:    invokespecial [31] 
L29:    new [37] 
L32:    dup 
L33:    iload_1 
L34:    invokespecial [32] 
L37:    invokevirtual [19] 
L40:    pop 
L41:    aload_2 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public synchronized [175] : [176] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iload_1 
L5:     invokevirtual [21] 
L8:     checkcast [7] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public synchronized [177] : [178] 
    .attribute [166] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [22] 
L7:     getstatic [3] 
L10:    iconst_1 
L11:    ldc [9] 
L13:    new [36] 
L16:    dup 
L17:    aload_0 
L18:    invokevirtual [18] 
L21:    invokespecial [31] 
L24:    invokevirtual [23] 
L27:    pop 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public synchronized [179] : [180] 
    .attribute [166] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [24] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [181] : [182] 
    .attribute [166] .code stack 3 locals 5 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [24] 
L7:     astore_2 
L8:     aload_2 
L9:     ifnonnull L14 
L12:    aconst_null 
L13:    areturn 
L14:    iconst_0 
L15:    istore_3 
L16:    iconst_0 
L17:    istore 4 
L19:    iload 4 
L21:    aload_2 
L22:    arraylength 
L23:    if_icmpge L54 
L26:    aload_0 
L27:    aload_2 
L28:    iload 4 
L30:    saload 
L31:    invokevirtual [25] 
L34:    astore 5 
L36:    aload 5 
L38:    invokevirtual [26] 
L41:    aload_1 
L42:    if_acmpne L48 
L45:    iinc 3 1 
L48:    iinc 4 1 
L51:    goto L19 
L54:    iload_3 
L55:    ifne L60 
L58:    aconst_null 
L59:    areturn 
L60:    iload_3 
L61:    anewarray [7] 
L64:    astore 4 
L66:    iconst_0 
L67:    istore_3 
L68:    iconst_0 
L69:    istore 5 
L71:    iload 5 
L73:    aload_2 
L74:    arraylength 
L75:    if_icmpge L112 
L78:    aload_0 
L79:    aload_2 
L80:    iload 5 
L82:    saload 
L83:    invokevirtual [25] 
L86:    astore 6 
L88:    aload 6 
L90:    invokevirtual [26] 
L93:    aload_1 
L94:    if_acmpne L106 
L97:    aload 4 
L99:    iload_3 
L100:   iinc 3 1 
L103:   aload 6 
L105:   aastore 
L106:   iinc 5 1 
L109:   goto L71 
L112:   aload 4 
L114:   areturn 
L115:   nop 
L116:   
    .end code 
.end method 

.method public synchronized [183] : [184] 
    .attribute [166] .code stack 3 locals 5 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [24] 
L7:     astore_2 
L8:     aload_2 
L9:     ifnonnull L14 
L12:    aconst_null 
L13:    areturn 
L14:    iconst_0 
L15:    istore_3 
L16:    iconst_0 
L17:    istore 4 
L19:    iload 4 
L21:    aload_2 
L22:    arraylength 
L23:    if_icmpge L54 
L26:    aload_0 
L27:    aload_2 
L28:    iload 4 
L30:    saload 
L31:    invokevirtual [25] 
L34:    astore 5 
L36:    aload 5 
L38:    invokevirtual [27] 
L41:    aload_1 
L42:    if_acmpne L48 
L45:    iinc 3 1 
L48:    iinc 4 1 
L51:    goto L19 
L54:    iload_3 
L55:    ifne L60 
L58:    aconst_null 
L59:    areturn 
L60:    iload_3 
L61:    anewarray [7] 
L64:    astore 4 
L66:    iconst_0 
L67:    istore_3 
L68:    iconst_0 
L69:    istore 5 
L71:    iload 5 
L73:    aload_2 
L74:    arraylength 
L75:    if_icmpge L112 
L78:    aload_0 
L79:    aload_2 
L80:    iload 5 
L82:    saload 
L83:    invokevirtual [25] 
L86:    astore 6 
L88:    aload 6 
L90:    invokevirtual [27] 
L93:    aload_1 
L94:    if_acmpne L106 
L97:    aload 4 
L99:    iload_3 
L100:   iinc 3 1 
L103:   aload 6 
L105:   aastore 
L106:   iinc 5 1 
L109:   goto L71 
L112:   aload 4 
L114:   areturn 
L115:   nop 
L116:   
    .end code 
.end method 

.method public synchronized [185] : [186] 
    .attribute [166] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [28] 
L7:     astore_1 
L8:     aload_1 
L9:     ifnull L54 
L12:    aload_1 
L13:    arraylength 
L14:    anewarray [10] 
L17:    astore_2 
L18:    iconst_0 
L19:    istore_3 
L20:    iload_3 
L21:    aload_1 
L22:    arraylength 
L23:    if_icmpge L52 
L26:    aload_1 
L27:    iload_3 
L28:    aaload 
L29:    checkcast [7] 
L32:    astore 4 
L34:    aload_2 
L35:    iload_3 
L36:    new [38] 
L39:    dup 
L40:    aload 4 
L42:    invokespecial [33] 
L45:    aastore 
L46:    iinc 3 1 
L49:    goto L20 
L52:    aload_2 
L53:    areturn 
L54:    aconst_null 
L55:    areturn 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = Field [40] [41] 
.const [4] = String [42] 
.const [5] = Class [43] 
.const [6] = Class [44] 
.const [7] = Class [45] 
.const [8] = String [46] 
.const [9] = String [47] 
.const [10] = Class [48] 
.const [11] = Class [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Field [53] [54] 
.const [16] = Method [55] [56] 
.const [17] = Method [57] [58] 
.const [18] = Method [59] [60] 
.const [19] = Method [61] [62] 
.const [20] = Method [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Class [91] 
.const [35] = Field [92] [93] 
.const [36] = Class [94] 
.const [37] = Class [95] 
.const [38] = Class [96] 
.const [39] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [40] = Class [97] 
.const [41] = NameAndType [98] [99] 
.const [42] = Utf8 '#PoolSize StubPool, size=%1, stubID=%2 [add]' 
.const [43] = Utf8 java/lang/Integer 
.const [44] = Utf8 java/lang/Short 
.const [45] = Utf8 de/esolutions/fw/comm/agent/service/Stub 
.const [46] = Utf8 '#PoolSize StubPool, size=%1, stubID=%2 [remove] ' 
.const [47] = Utf8 '#PoolSize StubPool, size=%1 [clear] ' 
.const [48] = Utf8 de/esolutions/fw/comm/agent/diag/info/StubInfo 
.const [49] = Utf8 de/esolutions/fw/comm/agent/client/StubPool 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [52] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [53] = Class [100] 
.const [54] = NameAndType [101] [102] 
.const [55] = Class [103] 
.const [56] = NameAndType [104] [105] 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Class [109] 
.const [60] = NameAndType [110] [111] 
.const [61] = Class [112] 
.const [62] = NameAndType [113] [114] 
.const [63] = Class [115] 
.const [64] = NameAndType [116] [117] 
.const [65] = Class [118] 
.const [66] = NameAndType [119] [120] 
.const [67] = Class [121] 
.const [68] = NameAndType [122] [123] 
.const [69] = Class [124] 
.const [70] = NameAndType [125] [126] 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Class [130] 
.const [74] = NameAndType [131] [132] 
.const [75] = Class [133] 
.const [76] = NameAndType [134] [135] 
.const [77] = Class [136] 
.const [78] = NameAndType [137] [138] 
.const [79] = Class [139] 
.const [80] = NameAndType [140] [141] 
.const [81] = Class [142] 
.const [82] = NameAndType [143] [144] 
.const [83] = Class [145] 
.const [84] = NameAndType [146] [147] 
.const [85] = Class [148] 
.const [86] = NameAndType [149] [150] 
.const [87] = Class [151] 
.const [88] = NameAndType [152] [153] 
.const [89] = Class [154] 
.const [90] = NameAndType [155] [156] 
.const [91] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [92] = Class [157] 
.const [93] = NameAndType [158] [159] 
.const [94] = Utf8 java/lang/Integer 
.const [95] = Utf8 java/lang/Short 
.const [96] = Utf8 de/esolutions/fw/comm/agent/diag/info/StubInfo 
.const [97] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [98] = Utf8 PROXYSTUBPOOL 
.const [99] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [100] = Utf8 de/esolutions/fw/comm/agent/client/StubPool 
.const [101] = Utf8 clientStubs 
.const [102] = Utf8 Lde/esolutions/fw/util/commons/pool/ShortPool; 
.const [103] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [104] = Utf8 size 
.const [105] = Utf8 ()I 
.const [106] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [107] = Utf8 add 
.const [108] = Utf8 (Ljava/lang/Object;)S 
.const [109] = Utf8 de/esolutions/fw/comm/agent/client/StubPool 
.const [110] = Utf8 size 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [113] = Utf8 log 
.const [114] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [115] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [116] = Utf8 remove 
.const [117] = Utf8 (S)Ljava/lang/Object; 
.const [118] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [119] = Utf8 getObject 
.const [120] = Utf8 (S)Ljava/lang/Object; 
.const [121] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [122] = Utf8 clear 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [125] = Utf8 log 
.const [126] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [127] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [128] = Utf8 getUsedIDs 
.const [129] = Utf8 ()[S 
.const [130] = Utf8 de/esolutions/fw/comm/agent/client/StubPool 
.const [131] = Utf8 getForID 
.const [132] = Utf8 (S)Lde/esolutions/fw/comm/agent/service/Stub; 
.const [133] = Utf8 de/esolutions/fw/comm/agent/service/Stub 
.const [134] = Utf8 getClient 
.const [135] = Utf8 ()Lde/esolutions/fw/comm/agent/client/IClientHandler; 
.const [136] = Utf8 de/esolutions/fw/comm/agent/service/Stub 
.const [137] = Utf8 getService 
.const [138] = Utf8 ()Lde/esolutions/fw/comm/core/IService; 
.const [139] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [140] = Utf8 getUsedObjects 
.const [141] = Utf8 ()[Ljava/lang/Object; 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (S)V 
.const [148] = Utf8 java/lang/Integer 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (I)V 
.const [151] = Utf8 java/lang/Short 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (S)V 
.const [154] = Utf8 de/esolutions/fw/comm/agent/diag/info/StubInfo 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (Lde/esolutions/fw/comm/agent/service/Stub;)V 
.const [157] = Utf8 de/esolutions/fw/comm/agent/client/StubPool 
.const [158] = Utf8 clientStubs 
.const [159] = Utf8 Lde/esolutions/fw/util/commons/pool/ShortPool; 
.const [160] = Utf8 de/esolutions/fw/comm/agent/client/StubPool 
.const [161] = Class [160] 
.const [162] = Utf8 java/lang/Object 
.const [163] = Class [162] 
.const [164] = Utf8 clientStubs 
.const [165] = Utf8 Lde/esolutions/fw/util/commons/pool/ShortPool; 
.const [166] = Utf8 Code 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (S)V 
.const [169] = Utf8 size 
.const [170] = Utf8 ()I 
.const [171] = Utf8 add 
.const [172] = Utf8 (Lde/esolutions/fw/comm/agent/service/Stub;)S 
.const [173] = Utf8 remove 
.const [174] = Utf8 (S)Lde/esolutions/fw/comm/agent/service/Stub; 
.const [175] = Utf8 getForID 
.const [176] = Utf8 (S)Lde/esolutions/fw/comm/agent/service/Stub; 
.const [177] = Utf8 clear 
.const [178] = Utf8 ()V 
.const [179] = Utf8 getUsedIDs 
.const [180] = Utf8 ()[S 
.const [181] = Utf8 getIDsForClient 
.const [182] = Utf8 (Lde/esolutions/fw/comm/agent/client/IClientHandler;)[Lde/esolutions/fw/comm/agent/service/Stub; 
.const [183] = Utf8 getIDsForService 
.const [184] = Utf8 (Lde/esolutions/fw/comm/core/IService;)[Lde/esolutions/fw/comm/agent/service/Stub; 
.const [185] = Utf8 createStubInfos 
.const [186] = Utf8 ()[Lde/esolutions/fw/comm/agent/diag/info/StubInfo; 
.end class 
