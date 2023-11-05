data Tree a = Nil | Node (Tree a) a (Tree a) deriving (Eq, Ord, Show)

alt :: Tree a -> Int
alt Nil = 0
alt (Node hi r hd) = 1+max (alt hi) (alt hd)

mirror :: Tree a -> Tree a
mirror Nil = Nil
mirror (Node Nil r Nil) = (Node Nil r Nil)
mirror (Node hi r hd) = (Node (mirror hd) r (mirror hi))

buscar :: (Eq a, Ord a) => Tree a -> a -> Bool
buscar Nil x = False
buscar (Node hi r hd) x
        | r == x = True
        | r < x = buscar hd x
        | r > x = buscar hi x

insertar :: (Eq a, Ord a) => Tree a -> a -> Tree a
insertar Nil x = (Node Nil x Nil)
insertar (Node Nil r Nil) x
        | r == x = (Node Nil r Nil)
        | r < x = (Node Nil r (Node Nil x Nil))
        | r > x = (Node (Node Nil x Nil) r Nil)
insertar (Node hi r hd) x
        | r == x = (Node hi r hd)
        | r < x = (Node hi r (insertar hd x))
        | r > x = (Node (insertar hi x) r hd)

eliminar :: (Eq a, Ord a) => Tree a -> a -> Tree a
eliminar Nil x = error "Árbol vacio"
eliminar (Node Nil r Nil) x
        | r == x = Nil
        | r /= x = error "Elemento no encontrado"
eliminar (Node hi r Nil) x
        | r == x = hi
        | r < x = error "Elemento no encontrado"
        | r > x = (Node (eliminar hi x) r Nil)
eliminar (Node Nil r hd) x
        | r == x = hd
        | r < x = (Node hd r (eliminar hd x))
        | r > x = error "Elemento no encontrado"
eliminar (Node hi r hd) x
        | r == x = (Node hi (minElem hd) (eliminar hd (minElem hd)))
        | r < x = (Node hi r (eliminar hd x))
        | r > x = (Node (eliminar hi x) r hd)

minElem :: Tree a -> a
minElem Nil = error "Árbol vacio"
minElem (Node Nil x _) = x
minElem (Node hi x _) = minElem hi

maxElem :: Tree a -> a
maxElem Nil = error "Árbol vacio"
maxElem (Node _ x Nil) = x
maxElem (Node _ x hd) = maxElem hd

preorden :: Tree a -> [a]
preorden Nil = []
preorden (Node hi r hd) = [r] ++ (preorden hi) ++ (preorden hd)

inorden :: Tree a -> [a]
inorden Nil = []
inorden (Node hi r hd) = (preorden hi) ++ [r] ++ (preorden hd)

posorden :: Tree a -> [a]
posorden Nil = []
posorden (Node hi r hd) = (preorden hi) ++ (preorden hd) ++ [r]

hojas :: Tree a -> Int
hojas Nil = 0
hojas (Node Nil r Nil) = 1
hojas (Node hi r hd) = hojas hi + hojas hd

nodos :: Tree a -> Int
nodos Nil = 0
nodos (Node hi r hd) = 1 + nodos hi + nodos hd

full :: Tree a -> Bool
full Nil = False
full (Node Nil r Nil) = True
full (Node hi r Nil) = False
full (Node Nil r hd) = False
full (Node hd r hi) = full hi && full hd

verificarABB :: (Eq a, Ord a) => Tree a -> Bool
verificarABB Nil = True
verificarABB (Node Nil r Nil) = True
verificarABB (Node Nil r hd)
        | hd < (Node Nil r Nil) = False
        | otherwise = verificarABB hd
verificarABB (Node hi r Nil)
        | hi > (Node Nil r Nil) = False
        | otherwise = verificarABB hi
verificarABB (Node hi r hd)
        | hi > (Node Nil r Nil) = False
        | hd < (Node Nil r Nil) = False
        | hi == (Node Nil r Nil) || hd == (Node Nil r Nil) = error "Elementos repetidos"
        | otherwise = verificarABB hi && verificarABB hd