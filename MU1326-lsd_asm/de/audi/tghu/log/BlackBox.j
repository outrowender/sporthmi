.version 50 0 
.class public final super [89] 
.super [91] 
.field private [92] [93] 

.method public [95] : [96] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     new [17] 
L8:     dup 
L9:     iload_1 
L10:    invokespecial [16] 
L13:    putfield [18] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [97] : [98] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnull L18 
L4:     aload_1 
L5:     invokeinterface [19] 0 
L10:    aload_0 
L11:    getfield [9] 
L14:    aload_1 
L15:    invokevirtual [10] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [99] : [100] 
    .attribute [94] .code stack 2 locals 2 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     invokestatic [3] 
L8:     aload_1 
L9:     invokevirtual [11] 
L12:    iconst_0 
L13:    istore_3 
L14:    iload_3 
L15:    aload_0 
L16:    getfield [9] 
L19:    invokevirtual [12] 
L22:    if_icmpge L54 
L25:    aload_0 
L26:    getfield [9] 
L29:    iload_3 
L30:    invokevirtual [13] 
L33:    checkcast [4] 
L36:    astore_2 
L37:    aload_2 
L38:    aload_1 
L39:    invokeinterface [20] 0 
L44:    aload_1 
L45:    invokevirtual [14] 
L48:    iinc 3 1 
L51:    goto L14 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Method [22] [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Field [29] [30] 
.const [10] = Method [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Class [45] 
.const [18] = Field [46] [47] 
.const [19] = InterfaceMethod [48] [49] 
.const [20] = InterfaceMethod [50] [51] 
.const [21] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [22] = Class [52] 
.const [23] = NameAndType [53] [54] 
.const [24] = Utf8 de/audi/atip/log/LogEntry 
.const [25] = Utf8 de/audi/tghu/log/BlackBox 
.const [26] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [27] = Utf8 de/audi/tghu/log/LogExtractorFactory 
.const [28] = Utf8 java/io/PrintStream 
.const [29] = Class [55] 
.const [30] = NameAndType [56] [57] 
.const [31] = Class [58] 
.const [32] = NameAndType [59] [60] 
.const [33] = Class [61] 
.const [34] = NameAndType [62] [63] 
.const [35] = Class [64] 
.const [36] = NameAndType [65] [66] 
.const [37] = Class [67] 
.const [38] = NameAndType [68] [69] 
.const [39] = Class [70] 
.const [40] = NameAndType [71] [72] 
.const [41] = Class [73] 
.const [42] = NameAndType [74] [75] 
.const [43] = Class [76] 
.const [44] = NameAndType [77] [78] 
.const [45] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Utf8 de/audi/tghu/log/LogExtractorFactory 
.const [53] = Utf8 getInstance 
.const [54] = Utf8 ()Lde/audi/tghu/log/LogExtractorFactory; 
.const [55] = Utf8 de/audi/tghu/log/BlackBox 
.const [56] = Utf8 content 
.const [57] = Utf8 Lde/esolutions/fw/util/commons/RingBuffer; 
.const [58] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [59] = Utf8 put 
.const [60] = Utf8 (Ljava/lang/Object;)V 
.const [61] = Utf8 de/audi/tghu/log/LogExtractorFactory 
.const [62] = Utf8 dumpInfo 
.const [63] = Utf8 (Ljava/io/PrintStream;)V 
.const [64] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [65] = Utf8 size 
.const [66] = Utf8 ()I 
.const [67] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [68] = Utf8 get 
.const [69] = Utf8 (I)Ljava/lang/Object; 
.const [70] = Utf8 java/io/PrintStream 
.const [71] = Utf8 println 
.const [72] = Utf8 ()V 
.const [73] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 de/esolutions/fw/util/commons/RingBuffer 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (I)V 
.const [79] = Utf8 de/audi/tghu/log/BlackBox 
.const [80] = Utf8 content 
.const [81] = Utf8 Lde/esolutions/fw/util/commons/RingBuffer; 
.const [82] = Utf8 de/audi/atip/log/LogEntry 
.const [83] = Utf8 freezeArgs 
.const [84] = Utf8 ()V 
.const [85] = Utf8 de/audi/atip/log/LogEntry 
.const [86] = Utf8 print 
.const [87] = Utf8 (Ljava/io/PrintStream;)V 
.const [88] = Utf8 de/audi/tghu/log/BlackBox 
.const [89] = Class [88] 
.const [90] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [91] = Class [90] 
.const [92] = Utf8 content 
.const [93] = Utf8 Lde/esolutions/fw/util/commons/RingBuffer; 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (I)V 
.const [97] = Utf8 writeLog 
.const [98] = Utf8 (Lde/audi/atip/log/LogEntry;)V 
.const [99] = Utf8 dumpBuffer 
.const [100] = Utf8 (Ljava/io/PrintStream;)V 
.end class 
