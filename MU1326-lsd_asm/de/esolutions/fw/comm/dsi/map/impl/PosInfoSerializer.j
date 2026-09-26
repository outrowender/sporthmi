.version 50 0 
.class public super [225] 
.super [227] 

.method public annotation [229] : [230] 
    .attribute [228] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [231] : [232] 
    .attribute [228] .code stack 3 locals 10 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [28] 0 
L17:    iload_2 
L18:    ifne L125 
L21:    aload_1 
L22:    invokevirtual [18] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [29] 0 
L33:    aload_1 
L34:    invokevirtual [19] 
L37:    lstore 4 
L39:    aload_0 
L40:    lload 4 
L42:    invokeinterface [30] 0 
L47:    aload_1 
L48:    invokevirtual [20] 
L51:    astore 6 
L53:    aload_0 
L54:    aload 6 
L56:    invokestatic [2] 
L59:    aload_1 
L60:    invokevirtual [21] 
L63:    astore 7 
L65:    aload_0 
L66:    aload 7 
L68:    invokestatic [3] 
L71:    aload_1 
L72:    invokevirtual [22] 
L75:    astore 8 
L77:    aload_0 
L78:    aload 8 
L80:    invokeinterface [31] 0 
L85:    aload_1 
L86:    invokevirtual [23] 
L89:    astore 9 
L91:    aload_0 
L92:    aload 9 
L94:    invokeinterface [31] 0 
L99:    aload_1 
L100:   invokevirtual [24] 
L103:   astore 10 
L105:   aload_0 
L106:   aload 10 
L108:   invokestatic [4] 
L111:   aload_1 
L112:   invokevirtual [25] 
L115:   istore 11 
L117:   aload_0 
L118:   iload 11 
L120:   invokeinterface [29] 0 
L125:   return 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public static [233] : [234] 
    .attribute [228] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [28] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [29] 0 
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

.method public static [235] : [236] 
    .attribute [228] .code stack 3 locals 11 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [32] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L125 
L13:    new [33] 
L16:    dup 
L17:    invokespecial [27] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [34] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [35] 
L33:    aload_0 
L34:    invokeinterface [36] 0 
L39:    lstore 4 
L41:    aload_1 
L42:    lload 4 
L44:    putfield [37] 
L47:    aload_0 
L48:    invokestatic [7] 
L51:    astore 6 
L53:    aload_1 
L54:    aload 6 
L56:    putfield [38] 
L59:    aload_0 
L60:    invokestatic [8] 
L63:    astore 7 
L65:    aload_1 
L66:    aload 7 
L68:    putfield [39] 
L71:    aload_0 
L72:    invokeinterface [40] 0 
L77:    astore 8 
L79:    aload_1 
L80:    aload 8 
L82:    putfield [41] 
L85:    aload_0 
L86:    invokeinterface [40] 0 
L91:    astore 9 
L93:    aload_1 
L94:    aload 9 
L96:    putfield [42] 
L99:    aload_0 
L100:   invokestatic [9] 
L103:   astore 10 
L105:   aload_1 
L106:   aload 10 
L108:   putfield [43] 
L111:   aload_0 
L112:   invokeinterface [34] 0 
L117:   istore 11 
L119:   aload_1 
L120:   iload 11 
L122:   putfield [44] 
L125:   aload_1 
L126:   areturn 
L127:   nop 
L128:   
    .end code 
.end method 

