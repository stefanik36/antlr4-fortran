function ff(arg, arg2)
    integer ff, arg, arg2
    print *, 'INSIDE FUNCTION', arg2
    ff = 666 + arg
end
program xfunc
    implicit none
    integer arg, vv, abc, v3
    integer func2
    arg = 3
    abc = 222
    v3 = arg
    vv = ff(arg, abc)
    print *, 'FUNCTION VALUE', arg, 'V: ', vv
end
