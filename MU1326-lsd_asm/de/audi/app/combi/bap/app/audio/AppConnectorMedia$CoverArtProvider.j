.version 50 0 
.class super [152] 
.super [154] 
.implements [156] 
.field private final [157] [158] 
.field private final synthetic [159] [160] 

.method private [162] : [163] 
    .attribute [161] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [28] 
L5:     aload_0 
L6:     invokespecial [25] 
L9:     aload_0 
L10:    new [29] 
L13:    dup 
L14:    invokespecial [26] 
L17:    putfield [30] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [161] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     sipush 255 
L5:     invokevirtual [21] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [161] .code stack 6 locals 1 
L0:     new [31] 
L3:     dup 
L4:     lload_1 
L5:     invokespecial [27] 
L8:     astore 4 
L10:    aload_0 
L11:    getfield [20] 
L14:    aload 4 
L16:    invokeinterface [32] 0 
L21:    ifeq L62 
L24:    aload_0 
L25:    getfield [19] 
L28:    invokestatic [4] 
L31:    checkcast [5] 
L34:    invokevirtual [22] 
L37:    lload_1 
L38:    iload_3 
L39:    aload_0 
L40:    getfield [20] 
L43:    aload 4 
L45:    invokeinterface [33] 0 
L50:    checkcast [6] 
L53:    iconst_0 
L54:    invokeinterface [34] 0 
L59:    goto L113 
L62:    aload_0 
L63:    getfield [19] 
L66:    invokestatic [7] 
L69:    instanceof [8] 
L72:    ifeq L113 
L75:    aload_0 
L76:    getfield [19] 
L79:    invokestatic [9] 
L82:    ldc [10] 
L84:    ldc [11] 
L86:    lload_1 
L87:    invokevirtual [23] 
L90:    pop 
L91:    aload_0 
L92:    getfield [19] 
L95:    invokestatic [12] 
L98:    checkcast [5] 
L101:   invokevirtual [22] 
L104:   lload_1 
L105:   iload_3 
L106:   aconst_null 
L107:   iconst_0 
L108:   invokeinterface [34] 0 
L113:   return 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [168] : [169] 
    .attribute [161] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     new [31] 
L7:     dup 
L8:     lload_1 
L9:     invokespecial [27] 
L12:    aload_3 
L13:    invokeinterface [35] 0 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public [170] : [171] 
    .attribute [161] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokeinterface [36] 0 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method synthetic [172] : [173] 
    .attribute [161] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [24] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = Class [38] 
