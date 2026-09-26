.version 50 0 
.class public super [155] 
.super [157] 
.field private [158] [159] 
.field private final [160] [161] 
.field private final [162] [163] 
.field private final [164] [165] 
.field private final [166] [167] 
.field private [168] [169] 

.method public [171] : [172] 
    .attribute [170] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload 6 
L4:     invokespecial [22] 
L7:     aload_0 
L8:     aload_2 
L9:     putfield [25] 
L12:    aload_0 
L13:    iload 4 
L15:    putfield [26] 
L18:    aload_0 
L19:    iload 5 
L21:    putfield [27] 
L24:    aload_0 
L25:    iload_3 
L26:    putfield [28] 
L29:    aload_0 
L30:    iload_3 
L31:    invokestatic [2] 
L34:    putfield [29] 
L37:    aload_0 
L38:    aload_0 
L39:    putfield [30] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [170] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iload_3 
L4:     iload 4 
L6:     iload 5 
L8:     aload 6 
L10:    invokespecial [23] 
L13:    aload_0 
L14:    aload 7 
L16:    putfield [30] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [170] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifnonnull L21 
L7:     getstatic [3] 
L10:    sipush 10000 
L13:    ldc [4] 
L15:    invokevirtual [17] 
L18:    pop 
L19:    aconst_null 
L20:    areturn 
L21:    aload_0 
L22:    getfield [18] 
L25:    aload_0 
L26:    getfield [11] 
L29:    aload_0 
L30:    getfield [14] 
L33:    aload_0 
L34:    getfield [12] 
L37:    aload_0 
L38:    getfield [13] 
L41:    invokevirtual [19] 
L44:    astore_1 
L45:    aload_1 
L46:    ifnonnull L51 
L49:    aconst_null 
L50:    areturn 
L51:    aload_0 
L52:    getfield [14] 
L55:    iconst_0 
L56:    invokestatic [5] 
L59:    astore_2 
L60:    aload_0 
L61:    getfield [18] 
L64:    aload_1 
L65:    aload_2 
L66:    invokevirtual [20] 
L69:    astore_3 
L70:    aload_0 
L71:    getfield [18] 
L74:    aload_1 
L75:    invokevirtual [21] 
L78:    aload_3 
L79:    ifnonnull L84 
L82:    aconst_null 
L83:    areturn 
L84:    aload_0 
L85:    aconst_null 
L86:    putfield [25] 
L89:    new [31] 
L92:    dup 
L93:    aload_3 
L94:    aload_0 
L95:    aload_0 
L96:    getfield [18] 
L99:    invokespecial [24] 
L102:   areturn 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [170] .code stack 4 locals 0 
L0:     iconst_2 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     aload_0 
L6:     getfield [12] 
L9:     iastore 
L10:    dup 
L11:    iconst_1 
L12:    aload_0 
L13:    getfield [13] 
L16:    iastore 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [179] : [180] 
    .attribute [170] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [181] : [182] 
    .attribute [170] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [32] [33] 
