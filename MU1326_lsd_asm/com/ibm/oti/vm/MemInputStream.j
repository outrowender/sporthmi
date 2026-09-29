.version 50 0 
.class super [129] 
.super [131] 
.implements [133] 
.field private [134] [135] 
.field private [136] [137] 
.field private [138] [139] 
.field private [140] [141] 
.field private [142] [143] 

.method [145] : [146] 
    .attribute [144] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     lload_1 
L6:     putfield [22] 
L9:     aload_0 
L10:    iload_3 
L11:    putfield [23] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [24] 
L19:    aload_0 
L20:    aload 4 
L22:    putfield [25] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifne L22 
L9:     new [26] 
L12:    dup 
L13:    ldc [5] 
L15:    invokestatic [7] 
L18:    invokespecial [18] 
L21:    athrow 
L22:    aload_0 
L23:    getfield [13] 
L26:    aload_0 
L27:    getfield [12] 
L30:    if_icmplt L35 
L33:    iconst_0 
L34:    areturn 
L35:    aload_0 
L36:    getfield [12] 
L39:    aload_0 
L40:    getfield [13] 
L43:    isub 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [144] .code stack 3 locals 0 
L0:     aload_0 
L1:     lconst_0 
L2:     putfield [22] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [151] : [152] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [153] : [154] 
    .attribute [144] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [155] : [156] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [13] 
L5:     putfield [27] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [144] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [144] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifne L22 
L9:     new [26] 
L12:    dup 
L13:    ldc [5] 
L15:    invokestatic [7] 
L18:    invokespecial [18] 
L21:    athrow 
L22:    aload_0 
L23:    getfield [13] 
L26:    aload_0 
L27:    getfield [12] 
L30:    if_icmplt L35 
L33:    iconst_m1 
L34:    areturn 
L35:    aload_0 
L36:    getfield [14] 
L39:    ifnull L67 
L42:    aload_0 
L43:    getfield [14] 
L46:    invokevirtual [16] 
L49:    lconst_0 
L50:    lcmp 
L51:    ifne L67 
L54:    new [26] 
L57:    dup 
L58:    ldc [5] 
L60:    invokestatic [7] 
L63:    invokespecial [18] 
L66:    athrow 
L67:    aload_0 
L68:    aload_0 
L69:    getfield [11] 
L72:    aload_0 
L73:    dup 
L74:    getfield [13] 
L77:    dup_x1 
L78:    iconst_1 
L79:    iadd 
L80:    putfield [24] 
L83:    invokespecial [19] 
L86:    sipush 255 
L89:    iand 
L90:    areturn 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [144] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifne L22 
L9:     new [26] 
L12:    dup 
L13:    ldc [5] 
L15:    invokestatic [7] 
L18:    invokespecial [18] 
L21:    athrow 
L22:    iload_2 
L23:    iflt L130 
L26:    iload_3 
L27:    iflt L130 
L30:    iload_3 
L31:    aload_1 
L32:    arraylength 
L33:    iload_2 
L34:    isub 
L35:    if_icmpgt L130 
L38:    aload_0 
L39:    getfield [13] 
L42:    aload_0 
L43:    getfield [12] 
L46:    if_icmplt L51 
L49:    iconst_m1 
L50:    areturn 
L51:    iload_3 
L52:    aload_0 
L53:    getfield [12] 
L56:    aload_0 
L57:    getfield [13] 
L60:    isub 
L61:    invokestatic [9] 
L64:    istore 4 
L66:    aload_0 
L67:    getfield [14] 
L70:    ifnull L98 
L73:    aload_0 
L74:    getfield [14] 
L77:    invokevirtual [16] 
L80:    lconst_0 
L81:    lcmp 
L82:    ifne L98 
L85:    new [26] 
L88:    dup 
L89:    ldc [5] 
L91:    invokestatic [7] 
L94:    invokespecial [18] 
L97:    athrow 
L98:    aload_0 
L99:    aload_1 
L100:   iload_2 
L101:   aload_0 
L102:   getfield [11] 
L105:   aload_0 
L106:   getfield [13] 
L109:   i2l 
L110:   ladd 
L111:   iload 4 
L113:   invokespecial [20] 
L116:   aload_0 
L117:   dup 
L118:   getfield [13] 
L121:   iload 4 
L123:   iadd 
L124:   putfield [24] 
L127:   iload 4 
L129:   areturn 
L130:   new [28] 
L133:   dup 
L134:   invokespecial [21] 
L137:   athrow 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method public synchronized [163] : [164] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [15] 
L5:     putfield [24] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [144] .code stack 4 locals 1 
L0:     lload_1 
L1:     lconst_0 
L2:     lcmp 
L3:     ifgt L8 
L6:     lconst_0 
L7:     freturn 
L8:     aload_0 
L9:     getfield [11] 
L12:    lconst_0 
L13:    lcmp 
L14:    ifne L30 
L17:    new [26] 
L20:    dup 
L21:    ldc [5] 
L23:    invokestatic [7] 
L26:    invokespecial [18] 
L29:    athrow 
L30:    lload_1 
L31:    l2i 
L32:    aload_0 
L33:    getfield [12] 
L36:    aload_0 
L37:    getfield [13] 
L40:    isub 
L41:    invokestatic [9] 
L44:    istore_3 
L45:    aload_0 
L46:    dup 
L47:    getfield [13] 
L50:    iload_3 
L51:    iadd 
L52:    putfield [24] 
L55:    iload_3 
L56:    i2l 
L57:    freturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method static [167] : [168] 
    .attribute [144] .code stack 2 locals 0 
