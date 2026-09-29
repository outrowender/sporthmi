.version 50 0 
.class public super [187] 
.super [189] 

.method public annotation [191] : [192] 
    .attribute [190] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [193] : [194] 
    .attribute [190] .code stack 2 locals 8 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [24] 0 
L17:    iload_2 
L18:    ifne L113 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [25] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokestatic [2] 
L45:    aload_1 
L46:    invokevirtual [17] 
L49:    astore 5 
L51:    aload_0 
L52:    aload 5 
L54:    invokestatic [3] 
L57:    aload_1 
L58:    invokevirtual [18] 
L61:    istore 6 
L63:    aload_0 
L64:    iload 6 
L66:    invokeinterface [25] 0 
L71:    aload_1 
L72:    invokevirtual [19] 
L75:    istore 7 
L77:    aload_0 
L78:    iload 7 
L80:    invokeinterface [25] 0 
L85:    aload_1 
L86:    invokevirtual [20] 
L89:    istore 8 
L91:    aload_0 
L92:    iload 8 
L94:    invokeinterface [25] 0 
L99:    aload_1 
L100:   invokevirtual [21] 
L103:   astore 9 
L105:   aload_0 
L106:   aload 9 
L108:   invokeinterface [26] 0 
L113:   return 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public static [195] : [196] 
    .attribute [190] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [24] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [25] 0 
L29:    iconst_0 
L30:    istore_3 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    if_icmpge L50 
L37:    aload_0 
L38:    aload_1 
L39:    iload_3 
L40:    aaload 
L41:    invokestatic [4] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [197] : [198] 
    .attribute [190] .code stack 2 locals 9 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [27] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L113 
L13:    new [28] 
L16:    dup 
L17:    invokespecial [23] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [29] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [30] 
L33:    aload_0 
L34:    invokestatic [6] 
L37:    astore 4 
L39:    aload_1 
L40:    aload 4 
L42:    putfield [31] 
L45:    aload_0 
L46:    invokestatic [7] 
L49:    astore 5 
L51:    aload_1 
L52:    aload 5 
L54:    putfield [32] 
L57:    aload_0 
L58:    invokeinterface [29] 0 
L63:    istore 6 
L65:    aload_1 
L66:    iload 6 
L68:    putfield [33] 
L71:    aload_0 
L72:    invokeinterface [29] 0 
L77:    istore 7 
L79:    aload_1 
L80:    iload 7 
L82:    putfield [34] 
L85:    aload_0 
L86:    invokeinterface [29] 0 
L91:    istore 8 
L93:    aload_1 
L94:    iload 8 
L96:    putfield [35] 
L99:    aload_0 
L100:   invokeinterface [36] 0 
L105:   astore 9 
L107:   aload_1 
L108:   aload 9 
L110:   putfield [37] 
L113:   aload_1 
L114:   areturn 
L115:   nop 
L116:   
    .end code 
.end method 

.method public static [199] : [200] 
    .attribute [190] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [27] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [29] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [5] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [8] 