.const [3] = Field [34] [35] 
.const [4] = String [36] 
.const [5] = Method [37] [38] 
.const [6] = Class [39] 
.const [7] = Class [40] 
.const [8] = Class [41] 
.const [9] = Class [42] 
.const [10] = Class [43] 
.const [11] = Field [44] [45] 
.const [12] = Field [46] [47] 
.const [13] = Field [48] [49] 
.const [14] = Field [50] [51] 
.const [15] = Field [52] [53] 
.const [16] = Field [54] [55] 
.const [17] = Method [56] [57] 
.const [18] = Field [58] [59] 
.const [19] = Method [60] [61] 
.const [20] = Method [62] [63] 
.const [21] = Method [64] [65] 
.const [22] = Method [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Method [70] [71] 
.const [25] = Field [72] [73] 
.const [26] = Field [74] [75] 
.const [27] = Field [76] [77] 
.const [28] = Field [78] [79] 
.const [29] = Field [80] [81] 
.const [30] = Field [82] [83] 
.const [31] = Class [84] 
.const [32] = Class [85] 
.const [33] = NameAndType [86] [87] 
.const [34] = Class [88] 
.const [35] = NameAndType [89] [90] 
.const [36] = Utf8 'TextureDescriptionByteBuffer#createTexture a texture can only be created one time from a buffer' 
.const [37] = Class [91] 
.const [38] = NameAndType [92] [93] 
.const [39] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedTexture 
.const [40] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [41] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [42] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Class [94] 
.const [45] = NameAndType [95] [96] 
.const [46] = Class [97] 
.const [47] = NameAndType [98] [99] 
.const [48] = Class [100] 
.const [49] = NameAndType [101] [102] 
.const [50] = Class [103] 
.const [51] = NameAndType [104] [105] 
.const [52] = Class [106] 
.const [53] = NameAndType [107] [108] 
.const [54] = Class [109] 
.const [55] = NameAndType [110] [111] 
.const [56] = Class [112] 
.const [57] = NameAndType [113] [114] 
.const [58] = Class [115] 
.const [59] = NameAndType [116] [117] 
.const [60] = Class [118] 
.const [61] = NameAndType [119] [120] 
.const [62] = Class [121] 
.const [63] = NameAndType [122] [123] 
.const [64] = Class [124] 
.const [65] = NameAndType [125] [126] 
.const [66] = Class [127] 
.const [67] = NameAndType [128] [129] 
.const [68] = Class [130] 
.const [69] = NameAndType [131] [132] 
.const [70] = Class [133] 
.const [71] = NameAndType [134] [135] 
.const [72] = Class [136] 
.const [73] = NameAndType [137] [138] 
.const [74] = Class [139] 
.const [75] = NameAndType [140] [141] 
.const [76] = Class [142] 
.const [77] = NameAndType [143] [144] 
.const [78] = Class [145] 
.const [79] = NameAndType [146] [147] 
.const [80] = Class [148] 
.const [81] = NameAndType [149] [150] 
.const [82] = Class [151] 
.const [83] = NameAndType [152] [153] 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedTexture 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [86] = Utf8 getImageFlags 
.const [87] = Utf8 (I)Lde/esolutions/graphics/eal/FlagImage; 
.const [88] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [89] = Utf8 logChannel3DEngine 
.const [90] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [91] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [92] = Utf8 getTextureFlags 
.const [93] = Utf8 (IZ)Lde/esolutions/graphics/eal/FlagTexture; 
.const [94] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [95] = Utf8 buffer 
.const [96] = Utf8 Ljava/nio/ByteBuffer; 
.const [97] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [98] = Utf8 width 
.const [99] = Utf8 I 
.const [100] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [101] = Utf8 height 
.const [102] = Utf8 I 
.const [103] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [104] = Utf8 format 
.const [105] = Utf8 I 
.const [106] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [107] = Utf8 flagImage 
.const [108] = Utf8 Lde/esolutions/graphics/eal/FlagImage; 
.const [109] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [110] = Utf8 key 
.const [111] = Utf8 Ljava/lang/Object; 
.const [112] = Utf8 de/audi/atip/log/LogChannel 
.const [113] = Utf8 log 
.const [114] = Utf8 (ILjava/lang/String;)Z 
.const [115] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [116] = Utf8 ealManager 
.const [117] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [119] = Utf8 createEALImage 
.const [120] = Utf8 (Ljava/nio/ByteBuffer;III)Lde/esolutions/graphics/eal/api/IImage; 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [122] = Utf8 createTexture 
.const [123] = Utf8 (Lde/esolutions/graphics/eal/api/IImage;Lde/esolutions/graphics/eal/FlagTexture;)Lde/esolutions/graphics/eal/api/ITexture; 
.const [124] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [125] = Utf8 destroy 
.const [126] = Utf8 (Lde/esolutions/graphics/eal/api/IObject;)V 
.const [127] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;)V 
.const [130] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Ljava/nio/ByteBuffer;IIILde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;)V 
.const [133] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedTexture 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;)V 
.const [136] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [137] = Utf8 buffer 
.const [138] = Utf8 Ljava/nio/ByteBuffer; 
.const [139] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [140] = Utf8 width 
.const [141] = Utf8 I 
.const [142] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [143] = Utf8 height 
.const [144] = Utf8 I 
.const [145] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [146] = Utf8 format 
.const [147] = Utf8 I 
.const [148] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [149] = Utf8 flagImage 
.const [150] = Utf8 Lde/esolutions/graphics/eal/FlagImage; 
.const [151] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [152] = Utf8 key 
.const [153] = Utf8 Ljava/lang/Object; 
.const [154] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionByteBuffer 
.const [155] = Class [154] 
.const [156] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [157] = Class [156] 
.const [158] = Utf8 buffer 
.const [159] = Utf8 Ljava/nio/ByteBuffer; 
.const [160] = Utf8 width 
.const [161] = Utf8 I 
.const [162] = Utf8 height 
.const [163] = Utf8 I 
.const [164] = Utf8 format 
.const [165] = Utf8 I 
.const [166] = Utf8 flagImage 
.const [167] = Utf8 Lde/esolutions/graphics/eal/FlagImage; 
.const [168] = Utf8 key 
.const [169] = Utf8 Ljava/lang/Object; 
.const [170] = Utf8 Code 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Ljava/nio/ByteBuffer;IIILde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;)V 
.const [173] = Utf8 <init> 
.const [174] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Ljava/nio/ByteBuffer;IIILde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;Ljava/lang/Object;)V 
.const [175] = Utf8 createTexture 
.const [176] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [177] = Utf8 getUnscaledDimension 
.const [178] = Utf8 ()[I 
.const [179] = Utf8 getCacheKey 
.const [180] = Utf8 ()Ljava/lang/Object; 
.const [181] = Utf8 getImageFlags 
.const [182] = Utf8 ()Lde/esolutions/graphics/eal/FlagImage; 
.end class 
