.version 50 0 
.class public super [201] 
.super [203] 

.method public annotation [205] : [206] 
    .attribute [204] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [207] : [208] 
    .attribute [204] .code stack 2 locals 8 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [27] 0 
L17:    iload_2 
L18:    ifne L109 
L21:    aload_1 
L22:    invokevirtual [18] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokestatic [2] 
L31:    aload_1 
L32:    invokevirtual [19] 
L35:    astore 4 
L37:    aload_0 
L38:    aload 4 
L40:    invokestatic [2] 
L43:    aload_1 
L44:    invokevirtual [20] 
L47:    istore 5 
L49:    aload_0 
L50:    iload 5 
L52:    invokeinterface [27] 0 
L57:    aload_1 
L58:    invokevirtual [21] 
L61:    istore 6 
L63:    aload_0 
L64:    iload 6 
L66:    invokeinterface [28] 0 
L71:    aload_1 
L72:    invokevirtual [22] 
L75:    astore 7 
L77:    aload_0 
L78:    aload 7 
L80:    invokeinterface [29] 0 
L85:    aload_1 
L86:    invokevirtual [23] 
L89:    astore 8 
L91:    aload_0 
L92:    aload 8 
L94:    invokestatic [3] 
L97:    aload_1 
L98:    invokevirtual [24] 
L101:   astore 9 
L103:   aload_0 
L104:   aload 9 
L106:   invokestatic [4] 
L109:   return 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public static [209] : [210] 
    .attribute [204] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [27] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [28] 0 
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
L41:    invokestatic [5] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [211] : [212] 
    .attribute [204] .code stack 2 locals 9 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [30] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L109 
L13:    new [31] 
L16:    dup 
L17:    invokespecial [26] 
L20:    astore_1 
L21:    aload_0 
L22:    invokestatic [7] 
L25:    astore_3 
L26:    aload_1 
L27:    aload_3 
L28:    putfield [32] 
L31:    aload_0 
L32:    invokestatic [7] 
L35:    astore 4 
L37:    aload_1 
L38:    aload 4 
L40:    putfield [33] 
L43:    aload_0 
L44:    invokeinterface [30] 0 
L49:    istore 5 
L51:    aload_1 
L52:    iload 5 
L54:    putfield [34] 
L57:    aload_0 
L58:    invokeinterface [35] 0 
L63:    istore 6 
L65:    aload_1 
L66:    iload 6 
L68:    putfield [36] 
L71:    aload_0 
L72:    invokeinterface [37] 0 
L77:    astore 7 
L79:    aload_1 
L80:    aload 7 
L82:    putfield [38] 
L85:    aload_0 
L86:    invokestatic [8] 
L89:    astore 8 
L91:    aload_1 
L92:    aload 8 
L94:    putfield [39] 
L97:    aload_0 
L98:    invokestatic [9] 
L101:   astore 9 
L103:   aload_1 
L104:   aload 9 
L106:   putfield [40] 
L109:   aload_1 
L110:   areturn 
L111:   nop 
L112:   
    .end code 
.end method 

