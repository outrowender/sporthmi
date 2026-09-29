.version 50 0 
.class public super [187] 
.super [189] 

.method public annotation [191] : [192] 
    .attribute [190] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [193] : [194] 
    .attribute [190] .code stack 2 locals 9 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [25] 0 
L17:    iload_2 
L18:    ifne L127 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [26] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [26] 0 
L47:    aload_1 
L48:    invokevirtual [17] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [26] 0 
L61:    aload_1 
L62:    invokevirtual [18] 
L65:    istore 6 
L67:    aload_0 
L68:    iload 6 
L70:    invokeinterface [26] 0 
L75:    aload_1 
L76:    invokevirtual [19] 
L79:    astore 7 
L81:    aload_0 
L82:    aload 7 
L84:    invokestatic [2] 
L87:    aload_1 
L88:    invokevirtual [20] 
L91:    istore 8 
L93:    aload_0 
L94:    iload 8 
L96:    invokeinterface [26] 0 
L101:   aload_1 
L102:   invokevirtual [21] 
L105:   istore 9 
L107:   aload_0 
L108:   iload 9 
L110:   invokeinterface [26] 0 
L115:   aload_1 
L116:   invokevirtual [22] 
L119:   astore 10 
L121:   aload_0 
L122:   aload 10 
L124:   invokestatic [3] 
L127:   return 
L128:   
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
L12:    invokeinterface [25] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [26] 0 
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
    .attribute [190] .code stack 2 locals 10 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [27] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L127 
L13:    new [28] 
L16:    dup 
L17:    invokespecial [24] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [29] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [30] 
L33:    aload_0 
L34:    invokeinterface [29] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [31] 
L47:    aload_0 
L48:    invokeinterface [29] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [32] 
L61:    aload_0 
L62:    invokeinterface [29] 0 
L67:    istore 6 
L69:    aload_1 
L70:    iload 6 
L72:    putfield [33] 
L75:    aload_0 
L76:    invokestatic [6] 
L79:    astore 7 
L81:    aload_1 
L82:    aload 7 
L84:    putfield [34] 
L87:    aload_0 
L88:    invokeinterface [29] 0 
L93:    istore 8 
L95:    aload_1 
L96:    iload 8 
L98:    putfield [35] 
L101:   aload_0 
L102:   invokeinterface [29] 0 
L107:   istore 9 
L109:   aload_1 
L110:   iload 9 
L112:   putfield [36] 
L115:   aload_0 
L116:   invokestatic [7] 
L119:   astore 10 
L121:   aload_1 
L122:   aload 10 
L124:   putfield [37] 
L127:   aload_1 
L128:   areturn 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
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
.const [24] = Method [75] [76] 
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
.const [36] = Field [98] [99] 
.const [37] = Field [100] [101] 
.const [38] = Class [102] 
.const [39] = NameAndType [103] [104] 
.const [40] = Class [105] 
.const [41] = NameAndType [106] [107] 
.const [42] = Class [108] 
.const [43] = NameAndType [109] [110] 
.const [44] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [45] = Class [111] 
.const [46] = NameAndType [112] [113] 
.const [47] = Class [114] 
.const [48] = NameAndType [115] [116] 
.const [49] = Class [117] 
.const [50] = NameAndType [118] [119] 
.const [51] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/PopupStatusSerializer 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [54] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/MenuContextSerializer 
.const [55] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/PopupStatusFlagsSerializer 
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
.const [83] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
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
.const [102] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/MenuContextSerializer 
.const [103] = Utf8 putOptionalMenuContext 
.const [104] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/kombisync2/MenuContext;)V 
.const [105] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/PopupStatusFlagsSerializer 
.const [106] = Utf8 putOptionalPopupStatusFlags 
.const [107] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/kombisync2/PopupStatusFlags;)V 
.const [108] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/PopupStatusSerializer 
.const [109] = Utf8 putOptionalPopupStatus 
.const [110] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/kombisync2/PopupStatus;)V 
.const [111] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/MenuContextSerializer 
.const [112] = Utf8 getOptionalMenuContext 
.const [113] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/kombisync2/MenuContext; 
.const [114] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/PopupStatusFlagsSerializer 
.const [115] = Utf8 getOptionalPopupStatusFlags 
.const [116] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/kombisync2/PopupStatusFlags; 
.const [117] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/PopupStatusSerializer 
.const [118] = Utf8 getOptionalPopupStatus 
.const [119] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/kombisync2/PopupStatus; 
.const [120] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [121] = Utf8 getPopupID 
.const [122] = Utf8 ()I 
.const [123] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [124] = Utf8 getPopupID2 
.const [125] = Utf8 ()I 
.const [126] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [127] = Utf8 getScreenFormat 
.const [128] = Utf8 ()I 
.const [129] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [130] = Utf8 getFocus 
.const [131] = Utf8 ()I 
.const [132] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [133] = Utf8 getMenuContext 
.const [134] = Utf8 ()Lorg/dsi/ifc/kombisync2/MenuContext; 
.const [135] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [136] = Utf8 getPopupFlapLeft 
.const [137] = Utf8 ()I 
.const [138] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [139] = Utf8 getPopupFlapRight 
.const [140] = Utf8 ()I 
.const [141] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [142] = Utf8 getPopupStatusFlags 
.const [143] = Utf8 ()Lorg/dsi/ifc/kombisync2/PopupStatusFlags; 
.const [144] = Utf8 java/lang/Object 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [151] = Utf8 putBool 
.const [152] = Utf8 (Z)V 
.const [153] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [154] = Utf8 putInt32 
.const [155] = Utf8 (I)V 
.const [156] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [157] = Utf8 getBool 
.const [158] = Utf8 ()Z 
.const [159] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [160] = Utf8 getInt32 
.const [161] = Utf8 ()I 
.const [162] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [163] = Utf8 popupID 
.const [164] = Utf8 I 
.const [165] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [166] = Utf8 popupID2 
.const [167] = Utf8 I 
.const [168] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [169] = Utf8 screenFormat 
.const [170] = Utf8 I 
.const [171] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [172] = Utf8 focus 
.const [173] = Utf8 I 
.const [174] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [175] = Utf8 menuContext 
.const [176] = Utf8 Lorg/dsi/ifc/kombisync2/MenuContext; 
.const [177] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [178] = Utf8 popupFlapLeft 
.const [179] = Utf8 I 
.const [180] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [181] = Utf8 popupFlapRight 
.const [182] = Utf8 I 
.const [183] = Utf8 org/dsi/ifc/kombisync2/PopupStatus 
.const [184] = Utf8 popupStatusFlags 
.const [185] = Utf8 Lorg/dsi/ifc/kombisync2/PopupStatusFlags; 
.const [186] = Utf8 de/esolutions/fw/comm/dsi/kombisync2/impl/PopupStatusSerializer 
.const [187] = Class [186] 
.const [188] = Utf8 java/lang/Object 
.const [189] = Class [188] 
.const [190] = Utf8 Code 
.const [191] = Utf8 <init> 
.const [192] = Utf8 ()V 
.const [193] = Utf8 putOptionalPopupStatus 
.const [194] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/kombisync2/PopupStatus;)V 
.const [195] = Utf8 putOptionalPopupStatusVarArray 
.const [196] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/kombisync2/PopupStatus;)V 
.const [197] = Utf8 getOptionalPopupStatus 
.const [198] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/kombisync2/PopupStatus; 
.const [199] = Utf8 getOptionalPopupStatusVarArray 
.const [200] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/kombisync2/PopupStatus; 
.end class 
