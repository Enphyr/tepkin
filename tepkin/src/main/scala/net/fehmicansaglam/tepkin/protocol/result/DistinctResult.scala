package net.fehmicansaglam.tepkin.protocol.result

import net.fehmicansaglam.bson.Implicits.BsonValueArray
import net.fehmicansaglam.bson.{BsonDocument, BsonValueNumber, BsonValue}

case class DistinctResult(ok: Boolean,
                          values: Seq[BsonValue],
                          stats: BsonDocument) extends Result

object DistinctResult {
  def apply(document: BsonDocument): DistinctResult = {
    DistinctResult(
      ok = document.get[BsonValueNumber]("ok").get.toInt == 1,
      values = document.get[BsonValueArray]("values").get.identifier.elements.map(_.value),
      stats = document.getAs[BsonDocument]("stats").get)
  }
}
