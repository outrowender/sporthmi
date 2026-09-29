.version 50 0 
.class public super [179] 
.super [181] 
.implements [183] 
.implements [185] 
.implements [187] 
.field protected [188] [189] 
.field protected [190] [191] 
.field protected [192] [193] 
.field private [194] [195] 

.method public [197] : [198] 
    .attribute [196] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [38] 
L9:     aload_0 
L10:    iload_1 
L11:    newarray byte 
L13:    putfield [39] 
L16:    aload_0 
L17:    new [40] 
L20:    dup 
L21:    iconst_0 
L22:    iload_1 
L23:    invokespecial [33] 
L26:    putfield [41] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [196] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     aload_1 
L6:     arraylength 
L7:     putfield [38] 
L10:    aload_0 
L11:    aload_1 
L12:    putfield [39] 
L15:    aload_0 
L16:    new [40] 
L19:    dup 
L20:    iconst_0 
L21:    aload_0 
L22:    getfield [21] 
L25:    invokespecial [33] 
L28:    putfield [41] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [196] .code stack 5 locals 1 
        .catch [5] from L0 to L38 using L39 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     checkcast [3] 
L7:     astore_1 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [22] 
L13:    arraylength 
L14:    newarray byte 
L16:    putfield [39] 
L19:    aload_0 
L20:    getfield [22] 
L23:    iconst_0 
L24:    aload_1 
L25:    getfield [22] 
L28:    iconst_0 
L29:    aload_0 
L30:    getfield [22] 
L33:    arraylength 
L34:    invokestatic [4] 
L37:    aload_1 
L38:    areturn 
L39:    astore_1 
L40:    aconst_null 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [196] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [24] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public interface [205] : [206] 
    .attribute [196] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [207] : [208] 
    .attribute [196] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [196] .code stack 5 locals 1 
L0:     iload_1 
L1:     iload_2 
L2:     iadd 
L3:     aload_0 
L4:     getfield [21] 
L7:     if_icmple L58 
L10:    new [42] 
L13:    dup 
L14:    new [43] 
L17:    dup 
L18:    invokespecial [35] 
L21:    ldc [8] 
L23:    invokevirtual [25] 
L26:    iload_1 
L27:    invokevirtual [26] 
L30:    ldc [9] 
L32:    invokevirtual [25] 
L35:    iload_2 
L36:    invokevirtual [26] 
L39:    ldc [10] 
L41:    invokevirtual [25] 
L44:    aload_0 
L45:    getfield [21] 
L48:    invokevirtual [26] 
L51:    invokevirtual [27] 
L54:    invokespecial [36] 
L57:    athrow 
L58:    iload_2 
L59:    newarray byte 
L61:    astore_3 
L62:    aload_0 
L63:    getfield [22] 
L66:    iload_1 
L67:    aload_3 
L68:    iconst_0 
L69:    iload_2 
L70:    invokestatic [4] 
L73:    aload_3 
L74:    areturn 
L75:    nop 
L76:    
    .end code 
.end method 

.method public interface [211] : [212] 
    .attribute [196] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [196] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [28] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [196] .code stack 5 locals 0 
