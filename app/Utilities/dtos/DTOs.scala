package Utilities.dtos

import play.api.libs.json.{Json, OWrites}

object DTOs {

  case class BookRatingDTO(averageRating: Long, ratingCount: Long)

  object BookRatingDTO {
    implicit val bookRatingWrites: OWrites[BookRatingDTO] = Json.writes[BookRatingDTO]
  }

  case class BookDTO(title: String, authors: List[String], originalPublicationYear: Int, isbn: Long,
                     rating: Option[BookRatingDTO] )

  object BookDTO {
    implicit val bookDTO: OWrites[BookDTO] = Json.writes[BookDTO]
  }
}
