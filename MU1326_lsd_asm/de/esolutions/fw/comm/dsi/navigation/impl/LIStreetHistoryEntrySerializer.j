.version 50 0 
.class public super [137] 
.super [139] 

.method public annotation [141] : [142] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [143] : [144] 
    .attribute [140] .code stack 3 locals 5 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [17] 0 
L17:    iload_2 
L18:    ifne L59 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokeinterface [18] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    lstore 4 
L39:    aload_0 
L40:    lload 4 
L42:    invokeinterface [19] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    astore 6 
L53:    aload_0 
L54:    aload 6 
L56:    invokestatic [2] 
L59:    return 
L60:    
    .end code 
.end method 

.method public static [145] : [146] 
    .attribute [140] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [17] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [20] 0 
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

.method public static [147] : [148] 
    .attribute [140] .code stack 3 locals 6 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [21] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L59 
L13:    new [22] 
L16:    dup 
L17:    invokespecial [16] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [23] 0 
L27:    astore_3 
L28:    aload_1 
L29:    aload_3 
L30:    putfield [24] 
L33:    aload_0 
L34:    invokeinterface [25] 0 
L39:    lstore 4 
L41:    aload_1 
L42:    lload 4 
L44:    putfield [26] 
L47:    aload_0 
L48:    invokestatic [5] 
L51:    astore 6 
L53:    aload_1 
L54:    aload 6 
L56:    putfield [27] 
L59:    aload_1 
L60:    areturn 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public static [149] : [150] 
    .attribute [140] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [21] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [28] 0 
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
.const [2] = Method [29] [30] 
.const [3] = Method [31] [32] 
.const [4] = Class [33] 
.const [5] = Method [34] [35] 
.const [6] = Method [36] [37] 
.const [7] = Class [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Method [43] [44] 
.const [13] = Method [45] [46] 
.const [14] = Method [47] [48] 
.const [15] = Method [49] [50] 
.const [16] = Method [51] [52] 
.const [17] = InterfaceMethod [53] [54] 
.const [18] = InterfaceMethod [55] [56] 
.const [19] = InterfaceMethod [57] [58] 
.const [20] = InterfaceMethod [59] [60] 
.const [21] = InterfaceMethod [61] [62] 
.const [22] = Class [63] 
.const [23] = InterfaceMethod [64] [65] 
.const [24] = Field [66] [67] 
.const [25] = InterfaceMethod [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = Field [72] [73] 
.const [28] = InterfaceMethod [74] [75] 
.const [29] = Class [76] 
.const [30] = NameAndType [77] [78] 
.const [31] = Class [79] 
.const [32] = NameAndType [80] [81] 
.const [33] = Utf8 org/dsi/ifc/navigation/LIStreetHistoryEntry 
.const [34] = Class [82] 
.const [35] = NameAndType [83] [84] 
.const [36] = Class [85] 
.const [37] = NameAndType [86] [87] 
.const [38] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/LIStreetHistoryEntrySerializer 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [41] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/LIExtDataSerializer 
.const [42] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [43] = Class [88] 
.const [44] = NameAndType [89] [90] 
.const [45] = Class [91] 
.const [46] = NameAndType [92] [93] 
.const [47] = Class [94] 
.const [48] = NameAndType [95] [96] 
.const [49] = Class [97] 
.const [50] = NameAndType [98] [99] 
.const [51] = Class [100] 
.const [52] = NameAndType [101] [102] 
.const [53] = Class [103] 
.const [54] = NameAndType [104] [105] 
.const [55] = Class [106] 
.const [56] = NameAndType [107] [108] 
.const [57] = Class [109] 
.const [58] = NameAndType [110] [111] 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Class [115] 
.const [62] = NameAndType [116] [117] 
.const [63] = Utf8 org/dsi/ifc/navigation/LIStreetHistoryEntry 
.const [64] = Class [118] 
.const [65] = NameAndType [119] [120] 
.const [66] = Class [121] 
.const [67] = NameAndType [122] [123] 
.const [68] = Class [124] 
.const [69] = NameAndType [125] [126] 
.const [70] = Class [127] 
.const [71] = NameAndType [128] [129] 
.const [72] = Class [130] 
.const [73] = NameAndType [131] [132] 
.const [74] = Class [133] 
.const [75] = NameAndType [134] [135] 
.const [76] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/LIExtDataSerializer 
.const [77] = Utf8 putOptionalLIExtDataVarArray 
.const [78] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/navigation/LIExtData;)V 
.const [79] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/LIStreetHistoryEntrySerializer 
.const [80] = Utf8 putOptionalLIStreetHistoryEntry 
.const [81] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/LIStreetHistoryEntry;)V 
.const [82] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/LIExtDataSerializer 
.const [83] = Utf8 getOptionalLIExtDataVarArray 
.const [84] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/LIExtData; 
.const [85] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/LIStreetHistoryEntrySerializer 
.const [86] = Utf8 getOptionalLIStreetHistoryEntry 
.const [87] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/LIStreetHistoryEntry; 
.const [88] = Utf8 org/dsi/ifc/navigation/LIStreetHistoryEntry 
.const [89] = Utf8 getName 
.const [90] = Utf8 ()Ljava/lang/String; 
.const [91] = Utf8 org/dsi/ifc/navigation/LIStreetHistoryEntry 
.const [92] = Utf8 getId 
.const [93] = Utf8 ()J 
.const [94] = Utf8 org/dsi/ifc/navigation/LIStreetHistoryEntry 
.const [95] = Utf8 getExtendedData 
.const [96] = Utf8 ()[Lorg/dsi/ifc/navigation/LIExtData; 
.const [97] = Utf8 java/lang/Object 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 org/dsi/ifc/navigation/LIStreetHistoryEntry 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [104] = Utf8 putBool 
.const [105] = Utf8 (Z)V 
.const [106] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [107] = Utf8 putOptionalString 
.const [108] = Utf8 (Ljava/lang/String;)V 
.const [109] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [110] = Utf8 putInt64 
.const [111] = Utf8 (J)V 
.const [112] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [113] = Utf8 putInt32 
.const [114] = Utf8 (I)V 
.const [115] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [116] = Utf8 getBool 
.const [117] = Utf8 ()Z 
.const [118] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [119] = Utf8 getOptionalString 
.const [120] = Utf8 ()Ljava/lang/String; 
.const [121] = Utf8 org/dsi/ifc/navigation/LIStreetHistoryEntry 
.const [122] = Utf8 name 
.const [123] = Utf8 Ljava/lang/String; 
.const [124] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [125] = Utf8 getInt64 
.const [126] = Utf8 ()J 
.const [127] = Utf8 org/dsi/ifc/navigation/LIStreetHistoryEntry 
.const [128] = Utf8 id 
.const [129] = Utf8 J 
.const [130] = Utf8 org/dsi/ifc/navigation/LIStreetHistoryEntry 
.const [131] = Utf8 extendedData 
.const [132] = Utf8 [Lorg/dsi/ifc/navigation/LIExtData; 
.const [133] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [134] = Utf8 getInt32 
.const [135] = Utf8 ()I 
.const [136] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/LIStreetHistoryEntrySerializer 
.const [137] = Class [136] 
.const [138] = Utf8 java/lang/Object 
.const [139] = Class [138] 
.const [140] = Utf8 Code 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 putOptionalLIStreetHistoryEntry 
.const [144] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/LIStreetHistoryEntry;)V 
.const [145] = Utf8 putOptionalLIStreetHistoryEntryVarArray 
.const [146] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/navigation/LIStreetHistoryEntry;)V 
.const [147] = Utf8 getOptionalLIStreetHistoryEntry 
.const [148] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/LIStreetHistoryEntry; 
.const [149] = Utf8 getOptionalLIStreetHistoryEntryVarArray 
.const [150] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/LIStreetHistoryEntry; 
.end class 
