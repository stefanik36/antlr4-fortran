function ff(arg, arg2)
    integer ff, arg, arg2
    print *, 'INSIDE FUNCTION'
    ff = arg + arg2
end
program xfunc
    implicit none
    integer arg, vv
    arg = 3
    vv = ff(1,arg)
    print *, 'FUNCTION VALUE', arg, 'V: ', vv
end
