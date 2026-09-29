.version 50 0 
.class public super [89] 
.super [91] 
.field protected [92] [93] 
.field protected [94] [95] 
.field protected [96] [97] 
.field protected [98] [99] 

.method public [101] : [102] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [15] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [16] 
L14:    aload_0 
L15:    aload_1 
L16:    arraylength 
L17:    putfield [17] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [100] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [16] 
L9:     aload_0 
L10:    iload_2 
L11:    aload_1 
L12:    arraylength 
L13:    if_icmplt L21 
L16:    aload_1 
L17:    arraylength 
L18:    goto L22 
L21:    iload_2 
L22:    putfield [18] 
L25:    aload_0 
L26:    aload_0 
L27:    getfield [11] 
L30:    putfield [15] 
L33:    aload_0 
L34:    iload_3 
L35:    aload_0 
L36:    getfield [11] 
L39:    iadd 
L40:    aload_1 
L41:    arraylength 
L42:    if_icmple L50 
L45:    aload_1 
L46:    arraylength 
L47:    goto L56 
L50:    iload_3 
L51:    aload_0 
L52:    getfield [11] 
L55:    iadd 
L56:    putfield [17] 
L59:    return 
L60:    
    .end code 
.end method 

.method public synchronized [105] : [106] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_0 
L5:     getfield [11] 
L8:     isub 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public enum [107] : [108] 
    .attribute [100] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public synchronized [109] : [110] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [11] 
L5:     putfield [15] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [100] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public synchronized [113] : [114] 
    .attribute [100] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_0 
L5:     getfield [10] 
L8:     if_icmpge L34 
L11:    aload_0 
L12:    getfield [9] 
L15:    aload_0 
L16:    dup 
L17:    getfield [11] 
L20:    dup_x1 
L21:    iconst_1 
L22:    iadd 
L23:    putfield [18] 
L26:    baload 
L27:    sipush 255 
L30:    iand 
L31:    goto L35 
L34:    iconst_m1 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public synchronized [115] : [116] 
    .attribute [100] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_0 
L5:     getfield [10] 
L8:     if_icmplt L13 
L11:    iconst_m1 
L12:    areturn 
L13:    aload_1 
L14:    ifnull L110 
L17:    iload_2 
L18:    iflt L102 
L21:    iload_2 
L22:    aload_1 
L23:    arraylength 
L24:    if_icmpgt L102 
L27:    iload_3 
L28:    iflt L102 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    iload_2 
L35:    isub 
L36:    if_icmpgt L102 
L39:    iload_3 
L40:    ifne L45 
L43:    iconst_0 
L44:    areturn 
L45:    aload_0 
L46:    getfield [10] 
L49:    aload_0 
L50:    getfield [11] 
L53:    isub 
L54:    iload_3 
L55:    if_icmpge L70 
L58:    aload_0 
L59:    getfield [10] 
L62:    aload_0 
L63:    getfield [11] 
L66:    isub 
L67:    goto L71 
L70:    iload_3 
L71:    istore 4 
L73:    aload_0 
L74:    getfield [9] 
L77:    aload_0 
L78:    getfield [11] 
L81:    aload_1 
L82:    iload_2 
L83:    iload 4 
L85:    invokestatic [5] 
L88:    aload_0 
L89:    dup 
L90:    getfield [11] 
L93:    iload 4 
L95:    iadd 
L96:    putfield [18] 
L99:    iload 4 
L101:   areturn 
L102:   new [19] 
L105:   dup 
L106:   invokespecial [13] 
L109:   athrow 
L110:   new [20] 
L113:   dup 
L114:   invokespecial [14] 
L117:   athrow 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 

.method public synchronized [117] : [118] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [8] 
L5:     putfield [18] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [119] : [120] 
    .attribute [100] .code stack 5 locals 1 