.const [4] = Method [39] [40] 
.const [5] = Class [41] 
.const [6] = Class [42] 
.const [7] = Method [43] [44] 
.const [8] = Class [45] 
.const [9] = Method [46] [47] 
.const [10] = Int -2137614336 
.const [11] = String [48] 
.const [12] = Method [49] [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Class [53] 
.const [16] = Class [54] 
.const [17] = Class [55] 
.const [18] = Class [56] 
.const [19] = Field [57] [58] 
.const [20] = Field [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Field [75] [76] 
.const [29] = Class [77] 
.const [30] = Field [78] [79] 
.const [31] = Class [80] 
.const [32] = InterfaceMethod [81] [82] 
.const [33] = InterfaceMethod [83] [84] 
.const [34] = InterfaceMethod [85] [86] 
.const [35] = InterfaceMethod [87] [88] 
.const [36] = InterfaceMethod [89] [90] 
.const [37] = Utf8 java/util/HashMap 
.const [38] = Utf8 java/lang/Long 
.const [39] = Class [91] 
.const [40] = NameAndType [92] [93] 
.const [41] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [42] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [43] = Class [94] 
.const [44] = NameAndType [95] [96] 
.const [45] = Utf8 de/audi/atip/interapp/combi/bap/audio/CombiBAPServiceMediaListener 
.const [46] = Class [97] 
.const [47] = NameAndType [98] [99] 
.const [48] = Utf8 "[AppConnectorMedia.CoverArtProvider#requestPicture] call media service 'requestCoverArt(bapEntryID=%1)'" 
.const [49] = Class [100] 
.const [50] = NameAndType [101] [102] 
.const [51] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia$CoverArtProvider 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 java/util/Map 
.const [54] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia 
.const [55] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Class [103] 
.const [58] = NameAndType [104] [105] 
.const [59] = Class [106] 
.const [60] = NameAndType [107] [108] 
.const [61] = Class [109] 
.const [62] = NameAndType [110] [111] 
.const [63] = Class [112] 
.const [64] = NameAndType [113] [114] 
.const [65] = Class [115] 
.const [66] = NameAndType [116] [117] 
.const [67] = Class [118] 
.const [68] = NameAndType [119] [120] 
.const [69] = Class [121] 
.const [70] = NameAndType [122] [123] 
.const [71] = Class [124] 
.const [72] = NameAndType [125] [126] 
.const [73] = Class [127] 
.const [74] = NameAndType [128] [129] 
.const [75] = Class [130] 
.const [76] = NameAndType [131] [132] 
.const [77] = Utf8 java/util/HashMap 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Utf8 java/lang/Long 
.const [81] = Class [136] 
.const [82] = NameAndType [137] [138] 
.const [83] = Class [139] 
.const [84] = NameAndType [140] [141] 
.const [85] = Class [142] 
.const [86] = NameAndType [143] [144] 
.const [87] = Class [145] 
.const [88] = NameAndType [146] [147] 
.const [89] = Class [148] 
.const [90] = NameAndType [149] [150] 
.const [91] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia 
.const [92] = Utf8 access$000 
.const [93] = Utf8 (Lde/audi/app/combi/bap/app/audio/AppConnectorMedia;)Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [94] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia 
.const [95] = Utf8 access$100 
.const [96] = Utf8 (Lde/audi/app/combi/bap/app/audio/AppConnectorMedia;)Lde/audi/atip/interapp/bap/BAPServiceListener; 
.const [97] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia 
.const [98] = Utf8 access$200 
.const [99] = Utf8 (Lde/audi/app/combi/bap/app/audio/AppConnectorMedia;)Lde/audi/atip/log/LogChannel; 
.const [100] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia 
.const [101] = Utf8 access$300 
.const [102] = Utf8 (Lde/audi/app/combi/bap/app/audio/AppConnectorMedia;)Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [103] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia$CoverArtProvider 
.const [104] = Utf8 this$0 
.const [105] = Utf8 Lde/audi/app/combi/bap/app/audio/AppConnectorMedia; 
.const [106] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia$CoverArtProvider 
.const [107] = Utf8 id2pictureURL 
.const [108] = Utf8 Ljava/util/Map; 
.const [109] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia$CoverArtProvider 
.const [110] = Utf8 requestPicture 
.const [111] = Utf8 (JI)V 
.const [112] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [113] = Utf8 getPictureManager 
.const [114] = Utf8 ()Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;J)Z 
.const [118] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia$CoverArtProvider 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lde/audi/app/combi/bap/app/audio/AppConnectorMedia;)V 
.const [121] = Utf8 java/lang/Object 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 java/util/HashMap 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 java/lang/Long 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (J)V 
.const [130] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia$CoverArtProvider 
.const [131] = Utf8 this$0 
.const [132] = Utf8 Lde/audi/app/combi/bap/app/audio/AppConnectorMedia; 
.const [133] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia$CoverArtProvider 
.const [134] = Utf8 id2pictureURL 
.const [135] = Utf8 Ljava/util/Map; 
.const [136] = Utf8 java/util/Map 
.const [137] = Utf8 containsKey 
.const [138] = Utf8 (Ljava/lang/Object;)Z 
.const [139] = Utf8 java/util/Map 
.const [140] = Utf8 get 
.const [141] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [142] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [143] = Utf8 responseCoverArt 
.const [144] = Utf8 (JILorg/dsi/ifc/global/ResourceLocator;Z)V 
.const [145] = Utf8 java/util/Map 
.const [146] = Utf8 put 
.const [147] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [148] = Utf8 java/util/Map 
.const [149] = Utf8 clear 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorMedia$CoverArtProvider 
.const [152] = Class [151] 
.const [153] = Utf8 java/lang/Object 
.const [154] = Class [153] 
.const [155] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureProvider 
.const [156] = Class [155] 
.const [157] = Utf8 id2pictureURL 
.const [158] = Utf8 Ljava/util/Map; 
.const [159] = Utf8 this$0 
.const [160] = Utf8 Lde/audi/app/combi/bap/app/audio/AppConnectorMedia; 
.const [161] = Utf8 Code 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Lde/audi/app/combi/bap/app/audio/AppConnectorMedia;)V 
.const [164] = Utf8 requestPicture 
.const [165] = Utf8 (J)V 
.const [166] = Utf8 requestPicture 
.const [167] = Utf8 (JI)V 
.const [168] = Utf8 addToMapping 
.const [169] = Utf8 (JLorg/dsi/ifc/global/ResourceLocator;)V 
.const [170] = Utf8 clearMapping 
.const [171] = Utf8 ()V 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Lde/audi/app/combi/bap/app/audio/AppConnectorMedia;Lde/audi/app/combi/bap/app/audio/AppConnectorMedia$1;)V 
.end class 
