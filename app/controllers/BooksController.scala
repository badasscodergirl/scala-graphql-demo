package controllers

//import Utilities.graphql.BooksSchema
import com.google.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.BooksService

import scala.concurrent.{ExecutionContext, Future}
import play.api.libs.json._
/*import sangria.ast.Document
import sangria.execution.{ErrorWithResolver, Executor, QueryAnalysisError}
import sangria.parser.{QueryParser, SyntaxError}

import scala.util.{Failure, Success}*/


@Singleton
class BooksController @Inject()(cc: ControllerComponents,
                                booksService: BooksService) extends AbstractController(cc) {

  implicit val ec = ExecutionContext.global

  def getAllBooks = Action.async { _ =>
    booksService.getBooks.map { result =>
      Ok(Json.toJson(result))
    }
  }

  /*def booksGraphQl = Action.async(parse.json) { request =>
    val query: String = (request.body \ "query").as[String]
    val operation = (request.body \ "operationName").asOpt[String]

    val variables = (request.body \ "variables").toOption.fold(Json.obj()) {
      case JsString(vars) ⇒ parseVariables(vars)
      case obj: JsObject ⇒ obj
      case _ ⇒ Json.obj()
    }

    def parseVariables(variables: String) =
      if (variables.trim == "" || variables.trim == "null") Json.obj() else Json.parse(variables).as[JsObject]

    QueryParser.parse(query) match {
      case Success(queryAst: Document) ⇒
        executeGraphQLQuery(queryAst, operation, variables)

      case Failure(error: SyntaxError) ⇒
        Future.successful(BadRequest(Json.obj("error" → error.getMessage)))
    }
  }*/

  //import sangria.marshalling.playJson._

  /*def executeGraphQLQuery(query: Document, op: Option[String], vars: JsObject) =
    Executor.execute(BooksSchema.schema, query, booksService, operationName = op, variables = vars)
      .map(Ok(_))
      .recover {
        case error: QueryAnalysisError ⇒ BadRequest(error.resolveError)
        case error: ErrorWithResolver ⇒ InternalServerError(error.resolveError)
      }*/

}
