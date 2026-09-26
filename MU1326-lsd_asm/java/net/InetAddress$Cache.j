.version 50 0 
.class super [97] 
.super [99] 
.field static [100] [101] 
.field private static [102] [103] 
.field private static [104] [105] 

.method static [107] : [108] 
    .attribute [106] .code stack 1 locals 0 
L0:     iconst_5 
L1:     putstatic [16] 
L4:     iconst_0 
L5:     putstatic [17] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method annotation [109] : [110] 
    .attribute [106] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static [111] : [112] 
    .attribute [106] .code stack 1 locals 0 
L0:     iconst_0 
L1:     putstatic [17] 
L4:     aconst_null 
L5:     putstatic [19] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method static [113] : [114] 
    .attribute [106] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     astore_1 
L5:     getstatic [5] 
L8:     getstatic [4] 
L11:    if_icmpge L25 
L14:    getstatic [5] 
L17:    iconst_1 
L18:    iadd 
L19:    putstatic [17] 
L22:    goto L28 
L25:    invokestatic [8] 
L28:    aload_1 
L29:    getstatic [6] 
L32:    putfield [20] 
L35:    aload_1 
L36:    putstatic [19] 
L39:    return 
L40:    
    .end code 
.end method 

.method static [115] : [116] 
    .attribute [106] .code stack 2 locals 3 
L0:     aconst_null 
L1:     astore_1 
L2:     getstatic [6] 
L5:     astore_2 
L6:     iconst_1 
L7:     istore_3 
L8:     goto L18 
L11:    aload_2 
L12:    astore_1 
L13:    aload_2 
L14:    getfield [13] 
L17:    astore_2 
L18:    aload_2 
L19:    ifnull L43 
L22:    aload_0 
L23:    aload_2 
L24:    invokevirtual [14] 
L27:    invokevirtual [15] 
L30:    ifeq L37 
L33:    iconst_0 
L34:    goto L38 
L37:    iconst_1 
L38:    dup 
L39:    istore_3 
L40:    ifne L11 
L43:    iload_3 
L44:    ifeq L49 
L47:    aconst_null 
L48:    areturn 
L49:    aload_2 
L50:    aload_1 
L51:    invokestatic [11] 
L54:    aload_2 
L55:    areturn 
L56:    
    .end code 
.end method 

.method private static [117] : [118] 
    .attribute [106] .code stack 2 locals 2 
L0:     getstatic [5] 
L3:     ifne L7 
L6:     return 
L7:     iconst_1 
L8:     getstatic [5] 
L11:    if_icmpne L18 
L14:    aconst_null 
L15:    putstatic [19] 
L18:    aconst_null 
L19:    astore_0 
L20:    getstatic [6] 
L23:    astore_1 
L24:    goto L34 
L27:    aload_1 
L28:    astore_0 
L29:    aload_1 
L30:    getfield [13] 
L33:    astore_1 
L34:    aload_1 
L35:    getfield [13] 
L38:    ifnonnull L27 
L41:    aload_0 
L42:    aconst_null 
L43:    putfield [20] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method private static [119] : [120] 
    .attribute [106] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L11 
