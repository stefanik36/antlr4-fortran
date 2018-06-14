function ff(arg, arg2)
    integer ff, arg, arg2
    print *, 'INSIDE FUNCTION'
    ff = 666 + arg
end

program xfunc
    implicit none
    integer arg, vv, abc
    integer func2
    arg = 3
    abc = 222
    vv = ff(arg, abc)
    print *, 'FUNCTION VALUE', arg, 'V: ', vv
end

