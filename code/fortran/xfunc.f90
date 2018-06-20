function f()
    integer f
    print *, 'INSIE FUNCTION'
    f = 666 + 12
end
program xfunc
    implicit none
    integer arg, fReturn
    integer func2
    arg = 3
    fReturn = f()
    print *, 'FUNCTION VALUE', arg, 'V: ', fReturn
end
