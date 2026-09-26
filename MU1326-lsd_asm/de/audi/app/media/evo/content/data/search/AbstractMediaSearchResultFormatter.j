.version 50 0 
.class public super abstract [95] 
.super [97] 
.field private static final [98] [99] 
.field public static final [100] [101] 
.field public static final [102] [103] 
.field public static final [104] [105] 
.field public static final [106] [107] 
.field public static final [108] [109] 
.field public static final [110] [111] 
.field public static final [112] [113] 
.field public static final [114] [115] 
.field public static final [116] [117] 
.field public static final [118] [119] 
.field public static final [120] [121] 
.field public static final [122] [123] 
.field protected final [124] [125] 
.field private volatile [126] [127] 

.method public [129] : [130] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [29] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [30] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [131] : [132] 
    .attribute [128] .code stack 6 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [24] 
L5:     if_icmpne L9 
L8:     return 
L9:     aload_0 
L10:    getfield [23] 
L13:    ldc [2] 
L15:    ldc [3] 
L17:    ldc [4] 
L19:    iload_1 
L20:    i2l 
L21:    invokevirtual [25] 
L24:    pop 
L25:    aload_0 
L26:    iload_1 
L27:    putfield [30] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [133] : [134] 
    .attribute [128] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [26] 
L7:     ifeq L30 
L10:    aload_0 
L11:    getfield [23] 
L14:    ldc [5] 
L16:    ldc [6] 
L18:    ldc [4] 
L20:    aload_0 
L21:    getfield [24] 
L24:    invokestatic [7] 
L27:    invokevirtual [27] 
L30:    aload_0 
L31:    getfield [24] 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public abstract [135] : [136] 
    .attribute [128] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static [137] : [138] 
    .attribute [128] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L60 
            L63 
            L66 
            L69 
            L72 
            L75 
            L78 
            L81 
            L84 
            L87 
            L90 
            default : L93 

