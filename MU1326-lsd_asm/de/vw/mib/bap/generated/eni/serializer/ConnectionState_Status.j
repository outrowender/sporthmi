.version 50 0 
.class public final super [211] 
.super [213] 
.implements [215] 
.field public [216] [217] 
.field public static final [218] [219] 
.field public static final [220] [221] 
.field public static final [222] [223] 
.field public static final [224] [225] 
.field public [226] [227] 
.field public [228] [229] 
.field public static final [230] [231] 
.field public [232] [233] 
.field public static final [234] [235] 
.field public [236] [237] 
.field public static final [238] [239] 
.field public [240] [241] 
.field public static final [242] [243] 

.method public [245] : [246] 
    .attribute [244] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     new [36] 
L8:     dup 
L9:     invokespecial [31] 
L12:    putfield [37] 
L15:    aload_0 
L16:    invokespecial [32] 
L19:    aload_0 
L20:    invokespecial [33] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [244] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [16] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [249] : [250] 
    .attribute [244] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [38] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [39] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [40] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [41] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [42] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [244] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     getfield [15] 
L8:     invokevirtual [22] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [244] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [17] 
L9:     aload_2 
L10:    getfield [17] 
L13:    if_icmpne L78 
L16:    aload_0 
L17:    getfield [15] 
L20:    aload_2 
L21:    getfield [15] 
L24:    invokevirtual [23] 
L27:    ifeq L78 
L30:    aload_0 
L31:    getfield [18] 
L34:    aload_2 
L35:    getfield [18] 
L38:    if_icmpne L78 
L41:    aload_0 
L42:    getfield [19] 
L45:    aload_2 
L46:    getfield [19] 
L49:    if_icmpne L78 
L52:    aload_0 
L53:    getfield [20] 
L56:    aload_2 
L57:    getfield [20] 
L60:    if_icmpne L78 
L63:    aload_0 
L64:    getfield [21] 
L67:    aload_2 
L68:    getfield [21] 
L71:    if_icmpne L78 
L74:    iconst_1 
L75:    goto L79 
L78:    iconst_0 
L79:    areturn 
L80:    
    .end code 
.end method 

.method private enum [255] : [256] 
    .attribute [244] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [244] .code stack 3 locals 1 
L0:     new [43] 
L3:     dup 
L4:     invokespecial [35] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [5] 
L11:    invokevirtual [24] 
L14:    pop 
L15:    aload_1 
L16:    new [43] 
L19:    dup 
L20:    invokespecial [35] 
L23:    ldc [6] 
L25:    invokevirtual [24] 
L28:    aload_0 
L29:    getfield [17] 
L32:    invokevirtual [25] 
L35:    invokevirtual [26] 
L38:    invokevirtual [24] 
L41:    pop 
L42:    aload_1 
L43:    new [43] 
L46:    dup 
L47:    invokespecial [35] 
L50:    ldc [7] 
L52:    invokevirtual [24] 
L55:    aload_0 
L56:    getfield [15] 
L59:    invokevirtual [27] 
L62:    invokevirtual [24] 
L65:    invokevirtual [26] 
L68:    invokevirtual [24] 
L71:    pop 
L72:    aload_1 
L73:    new [43] 
L76:    dup 
L77:    invokespecial [35] 
L80:    ldc [8] 
L82:    invokevirtual [24] 
L85:    aload_0 
L86:    getfield [18] 
L89:    invokevirtual [25] 
L92:    invokevirtual [26] 
L95:    invokevirtual [24] 
L98:    pop 
L99:    aload_1 
L100:   new [43] 
L103:   dup 
L104:   invokespecial [35] 
L107:   ldc [9] 
L109:   invokevirtual [24] 
L112:   aload_0 
L113:   getfield [19] 
L116:   invokevirtual [25] 
L119:   invokevirtual [26] 
L122:   invokevirtual [24] 
L125:   pop 
L126:   aload_1 
L127:   new [43] 
L130:   dup 
L131:   invokespecial [35] 
L134:   ldc [10] 
L136:   invokevirtual [24] 
L139:   aload_0 
L140:   getfield [20] 
L143:   invokevirtual [25] 
L146:   invokevirtual [26] 
L149:   invokevirtual [24] 
L152:   pop 
L153:   aload_1 
L154:   new [43] 
L157:   dup 
L158:   invokespecial [35] 
L161:   ldc [11] 
L163:   invokevirtual [24] 
L166:   aload_0 
L167:   getfield [21] 
L170:   invokevirtual [25] 
L173:   invokevirtual [26] 
L176:   invokevirtual [24] 
L179:   pop 
L180:   aload_1 
L181:   invokevirtual [26] 
L184:   areturn 
L185:   nop 
L186:   nop 
L187:   nop 
L188:   
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [244] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [244] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [17] 
L5:     i2b 
L6:     invokeinterface [44] 0 
L11:    aload_0 
L12:    getfield [15] 
L15:    aload_1 
L16:    invokevirtual [28] 
L19:    aload_1 
L20:    aload_0 
L21:    getfield [18] 
L24:    i2b 
L25:    invokeinterface [44] 0 
L30:    aload_1 
L31:    aload_0 
L32:    getfield [19] 
L35:    i2b 
L36:    invokeinterface [44] 0 
L41:    aload_1 
L42:    aload_0 
L43:    getfield [20] 
L46:    i2b 
L47:    invokeinterface [44] 0 
L52:    aload_1 
L53:    aload_0 
L54:    getfield [21] 
L57:    i2b 
L58:    invokeinterface [44] 0 
L63:    return 
L64:    
    .end code 
