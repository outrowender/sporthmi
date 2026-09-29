.version 50 0 
.class public super [211] 
.super [213] 

.method public annotation [215] : [216] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [217] : [218] 
    .attribute [214] .code stack 2 locals 10 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [26] 0 
L17:    iload_2 
L18:    ifne L141 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokeinterface [27] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokeinterface [27] 0 
L47:    aload_1 
L48:    invokevirtual [17] 
L51:    astore 5 
L53:    aload_0 
L54:    aload 5 
L56:    invokeinterface [27] 0 
L61:    aload_1 
L62:    invokevirtual [18] 
L65:    astore 6 
L67:    aload_0 
L68:    aload 6 
L70:    invokeinterface [27] 0 
L75:    aload_1 
L76:    invokevirtual [19] 
L79:    astore 7 
L81:    aload_0 
L82:    aload 7 
L84:    invokeinterface [27] 0 
L89:    aload_1 
L90:    invokevirtual [20] 
L93:    astore 8 
L95:    aload_0 
L96:    aload 8 
L98:    invokestatic [2] 
L101:   aload_1 
L102:   invokevirtual [21] 
L105:   astore 9 
L107:   aload_0 
L108:   aload 9 
L110:   invokestatic [3] 
L113:   aload_1 
L114:   invokevirtual [22] 
L117:   istore 10 
L119:   aload_0 
L120:   iload 10 
L122:   invokeinterface [28] 0 
L127:   aload_1 
L128:   invokevirtual [23] 
L131:   istore 11 
L133:   aload_0 
L134:   iload 11 
L136:   invokeinterface [28] 0 
L141:   return 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method public static [219] : [220] 
    .attribute [214] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [26] 0 
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
L41:    invokestatic [4] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [221] : [222] 
    .attribute [214] .code stack 2 locals 11 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [29] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L141 
L13:    new [30] 
L16:    dup 
L17:    invokespecial [25] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [31] 0 
L27:    astore_3 
L28:    aload_1 
L29:    aload_3 
L30:    putfield [32] 
L33:    aload_0 
L34:    invokeinterface [31] 0 
L39:    astore 4 
L41:    aload_1 
L42:    aload 4 
L44:    putfield [33] 
L47:    aload_0 
L48:    invokeinterface [31] 0 
L53:    astore 5 
L55:    aload_1 
L56:    aload 5 
L58:    putfield [34] 
L61:    aload_0 
L62:    invokeinterface [31] 0 
L67:    astore 6 
L69:    aload_1 
L70:    aload 6 
L72:    putfield [35] 
L75:    aload_0 
L76:    invokeinterface [31] 0 
L81:    astore 7 
L83:    aload_1 
L84:    aload 7 
L86:    putfield [36] 
L89:    aload_0 
L90:    invokestatic [6] 
L93:    astore 8 
L95:    aload_1 
L96:    aload 8 
L98:    putfield [37] 
L101:   aload_0 
L102:   invokestatic [7] 
L105:   astore 9 
L107:   aload_1 
L108:   aload 9 
L110:   putfield [38] 
L113:   aload_0 
L114:   invokeinterface [39] 0 
L119:   istore 10 
L121:   aload_1 
L122:   iload 10 
L124:   putfield [40] 
L127:   aload_0 
L128:   invokeinterface [39] 0 
L133:   istore 11 
L135:   aload_1 
L136:   iload 11 
L138:   putfield [41] 
L141:   aload_1 
L142:   areturn 
L143:   nop 
L144:   
    .end code 
.end method 

