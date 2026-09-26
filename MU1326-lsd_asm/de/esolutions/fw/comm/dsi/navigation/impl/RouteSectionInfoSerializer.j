.version 50 0 
.class public super [137] 
.super [139] 

.method public annotation [141] : [142] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [143] : [144] 
    .attribute [140] .code stack 3 locals 8 
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
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [19] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    lstore 5 
L39:    aload_0 
L40:    lload 5 
L42:    invokeinterface [19] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    lstore 7 
L53:    aload_0 
L54:    lload 7 
L56:    invokeinterface [19] 0 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    astore 9 
L67:    aload_0 
L68:    aload 9 
L70:    invokestatic [2] 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
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
L12:    invokeinterface [18] 0 
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
    .attribute [140] .code stack 3 locals 9 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [21] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L73 
L13:    new [22] 
L16:    dup 
L17:    invokespecial [17] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [23] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [24] 
L33:    aload_0 
L34:    invokeinterface [23] 0 
L39:    lstore 5 
L41:    aload_1 
L42:    lload 5 
L44:    putfield [25] 
L47:    aload_0 
L48:    invokeinterface [23] 0 
L53:    lstore 7 
L55:    aload_1 
L56:    lload 7 
L58:    putfield [26] 
L61:    aload_0 
L62:    invokestatic [5] 
L65:    astore 9 
L67:    aload_1 
L68:    aload 9 
L70:    putfield [27] 
L73:    aload_1 
L74:    areturn 
L75:    nop 
L76:    
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
.const [17] = Method [53] [54] 
.const [18] = InterfaceMethod [55] [56] 
.const [19] = InterfaceMethod [57] [58] 
.const [20] = InterfaceMethod [59] [60] 
.const [21] = InterfaceMethod [61] [62] 
.const [22] = Class [63] 
.const [23] = InterfaceMethod [64] [65] 
.const [24] = Field [66] [67] 
.const [25] = Field [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = Field [72] [73] 
.const [28] = InterfaceMethod [74] [75] 
.const [29] = Class [76] 
.const [30] = NameAndType [77] [78] 
.const [31] = Class [79] 
.const [32] = NameAndType [80] [81] 
.const [33] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [34] = Class [82] 
.const [35] = NameAndType [83] [84] 
.const [36] = Class [85] 
.const [37] = NameAndType [86] [87] 
.const [38] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RouteSectionInfoSerializer 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [41] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
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
.const [63] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
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
.const [76] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [77] = Utf8 putOptionalNavRectangle 
.const [78] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/NavRectangle;)V 
.const [79] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RouteSectionInfoSerializer 
.const [80] = Utf8 putOptionalRouteSectionInfo 
.const [81] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/RouteSectionInfo;)V 
.const [82] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [83] = Utf8 getOptionalNavRectangle 
.const [84] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavRectangle; 
.const [85] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RouteSectionInfoSerializer 
.const [86] = Utf8 getOptionalRouteSectionInfo 
.const [87] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/RouteSectionInfo; 
.const [88] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [89] = Utf8 getStartDistanceToDestination 
.const [90] = Utf8 ()J 
.const [91] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [92] = Utf8 getLength 
.const [93] = Utf8 ()J 
.const [94] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [95] = Utf8 getStartTimeToDestination 
.const [96] = Utf8 ()J 
.const [97] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [98] = Utf8 getBoundingRectangle 
.const [99] = Utf8 ()Lorg/dsi/ifc/global/NavRectangle; 
.const [100] = Utf8 java/lang/Object 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [107] = Utf8 putBool 
.const [108] = Utf8 (Z)V 
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
.const [119] = Utf8 getInt64 
.const [120] = Utf8 ()J 
.const [121] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [122] = Utf8 startDistanceToDestination 
.const [123] = Utf8 J 
.const [124] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [125] = Utf8 length 
.const [126] = Utf8 J 
.const [127] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [128] = Utf8 startTimeToDestination 
.const [129] = Utf8 J 
.const [130] = Utf8 org/dsi/ifc/navigation/RouteSectionInfo 
.const [131] = Utf8 boundingRectangle 
.const [132] = Utf8 Lorg/dsi/ifc/global/NavRectangle; 
.const [133] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [134] = Utf8 getInt32 
.const [135] = Utf8 ()I 
.const [136] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RouteSectionInfoSerializer 
.const [137] = Class [136] 
.const [138] = Utf8 java/lang/Object 
.const [139] = Class [138] 
.const [140] = Utf8 Code 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 putOptionalRouteSectionInfo 
.const [144] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/RouteSectionInfo;)V 
.const [145] = Utf8 putOptionalRouteSectionInfoVarArray 
.const [146] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/navigation/RouteSectionInfo;)V 
.const [147] = Utf8 getOptionalRouteSectionInfo 
.const [148] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/RouteSectionInfo; 
.const [149] = Utf8 getOptionalRouteSectionInfoVarArray 
.const [150] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/RouteSectionInfo; 
.end class 
