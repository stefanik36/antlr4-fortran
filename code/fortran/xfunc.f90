function ff()
    integer ff
    print *, 'INSIE FUNCTION'
    ff = 666
end
program xfunc
    implicit none
    integer arg, vv, abc
    integer func2
    arg = 3
    abc = 222
    vv = ff()
    print *, 'FUNCTION VALUE', arg, 'V: ', vv
end