L0:     iload_0 
L1:     iload_1 
L2:     if_icmpge L9 
L5:     iload_0 
L6:     goto L10 
L9:     iload_1 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method private native [169] : [170] 
    .attribute [144] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [171] : [172] 
    .attribute [144] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = Class [31] 
.const [5] = String [32] 
.const [6] = Class [33] 
.const [7] = Method [34] [35] 
.const [8] = Class [36] 
.const [9] = Method [37] [38] 
.const [10] = Class [39] 
.const [11] = Field [40] [41] 
.const [12] = Field [42] [43] 
.const [13] = Field [44] [45] 
.const [14] = Field [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Field [62] [63] 
.const [23] = Field [64] [65] 
.const [24] = Field [66] [67] 
.const [25] = Field [68] [69] 
.const [26] = Class [70] 
.const [27] = Field [71] [72] 
.const [28] = Class [73] 
.const [29] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [30] = Utf8 java/io/InputStream 
.const [31] = Utf8 java/io/IOException 
.const [32] = Utf8 K0059 
.const [33] = Utf8 com/ibm/oti/util/Msg 
.const [34] = Class [74] 
.const [35] = NameAndType [75] [76] 
.const [36] = Utf8 com/ibm/oti/vm/Jxe 
.const [37] = Class [77] 
.const [38] = NameAndType [78] [79] 
.const [39] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [40] = Class [80] 
.const [41] = NameAndType [81] [82] 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Class [89] 
.const [47] = NameAndType [90] [91] 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Class [101] 
.const [55] = NameAndType [102] [103] 
.const [56] = Class [104] 
.const [57] = NameAndType [105] [106] 
.const [58] = Class [107] 
.const [59] = NameAndType [108] [109] 
.const [60] = Class [110] 
.const [61] = NameAndType [111] [112] 
.const [62] = Class [113] 
.const [63] = NameAndType [114] [115] 
.const [64] = Class [116] 
.const [65] = NameAndType [117] [118] 
.const [66] = Class [119] 
.const [67] = NameAndType [120] [121] 
.const [68] = Class [122] 
.const [69] = NameAndType [123] [124] 
.const [70] = Utf8 java/io/IOException 
.const [71] = Class [125] 
.const [72] = NameAndType [126] [127] 
.const [73] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [74] = Utf8 com/ibm/oti/util/Msg 
.const [75] = Utf8 getString 
.const [76] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [77] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [78] = Utf8 min 
.const [79] = Utf8 (II)I 
.const [80] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [81] = Utf8 pointer 
.const [82] = Utf8 J 
.const [83] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [84] = Utf8 size 
.const [85] = Utf8 I 
.const [86] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [87] = Utf8 offset 
.const [88] = Utf8 I 
.const [89] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [90] = Utf8 jxe 
.const [91] = Utf8 Lcom/ibm/oti/vm/Jxe; 
.const [92] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [93] = Utf8 mark 
.const [94] = Utf8 I 
.const [95] = Utf8 com/ibm/oti/vm/Jxe 
.const [96] = Utf8 getJxePointer 
.const [97] = Utf8 ()J 
.const [98] = Utf8 java/io/InputStream 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/io/IOException 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (Ljava/lang/String;)V 
.const [104] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [105] = Utf8 nativeGetByte 
.const [106] = Utf8 (JI)B 
.const [107] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [108] = Utf8 nativeMemcpy 
.const [109] = Utf8 ([BIJI)V 
.const [110] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [114] = Utf8 pointer 
.const [115] = Utf8 J 
.const [116] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [117] = Utf8 size 
.const [118] = Utf8 I 
.const [119] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [120] = Utf8 offset 
.const [121] = Utf8 I 
.const [122] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [123] = Utf8 jxe 
.const [124] = Utf8 Lcom/ibm/oti/vm/Jxe; 
.const [125] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [126] = Utf8 mark 
.const [127] = Utf8 I 
.const [128] = Utf8 com/ibm/oti/vm/MemInputStream 
.const [129] = Class [128] 
.const [130] = Utf8 java/io/InputStream 
.const [131] = Class [130] 
.const [132] = Utf8 com/ibm/oti/vm/OSMemoryAccessor 
.const [133] = Class [132] 
.const [134] = Utf8 pointer 
.const [135] = Utf8 J 
.const [136] = Utf8 size 
.const [137] = Utf8 I 
.const [138] = Utf8 offset 
.const [139] = Utf8 I 
.const [140] = Utf8 mark 
.const [141] = Utf8 I 
.const [142] = Utf8 jxe 
.const [143] = Utf8 Lcom/ibm/oti/vm/Jxe; 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (JILcom/ibm/oti/vm/Jxe;)V 
.const [147] = Utf8 available 
.const [148] = Utf8 ()I 
.const [149] = Utf8 close 
.const [150] = Utf8 ()V 
.const [151] = Utf8 getPointer 
.const [152] = Utf8 ()J 
.const [153] = Utf8 getSize 
.const [154] = Utf8 ()I 
.const [155] = Utf8 mark 
.const [156] = Utf8 (I)V 
.const [157] = Utf8 markSupported 
.const [158] = Utf8 ()Z 
.const [159] = Utf8 read 
.const [160] = Utf8 ()I 
.const [161] = Utf8 read 
.const [162] = Utf8 ([BII)I 
.const [163] = Utf8 reset 
.const [164] = Utf8 ()V 
.const [165] = Utf8 skip 
.const [166] = Utf8 (J)J 
.const [167] = Utf8 min 
.const [168] = Utf8 (II)I 
.const [169] = Utf8 nativeGetByte 
.const [170] = Utf8 (JI)B 
.const [171] = Utf8 nativeMemcpy 
.const [172] = Utf8 ([BIJI)V 
.end class 
