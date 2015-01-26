package controllers

import models.{User, City, Country}
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {
  val form = Form(
    tuple(
      "email" -> text,
      "password" -> text
    )
  )

  def index = Action {
    val results = User.find
    Logger.debug(results.mkString("\n"))
    Ok(views.html.register.render(""))
  }

  def show = Action {
    val results = User.find
    Logger.debug(results.mkString("\n"))
    Ok(views.html.show.render(results))
  }

  def login = Action {
    Ok(views.html.login.render(""))
  }

  def submitlogin = Action { implicit request =>
    val (email, password) = form.bindFromRequest.get
    val test = User.login(email, password)
    val results = User.find
    //Logger.debug(test.toString())
    test match {
      case Some(theValue) => Ok(views.html.show.render(results))
      case None           => Ok(views.html.sorry.render())
    }



  }
}