L0:     iload_1 
L1:     iload_2 
L2:     iadd 
L3:     aload_0 
L4:     invokevirtual [29] 
L7:     if_icmple L58 
L10:    new [42] 
L13:    dup 
L14:    new [43] 
L17:    dup 
L18:    invokespecial [35] 
L21:    ldc [11] 
L23:    invokevirtual [25] 
L26:    iload_1 
L27:    invokevirtual [26] 
L30:    ldc [9] 
L32:    invokevirtual [25] 
L35:    iload_2 
L36:    invokevirtual [26] 
L39:    ldc [10] 
L41:    invokevirtual [25] 
L44:    aload_0 
L45:    invokevirtual [29] 
L48:    invokevirtual [26] 
L51:    invokevirtual [27] 
L54:    invokespecial [36] 
L57:    athrow 
L58:    new [44] 
L61:    dup 
L62:    aload_0 
L63:    iload_1 
L64:    iload_2 
L65:    invokespecial [37] 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [196] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [24] 
L7:     istore_2 
L8:     aload_1 
L9:     arraylength 
L10:    iload_2 
L11:    if_icmpeq L51 
L14:    new [42] 
L17:    dup 
L18:    new [43] 
L21:    dup 
L22:    invokespecial [35] 
L25:    ldc [13] 
L27:    invokevirtual [25] 
L30:    iload_2 
L31:    invokevirtual [26] 
L34:    ldc [14] 
L36:    invokevirtual [25] 
L39:    aload_1 
L40:    arraylength 
L41:    invokevirtual [26] 
L44:    invokevirtual [27] 
L47:    invokespecial [36] 
L50:    athrow 
L51:    aload_0 
L52:    getfield [21] 
L55:    iload_2 
L56:    if_icmpne L67 
L59:    aload_0 
L60:    aload_1 
L61:    putfield [39] 
L64:    goto L84 
L67:    aload_1 
L68:    iconst_0 
L69:    aload_0 
L70:    getfield [22] 
L73:    aload_0 
L74:    getfield [23] 
L77:    invokevirtual [28] 
L80:    iload_2 
L81:    invokestatic [4] 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [196] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [24] 
L7:     istore_3 
L8:     aload_0 
L9:     getfield [23] 
L12:    invokevirtual [28] 
L15:    istore 4 
L17:    aload_2 
L18:    arraylength 
L19:    istore 5 
L21:    iload 5 
L23:    iload_1 
L24:    iadd 
L25:    iload_3 
L26:    if_icmple L39 
L29:    new [42] 
L32:    dup 
L33:    ldc [15] 
L35:    invokespecial [36] 
L38:    athrow 
L39:    aload_2 
L40:    iconst_0 
L41:    aload_0 
L42:    getfield [22] 
L45:    iload 4 
L47:    iload_1 
L48:    iadd 
L49:    iload 5 
L51:    invokestatic [4] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [196] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [24] 
L7:     istore 4 
L9:     aload_0 
L10:    getfield [23] 
L13:    invokevirtual [28] 
L16:    istore 5 
L18:    iload_3 
L19:    iload_1 
L20:    iadd 
L21:    iload 4 
L23:    if_icmple L36 
L26:    new [42] 
L29:    dup 
L30:    ldc [15] 
L32:    invokespecial [36] 
L35:    athrow 
L36:    aload_2 
L37:    iconst_0 
L38:    aload_0 
L39:    getfield [22] 
L42:    iload 5 
L44:    iload_1 
L45:    iadd 
L46:    iload_3 
L47:    invokestatic [4] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [196] .code stack 4 locals 1 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [21] 
L5:     invokevirtual [30] 
L8:     ifne L88 
L11:    new [42] 
L14:    dup 
L15:    new [43] 
L18:    dup 
L19:    invokespecial [35] 
L22:    ldc [16] 
L24:    invokevirtual [25] 
L27:    aload_1 
L28:    invokevirtual [28] 
L31:    invokevirtual [26] 
L34:    ldc [9] 
L36:    invokevirtual [25] 
L39:    aload_1 
L40:    invokevirtual [24] 
L43:    invokevirtual [26] 
L46:    ldc [17] 
L48:    invokevirtual [25] 
L51:    aload_0 
L52:    getfield [23] 
L55:    invokevirtual [28] 
L58:    invokevirtual [26] 
L61:    ldc [9] 
L63:    invokevirtual [25] 
L66:    aload_0 
L67:    getfield [23] 
L70:    invokevirtual [24] 
L73:    invokevirtual [26] 
L76:    ldc [18] 
L78:    invokevirtual [25] 
L81:    invokevirtual [27] 
L84:    invokespecial [36] 
L87:    athrow 
L88:    aload_0 
L89:    getfield [23] 
L92:    astore_2 
L93:    aload_0 
L94:    aload_1 
L95:    putfield [41] 
L98:    aload_2 
L99:    areturn 
L100:   
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [196] .code stack 4 locals 2 
L0:     new [40] 
L3:     dup 
L4:     aload_0 
L5:     getfield [23] 
L8:     invokevirtual [28] 
L11:    iload_1 
L12:    iadd 
L13:    iload_2 
L14:    invokespecial [33] 
L17:    astore_3 
L18:    aload_3 
L19:    aload_0 
L20:    getfield [21] 
L23:    invokevirtual [30] 
L26:    ifne L106 
L29:    new [42] 
L32:    dup 
L33:    new [43] 
L36:    dup 
L37:    invokespecial [35] 
L40:    ldc [16] 
L42:    invokevirtual [25] 
L45:    aload_3 
L46:    invokevirtual [28] 
L49:    invokevirtual [26] 
L52:    ldc [9] 
L54:    invokevirtual [25] 
L57:    aload_3 
L58:    invokevirtual [24] 
L61:    invokevirtual [26] 
L64:    ldc [17] 
L66:    invokevirtual [25] 
L69:    aload_0 
L70:    getfield [23] 
L73:    invokevirtual [28] 
L76:    invokevirtual [26] 
L79:    ldc [9] 
L81:    invokevirtual [25] 
L84:    aload_0 
L85:    getfield [23] 
L88:    invokevirtual [24] 
L91:    invokevirtual [26] 
L94:    ldc [18] 
L96:    invokevirtual [25] 
L99:    invokevirtual [27] 
L102:   invokespecial [36] 
L105:   athrow 
L106:   aload_0 
L107:   getfield [23] 
L110:   astore 4 
L112:   aload_0 
L113:   aload_3 
L114:   putfield [41] 
L117:   aload 4 
L119:   areturn 
L120:   
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [196] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [40] 
L4:     dup 
L5:     iconst_0 
L6:     aload_0 
L7:     getfield [22] 
L10:    arraylength 
L11:    invokespecial [33] 
L14:    putfield [41] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [196] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [45] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [231] : [232] 
    .attribute [196] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = Class [47] 
