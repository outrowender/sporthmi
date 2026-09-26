.version 50 0 
.class public super [209] 
.super [211] 

.method public annotation [213] : [214] 
    .attribute [212] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [215] : [216] 
    .attribute [212] .code stack 3 locals 13 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [23] 0 
L17:    iload_2 
L18:    ifne L143 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokeinterface [24] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    lstore 4 
L39:    aload_0 
L40:    lload 4 
L42:    invokeinterface [25] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    astore 6 
L53:    aload_0 
L54:    aload 6 
L56:    invokeinterface [24] 0 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    lstore 7 
L67:    aload_0 
L68:    lload 7 
L70:    invokeinterface [25] 0 
L75:    aload_1 
L76:    invokevirtual [16] 
L79:    astore 9 
L81:    aload_0 
L82:    aload 9 
L84:    invokestatic [2] 
L87:    aload_1 
L88:    invokevirtual [17] 
L91:    lstore 10 
L93:    aload_0 
L94:    lload 10 
L96:    invokeinterface [25] 0 
L101:   aload_1 
L102:   invokevirtual [18] 
L105:   istore 12 
L107:   aload_0 
L108:   iload 12 
L110:   invokeinterface [26] 0 
L115:   aload_1 
L116:   invokevirtual [19] 
L119:   istore 13 
L121:   aload_0 
L122:   iload 13 
L124:   invokeinterface [26] 0 
L129:   aload_1 
L130:   invokevirtual [20] 
L133:   istore 14 
L135:   aload_0 
L136:   iload 14 
L138:   invokeinterface [26] 0 
L143:   return 
L144:   
    .end code 
.end method 

.method public static [217] : [218] 
    .attribute [212] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [23] 0 
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
L41:    invokestatic [3] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [219] : [220] 
    .attribute [212] .code stack 3 locals 14 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [27] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L143 
