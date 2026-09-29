.version 50 0 
.class public super [57] 
.super [59] 

.method public annotation [61] : [62] 
    .attribute [60] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [63] : [64] 
    .attribute [60] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 17 
            L272 
            L275 
            L278 
            L281 
            L284 
            L287 
            L290 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L293 
            L296 
            L299 
            L302 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L305 
            L308 
            L311 
            L314 
            L317 
            L320 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L323 
            L326 
            L329 
            L332 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L338 
            L335 
            default : L338 

L272:   ldc [2] 
L274:   areturn 
L275:   ldc [3] 
L277:   areturn 
L278:   ldc [4] 
L280:   areturn 
L281:   ldc [5] 
L283:   areturn 
L284:   ldc [6] 
L286:   areturn 
L287:   ldc [7] 
L289:   areturn 
L290:   ldc [8] 
L292:   areturn 
L293:   ldc [9] 
L295:   areturn 
L296:   ldc [10] 
L298:   areturn 
L299:   ldc [11] 
L301:   areturn 
L302:   ldc [12] 
L304:   areturn 
L305:   ldc [13] 
L307:   areturn 
L308:   ldc [14] 
L310:   areturn 
L311:   ldc [15] 
L313:   areturn 
L314:   ldc [16] 
L316:   areturn 
L317:   ldc [17] 
L319:   areturn 
L320:   ldc [18] 
L322:   areturn 
L323:   ldc [19] 
L325:   areturn 
L326:   ldc [20] 
L328:   areturn 
L329:   ldc [21] 
L331:   areturn 
L332:   ldc [22] 
L334:   areturn 
L335:   ldc [23] 
L337:   areturn 
L338:   ldc [24] 
L340:   areturn 
L341:   nop 
L342:   nop 
L343:   nop 
L344:   
    .end code 
.end method 

.method public static [65] : [66] 
    .attribute [60] .code stack 2 locals 0 
L0:     iload_0 
L1:     ifle L14 
L4:     iload_0 
L5:     bipush 127 
L7:     if_icmpgt L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [27] 
.const [3] = String [28] 
.const [4] = String [29] 
.const [5] = String [30] 
.const [6] = String [31] 
.const [7] = String [32] 
.const [8] = String [33] 
.const [9] = String [34] 
.const [10] = String [35] 
.const [11] = String [36] 
.const [12] = String [37] 
.const [13] = String [38] 
.const [14] = String [39] 
.const [15] = String [40] 
.const [16] = String [41] 
.const [17] = String [42] 
.const [18] = String [43] 
.const [19] = String [44] 
.const [20] = String [45] 
.const [21] = String [46] 
.const [22] = String [47] 
.const [23] = String [48] 
.const [24] = String [49] 
.const [25] = Class [50] 
.const [26] = Method [51] [52] 
.const [27] = Utf8 'Transport medium not accessible' 
.const [28] = Utf8 'Received a sequence message without the start message' 
.const [29] = Utf8 'Received unexpected sequence number during segmentation' 
.const [30] = Utf8 'Time out occured while waiting for next segmented message' 
.const [31] = Utf8 "The received segmented message doesn't fit inside the receive buffer" 
.const [32] = Utf8 'Incorrect message length received' 
.const [33] = Utf8 'Overflow of receive buffer' 
.const [34] = Utf8 'Time out for occurred while waiting for the heartbeat message' 
.const [35] = Utf8 "Retry time-out occurred - all retry messages weren't successful" 
.const [36] = Utf8 'Request could not be processed because the retry timer is running' 
.const [37] = Utf8 'Request could not be send to vehicle bus and the number of retries is reached' 
.const [38] = Utf8 'The protocol version of function control unit (FSG) is not the same as the version of display control unit (ASG)' 
.const [39] = Utf8 'The data specification of function control unit (FSG) is not the same as of display control unit (ASG)' 
.const [40] = Utf8 'Either GetAll message corrupted, send buffers of FSG not initialized or BAP cache invalid' 
.const [41] = Utf8 'The BAP stack for given logical control unit is in a wrong state' 
.const [42] = Utf8 'There is no cache available for given logical control unit' 
.const [43] = Utf8 'One of the given parameters for given logical control unit is invalid' 
.const [44] = Utf8 'The data to send or to receive are out of range' 
.const [45] = Utf8 'Either the method is not implemented or is temporary not available' 
.const [46] = Utf8 'The given request or a received message is exceed the specified data length' 
.const [47] = Utf8 'The units between the function and display control unit are ambiguous' 
.const [48] = Utf8 'The method was successfully aborted by the function control unit (FSG)' 
.const [49] = Utf8 'Unknown BAP error error code received' 
.const [50] = Utf8 java/lang/Object 
.const [51] = Class [53] 
.const [52] = NameAndType [54] [55] 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 <init> 
.const [55] = Utf8 ()V 
.const [56] = Utf8 org/dsi/ifc/bap/util/BAPErrorCodes 
.const [57] = Class [56] 
.const [58] = Utf8 java/lang/Object 
.const [59] = Class [58] 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 stringFromErrorCode 
.const [64] = Utf8 (I)Ljava/lang/String; 
.const [65] = Utf8 isStandardizedErrorCode 
.const [66] = Utf8 (I)Z 
.end class 
