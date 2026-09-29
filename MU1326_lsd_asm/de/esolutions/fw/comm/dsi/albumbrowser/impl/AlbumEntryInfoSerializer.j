.version 50 0 
.class public super [159] 
.super [161] 

.method public annotation [163] : [164] 
    .attribute [162] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [165] : [166] 
    .attribute [162] .code stack 3 locals 10 
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
L18:    ifne L103 
L21:    aload_1 
L22:    invokevirtual [9] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [18] 0 
L33:    aload_1 
L34:    invokevirtual [10] 
L37:    lstore 5 
L39:    aload_0 
L40:    lload 5 
L42:    invokeinterface [18] 0 
L47:    aload_1 
L48:    invokevirtual [11] 
L51:    astore 7 
L53:    aload_0 
L54:    aload 7 
L56:    invokeinterface [19] 0 
L61:    aload_1 
L62:    invokevirtual [12] 
L65:    lstore 8 
L67:    aload_0 
L68:    lload 8 
L70:    invokeinterface [18] 0 
L75:    aload_1 
L76:    invokevirtual [13] 
L79:    astore 10 
L81:    aload_0 
L82:    aload 10 
L84:    invokeinterface [19] 0 
L89:    aload_1 
L90:    invokevirtual [14] 
L93:    istore 11 
L95:    aload_0 
L96:    iload 11 
L98:    invokeinterface [20] 0 
L103:   return 
L104:   
    .end code 
.end method 

.method public static [167] : [168] 
    .attribute [162] .code stack 3 locals 2 
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
L41:    invokestatic [2] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [169] : [170] 
    .attribute [162] .code stack 3 locals 11 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [21] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L103 
