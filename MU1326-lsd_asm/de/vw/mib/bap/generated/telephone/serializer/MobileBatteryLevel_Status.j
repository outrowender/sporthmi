.version 50 0 
.class public final super [203] 
.super [205] 
.implements [207] 
.field public [208] [209] 
.field private static final [210] [211] 
.field public [212] [213] 
.field private static final [214] [215] 
.field public [216] [217] 
.field private static final [218] [219] 
.field public [220] [221] 
.field private static final [222] [223] 
.field public final [224] [225] 

.method public [227] : [228] 
    .attribute [226] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     new [35] 
L8:     dup 
L9:     invokespecial [30] 
L12:    putfield [36] 
L15:    aload_0 
L16:    invokespecial [31] 
L19:    aload_0 
L20:    invokespecial [32] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [226] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [231] : [232] 
    .attribute [226] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [37] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [38] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [39] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [40] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [226] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     getfield [14] 
L8:     invokevirtual [20] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [226] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [16] 
L9:     aload_2 
L10:    getfield [16] 
L13:    if_icmpne L67 
L16:    aload_0 
L17:    getfield [17] 
L20:    aload_2 
L21:    getfield [17] 
L24:    if_icmpne L67 
L27:    aload_0 
L28:    getfield [18] 
L31:    aload_2 
L32:    getfield [18] 
L35:    if_icmpne L67 
L38:    aload_0 
L39:    getfield [19] 
L42:    aload_2 
L43:    getfield [19] 
L46:    if_icmpne L67 
L49:    aload_0 
L50:    getfield [14] 
L53:    aload_2 
L54:    getfield [14] 
L57:    invokevirtual [21] 
L60:    ifeq L67 
L63:    iconst_1 
L64:    goto L68 
L67:    iconst_0 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method private enum [237] : [238] 
    .attribute [226] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [226] .code stack 2 locals 1 
L0:     new [41] 
L3:     dup 
L4:     invokespecial [34] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [5] 
L11:    invokevirtual [22] 
L14:    pop 
L15:    aload_1 
L16:    ldc [6] 
L18:    invokevirtual [22] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [16] 
L27:    invokevirtual [23] 
L30:    pop 
L31:    aload_1 
L32:    ldc [7] 
L34:    invokevirtual [22] 
L37:    pop 
L38:    aload_1 
L39:    aload_0 
L40:    getfield [17] 
L43:    invokevirtual [23] 
L46:    pop 
L47:    aload_1 
L48:    ldc [8] 
L50:    invokevirtual [22] 
L53:    pop 
L54:    aload_1 
L55:    aload_0 
L56:    getfield [18] 
L59:    invokevirtual [23] 
L62:    pop 
L63:    aload_1 
L64:    ldc [9] 
L66:    invokevirtual [22] 
L69:    pop 
L70:    aload_1 
L71:    aload_0 
L72:    getfield [19] 
L75:    invokevirtual [23] 
L78:    pop 
L79:    aload_1 
L80:    ldc [10] 
L82:    invokevirtual [22] 
L85:    pop 
L86:    aload_1 
L87:    aload_0 
L88:    getfield [14] 
L91:    invokevirtual [24] 
L94:    invokevirtual [22] 
L97:    pop 
L98:    aload_1 
L99:    invokevirtual [25] 
L102:   areturn 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [226] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 8 
L8:     iinc 1 8 
L11:    iinc 1 8 
L14:    iload_1 
L15:    aload_0 
L16:    getfield [14] 
L19:    invokevirtual [26] 
L22:    iadd 
L23:    istore_1 
L24:    iload_1 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [226] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [16] 
L5:     i2b 
L6:     invokeinterface [42] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [17] 
L16:    i2b 
L17:    invokeinterface [42] 0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [18] 
L27:    i2b 
L28:    invokeinterface [42] 0 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [19] 
L38:    i2b 
L39:    invokeinterface [42] 0 
L44:    aload_0 
L45:    getfield [14] 
L48:    aload_1 
L49:    invokevirtual [27] 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [226] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [43] 0 
L7:     putfield [37] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [43] 0 
L17:    putfield [38] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [43] 0 
L27:    putfield [39] 
L30:    aload_0 
L31:    aload_1 
L32:    invokeinterface [43] 0 
L37:    putfield [40] 
L40:    aload_0 
L41:    getfield [14] 
L44:    aload_1 
L45:    invokevirtual [28] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [247] : [248] 
    .attribute [226] .code stack 1 locals 0 