.method public static [223] : [224] 
    .attribute [214] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [29] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [39] 0 
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
.const [2] = Method [42] [43] 
.const [3] = Method [44] [45] 
.const [4] = Method [46] [47] 
.const [5] = Class [48] 
.const [6] = Method [49] [50] 
.const [7] = Method [51] [52] 
.const [8] = Method [53] [54] 
.const [9] = Class [55] 
.const [10] = Class [56] 
.const [11] = Class [57] 
.const [12] = Class [58] 
.const [13] = Class [59] 
.const [14] = Class [60] 
.const [15] = Method [61] [62] 
.const [16] = Method [63] [64] 
.const [17] = Method [65] [66] 
.const [18] = Method [67] [68] 
.const [19] = Method [69] [70] 
.const [20] = Method [71] [72] 
.const [21] = Method [73] [74] 
.const [22] = Method [75] [76] 
.const [23] = Method [77] [78] 
.const [24] = Method [79] [80] 
.const [25] = Method [81] [82] 
.const [26] = InterfaceMethod [83] [84] 
.const [27] = InterfaceMethod [85] [86] 
.const [28] = InterfaceMethod [87] [88] 
.const [29] = InterfaceMethod [89] [90] 
.const [30] = Class [91] 
.const [31] = InterfaceMethod [92] [93] 
.const [32] = Field [94] [95] 
.const [33] = Field [96] [97] 
.const [34] = Field [98] [99] 
.const [35] = Field [100] [101] 
.const [36] = Field [102] [103] 
.const [37] = Field [104] [105] 
.const [38] = Field [106] [107] 
.const [39] = InterfaceMethod [108] [109] 
.const [40] = Field [110] [111] 
.const [41] = Field [112] [113] 
.const [42] = Class [114] 
.const [43] = NameAndType [115] [116] 
.const [44] = Class [117] 
.const [45] = NameAndType [118] [119] 
.const [46] = Class [120] 
.const [47] = NameAndType [121] [122] 
.const [48] = Utf8 org/dsi/ifc/online/OSRUser 
.const [49] = Class [123] 
.const [50] = NameAndType [124] [125] 
.const [51] = Class [126] 
.const [52] = NameAndType [127] [128] 
.const [53] = Class [129] 
.const [54] = NameAndType [130] [131] 
.const [55] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRUserSerializer 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [58] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRPersonalIdentifierSerializer 
.const [59] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRDeviceSerializer 
.const [60] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [61] = Class [132] 
.const [62] = NameAndType [133] [134] 
.const [63] = Class [135] 
.const [64] = NameAndType [136] [137] 
.const [65] = Class [138] 
.const [66] = NameAndType [139] [140] 
.const [67] = Class [141] 
.const [68] = NameAndType [142] [143] 
.const [69] = Class [144] 
.const [70] = NameAndType [145] [146] 
.const [71] = Class [147] 
.const [72] = NameAndType [148] [149] 
.const [73] = Class [150] 
.const [74] = NameAndType [151] [152] 
.const [75] = Class [153] 
.const [76] = NameAndType [154] [155] 
.const [77] = Class [156] 
.const [78] = NameAndType [157] [158] 
.const [79] = Class [159] 
.const [80] = NameAndType [160] [161] 
.const [81] = Class [162] 
.const [82] = NameAndType [163] [164] 
.const [83] = Class [165] 
.const [84] = NameAndType [166] [167] 
.const [85] = Class [168] 
.const [86] = NameAndType [169] [170] 
.const [87] = Class [171] 
.const [88] = NameAndType [172] [173] 
.const [89] = Class [174] 
.const [90] = NameAndType [175] [176] 
.const [91] = Utf8 org/dsi/ifc/online/OSRUser 
.const [92] = Class [177] 
.const [93] = NameAndType [178] [179] 
.const [94] = Class [180] 
.const [95] = NameAndType [181] [182] 
.const [96] = Class [183] 
.const [97] = NameAndType [184] [185] 
.const [98] = Class [186] 
.const [99] = NameAndType [187] [188] 
.const [100] = Class [189] 
.const [101] = NameAndType [190] [191] 
.const [102] = Class [192] 
.const [103] = NameAndType [193] [194] 
.const [104] = Class [195] 
.const [105] = NameAndType [196] [197] 
.const [106] = Class [198] 
.const [107] = NameAndType [199] [200] 
.const [108] = Class [201] 
.const [109] = NameAndType [202] [203] 
.const [110] = Class [204] 
.const [111] = NameAndType [205] [206] 
.const [112] = Class [207] 
.const [113] = NameAndType [208] [209] 
.const [114] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRPersonalIdentifierSerializer 
.const [115] = Utf8 putOptionalOSRPersonalIdentifier 
.const [116] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/online/OSRPersonalIdentifier;)V 
.const [117] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRDeviceSerializer 
.const [118] = Utf8 putOptionalOSRDeviceVarArray 
.const [119] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/online/OSRDevice;)V 
.const [120] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRUserSerializer 
.const [121] = Utf8 putOptionalOSRUser 
.const [122] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/online/OSRUser;)V 
.const [123] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRPersonalIdentifierSerializer 
.const [124] = Utf8 getOptionalOSRPersonalIdentifier 
.const [125] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/OSRPersonalIdentifier; 
.const [126] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRDeviceSerializer 
.const [127] = Utf8 getOptionalOSRDeviceVarArray 
.const [128] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/online/OSRDevice; 
.const [129] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRUserSerializer 
.const [130] = Utf8 getOptionalOSRUser 
.const [131] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/OSRUser; 
.const [132] = Utf8 org/dsi/ifc/online/OSRUser 
.const [133] = Utf8 getAuthIdentifier 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 org/dsi/ifc/online/OSRUser 
.const [136] = Utf8 getPortalUser 
.const [137] = Utf8 ()Ljava/lang/String; 
.const [138] = Utf8 org/dsi/ifc/online/OSRUser 
.const [139] = Utf8 getHash1 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 org/dsi/ifc/online/OSRUser 
.const [142] = Utf8 getHash2 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 org/dsi/ifc/online/OSRUser 
.const [145] = Utf8 getName 
.const [146] = Utf8 ()Ljava/lang/String; 
.const [147] = Utf8 org/dsi/ifc/online/OSRUser 
.const [148] = Utf8 getPersonalIdentifier 
.const [149] = Utf8 ()Lorg/dsi/ifc/online/OSRPersonalIdentifier; 
.const [150] = Utf8 org/dsi/ifc/online/OSRUser 
.const [151] = Utf8 getDevicesForAutologin 
.const [152] = Utf8 ()[Lorg/dsi/ifc/online/OSRDevice; 
.const [153] = Utf8 org/dsi/ifc/online/OSRUser 
.const [154] = Utf8 getPrivacyFlag 
.const [155] = Utf8 ()I 
.const [156] = Utf8 org/dsi/ifc/online/OSRUser 
.const [157] = Utf8 getUsertype 
.const [158] = Utf8 ()I 
.const [159] = Utf8 java/lang/Object 
.const [160] = Utf8 <init> 
.const [161] = Utf8 ()V 
.const [162] = Utf8 org/dsi/ifc/online/OSRUser 
.const [163] = Utf8 <init> 
.const [164] = Utf8 ()V 
.const [165] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [166] = Utf8 putBool 
.const [167] = Utf8 (Z)V 
.const [168] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [169] = Utf8 putOptionalString 
.const [170] = Utf8 (Ljava/lang/String;)V 
.const [171] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [172] = Utf8 putInt32 
.const [173] = Utf8 (I)V 
.const [174] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [175] = Utf8 getBool 
.const [176] = Utf8 ()Z 
.const [177] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [178] = Utf8 getOptionalString 
.const [179] = Utf8 ()Ljava/lang/String; 
.const [180] = Utf8 org/dsi/ifc/online/OSRUser 
.const [181] = Utf8 authIdentifier 
.const [182] = Utf8 Ljava/lang/String; 
.const [183] = Utf8 org/dsi/ifc/online/OSRUser 
.const [184] = Utf8 portalUser 
.const [185] = Utf8 Ljava/lang/String; 
.const [186] = Utf8 org/dsi/ifc/online/OSRUser 
.const [187] = Utf8 hash1 
.const [188] = Utf8 Ljava/lang/String; 
.const [189] = Utf8 org/dsi/ifc/online/OSRUser 
.const [190] = Utf8 hash2 
.const [191] = Utf8 Ljava/lang/String; 
.const [192] = Utf8 org/dsi/ifc/online/OSRUser 
.const [193] = Utf8 name 
.const [194] = Utf8 Ljava/lang/String; 
.const [195] = Utf8 org/dsi/ifc/online/OSRUser 
.const [196] = Utf8 personalIdentifier 
.const [197] = Utf8 Lorg/dsi/ifc/online/OSRPersonalIdentifier; 
.const [198] = Utf8 org/dsi/ifc/online/OSRUser 
.const [199] = Utf8 devicesForAutologin 
.const [200] = Utf8 [Lorg/dsi/ifc/online/OSRDevice; 
.const [201] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [202] = Utf8 getInt32 
.const [203] = Utf8 ()I 
.const [204] = Utf8 org/dsi/ifc/online/OSRUser 
.const [205] = Utf8 privacyFlag 
.const [206] = Utf8 I 
.const [207] = Utf8 org/dsi/ifc/online/OSRUser 
.const [208] = Utf8 usertype 
.const [209] = Utf8 I 
.const [210] = Utf8 de/esolutions/fw/comm/dsi/online/impl/OSRUserSerializer 
.const [211] = Class [210] 
.const [212] = Utf8 java/lang/Object 
.const [213] = Class [212] 
.const [214] = Utf8 Code 
.const [215] = Utf8 <init> 
.const [216] = Utf8 ()V 
.const [217] = Utf8 putOptionalOSRUser 
.const [218] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/online/OSRUser;)V 
.const [219] = Utf8 putOptionalOSRUserVarArray 
.const [220] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/online/OSRUser;)V 
.const [221] = Utf8 getOptionalOSRUser 
.const [222] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/online/OSRUser; 
.const [223] = Utf8 getOptionalOSRUserVarArray 
.const [224] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/online/OSRUser; 
.end class 
