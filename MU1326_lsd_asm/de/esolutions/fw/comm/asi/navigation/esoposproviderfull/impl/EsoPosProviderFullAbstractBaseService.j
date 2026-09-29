.version 50 0 
.class public super abstract [220] 
.super [222] 
.implements [224] 
.field private static final [225] [226] 
.field private static final [227] [228] 
.field private [229] [230] 
.field private [231] [232] 
.field private [233] [234] 

.method public static [236] : [237] 
    .attribute [235] .code stack 3 locals 0 
L0:     aload_0 
L1:     ifnull L13 
L4:     new [40] 
L7:     dup 
L8:     aload_0 
L9:     invokespecial [32] 
L12:    areturn 
L13:    aconst_null 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [238] : [239] 
    .attribute [235] .code stack 5 locals 1 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [41] 
L9:     new [42] 
L12:    dup 
L13:    invokespecial [34] 
L16:    astore_1 
L17:    aload_0 
L18:    new [43] 
L21:    dup 
L22:    ldc [5] 
L24:    aload_1 
L25:    invokespecial [35] 
L28:    putfield [44] 
L31:    return 
L32:    
    .end code 
.end method 

.method public synchronized [240] : [241] 
    .attribute [235] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     lload_1 
L5:     aload_3 
L6:     invokevirtual [22] 
L9:     aload_0 
L10:    lload_1 
L11:    aload_3 
L12:    invokespecial [36] 
L15:    return 
L16:    
    .end code 
.end method 

.method public synchronized [242] : [243] 
    .attribute [235] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_1 
L5:     invokevirtual [23] 
L8:     aload_0 
L9:     aload_1 
L10:    invokespecial [37] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [244] : [245] 
    .attribute [235] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_1 
L5:     aload_2 
L6:     invokevirtual [24] 
L9:     aload_0 
L10:    aload_1 
L11:    aload_2 
L12:    invokespecial [38] 
L15:    return 
L16:    
    .end code 
.end method 

.method public synchronized [246] : [247] 
    .attribute [235] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     lload_1 
L5:     aload_3 
L6:     invokevirtual [25] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [248] : [249] 
    .attribute [235] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_1 
L5:     invokevirtual [26] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [250] : [251] 
    .attribute [235] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_1 
L5:     aload_2 
L6:     invokevirtual [27] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [252] : [253] 
    .attribute [235] .code stack 3 locals 1 
        .catch [6] from L0 to L14 using L17 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [28] 
L5:     aload_0 
L6:     getfield [20] 
L9:     invokeinterface [46] 0 
L14:    goto L18 
L17:    astore_2 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [254] : [255] 
    .attribute [235] .code stack 4 locals 1 
L0:     iconst_0 
L1:     istore_3 
L2:     iload_3 
L3:     aload_1 
L4:     arraylength 
L5:     if_icmpge L22 
L8:     aload_0 
L9:     aload_1 
L10:    iload_3 
L11:    laload 
L12:    aload_2 
L13:    invokespecial [36] 
L16:    iinc 3 1 
L19:    goto L2 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [256] : [257] 
    .attribute [235] .code stack 4 locals 1 
        .catch [6] from L0 to L33 using L36 
L0:     lload_1 
L1:     ldc_w [1] 
L4:     lcmp 
L5:     ifne L25 
L8:     aload_3 
L9:     aload_0 
L10:    getfield [28] 
L13:    aload_0 
L14:    getfield [20] 
L17:    invokeinterface [46] 0 
L22:    goto L33 
L25:    getstatic [7] 
L28:    ldc [8] 
L30:    invokevirtual [29] 
L33:    goto L38 
L36:    astore 4 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [258] : [259] 
    .attribute [235] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokevirtual [30] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [260] : [261] 
    .attribute [235] .code stack 3 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic [9] 
L5:     putfield [45] 
L8:     aload_0 
L9:     iload_2 
L10:    putfield [41] 
L13:    aload_0 
L14:    getfield [21] 
L17:    bipush 19 
L19:    invokevirtual [31] 
L22:    astore_3 
L23:    aload_3 
L24:    invokeinterface [47] 0 
L29:    astore 4 
L31:    aload 4 
L33:    invokeinterface [48] 0 
L38:    ifeq L70 
L41:    aload 4 
L43:    invokeinterface [49] 0 
L48:    checkcast [10] 
L51:    astore 5 
        .catch [6] from L53 to L62 using L65 
L53:    aload 5 
L55:    aload_1 
L56:    iload_2 
L57:    invokeinterface [46] 0 
L62:    goto L67 
L65:    astore 6 
L67:    goto L31 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method static [262] : [263] 
    .attribute [235] .code stack 1 locals 0 
