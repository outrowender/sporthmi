.version 50 0 
.class public super [173] 
.super [175] 
.field protected [176] [177] 
.field protected [178] [179] 
.field protected [180] [181] 
.field protected [182] [183] 

.method public [185] : [186] 
    .attribute [184] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [27] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [184] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [28] 
L5:     aload_0 
L6:     getfield [12] 
L9:     ifne L25 
L12:    aload_0 
L13:    aload_0 
L14:    getfield [11] 
L17:    invokeinterface [29] 0 
L22:    putfield [28] 
L25:    aload_0 
L26:    aload_0 
L27:    getfield [12] 
L30:    iconst_4 
L31:    idiv 
L32:    putfield [30] 
L35:    aload_0 
L36:    new [31] 
L39:    dup 
L40:    aload_0 
L41:    getfield [12] 
L44:    invokespecial [23] 
L47:    putfield [32] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [15] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected [191] : [192] 
    .attribute [184] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [16] 
L7:     ifne L11 
L10:    return 
L11:    aload_0 
L12:    getfield [11] 
L15:    aload_0 
L16:    getfield [14] 
L19:    invokeinterface [33] 0 
L24:    aload_0 
L25:    new [31] 
L28:    dup 
L29:    aload_0 
L30:    getfield [12] 
L33:    invokespecial [23] 
L36:    putfield [32] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [184] .code stack 3 locals 1 
L0:     aload_1 
L1:     invokeinterface [34] 0 
L6:     istore_2 
L7:     iload_2 
L8:     aload_0 
L9:     getfield [14] 
L12:    invokevirtual [15] 
L15:    if_icmple L28 
L18:    new [35] 
L21:    dup 
L22:    ldc [4] 
L24:    invokespecial [24] 
L27:    athrow 
L28:    aload_0 
L29:    getfield [14] 
L32:    aload_1 
L33:    invokevirtual [17] 
L36:    ifne L43 
L39:    aload_0 
L40:    invokevirtual [18] 
L43:    aload_0 
L44:    getfield [14] 
L47:    aload_1 
L48:    invokevirtual [19] 
L51:    aload_0 
L52:    getfield [14] 
L55:    invokevirtual [20] 
L58:    aload_0 
L59:    getfield [13] 
L62:    if_icmpge L69 
L65:    aload_0 
L66:    invokevirtual [18] 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [184] .code stack 4 locals 1 
L0:     new [36] 
L3:     dup 
L4:     aload_1 
L5:     invokeinterface [34] 0 
L10:    invokespecial [25] 
L13:    astore_2 
L14:    aload_1 
L15:    aload_2 
L16:    invokeinterface [37] 0 
L21:    aload_0 
L22:    new [38] 
L25:    dup 
L26:    aload_2 
L27:    invokespecial [26] 
L30:    invokevirtual [21] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [16] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [16] 
L7:     ifle L14 
L10:    aload_0 
L11:    invokevirtual [18] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = Class [40] 
.const [4] = String [41] 
.const [5] = Class [42] 
.const [6] = Class [43] 
.const [7] = Class [44] 
.const [8] = Class [45] 
.const [9] = Class [46] 
.const [10] = Class [47] 
.const [11] = Field [48] [49] 
.const [12] = Field [50] [51] 
.const [13] = Field [52] [53] 
.const [14] = Field [54] [55] 
.const [15] = Method [56] [57] 
.const [16] = Method [58] [59] 
.const [17] = Method [60] [61] 
.const [18] = Method [62] [63] 
.const [19] = Method [64] [65] 
.const [20] = Method [66] [67] 
.const [21] = Method [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Field [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = InterfaceMethod [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Class [88] 
.const [32] = Field [89] [90] 
.const [33] = InterfaceMethod [91] [92] 
.const [34] = InterfaceMethod [93] [94] 
.const [35] = Class [95] 
.const [36] = Class [96] 
.const [37] = InterfaceMethod [97] [98] 
.const [38] = Class [99] 
.const [39] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [40] = Utf8 de/esolutions/fw/util/transport/exception/InvalidTransportFormatException 
.const [41] = Utf8 'Message too large' 
.const [42] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [43] = Utf8 de/esolutions/fw/util/transport/CopyWriter 
.const [44] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [47] = Utf8 de/esolutions/fw/util/transport/IWriter 
.const [48] = Class [100] 
.const [49] = NameAndType [101] [102] 
.const [50] = Class [103] 
.const [51] = NameAndType [104] [105] 
.const [52] = Class [106] 
.const [53] = NameAndType [107] [108] 
.const [54] = Class [109] 
.const [55] = NameAndType [110] [111] 
.const [56] = Class [112] 
.const [57] = NameAndType [113] [114] 
.const [58] = Class [115] 
.const [59] = NameAndType [116] [117] 
.const [60] = Class [118] 
.const [61] = NameAndType [119] [120] 
.const [62] = Class [121] 
.const [63] = NameAndType [122] [123] 
.const [64] = Class [124] 
.const [65] = NameAndType [125] [126] 
.const [66] = Class [127] 
.const [67] = NameAndType [128] [129] 
.const [68] = Class [130] 
.const [69] = NameAndType [131] [132] 
.const [70] = Class [133] 
.const [71] = NameAndType [134] [135] 
.const [72] = Class [136] 
.const [73] = NameAndType [137] [138] 
.const [74] = Class [139] 
.const [75] = NameAndType [140] [141] 
.const [76] = Class [142] 
.const [77] = NameAndType [143] [144] 
.const [78] = Class [145] 
.const [79] = NameAndType [146] [147] 
.const [80] = Class [148] 
.const [81] = NameAndType [149] [150] 
.const [82] = Class [151] 
.const [83] = NameAndType [152] [153] 
.const [84] = Class [154] 
.const [85] = NameAndType [155] [156] 
.const [86] = Class [157] 
.const [87] = NameAndType [158] [159] 
.const [88] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [89] = Class [160] 
.const [90] = NameAndType [161] [162] 
.const [91] = Class [163] 
.const [92] = NameAndType [164] [165] 
.const [93] = Class [166] 
.const [94] = NameAndType [167] [168] 
.const [95] = Utf8 de/esolutions/fw/util/transport/exception/InvalidTransportFormatException 
.const [96] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [97] = Class [169] 
.const [98] = NameAndType [170] [171] 
.const [99] = Utf8 de/esolutions/fw/util/transport/CopyWriter 
.const [100] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [101] = Utf8 transport 
.const [102] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [103] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [104] = Utf8 packetSize 
.const [105] = Utf8 I 
.const [106] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [107] = Utf8 maxLeftForSend 
.const [108] = Utf8 I 
.const [109] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [110] = Utf8 aggregate 
.const [111] = Utf8 Lde/esolutions/fw/util/transport/aggregate/AggregatedWriters; 
.const [112] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [113] = Utf8 maxSize 
.const [114] = Utf8 ()I 
.const [115] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [116] = Utf8 numEntries 
.const [117] = Utf8 ()I 
.const [118] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [119] = Utf8 doesFit 
.const [120] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)Z 
.const [121] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [122] = Utf8 sendPacket 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [125] = Utf8 addWritable 
.const [126] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [127] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [128] = Utf8 sizeLeft 
.const [129] = Utf8 ()I 
.const [130] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [131] = Utf8 putMessage 
.const [132] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [133] = Utf8 java/lang/Object 
.const [134] = Utf8 <init> 
.const [135] = Utf8 ()V 
.const [136] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregatedWriters 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (I)V 
.const [139] = Utf8 de/esolutions/fw/util/transport/exception/InvalidTransportFormatException 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Ljava/lang/String;)V 
.const [142] = Utf8 de/esolutions/fw/util/transport/buffer/TransportBuffer 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (I)V 
.const [145] = Utf8 de/esolutions/fw/util/transport/CopyWriter 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/esolutions/fw/util/transport/IReadable;)V 
.const [148] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [149] = Utf8 transport 
.const [150] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [151] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [152] = Utf8 packetSize 
.const [153] = Utf8 I 
.const [154] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [155] = Utf8 maxMsgSize 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [158] = Utf8 maxLeftForSend 
.const [159] = Utf8 I 
.const [160] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [161] = Utf8 aggregate 
.const [162] = Utf8 Lde/esolutions/fw/util/transport/aggregate/AggregatedWriters; 
.const [163] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [164] = Utf8 send 
.const [165] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [166] = Utf8 de/esolutions/fw/util/transport/IWriter 
.const [167] = Utf8 size 
.const [168] = Utf8 ()I 
.const [169] = Utf8 de/esolutions/fw/util/transport/IWriter 
.const [170] = Utf8 write 
.const [171] = Utf8 (Lde/esolutions/fw/util/transport/IWriteable;)V 
.const [172] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [173] = Class [172] 
.const [174] = Utf8 java/lang/Object 
.const [175] = Class [174] 
.const [176] = Utf8 transport 
.const [177] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [178] = Utf8 packetSize 
.const [179] = Utf8 I 
.const [180] = Utf8 maxLeftForSend 
.const [181] = Utf8 I 
.const [182] = Utf8 aggregate 
.const [183] = Utf8 Lde/esolutions/fw/util/transport/aggregate/AggregatedWriters; 
.const [184] = Utf8 Code 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (Lde/esolutions/fw/util/transport/ITransport;)V 
.const [187] = Utf8 init 
.const [188] = Utf8 (I)V 
.const [189] = Utf8 getMaxMessageSize 
.const [190] = Utf8 ()I 
.const [191] = Utf8 sendPacket 
.const [192] = Utf8 ()V 
.const [193] = Utf8 putMessage 
.const [194] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [195] = Utf8 putMessageCopy 
.const [196] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [197] = Utf8 getNumPendingMessages 
.const [198] = Utf8 ()I 
.const [199] = Utf8 flushPacket 
.const [200] = Utf8 ()V 
.end class 
