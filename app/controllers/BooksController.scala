package controllers

import com.google.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.BooksService

import scala.concurrent.ExecutionContext


@Singleton
class BooksController @Inject()(cc: ControllerComponents,
                                booksService: BooksService) extends AbstractController(cc) {

  implicit val ec = ExecutionContext.global

  def getAllBooks = Action.async { _ =>
    booksService.getBooks.map { result =>
      Ok(result.toString())
    }
  }

}