L60:    ldc [8] 
L62:    areturn 
L63:    ldc [9] 
L65:    areturn 
L66:    ldc [10] 
L68:    areturn 
L69:    ldc [11] 
L71:    areturn 
L72:    ldc [12] 
L74:    areturn 
L75:    ldc [13] 
L77:    areturn 
L78:    ldc [14] 
L80:    areturn 
L81:    ldc [15] 
L83:    areturn 
L84:    ldc [16] 
L86:    areturn 
L87:    ldc [17] 
L89:    areturn 
L90:    ldc [18] 
L92:    areturn 
L93:    ldc [19] 
L95:    areturn 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [31] 
.const [4] = String [32] 
.const [5] = Int 14808325 
.const [6] = String [33] 
.const [7] = Method [34] [35] 
.const [8] = String [36] 
.const [9] = String [37] 
.const [10] = String [38] 
.const [11] = String [39] 
.const [12] = String [40] 
.const [13] = String [41] 
.const [14] = String [42] 
.const [15] = String [43] 
.const [16] = String [44] 
.const [17] = String [45] 
.const [18] = String [46] 
.const [19] = String [47] 
.const [20] = Class [48] 
.const [21] = Class [49] 
.const [22] = Class [50] 
.const [23] = Field [51] [52] 
.const [24] = Field [53] [54] 
.const [25] = Method [55] [56] 
.const [26] = Method [57] [58] 
.const [27] = Method [59] [60] 
.const [28] = Method [61] [62] 
.const [29] = Field [63] [64] 
.const [30] = Field [65] [66] 
.const [31] = Utf8 '[%1.setFormatterType] %2' 
.const [32] = Utf8 AbstractMediaSearchResultFormatter 
.const [33] = Utf8 "[%1.getFormatterType] type='%2'" 
.const [34] = Class [67] 
.const [35] = NameAndType [68] [69] 
.const [36] = Utf8 FORMATTER_TYPE_TITLE 
.const [37] = Utf8 FORMATTER_TYPE_ARTIST 
.const [38] = Utf8 FORMATTER_TYPE_ALBUM 
.const [39] = Utf8 FORMATTER_TYPE_GENRE 
.const [40] = Utf8 FORMATTER_TYPE_VIDEO 
.const [41] = Utf8 FORMATTER_TYPE_PLAYLIST 
.const [42] = Utf8 FORMATTER_TYPE_PHYSICAL 
.const [43] = Utf8 FORMATTER_TYPE_COMPOSERS 
.const [44] = Utf8 FORMATTER_TYPE_AUDIOBOOKS 
.const [45] = Utf8 FORMATTER_TYPE_PODCASTS 
.const [46] = Utf8 FORMATTER_TYPE_FAVORITES 
.const [47] = Utf8 FORMATTER_TYPE_UNKNOWN 
.const [48] = Utf8 de/audi/app/media/evo/content/data/search/AbstractMediaSearchResultFormatter 
.const [49] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [50] = Utf8 de/audi/atip/log/LogChannel 
.const [51] = Class [70] 
.const [52] = NameAndType [71] [72] 
.const [53] = Class [73] 
.const [54] = NameAndType [74] [75] 
.const [55] = Class [76] 
.const [56] = NameAndType [77] [78] 
.const [57] = Class [79] 
.const [58] = NameAndType [80] [81] 
.const [59] = Class [82] 
.const [60] = NameAndType [83] [84] 
.const [61] = Class [85] 
.const [62] = NameAndType [86] [87] 
.const [63] = Class [88] 
.const [64] = NameAndType [89] [90] 
.const [65] = Class [91] 
.const [66] = NameAndType [92] [93] 
.const [67] = Utf8 de/audi/app/media/evo/content/data/search/AbstractMediaSearchResultFormatter 
.const [68] = Utf8 getFormatterType 
.const [69] = Utf8 (I)Ljava/lang/String; 
.const [70] = Utf8 de/audi/app/media/evo/content/data/search/AbstractMediaSearchResultFormatter 
.const [71] = Utf8 logger 
.const [72] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [73] = Utf8 de/audi/app/media/evo/content/data/search/AbstractMediaSearchResultFormatter 
.const [74] = Utf8 formatterType 
.const [75] = Utf8 I 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 log 
.const [78] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [79] = Utf8 de/audi/atip/log/LogChannel 
.const [80] = Utf8 isDebug2 
.const [81] = Utf8 ()Z 
.const [82] = Utf8 de/audi/atip/log/LogChannel 
.const [83] = Utf8 log 
.const [84] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [85] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 de/audi/app/media/evo/content/data/search/AbstractMediaSearchResultFormatter 
.const [89] = Utf8 logger 
.const [90] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [91] = Utf8 de/audi/app/media/evo/content/data/search/AbstractMediaSearchResultFormatter 
.const [92] = Utf8 formatterType 
.const [93] = Utf8 I 
.const [94] = Utf8 de/audi/app/media/evo/content/data/search/AbstractMediaSearchResultFormatter 
.const [95] = Class [94] 
.const [96] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [97] = Class [96] 
.const [98] = Utf8 LOGCLASS 
.const [99] = Utf8 Ljava/lang/String; 
.const [100] = Utf8 COUNT_FORMATTER_TYPES 
.const [101] = Utf8 I 
.const [102] = Utf8 FORMATTER_TYPE_TITLE 
.const [103] = Utf8 I 
.const [104] = Utf8 FORMATTER_TYPE_ARTIST 
.const [105] = Utf8 I 
.const [106] = Utf8 FORMATTER_TYPE_ALBUM 
.const [107] = Utf8 I 
.const [108] = Utf8 FORMATTER_TYPE_GENRE 
.const [109] = Utf8 I 
.const [110] = Utf8 FORMATTER_TYPE_VIDEO 
.const [111] = Utf8 I 
.const [112] = Utf8 FORMATTER_TYPE_PLAYLIST 
.const [113] = Utf8 I 
.const [114] = Utf8 FORMATTER_TYPE_PHYSICAL 
.const [115] = Utf8 I 
.const [116] = Utf8 FORMATTER_TYPE_COMPOSERS 
.const [117] = Utf8 I 
.const [118] = Utf8 FORMATTER_TYPE_AUDIOBOOKS 
.const [119] = Utf8 I 
.const [120] = Utf8 FORMATTER_TYPE_PODCASTS 
.const [121] = Utf8 I 
.const [122] = Utf8 FORMATTER_TYPE_FAVORITES 
.const [123] = Utf8 I 
.const [124] = Utf8 logger 
.const [125] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [126] = Utf8 formatterType 
.const [127] = Utf8 I 
.const [128] = Utf8 Code 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Lde/audi/atip/log/LogChannel;I)V 
.const [131] = Utf8 setFormatterType 
.const [132] = Utf8 (I)V 
.const [133] = Utf8 getFormatterType 
.const [134] = Utf8 ()I 
.const [135] = Utf8 setLayout 
.const [136] = Utf8 (I)V 
.const [137] = Utf8 getFormatterType 
.const [138] = Utf8 (I)Ljava/lang/String; 
.end class 
