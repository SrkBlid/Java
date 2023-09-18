--ALGEBRA ABSTRACTA
module StackADT where

-- s = cualquier tipo
class Stack s where 
    -- | empty Stack
    empty :: s a -> s a
    -- | push an element into the Stack
    push :: s a -> a -> s a
    -- | popea un elemento fuera del stack
    pop :: s a -> s a
    -- | comprueba que la lista sea vacia
    esVacia :: s a -> Bool
    -- | devuelve el primer elemento de la lista
    top :: s a -> a