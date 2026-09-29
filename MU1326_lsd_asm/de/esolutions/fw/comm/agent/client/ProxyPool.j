.version 50 0 
.class public super [183] 
.super [185] 
.field protected [186] [187] 

.method public [189] : [190] 
    .attribute [188] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     new [39] 
L8:     dup 
L9:     iload_1 
L10:    invokespecial [35] 
L13:    putfield [40] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [191] : [192] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokevirtual [18] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [193] : [194] 
    .attribute [188] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [17] 
L4:     aload_1 
L5:     invokevirtual [19] 
L8:     istore_2 
L9:     getstatic [3] 
L12:    iconst_1 
L13:    ldc [4] 
L15:    new [41] 
L18:    dup 
L19:    aload_0 
L20:    invokevirtual [20] 
L23:    invokespecial [36] 
L26:    new [42] 
L29:    dup 
L30:    iload_2 
L31:    invokespecial [37] 
L34:    invokevirtual [21] 
L37:    pop 
L38:    iload_2 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public synchronized [195] : [196] 
    .attribute [188] .code stack 7 locals 1 
L0:     iconst_m1 
L1:     istore_2 
L2:     aload_0 
L3:     getfield [17] 
L6:     aload_1 
L7:     invokevirtual [22] 
L10:    iconst_m1 
L11:    if_icmpne L26 
L14:    aload_0 
L15:    getfield [17] 
L18:    aload_1 
L19:    invokevirtual [19] 
L22:    istore_2 
L23:    goto L31 
L26:    aload_1 
L27:    invokevirtual [23] 
L30:    istore_2 
L31:    getstatic [3] 
L34:    iconst_1 
L35:    ldc [7] 
L37:    new [41] 
L40:    dup 
L41:    aload_0 
L42:    invokevirtual [20] 
L45:    invokespecial [36] 
L48:    new [42] 
L51:    dup 
L52:    iload_2 
L53:    invokespecial [37] 
L56:    invokevirtual [21] 
L59:    pop 
L60:    iload_2 
L61:    areturn 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public synchronized [197] : [198] 
    .attribute [188] .code stack 7 locals 2 
L0:     aload_0 
L1:     getfield [17] 
L4:     iload_1 
L5:     invokevirtual [24] 
L8:     checkcast [8] 
L11:    astore_2 
L12:    iconst_m1 
L13:    istore_3 
L14:    aload_2 
L15:    ifnull L23 
L18:    aload_2 
L19:    invokevirtual [23] 
L22:    istore_3 
L23:    getstatic [3] 
L26:    iconst_1 
L27:    ldc [9] 
L29:    new [41] 
L32:    dup 
L33:    aload_0 
L34:    invokevirtual [20] 
L37:    invokespecial [36] 
L40:    new [42] 
L43:    dup 
L44:    iload_3 
L45:    invokespecial [37] 
L48:    invokevirtual [21] 
L51:    pop 
L52:    aload_2 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public synchronized [199] : [200] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     iload_1 
L5:     invokevirtual [25] 
L8:     checkcast [8] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public synchronized [201] : [202] 
    .attribute [188] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokevirtual [26] 
