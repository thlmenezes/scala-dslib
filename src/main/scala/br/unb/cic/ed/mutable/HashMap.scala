package br.unb.cic.ed.mutable

/**
  * Uma especifição do tipo Hash Map
  * usando a construção trait da linguagem 
  * Scala. 
  * 
  * @author thaleslim
  */

trait HashMap[A <: Comparable[A],B]{
    /** Altera a função default de hash */
    def apply(newHash: A => Int): Unit
    /** Busca por um valor no Hash Map baseado em uma chave */
    def apply(key: A): Option[B]
    /** Insere um valor no Hash Map vinculando-o a uma chave, usar operador -> ou uma Tupla */
    def apply(pair: Tuple2[A,B]): Unit
    /** Insere uma sequência de Tuplas no Hash Map */
    def apply(values: Tuple2[A,B]*): Unit
    /** Remove um valor do Hash Map */
    def - (key: A): Unit
    /** Remove uma sequência de valores do Hash Map */
    def - (keys: A*): Unit
}