L13:    new [22] 
L16:    dup 
L17:    invokespecial [16] 
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
L48:    invokeinterface [26] 0 
L53:    astore 7 
L55:    aload_1 
L56:    aload 7 
L58:    putfield [27] 
L61:    aload_0 
L62:    invokeinterface [23] 0 
L67:    lstore 8 
L69:    aload_1 
L70:    lload 8 
L72:    putfield [28] 
L75:    aload_0 
L76:    invokeinterface [26] 0 
L81:    astore 10 
L83:    aload_1 
L84:    aload 10 
L86:    putfield [29] 
L89:    aload_0 
L90:    invokeinterface [30] 0 
L95:    istore 11 
L97:    aload_1 
L98:    iload 11 
L100:   putfield [31] 
L103:   aload_1 
L104:   areturn 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public static [171] : [172] 
    .attribute [162] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [21] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [30] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [3] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [4] 
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
.const [2] = Method [32] [33] 
.const [3] = Class [34] 
.const [4] = Method [35] [36] 
.const [5] = Class [37] 
.const [6] = Class [38] 
.const [7] = Class [39] 
.const [8] = Class [40] 
.const [9] = Method [41] [42] 
.const [10] = Method [43] [44] 
.const [11] = Method [45] [46] 
.const [12] = Method [47] [48] 
.const [13] = Method [49] [50] 
.const [14] = Method [51] [52] 
.const [15] = Method [53] [54] 
.const [16] = Method [55] [56] 
.const [17] = InterfaceMethod [57] [58] 
.const [18] = InterfaceMethod [59] [60] 
.const [19] = InterfaceMethod [61] [62] 
.const [20] = InterfaceMethod [63] [64] 
.const [21] = InterfaceMethod [65] [66] 
.const [22] = Class [67] 
.const [23] = InterfaceMethod [68] [69] 
.const [24] = Field [70] [71] 
.const [25] = Field [72] [73] 
.const [26] = InterfaceMethod [74] [75] 
.const [27] = Field [76] [77] 
.const [28] = Field [78] [79] 
.const [29] = Field [80] [81] 
.const [30] = InterfaceMethod [82] [83] 
.const [31] = Field [84] [85] 
.const [32] = Class [86] 
.const [33] = NameAndType [87] [88] 
.const [34] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [35] = Class [89] 
.const [36] = NameAndType [90] [91] 
.const [37] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/AlbumEntryInfoSerializer 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [40] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [41] = Class [92] 
.const [42] = NameAndType [93] [94] 
.const [43] = Class [95] 
.const [44] = NameAndType [96] [97] 
.const [45] = Class [98] 
.const [46] = NameAndType [99] [100] 
.const [47] = Class [101] 
.const [48] = NameAndType [102] [103] 
.const [49] = Class [104] 
.const [50] = NameAndType [105] [106] 
.const [51] = Class [107] 
.const [52] = NameAndType [108] [109] 
.const [53] = Class [110] 
.const [54] = NameAndType [111] [112] 
.const [55] = Class [113] 
.const [56] = NameAndType [114] [115] 
.const [57] = Class [116] 
.const [58] = NameAndType [117] [118] 
.const [59] = Class [119] 
.const [60] = NameAndType [120] [121] 
.const [61] = Class [122] 
.const [62] = NameAndType [123] [124] 
.const [63] = Class [125] 
.const [64] = NameAndType [126] [127] 
.const [65] = Class [128] 
.const [66] = NameAndType [129] [130] 
.const [67] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [68] = Class [131] 
.const [69] = NameAndType [132] [133] 
.const [70] = Class [134] 
.const [71] = NameAndType [135] [136] 
.const [72] = Class [137] 
.const [73] = NameAndType [138] [139] 
.const [74] = Class [140] 
.const [75] = NameAndType [141] [142] 
.const [76] = Class [143] 
.const [77] = NameAndType [144] [145] 
.const [78] = Class [146] 
.const [79] = NameAndType [147] [148] 
.const [80] = Class [149] 
.const [81] = NameAndType [150] [151] 
.const [82] = Class [152] 
.const [83] = NameAndType [153] [154] 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/AlbumEntryInfoSerializer 
.const [87] = Utf8 putOptionalAlbumEntryInfo 
.const [88] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/albumbrowser/AlbumEntryInfo;)V 
.const [89] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/AlbumEntryInfoSerializer 
.const [90] = Utf8 getOptionalAlbumEntryInfo 
.const [91] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/albumbrowser/AlbumEntryInfo; 
.const [92] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [93] = Utf8 getAlbumIdx 
.const [94] = Utf8 ()J 
.const [95] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [96] = Utf8 getArtistID 
.const [97] = Utf8 ()J 
.const [98] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [99] = Utf8 getArtist 
.const [100] = Utf8 ()Ljava/lang/String; 
.const [101] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [102] = Utf8 getAlbumID 
.const [103] = Utf8 ()J 
.const [104] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [105] = Utf8 getAlbum 
.const [106] = Utf8 ()Ljava/lang/String; 
.const [107] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [108] = Utf8 getFlags 
.const [109] = Utf8 ()I 
.const [110] = Utf8 java/lang/Object 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [117] = Utf8 putBool 
.const [118] = Utf8 (Z)V 
.const [119] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [120] = Utf8 putInt64 
.const [121] = Utf8 (J)V 
.const [122] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [123] = Utf8 putOptionalString 
.const [124] = Utf8 (Ljava/lang/String;)V 
.const [125] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [126] = Utf8 putInt32 
.const [127] = Utf8 (I)V 
.const [128] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [129] = Utf8 getBool 
.const [130] = Utf8 ()Z 
.const [131] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [132] = Utf8 getInt64 
.const [133] = Utf8 ()J 
.const [134] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [135] = Utf8 albumIdx 
.const [136] = Utf8 J 
.const [137] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [138] = Utf8 artistID 
.const [139] = Utf8 J 
.const [140] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [141] = Utf8 getOptionalString 
.const [142] = Utf8 ()Ljava/lang/String; 
.const [143] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [144] = Utf8 artist 
.const [145] = Utf8 Ljava/lang/String; 
.const [146] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [147] = Utf8 albumID 
.const [148] = Utf8 J 
.const [149] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [150] = Utf8 album 
.const [151] = Utf8 Ljava/lang/String; 
.const [152] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [153] = Utf8 getInt32 
.const [154] = Utf8 ()I 
.const [155] = Utf8 org/dsi/ifc/albumbrowser/AlbumEntryInfo 
.const [156] = Utf8 flags 
.const [157] = Utf8 I 
.const [158] = Utf8 de/esolutions/fw/comm/dsi/albumbrowser/impl/AlbumEntryInfoSerializer 
.const [159] = Class [158] 
.const [160] = Utf8 java/lang/Object 
.const [161] = Class [160] 
.const [162] = Utf8 Code 
.const [163] = Utf8 <init> 
.const [164] = Utf8 ()V 
.const [165] = Utf8 putOptionalAlbumEntryInfo 
.const [166] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/albumbrowser/AlbumEntryInfo;)V 
.const [167] = Utf8 putOptionalAlbumEntryInfoVarArray 
.const [168] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/albumbrowser/AlbumEntryInfo;)V 
.const [169] = Utf8 getOptionalAlbumEntryInfo 
.const [170] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/albumbrowser/AlbumEntryInfo; 
.const [171] = Utf8 getOptionalAlbumEntryInfoVarArray 
.const [172] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/albumbrowser/AlbumEntryInfo; 
.end class 
