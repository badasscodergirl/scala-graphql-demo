package services.models

import slick.lifted.{ProvenShape, Tag}
import slick.jdbc.PostgresProfile.api._

//id	book_id	best_book_id	books_count	isbn	isbn13	authors	original_publication_year original_title	title	language_code	image_url	small_image_url
case class Book(id: Long, bookId: Long, title: String, originalTitle: String, languageCode: String,
                bestBookId: Option[Long], booksCount: Long, isbn: Long, isbn13: Long, originalPublicationYear: Int,
                imageUrl: Option[String], smallImageUrl: Option[String])

class Books(tag: Tag) extends Table[Book](tag, _tableName = "books") {

  def id : Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def bookId: Rep[Long] = column[Long]("book_id", O.Unique)
  def title: Rep[String] = column[String]("title")
  def originalTitle: Rep[String] = column[String]("original_title")
  def languageCode: Rep[String] = column[String]("language_code")

  def bestBookId: Rep[Option[Long]] = column[Option[Long]]("best_book_id")
  def booksCount: Rep[Long] = column[Long]("books_count")
  def isbn: Rep[Long] = column[Long]("isbn")
  def isbn13: Rep[Long] = column[Long]("isbn13")
  def originalPublicationYear: Rep[Int] = column[Int]("original_publication_year")

  def imageUrl: Rep[Option[String]] = column[Option[String]]("image_url")
  def smallImageUrl: Rep[Option[String]] = column[Option[String]]("small_image_url")

  override def * : ProvenShape[Book] = (id, bookId, title, originalTitle, languageCode, bestBookId, booksCount,
  isbn, isbn13, originalPublicationYear, imageUrl, smallImageUrl) <> (Book.tupled, Book.unapply)
}

object Books {
  lazy val query = TableQuery[Books]
}