L0:     lload_1 
L1:     lconst_0 
L2:     lcmp 
L3:     ifgt L8 
L6:     lconst_0 
L7:     return 
L8:     aload_0 
L9:     getfield [11] 
L12:    istore_3 
L13:    aload_0 
L14:    aload_0 
L15:    getfield [10] 
L18:    aload_0 
L19:    getfield [11] 
L22:    isub 
L23:    i2l 
L24:    lload_1 
L25:    lcmp 
L26:    ifge L36 
L29:    aload_0 
L30:    getfield [10] 
L33:    goto L44 
L36:    aload_0 
L37:    getfield [11] 
L40:    i2l 
L41:    lload_1 
L42:    ladd 
L43:    l2i 
L44:    putfield [18] 
L47:    aload_0 
L48:    getfield [11] 
L51:    iload_3 
L52:    isub 
L53:    i2l 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = Class [23] 
.const [5] = Method [24] [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Field [28] [29] 
.const [9] = Field [30] [31] 
.const [10] = Field [32] [33] 
.const [11] = Field [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Field [42] [43] 
.const [16] = Field [44] [45] 
.const [17] = Field [46] [47] 
.const [18] = Field [48] [49] 
.const [19] = Class [50] 
.const [20] = Class [51] 
.const [21] = Utf8 java/io/ByteArrayInputStream 
.const [22] = Utf8 java/io/InputStream 
.const [23] = Utf8 java/lang/System 
.const [24] = Class [52] 
.const [25] = NameAndType [53] [54] 
.const [26] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [27] = Utf8 java/lang/NullPointerException 
.const [28] = Class [55] 
.const [29] = NameAndType [56] [57] 
.const [30] = Class [58] 
.const [31] = NameAndType [59] [60] 
.const [32] = Class [61] 
.const [33] = NameAndType [62] [63] 
.const [34] = Class [64] 
.const [35] = NameAndType [65] [66] 
.const [36] = Class [67] 
.const [37] = NameAndType [68] [69] 
.const [38] = Class [70] 
.const [39] = NameAndType [71] [72] 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [51] = Utf8 java/lang/NullPointerException 
.const [52] = Utf8 java/lang/System 
.const [53] = Utf8 arraycopy 
.const [54] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [55] = Utf8 java/io/ByteArrayInputStream 
.const [56] = Utf8 mark 
.const [57] = Utf8 I 
.const [58] = Utf8 java/io/ByteArrayInputStream 
.const [59] = Utf8 buf 
.const [60] = Utf8 [B 
.const [61] = Utf8 java/io/ByteArrayInputStream 
.const [62] = Utf8 count 
.const [63] = Utf8 I 
.const [64] = Utf8 java/io/ByteArrayInputStream 
.const [65] = Utf8 pos 
.const [66] = Utf8 I 
.const [67] = Utf8 java/io/InputStream 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 java/lang/NullPointerException 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 java/io/ByteArrayInputStream 
.const [77] = Utf8 mark 
.const [78] = Utf8 I 
.const [79] = Utf8 java/io/ByteArrayInputStream 
.const [80] = Utf8 buf 
.const [81] = Utf8 [B 
.const [82] = Utf8 java/io/ByteArrayInputStream 
.const [83] = Utf8 count 
.const [84] = Utf8 I 
.const [85] = Utf8 java/io/ByteArrayInputStream 
.const [86] = Utf8 pos 
.const [87] = Utf8 I 
.const [88] = Utf8 java/io/ByteArrayInputStream 
.const [89] = Class [88] 
.const [90] = Utf8 java/io/InputStream 
.const [91] = Class [90] 
.const [92] = Utf8 buf 
.const [93] = Utf8 [B 
.const [94] = Utf8 pos 
.const [95] = Utf8 I 
.const [96] = Utf8 mark 
.const [97] = Utf8 I 
.const [98] = Utf8 count 
.const [99] = Utf8 I 
.const [100] = Utf8 Code 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ([B)V 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ([BII)V 
.const [105] = Utf8 available 
.const [106] = Utf8 ()I 
.const [107] = Utf8 close 
.const [108] = Utf8 ()V 
.const [109] = Utf8 mark 
.const [110] = Utf8 (I)V 
.const [111] = Utf8 markSupported 
.const [112] = Utf8 ()Z 
.const [113] = Utf8 read 
.const [114] = Utf8 ()I 
.const [115] = Utf8 read 
.const [116] = Utf8 ([BII)I 
.const [117] = Utf8 reset 
.const [118] = Utf8 ()V 
.const [119] = Utf8 skip 
.const [120] = Utf8 (J)J 
.end class 
