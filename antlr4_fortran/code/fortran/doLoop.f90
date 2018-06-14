program doLoop
    implicit none
    integer i1, i2, i3
    print *, 'wejscie do pętli do'
    do i1 = 0, 10, 1
        print *, 'DO', i1, 1, 'KOLUMNA ZYGMUNTA JUZ STOI'
        do i2 = 0, 10, 1
            print *, 'DO_xD'
            do i3 = 0, 10, 1
                print *, 'DO_xD',i3, i3*2-10
            end do
        end do
    end do
end
