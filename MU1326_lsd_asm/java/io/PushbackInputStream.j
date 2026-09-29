.version 50 0 
.class public super [161] 
.super [163] 
.field protected [164] [165] 
.field protected [166] [167] 

.method public [169] : [170] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [26] 
L5:     aload_0 
L6:     iconst_1 
L7:     newarray byte 
L9:     putfield [32] 
L12:    aload_0 
L13:    iconst_1 
L14:    putfield [33] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [168] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [26] 
L5:     iload_2 
L6:     ifle L24 
L9:     aload_0 
L10:    iload_2 
L11:    newarray byte 
L13:    putfield [32] 
L16:    aload_0 
L17:    iload_2 
L18:    putfield [33] 
L21:    goto L37 
L24:    new [34] 
L27:    dup 
L28:    ldc [5] 
L30:    invokestatic [7] 
L33:    invokespecial [27] 
L36:    athrow 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnull L26 
L7:     aload_0 
L8:     getfield [16] 
L11:    arraylength 
L12:    aload_0 
L13:    getfield [17] 
L16:    isub 
L17:    aload_0 
L18:    getfield [18] 
L21:    invokevirtual [19] 
L24:    iadd 
L25:    areturn 
L26:    new [35] 
L29:    dup 
L30:    invokespecial [28] 
L33:    athrow 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifnull L24 
L7:     aload_0 
L8:     getfield [18] 
L11:    invokevirtual [20] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [36] 
L19:    aload_0 
L20:    aconst_null 
L21:    putfield [32] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [168] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [168] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnull L48 
L7:     aload_0 
L8:     getfield [17] 
L11:    aload_0 
L12:    getfield [16] 
L15:    arraylength 
L16:    if_icmpge L40 
L19:    aload_0 
L20:    getfield [16] 
L23:    aload_0 
L24:    dup 
L25:    getfield [17] 
L28:    dup_x1 
L29:    iconst_1 
L30:    iadd 
L31:    putfield [33] 
L34:    baload 
L35:    sipush 255 
L38:    iand 
L39:    areturn 
L40:    aload_0 
L41:    getfield [18] 
L44:    invokevirtual [21] 
L47:    areturn 
L48:    new [35] 
L51:    dup 
L52:    invokespecial [28] 
L55:    athrow 
L56:    
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [168] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnull L179 
L7:     aload_1 
L8:     ifnull L179 
L11:    iload_2 
L12:    iflt L171 
L15:    iload_2 
L16:    aload_1 
L17:    arraylength 
L18:    if_icmpgt L171 
L21:    iload_3 
L22:    iflt L171 
L25:    iload_3 
L26:    aload_1 
L27:    arraylength 
L28:    iload_2 
L29:    isub 
L30:    if_icmpgt L171 
L33:    iconst_0 
L34:    istore 4 
L36:    iconst_0 
L37:    istore 5 
L39:    iload_2 
L40:    istore 6 
L42:    aload_0 
L43:    getfield [17] 
L46:    aload_0 
L47:    getfield [16] 
L50:    arraylength 
L51:    if_icmpge L125 
L54:    aload_0 
L55:    getfield [16] 
L58:    arraylength 
L59:    aload_0 
L60:    getfield [17] 
L63:    isub 
L64:    iload_3 
L65:    if_icmplt L72 
L68:    iload_3 
L69:    goto L82 
L72:    aload_0 
L73:    getfield [16] 
L76:    arraylength 
L77:    aload_0 
L78:    getfield [17] 
L81:    isub 
L82:    istore 5 
L84:    aload_0 
L85:    getfield [16] 
L88:    aload_0 
L89:    getfield [17] 
L92:    aload_1 
L93:    iload 6 
L95:    iload 5 
L97:    invokestatic [11] 
L100:   iload 6 
L102:   iload 5 
L104:   iadd 
L105:   istore 6 
L107:   iload 4 
L109:   iload 5 
L111:   iadd 
L112:   istore 4 
L114:   aload_0 
L115:   dup 
L116:   getfield [17] 
L119:   iload 5 
L121:   iadd 
L122:   putfield [33] 
L125:   iload 5 
L127:   iload_3 
L128:   if_icmpne L133 
L131:   iload_3 
L132:   areturn 
L133:   aload_0 
L134:   getfield [18] 
L137:   aload_1 
L138:   iload 6 
L140:   iload_3 
L141:   iload 4 
L143:   isub 
L144:   invokevirtual [22] 
L147:   istore 7 
L149:   iload 7 
L151:   ifle L160 
L154:   iload 7 
L156:   iload 4 
L158:   iadd 
L159:   areturn 
L160:   iload 4 
L162:   ifne L168 
L165:   iload 7 
L167:   areturn 
L168:   iload 4 
L170:   areturn 
L171:   new [37] 
L174:   dup 
L175:   invokespecial [29] 
L178:   athrow 
L179:   aload_0 
L180:   getfield [16] 
L183:   ifnonnull L194 
L186:   new [35] 
L189:   dup 
L190:   invokespecial [28] 
L193:   athrow 
L194:   new [38] 
L197:   dup 
L198:   invokespecial [30] 
L201:   athrow 
L202:   nop 
L203:   nop 
L204:   
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [168] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifnull L101 
L7:     lload_1 
L8:     lconst_0 
L9:     lcmp 
L10:    ifgt L15 
L13:    lconst_0 
L14:    freturn 
L15:    iconst_0 
L16:    istore_3 
L17:    aload_0 
L18:    getfield [17] 
L21:    aload_0 
L22:    getfield [16] 
L25:    arraylength 
L26:    if_icmpge L75 
L29:    iload_3 
L30:    i2l 
L31:    lload_1 
L32:    aload_0 
L33:    getfield [16] 
L36:    arraylength 
L37:    aload_0 
L38:    getfield [17] 
L41:    isub 
L42:    i2l 
L43:    lcmp 
L44:    ifge L51 
L47:    lload_1 
L48:    goto L62 
L51:    aload_0 
L52:    getfield [16] 
L55:    arraylength 
L56:    aload_0 
L57:    getfield [17] 
L60:    isub 
L61:    i2l 
L62:    ladd 
L63:    l2i 
L64:    istore_3 
L65:    aload_0 
L66:    dup 
L67:    getfield [17] 
L70:    iload_3 
L71:    iadd 
L72:    putfield [33] 
L75:    iload_3 
L76:    i2l 
L77:    lload_1 
L78:    lcmp 
L79:    ifge L98 
L82:    iload_3 
L83:    i2l 
L84:    aload_0 
L85:    getfield [18] 
L88:    lload_1 
L89:    iload_3 
L90:    i2l 
L91:    lsub 
L92:    invokevirtual [23] 
L95:    ladd 
L96:    l2i 
L97:    istore_3 
L98:    iload_3 
L99:    i2l 
L100:   freturn 
L101:   new [35] 
L104:   dup 
L105:   ldc [14] 
L107:   invokestatic [7] 
L110:   invokespecial [31] 
L113:   athrow 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [168] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_0 
L3:     aload_1 
L4:     arraylength 
L5:     invokevirtual [24] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [168] .code stack 3 locals 1 
L0:     iload_3 
L1:     aload_0 
L2:     getfield [17] 
L5:     if_icmple L21 
L8:     new [35] 
L11:    dup 
L12:    ldc [15] 
L14:    invokestatic [7] 
L17:    invokespecial [31] 
L20:    athrow 
L21:    iload_2 
L22:    iflt L73 
L25:    iload_2 
L26:    aload_1 
L27:    arraylength 
L28:    if_icmpgt L73 
L31:    iload_3 
L32:    iflt L73 
L35:    iload_3 
L36:    aload_1 
L37:    arraylength 
L38:    iload_2 
L39:    isub 
L40:    if_icmpgt L73 
L43:    iload_2 
L44:    iload_3 
L45:    iadd 
L46:    iconst_1 
L47:    isub 
L48:    istore 4 
L50:    goto L64 
L53:    aload_0 
L54:    aload_1 
L55:    iload 4 
L57:    baload 
L58:    invokevirtual [25] 
L61:    iinc 4 -1 
L64:    iload 4 
L66:    iload_2 
L67:    if_icmpge L53 
L70:    goto L81 
L73:    new [37] 
L76:    dup 
L77:    invokespecial [29] 
L80:    athrow 
L81:    return 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [168] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnull L51 
L7:     aload_0 
L8:     getfield [17] 
L11:    ifeq L35 
L14:    aload_0 
L15:    getfield [16] 
L18:    aload_0 
L19:    dup 
L20:    getfield [17] 
L23:    iconst_1 
L24:    isub 
L25:    dup_x1 
L26:    putfield [33] 
L29:    iload_1 
L30:    i2b 
L31:    bastore 
L32:    goto L59 
L35:    new [35] 
L38:    dup 
L39:    ldc [15] 
L41:    invokestatic [7] 
L44:    invokespecial [31] 
L47:    athrow 
L48:    goto L59 
L51:    new [35] 
L54:    dup 
L55:    invokespecial [28] 
L58:    athrow 
L59:    return 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = Class [40] 
.const [4] = Class [41] 
.const [5] = String [42] 
.const [6] = Class [43] 
.const [7] = Method [44] [45] 
.const [8] = Class [46] 
.const [9] = Class [47] 
.const [10] = Class [48] 
.const [11] = Method [49] [50] 
.const [12] = Class [51] 
.const [13] = Class [52] 
.const [14] = String [53] 
.const [15] = String [54] 
.const [16] = Field [55] [56] 
.const [17] = Field [57] [58] 
.const [18] = Field [59] [60] 
.const [19] = Method [61] [62] 
.const [20] = Method [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Field [87] [88] 
.const [33] = Field [89] [90] 
.const [34] = Class [91] 
.const [35] = Class [92] 
.const [36] = Field [93] [94] 
.const [37] = Class [95] 
.const [38] = Class [96] 
.const [39] = Utf8 java/io/PushbackInputStream 
.const [40] = Utf8 java/io/FilterInputStream 
.const [41] = Utf8 java/lang/IllegalArgumentException 
.const [42] = Utf8 K0058 
.const [43] = Utf8 com/ibm/oti/util/Msg 
.const [44] = Class [97] 
.const [45] = NameAndType [98] [99] 
.const [46] = Utf8 java/io/IOException 
.const [47] = Utf8 java/io/InputStream 
.const [48] = Utf8 java/lang/System 
.const [49] = Class [100] 
.const [50] = NameAndType [101] [102] 
.const [51] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [52] = Utf8 java/lang/NullPointerException 
.const [53] = Utf8 K0059 
.const [54] = Utf8 K007e 
.const [55] = Class [103] 
.const [56] = NameAndType [104] [105] 
.const [57] = Class [106] 
.const [58] = NameAndType [107] [108] 
.const [59] = Class [109] 
.const [60] = NameAndType [110] [111] 
.const [61] = Class [112] 
.const [62] = NameAndType [113] [114] 
.const [63] = Class [115] 
.const [64] = NameAndType [116] [117] 
.const [65] = Class [118] 
.const [66] = NameAndType [119] [120] 
.const [67] = Class [121] 
.const [68] = NameAndType [122] [123] 
.const [69] = Class [124] 
.const [70] = NameAndType [125] [126] 
.const [71] = Class [127] 
.const [72] = NameAndType [128] [129] 
.const [73] = Class [130] 
.const [74] = NameAndType [131] [132] 
.const [75] = Class [133] 
.const [76] = NameAndType [134] [135] 
.const [77] = Class [136] 
.const [78] = NameAndType [137] [138] 
.const [79] = Class [139] 
.const [80] = NameAndType [140] [141] 
.const [81] = Class [142] 
.const [82] = NameAndType [143] [144] 
.const [83] = Class [145] 
.const [84] = NameAndType [146] [147] 
.const [85] = Class [148] 
.const [86] = NameAndType [149] [150] 
.const [87] = Class [151] 
.const [88] = NameAndType [152] [153] 
.const [89] = Class [154] 
.const [90] = NameAndType [155] [156] 
.const [91] = Utf8 java/lang/IllegalArgumentException 
.const [92] = Utf8 java/io/IOException 
.const [93] = Class [157] 
.const [94] = NameAndType [158] [159] 
.const [95] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [96] = Utf8 java/lang/NullPointerException 
.const [97] = Utf8 com/ibm/oti/util/Msg 
.const [98] = Utf8 getString 
.const [99] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [100] = Utf8 java/lang/System 
.const [101] = Utf8 arraycopy 
.const [102] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [103] = Utf8 java/io/PushbackInputStream 
.const [104] = Utf8 buf 
.const [105] = Utf8 [B 
.const [106] = Utf8 java/io/PushbackInputStream 
.const [107] = Utf8 pos 
.const [108] = Utf8 I 
.const [109] = Utf8 java/io/PushbackInputStream 
.const [110] = Utf8 in 
.const [111] = Utf8 Ljava/io/InputStream; 
.const [112] = Utf8 java/io/InputStream 
.const [113] = Utf8 available 
.const [114] = Utf8 ()I 
.const [115] = Utf8 java/io/InputStream 
.const [116] = Utf8 close 
.const [117] = Utf8 ()V 
.const [118] = Utf8 java/io/InputStream 
.const [119] = Utf8 read 
.const [120] = Utf8 ()I 
.const [121] = Utf8 java/io/InputStream 
.const [122] = Utf8 read 
.const [123] = Utf8 ([BII)I 
.const [124] = Utf8 java/io/InputStream 
.const [125] = Utf8 skip 
.const [126] = Utf8 (J)J 
.const [127] = Utf8 java/io/PushbackInputStream 
.const [128] = Utf8 unread 
.const [129] = Utf8 ([BII)V 
.const [130] = Utf8 java/io/PushbackInputStream 
.const [131] = Utf8 unread 
.const [132] = Utf8 (I)V 
.const [133] = Utf8 java/io/FilterInputStream 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Ljava/io/InputStream;)V 
.const [136] = Utf8 java/lang/IllegalArgumentException 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Ljava/lang/String;)V 
.const [139] = Utf8 java/io/IOException 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 java/lang/NullPointerException 
.const [146] = Utf8 <init> 
.const [147] = Utf8 ()V 
.const [148] = Utf8 java/io/IOException 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Ljava/lang/String;)V 
.const [151] = Utf8 java/io/PushbackInputStream 
.const [152] = Utf8 buf 
.const [153] = Utf8 [B 
.const [154] = Utf8 java/io/PushbackInputStream 
.const [155] = Utf8 pos 
.const [156] = Utf8 I 
.const [157] = Utf8 java/io/PushbackInputStream 
.const [158] = Utf8 in 
.const [159] = Utf8 Ljava/io/InputStream; 
.const [160] = Utf8 java/io/PushbackInputStream 
.const [161] = Class [160] 
.const [162] = Utf8 java/io/FilterInputStream 
.const [163] = Class [162] 
.const [164] = Utf8 buf 
.const [165] = Utf8 [B 
.const [166] = Utf8 pos 
.const [167] = Utf8 I 
.const [168] = Utf8 Code 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Ljava/io/InputStream;)V 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Ljava/io/InputStream;I)V 
.const [173] = Utf8 available 
.const [174] = Utf8 ()I 
.const [175] = Utf8 close 
.const [176] = Utf8 ()V 
.const [177] = Utf8 markSupported 
.const [178] = Utf8 ()Z 
.const [179] = Utf8 read 
.const [180] = Utf8 ()I 
.const [181] = Utf8 read 
.const [182] = Utf8 ([BII)I 
.const [183] = Utf8 skip 
.const [184] = Utf8 (J)J 
.const [185] = Utf8 unread 
.const [186] = Utf8 ([B)V 
.const [187] = Utf8 unread 
.const [188] = Utf8 ([BII)V 
.const [189] = Utf8 unread 
.const [190] = Utf8 (I)V 
.end class 
