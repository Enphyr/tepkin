package net.fehmicansaglam.bson

import java.nio.ByteOrder

trait BsonValue extends Writable {
  implicit val byteOrder = ByteOrder.LITTLE_ENDIAN

  def pretty(level: Int = 0): String = toString
}