L0:     bipush 43 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [226] .code stack 1 locals 0 
L0:     invokestatic [11] 
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
.const [11] = Method [53] [54] 
.const [12] = Class [55] 
.const [13] = Class [56] 
.const [14] = Field [57] [58] 
.const [15] = Method [59] [60] 
.const [16] = Field [61] [62] 
.const [17] = Field [63] [64] 
.const [18] = Field [65] [66] 
.const [19] = Field [67] [68] 
.const [20] = Method [69] [70] 
.const [21] = Method [71] [72] 
.const [22] = Method [73] [74] 
.const [23] = Method [75] [76] 
.const [24] = Method [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Method [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Class [99] 
.const [36] = Field [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Field [108] [109] 
.const [41] = Class [110] 
.const [42] = InterfaceMethod [111] [112] 
.const [43] = InterfaceMethod [113] [114] 
.const [44] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel 
.const [45] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [46] = Utf8 java/lang/StringBuffer 
.const [47] = Utf8 'MobileBatteryLevel_Status:' 
.const [48] = Utf8 '\n - ChargeLevel_Mobile1 - ' 
.const [49] = Utf8 '\n - ChargeLevel_Mobile2 - ' 
.const [50] = Utf8 '\n - ChargeLevel_Handset1 - ' 
.const [51] = Utf8 '\n - ChargeLevel_Handset2 - ' 
.const [52] = Utf8 '\n - WarningLevel - ' 
.const [53] = Class [115] 
.const [54] = NameAndType [116] [117] 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [57] = Class [118] 
.const [58] = NameAndType [119] [120] 
.const [59] = Class [121] 
.const [60] = NameAndType [122] [123] 
.const [61] = Class [124] 
.const [62] = NameAndType [125] [126] 
.const [63] = Class [127] 
.const [64] = NameAndType [128] [129] 
.const [65] = Class [130] 
.const [66] = NameAndType [131] [132] 
.const [67] = Class [133] 
.const [68] = NameAndType [134] [135] 
.const [69] = Class [136] 
.const [70] = NameAndType [137] [138] 
.const [71] = Class [139] 
.const [72] = NameAndType [140] [141] 
.const [73] = Class [142] 
.const [74] = NameAndType [143] [144] 
.const [75] = Class [145] 
.const [76] = NameAndType [146] [147] 
.const [77] = Class [148] 
.const [78] = NameAndType [149] [150] 
.const [79] = Class [151] 
.const [80] = NameAndType [152] [153] 
.const [81] = Class [154] 
.const [82] = NameAndType [155] [156] 
.const [83] = Class [157] 
.const [84] = NameAndType [158] [159] 
.const [85] = Class [160] 
.const [86] = NameAndType [161] [162] 
.const [87] = Class [163] 
.const [88] = NameAndType [164] [165] 
.const [89] = Class [166] 
.const [90] = NameAndType [167] [168] 
.const [91] = Class [169] 
.const [92] = NameAndType [170] [171] 
.const [93] = Class [172] 
.const [94] = NameAndType [173] [174] 
.const [95] = Class [175] 
.const [96] = NameAndType [176] [177] 
.const [97] = Class [178] 
.const [98] = NameAndType [179] [180] 
.const [99] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel 
.const [100] = Class [181] 
.const [101] = NameAndType [182] [183] 
.const [102] = Class [184] 
.const [103] = NameAndType [185] [186] 
.const [104] = Class [187] 
.const [105] = NameAndType [188] [189] 
.const [106] = Class [190] 
.const [107] = NameAndType [191] [192] 
.const [108] = Class [193] 
.const [109] = NameAndType [194] [195] 
.const [110] = Utf8 java/lang/StringBuffer 
.const [111] = Class [196] 
.const [112] = NameAndType [197] [198] 
.const [113] = Class [199] 
.const [114] = NameAndType [200] [201] 
.const [115] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [116] = Utf8 functionId 
.const [117] = Utf8 ()I 
.const [118] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [119] = Utf8 warningLevel 
.const [120] = Utf8 Lde/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel; 
.const [121] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [122] = Utf8 deserialize 
.const [123] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [124] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [125] = Utf8 chargeLevel_Mobile1 
.const [126] = Utf8 I 
.const [127] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [128] = Utf8 chargeLevel_Mobile2 
.const [129] = Utf8 I 
.const [130] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [131] = Utf8 chargeLevel_Handset1 
.const [132] = Utf8 I 
.const [133] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [134] = Utf8 chargeLevel_Handset2 
.const [135] = Utf8 I 
.const [136] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel 
.const [137] = Utf8 reset 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel 
.const [140] = Utf8 equalTo 
.const [141] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [142] = Utf8 java/lang/StringBuffer 
.const [143] = Utf8 append 
.const [144] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [145] = Utf8 java/lang/StringBuffer 
.const [146] = Utf8 append 
.const [147] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [148] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel 
.const [149] = Utf8 toString 
.const [150] = Utf8 ()Ljava/lang/String; 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Utf8 toString 
.const [153] = Utf8 ()Ljava/lang/String; 
.const [154] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel 
.const [155] = Utf8 bitSize 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel 
.const [158] = Utf8 serialize 
.const [159] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [160] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel 
.const [161] = Utf8 deserialize 
.const [162] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [163] = Utf8 java/lang/Object 
.const [164] = Utf8 <init> 
.const [165] = Utf8 ()V 
.const [166] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel 
.const [167] = Utf8 <init> 
.const [168] = Utf8 ()V 
.const [169] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [170] = Utf8 internalReset 
.const [171] = Utf8 ()V 
.const [172] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [173] = Utf8 customInitialization 
.const [174] = Utf8 ()V 
.const [175] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 java/lang/StringBuffer 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [182] = Utf8 warningLevel 
.const [183] = Utf8 Lde/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel; 
.const [184] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [185] = Utf8 chargeLevel_Mobile1 
.const [186] = Utf8 I 
.const [187] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [188] = Utf8 chargeLevel_Mobile2 
.const [189] = Utf8 I 
.const [190] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [191] = Utf8 chargeLevel_Handset1 
.const [192] = Utf8 I 
.const [193] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [194] = Utf8 chargeLevel_Handset2 
.const [195] = Utf8 I 
.const [196] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [197] = Utf8 pushByte 
.const [198] = Utf8 (B)V 
.const [199] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [200] = Utf8 popFrontByte 
.const [201] = Utf8 ()I 
.const [202] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status 
.const [203] = Class [202] 
.const [204] = Utf8 java/lang/Object 
.const [205] = Class [204] 
.const [206] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [207] = Class [206] 
.const [208] = Utf8 chargeLevel_Mobile1 
.const [209] = Utf8 I 
.const [210] = Utf8 CHARGE_LEVEL_MOBILE1_BITSIZE 
.const [211] = Utf8 I 
.const [212] = Utf8 chargeLevel_Mobile2 
.const [213] = Utf8 I 
.const [214] = Utf8 CHARGE_LEVEL_MOBILE2_BITSIZE 
.const [215] = Utf8 I 
.const [216] = Utf8 chargeLevel_Handset1 
.const [217] = Utf8 I 
.const [218] = Utf8 CHARGE_LEVEL_HANDSET1_BITSIZE 
.const [219] = Utf8 I 
.const [220] = Utf8 chargeLevel_Handset2 
.const [221] = Utf8 I 
.const [222] = Utf8 CHARGE_LEVEL_HANDSET2_BITSIZE 
.const [223] = Utf8 I 
.const [224] = Utf8 warningLevel 
.const [225] = Utf8 Lde/vw/mib/bap/generated/telephone/serializer/MobileBatteryLevel_Status$WarningLevel; 
.const [226] = Utf8 Code 
.const [227] = Utf8 <init> 
.const [228] = Utf8 ()V 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [231] = Utf8 internalReset 
.const [232] = Utf8 ()V 
.const [233] = Utf8 reset 
.const [234] = Utf8 ()V 
.const [235] = Utf8 equalTo 
.const [236] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [237] = Utf8 customInitialization 
.const [238] = Utf8 ()V 
.const [239] = Utf8 toString 
.const [240] = Utf8 ()Ljava/lang/String; 
.const [241] = Utf8 bitSize 
.const [242] = Utf8 ()I 
.const [243] = Utf8 serialize 
.const [244] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [245] = Utf8 deserialize 
.const [246] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [247] = Utf8 functionId 
.const [248] = Utf8 ()I 
.const [249] = Utf8 getFunctionId 
.const [250] = Utf8 ()I 
.end class 
