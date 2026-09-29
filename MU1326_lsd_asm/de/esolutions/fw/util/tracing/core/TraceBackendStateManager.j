.version 50 0 
.class public super [261] 
.super [263] 
.field private [264] [265] 
.field private [266] [267] 
.field private [268] [269] 
.field private [270] [271] 
.field private [272] [273] 

.method public [275] : [276] 
    .attribute [274] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     new [35] 
L8:     dup 
L9:     iload_1 
L10:    invokespecial [30] 
L13:    putfield [36] 
L16:    aload_0 
L17:    new [37] 
L20:    dup 
L21:    invokespecial [31] 
L24:    putfield [38] 
L27:    aload_0 
L28:    iconst_0 
L29:    putfield [39] 
L32:    aload_0 
L33:    iconst_0 
L34:    putfield [40] 
L37:    aload_0 
L38:    new [41] 
L41:    dup 
L42:    invokespecial [32] 
L45:    putfield [42] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [277] : [278] 
    .attribute [274] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokeinterface [43] 0 
L9:     ifne L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [279] : [280] 
    .attribute [274] .code stack 4 locals 2 
L0:     new [44] 
L3:     dup 
L4:     aload_1 
L5:     aload_2 
L6:     invokespecial [33] 
L9:     astore_3 
L10:    aload_0 
L11:    getfield [12] 
L14:    aload_3 
L15:    invokevirtual [17] 
L18:    istore 4 
L20:    aload_3 
L21:    iload 4 
L23:    invokevirtual [18] 
L26:    aload_0 
L27:    getfield [16] 
L30:    aload_1 
L31:    aload_3 
L32:    invokeinterface [45] 0 
L37:    pop 
L38:    aload_0 
L39:    dup 
L40:    getfield [14] 
L43:    iconst_1 
L44:    iadd 
L45:    putfield [39] 
L48:    iload 4 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [281] : [282] 
    .attribute [274] .code stack 3 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokevirtual [19] 
L5:     astore_2 
L6:     aload_2 
L7:     ifnonnull L12 
L10:    iconst_0 
L11:    areturn 
L12:    aload_0 
L13:    getfield [16] 
L16:    aload_2 
L17:    invokeinterface [46] 0 
L22:    pop 
L23:    aload_0 
L24:    getfield [12] 
L27:    iload_1 
L28:    invokevirtual [20] 
L31:    pop 
L32:    aload_0 
L33:    dup 
L34:    getfield [14] 
L37:    iconst_1 
L38:    isub 
L39:    putfield [39] 
L42:    iconst_1 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public [283] : [284] 
    .attribute [274] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [16] 
L4:     aload_1 
L5:     invokeinterface [47] 0 
L10:    checkcast [5] 
L13:    astore_2 
L14:    aload_2 
L15:    ifnonnull L20 
L18:    iconst_m1 
L19:    areturn 
L20:    aload_2 
L21:    invokevirtual [21] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [285] : [286] 
    .attribute [274] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     iload_1 
L5:     invokevirtual [22] 
L8:     checkcast [5] 
L11:    astore_2 
L12:    aload_2 
L13:    ifnonnull L18 
L16:    aconst_null 
L17:    areturn 
L18:    aload_2 
L19:    invokevirtual [23] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [287] : [288] 
    .attribute [274] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     iload_1 
L5:     invokevirtual [22] 
L8:     checkcast [5] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [289] : [290] 
    .attribute [274] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [12] 
L4:     iload_1 
L5:     invokevirtual [22] 
L8:     checkcast [5] 
L11:    astore_2 
L12:    aload_2 
L13:    ifnonnull L18 
L16:    iconst_0 
L17:    areturn 
L18:    aload_2 
L19:    invokevirtual [24] 
L22:    ifne L72 
L25:    aload_2 
L26:    iconst_1 
L27:    invokevirtual [25] 
L30:    aload_0 
L31:    getfield [13] 
L34:    new [48] 
L37:    dup 
L38:    iload_1 
L39:    invokespecial [34] 
L42:    invokeinterface [49] 0 
L47:    pop 
L48:    aload_2 
L49:    invokevirtual [26] 
L52:    istore_3 
L53:    iload_3 
L54:    iconst_1 
L55:    iand 
L56:    iconst_1 
L57:    if_icmpne L70 
L60:    aload_0 
L61:    dup 
L62:    getfield [15] 
L65:    iconst_1 
L66:    iadd 
L67:    putfield [40] 
L70:    iconst_1 
L71:    areturn 
L72:    iconst_0 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [291] : [292] 
    .attribute [274] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [12] 
