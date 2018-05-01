package br.unb.cic.ed.ConcreteIterators

import br.unb.cic.ed.traits.Iterator
import br.unb.cic.ed.mutable.NodeList
import br.unb.cic.ed.mutable.LinkedList

/**
  * Uma implementação do tipo iterator baseado
  * em uma Lista encadeada e NodeList.
  * 
  * @author thaleslim
  */

class LinkedListIterable[T <% Comparable[T]](private val list: LinkedList[T]) extends Iterator[NodeList[T]]{

    private var cursor: NodeList[T] = null
    private var temp: NodeList[T] = cursor
    private var finished: Boolean = false

    def currentItem(): NodeList[T] = this.cursor

    def first() = { this.cursor = list.nodeAtPosition(0) }

    def currentValue() = this.cursor.value

    def previous(): Unit = {
        if( this.temp != null ) 
            this.cursor = this.temp
        else
            finished = true
    }

    def next(): Unit = {
        if( this.cursor != null && !this.isDone ){
            this.temp = this.cursor
            this.cursor = this.cursor.next
        }else
            finished = true
    }

    def isDone(): Boolean = this.finished
    
}