.method public static [213] : [214] 
    .attribute [204] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [30] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [35] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [6] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [10] 
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
.const [2] = Method [41] [42] 
.const [3] = Method [43] [44] 
.const [4] = Method [45] [46] 
.const [5] = Method [47] [48] 
.const [6] = Class [49] 
.const [7] = Method [50] [51] 
.const [8] = Method [52] [53] 
.const [9] = Method [54] [55] 
.const [10] = Method [56] [57] 
.const [11] = Class [58] 
.const [12] = Class [59] 
.const [13] = Class [60] 
.const [14] = Class [61] 
.const [15] = Class [62] 
.const [16] = Class [63] 
.const [17] = Class [64] 
.const [18] = Method [65] [66] 
.const [19] = Method [67] [68] 
.const [20] = Method [69] [70] 
.const [21] = Method [71] [72] 
.const [22] = Method [73] [74] 
.const [23] = Method [75] [76] 
.const [24] = Method [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Method [81] [82] 
.const [27] = InterfaceMethod [83] [84] 
.const [28] = InterfaceMethod [85] [86] 
.const [29] = InterfaceMethod [87] [88] 
.const [30] = InterfaceMethod [89] [90] 
.const [31] = Class [91] 
.const [32] = Field [92] [93] 
.const [33] = Field [94] [95] 
.const [34] = Field [96] [97] 
.const [35] = InterfaceMethod [98] [99] 
.const [36] = Field [100] [101] 
.const [37] = InterfaceMethod [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Field [108] [109] 
.const [41] = Class [110] 
.const [42] = NameAndType [111] [112] 
.const [43] = Class [113] 
.const [44] = NameAndType [114] [115] 
.const [45] = Class [116] 
.const [46] = NameAndType [117] [118] 
.const [47] = Class [119] 
.const [48] = NameAndType [120] [121] 
.const [49] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [50] = Class [122] 
.const [51] = NameAndType [123] [124] 
.const [52] = Class [125] 
.const [53] = NameAndType [126] [127] 
.const [54] = Class [128] 
.const [55] = NameAndType [129] [130] 
.const [56] = Class [131] 
.const [57] = NameAndType [132] [133] 
.const [58] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RgRouteCostChangeInformationSerializer 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [61] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/CalculatedRouteListElementSerializer 
.const [62] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [63] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RouteSectionInfoSerializer 
.const [64] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [65] = Class [134] 
.const [66] = NameAndType [135] [136] 
.const [67] = Class [137] 
.const [68] = NameAndType [138] [139] 
.const [69] = Class [140] 
.const [70] = NameAndType [141] [142] 
.const [71] = Class [143] 
.const [72] = NameAndType [144] [145] 
.const [73] = Class [146] 
.const [74] = NameAndType [147] [148] 
.const [75] = Class [149] 
.const [76] = NameAndType [150] [151] 
.const [77] = Class [152] 
.const [78] = NameAndType [153] [154] 
.const [79] = Class [155] 
.const [80] = NameAndType [156] [157] 
.const [81] = Class [158] 
.const [82] = NameAndType [159] [160] 
.const [83] = Class [161] 
.const [84] = NameAndType [162] [163] 
.const [85] = Class [164] 
.const [86] = NameAndType [165] [166] 
.const [87] = Class [167] 
.const [88] = NameAndType [168] [169] 
.const [89] = Class [170] 
.const [90] = NameAndType [171] [172] 
.const [91] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [92] = Class [173] 
.const [93] = NameAndType [174] [175] 
.const [94] = Class [176] 
.const [95] = NameAndType [177] [178] 
.const [96] = Class [179] 
.const [97] = NameAndType [180] [181] 
.const [98] = Class [182] 
.const [99] = NameAndType [183] [184] 
.const [100] = Class [185] 
.const [101] = NameAndType [186] [187] 
.const [102] = Class [188] 
.const [103] = NameAndType [189] [190] 
.const [104] = Class [191] 
.const [105] = NameAndType [192] [193] 
.const [106] = Class [194] 
.const [107] = NameAndType [195] [196] 
.const [108] = Class [197] 
.const [109] = NameAndType [198] [199] 
.const [110] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/CalculatedRouteListElementSerializer 
.const [111] = Utf8 putOptionalCalculatedRouteListElement 
.const [112] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/CalculatedRouteListElement;)V 
.const [113] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [114] = Utf8 putOptionalNavRectangle 
.const [115] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/NavRectangle;)V 
.const [116] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RouteSectionInfoSerializer 
.const [117] = Utf8 putOptionalRouteSectionInfoVarArray 
.const [118] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/navigation/RouteSectionInfo;)V 
.const [119] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RgRouteCostChangeInformationSerializer 
.const [120] = Utf8 putOptionalRgRouteCostChangeInformation 
.const [121] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)V 
.const [122] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/CalculatedRouteListElementSerializer 
.const [123] = Utf8 getOptionalCalculatedRouteListElement 
.const [124] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [125] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavRectangleSerializer 
.const [126] = Utf8 getOptionalNavRectangle 
.const [127] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavRectangle; 
.const [128] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RouteSectionInfoSerializer 
.const [129] = Utf8 getOptionalRouteSectionInfoVarArray 
.const [130] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/RouteSectionInfo; 
.const [131] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RgRouteCostChangeInformationSerializer 
.const [132] = Utf8 getOptionalRgRouteCostChangeInformation 
.const [133] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation; 
.const [134] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [135] = Utf8 getOldRoute 
.const [136] = Utf8 ()Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [137] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [138] = Utf8 getNewRoute 
.const [139] = Utf8 ()Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [140] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [141] = Utf8 isNewRouteRecommended 
.const [142] = Utf8 ()Z 
.const [143] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [144] = Utf8 getTmcMsgId 
.const [145] = Utf8 ()I 
.const [146] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [147] = Utf8 getTmcMsgIds 
.const [148] = Utf8 ()[I 
.const [149] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [150] = Utf8 getBoundingRectangle 
.const [151] = Utf8 ()Lorg/dsi/ifc/global/NavRectangle; 
.const [152] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [153] = Utf8 getDetours 
.const [154] = Utf8 ()[Lorg/dsi/ifc/navigation/RouteSectionInfo; 
.const [155] = Utf8 java/lang/Object 
.const [156] = Utf8 <init> 
.const [157] = Utf8 ()V 
.const [158] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [162] = Utf8 putBool 
.const [163] = Utf8 (Z)V 
.const [164] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [165] = Utf8 putInt32 
.const [166] = Utf8 (I)V 
.const [167] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [168] = Utf8 putOptionalInt32VarArray 
.const [169] = Utf8 ([I)V 
.const [170] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [171] = Utf8 getBool 
.const [172] = Utf8 ()Z 
.const [173] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [174] = Utf8 oldRoute 
.const [175] = Utf8 Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [176] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [177] = Utf8 newRoute 
.const [178] = Utf8 Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [179] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [180] = Utf8 newRouteRecommended 
.const [181] = Utf8 Z 
.const [182] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [183] = Utf8 getInt32 
.const [184] = Utf8 ()I 
.const [185] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [186] = Utf8 tmcMsgId 
.const [187] = Utf8 I 
.const [188] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [189] = Utf8 getOptionalInt32VarArray 
.const [190] = Utf8 ()[I 
.const [191] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [192] = Utf8 tmcMsgIds 
.const [193] = Utf8 [I 
.const [194] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [195] = Utf8 boundingRectangle 
.const [196] = Utf8 Lorg/dsi/ifc/global/NavRectangle; 
.const [197] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [198] = Utf8 detours 
.const [199] = Utf8 [Lorg/dsi/ifc/navigation/RouteSectionInfo; 
.const [200] = Utf8 de/esolutions/fw/comm/dsi/navigation/impl/RgRouteCostChangeInformationSerializer 
.const [201] = Class [200] 
.const [202] = Utf8 java/lang/Object 
.const [203] = Class [202] 
.const [204] = Utf8 Code 
.const [205] = Utf8 <init> 
.const [206] = Utf8 ()V 
.const [207] = Utf8 putOptionalRgRouteCostChangeInformation 
.const [208] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)V 
.const [209] = Utf8 putOptionalRgRouteCostChangeInformationVarArray 
.const [210] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)V 
.const [211] = Utf8 getOptionalRgRouteCostChangeInformation 
.const [212] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation; 
.const [213] = Utf8 getOptionalRgRouteCostChangeInformationVarArray 
.const [214] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation; 
.end class 
