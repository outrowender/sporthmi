.version 50 0 
.class public final super [187] 
.super [189] 
.implements [191] 
.field public [192] [193] 
.field private static final [194] [195] 
.field public static final [196] [197] 
.field public static final [198] [199] 
.field public static final [200] [201] 
.field public static final [202] [203] 
.field public static final [204] [205] 
.field public [206] [207] 
.field private static final [208] [209] 
.field private [210] [211] 

.method public [213] : [214] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     bipush 7 
L6:     iand 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [212] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [18] 
L5:     bipush 8 
L7:     iand 
L8:     iload_1 
L9:     bipush 7 
L11:    iand 
L12:    ior 
L13:    putfield [37] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     iconst_3 
L5:     iushr 
L6:     iconst_1 
L7:     if_icmpne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     ifeq L15 
L5:     aload_0 
L6:     getfield [18] 
L9:     bipush 8 
L11:    ior 
L12:    goto L22 
L15:    aload_0 
L16:    getfield [18] 
L19:    bipush 7 
L21:    iand 
L22:    putfield [37] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [221] : [222] 
    .attribute [212] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [38] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [39] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [227] : [228] 
    .attribute [212] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     new [40] 
L8:     dup 
L9:     invokespecial [32] 
L12:    putfield [39] 
L15:    aload_0 
L16:    invokespecial [33] 
L19:    aload_0 
L20:    invokespecial [34] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [21] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [233] : [234] 
    .attribute [212] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [37] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [38] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [212] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     getfield [20] 
L8:     invokevirtual [22] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [212] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [18] 
L9:     aload_2 
L10:    getfield [18] 
L13:    if_icmpne L45 
L16:    aload_0 
L17:    getfield [19] 
L20:    aload_2 
L21:    getfield [19] 
L24:    if_icmpne L45 
L27:    aload_0 
L28:    getfield [20] 
L31:    aload_2 
L32:    getfield [20] 
L35:    invokevirtual [23] 
L38:    ifeq L45 
L41:    iconst_1 
L42:    goto L46 
L45:    iconst_0 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method private enum [239] : [240] 
    .attribute [212] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [212] .code stack 2 locals 1 
L0:     new [41] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [5] 
L11:    invokevirtual [24] 
L14:    pop 
L15:    aload_1 
L16:    ldc [6] 
L18:    invokevirtual [24] 
L21:    pop 
L22:    aload_0 
L23:    getfield [18] 
L26:    tableswitch 0 
            L88 
            L98 
            L138 
            L108 
            L138 
            L138 
            L138 
            L138 
            L138 
            L118 
            L138 
            L128 
            default : L138 

L88:    aload_1 
L89:    ldc [7] 
L91:    invokevirtual [24] 
L94:    pop 
L95:    goto L145 
L98:    aload_1 
L99:    ldc [8] 
L101:   invokevirtual [24] 
L104:   pop 
L105:   goto L145 
L108:   aload_1 
L109:   ldc [9] 
L111:   invokevirtual [24] 
L114:   pop 
L115:   goto L145 
L118:   aload_1 
L119:   ldc [10] 
L121:   invokevirtual [24] 
L124:   pop 
L125:   goto L145 
L128:   aload_1 
L129:   ldc [11] 
L131:   invokevirtual [24] 
L134:   pop 
L135:   goto L145 
L138:   aload_1 
L139:   ldc [12] 
L141:   invokevirtual [24] 
L144:   pop 
L145:   aload_1 
L146:   ldc [13] 
L148:   invokevirtual [24] 
L151:   pop 
L152:   aload_1 
L153:   aload_0 
L154:   getfield [19] 
L157:   invokevirtual [25] 
L160:   pop 
L161:   aload_1 
L162:   ldc [14] 
L164:   invokevirtual [24] 
L167:   pop 
L168:   aload_1 
L169:   aload_0 
L170:   getfield [20] 
L173:   invokevirtual [26] 
L176:   invokevirtual [24] 
L179:   pop 
L180:   aload_1 
L181:   invokevirtual [27] 
L184:   areturn 
L185:   nop 
L186:   nop 
L187:   nop 
L188:   
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [212] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 4 
L5:     iinc 1 4 
L8:     iload_1 
L9:     aload_0 
L10:    getfield [20] 
L13:    invokevirtual [28] 
L16:    iadd 
L17:    istore_1 
L18:    iload_1 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_1 
L1:     iconst_4 
L2:     aload_0 
L3:     getfield [18] 
L6:     invokeinterface [42] 0 
L11:    aload_1 
L12:    iconst_4 
L13:    aload_0 
L14:    getfield [19] 
L17:    invokeinterface [42] 0 
L22:    aload_0 
L23:    getfield [20] 
L26:    aload_1 
L27:    invokevirtual [29] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [212] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_4 
L3:     invokeinterface [43] 0 
L8:     putfield [37] 
L11:    aload_0 
L12:    aload_1 
L13:    iconst_4 
L14:    invokeinterface [43] 0 
L19:    putfield [38] 
L22:    aload_0 
L23:    getfield [20] 
L26:    aload_1 
L27:    invokevirtual [30] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public static [249] : [250] 
    .attribute [212] .code stack 1 locals 0 
