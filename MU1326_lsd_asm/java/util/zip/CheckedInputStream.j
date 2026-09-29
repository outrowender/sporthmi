.version 50 0 
.class public super [59] 
.super [61] 
.field private [62] [63] 

.method public [65] : [66] 
    .attribute [64] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [10] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [11] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [64] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [8] 
L7:     istore_1 
L8:     iload_1 
L9:     iconst_m1 
L10:    if_icmpeq L23 
L13:    aload_0 
L14:    getfield [6] 
L17:    iload_1 
L18:    invokeinterface [12] 0 
L23:    iload_1 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [64] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_1 
L5:     iload_2 
L6:     iload_3 
L7:     invokevirtual [9] 
L10:    istore 4 
L12:    iload 4 
L14:    iconst_m1 
L15:    if_icmpeq L31 
L18:    aload_0 
L19:    getfield [6] 
L22:    aload_1 
L23:    iload_2 
L24:    iload 4 
L26:    invokeinterface [13] 0 
L31:    iload 4 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public interface [71] : [72] 
    .attribute [64] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [64] .code stack 7 locals 5 
L0:     lload_1 
L1:     lconst_1 
L2:     lcmp 
L3:     ifge L8 
L6:     lconst_0 
L7:     freturn 
L8:     lconst_0 
L9:     lstore_3 
L10:    sipush 2048 
L13:    newarray byte 
L15:    astore 5 
L17:    goto L81 
L20:    aload_0 
L21:    getfield [7] 
L24:    aload 5 
L26:    iconst_0 
L27:    lload_1 
L28:    lload_3 
L29:    lsub 
L30:    l2i 
L31:    dup 
L32:    istore 7 
L34:    aload 5 
L36:    arraylength 
L37:    if_icmple L46 
L40:    aload 5 
L42:    arraylength 
L43:    goto L48 
L46:    iload 7 
L48:    invokevirtual [9] 
L51:    istore 6 
L53:    iload 6 
L55:    iconst_m1 
L56:    if_icmpne L61 
L59:    lload_3 
L60:    freturn 
L61:    aload_0 
L62:    getfield [6] 
L65:    aload 5 
L67:    iconst_0 
L68:    iload 6 
L70:    invokeinterface [13] 0 
L75:    lload_3 
L76:    iload 6 
L78:    i2l 
L79:    ladd 
L80:    lstore_3 
L81:    lload_3 
L82:    lload_1 
L83:    lcmp 
L84:    ifne L20 
L87:    lload_3 
L88:    freturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Field [18] [19] 
.const [7] = Field [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = InterfaceMethod [30] [31] 
.const [13] = InterfaceMethod [32] [33] 
.const [14] = Utf8 java/util/zip/CheckedInputStream 
.const [15] = Utf8 java/io/FilterInputStream 
.const [16] = Utf8 java/io/InputStream 
.const [17] = Utf8 java/util/zip/Checksum 
.const [18] = Class [34] 
.const [19] = NameAndType [35] [36] 
.const [20] = Class [37] 
.const [21] = NameAndType [38] [39] 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Utf8 java/util/zip/CheckedInputStream 
.const [35] = Utf8 check 
.const [36] = Utf8 Ljava/util/zip/Checksum; 
.const [37] = Utf8 java/util/zip/CheckedInputStream 
.const [38] = Utf8 in 
.const [39] = Utf8 Ljava/io/InputStream; 
.const [40] = Utf8 java/io/InputStream 
.const [41] = Utf8 read 
.const [42] = Utf8 ()I 
.const [43] = Utf8 java/io/InputStream 
.const [44] = Utf8 read 
.const [45] = Utf8 ([BII)I 
.const [46] = Utf8 java/io/FilterInputStream 
.const [47] = Utf8 <init> 
.const [48] = Utf8 (Ljava/io/InputStream;)V 
.const [49] = Utf8 java/util/zip/CheckedInputStream 
.const [50] = Utf8 check 
.const [51] = Utf8 Ljava/util/zip/Checksum; 
.const [52] = Utf8 java/util/zip/Checksum 
.const [53] = Utf8 update 
.const [54] = Utf8 (I)V 
.const [55] = Utf8 java/util/zip/Checksum 
.const [56] = Utf8 update 
.const [57] = Utf8 ([BII)V 
.const [58] = Utf8 java/util/zip/CheckedInputStream 
.const [59] = Class [58] 
.const [60] = Utf8 java/io/FilterInputStream 
.const [61] = Class [60] 
.const [62] = Utf8 check 
.const [63] = Utf8 Ljava/util/zip/Checksum; 
.const [64] = Utf8 Code 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (Ljava/io/InputStream;Ljava/util/zip/Checksum;)V 
.const [67] = Utf8 read 
.const [68] = Utf8 ()I 
.const [69] = Utf8 read 
.const [70] = Utf8 ([BII)I 
.const [71] = Utf8 getChecksum 
.const [72] = Utf8 ()Ljava/util/zip/Checksum; 
.const [73] = Utf8 skip 
.const [74] = Utf8 (J)J 
.end class 
