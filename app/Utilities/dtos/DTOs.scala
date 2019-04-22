package Utilities.dtos

object DTOs {

  case class AuthorDTO(id: Long, name: String)
  case class BookRatingDTO(averageRating: Long, ratingCount: Long)
  case class BookDTO(id: Long, title: String, authors: List[AuthorDTO], originalPublicationYear: Int, isbn: Long,
                     rating: BookRatingDTO )
}