L0:     bipush 52 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [212] .code stack 1 locals 0 
L0:     invokestatic [15] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [44] 
.const [3] = Class [45] 
.const [4] = Class [46] 
.const [5] = String [47] 
.const [6] = String [48] 
.const [7] = String [49] 
.const [8] = String [50] 
.const [9] = String [51] 
.const [10] = String [52] 
.const [11] = String [53] 
.const [12] = String [54] 
.const [13] = String [55] 
.const [14] = String [56] 
.const [15] = Method [57] [58] 
.const [16] = Class [59] 
.const [17] = Class [60] 
.const [18] = Field [61] [62] 
.const [19] = Field [63] [64] 
.const [20] = Field [65] [66] 
.const [21] = Method [67] [68] 
.const [22] = Method [69] [70] 
.const [23] = Method [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Method [93] [94] 
.const [35] = Method [95] [96] 
.const [36] = Method [97] [98] 
.const [37] = Field [99] [100] 
.const [38] = Field [101] [102] 
.const [39] = Field [103] [104] 
.const [40] = Class [105] 
.const [41] = Class [106] 
.const [42] = InterfaceMethod [107] [108] 
.const [43] = InterfaceMethod [109] [110] 
.const [44] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader 
.const [45] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [46] = Utf8 java/lang/StringBuffer 
.const [47] = Utf8 'POI_List_GetArray:' 
.const [48] = Utf8 '\n - ASG_ID: ' 
.const [49] = Utf8 '0x0 (default ASG (any ASG, spontaneous FSG message))' 
.const [50] = Utf8 '0x1 (instrument cluster)' 
.const [51] = Utf8 '0x3 (operating unit rear (DF4.2) )' 
.const [52] = Utf8 '0x9 (instrument cluster, to be evaluated by all ASGs)' 
.const [53] = Utf8 '0xB (operating unit rear, to be evaluated by all ASGs (DF4.2) )' 
.const [54] = Utf8 'UNKNOWN ENUM' 
.const [55] = Utf8 '\n - TAID - ' 
.const [56] = Utf8 '\n - ArrayHeader - ' 
.const [57] = Class [111] 
.const [58] = NameAndType [112] [113] 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [61] = Class [114] 
.const [62] = NameAndType [115] [116] 
.const [63] = Class [117] 
.const [64] = NameAndType [118] [119] 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Class [123] 
.const [68] = NameAndType [124] [125] 
.const [69] = Class [126] 
.const [70] = NameAndType [127] [128] 
.const [71] = Class [129] 
.const [72] = NameAndType [130] [131] 
.const [73] = Class [132] 
.const [74] = NameAndType [133] [134] 
.const [75] = Class [135] 
.const [76] = NameAndType [136] [137] 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Class [147] 
.const [84] = NameAndType [148] [149] 
.const [85] = Class [150] 
.const [86] = NameAndType [151] [152] 
.const [87] = Class [153] 
.const [88] = NameAndType [154] [155] 
.const [89] = Class [156] 
.const [90] = NameAndType [157] [158] 
.const [91] = Class [159] 
.const [92] = NameAndType [160] [161] 
.const [93] = Class [162] 
.const [94] = NameAndType [163] [164] 
.const [95] = Class [165] 
.const [96] = NameAndType [166] [167] 
.const [97] = Class [168] 
.const [98] = NameAndType [169] [170] 
.const [99] = Class [171] 
.const [100] = NameAndType [172] [173] 
.const [101] = Class [174] 
.const [102] = NameAndType [175] [176] 
.const [103] = Class [177] 
.const [104] = NameAndType [178] [179] 
.const [105] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader 
.const [106] = Utf8 java/lang/StringBuffer 
.const [107] = Class [180] 
.const [108] = NameAndType [181] [182] 
.const [109] = Class [183] 
.const [110] = NameAndType [184] [185] 
.const [111] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [112] = Utf8 functionId 
.const [113] = Utf8 ()I 
.const [114] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [115] = Utf8 asg_Id 
.const [116] = Utf8 I 
.const [117] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [118] = Utf8 taid 
.const [119] = Utf8 I 
.const [120] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [121] = Utf8 arrayHeader 
.const [122] = Utf8 Lde/vw/mib/bap/datatypes/ArrayHeader; 
.const [123] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [124] = Utf8 deserialize 
.const [125] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [126] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader 
.const [127] = Utf8 reset 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader 
.const [130] = Utf8 equalTo 
.const [131] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 append 
.const [134] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [135] = Utf8 java/lang/StringBuffer 
.const [136] = Utf8 append 
.const [137] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [138] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader 
.const [139] = Utf8 toString 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 java/lang/StringBuffer 
.const [142] = Utf8 toString 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader 
.const [145] = Utf8 bitSize 
.const [146] = Utf8 ()I 
.const [147] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader 
.const [148] = Utf8 serialize 
.const [149] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [150] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader 
.const [151] = Utf8 deserialize 
.const [152] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [153] = Utf8 java/lang/Object 
.const [154] = Utf8 <init> 
.const [155] = Utf8 ()V 
.const [156] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [160] = Utf8 internalReset 
.const [161] = Utf8 ()V 
.const [162] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [163] = Utf8 customInitialization 
.const [164] = Utf8 ()V 
.const [165] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [166] = Utf8 <init> 
.const [167] = Utf8 ()V 
.const [168] = Utf8 java/lang/StringBuffer 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [172] = Utf8 asg_Id 
.const [173] = Utf8 I 
.const [174] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [175] = Utf8 taid 
.const [176] = Utf8 I 
.const [177] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [178] = Utf8 arrayHeader 
.const [179] = Utf8 Lde/vw/mib/bap/datatypes/ArrayHeader; 
.const [180] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [181] = Utf8 pushBits 
.const [182] = Utf8 (II)V 
.const [183] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [184] = Utf8 popFrontBits 
.const [185] = Utf8 (I)I 
.const [186] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_List_GetArray 
.const [187] = Class [186] 
.const [188] = Utf8 java/lang/Object 
.const [189] = Class [188] 
.const [190] = Utf8 de/vw/mib/bap/array/requests/BAPGetArray 
.const [191] = Class [190] 
.const [192] = Utf8 asg_Id 
.const [193] = Utf8 I 
.const [194] = Utf8 ASG_ID_BITSIZE 
.const [195] = Utf8 I 
.const [196] = Utf8 ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE 
.const [197] = Utf8 I 
.const [198] = Utf8 ASG_ID_INSTRUMENT_CLUSTER 
.const [199] = Utf8 I 
.const [200] = Utf8 ASG_ID_OPERATING_UNIT_REAR_DF4_2 
.const [201] = Utf8 I 
.const [202] = Utf8 ASG_ID_INSTRUMENT_CLUSTER_TO_BE_EVALUATED_BY_ALL_ASGS 
.const [203] = Utf8 I 
.const [204] = Utf8 ASG_ID_OPERATING_UNIT_REAR_TO_BE_EVALUATED_BY_ALL_ASGS 
.const [205] = Utf8 I 
.const [206] = Utf8 taid 
.const [207] = Utf8 I 
.const [208] = Utf8 TAID_BITSIZE 
.const [209] = Utf8 I 
.const [210] = Utf8 arrayHeader 
.const [211] = Utf8 Lde/vw/mib/bap/datatypes/ArrayHeader; 
.const [212] = Utf8 Code 
.const [213] = Utf8 getAsgId 
.const [214] = Utf8 ()I 
.const [215] = Utf8 setAsgId 
.const [216] = Utf8 (I)V 
.const [217] = Utf8 isBroadcast 
.const [218] = Utf8 ()Z 
.const [219] = Utf8 setBroadcast 
.const [220] = Utf8 (Z)V 
.const [221] = Utf8 getTransactionId 
.const [222] = Utf8 ()I 
.const [223] = Utf8 setTransactionId 
.const [224] = Utf8 (I)V 
.const [225] = Utf8 setArrayHeader 
.const [226] = Utf8 (Lde/vw/mib/bap/datatypes/ArrayHeader;)V 
.const [227] = Utf8 getArrayHeader 
.const [228] = Utf8 ()Lde/vw/mib/bap/datatypes/ArrayHeader; 
.const [229] = Utf8 <init> 
.const [230] = Utf8 ()V 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [233] = Utf8 internalReset 
.const [234] = Utf8 ()V 
.const [235] = Utf8 reset 
.const [236] = Utf8 ()V 
.const [237] = Utf8 equalTo 
.const [238] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [239] = Utf8 customInitialization 
.const [240] = Utf8 ()V 
.const [241] = Utf8 toString 
.const [242] = Utf8 ()Ljava/lang/String; 
.const [243] = Utf8 bitSize 
.const [244] = Utf8 ()I 
.const [245] = Utf8 serialize 
.const [246] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [247] = Utf8 deserialize 
.const [248] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [249] = Utf8 functionId 
.const [250] = Utf8 ()I 
.const [251] = Utf8 getFunctionId 
.const [252] = Utf8 ()I 
.end class 