L7:     getstatic [3] 
L10:    iconst_1 
L11:    ldc [10] 
L13:    new [41] 
L16:    dup 
L17:    aload_0 
L18:    invokevirtual [20] 
L21:    invokespecial [36] 
L24:    invokevirtual [27] 
L27:    pop 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public synchronized [203] : [204] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokevirtual [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [205] : [206] 
    .attribute [188] .code stack 3 locals 5 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokevirtual [28] 
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
L31:    invokevirtual [29] 
L34:    astore 5 
L36:    aload 5 
L38:    invokevirtual [30] 
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
L61:    anewarray [8] 
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
L83:    invokevirtual [29] 
L86:    astore 6 
L88:    aload 6 
L90:    invokevirtual [30] 
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

.method public synchronized [207] : [208] 
    .attribute [188] .code stack 3 locals 5 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokevirtual [28] 
L7:     astore_3 
L8:     aload_3 
L9:     ifnonnull L14 
L12:    aconst_null 
L13:    areturn 
L14:    iconst_0 
L15:    istore 4 
L17:    iconst_0 
L18:    istore 5 
L20:    iload 5 
L22:    aload_3 
L23:    arraylength 
L24:    if_icmpge L67 
L27:    aload_0 
L28:    aload_3 
L29:    iload 5 
L31:    saload 
L32:    invokevirtual [29] 
L35:    astore 6 
L37:    aload 6 
L39:    invokevirtual [31] 
L42:    aload_2 
L43:    invokevirtual [32] 
L46:    ifeq L61 
L49:    aload 6 
L51:    invokevirtual [30] 
L54:    aload_1 
L55:    if_acmpne L61 
L58:    iinc 4 1 
L61:    iinc 5 1 
L64:    goto L20 
L67:    iload 4 
L69:    ifne L74 
L72:    aconst_null 
L73:    areturn 
L74:    iload 4 
L76:    anewarray [8] 
L79:    astore 5 
L81:    iconst_0 
L82:    istore 4 
L84:    iconst_0 
L85:    istore 6 
L87:    iload 6 
L89:    aload_3 
L90:    arraylength 
L91:    if_icmpge L141 
L94:    aload_0 
L95:    aload_3 
L96:    iload 6 
L98:    saload 
L99:    invokevirtual [29] 
L102:   astore 7 
L104:   aload 7 
L106:   invokevirtual [31] 
L109:   aload_2 
L110:   invokevirtual [32] 
L113:   ifeq L135 
L116:   aload 7 
L118:   invokevirtual [30] 
L121:   aload_1 
L122:   if_acmpne L135 
L125:   aload 5 
L127:   iload 4 
L129:   iinc 4 1 
L132:   aload 7 
L134:   aastore 
L135:   iinc 6 1 
L138:   goto L87 
L141:   aload 5 
L143:   areturn 
L144:   
    .end code 
.end method 

.method public synchronized [209] : [210] 
    .attribute [188] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokevirtual [33] 
L7:     astore_1 
L8:     aload_1 
L9:     ifnull L54 
L12:    aload_1 
L13:    arraylength 
L14:    anewarray [11] 
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
L29:    checkcast [8] 
L32:    astore 4 
L34:    aload_2 
L35:    iload_3 
L36:    new [43] 
L39:    dup 
L40:    aload 4 
L42:    invokespecial [38] 
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
.const [2] = Class [44] 
.const [3] = Field [45] [46] 
.const [4] = String [47] 
.const [5] = Class [48] 
.const [6] = Class [49] 
.const [7] = String [50] 
.const [8] = Class [51] 
.const [9] = String [52] 
.const [10] = String [53] 
.const [11] = Class [54] 
.const [12] = Class [55] 
.const [13] = Class [56] 
.const [14] = Class [57] 
.const [15] = Class [58] 
.const [16] = Class [59] 
.const [17] = Field [60] [61] 
.const [18] = Method [62] [63] 
.const [19] = Method [64] [65] 
.const [20] = Method [66] [67] 
.const [21] = Method [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Class [104] 
.const [40] = Field [105] [106] 
.const [41] = Class [107] 
.const [42] = Class [108] 
.const [43] = Class [109] 
.const [44] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [45] = Class [110] 
.const [46] = NameAndType [111] [112] 
.const [47] = Utf8 '#PoolSize ProxyPool, size=%1, proxyID=%2 [add]' 
.const [48] = Utf8 java/lang/Integer 
.const [49] = Utf8 java/lang/Short 
.const [50] = Utf8 '#PoolSize ProxyPool, size=%1, proxyID=%2 [addIfMissing]' 
.const [51] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [52] = Utf8 '#PoolSize ProxyPool, size=%1, proxyID=%2 [remove]' 
.const [53] = Utf8 '#PoolSize ProxyPool, size=%1 [clear]' 
.const [54] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [55] = Utf8 de/esolutions/fw/comm/agent/client/ProxyPool 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [58] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [59] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [60] = Class [113] 
.const [61] = NameAndType [114] [115] 
.const [62] = Class [116] 
.const [63] = NameAndType [117] [118] 
.const [64] = Class [119] 
.const [65] = NameAndType [120] [121] 
.const [66] = Class [122] 
.const [67] = NameAndType [123] [124] 
.const [68] = Class [125] 
.const [69] = NameAndType [126] [127] 
.const [70] = Class [128] 
.const [71] = NameAndType [129] [130] 
.const [72] = Class [131] 
.const [73] = NameAndType [132] [133] 
.const [74] = Class [134] 
.const [75] = NameAndType [135] [136] 
.const [76] = Class [137] 
.const [77] = NameAndType [138] [139] 
.const [78] = Class [140] 
.const [79] = NameAndType [141] [142] 
.const [80] = Class [143] 
.const [81] = NameAndType [144] [145] 
.const [82] = Class [146] 
.const [83] = NameAndType [147] [148] 
.const [84] = Class [149] 
.const [85] = NameAndType [150] [151] 
.const [86] = Class [152] 
.const [87] = NameAndType [153] [154] 
.const [88] = Class [155] 
.const [89] = NameAndType [156] [157] 
.const [90] = Class [158] 
.const [91] = NameAndType [159] [160] 
.const [92] = Class [161] 
.const [93] = NameAndType [162] [163] 
.const [94] = Class [164] 
.const [95] = NameAndType [165] [166] 
.const [96] = Class [167] 
.const [97] = NameAndType [168] [169] 
.const [98] = Class [170] 
.const [99] = NameAndType [171] [172] 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Class [176] 
.const [103] = NameAndType [177] [178] 
.const [104] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [105] = Class [179] 
.const [106] = NameAndType [180] [181] 
.const [107] = Utf8 java/lang/Integer 
.const [108] = Utf8 java/lang/Short 
.const [109] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [110] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [111] = Utf8 PROXYSTUBPOOL 
.const [112] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [113] = Utf8 de/esolutions/fw/comm/agent/client/ProxyPool 
.const [114] = Utf8 clientProxies 
.const [115] = Utf8 Lde/esolutions/fw/util/commons/pool/ShortPool; 
.const [116] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [117] = Utf8 size 
.const [118] = Utf8 ()I 
.const [119] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [120] = Utf8 add 
.const [121] = Utf8 (Ljava/lang/Object;)S 
.const [122] = Utf8 de/esolutions/fw/comm/agent/client/ProxyPool 
.const [123] = Utf8 size 
.const [124] = Utf8 ()I 
.const [125] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [126] = Utf8 log 
.const [127] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [128] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [129] = Utf8 findObject 
.const [130] = Utf8 (Ljava/lang/Object;)S 
.const [131] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [132] = Utf8 getProxyID 
.const [133] = Utf8 ()S 
.const [134] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [135] = Utf8 remove 
.const [136] = Utf8 (S)Ljava/lang/Object; 
.const [137] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [138] = Utf8 getObject 
.const [139] = Utf8 (S)Ljava/lang/Object; 
.const [140] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [141] = Utf8 clear 
.const [142] = Utf8 ()V 
.const [143] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [144] = Utf8 log 
.const [145] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [146] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [147] = Utf8 getUsedIDs 
.const [148] = Utf8 ()[S 
.const [149] = Utf8 de/esolutions/fw/comm/agent/client/ProxyPool 
.const [150] = Utf8 getForID 
.const [151] = Utf8 (S)Lde/esolutions/fw/comm/core/Proxy; 
.const [152] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [153] = Utf8 getBackend 
.const [154] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyBackend; 
.const [155] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [156] = Utf8 getInstanceID 
.const [157] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [158] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [159] = Utf8 equals 
.const [160] = Utf8 (Ljava/lang/Object;)Z 
.const [161] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [162] = Utf8 getUsedObjects 
.const [163] = Utf8 ()[Ljava/lang/Object; 
.const [164] = Utf8 java/lang/Object 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (S)V 
.const [170] = Utf8 java/lang/Integer 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (I)V 
.const [173] = Utf8 java/lang/Short 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (S)V 
.const [176] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;)V 
.const [179] = Utf8 de/esolutions/fw/comm/agent/client/ProxyPool 
.const [180] = Utf8 clientProxies 
.const [181] = Utf8 Lde/esolutions/fw/util/commons/pool/ShortPool; 
.const [182] = Utf8 de/esolutions/fw/comm/agent/client/ProxyPool 
.const [183] = Class [182] 
.const [184] = Utf8 java/lang/Object 
.const [185] = Class [184] 
.const [186] = Utf8 clientProxies 
.const [187] = Utf8 Lde/esolutions/fw/util/commons/pool/ShortPool; 
.const [188] = Utf8 Code 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (S)V 
.const [191] = Utf8 size 
.const [192] = Utf8 ()I 
.const [193] = Utf8 add 
.const [194] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;)S 
.const [195] = Utf8 addIfMissing 
.const [196] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;)S 
.const [197] = Utf8 remove 
.const [198] = Utf8 (S)Lde/esolutions/fw/comm/core/Proxy; 
.const [199] = Utf8 getForID 
.const [200] = Utf8 (S)Lde/esolutions/fw/comm/core/Proxy; 
.const [201] = Utf8 clear 
.const [202] = Utf8 ()V 
.const [203] = Utf8 getUsedIDs 
.const [204] = Utf8 ()[S 
.const [205] = Utf8 getIDsForBackend 
.const [206] = Utf8 (Lde/esolutions/fw/comm/core/IProxyBackend;)[Lde/esolutions/fw/comm/core/Proxy; 
.const [207] = Utf8 getIDsForServiceInstanceID 
.const [208] = Utf8 (Lde/esolutions/fw/comm/core/IProxyBackend;Lde/esolutions/fw/comm/core/ServiceInstanceID;)[Lde/esolutions/fw/comm/core/Proxy; 
.const [209] = Utf8 createProxyInfos 
.const [210] = Utf8 ()[Lde/esolutions/fw/comm/agent/diag/info/ProxyInfo; 
.end class 
