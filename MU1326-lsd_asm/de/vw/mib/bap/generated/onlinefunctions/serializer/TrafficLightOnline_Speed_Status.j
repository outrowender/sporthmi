.version 50 0 
.class public final super [183] 
.super [185] 
.implements [187] 
.field public [188] [189] 
.field private static final [190] [191] 
.field public [192] [193] 
.field private static final [194] [195] 
.field public static final [196] [197] 
.field public static final [198] [199] 
.field public static final [200] [201] 
.field public final [202] [203] 

.method public [205] : [206] 
    .attribute [204] .code stack 3 locals 0 
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

.method public [207] : [208] 
    .attribute [204] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [17] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [209] : [210] 
    .attribute [204] .code stack 2 locals 0 
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

.method public [211] : [212] 
    .attribute [204] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     getfield [16] 
L8:     invokevirtual [20] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [204] .code stack 2 locals 1 
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
L28:    getfield [16] 
L31:    aload_2 
L32:    getfield [16] 
L35:    invokevirtual [21] 
L38:    ifeq L45 
L41:    iconst_1 
L42:    goto L46 
L45:    iconst_0 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method private enum [215] : [216] 
    .attribute [204] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [204] .code stack 2 locals 1 
L0:     new [39] 
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
L24:    getfield [18] 
L27:    invokevirtual [23] 
L30:    pop 
L31:    aload_1 
L32:    ldc [7] 
L34:    invokevirtual [22] 
L37:    pop 
L38:    aload_0 
L39:    getfield [19] 
L42:    lookupswitch 
            0 : L76 
            1 : L86 
            255 : L96 
            default : L106 

L76:    aload_1 
L77:    ldc [8] 
L79:    invokevirtual [22] 
L82:    pop 
L83:    goto L113 
L86:    aload_1 
L87:    ldc [9] 
L89:    invokevirtual [22] 
L92:    pop 
L93:    goto L113 
L96:    aload_1 
L97:    ldc [10] 
L99:    invokevirtual [22] 
L102:   pop 
L103:   goto L113 
L106:   aload_1 
L107:   ldc [11] 
L109:   invokevirtual [22] 
L112:   pop 
L113:   aload_1 
L114:   ldc [12] 
L116:   invokevirtual [22] 
L119:   pop 
L120:   aload_1 
L121:   aload_0 
L122:   getfield [16] 
L125:   invokevirtual [24] 
L128:   invokevirtual [22] 
L131:   pop 
L132:   aload_1 
L133:   invokevirtual [25] 
L136:   areturn 
L137:   nop 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [204] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 8 
L8:     iload_1 
L9:     aload_0 
L10:    getfield [16] 
L13:    invokevirtual [26] 
L16:    iadd 
L17:    istore_1 
L18:    iload_1 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [204] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [18] 
L5:     i2b 
L6:     invokeinterface [40] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [19] 
L16:    i2b 
L17:    invokeinterface [40] 0 
L22:    aload_0 
L23:    getfield [16] 
L26:    aload_1 
L27:    invokevirtual [27] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [204] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [41] 0 
L7:     putfield [37] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [41] 0 
L17:    putfield [38] 
L20:    aload_0 
L21:    getfield [16] 
L24:    aload_1 
L25:    invokevirtual [28] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public static [225] : [226] 
    .attribute [204] .code stack 1 locals 0 
