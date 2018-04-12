 FUNCTION function01(b)
    REAL :: function01
    REAL :: b
    function01 = b*2
    RETURN
 END FUNCTION

 PROGRAM cows
    IMPLICIT NONE
    REAL :: function01
    PRINT *,function01(1.3)
 END PROGRAM