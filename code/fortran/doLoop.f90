program doLoop
    implicit none
    integer i1, i2
    print *, 'wejscie do pętli do'
    do i1 = 0, 10, 1
        print *, 'DO', i1, 1, 'KOLUMNA ZYGMUNTA JUZ STOI'
    end do
    do i2 = 0, 5, 1
        print *, 'DO2', i1, i2
    end do
    print *, 'koniec pętli do :>. Ostatnia wartosc iteratora:', i1, i2
    if (i1.eq.9) then
        print *, 'jebac disa'
    else
        print *, 'nie jebac disa'
    end if
end
