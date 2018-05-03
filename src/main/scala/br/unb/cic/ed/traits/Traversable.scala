package br.unb.cic.ed.traits

/**
  * Uma especificação do tipo traversable usando
  * a construção trait da linguagem Scala. 
  * 
  * @author thaleslim
  */
//TODO: comentar && rever herança de Traversable <-> List
trait Traversable[NodeType, IterableType]/* extends List[NodeType] with Aggregate[IterableType]*/{
    def foreach[U](fun: NodeType => U): Unit
    
    def size(): Int = {
        /* HUGE WARNING:
            Muito cuidado ao usar essa função: Altamente volátil
         */
        var size = 0
        this.foreach[Int]{ x: NodeType => size += 1; size }
        return size
    }

    def map(fun: NodeType => NodeType): List[NodeType]
    def reduce[A](fun: (A,NodeType) => A)(start: A): A
    def filter(fun: NodeType => Boolean): List[NodeType]
}