L41:    aastore 
L42:    iinc 4 1 
L45:    goto L28 
L48:    aload_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [38] [39] 
.const [3] = Method [40] [41] 
.const [4] = Method [42] [43] 
.const [5] = Class [44] 
.const [6] = Method [45] [46] 
.const [7] = Method [47] [48] 
.const [8] = Method [49] [50] 
.const [9] = Class [51] 
.const [10] = Class [52] 
.const [11] = Class [53] 
.const [12] = Class [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = Method [57] [58] 
.const [16] = Method [59] [60] 
.const [17] = Method [61] [62] 
.const [18] = Method [63] [64] 
.const [19] = Method [65] [66] 
.const [20] = Method [67] [68] 
.const [21] = Method [69] [70] 
.const [22] = Method [71] [72] 
.const [23] = Method [73] [74] 
.const [24] = InterfaceMethod [75] [76] 
.const [25] = InterfaceMethod [77] [78] 
.const [26] = InterfaceMethod [79] [80] 
.const [27] = InterfaceMethod [81] [82] 
.const [28] = Class [83] 
.const [29] = InterfaceMethod [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Field [88] [89] 
.const [32] = Field [90] [91] 
.const [33] = Field [92] [93] 
.const [34] = Field [94] [95] 
.const [35] = Field [96] [97] 
.const [36] = InterfaceMethod [98] [99] 
.const [37] = Field [100] [101] 
.const [38] = Class [102] 
.const [39] = NameAndType [103] [104] 
.const [40] = Class [105] 
.const [41] = NameAndType [106] [107] 
.const [42] = Class [108] 
.const [43] = NameAndType [109] [110] 
.const [44] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [45] = Class [111] 
.const [46] = NameAndType [112] [113] 
.const [47] = Class [114] 
.const [48] = NameAndType [115] [116] 
.const [49] = Class [117] 
.const [50] = NameAndType [118] [119] 
.const [51] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA5Serializer 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [54] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperationSerializer 
.const [55] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperation2Serializer 
.const [56] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [57] = Class [120] 
.const [58] = NameAndType [121] [122] 
.const [59] = Class [123] 
.const [60] = NameAndType [124] [125] 
.const [61] = Class [126] 
.const [62] = NameAndType [127] [128] 
.const [63] = Class [129] 
.const [64] = NameAndType [130] [131] 
.const [65] = Class [132] 
.const [66] = NameAndType [133] [134] 
.const [67] = Class [135] 
.const [68] = NameAndType [136] [137] 
.const [69] = Class [138] 
.const [70] = NameAndType [139] [140] 
.const [71] = Class [141] 
.const [72] = NameAndType [142] [143] 
.const [73] = Class [144] 
.const [74] = NameAndType [145] [146] 
.const [75] = Class [147] 
.const [76] = NameAndType [148] [149] 
.const [77] = Class [150] 
.const [78] = NameAndType [151] [152] 
.const [79] = Class [153] 
.const [80] = NameAndType [154] [155] 
.const [81] = Class [156] 
.const [82] = NameAndType [157] [158] 
.const [83] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
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
.const [102] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperationSerializer 
.const [103] = Utf8 putOptionalBatteryControlProfileOperation 
.const [104] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation;)V 
.const [105] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperation2Serializer 
.const [106] = Utf8 putOptionalBatteryControlProfileOperation2 
.const [107] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation2;)V 
.const [108] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA5Serializer 
.const [109] = Utf8 putOptionalBatteryControlProfileRA5 
.const [110] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA5;)V 
.const [111] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperationSerializer 
.const [112] = Utf8 getOptionalBatteryControlProfileOperation 
.const [113] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation; 
.const [114] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperation2Serializer 
.const [115] = Utf8 getOptionalBatteryControlProfileOperation2 
.const [116] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation2; 
.const [117] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA5Serializer 
.const [118] = Utf8 getOptionalBatteryControlProfileRA5 
.const [119] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA5; 
.const [120] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [121] = Utf8 getPos 
.const [122] = Utf8 ()I 
.const [123] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [124] = Utf8 getProfileOperation 
.const [125] = Utf8 ()Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation; 
.const [126] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [127] = Utf8 getProfileOperation2 
.const [128] = Utf8 ()Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation2; 
.const [129] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [130] = Utf8 getMaxCurrent 
.const [131] = Utf8 ()I 
.const [132] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [133] = Utf8 getTargetChargeLevel 
.const [134] = Utf8 ()I 
.const [135] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [136] = Utf8 getProviderDataId 
.const [137] = Utf8 ()I 
.const [138] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [139] = Utf8 getName 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 java/lang/Object 
.const [142] = Utf8 <init> 
.const [143] = Utf8 ()V 
.const [144] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [148] = Utf8 putBool 
.const [149] = Utf8 (Z)V 
.const [150] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [151] = Utf8 putInt32 
.const [152] = Utf8 (I)V 
.const [153] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [154] = Utf8 putOptionalString 
.const [155] = Utf8 (Ljava/lang/String;)V 
.const [156] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [157] = Utf8 getBool 
.const [158] = Utf8 ()Z 
.const [159] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [160] = Utf8 getInt32 
.const [161] = Utf8 ()I 
.const [162] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [163] = Utf8 pos 
.const [164] = Utf8 I 
.const [165] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [166] = Utf8 profileOperation 
.const [167] = Utf8 Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation; 
.const [168] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [169] = Utf8 profileOperation2 
.const [170] = Utf8 Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation2; 
.const [171] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [172] = Utf8 maxCurrent 
.const [173] = Utf8 I 
.const [174] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [175] = Utf8 targetChargeLevel 
.const [176] = Utf8 I 
.const [177] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [178] = Utf8 providerDataId 
.const [179] = Utf8 I 
.const [180] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [181] = Utf8 getOptionalString 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA5 
.const [184] = Utf8 name 
.const [185] = Utf8 Ljava/lang/String; 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA5Serializer 
.const [187] = Class [186] 
.const [188] = Utf8 java/lang/Object 
.const [189] = Class [188] 
.const [190] = Utf8 Code 
.const [191] = Utf8 <init> 
.const [192] = Utf8 ()V 
.const [193] = Utf8 putOptionalBatteryControlProfileRA5 
.const [194] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA5;)V 
.const [195] = Utf8 putOptionalBatteryControlProfileRA5VarArray 
.const [196] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA5;)V 
.const [197] = Utf8 getOptionalBatteryControlProfileRA5 
.const [198] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA5; 
.const [199] = Utf8 getOptionalBatteryControlProfileRA5VarArray 
.const [200] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA5; 
.end class 
