.version 50 0 
.class public super [119] 
.super [121] 
.field private [122] [123] 
.field private [124] [125] 
.field private [126] [127] 
.field private [128] [129] 
.field private [130] [131] 

.method public [133] : [134] 
    .attribute [132] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     sipush 1024 
L8:     newarray byte 
L10:    putfield [19] 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [20] 
L18:    aload_0 
L19:    iconst_0 
L20:    putfield [21] 
L23:    aload_0 
L24:    new [22] 
L27:    dup 
L28:    aload_0 
L29:    invokespecial [16] 
L32:    putfield [23] 
L35:    aload_0 
L36:    new [24] 
L39:    dup 
L40:    aload_0 
L41:    invokespecial [17] 
L44:    putfield [25] 
L47:    return 
L48:    
    .end code 
.end method 

.method public interface [135] : [136] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [137] : [138] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     arraylength 
L5:     iconst_1 
L6:     isub 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_0 
L5:     getfield [9] 
L8:     if_icmpne L13 
L11:    iconst_0 
L12:    areturn 
L13:    aload_0 
L14:    getfield [8] 
L17:    aload_0 
L18:    getfield [9] 
L21:    if_icmpge L34 
L24:    aload_0 
L25:    getfield [9] 
L28:    aload_0 
L29:    getfield [8] 
L32:    isub 
L33:    areturn 
L34:    aload_0 
L35:    getfield [7] 
L38:    arraylength 
L39:    aload_0 
L40:    getfield [8] 
L43:    isub 
L44:    aload_0 
L45:    getfield [9] 
L48:    iadd 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     aload_0 
L5:     invokevirtual [13] 
L8:     isub 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [145] : [146] 
    .attribute [132] .code stack 4 locals 2 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [7] 
L5:     arraylength 
L6:     bipush 8 
L8:     idiv 
L9:     if_icmpge L23 
L12:    aload_0 
L13:    getfield [7] 
L16:    arraylength 
L17:    bipush 8 
L19:    idiv 
L20:    goto L24 
L23:    iload_1 
L24:    istore_1 
L25:    aload_0 
L26:    getfield [7] 
L29:    arraylength 
L30:    iload_1 
L31:    iadd 
L32:    newarray byte 
L34:    astore_2 
L35:    aload_0 
L36:    invokevirtual [13] 
L39:    istore_3 
L40:    aload_0 
L41:    getfield [10] 
L44:    aload_2 
L45:    iconst_0 
L46:    iload_3 
L47:    invokevirtual [14] 
L50:    pop 
L51:    aload_0 
L52:    iconst_0 
L53:    putfield [20] 
L56:    aload_0 
L57:    iload_3 
L58:    putfield [21] 
L61:    aload_0 
L62:    aload_2 
L63:    putfield [19] 
L66:    iload_1 
L67:    areturn 
L68:    
    .end code 
.end method 

