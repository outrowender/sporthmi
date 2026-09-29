.version 50 0 
.class public super [73] 
.super [75] 
.field private final [76] [77] 
.field private final [78] [79] 
.field private final [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aconst_null 
L3:     invokespecial [11] 
L6:     aload_0 
L7:     aload_2 
L8:     putfield [13] 
L11:    aload_0 
L12:    iload_3 
L13:    putfield [14] 
L16:    aload_0 
L17:    iload 4 
L19:    putfield [15] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [82] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [6] 
L8:     aload_0 
L9:     getfield [7] 
L12:    aload_0 
L13:    getfield [8] 
L16:    invokevirtual [10] 
L19:    astore_1 
L20:    aload_1 
L21:    ifnonnull L26 
L24:    aconst_null 
L25:    areturn 
L26:    new [16] 
L29:    dup 
L30:    aload_1 
L31:    aload_0 
L32:    aload_0 
L33:    getfield [9] 
L36:    invokespecial [12] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [82] .code stack 4 locals 0 
L0:     iconst_2 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     aload_0 
L6:     getfield [7] 
L9:     iastore 
L10:    dup 
L11:    iconst_1 
L12:    aload_0 
L13:    getfield [8] 
L16:    iastore 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [89] : [90] 
    .attribute [82] .code stack 1 locals 0 
L0:     aload_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [82] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Field [21] [22] 
.const [7] = Field [23] [24] 
.const [8] = Field [25] [26] 
.const [9] = Field [27] [28] 
.const [10] = Method [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Field [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Class [41] 
.const [17] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedTexture 
.const [18] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionShared 
.const [19] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [20] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [21] = Class [42] 
.const [22] = NameAndType [43] [44] 
.const [23] = Class [45] 
.const [24] = NameAndType [46] [47] 
.const [25] = Class [48] 
.const [26] = NameAndType [49] [50] 
.const [27] = Class [51] 
.const [28] = NameAndType [52] [53] 
.const [29] = Class [54] 
.const [30] = NameAndType [55] [56] 
.const [31] = Class [57] 
.const [32] = NameAndType [58] [59] 
.const [33] = Class [60] 
.const [34] = NameAndType [61] [62] 
.const [35] = Class [63] 
.const [36] = NameAndType [64] [65] 
.const [37] = Class [66] 
.const [38] = NameAndType [67] [68] 
.const [39] = Class [69] 
.const [40] = NameAndType [70] [71] 
.const [41] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedTexture 
.const [42] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionShared 
.const [43] = Utf8 name 
.const [44] = Utf8 Ljava/lang/String; 
.const [45] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionShared 
.const [46] = Utf8 width 
.const [47] = Utf8 I 
.const [48] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionShared 
.const [49] = Utf8 height 
.const [50] = Utf8 I 
.const [51] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionShared 
.const [52] = Utf8 ealManager 
.const [53] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [54] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [55] = Utf8 createSharedTexture 
.const [56] = Utf8 (Ljava/lang/String;II)Lde/esolutions/graphics/eal/api/ITextureShared; 
.const [57] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [58] = Utf8 <init> 
.const [59] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;)V 
.const [60] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedTexture 
.const [61] = Utf8 <init> 
.const [62] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;)V 
.const [63] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionShared 
.const [64] = Utf8 name 
.const [65] = Utf8 Ljava/lang/String; 
.const [66] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionShared 
.const [67] = Utf8 width 
.const [68] = Utf8 I 
.const [69] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionShared 
.const [70] = Utf8 height 
.const [71] = Utf8 I 
.const [72] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionShared 
.const [73] = Class [72] 
.const [74] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [75] = Class [74] 
.const [76] = Utf8 name 
.const [77] = Utf8 Ljava/lang/String; 
.const [78] = Utf8 width 
.const [79] = Utf8 I 
.const [80] = Utf8 height 
.const [81] = Utf8 I 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Ljava/lang/String;II)V 
.const [85] = Utf8 createTexture 
.const [86] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [87] = Utf8 getUnscaledDimension 
.const [88] = Utf8 ()[I 
.const [89] = Utf8 getCacheKey 
.const [90] = Utf8 ()Ljava/lang/Object; 
.const [91] = Utf8 getImageFlags 
.const [92] = Utf8 ()Lde/esolutions/graphics/eal/FlagImage; 
.end class 
