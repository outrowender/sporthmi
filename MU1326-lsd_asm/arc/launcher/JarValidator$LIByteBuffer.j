.version 50 0 
.class public super [45] 
.super [47] 
.field [48] [49] 
.field [50] [51] 

.method private [53] : [54] 
    .attribute [52] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [9] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [55] : [56] 
    .attribute [52] .code stack 3 locals 0 
L0:     new [8] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [7] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [57] : [58] 
    .attribute [52] .code stack 3 locals 0 
L0:     new [8] 
L3:     dup 
L4:     iload_0 
L5:     newarray byte 
L7:     invokespecial [7] 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [59] : [60] 
    .attribute [52] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [52] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [10] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [52] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     aload_0 
L5:     dup 
L6:     getfield [5] 
L9:     dup_x1 
L10:    iconst_1 
L11:    iadd 
L12:    putfield [10] 
L15:    baload 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [52] .code stack 5 locals 2 
L0:     aload_1 
L1:     arraylength 
L2:     istore_2 
L3:     iconst_0 
L4:     istore_3 
L5:     goto L30 
L8:     aload_0 
L9:     getfield [4] 
L12:    aload_0 
L13:    dup 
L14:    getfield [5] 
L17:    dup_x1 
L18:    iconst_1 
L19:    iadd 
L20:    putfield [10] 
L23:    aload_1 
L24:    iload_3 
L25:    baload 
L26:    bastore 
L27:    iinc 3 1 
L30:    iload_3 
L31:    iload_2 
L32:    if_icmplt L8 
L35:    return 
L36:    
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [52] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [4] 
L4:     aload_0 
L5:     dup 
L6:     getfield [5] 
L9:     dup_x1 
L10:    iconst_1 
L11:    iadd 
L12:    putfield [10] 
L15:    baload 
L16:    sipush 255 
L19:    iand 
L20:    istore_1 
L21:    aload_0 
L22:    getfield [4] 
L25:    aload_0 
L26:    dup 
L27:    getfield [5] 
L30:    dup_x1 
L31:    iconst_1 
L32:    iadd 
L33:    putfield [10] 
L36:    baload 
L37:    sipush 255 
L40:    iand 
L41:    istore_2 
L42:    iload_2 
L43:    bipush 8 
L45:    ishl 
L46:    iload_1 
L47:    iconst_0 
L48:    ishl 
L49:    iadd 
L50:    i2s 
L51:    areturn 
L52:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [52] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     aload_0 
L5:     dup 
L6:     getfield [5] 
L9:     dup_x1 
L10:    iconst_1 
L11:    iadd 
L12:    putfield [10] 
L15:    iload_1 
L16:    iconst_0 
L17:    iushr 
L18:    sipush 255 
L21:    iand 
L22:    i2b 
L23:    bastore 
L24:    aload_0 
L25:    getfield [4] 
L28:    aload_0 
L29:    dup 
L30:    getfield [5] 
L33:    dup_x1 
L34:    iconst_1 
L35:    iadd 
L36:    putfield [10] 
L39:    iload_1 
L40:    bipush 8 
L42:    iushr 
L43:    sipush 255 
L46:    iand 
L47:    i2b 
L48:    bastore 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [52] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [4] 
L4:     aload_0 
L5:     dup 
L6:     getfield [5] 
L9:     dup_x1 
L10:    iconst_1 
L11:    iadd 
L12:    putfield [10] 
L15:    baload 
L16:    sipush 255 
L19:    iand 
L20:    istore_1 
L21:    aload_0 
L22:    getfield [4] 
L25:    aload_0 
L26:    dup 
L27:    getfield [5] 
L30:    dup_x1 
L31:    iconst_1 
L32:    iadd 
L33:    putfield [10] 
L36:    baload 
L37:    sipush 255 
L40:    iand 
L41:    istore_2 
L42:    aload_0 
L43:    getfield [4] 
L46:    aload_0 
L47:    dup 
L48:    getfield [5] 
L51:    dup_x1 
L52:    iconst_1 
L53:    iadd 
L54:    putfield [10] 
L57:    baload 
L58:    sipush 255 
L61:    iand 
L62:    istore_3 
L63:    aload_0 
L64:    getfield [4] 
L67:    aload_0 
L68:    dup 
L69:    getfield [5] 
L72:    dup_x1 
L73:    iconst_1 
L74:    iadd 
L75:    putfield [10] 
L78:    baload 
L79:    sipush 255 
L82:    iand 
L83:    istore 4 
L85:    iload 4 
L87:    bipush 24 
L89:    ishl 
L90:    iload_3 
L91:    bipush 16 
L93:    ishl 
L94:    iadd 
L95:    iload_2 
L96:    bipush 8 
L98:    ishl 
L99:    iadd 
L100:   iload_1 
L101:   iconst_0 
L102:   ishl 
L103:   iadd 
L104:   areturn 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [52] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     aload_0 
L5:     dup 
L6:     getfield [5] 
L9:     dup_x1 
L10:    iconst_1 
L11:    iadd 
L12:    putfield [10] 
L15:    iload_1 
L16:    iconst_0 
L17:    iushr 
L18:    sipush 255 
L21:    iand 
L22:    i2b 
L23:    bastore 
L24:    aload_0 
L25:    getfield [4] 
L28:    aload_0 
L29:    dup 
L30:    getfield [5] 
L33:    dup_x1 
L34:    iconst_1 
L35:    iadd 
L36:    putfield [10] 
L39:    iload_1 
L40:    bipush 8 
L42:    iushr 
L43:    sipush 255 
L46:    iand 
L47:    i2b 
L48:    bastore 
L49:    aload_0 
L50:    getfield [4] 
L53:    aload_0 
L54:    dup 
L55:    getfield [5] 
L58:    dup_x1 
L59:    iconst_1 
L60:    iadd 
L61:    putfield [10] 
L64:    iload_1 
L65:    bipush 16 
L67:    iushr 
L68:    sipush 255 
L71:    iand 
L72:    i2b 
L73:    bastore 
L74:    aload_0 
L75:    getfield [4] 
L78:    aload_0 
L79:    dup 
L80:    getfield [5] 
L83:    dup_x1 
L84:    iconst_1 
L85:    iadd 
L86:    putfield [10] 
L89:    iload_1 
L90:    bipush 24 
L92:    iushr 
L93:    sipush 255 
L96:    iand 
L97:    i2b 
L98:    bastore 
L99:    return 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [11] 
.const [3] = Class [12] 
.const [4] = Field [13] [14] 
.const [5] = Field [15] [16] 
.const [6] = Method [17] [18] 
.const [7] = Method [19] [20] 
.const [8] = Class [21] 
.const [9] = Field [22] [23] 
.const [10] = Field [24] [25] 
.const [11] = Utf8 arc/launcher/JarValidator$LIByteBuffer 
.const [12] = Utf8 java/lang/Object 
.const [13] = Class [26] 
.const [14] = NameAndType [27] [28] 
.const [15] = Class [29] 
.const [16] = NameAndType [30] [31] 
.const [17] = Class [32] 
.const [18] = NameAndType [33] [34] 
.const [19] = Class [35] 
.const [20] = NameAndType [36] [37] 
.const [21] = Utf8 arc/launcher/JarValidator$LIByteBuffer 
.const [22] = Class [38] 
.const [23] = NameAndType [39] [40] 
.const [24] = Class [41] 
.const [25] = NameAndType [42] [43] 
.const [26] = Utf8 arc/launcher/JarValidator$LIByteBuffer 
.const [27] = Utf8 buf 
.const [28] = Utf8 [B 
.const [29] = Utf8 arc/launcher/JarValidator$LIByteBuffer 
.const [30] = Utf8 pos 
.const [31] = Utf8 I 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 <init> 
.const [34] = Utf8 ()V 
.const [35] = Utf8 arc/launcher/JarValidator$LIByteBuffer 
.const [36] = Utf8 <init> 
.const [37] = Utf8 ([B)V 
.const [38] = Utf8 arc/launcher/JarValidator$LIByteBuffer 
.const [39] = Utf8 buf 
.const [40] = Utf8 [B 
.const [41] = Utf8 arc/launcher/JarValidator$LIByteBuffer 
.const [42] = Utf8 pos 
.const [43] = Utf8 I 
.const [44] = Utf8 arc/launcher/JarValidator$LIByteBuffer 
.const [45] = Class [44] 
.const [46] = Utf8 java/lang/Object 
.const [47] = Class [46] 
.const [48] = Utf8 pos 
.const [49] = Utf8 I 
.const [50] = Utf8 buf 
.const [51] = Utf8 [B 
.const [52] = Utf8 Code 
.const [53] = Utf8 <init> 
.const [54] = Utf8 ([B)V 
.const [55] = Utf8 wrap 
.const [56] = Utf8 ([B)Larc/launcher/JarValidator$LIByteBuffer; 
.const [57] = Utf8 allocate 
.const [58] = Utf8 (I)Larc/launcher/JarValidator$LIByteBuffer; 
.const [59] = Utf8 array 
.const [60] = Utf8 ()[B 
.const [61] = Utf8 position 
.const [62] = Utf8 (I)V 
.const [63] = Utf8 get 
.const [64] = Utf8 ()B 
.const [65] = Utf8 put 
.const [66] = Utf8 ([B)V 
.const [67] = Utf8 getShort 
.const [68] = Utf8 ()S 
.const [69] = Utf8 putShort 
.const [70] = Utf8 (S)V 
.const [71] = Utf8 getInt 
.const [72] = Utf8 ()I 
.const [73] = Utf8 putInt 
.const [74] = Utf8 (I)V 
.end class 
