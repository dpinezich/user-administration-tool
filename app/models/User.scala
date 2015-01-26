package models
// Importing the slick driver
import models.database.{Users, Cities, Countries}
import play.api.Logger
import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.DB
import scala.slick.session.Session

// The case class to represent the data object
case class User(id: Option[Int] = None, username: String, name: String, firstname: String, email: String, password: String, city_id: Int, country_id: Int, role_id: Int)


object User {

  val table = new Users

  def find: List[(Int, String, String, String, String, String, Int, Int, Int)] = DB.withSession { implicit session: Session =>
    Query(table).list
  }

  def findNames: List[String] = DB.withSession { implicit session: Session =>
    Query(table).map(_.name).list
  }

  def login (email:String, password:String) = DB.withSession { implicit session: Session =>
    Query(table).where(_.email === email).where(_.password === password).firstOption
  }

  def findSortedByRank: List[(Int, String, String, String, String, String, Int, Int, Int)] = DB.withSession { implicit session: Session =>
    Query(table).sortBy(_.role_id).list
  }

}
