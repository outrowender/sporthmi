.version 50 0 
.class public final super [173] 
.super [175] 
.implements [177] 
.field public final [178] [179] 
.field public [180] [181] 
.field private static final [182] [183] 
.field public static final [184] [185] 
.field public static final [186] [187] 
.field public static final [188] [189] 
.field public static final [190] [191] 
.field public static final [192] [193] 
.field public static final [194] [195] 
.field public static final [196] [197] 
.field public static final [198] [199] 

.method public [201] : [202] 
    .attribute [200] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     new [37] 
L8:     dup 
L9:     invokespecial [32] 
L12:    putfield [38] 
L15:    aload_0 
L16:    invokespecial [33] 
L19:    aload_0 
L20:    invokespecial [34] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [200] .code stack 2 locals 0 
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

.method private [205] : [206] 
    .attribute [200] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [39] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [200] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     getfield [20] 
L8:     invokevirtual [23] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [200] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [20] 
L9:     aload_2 
L10:    getfield [20] 
L13:    invokevirtual [24] 
L16:    ifeq L34 
L19:    aload_0 
L20:    getfield [22] 
L23:    aload_2 
L24:    getfield [22] 
L27:    if_icmpne L34 
L30:    iconst_1 
L31:    goto L35 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method private enum [211] : [212] 
    .attribute [200] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [200] .code stack 2 locals 1 
L0:     new [40] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [5] 
L11:    invokevirtual [25] 
L14:    pop 
L15:    aload_1 
L16:    ldc [6] 
L18:    invokevirtual [25] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [20] 
L27:    invokevirtual [26] 
L30:    invokevirtual [25] 
L33:    pop 
L34:    aload_1 
L35:    ldc [7] 
L37:    invokevirtual [25] 
L40:    pop 
L41:    aload_0 
L42:    getfield [22] 
L45:    tableswitch 0 
            L92 
            L102 
            L112 
            L122 
            L132 
            L142 
            L152 
            L162 
            default : L172 

L92:    aload_1 
L93:    ldc [8] 
L95:    invokevirtual [25] 
L98:    pop 
L99:    goto L179 
L102:   aload_1 
L103:   ldc [9] 
L105:   invokevirtual [25] 
L108:   pop 
L109:   goto L179 
L112:   aload_1 
L113:   ldc [10] 
L115:   invokevirtual [25] 
L118:   pop 
L119:   goto L179 
L122:   aload_1 
L123:   ldc [11] 
L125:   invokevirtual [25] 
L128:   pop 
L129:   goto L179 
L132:   aload_1 
L133:   ldc [12] 
L135:   invokevirtual [25] 
L138:   pop 
L139:   goto L179 
L142:   aload_1 
L143:   ldc [13] 
L145:   invokevirtual [25] 
L148:   pop 
L149:   goto L179 
L152:   aload_1 
L153:   ldc [14] 
L155:   invokevirtual [25] 
L158:   pop 
L159:   goto L179 
L162:   aload_1 
L163:   ldc [15] 
L165:   invokevirtual [25] 
L168:   pop 
L169:   goto L179 
L172:   aload_1 
L173:   ldc [16] 
L175:   invokevirtual [25] 
L178:   pop 
L179:   aload_1 
L180:   invokevirtual [27] 
L183:   areturn 
L184:   
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [200] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iload_1 
L3:     aload_0 
L4:     getfield [20] 
L7:     invokevirtual [28] 
L10:    iadd 
L11:    istore_1 
L12:    iinc 1 8 
L15:    iload_1 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [200] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_1 
L5:     invokevirtual [29] 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [22] 
L13:    i2b 
L14:    invokeinterface [41] 0 
L19:    return 
L20:    
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [200] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_1 
L5:     invokevirtual [30] 
L8:     aload_0 
L9:     aload_1 
L10:    invokeinterface [42] 0 
L15:    putfield [39] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [221] : [222] 
    .attribute [200] .code stack 1 locals 0 
