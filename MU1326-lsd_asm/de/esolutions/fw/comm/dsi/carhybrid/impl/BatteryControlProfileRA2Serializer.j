.version 50 0 
.class public super [125] 
.super [127] 

.method public annotation [129] : [130] 
    .attribute [128] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [131] : [132] 
    .attribute [128] .code stack 2 locals 5 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [18] 0 
L17:    iload_2 
L18:    ifne L73 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [19] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokestatic [2] 
L45:    aload_1 
L46:    invokevirtual [14] 
L49:    istore 5 
L51:    aload_0 
L52:    iload 5 
L54:    invokeinterface [19] 0 
L59:    aload_1 
L60:    invokevirtual [15] 
L63:    istore 6 
L65:    aload_0 
L66:    iload 6 
L68:    invokeinterface [19] 0 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public static [133] : [134] 
    .attribute [128] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [18] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [19] 0 
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
L41:    invokestatic [3] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [135] : [136] 
    .attribute [128] .code stack 2 locals 6 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [20] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L73 
L13:    new [21] 
L16:    dup 
L17:    invokespecial [17] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [22] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [23] 
L33:    aload_0 
L34:    invokestatic [5] 
L37:    astore 4 
L39:    aload_1 
L40:    aload 4 
L42:    putfield [24] 
L45:    aload_0 
L46:    invokeinterface [22] 0 
L51:    istore 5 
L53:    aload_1 
L54:    iload 5 
L56:    putfield [25] 
L59:    aload_0 
L60:    invokeinterface [22] 0 
L65:    istore 6 
L67:    aload_1 
L68:    iload 6 
L70:    putfield [26] 
L73:    aload_1 
L74:    areturn 
L75:    nop 
L76:    
    .end code 
.end method 

.method public static [137] : [138] 
    .attribute [128] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [20] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [22] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [4] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [6] 
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
.const [2] = Method [27] [28] 
.const [3] = Method [29] [30] 
.const [4] = Class [31] 
.const [5] = Method [32] [33] 
.const [6] = Method [34] [35] 
.const [7] = Class [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Method [41] [42] 
.const [13] = Method [43] [44] 
.const [14] = Method [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = InterfaceMethod [53] [54] 
.const [19] = InterfaceMethod [55] [56] 
.const [20] = InterfaceMethod [57] [58] 
.const [21] = Class [59] 
.const [22] = InterfaceMethod [60] [61] 
.const [23] = Field [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = Field [68] [69] 
.const [27] = Class [70] 
.const [28] = NameAndType [71] [72] 
.const [29] = Class [73] 
.const [30] = NameAndType [74] [75] 
.const [31] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [32] = Class [76] 
.const [33] = NameAndType [77] [78] 
.const [34] = Class [79] 
.const [35] = NameAndType [80] [81] 
.const [36] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA2Serializer 
.const [37] = Utf8 java/lang/Object 
.const [38] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [39] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperationSerializer 
.const [40] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [41] = Class [82] 
.const [42] = NameAndType [83] [84] 
.const [43] = Class [85] 
.const [44] = NameAndType [86] [87] 
.const [45] = Class [88] 
.const [46] = NameAndType [89] [90] 
.const [47] = Class [91] 
.const [48] = NameAndType [92] [93] 
.const [49] = Class [94] 
.const [50] = NameAndType [95] [96] 
.const [51] = Class [97] 
.const [52] = NameAndType [98] [99] 
.const [53] = Class [100] 
.const [54] = NameAndType [101] [102] 
.const [55] = Class [103] 
.const [56] = NameAndType [104] [105] 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [60] = Class [109] 
.const [61] = NameAndType [110] [111] 
.const [62] = Class [112] 
.const [63] = NameAndType [113] [114] 
.const [64] = Class [115] 
.const [65] = NameAndType [116] [117] 
.const [66] = Class [118] 
.const [67] = NameAndType [119] [120] 
.const [68] = Class [121] 
.const [69] = NameAndType [122] [123] 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperationSerializer 
.const [71] = Utf8 putOptionalBatteryControlProfileOperation 
.const [72] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation;)V 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA2Serializer 
.const [74] = Utf8 putOptionalBatteryControlProfileRA2 
.const [75] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA2;)V 
.const [76] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileOperationSerializer 
.const [77] = Utf8 getOptionalBatteryControlProfileOperation 
.const [78] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation; 
.const [79] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA2Serializer 
.const [80] = Utf8 getOptionalBatteryControlProfileRA2 
.const [81] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA2; 
.const [82] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [83] = Utf8 getPos 
.const [84] = Utf8 ()I 
.const [85] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [86] = Utf8 getProfileOperation 
.const [87] = Utf8 ()Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation; 
.const [88] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [89] = Utf8 getMaxCurrent 
.const [90] = Utf8 ()I 
.const [91] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [92] = Utf8 getTargetChargeLevel 
.const [93] = Utf8 ()I 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [101] = Utf8 putBool 
.const [102] = Utf8 (Z)V 
.const [103] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [104] = Utf8 putInt32 
.const [105] = Utf8 (I)V 
.const [106] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [107] = Utf8 getBool 
.const [108] = Utf8 ()Z 
.const [109] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [110] = Utf8 getInt32 
.const [111] = Utf8 ()I 
.const [112] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [113] = Utf8 pos 
.const [114] = Utf8 I 
.const [115] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [116] = Utf8 profileOperation 
.const [117] = Utf8 Lorg/dsi/ifc/carhybrid/BatteryControlProfileOperation; 
.const [118] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [119] = Utf8 maxCurrent 
.const [120] = Utf8 I 
.const [121] = Utf8 org/dsi/ifc/carhybrid/BatteryControlProfileRA2 
.const [122] = Utf8 targetChargeLevel 
.const [123] = Utf8 I 
.const [124] = Utf8 de/esolutions/fw/comm/dsi/carhybrid/impl/BatteryControlProfileRA2Serializer 
.const [125] = Class [124] 
.const [126] = Utf8 java/lang/Object 
.const [127] = Class [126] 
.const [128] = Utf8 Code 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 putOptionalBatteryControlProfileRA2 
.const [132] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA2;)V 
.const [133] = Utf8 putOptionalBatteryControlProfileRA2VarArray 
.const [134] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA2;)V 
.const [135] = Utf8 getOptionalBatteryControlProfileRA2 
.const [136] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA2; 
.const [137] = Utf8 getOptionalBatteryControlProfileRA2VarArray 
.const [138] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/carhybrid/BatteryControlProfileRA2; 
.end class 
