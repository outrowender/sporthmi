.version 50 0 
.class public super [113] 
.super [115] 
.implements [117] 
.field private static final [118] [119] 
.field private final [120] [121] 
.field private volatile [122] [123] 
.field private volatile [124] [125] 

.method public [127] : [128] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [24] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [126] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokeinterface [25] 0 
L9:     ldc [2] 
L11:    ldc [3] 
L13:    ldc [4] 
L15:    iload_1 
L16:    i2l 
L17:    invokevirtual [16] 
L20:    pop 
L21:    iload_1 
L22:    ifeq L45 
L25:    iload_1 
L26:    iconst_1 
L27:    if_icmpeq L45 
L30:    iload_1 
L31:    iconst_2 
L32:    if_icmpeq L45 
L35:    iload_1 
L36:    iconst_4 
L37:    if_icmpeq L45 
L40:    iload_1 
L41:    iconst_3 
L42:    if_icmpne L49 
L45:    iconst_1 
L46:    goto L50 
L49:    iconst_0 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [126] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokeinterface [25] 0 
L9:     ldc [5] 
L11:    ldc [6] 
L13:    ldc [4] 
L15:    iload_1 
L16:    i2l 
L17:    invokevirtual [16] 
L20:    pop 
L21:    iload_1 
L22:    tableswitch 0 
            L56 
            L68 
            L88 
            L100 
            L100 
            default : L110 