L4:     aload_0 
L5:     putstatic [19] 
L8:     goto L30 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [13] 
L16:    putfield [20] 
L19:    aload_0 
L20:    getstatic [6] 
L23:    putfield [20] 
L26:    aload_0 
L27:    putstatic [19] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = Field [23] [24] 
.const [5] = Field [25] [26] 
.const [6] = Field [27] [28] 
.const [7] = Class [29] 
.const [8] = Method [30] [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Method [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Field [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Field [44] [45] 
.const [17] = Field [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Field [50] [51] 
.const [20] = Field [52] [53] 
.const [21] = Utf8 java/net/InetAddress$Cache 
.const [22] = Utf8 java/lang/Object 
.const [23] = Class [54] 
.const [24] = NameAndType [55] [56] 
.const [25] = Class [57] 
.const [26] = NameAndType [58] [59] 
.const [27] = Class [60] 
.const [28] = NameAndType [61] [62] 
.const [29] = Utf8 java/net/InetAddress 
.const [30] = Class [63] 
.const [31] = NameAndType [64] [65] 
.const [32] = Utf8 java/net/InetAddress$CacheElement 
.const [33] = Utf8 java/lang/String 
.const [34] = Class [66] 
.const [35] = NameAndType [67] [68] 
.const [36] = Class [69] 
.const [37] = NameAndType [70] [71] 
.const [38] = Class [72] 
.const [39] = NameAndType [73] [74] 
.const [40] = Class [75] 
.const [41] = NameAndType [76] [77] 
.const [42] = Class [78] 
.const [43] = NameAndType [79] [80] 
.const [44] = Class [81] 
.const [45] = NameAndType [82] [83] 
.const [46] = Class [84] 
.const [47] = NameAndType [85] [86] 
.const [48] = Class [87] 
.const [49] = NameAndType [88] [89] 
.const [50] = Class [90] 
.const [51] = NameAndType [91] [92] 
.const [52] = Class [93] 
.const [53] = NameAndType [94] [95] 
.const [54] = Utf8 java/net/InetAddress$Cache 
.const [55] = Utf8 maxSize 
.const [56] = Utf8 I 
.const [57] = Utf8 java/net/InetAddress$Cache 
.const [58] = Utf8 size 
.const [59] = Utf8 I 
.const [60] = Utf8 java/net/InetAddress$Cache 
.const [61] = Utf8 head 
.const [62] = Utf8 Ljava/net/InetAddress$CacheElement; 
.const [63] = Utf8 java/net/InetAddress$Cache 
.const [64] = Utf8 deleteTail 
.const [65] = Utf8 ()V 
.const [66] = Utf8 java/net/InetAddress$Cache 
.const [67] = Utf8 moveToHead 
.const [68] = Utf8 (Ljava/net/InetAddress$CacheElement;Ljava/net/InetAddress$CacheElement;)V 
.const [69] = Utf8 java/net/InetAddress 
.const [70] = Utf8 cacheElement 
.const [71] = Utf8 ()Ljava/net/InetAddress$CacheElement; 
.const [72] = Utf8 java/net/InetAddress$CacheElement 
.const [73] = Utf8 next 
.const [74] = Utf8 Ljava/net/InetAddress$CacheElement; 
.const [75] = Utf8 java/net/InetAddress$CacheElement 
.const [76] = Utf8 hostName 
.const [77] = Utf8 ()Ljava/lang/String; 
.const [78] = Utf8 java/lang/String 
.const [79] = Utf8 equals 
.const [80] = Utf8 (Ljava/lang/Object;)Z 
.const [81] = Utf8 java/net/InetAddress$Cache 
.const [82] = Utf8 maxSize 
.const [83] = Utf8 I 
.const [84] = Utf8 java/net/InetAddress$Cache 
.const [85] = Utf8 size 
.const [86] = Utf8 I 
.const [87] = Utf8 java/lang/Object 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 java/net/InetAddress$Cache 
.const [91] = Utf8 head 
.const [92] = Utf8 Ljava/net/InetAddress$CacheElement; 
.const [93] = Utf8 java/net/InetAddress$CacheElement 
.const [94] = Utf8 next 
.const [95] = Utf8 Ljava/net/InetAddress$CacheElement; 
.const [96] = Utf8 java/net/InetAddress$Cache 
.const [97] = Class [96] 
.const [98] = Utf8 java/lang/Object 
.const [99] = Class [98] 
.const [100] = Utf8 maxSize 
.const [101] = Utf8 I 
.const [102] = Utf8 size 
.const [103] = Utf8 I 
.const [104] = Utf8 head 
.const [105] = Utf8 Ljava/net/InetAddress$CacheElement; 
.const [106] = Utf8 Code 
.const [107] = Utf8 <clinit> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 clear 
.const [112] = Utf8 ()V 
.const [113] = Utf8 add 
.const [114] = Utf8 (Ljava/net/InetAddress;)V 
.const [115] = Utf8 get 
.const [116] = Utf8 (Ljava/lang/String;)Ljava/net/InetAddress$CacheElement; 
.const [117] = Utf8 deleteTail 
.const [118] = Utf8 ()V 
.const [119] = Utf8 moveToHead 
.const [120] = Utf8 (Ljava/net/InetAddress$CacheElement;Ljava/net/InetAddress$CacheElement;)V 
.end class 
