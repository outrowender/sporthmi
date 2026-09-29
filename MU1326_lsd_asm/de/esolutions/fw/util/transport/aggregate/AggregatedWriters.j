.version 50 0 
.class public super [155] 
.super [157] 
.implements [159] 
.field private [160] [161] 
.field protected [162] [163] 
.field protected [164] [165] 
.field protected [166] [167] 
.field public static final [168] [169] 
.field public static final [170] [171] 

.method public [173] : [174] 
    .attribute [172] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     new [18] 
L8:     dup 
L9:     invokespecial [16] 
L12:    putfield [19] 
L15:    aload_0 
L16:    iconst_4 
L17:    putfield [20] 
L20:    aload_0 
L21:    iload_1 
L22:    putfield [21] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [172] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     aload_1 
L5:     invokeinterface [22] 0 
L10:    pop 
L11:    aload_0 
L12:    dup 
L13:    getfield [11] 
L16:    iconst_4 
L17:    aload_1 
L18:    invokeinterface [23] 0 
L23:    iadd 
L24:    iadd 
L25:    putfield [20] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_1 
L5:     invokeinterface [23] 0 
L10:    iadd 
L11:    iconst_4 
L12:    iadd 
L13:    aload_0 
L14:    getfield [12] 
L17:    if_icmpgt L24 
L20:    iconst_1 
L21:    goto L25 
L24:    iconst_0 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     aload_0 
L5:     getfield [11] 
L8:     isub 
L9:     iconst_4 
L10:    isub 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     iconst_4 
L5:     isub 
L6:     iconst_4 
L7:     isub 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [172] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokeinterface [24] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [185] : [186] 
    .attribute [172] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [172] .code stack 3 locals 8 
L0:     new [25] 
L3:     dup 
L4:     invokespecial [17] 
L7:     astore_2 
L8:     iconst_4 
L9:     newarray byte 
L11:    astore_3 
L12:    aload_0 
L13:    getfield [10] 
L16:    invokeinterface [24] 0 
L21:    istore 4 
L23:    aload_2 
L24:    iload 4 
L26:    aload_3 
L27:    invokevirtual [13] 
L30:    aload_1 
L31:    iconst_0 
L32:    aload_3 
L33:    invokeinterface [26] 0 
L38:    iconst_4 
L39:    istore 5 
L41:    aload_0 
L42:    getfield [10] 
L45:    invokeinterface [27] 0 
L50:    astore 6 
L52:    aload 6 
L54:    invokeinterface [28] 0 
L59:    ifeq L141 
L62:    aload 6 
L64:    invokeinterface [29] 0 
L69:    checkcast [4] 
L72:    astore 7 
L74:    aload 7 
L76:    invokeinterface [23] 0 
L81:    istore 8 
L83:    aload_2 
L84:    iload 8 
L86:    aload_3 
L87:    invokevirtual [13] 
L90:    aload_1 
L91:    iload 5 
L93:    aload_3 
L94:    invokeinterface [26] 0 
L99:    iinc 5 4 
L102:   aload_1 
L103:   iload 5 
L105:   iload 8 
L107:   invokeinterface [30] 0 
L112:   astore 9 
L114:   aload 7 
L116:   aload_1 
L117:   invokeinterface [31] 0 
L122:   aload_1 
L123:   aload 9 
L125:   invokeinterface [32] 0 
L130:   pop 
L131:   iload 5 
L133:   iload 8 
L135:   iadd 
L136:   istore 5 
L138:   goto L52 
L141:   return 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [33] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [191] : [192] 
    .attribute [172] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Class [36] 