.method public static [237] : [238] 
    .attribute [228] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [32] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [34] 0 
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
.const [2] = Method [45] [46] 
.const [3] = Method [47] [48] 
.const [4] = Method [49] [50] 
.const [5] = Method [51] [52] 
.const [6] = Class [53] 
.const [7] = Method [54] [55] 
.const [8] = Method [56] [57] 
.const [9] = Method [58] [59] 
.const [10] = Method [60] [61] 
.const [11] = Class [62] 
.const [12] = Class [63] 
.const [13] = Class [64] 
.const [14] = Class [65] 
.const [15] = Class [66] 
.const [16] = Class [67] 
.const [17] = Class [68] 
.const [18] = Method [69] [70] 
.const [19] = Method [71] [72] 
.const [20] = Method [73] [74] 
.const [21] = Method [75] [76] 
.const [22] = Method [77] [78] 
.const [23] = Method [79] [80] 
.const [24] = Method [81] [82] 
.const [25] = Method [83] [84] 
.const [26] = Method [85] [86] 
.const [27] = Method [87] [88] 
.const [28] = InterfaceMethod [89] [90] 
.const [29] = InterfaceMethod [91] [92] 
.const [30] = InterfaceMethod [93] [94] 
.const [31] = InterfaceMethod [95] [96] 
.const [32] = InterfaceMethod [97] [98] 
.const [33] = Class [99] 
.const [34] = InterfaceMethod [100] [101] 
.const [35] = Field [102] [103] 
.const [36] = InterfaceMethod [104] [105] 
.const [37] = Field [106] [107] 
.const [38] = Field [108] [109] 
.const [39] = Field [110] [111] 
.const [40] = InterfaceMethod [112] [113] 
.const [41] = Field [114] [115] 
.const [42] = Field [116] [117] 
.const [43] = Field [118] [119] 
.const [44] = Field [120] [121] 
.const [45] = Class [122] 
.const [46] = NameAndType [123] [124] 
.const [47] = Class [125] 
.const [48] = NameAndType [126] [127] 
.const [49] = Class [128] 
.const [50] = NameAndType [129] [130] 
.const [51] = Class [131] 
.const [52] = NameAndType [132] [133] 
.const [53] = Utf8 org/dsi/ifc/map/PosInfo 
.const [54] = Class [134] 
.const [55] = NameAndType [135] [136] 
.const [56] = Class [137] 
.const [57] = NameAndType [138] [139] 
.const [58] = Class [140] 
.const [59] = NameAndType [141] [142] 
.const [60] = Class [143] 
.const [61] = NameAndType [144] [145] 
.const [62] = Utf8 de/esolutions/fw/comm/dsi/map/impl/PosInfoSerializer 
.const [63] = Utf8 java/lang/Object 
.const [64] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [65] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [66] = Utf8 de/esolutions/fw/comm/dsi/map/impl/RectSerializer 
.const [67] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [68] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [69] = Class [146] 
.const [70] = NameAndType [147] [148] 
.const [71] = Class [149] 
.const [72] = NameAndType [150] [151] 
.const [73] = Class [152] 
.const [74] = NameAndType [153] [154] 
.const [75] = Class [155] 
.const [76] = NameAndType [156] [157] 
.const [77] = Class [158] 
.const [78] = NameAndType [159] [160] 
.const [79] = Class [161] 
.const [80] = NameAndType [162] [163] 
.const [81] = Class [164] 
.const [82] = NameAndType [165] [166] 
.const [83] = Class [167] 
.const [84] = NameAndType [168] [169] 
.const [85] = Class [170] 
.const [86] = NameAndType [171] [172] 
.const [87] = Class [173] 
.const [88] = NameAndType [174] [175] 
.const [89] = Class [176] 
.const [90] = NameAndType [177] [178] 
.const [91] = Class [179] 
.const [92] = NameAndType [180] [181] 
.const [93] = Class [182] 
.const [94] = NameAndType [183] [184] 
.const [95] = Class [185] 
.const [96] = NameAndType [186] [187] 
.const [97] = Class [188] 
.const [98] = NameAndType [189] [190] 
.const [99] = Utf8 org/dsi/ifc/map/PosInfo 
.const [100] = Class [191] 
.const [101] = NameAndType [192] [193] 
.const [102] = Class [194] 
.const [103] = NameAndType [195] [196] 
.const [104] = Class [197] 
.const [105] = NameAndType [198] [199] 
.const [106] = Class [200] 
.const [107] = NameAndType [201] [202] 
.const [108] = Class [203] 
.const [109] = NameAndType [204] [205] 
.const [110] = Class [206] 
.const [111] = NameAndType [207] [208] 
.const [112] = Class [209] 
.const [113] = NameAndType [210] [211] 
.const [114] = Class [212] 
.const [115] = NameAndType [213] [214] 
.const [116] = Class [215] 
.const [117] = NameAndType [216] [217] 
.const [118] = Class [218] 
.const [119] = NameAndType [219] [220] 
.const [120] = Class [221] 
.const [121] = NameAndType [222] [223] 
.const [122] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [123] = Utf8 putOptionalNavLocation 
.const [124] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/NavLocation;)V 
.const [125] = Utf8 de/esolutions/fw/comm/dsi/map/impl/RectSerializer 
.const [126] = Utf8 putOptionalRect 
.const [127] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/map/Rect;)V 
.const [128] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [129] = Utf8 putOptionalResourceLocator 
.const [130] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/ResourceLocator;)V 
.const [131] = Utf8 de/esolutions/fw/comm/dsi/map/impl/PosInfoSerializer 
.const [132] = Utf8 putOptionalPosInfo 
.const [133] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/map/PosInfo;)V 
.const [134] = Utf8 de/esolutions/fw/comm/dsi/global/impl/NavLocationSerializer 
.const [135] = Utf8 getOptionalNavLocation 
.const [136] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/NavLocation; 
.const [137] = Utf8 de/esolutions/fw/comm/dsi/map/impl/RectSerializer 
.const [138] = Utf8 getOptionalRect 
.const [139] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/map/Rect; 
.const [140] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [141] = Utf8 getOptionalResourceLocator 
.const [142] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [143] = Utf8 de/esolutions/fw/comm/dsi/map/impl/PosInfoSerializer 
.const [144] = Utf8 getOptionalPosInfo 
.const [145] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/map/PosInfo; 
.const [146] = Utf8 org/dsi/ifc/map/PosInfo 
.const [147] = Utf8 getEInfoType 
.const [148] = Utf8 ()I 
.const [149] = Utf8 org/dsi/ifc/map/PosInfo 
.const [150] = Utf8 getObjectId 
.const [151] = Utf8 ()J 
.const [152] = Utf8 org/dsi/ifc/map/PosInfo 
.const [153] = Utf8 getTLocation 
.const [154] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [155] = Utf8 org/dsi/ifc/map/PosInfo 
.const [156] = Utf8 getDisplayPosition 
.const [157] = Utf8 ()Lorg/dsi/ifc/map/Rect; 
.const [158] = Utf8 org/dsi/ifc/map/PosInfo 
.const [159] = Utf8 getInfoTxt 
.const [160] = Utf8 ()Ljava/lang/String; 
.const [161] = Utf8 org/dsi/ifc/map/PosInfo 
.const [162] = Utf8 getUrl 
.const [163] = Utf8 ()Ljava/lang/String; 
.const [164] = Utf8 org/dsi/ifc/map/PosInfo 
.const [165] = Utf8 getResourceLocator 
.const [166] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [167] = Utf8 org/dsi/ifc/map/PosInfo 
.const [168] = Utf8 getNumberOfObjects 
.const [169] = Utf8 ()I 
.const [170] = Utf8 java/lang/Object 
.const [171] = Utf8 <init> 
.const [172] = Utf8 ()V 
.const [173] = Utf8 org/dsi/ifc/map/PosInfo 
.const [174] = Utf8 <init> 
.const [175] = Utf8 ()V 
.const [176] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [177] = Utf8 putBool 
.const [178] = Utf8 (Z)V 
.const [179] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [180] = Utf8 putInt32 
.const [181] = Utf8 (I)V 
.const [182] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [183] = Utf8 putInt64 
.const [184] = Utf8 (J)V 
.const [185] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [186] = Utf8 putOptionalString 
.const [187] = Utf8 (Ljava/lang/String;)V 
.const [188] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [189] = Utf8 getBool 
.const [190] = Utf8 ()Z 
.const [191] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [192] = Utf8 getInt32 
.const [193] = Utf8 ()I 
.const [194] = Utf8 org/dsi/ifc/map/PosInfo 
.const [195] = Utf8 eInfoType 
.const [196] = Utf8 I 
.const [197] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [198] = Utf8 getInt64 
.const [199] = Utf8 ()J 
.const [200] = Utf8 org/dsi/ifc/map/PosInfo 
.const [201] = Utf8 objectId 
.const [202] = Utf8 J 
.const [203] = Utf8 org/dsi/ifc/map/PosInfo 
.const [204] = Utf8 tLocation 
.const [205] = Utf8 Lorg/dsi/ifc/global/NavLocation; 
.const [206] = Utf8 org/dsi/ifc/map/PosInfo 
.const [207] = Utf8 displayPosition 
.const [208] = Utf8 Lorg/dsi/ifc/map/Rect; 
.const [209] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [210] = Utf8 getOptionalString 
.const [211] = Utf8 ()Ljava/lang/String; 
.const [212] = Utf8 org/dsi/ifc/map/PosInfo 
.const [213] = Utf8 infoTxt 
.const [214] = Utf8 Ljava/lang/String; 
.const [215] = Utf8 org/dsi/ifc/map/PosInfo 
.const [216] = Utf8 url 
.const [217] = Utf8 Ljava/lang/String; 
.const [218] = Utf8 org/dsi/ifc/map/PosInfo 
.const [219] = Utf8 resourceLocator 
.const [220] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [221] = Utf8 org/dsi/ifc/map/PosInfo 
.const [222] = Utf8 numberOfObjects 
.const [223] = Utf8 I 
.const [224] = Utf8 de/esolutions/fw/comm/dsi/map/impl/PosInfoSerializer 
.const [225] = Class [224] 
.const [226] = Utf8 java/lang/Object 
.const [227] = Class [226] 
.const [228] = Utf8 Code 
.const [229] = Utf8 <init> 
.const [230] = Utf8 ()V 
.const [231] = Utf8 putOptionalPosInfo 
.const [232] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/map/PosInfo;)V 
.const [233] = Utf8 putOptionalPosInfoVarArray 
.const [234] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/map/PosInfo;)V 
.const [235] = Utf8 getOptionalPosInfo 
.const [236] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/map/PosInfo; 
.const [237] = Utf8 getOptionalPosInfoVarArray 
.const [238] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/map/PosInfo; 
.end class 
