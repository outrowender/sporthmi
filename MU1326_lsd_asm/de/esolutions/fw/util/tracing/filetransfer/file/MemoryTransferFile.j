.version 50 0 
.class public super [113] 
.super [115] 
.field private [116] [117] 

.method public [119] : [120] 
    .attribute [118] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [13] 
L5:     aload_0 
L6:     aconst_null 
L7:     putfield [14] 
L10:    aload_0 
L11:    aload_1 
L12:    putfield [15] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [16] 
L20:    aload_0 
L21:    iconst_0 
L22:    newarray byte 
L24:    putfield [14] 
L27:    aload_0 
L28:    lconst_0 
L29:    putfield [17] 
L32:    aload_0 
L33:    lconst_0 
L34:    putfield [18] 
L37:    aload_0 
L38:    iconst_0 
L39:    putfield [19] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [118] .code stack 3 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
        .catch [0] from L4 to L61 using L66 
L4:     aload_0 
L5:     getfield [8] 
L8:     ifne L62 
L11:    aload_0 
L12:    iconst_1 
L13:    putfield [16] 
L16:    aload_0 
L17:    lconst_0 
L18:    putfield [20] 
L21:    aload_0 
L22:    iload_1 
L23:    putfield [21] 
L26:    aload_0 
L27:    iconst_0 
L28:    putfield [19] 
L31:    aload_0 
L32:    aconst_null 
L33:    putfield [22] 
L36:    iload_1 
L37:    ifeq L50 
L40:    aload_0 
L41:    iconst_0 
L42:    newarray byte 
L44:    putfield [14] 
L47:    goto L58 
L50:    aload_0 
L51:    aload_0 
L52:    getfield [10] 
L55:    putfield [17] 
L58:    iconst_1 
L59:    aload_2 
L60:    monitorexit 
L61:    areturn 
        .catch [0] from L62 to L65 using L66 
L62:    iconst_0 
L63:    aload_2 
L64:    monitorexit 
L65:    areturn 
        .catch [0] from L66 to L69 using L66 
L66:    astore_3 
L67:    aload_2 
L68:    monitorexit 
L69:    aload_3 
L70:    athrow 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [118] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [15] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [118] .code stack 5 locals 3 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
        .catch [0] from L4 to L110 using L116 
L4:     aload_0 
L5:     getfield [8] 
L8:     ifeq L111 
L11:    aload_0 
L12:    getfield [12] 
L15:    ifeq L111 
L18:    aload_0 
L19:    getfield [9] 
L22:    lconst_0 
L23:    lcmp 
L24:    ifne L45 
L27:    aload_0 
L28:    aload_1 
L29:    putfield [14] 
L32:    aload_0 
L33:    aload_0 
L34:    getfield [7] 
L37:    arraylength 
L38:    i2l 
L39:    putfield [17] 
L42:    goto L107 
L45:    aload_0 
L46:    aload_0 
L47:    getfield [7] 
L50:    arraylength 
L51:    aload_1 
L52:    arraylength 
L53:    iadd 
L54:    i2l 
L55:    putfield [17] 
L58:    aload_0 
L59:    aload_0 
L60:    getfield [9] 
L63:    putfield [18] 
L66:    aload_0 
L67:    getfield [9] 
L70:    l2i 
L71:    newarray byte 
L73:    astore_3 
L74:    aload_0 
L75:    getfield [7] 
L78:    iconst_0 
L79:    aload_3 
L80:    iconst_0 
L81:    aload_0 
L82:    getfield [7] 
L85:    arraylength 
L86:    invokestatic [2] 
L89:    aload_1 
L90:    iconst_0 
L91:    aload_3 
L92:    aload_0 
L93:    getfield [7] 
L96:    arraylength 
L97:    aload_1 
L98:    arraylength 
L99:    invokestatic [2] 
L102:   aload_0 
L103:   aload_3 
L104:   putfield [14] 
L107:   iconst_1 
L108:   aload_2 
L109:   monitorexit 
L110:   areturn 
        .catch [0] from L111 to L113 using L116 
L111:   aload_2 
L112:   monitorexit 
L113:   goto L123 
        .catch [0] from L116 to L120 using L116 
L116:   astore 4 
L118:   aload_2 
L119:   monitorexit 
L120:   aload 4 
L122:   athrow 
L123:   iconst_0 
L124:   areturn 
L125:   nop 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [118] .code stack 5 locals 5 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
L4:     aload_0 
L5:     getfield [8] 
L8:     ifeq L120 
L11:    aload_0 
L12:    getfield [12] 
L15:    ifne L120 
L18:    iload_1 
L19:    istore_3 
L20:    aload_0 
L21:    getfield [11] 
L24:    aload_0 
L25:    getfield [9] 
L28:    lcmp 
L29:    iflt L38 
L32:    iconst_0 
L33:    newarray byte 
L35:    aload_2 
L36:    monitorexit 
L37:    areturn 
L38:    aload_0 
L39:    getfield [11] 
L42:    iload_3 
L43:    i2l 
L44:    ladd 
L45:    aload_0 
L46:    getfield [9] 
L49:    lcmp 
L50:    ifle L64 
L53:    aload_0 
L54:    getfield [9] 
L57:    aload_0 
L58:    getfield [11] 
L61:    lsub 
L62:    l2i 
L63:    istore_3 
L64:    iload_3 
L65:    newarray byte 
L67:    astore 4 
        .catch [3] from L69 to L85 using L88 
        .catch [0] from L4 to L37 using L125 
        .catch [0] from L38 to L103 using L125 