.const [4] = Method [48] [49] 
.const [5] = Class [50] 
.const [6] = Class [51] 
.const [7] = Class [52] 
.const [8] = String [53] 
.const [9] = String [54] 
.const [10] = String [55] 
.const [11] = String [56] 
.const [12] = Class [57] 
.const [13] = String [58] 
.const [14] = String [59] 
.const [15] = String [60] 
.const [16] = String [61] 
.const [17] = String [62] 
.const [18] = String [63] 
.const [19] = Class [64] 
.const [20] = Class [65] 
.const [21] = Field [66] [67] 
.const [22] = Field [68] [69] 
.const [23] = Field [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Field [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Method [98] [99] 
.const [38] = Field [100] [101] 
.const [39] = Field [102] [103] 
.const [40] = Class [104] 
.const [41] = Field [105] [106] 
.const [42] = Class [107] 
.const [43] = Class [108] 
.const [44] = Class [109] 
.const [45] = Field [110] [111] 
.const [46] = Utf8 de/esolutions/fw/util/transport/WriteableWindow 
.const [47] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [48] = Class [112] 
.const [49] = NameAndType [113] [114] 
.const [50] = Utf8 java/lang/CloneNotSupportedException 
.const [51] = Utf8 de/esolutions/fw/util/transport/exception/TransportBufferException 
.const [52] = Utf8 java/lang/StringBuffer 
.const [53] = Utf8 'getData out of range: data=(@' 
.const [54] = Utf8 ',' 
.const [55] = Utf8 ') size=' 
.const [56] = Utf8 'Invalid window for sub buffer: new=(@' 
.const [57] = Utf8 de/esolutions/fw/util/transport/buffer/TransportSubBuffer 
.const [58] = Utf8 'Invalid data size: expected=' 
.const [59] = Utf8 ' found: ' 
.const [60] = Utf8 'Data out of window' 
.const [61] = Utf8 'Invalid window (' 
.const [62] = Utf8 ') current (' 
.const [63] = Utf8 ')' 
.const [64] = Utf8 java/lang/Object 
.const [65] = Utf8 java/lang/System 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Class [145] 
.const [87] = NameAndType [146] [147] 
.const [88] = Class [148] 
.const [89] = NameAndType [149] [150] 
.const [90] = Class [151] 
.const [91] = NameAndType [152] [153] 
.const [92] = Class [154] 
.const [93] = NameAndType [155] [156] 
.const [94] = Class [157] 
.const [95] = NameAndType [158] [159] 
.const [96] = Class [160] 
.const [97] = NameAndType [161] [162] 
.const [98] = Class [163] 
.const [99] = NameAndType [164] [165] 
.const [100] = Class [166] 
.const [101] = NameAndType [167] [168] 
.const [102] = Class [169] 
.const [103] = NameAndType [170] [171] 
.const [104] = Utf8 de/esolutions/fw/util/transport/WriteableWindow 
.const [105] = Class [172] 
.const [106] = NameAndType [173] [174] 
.const [107] = Utf8 de/esolutions/fw/util/transport/exception/TransportBufferException 
.const [108] = Utf8 java/lang/StringBuffer 
.const [109] = Utf8 de/esolutions/fw/util/transport/buffer/TransportSubBuffer 
.const [110] = Class [175] 
.const [111] = NameAndType [176] [177] 
.const [112] = Utf8 java/lang/System 
.const [113] = Utf8 arraycopy 
.const [114] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [115] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [116] = Utf8 size 
.const [117] = Utf8 I 
.const [118] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [119] = Utf8 data 
.const [120] = Utf8 [B 
.const [121] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [122] = Utf8 window 
.const [123] = Utf8 Lde/esolutions/fw/util/transport/WriteableWindow; 
.const [124] = Utf8 de/esolutions/fw/util/transport/WriteableWindow 
.const [125] = Utf8 getSize 
.const [126] = Utf8 ()I 
.const [127] = Utf8 java/lang/StringBuffer 
.const [128] = Utf8 append 
.const [129] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Utf8 append 
.const [132] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [133] = Utf8 java/lang/StringBuffer 
.const [134] = Utf8 toString 
.const [135] = Utf8 ()Ljava/lang/String; 
.const [136] = Utf8 de/esolutions/fw/util/transport/WriteableWindow 
.const [137] = Utf8 getOffset 
.const [138] = Utf8 ()I 
.const [139] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [140] = Utf8 size 
.const [141] = Utf8 ()I 
.const [142] = Utf8 de/esolutions/fw/util/transport/WriteableWindow 
.const [143] = Utf8 isInside 
.const [144] = Utf8 (I)Z 
.const [145] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [146] = Utf8 debugTag 
.const [147] = Utf8 Ljava/lang/Object; 
.const [148] = Utf8 java/lang/Object 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/esolutions/fw/util/transport/WriteableWindow 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (II)V 
.const [154] = Utf8 java/lang/Object 
.const [155] = Utf8 clone 
.const [156] = Utf8 ()Ljava/lang/Object; 
.const [157] = Utf8 java/lang/StringBuffer 
.const [158] = Utf8 <init> 
.const [159] = Utf8 ()V 
.const [160] = Utf8 de/esolutions/fw/util/transport/exception/TransportBufferException 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Ljava/lang/String;)V 
.const [163] = Utf8 de/esolutions/fw/util/transport/buffer/TransportSubBuffer 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (Lde/esolutions/fw/util/transport/buffer/TransportBuffer;II)V 
.const [166] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [167] = Utf8 size 
.const [168] = Utf8 I 
.const [169] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [170] = Utf8 data 
.const [171] = Utf8 [B 
.const [172] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [173] = Utf8 window 
.const [174] = Utf8 Lde/esolutions/fw/util/transport/WriteableWindow; 
.const [175] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [176] = Utf8 debugTag 
.const [177] = Utf8 Ljava/lang/Object; 
.const [178] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [179] = Class [178] 
.const [180] = Utf8 java/lang/Object 
.const [181] = Class [180] 
.const [182] = Utf8 java/lang/Cloneable 
.const [183] = Class [182] 
.const [184] = Utf8 de/esolutions/fw/util/transport/IReadable 
.const [185] = Class [184] 
.const [186] = Utf8 de/esolutions/fw/util/transport/IWriteable 
.const [187] = Class [186] 
.const [188] = Utf8 size 
.const [189] = Utf8 I 
.const [190] = Utf8 data 
.const [191] = Utf8 [B 
.const [192] = Utf8 window 
.const [193] = Utf8 Lde/esolutions/fw/util/transport/WriteableWindow; 
.const [194] = Utf8 debugTag 
.const [195] = Utf8 Ljava/lang/Object; 
.const [196] = Utf8 Code 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (I)V 
.const [199] = Utf8 <init> 
.const [200] = Utf8 ([B)V 
.const [201] = Utf8 clone 
.const [202] = Utf8 ()Ljava/lang/Object; 
.const [203] = Utf8 size 
.const [204] = Utf8 ()I 
.const [205] = Utf8 data 
.const [206] = Utf8 ()[B 
.const [207] = Utf8 getData 
.const [208] = Utf8 ()[B 
.const [209] = Utf8 getData 
.const [210] = Utf8 (II)[B 
.const [211] = Utf8 getDirectData 
.const [212] = Utf8 ()[B 
.const [213] = Utf8 getDirectOffset 
.const [214] = Utf8 ()I 
.const [215] = Utf8 createSubBuffer 
.const [216] = Utf8 (II)Lde/esolutions/fw/util/transport/IReadable; 
.const [217] = Utf8 setData 
.const [218] = Utf8 ([B)V 
.const [219] = Utf8 setData 
.const [220] = Utf8 (I[B)V 
.const [221] = Utf8 setData 
.const [222] = Utf8 (I[BI)V 
.const [223] = Utf8 setWindow 
.const [224] = Utf8 (Lde/esolutions/fw/util/transport/WriteableWindow;)Lde/esolutions/fw/util/transport/WriteableWindow; 
.const [225] = Utf8 setLocalWindow 
.const [226] = Utf8 (II)Lde/esolutions/fw/util/transport/WriteableWindow; 
.const [227] = Utf8 resetWindow 
.const [228] = Utf8 ()V 
.const [229] = Utf8 setDebugTag 
.const [230] = Utf8 (Ljava/lang/Object;)V 
.const [231] = Utf8 getDebugTag 
.const [232] = Utf8 ()Ljava/lang/Object; 
.end class 
