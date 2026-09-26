.version 50 0 
.class public super [59] 
.super [61] 
.field private static final [62] [63] 

.method public [65] : [66] 
    .attribute [64] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     iload_2 
L4:     invokespecial [17] 
L7:     return 
L8:     
    .end code 
.end method 

.method protected final [67] : [68] 
    .attribute [64] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected final [69] : [70] 
    .attribute [64] .code stack 8 locals 2 
        .catch [7] from L0 to L39 using L40 
L0:     aload_1 
L1:     checkcast [3] 
L4:     invokevirtual [13] 
L7:     lstore 4 
L9:     aload_0 
L10:    invokevirtual [14] 
L13:    ldc [4] 
L15:    ldc [5] 
L17:    ldc [2] 
L19:    lload 4 
L21:    iload_3 
L22:    i2l 
L23:    invokevirtual [15] 
L26:    pop 
L27:    aload_2 
L28:    checkcast [6] 
L31:    lload 4 
L33:    invokeinterface [18] 0 
L38:    iconst_1 
L39:    areturn 
L40:    astore 4 
L42:    aload_0 
L43:    invokevirtual [14] 
L46:    ldc [8] 
L48:    ldc [9] 
L50:    ldc [2] 
L52:    aload 4 
L54:    invokevirtual [16] 
L57:    pop 
L58:    iconst_0 
L59:    areturn 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [19] 
.const [3] = Class [20] 
.const [4] = Int 1078071040 
.const [5] = String [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Int -1601830656 
.const [9] = String [24] 
.const [10] = Class [25] 
.const [11] = Class [26] 
.const [12] = Class [27] 
.const [13] = Method [28] [29] 
.const [14] = Method [30] [31] 
.const [15] = Method [32] [33] 
.const [16] = Method [34] [35] 
.const [17] = Method [36] [37] 
.const [18] = InterfaceMethod [38] [39] 
.const [19] = Utf8 MediaDSIPlayerRequestCoverArtUrlHandler 
.const [20] = Utf8 de/audi/app/media/dsi/media/requests/RequestParameterEntryID 
.const [21] = Utf8 "[%1.sendRequest] [%3] dsiMediaPlayer.requestCoverArt('%2')." 
.const [22] = Utf8 org/dsi/ifc/media/DSIMediaPlayer 
.const [23] = Utf8 java/lang/Exception 
.const [24] = Utf8 '[%1.sendRequest] Error on requesting detail informations: %2' 
.const [25] = Utf8 de/audi/app/media/dsi/media/requests/MediaDSIPlayerRequestCoverArtUrlHandler 
.const [26] = Utf8 de/audi/app/media/dsi/AbstractQueuedRequestHandler 
.const [27] = Utf8 de/audi/atip/log/LogChannel 
.const [28] = Class [40] 
.const [29] = NameAndType [41] [42] 
.const [30] = Class [43] 
.const [31] = NameAndType [44] [45] 
.const [32] = Class [46] 
.const [33] = NameAndType [47] [48] 
.const [34] = Class [49] 
.const [35] = NameAndType [50] [51] 
.const [36] = Class [52] 
.const [37] = NameAndType [53] [54] 
.const [38] = Class [55] 
.const [39] = NameAndType [56] [57] 
.const [40] = Utf8 de/audi/app/media/dsi/media/requests/RequestParameterEntryID 
.const [41] = Utf8 getEntryID 
.const [42] = Utf8 ()J 
.const [43] = Utf8 de/audi/app/media/dsi/media/requests/MediaDSIPlayerRequestCoverArtUrlHandler 
.const [44] = Utf8 getLogChannel 
.const [45] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 log 
.const [48] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [49] = Utf8 de/audi/atip/log/LogChannel 
.const [50] = Utf8 log 
.const [51] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [52] = Utf8 de/audi/app/media/dsi/AbstractQueuedRequestHandler 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (Lde/audi/atip/log/LogChannel;ZI)V 
.const [55] = Utf8 org/dsi/ifc/media/DSIMediaPlayer 
.const [56] = Utf8 requestCoverArt 
.const [57] = Utf8 (J)V 
.const [58] = Utf8 de/audi/app/media/dsi/media/requests/MediaDSIPlayerRequestCoverArtUrlHandler 
.const [59] = Class [58] 
.const [60] = Utf8 de/audi/app/media/dsi/AbstractQueuedRequestHandler 
.const [61] = Class [60] 
.const [62] = Utf8 LOGCLASS 
.const [63] = Utf8 Ljava/lang/String; 
.const [64] = Utf8 Code 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (Lde/audi/atip/log/LogChannel;I)V 
.const [67] = Utf8 getLogClass 
.const [68] = Utf8 ()Ljava/lang/String; 
.const [69] = Utf8 sendRequest 
.const [70] = Utf8 (Lde/audi/app/media/dsi/IRequestParameter;Lorg/dsi/ifc/base/DSIBase;I)Z 
.end class 