L0:     bipush 14 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [200] .code stack 1 locals 0 
L0:     invokestatic [17] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [43] 
.const [3] = Class [44] 
.const [4] = Class [45] 
.const [5] = String [46] 
.const [6] = String [47] 
.const [7] = String [48] 
.const [8] = String [49] 
.const [9] = String [50] 
.const [10] = String [51] 
.const [11] = String [52] 
.const [12] = String [53] 
.const [13] = String [54] 
.const [14] = String [55] 
.const [15] = String [56] 
.const [16] = String [57] 
.const [17] = Method [58] [59] 
.const [18] = Class [60] 
.const [19] = Class [61] 
.const [20] = Field [62] [63] 
.const [21] = Method [64] [65] 
.const [22] = Field [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Method [90] [91] 
.const [35] = Method [92] [93] 
.const [36] = Method [94] [95] 
.const [37] = Class [96] 
.const [38] = Field [97] [98] 
.const [39] = Field [99] [100] 
.const [40] = Class [101] 
.const [41] = InterfaceMethod [102] [103] 
.const [42] = InterfaceMethod [104] [105] 
.const [43] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics 
.const [44] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [45] = Utf8 java/lang/StringBuffer 
.const [46] = Utf8 'FSG_Setup_Status:' 
.const [47] = Utf8 '\n - PhoneCharacteristics - ' 
.const [48] = Utf8 '\n - MobileConnectionType: ' 
.const [49] = Utf8 '0x00 (NoConnection)' 
.const [50] = Utf8 '0x01 (InternalSIMCardReader)' 
.const [51] = Utf8 '0x02 (CableConnection)' 
.const [52] = Utf8 '0x03 (HandsFreeProfile)' 
.const [53] = Utf8 '0x04 (RemoteSIMAccessProfile)' 
.const [54] = Utf8 '0x05 (AppleLink (DF4.2))' 
.const [55] = Utf8 '0x06 (GoogleLink (DF4.2))' 
.const [56] = Utf8 '0x07 (BaiduLink (DF4.3))' 
.const [57] = Utf8 'UNKNOWN ENUM' 
.const [58] = Class [106] 
.const [59] = NameAndType [107] [108] 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Class [112] 
.const [65] = NameAndType [113] [114] 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Class [145] 
.const [87] = NameAndType [146] [147] 
.const [88] = Class [148] 
.const [89] = NameAndType [149] [150] 
.const [90] = Class [151] 
.const [91] = NameAndType [152] [153] 
.const [92] = Class [154] 
.const [93] = NameAndType [155] [156] 
.const [94] = Class [157] 
.const [95] = NameAndType [158] [159] 
.const [96] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics 
.const [97] = Class [160] 
.const [98] = NameAndType [161] [162] 
.const [99] = Class [163] 
.const [100] = NameAndType [164] [165] 
.const [101] = Utf8 java/lang/StringBuffer 
.const [102] = Class [166] 
.const [103] = NameAndType [167] [168] 
.const [104] = Class [169] 
.const [105] = NameAndType [170] [171] 
.const [106] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [107] = Utf8 functionId 
.const [108] = Utf8 ()I 
.const [109] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [110] = Utf8 phoneCharacteristics 
.const [111] = Utf8 Lde/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics; 
.const [112] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [113] = Utf8 deserialize 
.const [114] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [115] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [116] = Utf8 mobileConnectionType 
.const [117] = Utf8 I 
.const [118] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics 
.const [119] = Utf8 reset 
.const [120] = Utf8 ()V 
.const [121] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics 
.const [122] = Utf8 equalTo 
.const [123] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 append 
.const [126] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [127] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics 
.const [128] = Utf8 toString 
.const [129] = Utf8 ()Ljava/lang/String; 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 toString 
.const [132] = Utf8 ()Ljava/lang/String; 
.const [133] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics 
.const [134] = Utf8 bitSize 
.const [135] = Utf8 ()I 
.const [136] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics 
.const [137] = Utf8 serialize 
.const [138] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [139] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics 
.const [140] = Utf8 deserialize 
.const [141] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics 
.const [146] = Utf8 <init> 
.const [147] = Utf8 ()V 
.const [148] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [149] = Utf8 internalReset 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [152] = Utf8 customInitialization 
.const [153] = Utf8 ()V 
.const [154] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 java/lang/StringBuffer 
.const [158] = Utf8 <init> 
.const [159] = Utf8 ()V 
.const [160] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [161] = Utf8 phoneCharacteristics 
.const [162] = Utf8 Lde/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics; 
.const [163] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [164] = Utf8 mobileConnectionType 
.const [165] = Utf8 I 
.const [166] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [167] = Utf8 pushByte 
.const [168] = Utf8 (B)V 
.const [169] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [170] = Utf8 popFrontByte 
.const [171] = Utf8 ()I 
.const [172] = Utf8 de/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status 
.const [173] = Class [172] 
.const [174] = Utf8 java/lang/Object 
.const [175] = Class [174] 
.const [176] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [177] = Class [176] 
.const [178] = Utf8 phoneCharacteristics 
.const [179] = Utf8 Lde/vw/mib/bap/generated/telephone/serializer/FSG_Setup_Status$PhoneCharacteristics; 
.const [180] = Utf8 mobileConnectionType 
.const [181] = Utf8 I 
.const [182] = Utf8 MOBILE_CONNECTION_TYPE_BITSIZE 
.const [183] = Utf8 I 
.const [184] = Utf8 MOBILE_CONNECTION_TYPE_NO_CONNECTION 
.const [185] = Utf8 I 
.const [186] = Utf8 MOBILE_CONNECTION_TYPE_INTERNAL_SIM_CARD_READER 
.const [187] = Utf8 I 
.const [188] = Utf8 MOBILE_CONNECTION_TYPE_CABLE_CONNECTION 
.const [189] = Utf8 I 
.const [190] = Utf8 MOBILE_CONNECTION_TYPE_HANDS_FREE_PROFILE 
.const [191] = Utf8 I 
.const [192] = Utf8 MOBILE_CONNECTION_TYPE_REMOTE_SIM_ACCESS_PROFILE 
.const [193] = Utf8 I 
.const [194] = Utf8 MOBILE_CONNECTION_TYPE_APPLE_LINK_DF4_2 
.const [195] = Utf8 I 
.const [196] = Utf8 MOBILE_CONNECTION_TYPE_GOOGLE_LINK_DF4_2 
.const [197] = Utf8 I 
.const [198] = Utf8 MOBILE_CONNECTION_TYPE_BAIDU_LINK_DF4_3 
.const [199] = Utf8 I 
.const [200] = Utf8 Code 
.const [201] = Utf8 <init> 
.const [202] = Utf8 ()V 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [205] = Utf8 internalReset 
.const [206] = Utf8 ()V 
.const [207] = Utf8 reset 
.const [208] = Utf8 ()V 
.const [209] = Utf8 equalTo 
.const [210] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [211] = Utf8 customInitialization 
.const [212] = Utf8 ()V 
.const [213] = Utf8 toString 
.const [214] = Utf8 ()Ljava/lang/String; 
.const [215] = Utf8 bitSize 
.const [216] = Utf8 ()I 
.const [217] = Utf8 serialize 
.const [218] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [219] = Utf8 deserialize 
.const [220] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [221] = Utf8 functionId 
.const [222] = Utf8 ()I 
.const [223] = Utf8 getFunctionId 
.const [224] = Utf8 ()I 
.end class 