.end method 

.method public [263] : [264] 
    .attribute [244] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [45] 0 
L7:     putfield [38] 
L10:    aload_0 
L11:    getfield [15] 
L14:    aload_1 
L15:    invokevirtual [29] 
L18:    aload_0 
L19:    aload_1 
L20:    invokeinterface [45] 0 
L25:    putfield [39] 
L28:    aload_0 
L29:    aload_1 
L30:    invokeinterface [45] 0 
L35:    putfield [40] 
L38:    aload_0 
L39:    aload_1 
L40:    invokeinterface [45] 0 
L45:    putfield [41] 
L48:    aload_0 
L49:    aload_1 
L50:    invokeinterface [45] 0 
L55:    putfield [42] 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public static [265] : [266] 
    .attribute [244] .code stack 1 locals 0 
L0:     bipush 29 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [244] .code stack 1 locals 0 
L0:     invokestatic [12] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = Class [47] 
.const [4] = Class [48] 
.const [5] = String [49] 
.const [6] = String [50] 
.const [7] = String [51] 
.const [8] = String [52] 
.const [9] = String [53] 
.const [10] = String [54] 
.const [11] = String [55] 
.const [12] = Method [56] [57] 
.const [13] = Class [58] 
.const [14] = Class [59] 
.const [15] = Field [60] [61] 
.const [16] = Method [62] [63] 
.const [17] = Field [64] [65] 
.const [18] = Field [66] [67] 
.const [19] = Field [68] [69] 
.const [20] = Field [70] [71] 
.const [21] = Field [72] [73] 
.const [22] = Method [74] [75] 
.const [23] = Method [76] [77] 
.const [24] = Method [78] [79] 
.const [25] = Method [80] [81] 
.const [26] = Method [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Method [96] [97] 
.const [34] = Method [98] [99] 
.const [35] = Method [100] [101] 
.const [36] = Class [102] 
.const [37] = Field [103] [104] 
.const [38] = Field [105] [106] 
.const [39] = Field [107] [108] 
.const [40] = Field [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = Class [115] 
.const [44] = InterfaceMethod [116] [117] 
.const [45] = InterfaceMethod [118] [119] 
.const [46] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState 
.const [47] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [48] = Utf8 java/lang/StringBuffer 
.const [49] = Utf8 ConnectionState_Status 
.const [50] = Utf8 '\n - connectionIndication:' 
.const [51] = Utf8 '\n - synchronisationState:' 
.const [52] = Utf8 '\n - extension1:' 
.const [53] = Utf8 '\n - extension2:' 
.const [54] = Utf8 '\n - extension3:' 
.const [55] = Utf8 '\n - extension4:' 
.const [56] = Class [120] 
.const [57] = NameAndType [121] [122] 
.const [58] = Utf8 java/lang/Object 
.const [59] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [60] = Class [123] 
.const [61] = NameAndType [124] [125] 
.const [62] = Class [126] 
.const [63] = NameAndType [127] [128] 
.const [64] = Class [129] 
.const [65] = NameAndType [130] [131] 
.const [66] = Class [132] 
.const [67] = NameAndType [133] [134] 
.const [68] = Class [135] 
.const [69] = NameAndType [136] [137] 
.const [70] = Class [138] 
.const [71] = NameAndType [139] [140] 
.const [72] = Class [141] 
.const [73] = NameAndType [142] [143] 
.const [74] = Class [144] 
.const [75] = NameAndType [145] [146] 
.const [76] = Class [147] 
.const [77] = NameAndType [148] [149] 
.const [78] = Class [150] 
.const [79] = NameAndType [151] [152] 
.const [80] = Class [153] 
.const [81] = NameAndType [154] [155] 
.const [82] = Class [156] 
.const [83] = NameAndType [157] [158] 
.const [84] = Class [159] 
.const [85] = NameAndType [160] [161] 
.const [86] = Class [162] 
.const [87] = NameAndType [163] [164] 
.const [88] = Class [165] 
.const [89] = NameAndType [166] [167] 
.const [90] = Class [168] 
.const [91] = NameAndType [169] [170] 
.const [92] = Class [171] 
.const [93] = NameAndType [172] [173] 
.const [94] = Class [174] 
.const [95] = NameAndType [175] [176] 
.const [96] = Class [177] 
.const [97] = NameAndType [178] [179] 
.const [98] = Class [180] 
.const [99] = NameAndType [181] [182] 
.const [100] = Class [183] 
.const [101] = NameAndType [184] [185] 
.const [102] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState 
.const [103] = Class [186] 
.const [104] = NameAndType [187] [188] 
.const [105] = Class [189] 
.const [106] = NameAndType [190] [191] 
.const [107] = Class [192] 
.const [108] = NameAndType [193] [194] 
.const [109] = Class [195] 
.const [110] = NameAndType [196] [197] 
.const [111] = Class [198] 
.const [112] = NameAndType [199] [200] 
.const [113] = Class [201] 
.const [114] = NameAndType [202] [203] 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Class [204] 
.const [117] = NameAndType [205] [206] 
.const [118] = Class [207] 
.const [119] = NameAndType [208] [209] 
.const [120] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [121] = Utf8 functionId 
.const [122] = Utf8 ()I 
.const [123] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [124] = Utf8 synchronisationState 
.const [125] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState; 
.const [126] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [127] = Utf8 deserialize 
.const [128] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [129] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [130] = Utf8 connectionIndication 
.const [131] = Utf8 I 
.const [132] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [133] = Utf8 extension1 
.const [134] = Utf8 I 
.const [135] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [136] = Utf8 extension2 
.const [137] = Utf8 I 
.const [138] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [139] = Utf8 extension3 
.const [140] = Utf8 I 
.const [141] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [142] = Utf8 extension4 
.const [143] = Utf8 I 
.const [144] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState 
.const [145] = Utf8 reset 
.const [146] = Utf8 ()V 
.const [147] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState 
.const [148] = Utf8 equalTo 
.const [149] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 append 
.const [152] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 append 
.const [155] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 toString 
.const [158] = Utf8 ()Ljava/lang/String; 
.const [159] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState 
.const [160] = Utf8 toString 
.const [161] = Utf8 ()Ljava/lang/String; 
.const [162] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState 
.const [163] = Utf8 serialize 
.const [164] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [165] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState 
.const [166] = Utf8 deserialize 
.const [167] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [168] = Utf8 java/lang/Object 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState 
.const [172] = Utf8 <init> 
.const [173] = Utf8 ()V 
.const [174] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [175] = Utf8 internalReset 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [178] = Utf8 customInitialization 
.const [179] = Utf8 ()V 
.const [180] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [181] = Utf8 <init> 
.const [182] = Utf8 ()V 
.const [183] = Utf8 java/lang/StringBuffer 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [187] = Utf8 synchronisationState 
.const [188] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState; 
.const [189] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [190] = Utf8 connectionIndication 
.const [191] = Utf8 I 
.const [192] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [193] = Utf8 extension1 
.const [194] = Utf8 I 
.const [195] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [196] = Utf8 extension2 
.const [197] = Utf8 I 
.const [198] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [199] = Utf8 extension3 
.const [200] = Utf8 I 
.const [201] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [202] = Utf8 extension4 
.const [203] = Utf8 I 
.const [204] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [205] = Utf8 pushByte 
.const [206] = Utf8 (B)V 
.const [207] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [208] = Utf8 popFrontByte 
.const [209] = Utf8 ()I 
.const [210] = Utf8 de/vw/mib/bap/generated/eni/serializer/ConnectionState_Status 
.const [211] = Class [210] 
.const [212] = Utf8 java/lang/Object 
.const [213] = Class [212] 
.const [214] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [215] = Class [214] 
.const [216] = Utf8 connectionIndication 
.const [217] = Utf8 I 
.const [218] = Utf8 CONNECTION_INDICATION_INFORMATION_ABOUT_DATA_CONNECTING_IS_NOT_AVAILABLE 
.const [219] = Utf8 I 
.const [220] = Utf8 CONNECTION_INDICATION_NO_DATA_CONNECTION_ACTIVE 
.const [221] = Utf8 I 
.const [222] = Utf8 CONNECTION_INDICATION_DATA_CONNECTION_ACTIVE 
.const [223] = Utf8 I 
.const [224] = Utf8 CONNECTION_INDICATION_INITIALIZING 
.const [225] = Utf8 I 
.const [226] = Utf8 synchronisationState 
.const [227] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/ConnectionState_SynchronisationState; 
.const [228] = Utf8 extension1 
.const [229] = Utf8 I 
.const [230] = Utf8 EXTENSION1_MIN 
.const [231] = Utf8 I 
.const [232] = Utf8 extension2 
.const [233] = Utf8 I 
.const [234] = Utf8 EXTENSION2_MIN 
.const [235] = Utf8 I 
.const [236] = Utf8 extension3 
.const [237] = Utf8 I 
.const [238] = Utf8 EXTENSION3_MIN 
.const [239] = Utf8 I 
.const [240] = Utf8 extension4 
.const [241] = Utf8 I 
.const [242] = Utf8 EXTENSION4_MIN 
.const [243] = Utf8 I 
.const [244] = Utf8 Code 
.const [245] = Utf8 <init> 
.const [246] = Utf8 ()V 
.const [247] = Utf8 <init> 
.const [248] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [249] = Utf8 internalReset 
.const [250] = Utf8 ()V 
.const [251] = Utf8 reset 
.const [252] = Utf8 ()V 
.const [253] = Utf8 equalTo 
.const [254] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [255] = Utf8 customInitialization 
.const [256] = Utf8 ()V 
.const [257] = Utf8 toString 
.const [258] = Utf8 ()Ljava/lang/String; 
.const [259] = Utf8 bitSize 
.const [260] = Utf8 ()I 
.const [261] = Utf8 serialize 
.const [262] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [263] = Utf8 deserialize 
.const [264] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [265] = Utf8 functionId 
.const [266] = Utf8 ()I 
.const [267] = Utf8 getFunctionId 
.const [268] = Utf8 ()I 
.end class 
