package services

import Utilities.dtos.DTOs.BookDTO
import com.google.inject.ImplementedBy
import services.impl.BooksServiceImpl

import scala.concurrent.Future

@ImplementedBy(classOf[BooksServiceImpl])
trait BooksService {

  def getBooks: Future[List[BookDTO]]

  def getBookById(id: Long): Future[Option[BookDTO]]

}
