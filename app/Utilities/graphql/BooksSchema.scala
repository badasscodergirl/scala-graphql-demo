/*
package Utilities.graphql

import Utilities.dtos.DTOs.{BookDTO, BookRatingDTO}
import sangria.schema._
import sangria.macros.derive._
import services.BooksService



object BooksSchema {

 implicit val RatingType = deriveObjectType[Unit, BookRatingDTO](
   ObjectTypeDescription("Book Rating"),
   DocumentField("rating", "Book Rating")
 )

  val BookType = ObjectType(
    "Book",
    "Book",
    fields[Unit, BookDTO] (
      Field("title", IntType, resolve = _.value.title),
      Field("authors", ListType(StringType), resolve = _.value.authors),
      Field("originalPublicationYear", IntType, resolve = _.value.originalPublicationYear),
      Field("isbn", LongType, resolve = _.value.isbn),
      Field("rating", OptionType(RatingType), resolve = _.value.rating)
    )
  )


  val Id = Argument("id", StringType)

  val BooksQueryType = ObjectType("Query", fields[BooksService, Unit] (
    Field("book", OptionType(BookType),
      description = Some("Returns book of specific id"),
      arguments = Id :: Nil,
      resolve = c ⇒ c.ctx.getBookById(c args Id)),

    Field("books", ListType(BookType),
      description = Some("Returns list of books"),
      resolve = c ⇒ c.ctx.getBooks)
  ))

  val schema = Schema(BooksQueryType)
}
*/