L0:     ldc [11] 
L2:     invokestatic [12] 
L5:     putstatic [39] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [51] 
.const [3] = Class [52] 
.const [4] = Class [53] 
.const [5] = String [54] 
.const [6] = Class [55] 
.const [7] = Field [56] [57] 
.const [8] = String [58] 
.const [9] = Method [59] [60] 
.const [10] = Class [61] 
.const [11] = String [62] 
.const [12] = Method [63] [64] 
.const [13] = Class [65] 
.const [14] = Class [66] 
.const [15] = Class [67] 
.const [16] = Class [68] 
.const [17] = Class [69] 
.const [18] = Class [70] 
.const [19] = Class [71] 
.const [20] = Field [72] [73] 
.const [21] = Field [74] [75] 
.const [22] = Method [76] [77] 
.const [23] = Method [78] [79] 
.const [24] = Method [80] [81] 
.const [25] = Method [82] [83] 
.const [26] = Method [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Field [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Field [110] [111] 
.const [40] = Class [112] 
.const [41] = Field [113] [114] 
.const [42] = Class [115] 
.const [43] = Class [116] 
.const [44] = Field [117] [118] 
.const [45] = Field [119] [120] 
.const [46] = InterfaceMethod [121] [122] 
.const [47] = InterfaceMethod [123] [124] 
.const [48] = InterfaceMethod [125] [126] 
.const [49] = InterfaceMethod [127] [128] 
.const [50] = Int 318767104 
.const [51] = Utf8 java/lang/String 
.const [52] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService$AttributesBitMapProvider 
.const [53] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [54] = Utf8 EsoPosProviderFull 
.const [55] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [56] = Class [129] 
.const [57] = NameAndType [130] [131] 
.const [58] = Utf8 unexpected 
.const [59] = Class [132] 
.const [60] = NameAndType [133] [134] 
.const [61] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply 
.const [62] = Utf8 'ABSTRACTBASESERVICE.asi.navigation.esoposproviderfull.EsoPosProviderFull' 
.const [63] = Class [135] 
.const [64] = NameAndType [136] [137] 
.const [65] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [66] = Utf8 java/lang/Object 
.const [67] = Utf8 java/lang/System 
.const [68] = Utf8 java/io/PrintStream 
.const [69] = Utf8 java/util/List 
.const [70] = Utf8 java/util/Iterator 
.const [71] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [72] = Class [138] 
.const [73] = NameAndType [139] [140] 
.const [74] = Class [141] 
.const [75] = NameAndType [142] [143] 
.const [76] = Class [144] 
.const [77] = NameAndType [145] [146] 
.const [78] = Class [147] 
.const [79] = NameAndType [148] [149] 
.const [80] = Class [150] 
.const [81] = NameAndType [151] [152] 
.const [82] = Class [153] 
.const [83] = NameAndType [154] [155] 
.const [84] = Class [156] 
.const [85] = NameAndType [157] [158] 
.const [86] = Class [159] 
.const [87] = NameAndType [160] [161] 
.const [88] = Class [162] 
.const [89] = NameAndType [163] [164] 
.const [90] = Class [165] 
.const [91] = NameAndType [166] [167] 
.const [92] = Class [168] 
.const [93] = NameAndType [169] [170] 
.const [94] = Class [171] 
.const [95] = NameAndType [172] [173] 
.const [96] = Class [174] 
.const [97] = NameAndType [175] [176] 
.const [98] = Class [177] 
.const [99] = NameAndType [178] [179] 
.const [100] = Class [180] 
.const [101] = NameAndType [181] [182] 
.const [102] = Class [183] 
.const [103] = NameAndType [184] [185] 
.const [104] = Class [186] 
.const [105] = NameAndType [187] [188] 
.const [106] = Class [189] 
.const [107] = NameAndType [190] [191] 
.const [108] = Class [192] 
.const [109] = NameAndType [193] [194] 
.const [110] = Class [195] 
.const [111] = NameAndType [196] [197] 
.const [112] = Utf8 java/lang/String 
.const [113] = Class [198] 
.const [114] = NameAndType [199] [200] 
.const [115] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService$AttributesBitMapProvider 
.const [116] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [117] = Class [201] 
.const [118] = NameAndType [202] [203] 
.const [119] = Class [204] 
.const [120] = NameAndType [205] [206] 
.const [121] = Class [207] 
.const [122] = NameAndType [208] [209] 
.const [123] = Class [210] 
.const [124] = NameAndType [211] [212] 
.const [125] = Class [213] 
.const [126] = NameAndType [214] [215] 
.const [127] = Class [216] 
.const [128] = NameAndType [217] [218] 
.const [129] = Utf8 java/lang/System 
.const [130] = Utf8 out 
.const [131] = Utf8 Ljava/io/PrintStream; 
.const [132] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [133] = Utf8 copyString 
.const [134] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [135] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [136] = Utf8 getContext 
.const [137] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [138] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [139] = Utf8 ASIVersion_valid 
.const [140] = Utf8 Z 
.const [141] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [142] = Utf8 baseService 
.const [143] = Utf8 Lde/esolutions/fw/comm/attributes/AttributesBaseService; 
.const [144] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [145] = Utf8 setNotification 
.const [146] = Utf8 (JLjava/lang/Object;)V 
.const [147] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [148] = Utf8 setNotification 
.const [149] = Utf8 (Ljava/lang/Object;)V 
.const [150] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [151] = Utf8 setNotification 
.const [152] = Utf8 ([JLjava/lang/Object;)V 
.const [153] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [154] = Utf8 clearNotification 
.const [155] = Utf8 (JLjava/lang/Object;)V 
.const [156] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [157] = Utf8 clearNotification 
.const [158] = Utf8 (Ljava/lang/Object;)V 
.const [159] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [160] = Utf8 clearNotification 
.const [161] = Utf8 ([JLjava/lang/Object;)V 
.const [162] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [163] = Utf8 ASIVersion 
.const [164] = Utf8 Ljava/lang/String; 
.const [165] = Utf8 java/io/PrintStream 
.const [166] = Utf8 println 
.const [167] = Utf8 (Ljava/lang/String;)V 
.const [168] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [169] = Utf8 updateASIVersion 
.const [170] = Utf8 (Ljava/lang/String;Z)V 
.const [171] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [172] = Utf8 getNotifications 
.const [173] = Utf8 (I)Ljava/util/List; 
.const [174] = Utf8 java/lang/String 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Ljava/lang/String;)V 
.const [177] = Utf8 java/lang/Object 
.const [178] = Utf8 <init> 
.const [179] = Utf8 ()V 
.const [180] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService$AttributesBitMapProvider 
.const [181] = Utf8 <init> 
.const [182] = Utf8 ()V 
.const [183] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/attributes/IAttributeBitMapProvider;)V 
.const [186] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [187] = Utf8 sendAttributeUpdate 
.const [188] = Utf8 (JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [189] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [190] = Utf8 sendAttributeUpdate 
.const [191] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [192] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [193] = Utf8 sendAttributeUpdate 
.const [194] = Utf8 ([JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [195] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [196] = Utf8 context 
.const [197] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [198] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [199] = Utf8 ASIVersion_valid 
.const [200] = Utf8 Z 
.const [201] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [202] = Utf8 baseService 
.const [203] = Utf8 Lde/esolutions/fw/comm/attributes/AttributesBaseService; 
.const [204] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [205] = Utf8 ASIVersion 
.const [206] = Utf8 Ljava/lang/String; 
.const [207] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply 
.const [208] = Utf8 updateASIVersion 
.const [209] = Utf8 (Ljava/lang/String;Z)V 
.const [210] = Utf8 java/util/List 
.const [211] = Utf8 iterator 
.const [212] = Utf8 ()Ljava/util/Iterator; 
.const [213] = Utf8 java/util/Iterator 
.const [214] = Utf8 hasNext 
.const [215] = Utf8 ()Z 
.const [216] = Utf8 java/util/Iterator 
.const [217] = Utf8 next 
.const [218] = Utf8 ()Ljava/lang/Object; 
.const [219] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/impl/EsoPosProviderFullAbstractBaseService 
.const [220] = Class [219] 
.const [221] = Utf8 java/lang/Object 
.const [222] = Class [221] 
.const [223] = Utf8 de/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullS 
.const [224] = Class [223] 
.const [225] = Utf8 context 
.const [226] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [227] = Utf8 attributesCount 
.const [228] = Utf8 I 
.const [229] = Utf8 ASIVersion 
.const [230] = Utf8 Ljava/lang/String; 
.const [231] = Utf8 ASIVersion_valid 
.const [232] = Utf8 Z 
.const [233] = Utf8 baseService 
.const [234] = Utf8 Lde/esolutions/fw/comm/attributes/AttributesBaseService; 
.const [235] = Utf8 Code 
.const [236] = Utf8 copyString 
.const [237] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [238] = Utf8 <init> 
.const [239] = Utf8 ()V 
.const [240] = Utf8 setNotification 
.const [241] = Utf8 (JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [242] = Utf8 setNotification 
.const [243] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [244] = Utf8 setNotification 
.const [245] = Utf8 ([JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [246] = Utf8 clearNotification 
.const [247] = Utf8 (JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [248] = Utf8 clearNotification 
.const [249] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [250] = Utf8 clearNotification 
.const [251] = Utf8 ([JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [252] = Utf8 sendAttributeUpdate 
.const [253] = Utf8 (Lde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [254] = Utf8 sendAttributeUpdate 
.const [255] = Utf8 ([JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [256] = Utf8 sendAttributeUpdate 
.const [257] = Utf8 (JLde/esolutions/fw/comm/asi/navigation/esoposproviderfull/EsoPosProviderFullReply;)V 
.const [258] = Utf8 updateASIVersion 
.const [259] = Utf8 (Ljava/lang/String;)V 
.const [260] = Utf8 updateASIVersion 
.const [261] = Utf8 (Ljava/lang/String;Z)V 
.const [262] = Utf8 <clinit> 
.const [263] = Utf8 ()V 
.end class 