L69:    aload_0 
L70:    getfield [7] 
L73:    aload_0 
L74:    getfield [11] 
L77:    l2i 
L78:    aload 4 
L80:    iconst_0 
L81:    iload_3 
L82:    invokestatic [2] 
L85:    goto L104 
L88:    astore 5 
L90:    aload_0 
L91:    aload_0 
L92:    getfield [9] 
L95:    putfield [20] 
L98:    iconst_0 
L99:    newarray byte 
L101:   aload_2 
L102:   monitorexit 
L103:   areturn 
        .catch [0] from L104 to L119 using L125 
L104:   aload_0 
L105:   dup 
L106:   getfield [11] 
L109:   iload_3 
L110:   i2l 
L111:   ladd 
L112:   putfield [20] 
L115:   aload 4 
L117:   aload_2 
L118:   monitorexit 
L119:   areturn 
        .catch [0] from L120 to L122 using L125 
L120:   aload_2 
L121:   monitorexit 
L122:   goto L132 
        .catch [0] from L125 to L129 using L125 
L125:   astore 6 
L127:   aload_2 
L128:   monitorexit 
L129:   aload 6 
L131:   athrow 
L132:   aconst_null 
L133:   areturn 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [118] .code stack 2 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_1 
L3:     monitorenter 
        .catch [0] from L4 to L19 using L24 
L4:     aload_0 
L5:     getfield [8] 
L8:     ifeq L20 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [16] 
L16:    iconst_1 
L17:    aload_1 
L18:    monitorexit 
L19:    areturn 
        .catch [0] from L20 to L23 using L24 
L20:    iconst_0 
L21:    aload_1 
L22:    monitorexit 
L23:    areturn 
        .catch [0] from L24 to L27 using L24 
L24:    astore_2 
L25:    aload_1 
L26:    monitorexit 
L27:    aload_2 
L28:    athrow 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [23] [24] 
.const [3] = Class [25] 
.const [4] = Class [26] 
.const [5] = Class [27] 
.const [6] = Class [28] 
.const [7] = Field [29] [30] 
.const [8] = Field [31] [32] 
.const [9] = Field [33] [34] 
.const [10] = Field [35] [36] 
.const [11] = Field [37] [38] 
.const [12] = Field [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Field [43] [44] 
.const [15] = Field [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Field [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Class [61] 
.const [24] = NameAndType [62] [63] 
.const [25] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [26] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [27] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/AbstractTransferFile 
.const [28] = Utf8 java/lang/System 
.const [29] = Class [64] 
.const [30] = NameAndType [65] [66] 
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
.const [61] = Utf8 java/lang/System 
.const [62] = Utf8 arraycopy 
.const [63] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [64] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [65] = Utf8 data 
.const [66] = Utf8 [B 
.const [67] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [68] = Utf8 'open' 
.const [69] = Utf8 Z 
.const [70] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [71] = Utf8 size 
.const [72] = Utf8 J 
.const [73] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [74] = Utf8 completeSize 
.const [75] = Utf8 J 
.const [76] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [77] = Utf8 offset 
.const [78] = Utf8 J 
.const [79] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [80] = Utf8 writable 
.const [81] = Utf8 Z 
.const [82] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/AbstractTransferFile 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Ljava/lang/String;)V 
.const [85] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [86] = Utf8 data 
.const [87] = Utf8 [B 
.const [88] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [89] = Utf8 localPath 
.const [90] = Utf8 Ljava/lang/String; 
.const [91] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [92] = Utf8 'open' 
.const [93] = Utf8 Z 
.const [94] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [95] = Utf8 size 
.const [96] = Utf8 J 
.const [97] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [98] = Utf8 completeSize 
.const [99] = Utf8 J 
.const [100] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [101] = Utf8 error 
.const [102] = Utf8 Z 
.const [103] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [104] = Utf8 offset 
.const [105] = Utf8 J 
.const [106] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [107] = Utf8 writable 
.const [108] = Utf8 Z 
.const [109] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [110] = Utf8 errorObject 
.const [111] = Utf8 Lde/esolutions/fw/util/tracing/filetransfer/FileTransferError; 
.const [112] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/MemoryTransferFile 
.const [113] = Class [112] 
.const [114] = Utf8 de/esolutions/fw/util/tracing/filetransfer/file/AbstractTransferFile 
.const [115] = Class [114] 
.const [116] = Utf8 data 
.const [117] = Utf8 [B 
.const [118] = Utf8 Code 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Ljava/lang/String;)V 
.const [121] = Utf8 'open' 
.const [122] = Utf8 (Z)Z 
.const [123] = Utf8 setLocalPath 
.const [124] = Utf8 (Ljava/lang/String;)V 
.const [125] = Utf8 write 
.const [126] = Utf8 ([B)Z 
.const [127] = Utf8 read 
.const [128] = Utf8 (I)[B 
.const [129] = Utf8 close 
.const [130] = Utf8 ()Z 
.end class 