.const [5] = Class [37] 
.const [6] = Class [38] 
.const [7] = Class [39] 
.const [8] = Class [40] 
.const [9] = Class [41] 
.const [10] = Field [42] [43] 
.const [11] = Field [44] [45] 
.const [12] = Field [46] [47] 
.const [13] = Method [48] [49] 
.const [14] = Field [50] [51] 
.const [15] = Method [52] [53] 
.const [16] = Method [54] [55] 
.const [17] = Method [56] [57] 
.const [18] = Class [58] 
.const [19] = Field [59] [60] 
.const [20] = Field [61] [62] 
.const [21] = Field [63] [64] 
.const [22] = InterfaceMethod [65] [66] 
.const [23] = InterfaceMethod [67] [68] 
.const [24] = InterfaceMethod [69] [70] 
.const [25] = Class [71] 
.const [26] = InterfaceMethod [72] [73] 
.const [27] = InterfaceMethod [74] [75] 
.const [28] = InterfaceMethod [76] [77] 
.const [29] = InterfaceMethod [78] [79] 
.const [30] = InterfaceMethod [80] [81] 
.const [31] = InterfaceMethod [82] [83] 
.const [32] = InterfaceMethod [84] [85] 
.const [33] = Field [86] [87] 
.const [34] = Utf8 java/util/ArrayList 
.const [35] = Utf8 de/esolutions/fw/util/commons/miniser/BEMiniIntSerializer 
.const [36] = Utf8 de/esolutions/fw/util/transport/IWriter 
.const [37] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 java/util/List 
.const [40] = Utf8 de/esolutions/fw/util/transport/IWriteable 
.const [41] = Utf8 java/util/Iterator 
.const [42] = Class [88] 
.const [43] = NameAndType [89] [90] 
.const [44] = Class [91] 
.const [45] = NameAndType [92] [93] 
.const [46] = Class [94] 
.const [47] = NameAndType [95] [96] 
.const [48] = Class [97] 
.const [49] = NameAndType [98] [99] 
.const [50] = Class [100] 
.const [51] = NameAndType [101] [102] 
.const [52] = Class [103] 
.const [53] = NameAndType [104] [105] 
.const [54] = Class [106] 
.const [55] = NameAndType [107] [108] 
.const [56] = Class [109] 
.const [57] = NameAndType [110] [111] 
.const [58] = Utf8 java/util/ArrayList 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Class [115] 
.const [62] = NameAndType [116] [117] 
.const [63] = Class [118] 
.const [64] = NameAndType [119] [120] 
.const [65] = Class [121] 
.const [66] = NameAndType [122] [123] 
.const [67] = Class [124] 
.const [68] = NameAndType [125] [126] 
.const [69] = Class [127] 
.const [70] = NameAndType [128] [129] 
.const [71] = Utf8 de/esolutions/fw/util/commons/miniser/BEMiniIntSerializer 
.const [72] = Class [130] 
.const [73] = NameAndType [131] [132] 
.const [74] = Class [133] 
.const [75] = NameAndType [134] [135] 
.const [76] = Class [136] 
.const [77] = NameAndType [137] [138] 
.const [78] = Class [139] 
.const [79] = NameAndType [140] [141] 
.const [80] = Class [142] 
.const [81] = NameAndType [143] [144] 
.const [82] = Class [145] 
.const [83] = NameAndType [146] [147] 
.const [84] = Class [148] 
.const [85] = NameAndType [149] [150] 
.const [86] = Class [151] 
.const [87] = NameAndType [152] [153] 
.const [88] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [89] = Utf8 writerList 
.const [90] = Utf8 Ljava/util/List; 
.const [91] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [92] = Utf8 size 
.const [93] = Utf8 I 
.const [94] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [95] = Utf8 maxSize 
.const [96] = Utf8 I 
.const [97] = Utf8 de/esolutions/fw/util/commons/miniser/BEMiniIntSerializer 
.const [98] = Utf8 storeInt 
.const [99] = Utf8 (I[B)V 
.const [100] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [101] = Utf8 debugTag 
.const [102] = Utf8 Ljava/lang/Object; 
.const [103] = Utf8 java/lang/Object 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 java/util/ArrayList 
.const [107] = Utf8 <init> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 de/esolutions/fw/util/commons/miniser/BEMiniIntSerializer 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [113] = Utf8 writerList 
.const [114] = Utf8 Ljava/util/List; 
.const [115] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [116] = Utf8 size 
.const [117] = Utf8 I 
.const [118] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [119] = Utf8 maxSize 
.const [120] = Utf8 I 
.const [121] = Utf8 java/util/List 
.const [122] = Utf8 add 
.const [123] = Utf8 (Ljava/lang/Object;)Z 
.const [124] = Utf8 de/esolutions/fw/util/transport/IWriter 
.const [125] = Utf8 size 
.const [126] = Utf8 ()I 
.const [127] = Utf8 java/util/List 
.const [128] = Utf8 size 
.const [129] = Utf8 ()I 
.const [130] = Utf8 de/esolutions/fw/util/transport/IWriteable 
.const [131] = Utf8 setData 
.const [132] = Utf8 (I[B)V 
.const [133] = Utf8 java/util/List 
.const [134] = Utf8 iterator 
.const [135] = Utf8 ()Ljava/util/Iterator; 
.const [136] = Utf8 java/util/Iterator 
.const [137] = Utf8 hasNext 
.const [138] = Utf8 ()Z 
.const [139] = Utf8 java/util/Iterator 
.const [140] = Utf8 next 
.const [141] = Utf8 ()Ljava/lang/Object; 
.const [142] = Utf8 de/esolutions/fw/util/transport/IWriteable 
.const [143] = Utf8 setLocalWindow 
.const [144] = Utf8 (II)Lde/esolutions/fw/util/transport/WriteableWindow; 
.const [145] = Utf8 de/esolutions/fw/util/transport/IWriter 
.const [146] = Utf8 write 
.const [147] = Utf8 (Lde/esolutions/fw/util/transport/IWriteable;)V 
.const [148] = Utf8 de/esolutions/fw/util/transport/IWriteable 
.const [149] = Utf8 setWindow 
.const [150] = Utf8 (Lde/esolutions/fw/util/transport/WriteableWindow;)Lde/esolutions/fw/util/transport/WriteableWindow; 
.const [151] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [152] = Utf8 debugTag 
.const [153] = Utf8 Ljava/lang/Object; 
.const [154] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [155] = Class [154] 
.const [156] = Utf8 java/lang/Object 
.const [157] = Class [156] 
.const [158] = Utf8 de/esolutions/fw/util/transport/IWriter 
.const [159] = Class [158] 
.const [160] = Utf8 debugTag 
.const [161] = Utf8 Ljava/lang/Object; 
.const [162] = Utf8 writerList 
.const [163] = Utf8 Ljava/util/List; 
.const [164] = Utf8 size 
.const [165] = Utf8 I 
.const [166] = Utf8 maxSize 
.const [167] = Utf8 I 
.const [168] = Utf8 MSG_PREAMBLE_SIZE 
.const [169] = Utf8 I 
.const [170] = Utf8 MSG_HEADER_SIZE 
.const [171] = Utf8 I 
.const [172] = Utf8 Code 
.const [173] = Utf8 <init> 
.const [174] = Utf8 (I)V 
.const [175] = Utf8 addWritable 
.const [176] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [177] = Utf8 doesFit 
.const [178] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)Z 
.const [179] = Utf8 sizeLeft 
.const [180] = Utf8 ()I 
.const [181] = Utf8 maxSize 
.const [182] = Utf8 ()I 
.const [183] = Utf8 numEntries 
.const [184] = Utf8 ()I 
.const [185] = Utf8 size 
.const [186] = Utf8 ()I 
.const [187] = Utf8 write 
.const [188] = Utf8 (Lde/esolutions/fw/util/transport/IWriteable;)V 
.const [189] = Utf8 setDebugTag 
.const [190] = Utf8 (Ljava/lang/Object;)V 
.const [191] = Utf8 getDebugTag 
.const [192] = Utf8 ()Ljava/lang/Object; 
.end class 