L56:    new [26] 
L59:    dup 
L60:    aload_2 
L61:    aload_3 
L62:    aload 4 
L64:    invokespecial [20] 
L67:    areturn 
L68:    new [27] 
L71:    dup 
L72:    aload_2 
L73:    aload_3 
L74:    aload 4 
L76:    aload_0 
L77:    getfield [17] 
L80:    aload_0 
L81:    getfield [18] 
L84:    invokespecial [21] 
L87:    areturn 
L88:    new [30] 
L91:    dup 
L92:    aload_2 
L93:    aload_3 
L94:    aload 4 
L96:    invokespecial [22] 
L99:    areturn 
L100:   new [31] 
L103:   dup 
L104:   aload_2 
L105:   aload_3 
L106:   invokespecial [23] 
L109:   areturn 
L110:   aconst_null 
L111:   areturn 
L112:   
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [29] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [28] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [32] 
.const [4] = String [33] 
.const [5] = Int 1078071040 
.const [6] = String [34] 
.const [7] = Class [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Class [42] 
.const [15] = Field [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Field [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Field [61] [62] 
.const [25] = InterfaceMethod [63] [64] 
.const [26] = Class [65] 
.const [27] = Class [66] 
.const [28] = Field [67] [68] 
.const [29] = Field [69] [70] 
.const [30] = Class [71] 
.const [31] = Class [72] 
.const [32] = Utf8 "[%1.provideContent] '%2'" 
.const [33] = Utf8 MediaEVOContentProviderImpl 
.const [34] = Utf8 "[%1.createContent] '%2'" 
.const [35] = Utf8 de/audi/app/media/evo/content/cdda/CDDAContent 
.const [36] = Utf8 de/audi/app/media/evo/content/data/DataContent 
.const [37] = Utf8 de/audi/app/media/evo/content/dvdvideo/DVDVideoContent 
.const [38] = Utf8 de/audi/app/media/evo/content/tv/TVContent 
.const [39] = Utf8 de/audi/app/media/evo/content/MediaEVOContentProviderImpl 
.const [40] = Utf8 java/lang/Object 
.const [41] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [42] = Utf8 de/audi/atip/log/LogChannel 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Class [82] 
.const [50] = NameAndType [83] [84] 
.const [51] = Class [85] 
.const [52] = NameAndType [86] [87] 
.const [53] = Class [88] 
.const [54] = NameAndType [89] [90] 
.const [55] = Class [91] 
.const [56] = NameAndType [92] [93] 
.const [57] = Class [94] 
.const [58] = NameAndType [95] [96] 
.const [59] = Class [97] 
.const [60] = NameAndType [98] [99] 
.const [61] = Class [100] 
.const [62] = NameAndType [101] [102] 
.const [63] = Class [103] 
.const [64] = NameAndType [104] [105] 
.const [65] = Utf8 de/audi/app/media/evo/content/cdda/CDDAContent 
.const [66] = Utf8 de/audi/app/media/evo/content/data/DataContent 
.const [67] = Class [106] 
.const [68] = NameAndType [107] [108] 
.const [69] = Class [109] 
.const [70] = NameAndType [110] [111] 
.const [71] = Utf8 de/audi/app/media/evo/content/dvdvideo/DVDVideoContent 
.const [72] = Utf8 de/audi/app/media/evo/content/tv/TVContent 
.const [73] = Utf8 de/audi/app/media/evo/content/MediaEVOContentProviderImpl 
.const [74] = Utf8 logger 
.const [75] = Utf8 Lde/audi/app/media/logger/IMediaLogger; 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 log 
.const [78] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [79] = Utf8 de/audi/app/media/evo/content/MediaEVOContentProviderImpl 
.const [80] = Utf8 implicitRepeatHandler 
.const [81] = Utf8 Lde/audi/app/media/evo/content/IImplicitRepeatHandler; 
.const [82] = Utf8 de/audi/app/media/evo/content/MediaEVOContentProviderImpl 
.const [83] = Utf8 favoritesController 
.const [84] = Utf8 Lde/audi/app/media/evo/content/data/favorites/IFavoritesController; 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 de/audi/app/media/evo/content/cdda/CDDAContent 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (Lde/audi/app/media/content/IContentContext;Lde/audi/app/media/IMediaTerminal;Lde/audi/app/media/dsi/media/IMediaDSIPlayerController;)V 
.const [91] = Utf8 de/audi/app/media/evo/content/data/DataContent 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Lde/audi/app/media/content/IContentContext;Lde/audi/app/media/IMediaTerminal;Lde/audi/app/media/dsi/media/IMediaDSIPlayerController;Lde/audi/app/media/evo/content/IImplicitRepeatHandler;Lde/audi/app/media/evo/content/data/favorites/IFavoritesController;)V 
.const [94] = Utf8 de/audi/app/media/evo/content/dvdvideo/DVDVideoContent 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Lde/audi/app/media/content/IContentContext;Lde/audi/app/media/IMediaTerminal;Lde/audi/app/media/dsi/media/IMediaDSIPlayerController;)V 
.const [97] = Utf8 de/audi/app/media/evo/content/tv/TVContent 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (Lde/audi/app/media/content/IContentContext;Lde/audi/app/media/IMediaTerminal;)V 
.const [100] = Utf8 de/audi/app/media/evo/content/MediaEVOContentProviderImpl 
.const [101] = Utf8 logger 
.const [102] = Utf8 Lde/audi/app/media/logger/IMediaLogger; 
.const [103] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [104] = Utf8 main 
.const [105] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [106] = Utf8 de/audi/app/media/evo/content/MediaEVOContentProviderImpl 
.const [107] = Utf8 implicitRepeatHandler 
.const [108] = Utf8 Lde/audi/app/media/evo/content/IImplicitRepeatHandler; 
.const [109] = Utf8 de/audi/app/media/evo/content/MediaEVOContentProviderImpl 
.const [110] = Utf8 favoritesController 
.const [111] = Utf8 Lde/audi/app/media/evo/content/data/favorites/IFavoritesController; 
.const [112] = Utf8 de/audi/app/media/evo/content/MediaEVOContentProviderImpl 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 de/audi/app/media/extension/IContentProvider 
.const [117] = Class [116] 
.const [118] = Utf8 LOGCLASS 
.const [119] = Utf8 Ljava/lang/String; 
.const [120] = Utf8 logger 
.const [121] = Utf8 Lde/audi/app/media/logger/IMediaLogger; 
.const [122] = Utf8 favoritesController 
.const [123] = Utf8 Lde/audi/app/media/evo/content/data/favorites/IFavoritesController; 
.const [124] = Utf8 implicitRepeatHandler 
.const [125] = Utf8 Lde/audi/app/media/evo/content/IImplicitRepeatHandler; 
.const [126] = Utf8 Code 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Lde/audi/app/media/logger/IMediaLogger;)V 
.const [129] = Utf8 provideContent 
.const [130] = Utf8 (I)Z 
.const [131] = Utf8 createContent 
.const [132] = Utf8 (ILde/audi/app/media/content/IContentContext;Lde/audi/app/media/IMediaTerminal;Lde/audi/app/media/dsi/media/IMediaDSIPlayerController;)Lde/audi/app/media/content/IContent; 
.const [133] = Utf8 setFavoritesController 
.const [134] = Utf8 (Lde/audi/app/media/evo/content/data/favorites/IFavoritesController;)V 
.const [135] = Utf8 setImplicitRepeatHandler 
.const [136] = Utf8 (Lde/audi/app/media/evo/content/IImplicitRepeatHandler;)V 
.end class 