L4:     iload_1 
L5:     invokevirtual [22] 
L8:     checkcast [5] 
L11:    astore_2 
L12:    aload_2 
L13:    ifnonnull L18 
L16:    iconst_0 
L17:    areturn 
L18:    aload_2 
L19:    invokevirtual [24] 
L22:    ifeq L72 
L25:    aload_2 
L26:    iconst_0 
L27:    invokevirtual [25] 
L30:    aload_0 
L31:    getfield [13] 
L34:    new [48] 
L37:    dup 
L38:    iload_1 
L39:    invokespecial [34] 
L42:    invokeinterface [50] 0 
L47:    pop 
L48:    aload_2 
L49:    invokevirtual [26] 
L52:    istore_3 
L53:    iload_3 
L54:    iconst_1 
L55:    iand 
L56:    iconst_1 
L57:    if_icmpne L70 
L60:    aload_0 
L61:    dup 
L62:    getfield [15] 
L65:    iconst_1 
L66:    isub 
L67:    putfield [40] 
L70:    iconst_1 
L71:    areturn 
L72:    iconst_0 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [293] : [294] 
    .attribute [274] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [12] 
L4:     iload_1 
L5:     invokevirtual [22] 
L8:     checkcast [5] 
L11:    astore_2 
L12:    aload_2 
L13:    ifnonnull L18 
L16:    iconst_0 
L17:    areturn 
L18:    aload_2 
L19:    invokevirtual [24] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [295] : [296] 
    .attribute [274] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [27] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [297] : [298] 
    .attribute [274] .code stack 3 locals 5 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokeinterface [51] 0 
L9:     istore_1 
L10:    iload_1 
L11:    newarray short 
L13:    astore_2 
L14:    aload_0 
L15:    getfield [13] 
L18:    invokeinterface [52] 0 
L23:    astore_3 
L24:    iconst_0 
L25:    istore 4 
L27:    aload_3 
L28:    invokeinterface [53] 0 
L33:    ifeq L62 
L36:    aload_3 
L37:    invokeinterface [54] 0 
L42:    checkcast [6] 
L45:    astore 5 
L47:    aload_2 
L48:    iload 4 
L50:    iinc 4 1 
L53:    aload 5 
L55:    invokevirtual [28] 
L58:    sastore 
L59:    goto L27 
L62:    aload_2 
L63:    areturn 
L64:    
    .end code 
.end method 

.method public [299] : [300] 
    .attribute [274] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     getfield [13] 
L8:     invokeinterface [51] 0 
L13:    if_icmpne L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [301] : [302] 
    .attribute [274] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [27] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public interface [303] : [304] 
    .attribute [274] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [55] 
