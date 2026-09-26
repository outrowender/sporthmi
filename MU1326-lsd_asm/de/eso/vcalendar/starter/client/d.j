.version 50 0 
.class public super [61] 
.super [63] 

.method public annotation [65] : [66] 
    .attribute [64] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [14] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [67] : [68] 
    .attribute [64] .code stack 1 locals 1 
        .catch [8] from L0 to L11 using L14 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_2 
L6:     invokeinterface [16] 0 
L11:    goto L26 
L14:    astore_2 
L15:    aload_2 
L16:    invokevirtual [11] 
L19:    invokestatic [9] 
L22:    aload_2 
L23:    invokevirtual [12] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [64] .code stack 5 locals 2 
L0:     new [15] 
L3:     dup 
L4:     aload_1 
L5:     iload_2 
L6:     aload_3 
L7:     invokespecial [13] 
L10:    astore 4 
        .catch [6] from L12 to L19 using L22 
L12:    aload_0 
L13:    aload 4 
L15:    invokevirtual [10] 
L18:    pop 
L19:    goto L24 
L22:    astore 5 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Class [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Method [34] [35] 
.const [15] = Class [36] 
.const [16] = InterfaceMethod [37] [38] 
.const [17] = Utf8 de/eso/a/a/a 
.const [18] = Utf8 de/eso/a/d/b 
.const [19] = Utf8 de/eso/vcalendar/a/a/a 
.const [20] = Utf8 de/eso/vcalendar/starter/client/d 
.const [21] = Utf8 de/esolutions/fw/util/commons/queue/QueueShutdownException 
.const [22] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [23] = Utf8 java/lang/ClassCastException 
.const [24] = Class [39] 
.const [25] = NameAndType [40] [41] 
.const [26] = Class [42] 
.const [27] = NameAndType [43] [44] 
.const [28] = Class [45] 
.const [29] = NameAndType [46] [47] 
.const [30] = Class [48] 
.const [31] = NameAndType [49] [50] 
.const [32] = Class [51] 
.const [33] = NameAndType [52] [53] 
.const [34] = Class [54] 
.const [35] = NameAndType [55] [56] 
.const [36] = Utf8 de/eso/vcalendar/a/a/a 
.const [37] = Class [57] 
.const [38] = NameAndType [58] [59] 
.const [39] = Utf8 de/eso/a/d/b 
.const [40] = Utf8 d 
.const [41] = Utf8 (Ljava/lang/String;)V 
.const [42] = Utf8 de/eso/vcalendar/starter/client/d 
.const [43] = Utf8 addToQueue 
.const [44] = Utf8 (Ljava/lang/Object;)Z 
.const [45] = Utf8 java/lang/ClassCastException 
.const [46] = Utf8 getMessage 
.const [47] = Utf8 ()Ljava/lang/String; 
.const [48] = Utf8 java/lang/ClassCastException 
.const [49] = Utf8 printStackTrace 
.const [50] = Utf8 ()V 
.const [51] = Utf8 de/eso/vcalendar/a/a/a 
.const [52] = Utf8 <init> 
.const [53] = Utf8 (Ljava/io/File;ILde/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy;)V 
.const [54] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [55] = Utf8 <init> 
.const [56] = Utf8 (Ljava/lang/String;I)V 
.const [57] = Utf8 de/eso/a/a/a 
.const [58] = Utf8 a 
.const [59] = Utf8 ()V 
.const [60] = Utf8 de/eso/vcalendar/starter/client/d 
.const [61] = Class [60] 
.const [62] = Utf8 de/esolutions/fw/util/commons/queue/QueueWorker 
.const [63] = Class [62] 
.const [64] = Utf8 Code 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (Ljava/lang/String;I)V 
.const [67] = Utf8 handleQueuedObject 
.const [68] = Utf8 (Ljava/lang/Object;)V 
.const [69] = Utf8 a 
.const [70] = Utf8 (Ljava/io/File;ILde/esolutions/fw/comm/asi/calendar/db/provider/impl/VCalendarDbProviderProxy;)V 
.end class 