L0:     bipush 17 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [204] .code stack 1 locals 0 
L0:     invokestatic [13] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [42] 
.const [3] = Class [43] 
.const [4] = Class [44] 
.const [5] = String [45] 
.const [6] = String [46] 
.const [7] = String [47] 
.const [8] = String [48] 
.const [9] = String [49] 
.const [10] = String [50] 
.const [11] = String [51] 
.const [12] = String [52] 
.const [13] = Method [53] [54] 
.const [14] = Class [55] 
.const [15] = Class [56] 
.const [16] = Field [57] [58] 
.const [17] = Method [59] [60] 
.const [18] = Field [61] [62] 
.const [19] = Field [63] [64] 
.const [20] = Method [65] [66] 
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
.const [35] = Class [95] 
.const [36] = Field [96] [97] 
.const [37] = Field [98] [99] 
.const [38] = Field [100] [101] 
.const [39] = Class [102] 
.const [40] = InterfaceMethod [103] [104] 
.const [41] = InterfaceMethod [105] [106] 
.const [42] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [43] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [44] = Utf8 java/lang/StringBuffer 
.const [45] = Utf8 'TrafficLightOnline_Speed_Status:' 
.const [46] = Utf8 '\n - RecommendedSpeed - ' 
.const [47] = Utf8 '\n - Unit: ' 
.const [48] = Utf8 '0x00 (km/h)' 
.const [49] = Utf8 '0x01 (mph)' 
.const [50] = Utf8 '0xFF (unit not supported)' 
.const [51] = Utf8 'UNKNOWN ENUM' 
.const [52] = Utf8 '\n - ValidityInformation - ' 
.const [53] = Class [107] 
.const [54] = NameAndType [108] [109] 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [57] = Class [110] 
.const [58] = NameAndType [111] [112] 
.const [59] = Class [113] 
.const [60] = NameAndType [114] [115] 
.const [61] = Class [116] 
.const [62] = NameAndType [117] [118] 
.const [63] = Class [119] 
.const [64] = NameAndType [120] [121] 
.const [65] = Class [122] 
.const [66] = NameAndType [123] [124] 
.const [67] = Class [125] 
.const [68] = NameAndType [126] [127] 
.const [69] = Class [128] 
.const [70] = NameAndType [129] [130] 
.const [71] = Class [131] 
.const [72] = NameAndType [132] [133] 
.const [73] = Class [134] 
.const [74] = NameAndType [135] [136] 
.const [75] = Class [137] 
.const [76] = NameAndType [138] [139] 
.const [77] = Class [140] 
.const [78] = NameAndType [141] [142] 
.const [79] = Class [143] 
.const [80] = NameAndType [144] [145] 
.const [81] = Class [146] 
.const [82] = NameAndType [147] [148] 
.const [83] = Class [149] 
.const [84] = NameAndType [150] [151] 
.const [85] = Class [152] 
.const [86] = NameAndType [153] [154] 
.const [87] = Class [155] 
.const [88] = NameAndType [156] [157] 
.const [89] = Class [158] 
.const [90] = NameAndType [159] [160] 
.const [91] = Class [161] 
.const [92] = NameAndType [162] [163] 
.const [93] = Class [164] 
.const [94] = NameAndType [165] [166] 
.const [95] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [96] = Class [167] 
.const [97] = NameAndType [168] [169] 
.const [98] = Class [170] 
.const [99] = NameAndType [171] [172] 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Utf8 java/lang/StringBuffer 
.const [103] = Class [176] 
.const [104] = NameAndType [177] [178] 
.const [105] = Class [179] 
.const [106] = NameAndType [180] [181] 
.const [107] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [108] = Utf8 functionId 
.const [109] = Utf8 ()I 
.const [110] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [111] = Utf8 validityInformation 
.const [112] = Utf8 Lde/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation; 
.const [113] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [114] = Utf8 deserialize 
.const [115] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [116] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [117] = Utf8 recommendedSpeed 
.const [118] = Utf8 I 
.const [119] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [120] = Utf8 unit 
.const [121] = Utf8 I 
.const [122] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [123] = Utf8 reset 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [126] = Utf8 equalTo 
.const [127] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 append 
.const [130] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [131] = Utf8 java/lang/StringBuffer 
.const [132] = Utf8 append 
.const [133] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [134] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [135] = Utf8 toString 
.const [136] = Utf8 ()Ljava/lang/String; 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 toString 
.const [139] = Utf8 ()Ljava/lang/String; 
.const [140] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [141] = Utf8 bitSize 
.const [142] = Utf8 ()I 
.const [143] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [144] = Utf8 serialize 
.const [145] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [146] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [147] = Utf8 deserialize 
.const [148] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [149] = Utf8 java/lang/Object 
.const [150] = Utf8 <init> 
.const [151] = Utf8 ()V 
.const [152] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [153] = Utf8 <init> 
.const [154] = Utf8 ()V 
.const [155] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [156] = Utf8 internalReset 
.const [157] = Utf8 ()V 
.const [158] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [159] = Utf8 customInitialization 
.const [160] = Utf8 ()V 
.const [161] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [162] = Utf8 <init> 
.const [163] = Utf8 ()V 
.const [164] = Utf8 java/lang/StringBuffer 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [168] = Utf8 validityInformation 
.const [169] = Utf8 Lde/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation; 
.const [170] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [171] = Utf8 recommendedSpeed 
.const [172] = Utf8 I 
.const [173] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [174] = Utf8 unit 
.const [175] = Utf8 I 
.const [176] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [177] = Utf8 pushByte 
.const [178] = Utf8 (B)V 
.const [179] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [180] = Utf8 popFrontByte 
.const [181] = Utf8 ()I 
.const [182] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status 
.const [183] = Class [182] 
.const [184] = Utf8 java/lang/Object 
.const [185] = Class [184] 
.const [186] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [187] = Class [186] 
.const [188] = Utf8 recommendedSpeed 
.const [189] = Utf8 I 
.const [190] = Utf8 RECOMMENDED_SPEED_BITSIZE 
.const [191] = Utf8 I 
.const [192] = Utf8 unit 
.const [193] = Utf8 I 
.const [194] = Utf8 UNIT_BITSIZE 
.const [195] = Utf8 I 
.const [196] = Utf8 UNIT_KM_H 
.const [197] = Utf8 I 
.const [198] = Utf8 UNIT_MPH 
.const [199] = Utf8 I 
.const [200] = Utf8 UNIT_UNIT_NOT_SUPPORTED 
.const [201] = Utf8 I 
.const [202] = Utf8 validityInformation 
.const [203] = Utf8 Lde/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation; 
.const [204] = Utf8 Code 
.const [205] = Utf8 <init> 
.const [206] = Utf8 ()V 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [209] = Utf8 internalReset 
.const [210] = Utf8 ()V 
.const [211] = Utf8 reset 
.const [212] = Utf8 ()V 
.const [213] = Utf8 equalTo 
.const [214] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [215] = Utf8 customInitialization 
.const [216] = Utf8 ()V 
.const [217] = Utf8 toString 
.const [218] = Utf8 ()Ljava/lang/String; 
.const [219] = Utf8 bitSize 
.const [220] = Utf8 ()I 
.const [221] = Utf8 serialize 
.const [222] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [223] = Utf8 deserialize 
.const [224] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [225] = Utf8 functionId 
.const [226] = Utf8 ()I 
.const [227] = Utf8 getFunctionId 
.const [228] = Utf8 ()I 
.end class 