L13:    new [28] 
L16:    dup 
L17:    invokespecial [22] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [29] 0 
L27:    astore_3 
L28:    aload_1 
L29:    aload_3 
L30:    putfield [30] 
L33:    aload_0 
L34:    invokeinterface [31] 0 
L39:    lstore 4 
L41:    aload_1 
L42:    lload 4 
L44:    putfield [32] 
L47:    aload_0 
L48:    invokeinterface [29] 0 
L53:    astore 6 
L55:    aload_1 
L56:    aload 6 
L58:    putfield [33] 
L61:    aload_0 
L62:    invokeinterface [31] 0 
L67:    lstore 7 
L69:    aload_1 
L70:    lload 7 
L72:    putfield [34] 
L75:    aload_0 
L76:    invokestatic [5] 
L79:    astore 9 
L81:    aload_1 
L82:    aload 9 
L84:    putfield [35] 
L87:    aload_0 
L88:    invokeinterface [31] 0 
L93:    lstore 10 
L95:    aload_1 
L96:    lload 10 
L98:    putfield [36] 
L101:   aload_0 
L102:   invokeinterface [37] 0 
L107:   istore 12 
L109:   aload_1 
L110:   iload 12 
L112:   putfield [38] 
L115:   aload_0 
L116:   invokeinterface [37] 0 
L121:   istore 13 
L123:   aload_1 
L124:   iload 13 
L126:   putfield [39] 
L129:   aload_0 
L130:   invokeinterface [37] 0 
L135:   istore 14 
L137:   aload_1 
L138:   iload 14 
L140:   putfield [40] 
L143:   aload_1 
L144:   areturn 
L145:   nop 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public static [221] : [222] 
    .attribute [212] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [27] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [37] 0 
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
.const [2] = Method [41] [42] 
.const [3] = Method [43] [44] 
.const [4] = Class [45] 
.const [5] = Method [46] [47] 
.const [6] = Method [48] [49] 
.const [7] = Class [50] 
.const [8] = Class [51] 
.const [9] = Class [52] 
.const [10] = Class [53] 
.const [11] = Class [54] 
.const [12] = Method [55] [56] 
.const [13] = Method [57] [58] 
.const [14] = Method [59] [60] 
.const [15] = Method [61] [62] 
.const [16] = Method [63] [64] 
.const [17] = Method [65] [66] 
.const [18] = Method [67] [68] 
.const [19] = Method [69] [70] 
.const [20] = Method [71] [72] 
.const [21] = Method [73] [74] 
.const [22] = Method [75] [76] 
.const [23] = InterfaceMethod [77] [78] 
.const [24] = InterfaceMethod [79] [80] 
.const [25] = InterfaceMethod [81] [82] 
.const [26] = InterfaceMethod [83] [84] 
.const [27] = InterfaceMethod [85] [86] 
.const [28] = Class [87] 
.const [29] = InterfaceMethod [88] [89] 
.const [30] = Field [90] [91] 
.const [31] = InterfaceMethod [92] [93] 
.const [32] = Field [94] [95] 
.const [33] = Field [96] [97] 
.const [34] = Field [98] [99] 
.const [35] = Field [100] [101] 
.const [36] = Field [102] [103] 
.const [37] = InterfaceMethod [104] [105] 
.const [38] = Field [106] [107] 
.const [39] = Field [108] [109] 
.const [40] = Field [110] [111] 
.const [41] = Class [112] 
.const [42] = NameAndType [113] [114] 
.const [43] = Class [115] 
.const [44] = NameAndType [116] [117] 
.const [45] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [46] = Class [118] 
.const [47] = NameAndType [119] [120] 
.const [48] = Class [121] 
.const [49] = NameAndType [122] [123] 
.const [50] = Utf8 de/esolutions/fw/comm/dsi/media/impl/ListEntryExtSerializer 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [53] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [54] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [55] = Class [124] 
.const [56] = NameAndType [125] [126] 
.const [57] = Class [127] 
.const [58] = NameAndType [128] [129] 
.const [59] = Class [130] 
.const [60] = NameAndType [131] [132] 
.const [61] = Class [133] 
.const [62] = NameAndType [134] [135] 
.const [63] = Class [136] 
.const [64] = NameAndType [137] [138] 
.const [65] = Class [139] 
.const [66] = NameAndType [140] [141] 
.const [67] = Class [142] 
.const [68] = NameAndType [143] [144] 
.const [69] = Class [145] 
.const [70] = NameAndType [146] [147] 
.const [71] = Class [148] 
.const [72] = NameAndType [149] [150] 
.const [73] = Class [151] 
.const [74] = NameAndType [152] [153] 
.const [75] = Class [154] 
.const [76] = NameAndType [155] [156] 
.const [77] = Class [157] 
.const [78] = NameAndType [158] [159] 
.const [79] = Class [160] 
.const [80] = NameAndType [161] [162] 
.const [81] = Class [163] 
.const [82] = NameAndType [164] [165] 
.const [83] = Class [166] 
.const [84] = NameAndType [167] [168] 
.const [85] = Class [169] 
.const [86] = NameAndType [170] [171] 
.const [87] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [88] = Class [172] 
.const [89] = NameAndType [173] [174] 
.const [90] = Class [175] 
.const [91] = NameAndType [176] [177] 
.const [92] = Class [178] 
.const [93] = NameAndType [179] [180] 
.const [94] = Class [181] 
.const [95] = NameAndType [182] [183] 
.const [96] = Class [184] 
.const [97] = NameAndType [185] [186] 
.const [98] = Class [187] 
.const [99] = NameAndType [188] [189] 
.const [100] = Class [190] 
.const [101] = NameAndType [191] [192] 
.const [102] = Class [193] 
.const [103] = NameAndType [194] [195] 
.const [104] = Class [196] 
.const [105] = NameAndType [197] [198] 
.const [106] = Class [199] 
.const [107] = NameAndType [200] [201] 
.const [108] = Class [202] 
.const [109] = NameAndType [203] [204] 
.const [110] = Class [205] 
.const [111] = NameAndType [206] [207] 
.const [112] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [113] = Utf8 putOptionalResourceLocator 
.const [114] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/ResourceLocator;)V 
.const [115] = Utf8 de/esolutions/fw/comm/dsi/media/impl/ListEntryExtSerializer 
.const [116] = Utf8 putOptionalListEntryExt 
.const [117] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/media/ListEntryExt;)V 
.const [118] = Utf8 de/esolutions/fw/comm/dsi/global/impl/ResourceLocatorSerializer 
.const [119] = Utf8 getOptionalResourceLocator 
.const [120] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/ResourceLocator; 
.const [121] = Utf8 de/esolutions/fw/comm/dsi/media/impl/ListEntryExtSerializer 
.const [122] = Utf8 getOptionalListEntryExt 
.const [123] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/media/ListEntryExt; 
.const [124] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [125] = Utf8 getAlbum 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [128] = Utf8 getAlbumID 
.const [129] = Utf8 ()J 
.const [130] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [131] = Utf8 getArtist 
.const [132] = Utf8 ()Ljava/lang/String; 
.const [133] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [134] = Utf8 getArtistID 
.const [135] = Utf8 ()J 
.const [136] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [137] = Utf8 getCoverArtResource 
.const [138] = Utf8 ()Lorg/dsi/ifc/global/ResourceLocator; 
.const [139] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [140] = Utf8 getTitleID 
.const [141] = Utf8 ()J 
.const [142] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [143] = Utf8 getFileCount 
.const [144] = Utf8 ()I 
.const [145] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [146] = Utf8 getFolderCount 
.const [147] = Utf8 ()I 
.const [148] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [149] = Utf8 getPlaylistCount 
.const [150] = Utf8 ()I 
.const [151] = Utf8 java/lang/Object 
.const [152] = Utf8 <init> 
.const [153] = Utf8 ()V 
.const [154] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [158] = Utf8 putBool 
.const [159] = Utf8 (Z)V 
.const [160] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [161] = Utf8 putOptionalString 
.const [162] = Utf8 (Ljava/lang/String;)V 
.const [163] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [164] = Utf8 putInt64 
.const [165] = Utf8 (J)V 
.const [166] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [167] = Utf8 putInt32 
.const [168] = Utf8 (I)V 
.const [169] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [170] = Utf8 getBool 
.const [171] = Utf8 ()Z 
.const [172] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [173] = Utf8 getOptionalString 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [176] = Utf8 album 
.const [177] = Utf8 Ljava/lang/String; 
.const [178] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [179] = Utf8 getInt64 
.const [180] = Utf8 ()J 
.const [181] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [182] = Utf8 albumID 
.const [183] = Utf8 J 
.const [184] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [185] = Utf8 artist 
.const [186] = Utf8 Ljava/lang/String; 
.const [187] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [188] = Utf8 artistID 
.const [189] = Utf8 J 
.const [190] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [191] = Utf8 coverArtResource 
.const [192] = Utf8 Lorg/dsi/ifc/global/ResourceLocator; 
.const [193] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [194] = Utf8 titleID 
.const [195] = Utf8 J 
.const [196] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [197] = Utf8 getInt32 
.const [198] = Utf8 ()I 
.const [199] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [200] = Utf8 fileCount 
.const [201] = Utf8 I 
.const [202] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [203] = Utf8 folderCount 
.const [204] = Utf8 I 
.const [205] = Utf8 org/dsi/ifc/media/ListEntryExt 
.const [206] = Utf8 playlistCount 
.const [207] = Utf8 I 
.const [208] = Utf8 de/esolutions/fw/comm/dsi/media/impl/ListEntryExtSerializer 
.const [209] = Class [208] 
.const [210] = Utf8 java/lang/Object 
.const [211] = Class [210] 
.const [212] = Utf8 Code 
.const [213] = Utf8 <init> 
.const [214] = Utf8 ()V 
.const [215] = Utf8 putOptionalListEntryExt 
.const [216] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/media/ListEntryExt;)V 
.const [217] = Utf8 putOptionalListEntryExtVarArray 
.const [218] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/media/ListEntryExt;)V 
.const [219] = Utf8 getOptionalListEntryExt 
.const [220] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/media/ListEntryExt; 
.const [221] = Utf8 getOptionalListEntryExtVarArray 
.const [222] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/media/ListEntryExt; 
.end class 
