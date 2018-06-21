subroutine ff(arg, arg2)
    integer arg, arg2
    print *, 'INSIDE FUNCTION', arg, arg2
end
program xfunc
    implicit none
    print *, 'MAIN'
    call ff(1,2)
end