.const [3] = Class [56] 
.const [4] = Class [57] 
.const [5] = Class [58] 
.const [6] = Class [59] 
.const [7] = Class [60] 
.const [8] = Class [61] 
.const [9] = Class [62] 
.const [10] = Class [63] 
.const [11] = Class [64] 
.const [12] = Field [65] [66] 
.const [13] = Field [67] [68] 
.const [14] = Field [69] [70] 
.const [15] = Field [71] [72] 
.const [16] = Field [73] [74] 
.const [17] = Method [75] [76] 
.const [18] = Method [77] [78] 
.const [19] = Method [79] [80] 
.const [20] = Method [81] [82] 
.const [21] = Method [83] [84] 
.const [22] = Method [85] [86] 
.const [23] = Method [87] [88] 
.const [24] = Method [89] [90] 
.const [25] = Method [91] [92] 
.const [26] = Method [93] [94] 
.const [27] = Method [95] [96] 
.const [28] = Method [97] [98] 
.const [29] = Method [99] [100] 
.const [30] = Method [101] [102] 
.const [31] = Method [103] [104] 
.const [32] = Method [105] [106] 
.const [33] = Method [107] [108] 
.const [34] = Method [109] [110] 
.const [35] = Class [111] 
.const [36] = Field [112] [113] 
.const [37] = Class [114] 
.const [38] = Field [115] [116] 
.const [39] = Field [117] [118] 
.const [40] = Field [119] [120] 
.const [41] = Class [121] 
.const [42] = Field [122] [123] 
.const [43] = InterfaceMethod [124] [125] 
.const [44] = Class [126] 
.const [45] = InterfaceMethod [127] [128] 
.const [46] = InterfaceMethod [129] [130] 
.const [47] = InterfaceMethod [131] [132] 
.const [48] = Class [133] 
.const [49] = InterfaceMethod [134] [135] 
.const [50] = InterfaceMethod [136] [137] 
.const [51] = InterfaceMethod [138] [139] 
.const [52] = InterfaceMethod [140] [141] 
.const [53] = InterfaceMethod [142] [143] 
.const [54] = InterfaceMethod [144] [145] 
.const [55] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [56] = Utf8 java/util/ArrayList 
.const [57] = Utf8 java/util/HashMap 
.const [58] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendState 
.const [59] = Utf8 java/lang/Short 
.const [60] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [61] = Utf8 java/lang/Object 
.const [62] = Utf8 java/util/List 
.const [63] = Utf8 java/util/Map 
.const [64] = Utf8 java/util/ListIterator 
.const [65] = Class [146] 
.const [66] = NameAndType [147] [148] 
.const [67] = Class [149] 
.const [68] = NameAndType [150] [151] 
.const [69] = Class [152] 
.const [70] = NameAndType [153] [154] 
.const [71] = Class [155] 
.const [72] = NameAndType [156] [157] 
.const [73] = Class [158] 
.const [74] = NameAndType [159] [160] 
.const [75] = Class [161] 
.const [76] = NameAndType [162] [163] 
.const [77] = Class [164] 
.const [78] = NameAndType [165] [166] 
.const [79] = Class [167] 
.const [80] = NameAndType [168] [169] 
.const [81] = Class [170] 
.const [82] = NameAndType [171] [172] 
.const [83] = Class [173] 
.const [84] = NameAndType [174] [175] 
.const [85] = Class [176] 
.const [86] = NameAndType [177] [178] 
.const [87] = Class [179] 
.const [88] = NameAndType [180] [181] 
.const [89] = Class [182] 
.const [90] = NameAndType [183] [184] 
.const [91] = Class [185] 
.const [92] = NameAndType [186] [187] 
.const [93] = Class [188] 
.const [94] = NameAndType [189] [190] 
.const [95] = Class [191] 
.const [96] = NameAndType [192] [193] 
.const [97] = Class [194] 
.const [98] = NameAndType [195] [196] 
.const [99] = Class [197] 
.const [100] = NameAndType [198] [199] 
.const [101] = Class [200] 
.const [102] = NameAndType [201] [202] 
.const [103] = Class [203] 
.const [104] = NameAndType [204] [205] 
.const [105] = Class [206] 
.const [106] = NameAndType [207] [208] 
.const [107] = Class [209] 
.const [108] = NameAndType [210] [211] 
.const [109] = Class [212] 
.const [110] = NameAndType [213] [214] 
.const [111] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [112] = Class [215] 
.const [113] = NameAndType [216] [217] 
.const [114] = Utf8 java/util/ArrayList 
.const [115] = Class [218] 
.const [116] = NameAndType [219] [220] 
.const [117] = Class [221] 
.const [118] = NameAndType [222] [223] 
.const [119] = Class [224] 
.const [120] = NameAndType [225] [226] 
.const [121] = Utf8 java/util/HashMap 
.const [122] = Class [227] 
.const [123] = NameAndType [228] [229] 
.const [124] = Class [230] 
.const [125] = NameAndType [231] [232] 
.const [126] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendState 
.const [127] = Class [233] 
.const [128] = NameAndType [234] [235] 
.const [129] = Class [236] 
.const [130] = NameAndType [237] [238] 
.const [131] = Class [239] 
.const [132] = NameAndType [240] [241] 
.const [133] = Utf8 java/lang/Short 
.const [134] = Class [242] 
.const [135] = NameAndType [243] [244] 
.const [136] = Class [245] 
.const [137] = NameAndType [246] [247] 
.const [138] = Class [248] 
.const [139] = NameAndType [249] [250] 
.const [140] = Class [251] 
.const [141] = NameAndType [252] [253] 
.const [142] = Class [254] 
.const [143] = NameAndType [255] [256] 
.const [144] = Class [257] 
.const [145] = NameAndType [258] [259] 
.const [146] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [147] = Utf8 backends 
.const [148] = Utf8 Lde/esolutions/fw/util/commons/pool/ShortPool; 
.const [149] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [150] = Utf8 connected 
.const [151] = Utf8 Ljava/util/List; 
.const [152] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [153] = Utf8 counter 
.const [154] = Utf8 I 
.const [155] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [156] = Utf8 decodeFlagCounter 
.const [157] = Utf8 I 
.const [158] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [159] = Utf8 mapToState 
.const [160] = Utf8 Ljava/util/Map; 
.const [161] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [162] = Utf8 add 
.const [163] = Utf8 (Ljava/lang/Object;)S 
.const [164] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendState 
.const [165] = Utf8 setId 
.const [166] = Utf8 (S)V 
.const [167] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [168] = Utf8 getBackend 
.const [169] = Utf8 (S)Lde/esolutions/fw/util/tracing/backend/ITraceBackend; 
.const [170] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [171] = Utf8 remove 
.const [172] = Utf8 (S)Ljava/lang/Object; 
.const [173] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendState 
.const [174] = Utf8 getId 
.const [175] = Utf8 ()S 
.const [176] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [177] = Utf8 getObject 
.const [178] = Utf8 (S)Ljava/lang/Object; 
.const [179] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendState 
.const [180] = Utf8 getBackend 
.const [181] = Utf8 ()Lde/esolutions/fw/util/tracing/backend/ITraceBackend; 
.const [182] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendState 
.const [183] = Utf8 isConnected 
.const [184] = Utf8 ()Z 
.const [185] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendState 
.const [186] = Utf8 setConnected 
.const [187] = Utf8 (Z)V 
.const [188] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendState 
.const [189] = Utf8 getFlags 
.const [190] = Utf8 ()I 
.const [191] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [192] = Utf8 getUsedIDs 
.const [193] = Utf8 ()[S 
.const [194] = Utf8 java/lang/Short 
.const [195] = Utf8 shortValue 
.const [196] = Utf8 ()S 
.const [197] = Utf8 java/lang/Object 
.const [198] = Utf8 <init> 
.const [199] = Utf8 ()V 
.const [200] = Utf8 de/esolutions/fw/util/commons/pool/ShortPool 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (S)V 
.const [203] = Utf8 java/util/ArrayList 
.const [204] = Utf8 <init> 
.const [205] = Utf8 ()V 
.const [206] = Utf8 java/util/HashMap 
.const [207] = Utf8 <init> 
.const [208] = Utf8 ()V 
.const [209] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendState 
.const [210] = Utf8 <init> 
.const [211] = Utf8 (Lde/esolutions/fw/util/tracing/backend/ITraceBackend;Ljava/lang/String;)V 
.const [212] = Utf8 java/lang/Short 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (S)V 
.const [215] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [216] = Utf8 backends 
.const [217] = Utf8 Lde/esolutions/fw/util/commons/pool/ShortPool; 
.const [218] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [219] = Utf8 connected 
.const [220] = Utf8 Ljava/util/List; 
.const [221] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [222] = Utf8 counter 
.const [223] = Utf8 I 
.const [224] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [225] = Utf8 decodeFlagCounter 
.const [226] = Utf8 I 
.const [227] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [228] = Utf8 mapToState 
.const [229] = Utf8 Ljava/util/Map; 
.const [230] = Utf8 java/util/List 
.const [231] = Utf8 isEmpty 
.const [232] = Utf8 ()Z 
.const [233] = Utf8 java/util/Map 
.const [234] = Utf8 put 
.const [235] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [236] = Utf8 java/util/Map 
.const [237] = Utf8 remove 
.const [238] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [239] = Utf8 java/util/Map 
.const [240] = Utf8 get 
.const [241] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [242] = Utf8 java/util/List 
.const [243] = Utf8 add 
.const [244] = Utf8 (Ljava/lang/Object;)Z 
.const [245] = Utf8 java/util/List 
.const [246] = Utf8 remove 
.const [247] = Utf8 (Ljava/lang/Object;)Z 
.const [248] = Utf8 java/util/List 
.const [249] = Utf8 size 
.const [250] = Utf8 ()I 
.const [251] = Utf8 java/util/List 
.const [252] = Utf8 listIterator 
.const [253] = Utf8 ()Ljava/util/ListIterator; 
.const [254] = Utf8 java/util/ListIterator 
.const [255] = Utf8 hasNext 
.const [256] = Utf8 ()Z 
.const [257] = Utf8 java/util/ListIterator 
.const [258] = Utf8 next 
.const [259] = Utf8 ()Ljava/lang/Object; 
.const [260] = Utf8 de/esolutions/fw/util/tracing/core/TraceBackendStateManager 
.const [261] = Class [260] 
.const [262] = Utf8 java/lang/Object 
.const [263] = Class [262] 
.const [264] = Utf8 backends 
.const [265] = Utf8 Lde/esolutions/fw/util/commons/pool/ShortPool; 
.const [266] = Utf8 connected 
.const [267] = Utf8 Ljava/util/List; 
.const [268] = Utf8 mapToState 
.const [269] = Utf8 Ljava/util/Map; 
.const [270] = Utf8 counter 
.const [271] = Utf8 I 
.const [272] = Utf8 decodeFlagCounter 
.const [273] = Utf8 I 
.const [274] = Utf8 Code 
.const [275] = Utf8 <init> 
.const [276] = Utf8 (S)V 
.const [277] = Utf8 hasConnectedBackends 
.const [278] = Utf8 ()Z 
.const [279] = Utf8 createBackend 
.const [280] = Utf8 (Lde/esolutions/fw/util/tracing/backend/ITraceBackend;Ljava/lang/String;)S 
.const [281] = Utf8 removeBackend 
.const [282] = Utf8 (S)Z 
.const [283] = Utf8 findBackend 
.const [284] = Utf8 (Lde/esolutions/fw/util/tracing/backend/ITraceBackend;)S 
.const [285] = Utf8 getBackend 
.const [286] = Utf8 (S)Lde/esolutions/fw/util/tracing/backend/ITraceBackend; 
.const [287] = Utf8 getBackendState 
.const [288] = Utf8 (S)Lde/esolutions/fw/util/tracing/core/TraceBackendState; 
.const [289] = Utf8 setConnected 
.const [290] = Utf8 (S)Z 
.const [291] = Utf8 setDisconnected 
.const [292] = Utf8 (S)Z 
.const [293] = Utf8 isConnected 
.const [294] = Utf8 (S)Z 
.const [295] = Utf8 getAllBackendIds 
.const [296] = Utf8 ()[S 
.const [297] = Utf8 getAllConnectedBackendIds 
.const [298] = Utf8 ()[S 
.const [299] = Utf8 areAllConnected 
.const [300] = Utf8 ()Z 
.const [301] = Utf8 getBackendIds 
.const [302] = Utf8 ()[S 
.const [303] = Utf8 getDecodeFlagCounter 
.const [304] = Utf8 ()I 
.end class 