.method static synthetic [147] : [148] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [149] : [150] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [151] : [152] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [20] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [153] : [154] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [18] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [155] : [156] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [157] : [158] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [21] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Field [31] [32] 
.const [8] = Field [33] [34] 
.const [9] = Field [35] [36] 
.const [10] = Field [37] [38] 
.const [11] = Field [39] [40] 
.const [12] = Method [41] [42] 
.const [13] = Method [43] [44] 
.const [14] = Method [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Field [55] [56] 
.const [20] = Field [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = Class [61] 
.const [23] = Field [62] [63] 
.const [24] = Class [64] 
.const [25] = Field [65] [66] 
.const [26] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 com/ibm/j9/ssl/StreamQueue$1 
.const [29] = Utf8 com/ibm/j9/ssl/StreamQueue$2 
.const [30] = Utf8 java/io/InputStream 
.const [31] = Class [67] 
.const [32] = NameAndType [68] [69] 
.const [33] = Class [70] 
.const [34] = NameAndType [71] [72] 
.const [35] = Class [73] 
.const [36] = NameAndType [74] [75] 
.const [37] = Class [76] 
.const [38] = NameAndType [77] [78] 
.const [39] = Class [79] 
.const [40] = NameAndType [80] [81] 
.const [41] = Class [82] 
.const [42] = NameAndType [83] [84] 
.const [43] = Class [85] 
.const [44] = NameAndType [86] [87] 
.const [45] = Class [88] 
.const [46] = NameAndType [89] [90] 
.const [47] = Class [91] 
.const [48] = NameAndType [92] [93] 
.const [49] = Class [94] 
.const [50] = NameAndType [95] [96] 
.const [51] = Class [97] 
.const [52] = NameAndType [98] [99] 
.const [53] = Class [100] 
.const [54] = NameAndType [101] [102] 
.const [55] = Class [103] 
.const [56] = NameAndType [104] [105] 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Class [109] 
.const [60] = NameAndType [110] [111] 
.const [61] = Utf8 com/ibm/j9/ssl/StreamQueue$1 
.const [62] = Class [112] 
.const [63] = NameAndType [113] [114] 
.const [64] = Utf8 com/ibm/j9/ssl/StreamQueue$2 
.const [65] = Class [115] 
.const [66] = NameAndType [116] [117] 
.const [67] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [68] = Utf8 buffer 
.const [69] = Utf8 [B 
.const [70] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [71] = Utf8 posRead 
.const [72] = Utf8 I 
.const [73] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [74] = Utf8 posWrite 
.const [75] = Utf8 I 
.const [76] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [77] = Utf8 queueRead 
.const [78] = Utf8 Ljava/io/InputStream; 
.const [79] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [80] = Utf8 queueWrite 
.const [81] = Utf8 Ljava/io/OutputStream; 
.const [82] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [83] = Utf8 getCapacity 
.const [84] = Utf8 ()I 
.const [85] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [86] = Utf8 getSize 
.const [87] = Utf8 ()I 
.const [88] = Utf8 java/io/InputStream 
.const [89] = Utf8 read 
.const [90] = Utf8 ([BII)I 
.const [91] = Utf8 java/lang/Object 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ()V 
.const [94] = Utf8 com/ibm/j9/ssl/StreamQueue$1 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)V 
.const [97] = Utf8 com/ibm/j9/ssl/StreamQueue$2 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)V 
.const [100] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [101] = Utf8 grow 
.const [102] = Utf8 (I)I 
.const [103] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [104] = Utf8 buffer 
.const [105] = Utf8 [B 
.const [106] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [107] = Utf8 posRead 
.const [108] = Utf8 I 
.const [109] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [110] = Utf8 posWrite 
.const [111] = Utf8 I 
.const [112] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [113] = Utf8 queueRead 
.const [114] = Utf8 Ljava/io/InputStream; 
.const [115] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [116] = Utf8 queueWrite 
.const [117] = Utf8 Ljava/io/OutputStream; 
.const [118] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [119] = Class [118] 
.const [120] = Utf8 java/lang/Object 
.const [121] = Class [120] 
.const [122] = Utf8 buffer 
.const [123] = Utf8 [B 
.const [124] = Utf8 posRead 
.const [125] = Utf8 I 
.const [126] = Utf8 posWrite 
.const [127] = Utf8 I 
.const [128] = Utf8 queueRead 
.const [129] = Utf8 Ljava/io/InputStream; 
.const [130] = Utf8 queueWrite 
.const [131] = Utf8 Ljava/io/OutputStream; 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 getReadStream 
.const [136] = Utf8 ()Ljava/io/InputStream; 
.const [137] = Utf8 getWriteStream 
.const [138] = Utf8 ()Ljava/io/OutputStream; 
.const [139] = Utf8 getCapacity 
.const [140] = Utf8 ()I 
.const [141] = Utf8 getSize 
.const [142] = Utf8 ()I 
.const [143] = Utf8 getUnusedCapacity 
.const [144] = Utf8 ()I 
.const [145] = Utf8 grow 
.const [146] = Utf8 (I)I 
.const [147] = Utf8 access$0 
.const [148] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)[B 
.const [149] = Utf8 access$1 
.const [150] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)I 
.const [151] = Utf8 access$2 
.const [152] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;I)V 
.const [153] = Utf8 access$3 
.const [154] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;I)I 
.const [155] = Utf8 access$4 
.const [156] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)I 
.const [157] = Utf8 access$5 
.const [158] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;I)V 
.end class 
